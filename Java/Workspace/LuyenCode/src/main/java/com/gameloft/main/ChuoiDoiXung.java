/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class ChuoiDoiXung {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String a = s.nextLine();
        int m = s.nextInt();

        int store[] = new int[m];

        for (int i = 0; i < m; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            try {
                String subA = a.trim().substring(l - 1, r);
                String subReverse = String.valueOf(new StringBuffer(subA).reverse());
                store[i] = subA.equals(subReverse) ? 1 : -1;
            } catch (Exception e) {
                store[i] = -1;
            }

        }

        for (int i = 0; i < m; i++) {
            System.out.println(store[i]);
        }

    }

}
