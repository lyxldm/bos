package cn.ldm.bean;

import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable{
	private Integer id;
	private String user_name;
	private String user_pwd;
	private String user_phone;
	private Set noticebills = new HashSet(0);
	private Set<Role> roles = new HashSet(0);
	
	public Set getNoticebills() {
		return noticebills;
	}
	public void setNoticebills(Set noticebills) {
		this.noticebills = noticebills;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_phone=" + user_phone
				+ "]";
	}
	
}
