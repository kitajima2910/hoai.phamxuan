/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gameloft.main;

import java.math.BigInteger;
import java.util.Scanner;

public class TongCacChuSo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger[] store = new BigInteger[2];

        for (int i = 0; i < 2; i++) {
            BigInteger n = sc.nextBigInteger();
            BigInteger k = sc.nextBigInteger();

            BigInteger sum = BigInteger.ZERO;
            for (BigInteger j = k; j.compareTo(n) <= 0; j = j.add(k)) {
                sum = sum.add(sumNumbers(j));
            }

            store[i] = sum;
        }

        for (int i = 0; i < store.length; i++) {
            System.out.println(String.valueOf(store[i]));
        }
    }

    private static BigInteger sumNumbers(BigInteger n) {
        if (n.compareTo(BigInteger.TEN) < 0) {
            return n;
        } else {
            return n.remainder(BigInteger.TEN).add(sumNumbers(n.divide(BigInteger.TEN)));
        }
    }
}
