package com.bibinet.finance.presenter.presenterimpl;

import android.os.Handler;
import android.widget.Toast;

import com.bibinet.finance.bean.LoginResultBean;
import com.bibinet.finance.model.basemodel.FragmentLoginModel;
import com.bibinet.finance.model.modelimple.FragmentLoginModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentLoginPresenter;
import com.bibinet.finance.utils.ProgressDialogUtils;
import com.bibinet.finance.utils.ToastUtils;
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
        delay_operation(5000);
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
    public void delay_operation(long time)
    {
        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
               fragmentLoginView.hideProgress();//隐藏对话框
            }
        }, time);
    }
}
