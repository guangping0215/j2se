package com.ncs.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) throws CharacterCodingException {
		String content = "陈光平Eddie";
		CharBuffer cb = CharBuffer.wrap(content);
		SortedMap<String,Charset> map = Charset.availableCharsets();
		System.out.println(map);
		Charset charset = Charset.forName("UTF-8");
		CharsetEncoder ce = charset.newEncoder();
		CharsetDecoder de = charset.newDecoder();
		
		ByteBuffer bf = ce.encode(cb);
		System.out.println(de.decode(bf));;
		
	}
}
