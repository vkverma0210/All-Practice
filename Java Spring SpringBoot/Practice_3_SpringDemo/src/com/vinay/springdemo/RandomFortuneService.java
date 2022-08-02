package com.vinay.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] data = { "Beware of the wolf in sheep's clothing", "Diligence is the mother of good luck",
			"The journey is the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);

		String theFortune = data[index];

		return theFortune;
	}
}
