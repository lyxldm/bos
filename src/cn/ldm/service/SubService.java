package cn.ldm.service;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Subarea;

public interface SubService {

	void pageList(PageBean pageBean);

	void add(Subarea t);

	List<Subarea> findAll();

	List<Subarea> listAjax();

}
