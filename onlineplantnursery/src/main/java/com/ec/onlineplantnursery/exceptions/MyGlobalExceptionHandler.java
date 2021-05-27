package com.ec.onlineplantnursery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidResourceInputByUser(ResourceNotFoundException ex) {
		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Resources, pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidSeedId(SeedIdNotFoundException ex) {
		int sid = ex.getId();
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid Seed Id"+sid+" doesn't exist , pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidOrderIdException(OrderIdNotFoundException ex) {
		int id = ex.getId();		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setExceptionMsg("Invalid OrderId "+id+" doesn't exist , pls try again");
		
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}

}
