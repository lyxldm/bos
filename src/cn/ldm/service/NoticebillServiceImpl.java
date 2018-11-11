package cn.ldm.service;

import java.sql.Timestamp;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.Decidedzone;
import cn.ldm.bean.Noticebill;
import cn.ldm.bean.Staff;
import cn.ldm.bean.User;
import cn.ldm.bean.Workbill;
import cn.ldm.crm.Customer;
import cn.ldm.crm.CustomerService;
import cn.ldm.dao.DecidedDaoImpl;
import cn.ldm.dao.NoticebillDao;
import cn.ldm.dao.RegionDaoImpl;
import cn.ldm.dao.StaffDaoImpl;
import cn.ldm.dao.WorkbillDaoImpl;

@Service
@Transactional
public class NoticebillServiceImpl implements NoticebillService{

	@Autowired
	private DecidedDaoImpl decidedDaoImpl;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private NoticebillDao nod;
	@Autowired
	private WorkbillDaoImpl wd;
	@Override
	public void add(Noticebill t) {
		// TODO Auto-generated method stub
		User user = (User) ServletActionContext.getContext().getSession().get("user");
		t.setUser(user);
		Customer findCustomer = customerService.findCustomer(t.getTelephone());
		String decidedzoneId = findCustomer.getDecidedzoneId();
		if(decidedzoneId != null){
			t.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Decidedzone findById = decidedDaoImpl.findById(decidedzoneId);
			Staff staff = findById.getStaff();
			t.setStaff(staff);
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workbill.setNoticebill(t);
			workbill.setPickstate(Workbill.PICKSTATE_NO);
			workbill.setRemark(t.getRemark());
			workbill.setStaff(staff);
			workbill.setType(Workbill.TYPE_1);
			wd.save(workbill);
		}else{
			t.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
		System.out.println();
		nod.add(t);
	}


}
