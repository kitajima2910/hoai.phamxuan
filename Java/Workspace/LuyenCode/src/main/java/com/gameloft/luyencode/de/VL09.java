/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Kitajima2910
 */
public class VL09 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());
        
        double sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += Math.pow(x, i) / factorial(i);
        }
        
        System.out.printf("%.2f", sum);
        
    }
    
    private static long factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    } 

}
