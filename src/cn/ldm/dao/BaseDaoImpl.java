package cn.ldm.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Conditional;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Staff;
import cn.ldm.bean.User;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class class1;
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType pType =(ParameterizedType) getClass().getGenericSuperclass();
		class1 = (Class) pType.getActualTypeArguments()[0];	
	}
	
	//resource 既可以根据名字注入，也可以更具类型注入	 使用注解开发
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(class1, id);
	}

	@Override
	public List findPageList(DetachedCriteria dc,int start, int size) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByCriteria(dc, start, size);
	}
	@Override
	public List findList(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByCriteria(dc);
	}
	@Override
	public List<T> find(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return  (List<T>) this.getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public User loginUser(final User user) {
		return this.getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from User where user_name = "+user.getUser_name()+" and user_pwd = "+user.getUser_pwd();
				System.out.println(hql);
				Query query = session.createQuery(hql);
				if((User) query.uniqueResult()!=null){
					return (User) query.uniqueResult();
				}
				return null;
			}
		});
	}

	@Override
	public void staffUpdate(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		List<T> list = find(dc);
		T t = list.get(0);
	}

}
