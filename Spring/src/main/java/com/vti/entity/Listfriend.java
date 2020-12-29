package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Listfriend", catalog = "CRUD")
public class Listfriend implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "`Name`", length = 50, nullable = false, unique = true)
	private String name;
	@Column(name = "Address", length = 50, nullable = false)
	private String address;
	@Column(name = "City", length = 50, nullable = false)
	private String city;
	@Column(name = "`Pin Code`", length = 50, nullable = false)
	private String pincode;
	@Column(name = "AGE",precision = 100 , nullable = false)
	private int age;
	

	public Listfriend() {
	}


	public Listfriend(String name, String address, String city, String pincode, int age) {
	
		this.name=name;
		this.address=address;
		this.city=city;
		this.pincode=pincode;
		this.age=age;
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Listfriend [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", age=" + age + "]";
	}


}
