package com.itwill.hellomart.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.hellomart.cart.Cart;
import com.itwill.hellomart.cart.CartDao;
import com.itwill.hellomart.product.Product;
import com.itwill.hellomart.product.ProductDao;

public class OrderService {
	
	
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	
	public OrderService() throws Exception {
		orderDao = new OrderDao();
		productDao = new ProductDao();
		cartDao = new CartDao();
	}
		//로그인 회원의 주문 1건 삭제
		public int deleteByOrderNo(int o_no) throws Exception {
			return orderDao.deleteByOrderNo(o_no);
		}
		//로그인 회원의 전체 주문 삭제
		public int deleteBysUserId(String sUserId) throws Exception {
			return orderDao.deleteByUserId(sUserId);
		}
		//로그인 회원 주문 목록 
		public List<Order> findOrderByUserId(String sUserId) throws Exception {
			return orderDao.findOrderByUserId(sUserId);
		}
		//주문 + 주문 아이템 목록
		public List<Order> findOrderWithOrderItemByUserId (String sUserId) throws Exception {
			return orderDao.findOrderWithOrderItemByUserId(sUserId);
		}
		/*
		 * 주문+주문아이템 [상세보기]
		 */
		public Order orderWithOrderItem(int o_no)throws Exception{
			return orderDao.findByOrderNo(o_no);
		}
		
		//상품에서 직접 주문
		public int createDirectOrder(String sUserId, int p_no, int oi_qty) throws Exception {
			Product product = productDao.findByPrimaryKey(p_no);
			OrderItem orderItem = new OrderItem(0, oi_qty, p_no, product);
			ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
			orderItemList.add(orderItem);
			//o_no , date, o_status , o_option o_price, sUSerId
			Order newOrder = 
							new Order(0, null, null, null, 
										orderItemList.get(0).getOi_qty()*orderItemList.get(0).getProduct().getP_price(),
										sUserId);
			newOrder.setOrderItemList(orderItemList);
			return orderDao.insert(newOrder);
		}
		
		//장바구니에서 전체 주문
		public int createCartOrder (String sUserId) throws Exception {
			
			List <Cart> cartList = cartDao.findByUserId(sUserId);
			ArrayList<OrderItem> orderItemList = new ArrayList <OrderItem>();
			int o_tot_price = 0;
			//장바구니에 담긴 상품을 orderList에 담기
			for(Cart cart : cartList) {
				OrderItem orderItem = new OrderItem(0,cart.getCart_qty(),0,cart.getProduct());
				orderItemList.add(orderItem);
				o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			}
			//o_no , date, o_status , o_option o_price, sUSerId
			Order newOrder = new Order(0,null,null,null,o_tot_price,sUserId);
			newOrder.setOrderItemList(orderItemList);
			orderDao.insert(newOrder);
			cartDao.deleteByUserId(sUserId);
			
			return 0;
			
		}
		
		//장바구니에서 선택주문
		public int createCartChoiceOrder(String sUserId, String[] cart_item_noStr_array) throws Exception {
			ArrayList <OrderItem> orderItemList = new ArrayList<OrderItem>();
			int o_tot_price = 0; // 전체금액
			for (int i=0; i<cart_item_noStr_array.length; i++) {
				Cart cartItem = cartDao.findByCartNo(Integer.parseInt(cart_item_noStr_array[i]));
				OrderItem orderItem = new OrderItem(0,cartItem.getCart_qty(),0,cartItem.getProduct());
				orderItemList.add(orderItem);
				o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			}
			Order newOrder = new Order(0,null,"배송 전",null,o_tot_price,sUserId);
			newOrder.setOrderItemList(orderItemList);
			orderDao.insert(newOrder);
			
			for(int i=0; i<cart_item_noStr_array.length; i++) {
				cartDao.deleteByCartNo(Integer.parseInt(cart_item_noStr_array[i]));
			}
			return 0;
			
		}
		
}


