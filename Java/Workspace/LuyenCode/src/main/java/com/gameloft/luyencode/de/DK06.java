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
public class DK06 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        
        // ax + b = 0
        if(a == 0) {
            if(b == 0) {
                System.out.println("WOW");
            } else {
                System.out.println("NO");
            }
        } else {
            double x = -b / a;
            System.out.printf("%.2f", x);
        }

    }

}
