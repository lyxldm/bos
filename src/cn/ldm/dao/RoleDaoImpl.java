package cn.ldm.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;
import cn.ldm.bean.Role;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public void add(String roleIds, Role t) {
		// TODO Auto-generated method stub
		save(t);
		
		if(StringUtils.isNotBlank("roleIds")){
			String[] ids = roleIds.split(",");
			for (String string : ids) {
				Function function = new Function();
				function.setId(string);
				t.getFunctions().add(function);
			}
		}
		
	}

	@Override
	public void roleList(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Role.class);
		int start = (pageBean.getPage()-1)*pageBean.getSize();
		List<Function> findPageList = findPageList(dCriteria, start, pageBean.getSize());
		pageBean.setRows(findPageList);
	}

	@Override
	public void total(PageBean pageBean) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
		dc.setProjection(Projections.rowCount());
		List<Long> findByCriteria = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		int total = findByCriteria.get(0).intValue();
		pageBean.setTotal(total);
	}

	@Override
	public List<Role> roleAll() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
		List<Role> find = find(dc);
		return find;
	}

	

}
