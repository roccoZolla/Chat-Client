/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author rocco
 */
public class MessageSender extends Thread {
    private final Socket socket;
    private final BlockingQueue<String> messageQueue; // coda bloccante, invio dei messaggi in maniera thread-safe
    private final PrintWriter writer;

    public MessageSender(Socket socket) throws IOException {
        this.socket = socket;
        this.messageQueue = new LinkedBlockingQueue<>();
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(String message) {
        messageQueue.add(message);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String message = messageQueue.take();
                writer.println(message);
            }
        } catch (InterruptedException e) {
            // Thread interrotto, esce dal loop
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // rilascia le risorse
    public void closeResources() {
        // chiude il flusso di output
        if (writer != null) {
            writer.close();
        }
        
        try {
            if(socket != null) {
                socket.close();
            } 
        } catch (IOException e) {
            System.err.println("Errore durante la chiusura del socket: " + e.getMessage());
        }
        
        System.out.println("message sender chiuso correttamente");
    }
}
