package com.ncs.adapter3;

public class Client {

	public static void main(String[] args) {
		AbstractService as = new ServiceAdapter();
		as.service1();
	}
}
