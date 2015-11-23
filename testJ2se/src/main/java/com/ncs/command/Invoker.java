package com.ncs.command;

public class Invoker {

	private AbstractCommand command; 
	public Invoker(AbstractCommand command) {
		this.command = command;
	}
	
	public void invoke(){
		command.execute();
	}
}
