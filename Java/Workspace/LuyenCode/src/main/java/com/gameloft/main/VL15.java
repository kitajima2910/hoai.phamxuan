/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Kitajima2910
 */
public class VL15 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = BigInteger.valueOf(Integer.valueOf(st.nextToken()));
        BigInteger b = BigInteger.valueOf(Integer.valueOf(st.nextToken()));
        
        if(b.intValue() == 0) {
            System.out.println("INVALID");
            return;
        }
        
        if(a.intValue() % b.intValue() == 0) {
            System.out.println(a.divide(b).intValue());
            return;
        }
        
        if(b.intValue() < 0) {
            b = b.multiply(new BigInteger("-1"));
            a = a.multiply(new BigInteger("-1"));
        }
        
        BigInteger gcd = a.gcd(b);
        
        BigInteger t = a.divide(gcd);
        BigInteger m = b.divide(gcd);

        System.out.println(t.intValue() + " " + m.intValue());

    }

}
