package com.bibinet.finance.presenter.presenterimpl;

import com.bibinet.finance.model.basemodel.GuarnteeApplayModel;
import com.bibinet.finance.model.modelimple.GuaranteeApplayModelImp;
import com.bibinet.finance.presenter.basepresenter.GuranteeApplayPresenter;
import com.bibinet.finance.view.GuranteApplayView;

import java.io.File;

/**
 * Created by Administrator on 2017/5/9.
 */

public class GuranteeApplayPresenterImp implements GuranteeApplayPresenter {
    private GuaranteeApplayModelImp modelImp;
    private GuranteApplayView guranteApplayView;

    public GuranteeApplayPresenterImp(GuranteApplayView guranteApplayView) {
        this.guranteApplayView = guranteApplayView;
        this.modelImp=new GuaranteeApplayModelImp();
    }

    @Override
    public void UpLoadPic(File file,int type) {
        guranteApplayView.showProgress();
        modelImp.upLoadPic(file, type, new GuarnteeApplayModel.OnUpLoadDPicListioner() {
            @Override
            public void onUpLoadSucess() {
                guranteApplayView.hideProgress();
            }

            @Override
            public void onUpLoadFailed() {
                guranteApplayView.hideProgress();
            }
        });
    }
}
