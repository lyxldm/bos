package cn.ldm.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aaa {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(classPathXmlApplicationContext.getBean("a"));
	}

}
