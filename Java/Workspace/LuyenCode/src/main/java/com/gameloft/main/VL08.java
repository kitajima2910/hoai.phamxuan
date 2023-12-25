/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Kitajima2910
 */
public class VL08 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        if(a % 2 == 1) {
            a = a + 1;
        }
        
        if(b % 2 == 1) {
            b = b - 1;
        }

        int sum = 0;
        
        for(int i = a; i <= b; i+=2) {
            sum += i;
        }
        
        System.out.println(sum);
        
    }

}
