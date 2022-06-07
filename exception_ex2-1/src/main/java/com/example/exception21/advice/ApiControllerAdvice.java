package com.example.exception21.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception21.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("예외 발생");
		System.out.println("===============");
		System.out.println(e.getClass());
		System.out.println("===============");
		System.out.println(e.getMessage());
		System.out.println("===============");
		System.out.println(e.getCause());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	// 예외 발생 및 처리 get 방식일 때 파라미터 없을 경우 발생
	// MissingServletRequestParameterException
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("MissingServletRequestParameterException 동작");
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		System.out.println("fieldName : " + fieldName);
		System.out.println("fieldType : " + fieldType);
		System.out.println("invalidValue : " + invalidValue);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "을 입력하세요");
	}
	
	// POST 방식
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("MethodArgumentNotValidException 예외 발생");
		
		// 한 번에 전부 들어온다
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			// action
			FieldError field = (FieldError) action;
			
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	// GET 방식
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e){
		// 동시에 확인 validation
		System.out.println("ConstraintViolationException 예외 발생");
		List<CustomError> errorList = new ArrayList<>();
		
		e.getConstraintViolations().forEach(error -> {
			String strField = error.getPropertyPath().toString();
			int index = strField.indexOf(".");
			
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
}
