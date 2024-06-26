package com.learn.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public String message;

    public ResourceNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
