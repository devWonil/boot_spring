package com.example.validation1_ex.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {

	@NotBlank(message = "이름을 입력하세요")
	private String name;

	@Max(value = 90, message = "나이를 잘 못 입력했어요")
	@Min(value = 9, message = "나이를 잘 못 입력했어요")
	private int age;
	
	@Email
	private String email;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
