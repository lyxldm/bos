package cn.ldm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Noticebill;
import cn.ldm.crm.Customer;
import cn.ldm.crm.CustomerService;
import cn.ldm.service.NoticebillService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private NoticebillService noticeS;
	public void findCustomerByTelephone(){
		Customer findCustomer = customerService.findCustomer(t.getTelephone());
		getObjectToJson(findCustomer, null);
	}
	
	public String add(){
		noticeS.add(t);
		return "toNoticebill";
	}
}
