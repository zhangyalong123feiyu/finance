package com.bibinet.finance.model.basemodel;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.modelimple.FragmentHomeModelImp;
import com.bibinet.finance.utils.MyCallBack;

import java.util.List;

/**
 * Created by bibinet on 2017-4-20.
 */

public interface FragmentBankModel {
    void loadData(String url, int page , FragmentBankModelListioner listioner);

    public interface FragmentBankModelListioner{
        void onSucess(List<SocailBean.SocailInfo> socailinfo);
        void onFailed(String error);
    }
}
