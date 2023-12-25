/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Kitajima2910
 */
public class VT09 {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();

            Map<BigInteger, BigInteger> store = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                BigInteger e = s.nextBigInteger();
                store.put(e, e);
            }
            
            store.entrySet().forEach(e -> {
                
                BigInteger temp = e.getKey();
                if(temp.isProbablePrime(1)) {
                    System.out.print(temp + " ");
                }
                
            });

        }
    }

}
