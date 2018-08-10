package org.slsale.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.slsale.pojo.User;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController extends BaseController {
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/backend/modifyPwd.html")
	@ResponseBody
	public Object modifyPwd(@RequestParam String userJson){
		logger.debug("modifyPwd ================ ");
		User sessionUser = this.getCurrentUser();
		if(userJson == null || userJson.equals("")){
			return "nodata";
		}else{
			JSONObject userObject = JSONObject.fromObject(userJson);
			User user = (User)JSONObject.toBean(userObject,User.class);
			user.setId(sessionUser.getId());
			user.setLoginCode(sessionUser.getLoginCode());
			try {
				if(userService.getLoginUser(user)!=null){
					user.setPassword(user.getPassword2()); //user.getPassword2()中间变量 charisma.js中的中间变量
					user.setPassword2(null);	//这个为数据库中的Password2(支付密码设为空的时候UserMapperSQL语句 modifyUser方法中默认为不作为)
					userService.modifyUser(user);
				}else{
					return "oldpwdwrong";
				}
			} catch (Exception e) {
				// TODO: handle exception
				return "failed";
			}
		}
		return "success";
	}
}
