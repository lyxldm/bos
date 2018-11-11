package cn.ldm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.ldm.bean.User;

public interface BaseDao<T> {
	void save(T t);
	void delete(T t);
	void update(T t);
	T findById(Serializable id);
	List findList(DetachedCriteria dc);
	List findPageList(DetachedCriteria dc,int start, int size);
	List<T> find(DetachedCriteria dc);
	User loginUser(User user);
	void staffUpdate(DetachedCriteria dc);
}
