package com.ncs.strategy;

public class Client {

	public static void main(String[] args) {
		
		Context context = new Context();
		Calculator add = new CalculatorAdd();
		context.setCal(add);
		
		System.out.println(context.calculat(3, 4));
		
		Calculator sb = new CalculatorSubtract();
		context.setCal(sb);
		
		System.out.println(context.calculat(3, 4));
	}
}
