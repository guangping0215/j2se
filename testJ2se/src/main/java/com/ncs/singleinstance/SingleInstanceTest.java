package com.ncs.singleinstance;

public class SingleInstanceTest {

	public static void main(String[] args) {
		
		Mythread thread1 = new Mythread();
		Mythread thread2 = new Mythread();
		
		thread1.start();
		thread2.start();
	}
}

class SingleInstance{
	
	private static SingleInstance singleInstance ;
	
	private SingleInstance(){
		
	}
	
	public static synchronized SingleInstance getInstance(){
		
		if(null == singleInstance){
			
			try {
				Thread.sleep((long)(Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			singleInstance = new SingleInstance();
		}
		return singleInstance;
	}
}

class Mythread extends Thread{
	@Override
	public void run() {
		System.out.println(SingleInstance.getInstance());
	}
}