#include <jni.h>
#include <string>





extern "C"
JNIEXPORT jint JNICALL
Java_com_zy_chart_jni_NDKTestActivity_addNum(JNIEnv *env, jobject instance) {

    //获取实例对应的 class
    jclass jclazz = env->GetObjectClass(instance);
    //通过class获取相应的变量的 field id
    jfieldID fid = env->GetFieldID(jclazz, "num", "I");
    //通过 field id 获取对应的值
    jint num = env->GetIntField(instance, fid);  //注意，不是用 jclazz, 使用 jobj
    num++;
    return num;

}