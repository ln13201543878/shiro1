package shiro.com.woniuxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiro.com.woniuxy.dao.UserMapper;
import shiro.com.woniuxy.entity.User;
import shiro.com.woniuxy.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper um;
	
	@Override
	public User getByCount(String count) {
		
		User user = um.findOneByCount(count);
		return user;
	}

}
