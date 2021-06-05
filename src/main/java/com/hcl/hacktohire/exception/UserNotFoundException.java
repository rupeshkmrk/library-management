package com.hcl.hacktohire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundException extends RuntimeException {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Error> exception(UserNotFoundException exception) {
        Error error = new Error();
        error.setMessage("User not found");
        error.setCode(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
