package cn.ldm.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Staff;
import cn.ldm.service.StaffService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{
	@Autowired
	private StaffService staffService;
	
	public String save(){
		System.out.println(t);
		return null;
	}
	
	public void list() throws IOException{
		staffService.list(pageBean);
		getObjectToJson(pageBean, new String[]{"page","size","decidedzones"});
	}
	
	private String ids;
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void deleteBatch(){
		staffService.deleteBatch(ids);
	}
	
	public String staffUpdate(){
		Staff staff = staffService.findStaffById(t.getId());
		//staffService.staffUpdate(t);
		staff.setName(t.getName());
		staff.setTelephone(t.getTelephone());
		staff.setHaspda(t.getHaspda());
		staff.setStandard(t.getStandard());
		staff.setStation(t.getStation());
		System.out.println(staff);
		staffService.staffUpdate(staff);
		return "toMenu";
	}
	
	public void listAjax(){
		List<Staff> listAjax = staffService.listAjax();
		getArrayToJson(listAjax, new String[]{"decidedzones"});
	}
}
