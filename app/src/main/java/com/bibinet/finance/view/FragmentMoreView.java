package com.bibinet.finance.view;

import com.bibinet.finance.bean.SocailBean;

import java.util.List;

/**
 * Created by bibinet on 2017-4-21.
 */

public interface FragmentMoreView extends BaseView {
    void showData(List<SocailBean.SocailInfo> socailInfos,boolean isLoadMore);
    void showLoadFailed(String error);
}
