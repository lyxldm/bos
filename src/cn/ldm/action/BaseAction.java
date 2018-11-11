package cn.ldm.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Scanner;

import org.apache.struts2.ServletActionContext;
import org.jboss.weld.context.ApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ldm.bean.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	PageBean pageBean = new PageBean();
	private int page;
	private int rows;
	public void setPage(int page) {
		pageBean.setPage(page);
	}

	public void setRows(int rows) {
		pageBean.setSize(rows);
	}
	
	public String getObjectToJson(Object obj,String[] exludes){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(exludes);
		String json = JSONObject.fromObject(obj,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}
	
	
	
	
	
	public String getArrayToJson(Object obj,String[] exludes){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(exludes);
		String json = JSONArray.fromObject(obj,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}

	
	protected T t;
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return t;
	}
	public BaseAction() {
		ParameterizedType pType =(ParameterizedType) getClass().getGenericSuperclass();
		Class<T> class1 = (Class) pType.getActualTypeArguments()[0];	
		try {
			t = class1.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
	}
}
