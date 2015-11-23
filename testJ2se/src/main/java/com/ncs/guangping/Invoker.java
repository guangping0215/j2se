package com.ncs.guangping;

public class Invoker{
	private String name;
	private int age;
	
	public Invoker(){
	}
	
	public Invoker(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private void prints(){
		System.out.println(name+": "+age);
	}
}
