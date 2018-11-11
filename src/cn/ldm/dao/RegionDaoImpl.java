package cn.ldm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Region;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao{

	@Override
	public void save(Region region) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(region);
	}

	public List<Region> list() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Region.class);
		List<Region> findList = findList(dc);
		return findList;
	}

	@Override
	public List<Region> likeList(String q) {
		// TODO Auto-generated method stub
		String hql = "from Region r where r.province like ? or  r.city like ? or r.district like ? ";
		List<Region> find = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%", "%"+q+"%", "%"+q+"%");
		return find;
	}

}
