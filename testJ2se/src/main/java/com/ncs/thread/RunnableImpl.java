package com.ncs.thread;

public class RunnableImpl {
	public static void main(String[] args) {
		MyRunnable mt1 = new MyRunnable();
		
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt1);
		Thread t3 = new Thread(mt1);
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyRunnable implements Runnable{
	private int ticket = 5;
	public void run() {
		synchronized (this) {
			
		}
		for(int i=0;i<100;i++){
			if(ticket > 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("current ticket : "+ticket-- );
			}
		}
	}
}