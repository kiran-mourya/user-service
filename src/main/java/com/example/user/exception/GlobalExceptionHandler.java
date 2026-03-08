package com.example.user.exception;

import com.example.user.response.ApiResponse;
import com.example.user.response.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleUserAlreadyExists(UserAlreadyExistsException exception, WebRequest request){
        ResultCode resultCode =  new ResultCode(exception.getMessage() + ": "+exception.getUserId(),
                HttpStatus.FOUND.value(),
                "user is already in db with given email id! ",
                exception.getUserId());
        return new ResponseEntity<>(new ApiResponse(resultCode, null), HttpStatus.FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
        // ApiResponse apiResponse = new ApiResponse();
        String cause = exception.getCause() != null ? exception.getCause().toString() : "No cause available";
        ResultCode resultCode =  new ResultCode(exception.getMessage() + ": "+exception.getUserId(),
                HttpStatus.NOT_FOUND.value(),
                cause ,
                exception.getUserId());
        return new ResponseEntity<>(new ApiResponse(resultCode, null), HttpStatus.NOT_FOUND);
    }
}
