package cn.ldm.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jobs01 {
	public void run(){
		System.out.println("Ê±¼äÎª:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
