package cn.ldm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Workbill;
import cn.ldm.service.WorkbillService;

@Controller
@Scope("prototype")
public class WorkbillAction extends BaseAction<Workbill>{
	@Autowired
	private WorkbillService ws;
	public void save(){
		ws.save(t);
	}
}
