/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.lab1;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class StudentInfo {
    
    public static void main(String[] args) {
        String hoten = "";
        float diemtb = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho va ten: ");
        hoten = scanner.nextLine();
        
        System.out.print("Nhap diem trung binh: ");
        diemtb = scanner.nextFloat();
        
        System.out.printf("%s %.1f diem\n", hoten, diemtb);
    }
    
}
