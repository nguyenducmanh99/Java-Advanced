package com.vti.test;

import java.util.List;
import com.vti.entity.Address;
import com.vti.repository.AddressRepository;


public class AddressTest {
	public static void main(String[] arg) {
		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL Address***********");

		List<Address> Addresss = repository.getAllAddresss();
		for (Address address : Addresss) {
			System.out.println(address);
			 
		System.out.println("Tao thanh cong");
		}
 }
}