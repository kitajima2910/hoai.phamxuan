/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gameloft.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class VT15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        List<Integer> store = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            store.add(sc.nextInt());
        }
        
        store.sort((a, b) -> a - b);
        
        int p01 = store.get(0) * store.get(1) * store.get(2);
        int p02 = store.get(n - 1) * store.get(n - 2) * store.get(n - 3);
        int max = p01 > p02 ? p01 : p02;

        System.out.println(max);

    }

}
