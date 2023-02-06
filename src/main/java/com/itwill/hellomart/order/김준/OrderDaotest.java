package com.itwill.hellomart.order.김준;

import java.sql.Date;
import java.util.ArrayList;



public class OrderDaotest {

	public static void main(String[] args) throws Exception {
		OrderDao orderDao = new OrderDao();
//주문	
//		orderDao.insert(new Order(0, null, "..", "..", 0, "guard1"));
		
//1개 삭제
//		orderDao.deleteByOrderNo(4);

//주문 조회
		System.out.println(orderDao.findOrderByUserId("guard1"));
		
//주문 상세 조회
		System.out.println(orderDao.findOrderWithOrderItemByUserId("guard1"));
//
		
	}

}
