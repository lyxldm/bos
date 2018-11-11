package cn.ldm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Function;
import cn.ldm.service.FunctionService;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	@Autowired
	private FunctionService fs;
	
	public void listajax(){
		List<Function> list = fs.listajax();
		getArrayToJson(list, new String[]{"parentFunction","roles","children"});
	}
	
	public void add(){
		fs.add(t);
	}
	
	public void pageQuery(){
		fs.pageQuery(pageBean);
		getObjectToJson(pageBean, new String[]{"size","page","parentFunction","roles","children"});
	}
	
	private Integer idd;
	public Integer getIdd(){
		return idd;
	}
	public void setIdd(Integer idd) {
		this.idd = idd;
	}
	public void findFunction(){ 
		List<Function> list = fs.findFunction(idd);
		getArrayToJson(list, new String[]{"roles","children","parentFunction"});
	}
}
