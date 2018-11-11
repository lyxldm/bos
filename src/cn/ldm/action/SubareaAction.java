package cn.ldm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ldm.bean.Decidedzone;
import cn.ldm.bean.Region;
import cn.ldm.bean.Subarea;
import cn.ldm.service.SubService;
import cn.ldm.utils.FileUtils;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
	@Autowired
	private SubService subService;
	
	public String list(){
		subService.pageList(pageBean);
		getObjectToJson(pageBean, new String[]{"page","size","decidedzone","subareas"});
		return NONE;
	}
	
	public String add(){
		subService.add(t);
		return "toSubarea";
	}
	
	public String exportXls() throws IOException{
		List<Subarea> list = subService.findAll();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet("sheet1");
		HSSFRow createRow = sheet.createRow(0);
		createRow.createCell(0).setCellValue("关键字");
		createRow.createCell(1).setCellValue("开始数");
		createRow.createCell(2).setCellValue("结束数");
		createRow.createCell(3).setCellValue("single");
		createRow.createCell(4).setCellValue("位置信息");
		createRow.createCell(5).setCellValue("省市区");
		for(Subarea subarea:list){
			HSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);
			row.createCell(0).setCellValue(subarea.getAddresskey());
			row.createCell(1).setCellValue(subarea.getStartnum());
			row.createCell(2).setCellValue(subarea.getEndnum());
			row.createCell(3).setCellValue(subarea.getSingle());
			row.createCell(4).setCellValue(subarea.getPosition());
			row.createCell(5).setCellValue(subarea.getRegion().getShow());
		}
		//使用输出流下载文件 (一个输出流，两个头)
		
		String fileName = "分区数据.xls";
		//获取客户端浏览器类型
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		//处理下载名中文问题
		fileName = FileUtils.encodeDownloadFilename(fileName,agent);
		String mimeType = ServletActionContext.getRequest().getServletContext().getMimeType(fileName);
		//一个头 文档类型
		ServletActionContext.getResponse().setContentType(mimeType);
		//一个头 指定文档名称
		ServletActionContext.getResponse().setHeader("content-disposition","attachment;filename="+fileName);
		//一个流
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		hssfWorkbook.write(outputStream);
		return NONE;
	}
	
	public void listAjax(){
		List<Subarea> list = subService.listAjax();
		System.out.println(list.size());
		getArrayToJson(list, new String[]{"decidedzone","region"});
		
	}
}
