package com.itwill.hellomart.address;

public class AddressSQL {
	//주소 입력
	public final static String ADDRESS_INSERT=
			"insert into address(addr_no,userid, loc) values(address_addr_no_SEQ.nextval, ? , ?)";
	//주소 변경
	public final static String ADDRESS_UPDATE=
			"update address set loc=? where addr_no = ?";
	//주소 삭제(일케 하는거 맞나?)
	public final static String ADDRESS_DELETE =
			"delete from address where addr_no= ?";
	//내 주소 전체보기
	public final static String ADDRESS_SELECT_ALL=
			"select * from address where userid = ?";
	
}
