/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class CB08 {
    
    private static final double PI = 3.14;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        System.out.printf("%d + %d = %d", a, b, (a + b));
        
    }
    
}