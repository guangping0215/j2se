package com.ncs.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	public static void main(String[] args) {
		ExecutorService exs = Executors.newFixedThreadPool(2);
		exs.execute(new PrintChar('a', 10));
		exs.execute(new PrintChar('b', 20));
		exs.execute(new PrintNum( 10));
		exs.shutdown();
	}
}

class PrintChar implements Runnable{
	private char c;
	private int num;
	
	public PrintChar(char c, int num) {
		this.c = c;
		this.num = num;
	}
	@Override
	public void run() {
		for(int i=0;i<num;i++){
			System.out.println(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintNum implements Runnable{
	private int num;
	
	public PrintNum(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		for(int i=0;i<num;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}