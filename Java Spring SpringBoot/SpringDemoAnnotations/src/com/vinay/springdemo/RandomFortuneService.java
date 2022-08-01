package com.vinay.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Create a array of string
	private String[] data = { "Delhi Capitals", "Chennai Super Kings", "Royal Chalengers Bangalore" };

	// create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFrotune() {
		// pick a random string from the arrray
		int index = myRandom.nextInt(data.length);

		String theFortune = data[index];

		return theFortune;
	}
}
