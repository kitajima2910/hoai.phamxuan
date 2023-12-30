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
public class VT13 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Integer> store = new ArrayList<>();
        
        // Thêm data vào trước
        for(int i = 1; i <= n; i++) {
            store.add(sc.nextInt());
        }
        
        // Tạo 2 biến liền kề để lưu
        int before = store.get(0);
        int after = store.get(1);
        
        // Tạo biến max để lưu
        int max = before + after;
        
        // Duyệt mảng và xử lý thuật toán
        for(int i = 1; i < n - 1; i++) {
            
            int sum = store.get(i) + store.get(i + 1);
            
            // Kiểm tra với biến max
            if(sum > max) {
                max = sum;
                before = store.get(i);
                after = store.get(i + 1);
            }
            
        }
        
        // Kiểm tra 2 số đầu cuối
        int sum = store.get(0) + store.get(n - 1);
        if(sum > max) {
            System.out.println(store.get(n - 1) + " " + store.get(0));
        } else {
            System.out.println(before + " " + after);
        }
        
    }
    
}
