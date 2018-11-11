package cn.ldm.action;

import org.jboss.weld.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class a {
public static void main(String[] args) {
	ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(classPathXmlApplicationContext.getBean("dasdas"));
	}
}
