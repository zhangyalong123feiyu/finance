package com.bibinet.finance.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by bibinet on 2017-4-19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
