package com.ncs.composite;

public class Client {

	public static void main(String[] args) {
		Component leaf1 = new Leaf();
		Component leaf2 = new Leaf();
		Component leaf3 = new Leaf();
		Component leaf4 = new Leaf();
		Composite composit = new Composite();
		composit.addComponent(leaf3);
		composit.addComponent(leaf4);
		
		leaf1.doAction1();
		leaf2.doAction1();
		composit.doAction1();
	}
}
