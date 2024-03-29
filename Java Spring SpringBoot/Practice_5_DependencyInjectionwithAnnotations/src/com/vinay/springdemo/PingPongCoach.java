package com.vinay.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;

	// define a default constructor
	public PingPongCoach() {
		System.out.println(">> PintPongCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your PingPong Drop shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
