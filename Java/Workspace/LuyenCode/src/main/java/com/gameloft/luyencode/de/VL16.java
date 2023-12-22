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
public class VL16 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = BigInteger.valueOf(Integer.valueOf(st.nextToken())).abs();
        BigInteger b = BigInteger.valueOf(Integer.valueOf(st.nextToken())).abs();
        
        BigInteger gcd = a.gcd(b);
        
        //BCNN = (số thứ nhất * số thứ 2) / UCLN
        BigInteger bcnn = a.multiply(b).divide(gcd);
        
        System.out.println(bcnn.intValue());

    }

}
