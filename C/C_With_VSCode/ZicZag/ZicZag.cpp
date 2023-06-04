#include "ZicZagLib.h"

int main() {

  int row = 3;
  int col = 4;

  int array[][MAX] = { 
    { 1,  2,  3,  4},
    { 8,  7,  6,  5},
    { 9, 10, 11, 12}
  };

  printZicZagArray(array, row, col, 0, 1);

  return 0;
}