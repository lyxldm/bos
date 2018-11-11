package cn.ldm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {

	@Override
	public List<Function> listajax() {
		// TODO Auto-generated method stub
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Function.class);
		dCriteria.add(Restrictions.eq("generatemenu", "1"));
		List<Function> find = find(dCriteria);
		return find;
	}
	public void add(Function t) {
		// TODO Auto-generated method stub
		save(t);
	}
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Function.class);
		int start = (pageBean.getPage()-1)*pageBean.getSize();
		List<Function> findPageList = findPageList(dCriteria, start, pageBean.getSize());
		pageBean.setRows(findPageList);
	}
	@Override
	public int total() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Function.class);
		dc.setProjection(Projections.rowCount());
		List<Long> findByCriteria = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return findByCriteria.get(0).intValue();
	}

	@Override
	public List<Function> findFunction(Integer id) {
		// TODO Auto-generated method stub
		String hql = "select distinct f from Function f left join f.roles r left join r.users u where u.id = ?";
		List<Function> find = (List<Function>) this.getHibernateTemplate().find(hql, id);
		
		return find;
	}
	public List<Function> findMean(Integer id) {
		// TODO Auto-generated method stub
		String hql = "select distinct f from Function f left join f.roles r left join r.users u where u.id = ? and f.generatemenu = '1' ";
		List<Function> find = (List<Function>) this.getHibernateTemplate().find(hql, id);
		return find;
	}
}
