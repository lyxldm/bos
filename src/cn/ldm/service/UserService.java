package cn.ldm.service;

import org.springframework.stereotype.Service;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.User;

public interface UserService {
	User login(User t);

	void editPassword(User t);

	void add(String[] ids,User t);

	void list(PageBean pageBean);



}
