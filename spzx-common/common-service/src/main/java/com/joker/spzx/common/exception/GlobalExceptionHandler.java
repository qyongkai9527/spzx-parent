package com.joker.spzx.common.exception;

import com.joker.spzx.model.vo.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.build(null, 201, "出现了异常");
    }

    @ExceptionHandler(value = ServiceException.class)     // 处理自定义异常
    public Result<String> error(ServiceException exception) {
        exception.printStackTrace();
        return Result.build(exception.getMessage() , exception.getResultCodeEnum()) ;
    }
}