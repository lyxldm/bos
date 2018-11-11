package cn.ldm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.Function;
import cn.ldm.bean.PageBean;
import cn.ldm.dao.FunctionDao;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionService{
	
	@Autowired
	private FunctionDao fd;
	@Override
	public List<Function> listajax() {
		// TODO Auto-generated method stub
		return fd.listajax();
	}
	public void add(Function t) {
		// TODO Auto-generated method stub
		fd.add(t);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		int total = fd.total();
		pageBean.setTotal(total);
		fd.pageQuery(pageBean);
	}
	public List<Function> findFunction(Integer id) {
		// TODO Auto-generated method stub
		return fd.findMean(id);
	}
	
}
