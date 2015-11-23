package com.ncs.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynmicProxySubject implements InvocationHandler{

	private Object object; //这个解决了代理模式的问题，减少了proxy类

	public DynmicProxySubject(Object object){
		this.object = object;
	}
	private void preHandle(){
		System.out.println("preHandle...");
	}
	
	private void postHandle(){
		System.out.println("postHandle...");
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		preHandle();
		method.invoke(object, args);
		postHandle();
		return null;
	}
	//简单的一个factory方法
	public static Object proxyFactory(Object object){
		
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new DynmicProxySubject(object));
	}
}
