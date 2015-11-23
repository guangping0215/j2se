package com.ncs.decorator;

public class ConcreteComponent implements Component{

	@Override
	public void doSomething() {
		System.out.println("ConcreteComponent do something...");
	}

}
