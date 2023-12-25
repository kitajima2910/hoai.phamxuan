/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxh2910.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Kitajima2910
 */
public class Main {
    
    public static void main(String[] args) {
        
        try {
            
            // Kết nối tới server
            int port = 69;
            Socket socket = new Socket("localhost", port);
            System.out.println("Đã kết nối thành công đến server!");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            
            BufferedReader clientSend = new BufferedReader(new InputStreamReader(System.in));
            while (true) {    
                // Gửi tin nhắn
                System.out.print("Client: ");
                String clientMessage = clientSend.readLine();
                pw.println(clientMessage);
                pw.flush();
                
                // Nhận tin nhắn
                String serverMessage = br.readLine();
                System.out.println("Server: " + serverMessage);
            }
            
        } catch (IOException e) {
            System.out.println("Không thể kết nối đến server!");
        }
        
    }
    
}
