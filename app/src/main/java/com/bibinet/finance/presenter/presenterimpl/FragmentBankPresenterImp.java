package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.basemodel.FragmentBankModel;
import com.bibinet.finance.model.modelimple.FragmentBankModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentBankPresenter;
import com.bibinet.finance.view.FragmentBankView;

import java.util.List;

/**
 * Created by bibinet on 2017-4-20.
 */

public class FragmentBankPresenterImp implements FragmentBankPresenter {
    private FragmentBankModelImp fragmentBankModelImp;
    private FragmentBankView fragmentBankView;
    private   boolean isLoadMore;
    public FragmentBankPresenterImp(FragmentBankView fragmentBankView,boolean isLoadMore) {
        fragmentBankModelImp=new FragmentBankModelImp();
        this.fragmentBankView = fragmentBankView;
        this.isLoadMore=isLoadMore;
    }

    @Override
    public void LoadData(String url, int page) {

        fragmentBankModelImp.loadData(url, page, new FragmentBankModel.FragmentBankModelListioner() {
            @Override
            public void onSucess(List<SocailBean.SocailInfo> socailInfo) {
                fragmentBankView.showData(socailInfo,isLoadMore);
                fragmentBankView.hideProgress();
            }

            @Override
            public void onFailed(String error) {
                fragmentBankView.showLoadFailed(error);
            }
        });
    }
}
