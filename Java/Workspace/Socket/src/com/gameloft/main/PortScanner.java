/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.main;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Kitajima2910
 */
public class PortScanner {
    
    public static void main(String[] args) {
        checkPort("localhost");
    }
    
    private static void checkPort(String urlString) {
        int startPort = 1;
        int endPort = 100_000;
        
        System.out.println("Dang quet cac Port cua may: " + urlString);
        
        for(int i = startPort; i <= endPort; i++) {
            try {
                try (Socket socket = new Socket(urlString, i)) {
                    System.out.println("Cong: " + i + " dang mo");
                }
            } catch (IOException e) {
            }
        }
        
        System.out.println("Quet cong hoan tat");
    }
    
}
