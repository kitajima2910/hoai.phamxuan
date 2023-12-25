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
public class DK05 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        long a = scanner.nextLong();
        
        long aC = (long)Math.sqrt(a);
        System.out.println(a == (aC * aC) ? "YES" : "NO");
        
    }
    
}
