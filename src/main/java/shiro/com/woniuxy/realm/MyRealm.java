package shiro.com.woniuxy.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiro.com.woniuxy.entity.User;
import shiro.com.woniuxy.service.IUserService;

@Service
@Transactional
public class MyRealm extends AuthorizingRealm{

	@Autowired
	private IUserService service;
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String lname = (String) token.getPrincipal();
		User u = service.getByCount(lname);
		SimpleAuthenticationInfo sa=new SimpleAuthenticationInfo(u.getUserName(),u.getPassword(),lname);
		System.out.println(sa);
		return sa;
		
	}

}
