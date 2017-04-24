package com.bibinet.finance.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by bibinet on 2017-4-24.
 */

public class LogUtils {
    private static LogUtils logUtils=null;
    private boolean isTest=true;
    private LogUtils(){
    }
    public synchronized static LogUtils getLogInstance(){
        if (logUtils==null)
            logUtils=new LogUtils();
        return logUtils;
    }
    public void logMessage(String msg){
        if (isTest)
        Log.i("TAG",msg );
    }
}
