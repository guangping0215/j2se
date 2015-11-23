package com.ncs.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		InvocationHandler ih = new DynmicProxySubject(real);
		Subject subject = (Subject) Proxy.newProxyInstance(real.getClass().getClassLoader(), real.getClass().getInterfaces(), ih);
		subject.request();
		System.out.println(subject.getClass());
		System.out.println("==========");
		Subject subject2 = (Subject) DynmicProxySubject.proxyFactory(real);
		subject2.request();
	}
}
