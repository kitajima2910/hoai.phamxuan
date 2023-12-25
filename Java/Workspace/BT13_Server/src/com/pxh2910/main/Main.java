/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxh2910.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Kitajima2910
 */
public class Main {

    public static void main(String[] args) {

        try {

            // Tạo server socket và lắng nghe
            int port = 69;
            ServerSocket serverSocket = new ServerSocket(port);

            // Chấp nhận nhiều kết nối
            while (true) {
                // Chấp nhận kết nối từ 1 client
                Socket clientSocket = serverSocket.accept();
                MyProcess mp = new MyProcess(clientSocket);
                mp.start();
            }

        } catch (IOException e) {
            System.out.println("Main: " + e.getMessage());
        }

    }

}
