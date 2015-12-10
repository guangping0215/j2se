package com.ncs.proxy;

public class ProxySubject extends Subject{

	private Subject subject;
	
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}
	public void request() {
		preHandle();
		subject.request();
		postHandle();
	}

	private void preHandle(){
		System.out.println("preHandle...");
	}
	
	private void postHandle(){
		System.out.println("postHandle...");
	}
}
