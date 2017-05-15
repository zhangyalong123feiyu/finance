package com.bibinet.finance.model.basemodel;

import com.bibinet.finance.bean.LoginResultBean;

/**
 * Created by bibinet on 2017-5-2.
 */

public interface FragmentLoginModel {
    void Longin(String mobileNum,String passWord,OnLoginListioner listioner);
    interface OnLoginListioner{
        void onLoginSucess(LoginResultBean loginResultBean);
        void onLoginFailed(String messge);
    }
}
