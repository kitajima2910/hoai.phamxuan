// Native methods implementation of
// Z:/hoai.phamxuan/Java/Workspace/test_native/src/test1/test11/Test2.java

#include "Test2.h"

jdouble JNICALL Java_test1_test11_Test2_times
  (JNIEnv * env, jobject object, jdouble param1, jdouble param2) {
    return param1 * param2;
}
