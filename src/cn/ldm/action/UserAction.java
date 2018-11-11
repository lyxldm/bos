package cn.ldm.action;

import java.io.File;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionContext;

import cn.ldm.bean.User;
import cn.ldm.crm.Customer;
import cn.ldm.exception.Exception01;
import cn.ldm.quartz.jobs01;
import cn.ldm.service.UserService;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Autowired
	private UserService userService;
	
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	public String login() throws Exception01{
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//if(StringUtils.isNotBlank(checkcode) && key.equals(checkcode)){
		//使用shiro框架提供的方式进行认证操作
		//获得当前用户对象,状态为“未认证”
		Subject subject = SecurityUtils.getSubject();
		//创建用户名密码令牌对象
		AuthenticationToken token = new UsernamePasswordToken(t.getUser_name(),t.getUser_pwd());
		try {
			subject.login(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletActionContext.getContext().put("error02", "用户名或者密码错误!");			
			return "toLogin";
		}
		User user = (User) subject.getPrincipal();
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "toMenu";
		/*User user = userService.login(t);
			if(user!=null){
				ActionContext.getContext().getSession().put("user", user);
				return "toMenu";
			}else{
				ActionContext.getContext().put("error02", "用户名或者密码错误!");
				return "toLogin";
			}*/
		/*}else{
				ActionContext.getContext().put("error01", "验证码错误!");
				return "toLogin";
		}*/
	}
	
	public String leave(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "toLogin";
	}
	public void editPassword(){
		userService.editPassword(t);
	}
	
	private String[] ids;
	
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public void add(){
		userService.add(ids,t);
	}
	
	public void list(){
		userService.list(pageBean);
		getObjectToJson(pageBean, null);
	}
	private File myfile;
	
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String text(){
		System.out.println(myfile);
		return NONE;
	}
}
