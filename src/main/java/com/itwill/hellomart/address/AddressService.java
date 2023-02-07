package com.itwill.hellomart.address;

import java.util.List;

public class AddressService {
	private AddressDao addressDao;
	
	public AddressService () throws Exception{
		addressDao=new AddressDao();
	}
	public int addressInsert(Address address) throws Exception{
		return addressDao.addressInsert(address);
	}
	public int addressUpdate(Address address) throws Exception{
		return addressDao.addressUpdate(address);
	}
	public int addressDelete(String userid) throws Exception{
		return addressDao.addressDelete(userid);
	}
	public List<Address> addressfindAll() throws Exception{
		return addressDao.addressfindAll();
	}
}
