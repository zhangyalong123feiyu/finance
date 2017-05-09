package com.bibinet.finance.model.modelimple;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.basemodel.GuarnteeApplayModel;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.utils.MyCallBack;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;

/**
 * Created by bibinet on 2017-5-9.
 */

public class GuaranteeApplayModelImp implements GuarnteeApplayModel {
    @Override
    public void upLoadPic(File file, int type, final OnUpLoadDPicListioner listioner) {
        RequestParams requestParams=new RequestParams("192.168.1.63:8080/finance/file/uploadCertificateFile.json");
        requestParams.addBodyParameter("type","1");
        requestParams.addBodyParameter("request",file);
        x.http().get(requestParams, new MyCallBack(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Gson gson=new Gson();
//                SocailBean socailBeanInfo = gson.fromJson(s, SocailBean.class);
//                List<SocailBean.SocailInfo> socailInfos=socailBeanInfo.getNewslist();
                LogUtils.getLogInstance().logMessage(s+"picjson");
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
//                listioner.onFailed(throwable.getMessage());
                LogUtils.getLogInstance().logMessage(throwable.getMessage()+"picerror");
            }
        });
    }

}
