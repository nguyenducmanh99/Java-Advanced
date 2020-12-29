package com.vti.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.vti.entity.Listfriend;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

public class ListfriendDTO {
	@Null(groups = onCreate.class)
	@NotNull(groups = onUpdate.class)
	
	private String name;
	private String address;
	private String city;
	private String pincode;
	private int age;
	
	
	public ListfriendDTO(String name, String address, String city, String pincode, int age) {
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.age = age;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public ListfriendDTO() {
	}

	public Listfriend toEntity() {
		return new Listfriend (name,address,city,pincode,age);
	}

}
