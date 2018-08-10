package org.slsale.service.user;

import javax.annotation.Resource;

import org.slsale.dao.user.UserMapper;
import org.slsale.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getLoginUser(User user) throws Exception {
		return userMapper.getLoginUser(user);
	}

	@Override
	public int loginCodeIsExit(User user) throws Exception {
		return userMapper.loginCodeIsExit(user);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		return userMapper.modifyUser(user);
	}

}
