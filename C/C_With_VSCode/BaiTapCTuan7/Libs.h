#include <iostream>
#include <math.h>

using namespace std;

// F1: giải quyết các vấn đề
// F1 = 1 + 2^2/2^1/2 + 3^3/3^1/3 + ... + n^n/n^1/n
double F1(int n) {
  double sum = 0;
  for(int i = 1; i <= n; i++) {
    sum += pow(i * 1.0, i * 1.0) / pow(i * 1.0, 1.0 / i);
  }
  return sum;
}

// F2: giải quyết vấn đề
// F2 = 1 + 2!/(1+2) + 3!/(1+2+3) + ... + n!/(1+2+...+n)
long numerator(int multip, int n) {
  if(n == 1) {
    return multip;
  }
  return numerator(multip * n, n - 1);
}

int denominator(int sum, int n) {
  if(n == 0) {
    return sum;
  }
  return denominator(sum + n, n - 1);
}

double F2(int n) {
  double sum = 0;
  for(int i = 1; i <= n; i++) {
    sum += 1.0 * numerator(1, i) / denominator(0, i);
  }
  return sum;
}