package com.ncs.command;

public class Client {

	public static void main(String[] args) {
		Receiver execute = new Receiver();
		AbstractCommand order = new Order(execute);
		Invoker invoker = new Invoker(order);
		invoker.invoke();
	}
}
