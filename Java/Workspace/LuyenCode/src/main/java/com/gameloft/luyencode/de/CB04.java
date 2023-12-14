/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class CB04 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        
        System.out.println((long)(a + b));
        System.out.println((long)(a - b));
        System.out.println((long)(a * b));
        
        if(b == 0) {
            System.out.println("ERROR");
        } else {
            System.out.printf("%.2f", (a / b));
        }
        
    }
    
}
