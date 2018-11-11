package cn.ldm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Decidedzone;
import cn.ldm.service.DecidedService;

@Controller
@Scope("prototype")
public class DecidedAction extends BaseAction<Decidedzone>{
	@Autowired 
	private DecidedService decideService;
	
	public void list(){
		List<Decidedzone> list = decideService.list();
		getArrayToJson(list, new String[]{"subareas","decidedzones"});
	}
}
