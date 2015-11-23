package com.ncs.command;

public class Order implements AbstractCommand{

	private Receiver receiver;
	
	public Order(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.doAction();
	}

}
