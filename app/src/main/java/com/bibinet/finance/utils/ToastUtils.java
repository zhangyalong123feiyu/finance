package com.bibinet.finance.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by bibinet on 2017-5-3.
 */

public class ToastUtils {
    private static ToastUtils toastUtils=new ToastUtils();
    private ToastUtils(){}
    public static ToastUtils getToastUtils(){
        return toastUtils;
    }
    public void ToastMsg(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
