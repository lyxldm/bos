package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Subarea;

public interface SubareaDao {


	void pageList(PageBean pageBean);

	void add(Subarea t);

	List<Subarea> findAll();

	List<Subarea> decidedzone();


}
