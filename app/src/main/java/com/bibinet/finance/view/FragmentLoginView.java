package com.bibinet.finance.view;

import com.bibinet.finance.bean.LoginResultBean;

/**
 * Created by bibinet on 2017-5-2.
 */

public interface FragmentLoginView extends BaseView {
    void showData(LoginResultBean loginResultBean);
    void showLoadFailed(String messge);
}
