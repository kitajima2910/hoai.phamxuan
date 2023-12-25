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
public class MyProcess extends Thread {
    
    private Socket socket;

    public MyProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            
            BufferedReader serverSend = new BufferedReader(new InputStreamReader(System.in));
            while (true) {     
                // Nhận tin nhắn
                String clientMessage = br.readLine();
                System.out.println("Client: " + clientMessage);
                
                // Gửi tin nhắn
                System.out.print("Server: ");
                String serverMessage = serverSend.readLine();
                pw.println(serverMessage);
                pw.flush();
            }
        } catch (IOException e) {
        }
        
    }
    
}
