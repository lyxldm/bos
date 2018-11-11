package cn.ldm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Region;
import cn.ldm.service.RegionService;
import cn.ldm.utils.PinYin4jUtils;
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{
	private File myfile;

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	@Autowired
	private RegionService regionService;
	public void adds() throws FileNotFoundException, IOException{
		List<Region> list = new ArrayList<Region>();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(myfile));
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
		for(Row row:hssfSheet){
			if(row.getRowNum() == 0){
				continue;
			}	
				String id = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postcode = row.getCell(4).getStringCellValue();
				province = province.substring(0, province.length() - 1);
				city = city.substring(0, city.length() - 1);
				district = district.substring(0, district.length() - 1);
				String info = province + city + district;
				String[] headByString = PinYin4jUtils.getHeadByString(info);
				String shortcode = StringUtils.join(headByString);
				//³ÇÊÐ±àÂë---->>shijiazhuang
				String citycode = PinYin4jUtils.hanziToPinyin(city, "");
				Region region = new Region(id, province, city, district, postcode, null, null,null);
				region.setShortcode(shortcode);
				region.setCitycode(citycode);
				list.add(region);
		}
		regionService.saveBatch(list);
	}
	
	private String q;
	
	public void setQ(String q) {
		this.q = q;
	}

	public String list(){
		if(q != null){
			List<Region> list = regionService.likeList(q);
			getArrayToJson(list, new String[]{"postcode","shortcode","citycode","subareas"});
		}else{
			List<Region> list = regionService.list();
			getArrayToJson(list, new String[]{"postcode","shortcode","citycode","subareas"});
		}
		return NONE;
	}
	
}
