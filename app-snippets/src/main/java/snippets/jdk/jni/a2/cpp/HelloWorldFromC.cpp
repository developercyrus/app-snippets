#include "stdafx.h"
#include <jni.h>
#include "snippets_jdk_jni_a2_HelloWorld.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL 
Java_snippets_jdk_jni_a2_HelloWorld_fromC (JNIEnv *env, jobject obj) {
    return  env->NewStringUTF("Hello World! This is from C.");
};
