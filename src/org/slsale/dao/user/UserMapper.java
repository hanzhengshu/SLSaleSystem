package org.slsale.dao.user;

import org.slsale.pojo.User;

public interface UserMapper {
	/**
	 * getLoginUser  获取的登陆用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user)throws Exception;
	
	/**
	 * loginCodeIsExit  登陆账号是否存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int loginCodeIsExit(User user)throws Exception;
	/**
	 * modifyUser  更新当前用户登陆(时间...)
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modifyUser(User user)throws Exception;
}
