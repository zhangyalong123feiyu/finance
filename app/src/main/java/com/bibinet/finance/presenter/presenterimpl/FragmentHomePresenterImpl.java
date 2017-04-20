package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.bean.StudentBean;
import com.bibinet.finance.model.modelimple.FragmentHomeModelImp;
import com.bibinet.finance.presenter.basepresenter.FragmentHomePresenter;
import com.bibinet.finance.view.FragmentHomeView;

/**
 * Created by bibinet on 2017-4-19.
 */

public class FragmentHomePresenterImpl implements FragmentHomePresenter {
   private FragmentHomeModelImp fragmentHomeModelImp;
    private FragmentHomeView fragmentHomeView;
    public FragmentHomePresenterImpl( FragmentHomeView fragmentHomeView) {
        this.fragmentHomeModelImp = new FragmentHomeModelImp();
        this.fragmentHomeView = fragmentHomeView;
    }

    @Override
    public void LoadData(String url) {
    fragmentHomeModelImp.loadData(url, new FragmentHomeModelImp.OnLoadFragmenetHomeListioner() {
        @Override
        public void onSucess(StudentBean students) {
            fragmentHomeView.showData(students);
        }

        @Override
        public void onFailed(String string) {

        }
    });
    }
}
