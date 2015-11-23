package com.ncs.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Person implements Serializable{

	private static final long serialVersionUID = -8351556676073921121L;

	private String name;
	private int age;
	private BigDecimal saveMoney;
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(BigDecimal saveMoney) {
		this.saveMoney = saveMoney;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
