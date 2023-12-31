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
public class VT14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // Xử lý nếu n == 2, để tránh tạo 2 mảng âm dương
        if (n == 2) {
            int product = 1;
            for (int i = 0; i < n; i++) {
                product *= sc.nextInt();
            }
            System.out.println(product);
            return;
        }

        // Tạo ra 2 mảng âm dương 
        List<Integer> storeNegative = new ArrayList<>();
        List<Integer> storePostive = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();

            if (e < 0) {
                storeNegative.add(e);
            } else {
                storePostive.add(e);
            }

        }

        // Xử lý mảng âm
        int maxNegative = 0;
        int lenNegative = storeNegative.size();
        if (lenNegative >= 2) {
            // Mảng âm thì sort từ lớn đến bé (vì để xử lý âm bé nhất, khi nhân lại ra dương: âm * âm = dương)
            storeNegative.sort((a, b) -> -(a - b));
            maxNegative = storeNegative.get(lenNegative - 1) * storeNegative.get(lenNegative - 2);
        }

        // Xử lý mảng dương
        int maxPositive = 0;
        int lenPositive = storePostive.size();
        if (lenPositive >= 2) {
            // Mảng dương sort từ bé đến lớn
            storePostive.sort((a, b) -> a - b);
            maxPositive = storePostive.get(lenPositive - 1) * storePostive.get(lenPositive - 2);
        }

        int max = maxNegative >= maxPositive ? maxNegative : maxPositive;

        System.out.println(max);

    }

}
