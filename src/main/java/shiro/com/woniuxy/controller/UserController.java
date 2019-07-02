package shiro.com.woniuxy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shiro.com.woniuxy.entity.User;
import shiro.com.woniuxy.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@RequestMapping("/login")
	public String login(User u) {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token=new UsernamePasswordToken(u.getUserName(),u.getPassword()); 
		try {
			subject.login(token);
			boolean f=subject.isAuthenticated();
			System.out.println(subject);
			System.out.println("认证"+f+"通过");
		} catch (Exception e) {
			System.out.println("账号密码错误");
		}	
		
		
		
		return null;
	}
	
}
