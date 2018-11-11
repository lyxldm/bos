package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;

public interface FunctionDao {

	List<Function> listajax();

	void add(Function t);

	void pageQuery(PageBean pageBean);
	
	int total();

	List<Function> findFunction(Integer id);

	public List<Function> findMean(Integer id);




}
