/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VT07 {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            List<Integer> store = new ArrayList<>();
            
            for (int i = 0; i < 11; i++) {
             
                int e = s.nextInt();
                store.add(e);
                
            }
            
            int save = store.get(10);
            boolean flag = false;
            for (int i = 0; i < 10; i++) {
                if(store.get(i) == save) {
                    System.out.print((i + 1) + " ");
                    flag = true;
                }
            }
            
            if(!flag) {
                System.out.println("-1");
            }

        }
    }

}
