#include <iostream>

using namespace std;

int main() {
	
	int n = 30;
	int count = 2;
	
	cout << "N % 2 == 0, N = " << n << ": " << endl;
	for(int i = 1; i <= n; i++) {
		if(i >= n / 2 + 1) {
			count -= 2;
		}
		for(int j = 1; j < n; j++) {
			if(i >= 2 && i <= n / 2 && j <= i * 2 - 1) {
				cout << "* ";
			}
			if(i >= n / 2 + 1 && i <= n - 1 && j <= n - 1 + count) {
				cout << "* ";
			}
			if((i == 1 || i == n) && j == 1) {
				cout << "* ";
			}
		}
		cout << endl;
	}
	
	system("pause");
	return 0;
}


