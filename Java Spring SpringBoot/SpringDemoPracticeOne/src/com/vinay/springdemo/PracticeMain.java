package com.vinay.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeMain {
	public static void main(String[] args) {

		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//retrieve bean from spring container
		Coach theCoach = context.getBean("myFootballCoach", Coach.class);

		//Call methodd ont he bean
		System.out.println(theCoach.getDailyWorkout());

		//close the context
		context.close();
	}
}