package com.ncs.observe;

public class RealWatcher implements Watcher{

	@Override
	public void performAction() {
		System.out.println("RealWatcher has been called...");
	}

}
