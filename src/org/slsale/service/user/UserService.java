package org.slsale.service.user;

import org.slsale.pojo.User;

public interface UserService {
	/**
	 * getLoginUser
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user)throws Exception;
	
	/**
	 * loginCodeIsExit
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int loginCodeIsExit(User user)throws Exception;
	
	/**
	 * modifyUser
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modifyUser(User user)throws Exception;
}
