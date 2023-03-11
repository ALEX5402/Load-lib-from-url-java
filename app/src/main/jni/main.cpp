#include <jni.h>
#include "obfuscate.h"


extern "C"
JNIEXPORT jstring JNICALL
Java_com_alex_libonlione_loder_link(JNIEnv *env, jobject thiz) {
    return (*env).NewStringUTF(OBFUSCATE("https//link.so"));
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_alex_libonlione_loder_libname(JNIEnv *env, jobject thiz) {
    return (*env).NewStringUTF(OBFUSCATE("libname.so"));
}