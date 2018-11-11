package cn.ldm.shiroRealm;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ldm.bean.Function;
import cn.ldm.bean.User;
import cn.ldm.dao.FunctionDao;
import cn.ldm.dao.UserDao;
import cn.ldm.service.UserService;

public class shiroRealm extends AuthorizingRealm{
	@Autowired
	private UserDao userDao;
	@Autowired
	private FunctionDao fd;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println(1);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<Function> list = fd.findFunction(user.getId());
		for(int i =0;i<list.size();i++){
			authorizationInfo.addStringPermission(list.get(i).getCode());
		}
		return authorizationInfo;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String username = uToken.getUsername();
		User loginById = userDao.loginById(username);
		if(loginById != null){
			//简单认证信息对象
			AuthenticationInfo aInfo = new SimpleAuthenticationInfo(loginById, loginById.getUser_pwd(),this.getName());
			//框架负责比对数据库中的密码和页面输入的密码是否一致
			return aInfo;
		}
		return null;
	}

}
