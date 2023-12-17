/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Kitajima2910
 */
public class VL11 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String n = st.nextToken();
        
        BigInteger bi = new BigInteger(n);
        
        if(bi.isProbablePrime(1) && Integer.valueOf(n) > 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
    
}
