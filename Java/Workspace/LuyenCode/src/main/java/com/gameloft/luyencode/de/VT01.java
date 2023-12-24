/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.luyencode.de;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VT01 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
            
        List<Integer> store = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            store.add(s.nextInt());
        }
        
        store.sort((a, b) -> -(a - b));
        
        System.out.println(store.get(0));
        
    }
    
}
