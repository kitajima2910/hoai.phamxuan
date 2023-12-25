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
public class VT08 {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();

            List<Integer> store = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                store.add(s.nextInt());
            }

            for (int i = 1; i < n; i += 2) {
                int left = (i - 1 >= 0) ? store.get(i - 1) : 0;
                int right = (i + 1 < n) ? store.get(i + 1) : 0;
                int diff = Math.abs(left - right);
                store.set(i, store.get(i) + diff);
            }
            
            store.forEach(e -> System.out.print(e + " "));

        }
    }

}
