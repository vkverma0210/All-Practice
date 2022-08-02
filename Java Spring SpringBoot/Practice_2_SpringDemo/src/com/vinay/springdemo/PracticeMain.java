package com.vinay.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeMain {

	public static void main(String[] args) {
		
		//load the spring Configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkOut());
		
		//close the context
		context.close();
	}
}
