// Native methods implementation of
// Z:/hoai.phamxuan/Java/Workspace/test_native/src/test1/Test1.java

#include "Test1.h"
#include <iostream>

using namespace std;

/*
 * Class:     test1_Test1
 * Method:    sayHi
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_test1_Test1_sayHi
  (JNIEnv *jvm, jclass Test1_class) {
    cout << "Hello from C++ with sayHi function" << endl;
}

/*
 * Class:     test1_Test1
 * Method:    sayHiToMe
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_test1_Test1_sayHiToMe
  (JNIEnv *jvm, jclass Test1_class) {
    cout << "Hello from C++ with sayHiToMe function" << endl;
}