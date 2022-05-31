package com.example.demo4_ex.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/*
 * {
 * 		"name" : "kkk",
 * 		"age" : 30,
 * 		"phone_number" : "010-1234-5678",
 * 		"address" : "부산시 진구 중앙대로 668"
 * }
 * */
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 내려주고 싶지 않을 때
public class User {

	private String name;
	private String phoneNumber;
	private String address;
	private int age;
	private int idNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", age=" + age
				+ ", idNumber=" + idNumber + "]";
	}

}
