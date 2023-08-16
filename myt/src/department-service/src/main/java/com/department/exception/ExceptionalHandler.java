package com.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionalHandler {
    @ExceptionHandler(DepartmentException.class)
    public ResponseEntity<Map<String,String>> hendleDepartmentException(DepartmentException e) {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("message :", e.getMessage());


        return ResponseEntity.internalServerError().body(errorMap);
    }
}
