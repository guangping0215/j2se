package com.ncs.observe;

public class Client {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		
		Watcher watcher1 = new RealWatcher();
		Watcher watcher2 = new RealWatcher();
		Watcher watcher3 = new RealWatcher();
		
		subject.addWatcher(watcher1);
		subject.addWatcher(watcher2);
		subject.addWatcher(watcher3);
		
		subject.nodifyWatcher("test");
		
		subject.removeWatcher(watcher2);
		
		subject.nodifyWatcher("test");
	}
}
