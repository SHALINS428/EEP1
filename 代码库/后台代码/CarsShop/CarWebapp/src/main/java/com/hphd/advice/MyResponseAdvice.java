package com.hphd.advice;

import cn.hutool.json.JSONUtil;
import com.hphd.dto.ResponseDTO;
import com.hphd.exception.MyException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class MyResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
    @ExceptionHandler
    public Object processException(Exception ex){
        if(ex instanceof  MyException){
            MyException myException= (MyException) ex;
            return ResponseDTO.error(myException.getCode(), ex.getMessage());
        }
       return ResponseDTO.error(996,ex.getMessage());
    }


    @Override
    public Object beforeBodyWrite(Object bady,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(bady instanceof  ResponseDTO){
            return bady;
        }
        ResponseDTO dto =ResponseDTO.success(bady);
        if(aClass == StringHttpMessageConverter.class){
          return  JSONUtil.toJsonStr(dto);
        }


        return dto;
    }
}
