package com.bibinet.finance.model.modelimple;

import com.bibinet.finance.bean.StudentBean;
import com.bibinet.finance.model.basemodel.FragmentHomeModel;
import com.bibinet.finance.utils.MyCallBack;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by bibinet on 2017-4-19.
 */

public class FragmentHomeModelImp implements FragmentHomeModel {
    @Override
    public void loadData(String url, final OnLoadFragmenetHomeListioner listioner) {

        RequestParams requestParams=new RequestParams(url);
        requestParams.addBodyParameter("","");
        x.http().get(requestParams, new MyCallBack(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Gson gson=new Gson();
                StudentBean studentInfo = gson.fromJson(s, StudentBean.class);
                listioner.onSucess(studentInfo);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
                listioner.onFailed(throwable.getMessage());
            }
        });
    }

    public interface OnLoadFragmenetHomeListioner{
        void onSucess(StudentBean students);
        void onFailed(String string);
    }
}
