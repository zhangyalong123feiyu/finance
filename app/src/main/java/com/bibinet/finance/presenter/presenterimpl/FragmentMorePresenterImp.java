package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.model.basemodel.FragmentMoreModel;
import com.bibinet.finance.model.modelimple.FragmentMoreModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentBankPresenter;
import com.bibinet.finance.view.FragmentMoreView;

import java.util.List;

/**
 * Created by bibinet on 2017-4-21.
 */

public class FragmentMorePresenterImp implements FragmentBankPresenter {
    private FragmentMoreModelImp fragmentMoreModelImp;
    private FragmentMoreView fragmentMoreView;
    private boolean isLoadMore;
    public FragmentMorePresenterImp(FragmentMoreView fragmentMoreView,boolean isLoadmore) {
        this.fragmentMoreView = fragmentMoreView;
        fragmentMoreModelImp=new FragmentMoreModelImp();
        this.isLoadMore=isLoadmore;
    }

    @Override
    public void LoadData(String url, int page) {
        fragmentMoreModelImp.loadData(url, page, new FragmentMoreModel.FragmentMoreModelListioner() {
            @Override
            public void onSucess(List<SocailBean.SocailInfo> socailInfos) {
                fragmentMoreView.showData(socailInfos,isLoadMore);
            }

            @Override
            public void onFailed(String error) {
                fragmentMoreView.showLoadFailed(error);
            }
        });
    }
}
