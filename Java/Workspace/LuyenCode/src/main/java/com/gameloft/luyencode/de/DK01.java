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
public class DK01 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        long max = a;
        
        if(b > max) {
            max = b;
        }
        
        System.out.println(max);
        
    }
    
}
