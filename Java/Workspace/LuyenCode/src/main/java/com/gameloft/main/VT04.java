/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VT04 {

    public static void main(String[] args) throws IOException {

        try (Scanner s = new Scanner(System.in)) {

            int n = s.nextInt();
            int x = s.nextInt();

            List<Integer> store = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                store.add(s.nextInt());
            }

            if (store.contains(x)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
