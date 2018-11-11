package cn.ldm.dao;

import java.util.List;

import cn.ldm.bean.Region;

public interface RegionDao {

	void save(Region region);


	List<Region> list();


	List<Region> likeList(String q);
	

}
