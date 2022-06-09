package com.example.demo10.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private String name;
	private Integer age;
	private String url;
	
	// 샘플데이터
	public static List<User> sampleUser(){
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동", 11, "http://localhost:9090/cat.jpg"));
		list.add(new User("홍길동", 12, "http://localhost:9090/cat.jpg"));
		list.add(new User("홍길동", 13, "http://localhost:9090/cat.jpg"));
		list.add(new User("홍길동", 14, "http://localhost:9090/cat.jpg"));
		return list;
	}
}
