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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kitajima2910
 */
public class DEC2BIN {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        List<String> store = new ArrayList<>();
        
        for(int i = 1; i <= T; i++) {
            store.add(br.readLine());
        }
        
        store.forEach(e -> {
            System.out.println(new BigInteger(e).toString(2));
        });
        
    }

}
