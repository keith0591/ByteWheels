package com.bytemark.bytewheels.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bytemark.bytewheels.dto.ErrorDto;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(IllegalArgumentException.class)
	 public ResponseEntity < ? > notFoundException(final IllegalArgumentException e) throws JSONException {
//		JSONObject object=new JSONObject();
		ErrorDto dto = new ErrorDto();
		dto.setError(e.getMessage());
        return new ResponseEntity<> (dto, HttpStatus.BAD_REQUEST);
    }
	
	
}
