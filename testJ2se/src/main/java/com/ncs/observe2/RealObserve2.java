package com.ncs.observe2;

import java.util.Observable;
import java.util.Observer;

public class RealObserve2 implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof SubjectObservable){
			SubjectObservable subjectObservable = (SubjectObservable) o;
			if(subjectObservable.localParam<=5)
				System.out.println("update called "+subjectObservable.localParam);
		}
		
	}

}
