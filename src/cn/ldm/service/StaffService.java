package cn.ldm.service;

import java.util.List;

import cn.ldm.bean.PageBean;
import cn.ldm.bean.Staff;

public interface StaffService {

	void save(Staff t);

	void list(PageBean pageBean);

	void deleteBatch(String ids);

	void staffUpdate(Staff t);

	Staff findStaffById(String id);

	List<Staff> listAjax();

}
