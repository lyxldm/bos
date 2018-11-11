package cn.ldm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Subarea;
import cn.ldm.dao.SubareaDao;
@Service
@Transactional
public class SubServiceImpl implements SubService{
@Autowired
	private SubareaDao subareaDao;

@Override
public void pageList(PageBean pageBean) {
	// TODO Auto-generated method stub
	subareaDao.pageList(pageBean);
}

@Override
public void add(Subarea t) {
	// TODO Auto-generated method stub
	subareaDao.add(t);
}

@Override
public List<Subarea> findAll() {
	// TODO Auto-generated method stub
	return subareaDao.findAll();
}

@Override
public List<Subarea> listAjax() {
	// TODO Auto-generated method stub
	return subareaDao.decidedzone();
}

}
