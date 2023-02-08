package com.itwill.hellomart.daotest;

import com.itwill.hellomart.address.AddressDao;

public class AddressDaoMainTest {

	public static void main(String[] args)throws Exception {
		AddressDao addressDao = new AddressDao();
		//주소 입력
		//addressDao.addressInsert(new Address("guard1","경기도 성남시 분당구 삼평동"));
		//주소 변경
		//addressDao.addressUpdate(new Address("guard1","서울시 강남구 논현동"));
		//주소 삭제
		//addressDao.addressDelete("guard1");
		//주소 전제보기
		//System.out.println(addressDao.addressfindAll());
		//멤버 한 사람의 주문 건당 주문 주소 확인
		System.out.println(addressDao.findAddressOrder("guard1"));

	}

}
