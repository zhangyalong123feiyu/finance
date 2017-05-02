package com.bibinet.finance.model.modelimple;

import android.content.Context;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.basemodel.FragmentBankModel;
import com.bibinet.finance.utils.HttpUtils;
import com.bibinet.finance.utils.MyCallBack;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bibinet on 2017-4-20.
 */

public class FragmentBankModelImp implements FragmentBankModel {


    @Override
    public void loadData(String url, int page, final FragmentBankModelListioner listioner) {
//        RequestParams requestParams=new RequestParams(url);
//        requestParams.addBodyParameter("key","f970d00798f1c3566388bf4af2fa6bac");
//        requestParams.addBodyParameter("page", String.valueOf(page));
//        requestParams.addBodyParameter("num","10");
        HashMap map=new HashMap();
        map.put("key","f970d00798f1c3566388bf4af2fa6bac");
        map.put("page", String.valueOf(page));
        map.put("num","10");
/*        x.http().get(requestParams,new MyCallBack(){
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
        });*/
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.getMethod(url,map,new MyCallBack(){
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
