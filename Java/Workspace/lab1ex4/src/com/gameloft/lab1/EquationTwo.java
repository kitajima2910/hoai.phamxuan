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
public class EquationTwo {
    
    public static void main(String[] args) {
        float a, b, c; // ax^2 + bx + c = 0
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = scanner.nextFloat();
        
        System.out.print("Enter b: ");
        b = scanner.nextFloat();
        
        System.out.print("Enter c: ");
        c = scanner.nextFloat();
        
        float delta = (float)Math.pow(b, 2) - 4 * a * c;
        float sqrt = (float)Math.sqrt(delta);
        
        System.out.println("Delta: " + delta);
        System.out.println("Square root: " + sqrt);
        System.out.println();
    }
    
}
