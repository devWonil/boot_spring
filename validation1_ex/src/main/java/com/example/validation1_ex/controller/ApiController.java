package com.example.validation1_ex.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1_ex.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// post 방식 처리에 대한 @Valid 확인 (반드시 @Valid 지정해줘야한다)
	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult){
		
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();
				
				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);
				
				sb.append("field : " + field.getField() + "\n");
				sb.append("message : " + message + "\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		System.out.println(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
