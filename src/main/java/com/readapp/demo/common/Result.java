package com.readapp.demo.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Boolean success;

    private String errCode;

    private String errMsg;

    private T module;

    public Result<T> ok(T module) {
        this.setSuccess(true);
        this.setErrCode("0");
        this.setErrCode("ok");
        this.setModule(module);
        return this;
    }

    public Result<T> error(String errCode, String errMsg) {
        this.setSuccess(false);
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
        return this;
    }

    public Result<T> error2Msg(String errMsg) {
        this.setSuccess(false);
        this.setErrCode("-1");
        this.setErrMsg(errMsg);
        return this;
    }

}
