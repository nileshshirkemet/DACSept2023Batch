#include "Legacy.h"
#include "primes.h"

JNIEXPORT jint JNICALL Java_Legacy_countPrimes(JNIEnv*, jclass, jlong first, jlong last)
{
    return primes_count(first, last);
}

int is_favorite(long prime)
{
    return (prime - 1) % 4 == 0;
}

JNIEXPORT jlongArray JNICALL Java_Legacy_selectPrimes(JNIEnv* env, jclass, jlong start, jint count, jboolean all)
{
    jlongArray result;
    jlong* selected = new jlong[count];

    if(all)
    {
        primes_select(start, count, selected, NULL);
    }
    else
    {
        primes_select(start, count, selected, is_favorite);
    }

    result = env->NewLongArray(count);
    env->SetLongArrayRegion(result, 0, count, selected);
    delete[] selected;

    return result;
}
