package cn.ldm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.Workbill;
@Service
@Transactional
public class WorkbillServiceImpl implements WorkbillService{
	@Autowired
	private WorkbillDao wd;
	public void save(Workbill t) {
		// TODO Auto-generated method stub
		wd.save(t);
	}

}
