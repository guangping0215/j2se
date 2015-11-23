package com.ncs.observe2;

import java.util.Observer;

public class TestObservable {

	public static void main(String[] args) {
		SubjectObservable oservable = new SubjectObservable();
		Observer watcher1 = new RealObserve();
		Observer watcher2 = new RealObserve2();
		oservable.addObserver(watcher1);
		oservable.addObserver(watcher2);
		for(int i=0;i<10;i++){
			oservable.doPerform();
			oservable.notifyObservers(oservable);
		}
	}
}
