package cn.ldm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.User;
public interface UserDao extends BaseDao<User>{
	User login(User t);

	void editPassword(User t);
	
	User loginById(String username);

	void add(String[] ids,User t);

	void list(PageBean pageBean);

	void total(PageBean pageBean);


}
