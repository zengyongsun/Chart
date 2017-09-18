package com.zy.chart.java.com;

import com.zy.chart.java.com.imp.NoSay;
import com.zy.chart.java.com.imp.SayHello;

public class Main {

	public static void main(String[] args) {

		BlackDuck blackDuck = new BlackDuck(new NoSay());
		blackDuck.say();
		
		RedDuck redDuck = new RedDuck(new NoSay());
		redDuck.say();
		
		RubberDuck rubberDuck = new RubberDuck(new SayHello());
		rubberDuck.say();
	}

}
