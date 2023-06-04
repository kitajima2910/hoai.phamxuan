#include <iostream>

using namespace std;

// a
// Kiểm tra loại
bool checkValid(char c) {
  return  (c >= 'a' && c <= 'z') || 
          (c >= 'A' && c <= 'Z') || 
          (c >= '0' && c <= '9');
}

// Xử lý chính
void outputResult(char c) {
  if(checkValid(c)) {
    cout << (char)(c - 1) << " - " << c << " - " << (char)(c + 1) << endl;
  } else {
    cout << "invalid type\n";
  }
}