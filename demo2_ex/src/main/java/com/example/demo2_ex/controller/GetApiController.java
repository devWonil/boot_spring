package com.example.demo2_ex.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2_ex.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	// http://localhost:9091/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say Hello";
	}

	// path-variable 방식
	// http://localhost:9091/api/get/path-variable/[사용자가 보낸값]/[사용자가 보낸값]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam(@PathVariable(name = "name") String name, @PathVariable(name = "age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);

		return name + ", " + age;

	}

	// query parameter 방식 (3가지)

	// 1. key 값을 지정해서 값을 받는 방식
	// http://localhost:9091/api/get/query-param1?name=홍길동&email=ten@naver.com&age=11
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String name, @RequestParam String email, @RequestParam int age) {

		return name + ", " + email + ", " + age;
	}

	// 2. Map 활용 방식
	@GetMapping("query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {

		StringBuffer sb = new StringBuffer();
		data.entrySet().forEach(entry -> {
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		return sb.toString();
	}

	// 3. dto 활용방식
	// 클라이언트 요청 (BufferedWriter 전송) -> (BufferedReader 응답)
	// Annotation 없음
	@GetMapping("query-param3")
	public String queryParam3(UserRequest request) {
		
		return request.toString();
		
	}
	
	@GetMapping("query-param4")
	public String queryParam4(UserRequest request) {
		
		return request.toString();
	}
	
	@GetMapping("query-param5")
	public String queryParam5(UserRequest request) {
		
		return request.toString();
	}
}
