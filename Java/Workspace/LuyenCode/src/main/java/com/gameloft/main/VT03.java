/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

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
public class VT03 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        Map<Integer, Integer> m = new TreeMap<>(Comparator.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            int e = s.nextInt();
            m.put(e, i);
        }
        
        List<Integer> r = new ArrayList<>(m.values());
        
        System.out.println(r.get(0));
    }
    
}
