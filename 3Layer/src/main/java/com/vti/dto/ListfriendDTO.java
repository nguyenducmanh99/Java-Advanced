package com.vti.dto;

import com.vti.entity.Listfriend;

public class ListfriendDTO {
	private String name;
	private String address;
	private String city;
	private String pincode;
	private int age;
	
	
	

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
