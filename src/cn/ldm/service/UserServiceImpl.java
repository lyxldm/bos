package cn.ldm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.User;
import cn.ldm.dao.UserDao;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User login(User t) {
		// TODO Auto-generated method stub
		return userDao.login(t);
	}
	@Override
	public void editPassword(User t) {
		// TODO Auto-generated method stub
		userDao.editPassword(t);
	}
	public void add(String[] ids,User t) {
		// TODO Auto-generated method stub
		userDao.add(ids,t);
	}
	public void list(PageBean pageBean) {
		// TODO Auto-generated method stub
		userDao.list(pageBean);
		userDao.total(pageBean);
	}
}
