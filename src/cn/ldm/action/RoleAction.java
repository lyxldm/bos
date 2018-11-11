package cn.ldm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Role;
import cn.ldm.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	private String roleIds;
	
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@Autowired
	private RoleService rs;
	
	public void add(){
		rs.add(roleIds,t);
	}
	
	public void roleList(){
		rs.roleList(pageBean);
		getObjectToJson(pageBean, new String[]{"functions","users","size","page"});
	}
	
	public void roleAll(){
		List<Role> list = rs.roleAll();
		getArrayToJson(list,new String[]{"functions","users"});
	}
}
