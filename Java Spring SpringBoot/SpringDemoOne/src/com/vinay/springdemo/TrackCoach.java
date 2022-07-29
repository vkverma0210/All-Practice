package com.vinay.springdemo;

public class TrackCoach implements Coach {
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
}