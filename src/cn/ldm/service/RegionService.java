package cn.ldm.service;

import java.util.List;

import cn.ldm.bean.Region;

public interface RegionService {

	void saveBatch(List<Region> list);

	List<Region> list();

	List<Region> likeList(String q);

}
