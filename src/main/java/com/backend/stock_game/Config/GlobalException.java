package com.backend.stock_game.Config;

import com.backend.stock_game.Config.Exception.ExceptionResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ExceptionResolver.class)
    public ResponseEntity<String> handleException(Exception ex){

        System.out.println("Global Exception for "+ex.getClass());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleBodyException(Exception ex){

        System.out.println("Response Body Exception for "+ex.getClass());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
