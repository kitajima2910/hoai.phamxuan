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
public class CB06 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        long d = scanner.nextLong();
        long r = scanner.nextLong();
        
        System.out.println((d + r) * 2);
        System.out.println(d * r);
        
    }
    
}
