package com.itwill.hellomart.cart;

import java.util.List;

public class CartDaoTestMain {
	public static void main(String[] args) throws Exception {

		CartDao cartDao = new CartDao();

		System.out.println(cartDao.countByProductNo("guard1", 2));
		
		System.out.println(cartDao.insert("guard1", 1, 1));

		System.out.println(cartDao.updateByProductNo("guard1",2,1)); 
		
		System.out.println(cartDao.updateByCartNo(1,3)); 

		System.out.println(cartDao.findByUserId("guard1"));

		System.out.println(cartDao.deleteByCartNo(3)); 
		
		System.out.println(cartDao.deleteByUserId("guard2")); 
		

		Cart cart2 = cartDao.findByCartNo(5);
		List<Cart> cart = cartDao.findByUserId("guard1");
		for(Cart cartList :cart) {
			System.out.println(cartList);
		}

	}
}
