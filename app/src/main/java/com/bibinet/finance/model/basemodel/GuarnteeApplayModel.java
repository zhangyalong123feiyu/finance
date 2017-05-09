package com.bibinet.finance.model.basemodel;

import java.io.File;

/**
 * Created by bibinet on 2017-5-9.
 */

public interface GuarnteeApplayModel {
    void upLoadPic(File file,int type,OnUpLoadDPicListioner listioner);
    interface OnUpLoadDPicListioner{
        void onUpLoadSucess();
        void onUpLoadFailed();
    }
}
