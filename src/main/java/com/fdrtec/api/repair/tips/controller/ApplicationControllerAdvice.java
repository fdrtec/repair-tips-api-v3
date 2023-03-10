package com.fdrtec.api.repair.tips.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fdrtec.api.repair.tips.exception.BusinessRuleException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(NotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleBusinessException( BusinessRuleException ex) {
        return  ex.getLocalizedMessage();
    }
    
}
