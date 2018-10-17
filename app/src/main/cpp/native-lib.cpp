#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_zy_chart_jni_NDKTestActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT void JNICALL
Java_com_zy_chart_jni_NDKTestActivity_swap(JNIEnv *env, jobject instance, jstring a_, jstring b_) {
    const char *a = env->GetStringUTFChars(a_, 0);
    const char *b = env->GetStringUTFChars(b_, 0);

    // TODO

    env->ReleaseStringUTFChars(a_, a);
    env->ReleaseStringUTFChars(b_, b);
}