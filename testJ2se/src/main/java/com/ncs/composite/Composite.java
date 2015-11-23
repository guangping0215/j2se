package com.ncs.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

	private List<Component> list = new ArrayList<Component>();
	
	public void addComponent(Component component){
		list.add(component);
	}
	
	public void removeComponent(Component component){
		list.remove(component);
	}
	
	public List<Component> getAllComponent(){
		return list;
	}
	
	@Override
	public void doAction1() {
		for(Component component : list){
			component.doAction1();
		}
	}

}
