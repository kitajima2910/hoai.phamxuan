// Native methods implementation of
// Z:/hoai.phamxuan/Java/Workspace/native/src/test/TestOverloading.java

#include "TestOverloading.h"

jdouble JNICALL Java_test_TestOverloading_func__D
  (JNIEnv * env, jobject object, jdouble param1) {
    return param1;
}

jdouble JNICALL Java_test_TestOverloading_func__DD
  (JNIEnv * env, jobject object, jdouble param1, jdouble param2) {
    return param1;
}

jdouble JNICALL Java_test_TestOverloading_func__DLjava_lang_String_2
  (JNIEnv * env, jobject object, jdouble param1, jstring param2) {
    return param1;
}
