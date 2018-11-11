package cn.ldm.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;
import cn.ldm.bean.Role;
import cn.ldm.bean.Staff;
import cn.ldm.bean.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User login(User t) {
		// TODO Auto-generated method stub
		return loginUser(t);
	}

	@Override
	public void editPassword(User t) {
		// TODO Auto-generated method stub
		/*DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", t.getId()));
		List<User> list = find(dc);
		User user = list.get(0);
		user.setUser_pwd(t.getUser_pwd());
		System.out.println(user);
		update(user);*/
		User user = findById(t.getId());
		user.setUser_pwd(t.getUser_pwd());
		update(user);
	}

	@Override
	public User loginById(String username) {
		// TODO Auto-generated method stub
		String sql = "from User where user_name = ?";
 		List<User> find = (List<User>) getHibernateTemplate().find(sql, username);
		User user = new User();
		user = find.get(0);
 		return user;
	}

	@Override
	public void add(String[] ids,User t) {
		// TODO Auto-generated method stub
		save(t);
		for(int i=0;i<ids.length;i++){
			Role role = new Role();
			role.setId(ids[i]);
			t.getRoles().add(role);
		}
	}

	@Override
	public void list(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		int start = (pageBean.getPage()-1)*pageBean.getSize();
		List<Function> findPageList = findPageList(dCriteria, start, pageBean.getSize());
		pageBean.setRows(findPageList);
	}

	public void total(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.setProjection(Projections.rowCount());
		List<Long> findByCriteria = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		int total = findByCriteria.get(0).intValue();
		pageBean.setTotal(total);
		
	}
}
