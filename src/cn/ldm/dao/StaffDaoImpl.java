package cn.ldm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Staff;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao{

	@Override
	public void save(Staff t) {
		// TODO Auto-generated method stub
		System.out.println(t);
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void list(PageBean pageBean) {
		// TODO Auto-generated method stub
		int start = (pageBean.getPage()-1)*pageBean.getSize();
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		dc.setProjection(Projections.rowCount());
		List<Long> total = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		pageBean.setTotal(total.get(0).intValue());
		
		dc.setProjection(null);
		List<Staff> findPageList = findPageList(dc, start, pageBean.getSize());
		pageBean.setRows(findPageList);
	}

	@Override
	public void deleteBatch(String i) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		dc.add(Restrictions.eq("id", i));
		List<Staff> list = (List<Staff>) find(dc);
		Staff staff = list.get(0);
		staff.setDeltag("1");
		update(staff);
	}

	@Override
	public void staffUpdate(Staff t) {
		// TODO Auto-generated method stub
		update(t);
	}

	@Override
	public Staff findStaffById(String id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	@Override
	public List<Staff> listAjax() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		List<Staff> find = find(dc);
		return find;
	}

}
