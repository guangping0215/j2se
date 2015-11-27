package com.ncs.commonclass;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();
		System.out.println(run.freeMemory());
		acceptStr();
		System.out.println(run.freeMemory());
		run.gc();
		System.out.println(run.freeMemory());
		System.out.println(run.availableProcessors());
		Process notepadProcess = run.exec("notepad.exe");
		Thread.sleep(5000);
		notepadProcess.destroy();
	}
	
	private static void acceptStr(){
		String s = "";
		for(int i=0;i<1000;i++){
			s = s + i;
		}
	}
	
}
