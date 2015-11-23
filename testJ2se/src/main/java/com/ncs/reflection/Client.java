package com.ncs.reflection;

public class Client {

	public void test1(){
		System.out.println("test1 .... ");
	}
	
	@Test
	public void test2(){
		System.out.println("test2 .... ");
	}
	
	@Test
	private void test4(){
		System.out.println("test4 .... ");
	}
	
	@Test
	public void test3(String test){
		System.out.println("test3 .... "+ test);
	}
	
}
