/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Kitajima2910
 */
public class Tong2ChuSo {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        if(n.length() < 2) {
            System.out.println("0");
            return;
        }

        int len = n.length();
        System.out.println(Integer.valueOf(n.charAt(len - 1) + "") + Integer.valueOf(n.charAt(len - 2) + ""));
        
    }

}
