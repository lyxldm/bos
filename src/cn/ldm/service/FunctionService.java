package cn.ldm.service;

import java.util.List;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;

public interface FunctionService {

	List<Function> listajax();

	void add(Function t);

	void pageQuery(PageBean pageBean);

	List<Function> findFunction(Integer id);

	
}
