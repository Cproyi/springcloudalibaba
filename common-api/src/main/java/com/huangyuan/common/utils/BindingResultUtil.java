package com.huangyuan.common.utils;

import com.huangyuan.common.web.HttpResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * 对web的参数校验后返回结果的封装
 */
public class BindingResultUtil {

    public static HttpResult getValidateError(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return null;
        }
        Map<String,String> fieldErrors = new HashMap<>();

        for(FieldError fieldError : bindingResult.getFieldErrors()){
            fieldErrors.put(fieldError.getField(),fieldError.getCode() + "||" + fieldError.getDefaultMessage());
        }

        return HttpResult.error("参数错误",fieldErrors);
    }

}
