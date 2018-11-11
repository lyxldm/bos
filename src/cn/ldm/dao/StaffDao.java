package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Staff;

public interface StaffDao {

	void save(Staff t);

	void list(PageBean pageBean);

	void deleteBatch(String i);
	
	void staffUpdate(Staff t);

	Staff findStaffById(String id);

	List<Staff> listAjax();


}
