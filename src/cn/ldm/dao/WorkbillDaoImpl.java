package cn.ldm.dao;

import org.springframework.stereotype.Repository;

import cn.ldm.bean.Workbill;
import cn.ldm.service.WorkbillDao;
@Repository
public class WorkbillDaoImpl extends BaseDaoImpl<Workbill> implements WorkbillDao{

	@Override
	public void save(Workbill t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}
}
