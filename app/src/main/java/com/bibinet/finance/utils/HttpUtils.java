package com.bibinet.finance.utils;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/4/23.
 */

public class HttpUtils {

    public void getMethod(String url, HashMap<String ,Object> map,MyCallBack myCallBack){
        RequestParams requestParams=new RequestParams(url);
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            requestParams.addBodyParameter(entry.getKey(),String.valueOf(entry.getValue()));
        }
        x.http().get(requestParams,myCallBack);
    }
    public void postMethod(String url,HashMap<String,Object> map,MyCallBack myCallBack){
        RequestParams requestParams=new RequestParams(url);
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            requestParams.addBodyParameter(entry.getKey(),String.valueOf(entry.getValue()));
        }
        x.http().get(requestParams,myCallBack);
    }
}
