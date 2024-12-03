package com.hphd.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private int code;
    private String message;
    private  Object data;

    //返回正确的数据
    public static ResponseDTO success(Object data){
        ResponseDTO dto =new ResponseDTO();
        dto.setCode(0);
        dto.setData(data);
        return dto;
    }
    //返回错误的数据
    public static ResponseDTO error(Integer code,String message){
        ResponseDTO dto =new ResponseDTO();
        dto.setCode(code);
        dto.setMessage(message);
        return dto;
    }
}
