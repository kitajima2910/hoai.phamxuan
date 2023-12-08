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
public class Cube {
    
    public static void main(String[] args) {
        float canh;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh cua hinh lap phuong: ");
        canh = scanner.nextFloat();
        
        float thetich = canh * canh * canh;
        thetich = (float)Math.pow(canh, 3);
        
        System.out.printf("Hinh co the tich: %f\n", thetich);
    }
    
}
