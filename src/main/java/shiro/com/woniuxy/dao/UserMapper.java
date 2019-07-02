package shiro.com.woniuxy.dao;

import shiro.com.woniuxy.entity.User;

public interface UserMapper {
User findOneByCount(String count);
}
