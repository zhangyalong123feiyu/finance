package com.bibinet.finance.model.modelimple;

import android.widget.Toast;

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
        RequestParams requestParams=new RequestParams("http://192.168.1.63:8080/finance/file/uploadCertificateFile.json");
        requestParams.addBodyParameter("type","1");
        requestParams.addBodyParameter("request",file);
        LogUtils.getLogInstance().logMessage("进来了");
        x.http().post(requestParams, new MyCallBack(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Gson gson=new Gson();
                LogUtils.getLogInstance().logMessage(s+"成功了");
//                SocailBean socailBeanInfo = gson.fromJson(s, SocailBean.class);
//                List<SocailBean.SocailInfo> socailInfos=socailBeanInfo.getNewslist();
                LogUtils.getLogInstance().logMessage(s+"picjson");
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
//                listioner.onFailed(throwable.getMessage());
                LogUtils.getLogInstance().logMessage(throwable.getMessage()+"picerror");
                LogUtils.getLogInstance().logMessage("失败了");
            }
        });
    }

}
