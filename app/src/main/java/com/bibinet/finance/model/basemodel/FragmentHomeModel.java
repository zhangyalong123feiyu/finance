package com.bibinet.finance.model.basemodel;

import com.bibinet.finance.model.modelimple.FragmentHomeModelImp;

/**
 * Created by bibinet on 2017-4-19.
 */

public interface FragmentHomeModel {
    void loadData(String url, FragmentHomeModelImp.OnLoadFragmenetHomeListioner listioner);
}
