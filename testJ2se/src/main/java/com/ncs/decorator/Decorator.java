package com.ncs.decorator;

public class Decorator implements Component{

	protected Component component;
	
	protected Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void doSomething() {
		component.doSomething();
	}

}
