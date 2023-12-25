/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Kitajima2910
 */
public class VL13 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();

        String perfectNumber[] = {
            "6", "28", "496", "8128", "33550336", "8589869056",
            "137438691328", "2305843008139952128",
            "2658455991569831744654692615953842176"
        };
        
        System.out.println(Arrays.asList(perfectNumber).contains(n) ? "YES" : "NO");
        
    }

}
