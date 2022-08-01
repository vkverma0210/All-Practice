package com.vinay.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice Batting for 2 hrs...!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
