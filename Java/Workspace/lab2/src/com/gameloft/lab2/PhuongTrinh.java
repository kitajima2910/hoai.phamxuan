/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.lab2;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class PhuongTrinh {
    
    private static void giaiPhuongTrinhBacNhat(float a, float b) {
        // ax + b = 0
        if(a == 0) {
            if(b == 0) {
                System.out.print("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            float x = -b / a;
            System.out.print("Phuong trinh co 1 nghiem x = " + x);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a, b;
        
        System.out.print("Nhap a: ");
        a = scanner.nextFloat();
        
        System.out.print("Nhap b: ");
        b = scanner.nextFloat();
        
        giaiPhuongTrinhBacNhat(a, b);
        System.out.println("\nKet thuc chuong trinh\n");
    }
    
}
