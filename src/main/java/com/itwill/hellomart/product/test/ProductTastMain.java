package com.itwill.hellomart.product.test;

import com.itwill.hellomart.product.Product;
import com.itwill.hellomart.product.ProductDao;

public class ProductTastMain {

	public static void main(String[] args)throws Exception {
			ProductDao productDao = new ProductDao();
				//상품 보기(번호)
				//System.out.println(productDao.findByPrimartKey(1));
				//상품 보기(전체)
				//System.out.println(productDao.findAll());
				//상품 추가
				//System.out.println(productDao.insert(new Product(0,"컴퓨터",50000,"p.jpg","좋아요",2)));
				//상품 업데이트
				//System.out.println(productDao.update(new Product(10, "냥냥", 3000, "g.jpg", "많이 좋아요", 1)));
				//상품 삭제
				System.out.println(productDao.delete("냥냥"));
				
	}

}
