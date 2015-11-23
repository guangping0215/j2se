package com.ncs.serializable;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = -7397861958516875518L;

	private String blockNo;
	private String streetNo;
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	
	
}
