package com.learn.employeeservice.exceptions;


import jakarta.annotation.Resource;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidValidationException extends RuntimeException{

   public InvalidValidationException(String message){
        super(message);
    }
}
