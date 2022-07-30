package com.vinay.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {
	// Define a private field
	private FortuneService fortuneService;

	public TrackCoach() {
	}

	// Define a constructor for dependency injection
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return "Just do it: " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}

	// add a destroy method
	public void destroy() throws Exception {
		System.out.println("TrackCoach: inside method doMyCLeanupStuff");
	}
}