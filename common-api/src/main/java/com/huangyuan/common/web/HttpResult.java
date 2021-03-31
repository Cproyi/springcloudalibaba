package com.huangyuan.common.web;

/**
 * http restful请求结果封装
 */
public class HttpResult<T> {

    private String msg;

    private Integer code;

    private T data;

    public HttpResult(){

    }

    public HttpResult(T data){
        this("操作成功",0,data);
    }

    public HttpResult(String msg){
         this(msg,0,null);
    }

    public HttpResult(String msg,Integer code){
        this(msg,code,null);
    }

    public HttpResult(String msg, T data){
        this(msg,0,data);
    }

    public HttpResult(String msg, Integer code, T data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static<T> HttpResult<T> error(String msg){
        return new HttpResult<T>(msg,-1);
    }

    public static <T> HttpResult<T> error(String msg,T data){
        return new HttpResult<T>(msg,-1,data);
    }

    public static<T> HttpResult<T> success(T data){
        return new HttpResult<T>(data);
    }

    public static HttpResult success(){
        return HttpResult.success(null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
