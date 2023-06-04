#include <iostream>

using namespace std;

const int MAX = 100;

void printZicZagArray(int array[][MAX], int row, int col, int line, int count) {

    while(count <= row) {

      if(count % 2 == 1) {
        for(int j = 0; j < col; j++) {
          cout << array[line][j] << " ";
        }
      } else if(count % 2 == 0) {
        for(int j = col - 1; j  >= 0; j--) {
          cout << array[line][j] << " ";
        }
      }

      line++;
      count++;
    }

}