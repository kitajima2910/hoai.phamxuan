/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.lab1;

import java.util.Scanner;

/**
 *
 * @author Kitajima2910
 */
public class Rectangle {
    
    public static void main(String[] args) {
        
        float dai, rong;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        dai = scanner.nextFloat();
        
        System.out.print("Nhap chieu rong: ");
        rong = scanner.nextFloat();
        
        float chuvi = (dai + rong) * 2;
        float dientich = dai * rong;
        float min = Math.min(dai, rong);
        
        System.out.printf("Hinh chu nhat co chieu dai %f và chiều rộng %f", dai, rong);
        System.out.println();
        System.out.printf("Chu vi %f va diện tích %f của hình", chuvi, dientich);
        System.out.printf("\nCạnh nhỏ nhất của hình là %f\n", min);
    }
}
