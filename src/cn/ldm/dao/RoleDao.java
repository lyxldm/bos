package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Role;

public interface RoleDao {

	void add(String roleIds, Role t);

	
	void total(PageBean pageBean);

	void roleList(PageBean pageBean);


	List<Role> roleAll();
	
}
