package cn.ldm.service;

import org.springframework.stereotype.Repository;

import cn.ldm.bean.Workbill;

@Repository
public interface WorkbillDao {

	void save(Workbill t);

	
}
