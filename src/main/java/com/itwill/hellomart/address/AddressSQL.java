package com.itwill.hellomart.address;

public class AddressSQL {
	//주소 입력
	public final static String ADDRESS_INSERT=
			"insert into address(userid, loc) values(?, ?)";
	//주소 변경
	public final static String ADDRESS_UPDATE=
			"update address set loc=? where userid = ?";
	//주소 삭제(일케 하는거 맞나?)
	public final static String ADDRESS_DELETE =
			"delete from address where userid= ?";
	//주소전체보기
	public final static String ADDRESS_SELECT_ALL=
			"select * from address";

}
