//
// Created by bibinet on 2017-5-5.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
/*
jstring返回值
Java_com_fcy_administrator_jnidemo_JNI_getStringFromNative        Java_类名_方法名
JNENV* env上下文
jobject jobj谁调用 了这个方法就是谁的实例 当前就是JNI.this
*/
jstring  Java_com_bibinet_finance_constant_JNI_getSerVerUrl(JNIEnv* env,jobject jobj){
    char* text="http://192.168.1.63:8080/app/";
    (*env)->NewStringUTF(env,text);
}
