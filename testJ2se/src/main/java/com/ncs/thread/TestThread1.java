package com.ncs.thread;

public class TestThread1 {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.start();
		
		Thread1 thread11 = new Thread1();
		thread11.start();
		
	}
}

class Thread1 extends Thread{
	int i;
	@Override
	public void run() {
		for( i=0;i<100;i++){
			System.out.println("i : " + i);
		}
	}
}

class Thread2 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("j : " + i);
		}
	}
}
