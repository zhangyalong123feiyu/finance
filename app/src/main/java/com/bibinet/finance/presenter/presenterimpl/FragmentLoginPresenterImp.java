package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.model.basemodel.FragmentLoginModel;
import com.bibinet.finance.model.modelimple.FragmentLoginModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentLoginPresenter;
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
    public void onLoadData(String numberphone,String deveCode,String accountTyepe){
        fragmentLoginModelImp.Longin(numberphone, deveCode, accountTyepe, new FragmentLoginModel.OnLoginListioner() {
            @Override
            public void onLoginSucess() {
                fragmentLoginView.showData();
            }

            @Override
            public void onLoginFailed(String messge) {
                fragmentLoginView.showLoadFailed(messge);
            }
        });

    }
}
