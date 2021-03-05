package com.huangyuan.common.hyexception;

public class HyException extends RuntimeException{

    private String msg;

    public HyException(String msg){
        super();
        this.msg = msg;
    }

}
