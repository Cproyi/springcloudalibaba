package com.huangyuan.userservice.modules.user.entity;

public class TUserExt extends TUser{

    //假定的在其他表中的数据
    private String extMsg;

    public String getExtMsg() {
        return extMsg;
    }

    public void setExtMsg(String extMsg) {
        this.extMsg = extMsg;
    }

    @Override
    public String toString() {
        return super.toString() + "TUserExt{" +
                "extMsg='" + extMsg + '\'' +
                '}';
    }
}
