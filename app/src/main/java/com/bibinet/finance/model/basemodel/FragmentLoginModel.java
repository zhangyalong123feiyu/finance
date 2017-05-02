package com.bibinet.finance.model.basemodel;

/**
 * Created by bibinet on 2017-5-2.
 */

public interface FragmentLoginModel {
    void Longin(String mobileNum,String deveceCode,String accountType,OnLoginListioner listioner);
    interface OnLoginListioner{
        void onLoginSucess();
        void onLoginFailed(String messge);
    }
}
