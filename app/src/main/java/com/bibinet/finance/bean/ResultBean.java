package com.bibinet.finance.bean;

/**
 * Created by bibinet on 2017-5-15.
 */
/*登录成功base接口*/
public class ResultBean {
    private String resCode;
    private String resMessage;
    private String modelAndView;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public String getModelAndView() {
        return modelAndView;
    }

    public void setModelAndView(String modelAndView) {
        this.modelAndView = modelAndView;
    }
}
