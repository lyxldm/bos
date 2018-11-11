package cn.ldm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Decidedzone;
@Repository
public class DecidedDaoImpl extends BaseDaoImpl<Decidedzone> implements DecidedDao{

	@Override
	public List<Decidedzone> list() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Decidedzone.class);
		return find(dc);
	}

	@Override
	public Decidedzone findById(String id) {
		// TODO Auto-generated method stub
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Decidedzone.class);
		dCriteria.add(Restrictions.eq("id", id));
		List<Decidedzone> find = find(dCriteria);
		Decidedzone decidedzone = find.get(0);
		System.out.println(1);
		return decidedzone;
	}

}
