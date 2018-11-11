package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.Decidedzone;

public interface DecidedDao {

	List<Decidedzone> list();
	Decidedzone findById(String id);
}
