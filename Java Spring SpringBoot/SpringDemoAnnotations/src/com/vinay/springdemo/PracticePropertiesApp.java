package com.vinay.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticePropertiesApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call our new swim coach method -- has the pops value injected
		System.out.println("email: " + theCoach.getEmailAddress());
		System.out.println("team: " + theCoach.getTeam());
		
		//close the context
		context.close();
	}
}
