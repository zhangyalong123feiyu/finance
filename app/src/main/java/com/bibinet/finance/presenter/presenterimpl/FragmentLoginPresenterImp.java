package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.bean.LoginResultBean;
import com.bibinet.finance.model.basemodel.FragmentLoginModel;
import com.bibinet.finance.model.modelimple.FragmentLoginModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentLoginPresenter;
import com.bibinet.finance.utils.ProgressDialogUtils;
import com.bibinet.finance.view.FragmentLoginView;

/**
 * Created by bibinet on 2017-5-2.
 */

public class FragmentLoginPresenterImp implements FragmentLoginPresenter {
    private FragmentLoginView fragmentLoginView;
    private FragmentLoginModelImp fragmentLoginModelImp;

    public FragmentLoginPresenterImp(FragmentLoginView fragmentLoginView) {
        this.fragmentLoginView = fragmentLoginView;
        fragmentLoginModelImp=new FragmentLoginModelImp();
    }
    public void onLoadData(String numberphone,String passWrod){
        fragmentLoginView.showProgress();
        fragmentLoginModelImp.Longin(numberphone, passWrod,new FragmentLoginModel.OnLoginListioner() {
            @Override
            public void onLoginSucess(LoginResultBean LoginInfo) {
                fragmentLoginView.showData(LoginInfo);
                fragmentLoginView.hideProgress();
            }
            @Override
            public void onLoginFailed(String messge) {
                fragmentLoginView.showLoadFailed(messge);
                fragmentLoginView.hideProgress();
            }
        });

    }
}
