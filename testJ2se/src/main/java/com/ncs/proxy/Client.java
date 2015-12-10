package com.ncs.proxy;

public class Client {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		ProxySubject proxy = new ProxySubject(subject);
		
		proxy.request();
	}
}
