package cn.ldm.service;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Role;

public interface RoleService {

	void add(String roleIds, Role t);

	void roleList(PageBean pageBean);

	List<Role> roleAll();
	
}
