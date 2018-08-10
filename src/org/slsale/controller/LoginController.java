package org.slsale.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.RedisAPI;
import org.slsale.pojo.Authority;
import org.slsale.pojo.Function;
import org.slsale.pojo.Menu;
import org.slsale.pojo.User;
import org.slsale.service.function.FunctionService;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private FunctionService functionService;
	
	@Resource
	private RedisAPI redisAPI;
	
	@RequestMapping("/main.html")
	public ModelAndView main(HttpSession session){
		logger.debug("main======================== " );
		//menu list
		User user = this.getCurrentUser();
		List<Menu> mList = null;
		if(null != user){
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user", user);
			/**
			 * key:menuList+roleID---eg:"menuList2"
			 * value:mList
			 */
			//redis里有没有数据
			if(!redisAPI.exist("menuList"+user.getRoleId())){//redis没数据
				//根据当前用户获取菜单列表mList
				mList = getFuncByCurrentUser(user.getRoleId());
				//json格式转换为string类型
				if(null != mList){
					JSONArray jsonArray = JSONArray.fromObject(mList);
					String jsonString = jsonArray.toString();
					logger.debug("jsonString : " + jsonString);
					model.put("mList", jsonString);
					redisAPI.set("menuList"+user.getRoleId(), jsonString);
				}
			}else{// redis里有数据,直接从redis里取数据
				String redisMenuListKeyString = redisAPI.get("menuList"+user.getRoleId());
				logger.debug("menuList from redis: " + redisMenuListKeyString);
				if(null != redisMenuListKeyString && !"".equals(redisMenuListKeyString)){
					model.put("mList", redisMenuListKeyString);
				}else {
					return new ModelAndView("redirect:/");
				}
			}
			session.setAttribute(Constants.SESSION_BASE_MODEL, model);
			return new ModelAndView("main",model);
		}
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * 根据当前用户角色id获取功能列表（对应的菜单）
	 * @param roleId
	 * @return
	 */
	protected List<Menu> getFuncByCurrentUser(int roleId){
		List<Menu> menuList = new ArrayList<Menu>();
		Authority authority = new Authority();
		authority.setRoleId(roleId);
		
		try {
			List<Function> mList = functionService.getMainFunctionList(authority);
			if(mList != null){
				for(Function function:mList){
					Menu menu = new Menu();
					menu.setMainMenu(function);
					function.setRoleId(roleId);//给roleId赋值
					//主菜单对应的子菜单列表
					List<Function> subList = functionService.getSubFunctionList(function);
					if(null != subList){
						menu.setSubMenus(subList);
					}
					menuList.add(menu);
				}
			}
		} catch (Exception e) {
		}
		return menuList;
	}
	
	@RequestMapping("/login.html")
	@ResponseBody	//应用于ajax异步返回   返回的是对象
	//	@RequestParam是传递参数的.接受前台传递过来ajax转变为String格式的内容
	public Object login(HttpSession session,@RequestParam String user){
		logger.debug("login===================");
		if(user == null || "".equals(user)){
			return "nodata";
		}else{
			System.out.println("neirong:"+user);
			
			JSONObject userObject = JSONObject.fromObject(user);
			User userObj= (User)userObject.toBean(userObject, User.class);
			System.out.println("账号:"+userObj.getLoginCode()+"密码:"+userObj.getPassword());
			try {
				System.out.println("判断userService");
				System.out.println("判断账号:"+userService.loginCodeIsExit(userObj));
				
				if(userService.loginCodeIsExit(userObj) == 0){//不存在这个登录账号
					System.out.println("不存在这个账号");
					return "nologincode";
				}else{
					User _user = userService.getLoginUser(userObj);
					if(null != _user){//登录成功
						//当前用户存到session中
						session.setAttribute(Constants.SESSION_USER, _user);
						//更新当前用户登录的lastLoginTime
						User updateLoginTimeUser = new User();
						updateLoginTimeUser.setId(_user.getId());
						updateLoginTimeUser.setLastLoginTime(new Date());
						userService.modifyUser(updateLoginTimeUser);
						updateLoginTimeUser = null;
						return "success";
					}else{//密码错误
						return "pwderror";
					}
				}
			} catch (Exception e) {
				return "failed";
			}
			
			
		}
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.html")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.SESSION_USER);
		session.invalidate();//让session失效
		this.setCurrentUser(null);
		return "index";
	}
	
}
