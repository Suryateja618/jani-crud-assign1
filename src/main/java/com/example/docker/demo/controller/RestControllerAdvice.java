package com.example.docker.demo.controller;

import com.example.docker.demo.exception.DuplicateEmailException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> uniqueEmailViolationException() {
		return new ResponseEntity<String>("error - duplicate email entered", HttpStatus.BAD_REQUEST);
	}
}
