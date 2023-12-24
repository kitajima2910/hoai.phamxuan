/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VL19 {

    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();
        int b = s.nextInt();
        
        boolean flag = false;
        
        for(int i = b - 1; i > a; i--) {
            if(i % 3 == 0) {
                flag = true;
                System.out.print(i + " ");
            }
        }
        
        if(!flag) {
            System.out.println("NOT FOUND");
        }

    }

}