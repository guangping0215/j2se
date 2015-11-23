package com.ncs.thread;

public class WaitNotifyTest {

	public static void main(String[] args) {
		Sample sample = new Sample();
		
		IncreaseTread increase = new IncreaseTread(sample);
		DecreaseTread decrease = new DecreaseTread(sample);
		
		IncreaseTread increase2 = new IncreaseTread(sample);
		DecreaseTread decrease2 = new DecreaseTread(sample);
		
		increase.start();
		decrease.start();
		increase2.start();
		decrease2.start();
	}
}

class Sample{
	
	private int number = 0;
	
	public synchronized void increasement(){
		while( 0 != number ){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		number ++;
		System.out.println( number );
		
		notify();
	}
	
	public synchronized void decreasement(){
		while( 0 == number ){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		number --;
		System.out.println( number );
		
		notify();
	}
}

class IncreaseTread extends Thread{
	
	private Sample sample;
	public IncreaseTread(Sample sample) {
		this.sample = sample;
	}
	@Override
	public void run() {
		
		for(int i=0;i<20;i++){
			try {
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sample.increasement();
		}
	}
}

class DecreaseTread extends Thread{
	
	private Sample sample;
	public DecreaseTread(Sample sample) {
		this.sample = sample;
	}
	@Override
	public void run() {
		
		for(int i=0;i<20;i++){
			try {
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		sample.decreasement();
		}
	}
}
