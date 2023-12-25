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
public class VL17 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = BigInteger.valueOf(Integer.valueOf(st.nextToken())).abs();
        
        System.out.println(countDivisors(a.intValue()));

    }
    
    
    // function to count the divisors 
    static int countDivisors(int n) 
    { 
        int cnt = 0; 
        for (int i = 1; i <= Math.sqrt(n); i++) 
        { 
            if (n % i == 0) { 
                // If divisors are equal, 
                // count only one 
                if (n / i == i) 
                    cnt++; 
  
                else // Otherwise count both 
                    cnt = cnt + 2; 
            } 
        } 
        return cnt; 
    } 

}
