#pragma once
#ifdef __cplusplus
extern "C" {
#endif

int primes_count(long first, long last);
long primes_select(long start, int count, long* selected, int (*selector)(long));

#ifdef __cplusplus
}
#endif

