package com.myt.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class AppExceptionalHandler {
    Logger logger = LoggerFactory.getLogger(AppExceptionalHandler.class);
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleException(ConstraintViolationException e) {
        logger.info("AppExceptionalHandler : ConstraintViolationException");
    }
}
