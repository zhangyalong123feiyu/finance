package com.bibinet.finance.model.basemodel;

/**
 * Created by bibinet on 2017-5-3.
 */

public interface FragmentCompanyModel {
    void LoadData(String url);
    interface OnCompanyDataListioner{
        void onSucess();
        void onFailed();
    }
}
