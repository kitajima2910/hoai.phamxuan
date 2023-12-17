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
public class VL12 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Math.abs(Integer.valueOf(st.nextToken()));

        if(n == 0) {
            System.out.println("INF");
            return;
        }
        
        for (int i = n; i >= 1; --i) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

    }

}
