package com.ncs.dynamicproxy;

public class RealSubject implements Subject{

	public void request() {
		System.out.println("Real Subject Handler .... ");
	}

}
