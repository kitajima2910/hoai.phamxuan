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
public class VT05 {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();
            int x = s.nextInt();
            
            int count = 0;

            for (int i = 0; i < n; i++) {
             
                int e = s.nextInt();
                if(x == e) {
                    count++;
                }
                
            }
            
            System.out.println(count);

        }
    }

}
