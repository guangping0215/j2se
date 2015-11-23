package com.ncs.guangping;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestInvoker {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int add(int a,int b){
		return a+b;
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> invokerClass = Class.forName("com.ncs.guangping.TestInvoker");
		Object invokerInstance = invokerClass.newInstance();
		//System.out.println(invokerInstance instanceof  TestInvoker);
		//Method[] methods = invokerClass.getDeclaredMethods();ß
		Method setName = invokerClass.getMethod("setName", new Class[]{String.class});
		setName.invoke(invokerInstance, new Object[]{"GuangPing"});
		
		Method getName = invokerClass.getMethod("getName", new Class[]{});
		System.out.println(getName.invoke(invokerInstance, new Object[]{}));
		
		Method add = invokerClass.getMethod("add", new Class[]{int.class,int.class});
		System.out.println(add.invoke(invokerInstance, new Object[]{5,6}));
		
		System.out.println("===================");
		Class<?> clazz = Invoker.class;
		Constructor cons = clazz.getConstructor(new Class[]{String.class,int.class});
		Object obj = cons.newInstance(new Object[]{"GuangPing",27});
		
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true); //压制java对访问修饰符的检查
		field.set(obj, "LiPing");
		Invoker invoker = (Invoker)obj;
		System.out.println(invoker.getName());
		
		Method method = clazz.getDeclaredMethod("prints", new Class[]{});
		method.setAccessible(true);
		method.invoke(obj, new Object[]{});
	}
}
