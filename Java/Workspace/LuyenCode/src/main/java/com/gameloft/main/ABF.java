/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Kitajima2910
 */
public class ABF {

    public static void main(String[] args) throws IOException {
        
        // input
        File ip = new File("input.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(ip));
        
        BigInteger sum = new BigInteger("0");
        
        String line;
        while((line = br.readLine()) != null) {
            sum = sum.add(new BigInteger(line));
        }

        // output
        File op = new File("output.txt");
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(op));
        bw.write(String.valueOf(sum));
        bw.close();
    }

}
