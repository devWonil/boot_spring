package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class APIController {

	// URL : 자원 요청하는 주소 체계방식
	// URI : 식별자 방식

	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}

	// path-variable 방식

	// get --> URI 방식 사용 (데이터를 담아서 요청) // 처리하고 // 응답가능
	// http://localhost:9090/api/get/path-variable/[xxx]
	@GetMapping(path = "/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {

		System.out.println("브라우저에서 들어온 값을 받음 : " + name);
		return "[[" + name + "]]";
	}

	// http://localhost:9090/api/get/path-variable/[xxx]

	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name") String name, @PathVariable(name = "age") int age) {

		System.out.println("name : " + name);
		System.out.println("age : " + age);

		return "name : " + name + "age : " + age;

	}
	
	// 문제1 새로운 주소 만들어서 요청 응답 (인자값 하나)
	@GetMapping(path = "/path-variable2/{id}")
	public String queryParam3(@PathVariable(name = "id") String id) {
		System.out.println("당신의 id : " + id);
		return "id : " + id;
	}
	
	// 문제2 새로운 주소 만들어서 요청 응답 (인자값 두개)
}
