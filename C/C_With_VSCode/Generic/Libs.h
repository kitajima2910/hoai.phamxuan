#include <iostream>

using namespace std;

// Overloading
void swap(int &a, int &b) {
  int temp = a + b;
  a = temp - a;
  b = temp - b;
}

void swap(long &a, long &b) {
  long temp = a + b;
  a = temp - a;
  b = temp - b;
}

void swap(double &a, double &b) {
  double temp = a + b;
  a = temp - a;
  b = temp - b;
}

// Generic
template <class T>
void swapGeneric(T &a, T &b) {
  T temp = a + b;
  a = temp - a;
  b = temp - b;
}