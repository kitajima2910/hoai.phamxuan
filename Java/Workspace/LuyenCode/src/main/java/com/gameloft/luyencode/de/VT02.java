/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Kitajima2910
 */
public class VT02 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        Map<Integer, Integer> m = new TreeMap<>(Comparator.reverseOrder());
        
        for(int i = 1; i <= n; i++) {
            int e = s.nextInt();
            m.put(e, e);
        }
        
        List<Integer> r = new ArrayList<>(m.keySet());
        
        if(r.size() == 1) {
            System.out.println("NOT FOUND");
            return;
        }
        
        System.out.println(r.get(1));
    }
    
}
