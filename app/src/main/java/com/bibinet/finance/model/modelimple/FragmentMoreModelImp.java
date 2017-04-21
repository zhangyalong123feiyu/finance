package com.bibinet.finance.model.modelimple;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.basemodel.FragmentMoreModel;
import com.bibinet.finance.utils.MyCallBack;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by bibinet on 2017-4-21.
 */

public class FragmentMoreModelImp implements FragmentMoreModel {
    @Override
    public void loadData(String url, int page, final FragmentMoreModelListioner listioner) {
        RequestParams requestParams=new RequestParams(url);
        requestParams.addBodyParameter("key","");
        requestParams.addBodyParameter("num","10");
        requestParams.addBodyParameter("page","");
        x.http().get(requestParams, new MyCallBack(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Gson gson=new Gson();
                SocailBean socailBeanInfo = gson.fromJson(s, SocailBean.class);
                List<SocailBean.SocailInfo> socailInfos=socailBeanInfo.getNewslist();
                listioner.onSucess(socailInfos);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
                listioner.onFailed(throwable.getMessage());
            }
        });
    }
}
