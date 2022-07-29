package com.vinay.springdemo;

public class GolfCoach implements Coach {
	private FortuneService fortuneService;

	public GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice for 2 hours...!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}