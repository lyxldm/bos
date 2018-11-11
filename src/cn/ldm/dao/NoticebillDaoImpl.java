package cn.ldm.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Noticebill;
import cn.ldm.crm.Customer;
@Repository
public class NoticebillDaoImpl extends BaseDaoImpl<Noticebill> implements NoticebillDao {

	public void add(Noticebill t) {
		// TODO Auto-generated method stub
		save(t);
	}

	
}
