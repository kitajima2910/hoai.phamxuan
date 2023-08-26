package com.fpt.gamepadpxh;

import android.widget.TextView;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WebSocketHost extends WebSocketServer {

    public String receivingMessages = "";

    public WebSocketHost(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        this.receivingMessages = message;
//        if(message.contains("released")) {
//            conn.send("Server: released");
//        } else if (message.contains("pressed")) {
//            conn.send("Server: pressed");
//        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

}