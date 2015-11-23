package com.ncs.decorator;

public class DecoratorB extends Decorator{

	protected DecoratorB(Component component) {
		super(component);
	}

	public void doSomething() {
		
		component.doSomething();
		doSomethinga();
	}
	public void doSomethinga() {
		System.out.println("DecoratorB do something...");
	}
}
