package com.bibinet.finance.model.basemodel;

import com.bibinet.finance.bean.SocailBean;

import java.util.List;

/**
 * Created by bibinet on 2017-4-21.
 */

public interface FragmentMoreModel {
    void loadData(String url,int page,FragmentMoreModelListioner listioner);
    interface FragmentMoreModelListioner{
        void onSucess(List<SocailBean.SocailInfo> socailInfos);
        void onFailed(String error);
    }
}
