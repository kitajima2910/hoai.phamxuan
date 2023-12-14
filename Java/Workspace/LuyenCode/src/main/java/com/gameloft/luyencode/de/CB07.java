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
public class CB07 {
    
    private static final double PI = 3.14;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double r = scanner.nextDouble();
        
        System.out.printf("%.3f %.3f", (PI * 2 * r), (PI * r * r));
        
    }
    
}
