package com.ncs.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class TestSerializable {

	public static void main(String[] args) throws Exception {
		readObjectFromFile();
	}
	
	private static void writeObjectToFile()throws Exception{
		Person person = new Person();
		Address address = new Address();
		address.setBlockNo("test Block No...");
		address.setStreetNo("test Street No...");
		person.setName("GuangPing");
		person.setAge(26);
		person.setSaveMoney(new BigDecimal ("20000.10"));
		person.setAddress(address);
		
		ObjectOutputStream dos = new ObjectOutputStream( new FileOutputStream( "/Users/guangping/test/test.tmp" ));
		dos.writeObject(person);
		dos.flush();
		dos.close();
	}
	
	private static void readObjectFromFile()throws Exception{
		
		ObjectInputStream dis = new ObjectInputStream( new FileInputStream( "/Users/guangping/test/test.tmp" ));
		Object object = dis.readObject();
		if (object instanceof Person){
			Person person = (Person) object;
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(person.getSaveMoney());
			System.out.println(person.getAddress().getBlockNo());
			System.out.println(person.getAddress().getStreetNo());
		}
		dis.close();
	}
}
