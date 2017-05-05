package com.bibinet.finance.constant;

/**
 * Created by bibinet on 2017-5-5.
 */

public class JNI {
    static {
        System.loadLibrary("Finance");
    }
    public static native String getSerVerUrl();
}
