package com.ncs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataInputAndOutputStreamTest {

	public static void main(String[] args) {
		show();
	}
	
	private static void show(){
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		ByteArrayInputStream bis = null;
		DataInputStream dis = null;
		String name = "Guang Ping";
		Integer age = 26;
		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos); //从内存写到字节数组
			dos.writeUTF(name);
			dos.writeInt(age);
			byte[] target = bos.toByteArray();
			
			bis = new ByteArrayInputStream(target); //再从字节数组读入内存
			dis = new DataInputStream(bis);
			System.out.println(dis.readUTF()+dis.readInt());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
