// Native methods implementation of
// Z:/hoai.phamxuan/Java/Workspace/test_native/src/test1/Test1.java

#include "Test1.h"
#include <iostream>
#include <string>

jdouble JNICALL Java_test1_Test1_multiple
(JNIEnv * env, jobject object, jdouble param1, jdouble param2) {
    return param1 * param2;
}

void JNICALL Java_test1_Test1_sayHi
(JNIEnv * env, jclass object) {

}

void JNICALL Java_test1_Test1_sayHiToMe
(JNIEnv * env, jclass object) {
}

jstring JNICALL Java_test1_Test1_initLegal
(JNIEnv * env, jobject object, jstring string) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}