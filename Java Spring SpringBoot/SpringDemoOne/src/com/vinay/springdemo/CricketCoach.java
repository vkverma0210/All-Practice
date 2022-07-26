package com.vinay.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//Add new Field for emailAddress and team
	private String emailAddress;
	private String team;

	// Create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	//Setter methods for email and team
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast balling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
