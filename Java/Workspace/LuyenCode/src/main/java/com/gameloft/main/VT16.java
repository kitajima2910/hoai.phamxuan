/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gameloft.main;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VT16 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        
        while(true) {
            int e = sc.nextInt();
            
            if(e < 0) {
                System.out.print(e + " ");
                count++;
            }
            
            if(e == 0) {
                break;
            }
            
        }
        
        if(count == 0) {
            System.out.println("NOT FOUND");
        }
        
    }
    
}
