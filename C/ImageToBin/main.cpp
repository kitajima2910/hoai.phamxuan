#include<iostream>
#include<fstream>
#include <conio.h>
#include <graphics.h>
#include <dos.h>

using namespace std;

int main(int argc, char *argv[]) {
	
	ifstream myReadFile;
	
	myReadFile.open(argv[1]);
	
	initwindow(800,800);
	  
	char output[1000];
	int y = 0;
	int x = 100;
	int yy = 100;
	  
	if (myReadFile.is_open()) {
		
		while (!myReadFile.eof()) {
			
			myReadFile >> output;
			  
			for(int i = 0; i < strlen(output); i++) {
					
				if (output[i] != '0') {
					putpixel(i + x, y + yy, 15);
				}
			    	
			}
			   
			y++;
			        
			cout << output;
			delay(1);
		}
	}
	 
	myReadFile.close();
	
	getch();
	return 0;
}