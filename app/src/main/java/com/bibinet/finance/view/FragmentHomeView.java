package com.bibinet.finance.view;

import com.bibinet.finance.bean.StudentBean;

import java.util.List;

/**
 * Created by bibinet on 2017-4-19.
 */

public interface FragmentHomeView extends BaseView{
        void showData(StudentBean bean);
        void showLoadFailed();
}
