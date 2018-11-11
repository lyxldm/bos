package cn.ldm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ldm.bean.Region;
import cn.ldm.dao.RegionDao;
@Service
@Transactional
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionDao regionDao;
	@Override
	public void saveBatch(List<Region> list) {
		// TODO Auto-generated method stub
		for(Region region:list){
			regionDao.save(region);
		}
	}
	@Override
	public List<Region> list() {
		// TODO Auto-generated method stub
		return regionDao.list();
	}
	@Override
	public List<Region> likeList(String q) {
		// TODO Auto-generated method stub
		return regionDao.likeList(q);
	}

}
