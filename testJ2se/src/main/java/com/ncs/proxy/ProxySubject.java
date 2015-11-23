package com.ncs.proxy;

public class ProxySubject extends Subject{

	private RealSubject realSubject;
	
	public void request() {
		if( null == realSubject){
			realSubject = new RealSubject();
		}
		preHandle();
		realSubject.request();
		postHandle();
	}

	private void preHandle(){
		System.out.println("preHandle...");
	}
	
	private void postHandle(){
		System.out.println("postHandle...");
	}
}
