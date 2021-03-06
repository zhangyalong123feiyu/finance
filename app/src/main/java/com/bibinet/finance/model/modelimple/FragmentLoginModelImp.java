package com.bibinet.finance.model.modelimple;

import com.bibinet.finance.bean.LoginResultBean;
import com.bibinet.finance.constant.Constants;
import com.bibinet.finance.constant.ProjectUrl;
import com.bibinet.finance.model.basemodel.FragmentLoginModel;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.utils.MyCallBack;
import com.bibinet.finance.utils.SharedPresUtils;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by bibinet on 2017-5-2.
 */

public class FragmentLoginModelImp implements FragmentLoginModel {
    @Override
    public void Longin(String mobileNum, String passWord,final OnLoginListioner listioner) {
        RequestParams requestParams=new RequestParams("http://192.168.1.63:8080/finance/app/doLogin.json");
        requestParams.addBodyParameter("account",mobileNum);
        requestParams.addBodyParameter("password",passWord);
        x.http().post(requestParams, new MyCallBack(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Gson gson=new Gson();
                LoginResultBean LoginInfo = gson.fromJson(s, LoginResultBean.class);

                listioner.onLoginSucess(LoginInfo);
                LogUtils.getLogInstance().logMessage(s+"-----------------");
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
            }
        });
    }
}
