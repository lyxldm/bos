package cn.ldm.service;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Staff;
import cn.ldm.dao.StaffDao;
@Service
@Transactional
public class StaffServiceImpl implements StaffService{
@Autowired
private StaffDao staffDao;
	@Override
	public void save(Staff t) {
		// TODO Auto-generated method stub
		staffDao.save(t);
	}
	@Override
	public void list(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.list(pageBean);
	}
	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(ids)){
			String[] id = ids.split(",");
			for(String i:id){
				staffDao.deleteBatch(i);
			}
		}
	}
	@Override
	public void staffUpdate(Staff t) {
		// TODO Auto-generated method stub
		staffDao.staffUpdate(t);
	}
	@Override
	public Staff findStaffById(String id) {
		// TODO Auto-generated method stub
		
		return staffDao.findStaffById(id);
	}
	@Override
	public List<Staff> listAjax() {
		// TODO Auto-generated method stub
		return staffDao.listAjax();
	}

}
