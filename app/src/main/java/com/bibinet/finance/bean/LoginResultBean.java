package com.bibinet.finance.bean;

import java.io.Serializable;

/**
 * Created by bibinet on 2017-5-3.
 */

public class LoginResultBean implements Serializable{

    /**
     * resultCode : 00000000
     * resultMessage : 成功
     * success : true
     */

    private String resultCode;
    private String resultMessage;
    private boolean success;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
