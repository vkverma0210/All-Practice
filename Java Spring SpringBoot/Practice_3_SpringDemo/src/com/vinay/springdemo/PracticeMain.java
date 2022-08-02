package com.vinay.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeMain {

	public static void main(String[] args) {

		// load the spring Configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);

		Coach alphaCoach = context.getBean("myGolfCoach", Coach.class);

		// Check if they are the same
		boolean result = (theCoach == alphaCoach);

		// print the result;
		System.out.println("\nPointing to the same Object: " + result);

		System.out.println("\nMemory location of theCoach: " + theCoach);

		System.out.println("\nMemory location of alphaCoach: " + alphaCoach);

		// close the context
		context.close();
	}
}
