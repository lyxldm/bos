package cn.ldm.service;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Role;
import cn.ldm.dao.RoleDao;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao rd;

	@Override
	public void add(String roleIds, Role t) {
		// TODO Auto-generated method stub
		rd.add(roleIds,t);
	}

	@Override
	public void roleList(PageBean pageBean) {
		
		// TODO Auto-generated method stub
		rd.total(pageBean);
		rd.roleList(pageBean);
	}

	public List<Role> roleAll() {
		// TODO Auto-generated method stub
		return rd.roleAll();
	}
	
	

}
