package com.itwill.hellomart.address;

public class Address {
	private String userid;
	private String loc;
	private int o_no;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String userid, String loc, int o_no) {
		super();
		this.userid = userid;
		this.loc = loc;
		this.o_no = o_no;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
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
		return "Address [userid=" + userid + ", loc=" + loc + ", o_no=" + o_no + "]";
	}
	
}
