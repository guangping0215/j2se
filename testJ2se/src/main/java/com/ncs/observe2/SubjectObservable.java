package com.ncs.observe2;

import java.util.Observable;

public class SubjectObservable extends Observable{

	public int localParam = 10;
	
	public void doPerform(){
		this.setChanged();
		localParam --;
	}
	
}
