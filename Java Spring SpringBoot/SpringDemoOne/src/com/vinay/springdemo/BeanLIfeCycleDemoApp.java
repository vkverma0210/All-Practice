package com.vinay.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLIfeCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//Print
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();
	}
}
