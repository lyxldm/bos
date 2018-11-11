package cn.ldm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Subarea;
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements SubareaDao{

	public void pageList(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dcCriteria = DetachedCriteria.forClass(Subarea.class);
		dcCriteria.setProjection(Projections.rowCount());
		List<Long> list1 = (List<Long>) this.getHibernateTemplate().findByCriteria(dcCriteria);
		int total = list1.get(0).intValue();
		pageBean.setTotal(total);
		
		dcCriteria.setProjection(null);
		List findPageList = findPageList(dcCriteria, (pageBean.getPage()-1)*pageBean.getSize(), pageBean.getSize());
		pageBean.setRows(findPageList);
	}

	@Override
	public void add(Subarea t) {
		// TODO Auto-generated method stub
		System.out.println(t);
		System.out.println(1);
		save(t);
	}

	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Subarea s";
		return (List<Subarea>) this.getHibernateTemplate().find(hql);
	}

	public List<Subarea> decidedzone() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		dc.add(Restrictions.isNull("decidedzone"));
		return find(dc);
	}


}
