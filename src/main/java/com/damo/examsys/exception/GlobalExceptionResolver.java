package com.damo.examsys.exception;

import com.damo.examsys.common.JsonBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(MyException.class)
    public JsonBean myException(MyException ex){
        return new JsonBean(ex.getCode(), ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public JsonBean commonException(Exception ex){
        return new JsonBean(500, ex.getMessage());
    }

}
