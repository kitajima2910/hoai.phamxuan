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
public class VT06 {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();
            
            int count = 0;
            double sum = 0;

            for (int i = 0; i < n; i++) {
             
                long e = s.nextLong();
                if(Math.abs(e) % 2 == 1) {
                    sum += e;
                    count++;
                }
                
            }
            
            
            System.out.printf("%.4f" , (sum / count));

        }
    }

}
