// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("samplejni");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("samplejni")
//      }
//    }

#include <jni.h>
#include <string>
#include <iostream>

extern "C"
JNIEXPORT jint JNICALL
Java_com_gameloft_samplejni_MainActivity_getInit(JNIEnv *env, jobject thiz) {
    return 10;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_gameloft_samplejni_MainActivity_getText(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("Hello From C++");
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_gameloft_samplejni_MainActivity_addThree(JNIEnv *env, jobject thiz, jdouble a, jdouble b,
                                                  jdouble c) {
    return a + b + c;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_gameloft_samplejni_MainActivity_add__DD(JNIEnv *env, jobject thiz, jdouble a, jdouble b) {
    return a + b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_gameloft_samplejni_MainActivity_add__DDD(JNIEnv *env, jobject thiz, jdouble a, jdouble b, jdouble c) {
    return a + b + c;
}