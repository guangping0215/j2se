package com.ncs.commonclass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000, 2000);
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		Date date = new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
	}
}
