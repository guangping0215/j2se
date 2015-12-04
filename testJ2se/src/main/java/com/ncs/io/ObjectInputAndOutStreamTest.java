package com.ncs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputAndOutStreamTest {

	static byte[] result;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		write();
		show();
	}
	
	private static void write() throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream obs = new ObjectOutputStream(bos);
		List<Person> pers = new ArrayList<Person>();
		pers.add(new Person("guangping",26));
		pers.add(new Person("liping",26));
		obs.writeObject(pers);
		result = bos.toByteArray();
		obs.close();
	}
	@SuppressWarnings("unchecked")
	private static void show() throws IOException, ClassNotFoundException{
		ByteArrayInputStream bis = new ByteArrayInputStream(result);
		ObjectInputStream ois = new ObjectInputStream(bis);
		List<Person> pers = (List<Person>)ois.readObject();
		for(Person p : pers){
			System.out.println(p.getName() + " age is " +p.getAge());
		}
		ois.close();
	}
}

class Person implements Serializable{
	private static final long serialVersionUID = -7796664547091417207L;
	private String name;
	private Integer age;
	//private transient Integer age;
	 
	public Person(String name,Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
