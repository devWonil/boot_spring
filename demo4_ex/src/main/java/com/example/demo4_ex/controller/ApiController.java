package com.example.demo4_ex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4_ex.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// text/plain <- contentType : text/plain
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// application/json
	@PostMapping("/json")
	// request -> Object Mapper -> object -> method
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}
	
	// 200, 202 -> 응답을 돌려 줄때 응답 코드를 지정해서 보낼 수 있다
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
