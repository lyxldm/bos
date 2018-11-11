package cn.ldm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.ldm.crm.Customer;
import cn.ldm.crm.CustomerService;

@Controller
public class CrmAction extends BaseAction<Customer>{
	@Autowired
	private CustomerService cs;
	
	private String idd;
	
	
	public String getIdd() {
		return idd;
	}
	public void setIdd(String idd) {
		this.idd = idd;
	}
	public void noassociationSelect(){
		List<Customer> list = cs.customerService();
		getArrayToJson(list, null);
	}
	public void associationSelect(){
		List<Customer> list1 = cs.associationSelect(idd);
		getArrayToJson(list1, null);
	}
	
	/**
	 * 更改定区所绑定的客户
	 */
	
	private List customerIds;
	private String selectedId;
	
	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
	
	public void setCustomerIds(List customerIds) {
		this.customerIds = customerIds;
	}
	public void assigncustomerstodecidedzone(){
		cs.assigncustomerstodecidedzone(selectedId, customerIds);
	}
}
