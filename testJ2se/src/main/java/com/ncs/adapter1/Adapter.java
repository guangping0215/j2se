package com.ncs.adapter1;

public class Adapter extends Adaptee implements Target{

	@Override
	public void runTest() {
		System.out.println("适配步骤。。");
		this.testAdd();
	}

	
}
