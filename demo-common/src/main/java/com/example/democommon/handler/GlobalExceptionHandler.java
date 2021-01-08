package com.example.democommon.handler;

import com.example.democommon.entity.ResultData;
import com.example.democommon.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {BusinessException.class})
    public ResultData BusinessHandler(HttpServletRequest request, Exception e) {
        log.info(e.getMessage());
        log.info("IP:{}", request.getRemoteAddr());
        log.info("requestURI:{}", request.getRequestURI());
        log.info("request method:{}", request.getMethod());
        return ResultData.fail("程序异常", e.getMessage());
    }

}
