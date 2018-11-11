package cn.ldm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.Decidedzone;
import cn.ldm.dao.DecidedDao;
@Service
@Transactional
public class DecidedServiceImpl implements DecidedService{

	@Autowired
	private DecidedDao decidedDao;
	
	public List<Decidedzone> list() {
		// TODO Auto-generated method stub
		return decidedDao.list();
	}

}
