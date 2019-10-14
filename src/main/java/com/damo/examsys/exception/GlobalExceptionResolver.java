package com.damo.examsys.exception;

import com.damo.examsys.common.ExceptionResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(MyException.class)
    public ExceptionResult myException(MyException ex){
        return new ExceptionResult(ex.getCode(), ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ExceptionResult commonException(Exception ex){
        return new ExceptionResult(500, ex.getMessage());
    }

}
