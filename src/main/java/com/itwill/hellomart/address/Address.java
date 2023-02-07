package com.itwill.hellomart.address;

public class Address {
	private String userid;
	private String loc;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String userid, String loc) {
		super();
		this.userid = userid;
		this.loc = loc;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Address [userid=" + userid + ", loc=" + loc + "]";
	}
	
}
