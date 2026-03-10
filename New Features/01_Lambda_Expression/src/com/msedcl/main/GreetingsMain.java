package com.msedcl.main;

import com.msedcl.main.service.GoodAfternoonGreetings;
import com.msedcl.main.service.GoodMorningGreetings;
import com.msedcl.main.service.Greetings;

public class GreetingsMain {
	public static void main(String[] args) {

		GoodMorningGreetings goodMorningGreetings = new GoodMorningGreetings();
		goodMorningGreetings.greet();

		GoodAfternoonGreetings goodAfternoonGreetings = new GoodAfternoonGreetings();
		goodAfternoonGreetings.greet();
		
		Greetings goodEveningGreetings = new Greetings() {
			
			@Override
			public void greet() {
				System.out.println("Good Evening");
			}
		};
		
		goodEveningGreetings.greet();
		
		Greetings goodNightGreetings = ()  -> System.out.println("Good Night");
		goodNightGreetings.greet();
		
		Greetings goodDayGreetings = () ->   {
			System.out.println("Good Day");
			System.out.println("Lambda Expression is simple");
		};
		
		goodDayGreetings.greet();
	}
}
