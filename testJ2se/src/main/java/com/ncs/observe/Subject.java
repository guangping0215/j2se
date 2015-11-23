package com.ncs.observe;

public interface Subject {

	public void addWatcher(Watcher watcher);
	
	public void removeWatcher(Watcher watcher);
	
	public void nodifyWatcher(String str);
	
}
