package com.ncs.observe;

import java.util.ArrayList;
import java.util.List;

public class RealSubject implements Subject{

	private List<Watcher> watchers = new ArrayList<Watcher>();
	@Override
	public void addWatcher(Watcher watcher) {
		watchers.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		watchers.remove(watcher);
	}

	@Override
	public void nodifyWatcher(String str) {
		for ( Watcher watcher : watchers ){
			watcher.performAction();
		}
	}

}
