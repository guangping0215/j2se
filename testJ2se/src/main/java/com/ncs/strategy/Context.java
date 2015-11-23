package com.ncs.strategy;

public class Context {

	private Calculator cal ;
	
	public void setCal(Calculator cal) {
		this.cal = cal;
	}
	
	public int calculat(int a, int b){
		return cal.calculate(a, b);
	}
	
}
