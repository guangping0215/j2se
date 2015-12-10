package com.ncs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestInvoker {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class<?> invokerClass = Class.forName("com.ncs.reflection.Invoker");
		Object invokerInstance = invokerClass.newInstance();
		//System.out.println(invokerInstance instanceof  TestInvoker);
		//Method[] methods = invokerClass.getDeclaredMethods();
		Method setName = invokerClass.getMethod("setName", new Class[]{String.class});
		setName.invoke(invokerInstance, new Object[]{"GuangPing"});
		
		Method getName = invokerClass.getMethod("getName", new Class[]{});
		System.out.println(getName.invoke(invokerInstance, new Object[]{}));
		
		Method add = invokerClass.getMethod("add", new Class[]{Integer.class,int.class});
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

class Invoker{
	private String name;
	private int age;
	
	public Invoker(){
	}
	
	public Invoker(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int add(Integer a, int b){
		return a+b;
	}

	public void prints(){
		System.out.println(name+": "+age);
	}
}