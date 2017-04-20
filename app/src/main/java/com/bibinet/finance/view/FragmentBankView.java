package com.bibinet.finance.view;

import com.bibinet.finance.bean.SocailBean;

import java.util.List;

/**
 * Created by bibinet on 2017-4-20.
 */

public interface FragmentBankView extends BaseView {
    void showData(List<SocailBean.SocailInfo> socailBean);
    void showLoadFailed(String error);
}
