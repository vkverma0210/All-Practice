package com.vinay.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFrotune() {
		return "Today is your lucky day";
	}

}
