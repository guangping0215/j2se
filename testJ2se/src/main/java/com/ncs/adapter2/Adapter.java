package com.ncs.adapter2;

public class Adapter implements Target{

	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void runTest() {
		adaptee.testAdd();
	}

}
