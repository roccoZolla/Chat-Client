/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.chat.client;

import java.awt.Color;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author rocco
 */

// indirizzo ip server 169.254.152.75
// indirizzo ip macchina 127.0.0.1 local host

public class Client {
    // static String serverAddress = "localhost"; // Indirizzo IP del server, con localhost ottengo l'indirizzo ip della macchina host del server
    // static String serverAddress = "192.xxx.x.xxx" // indirizzo ip del server specificato con l'indirizzo ip
    // static string serverAddress = "example.com" // collegamento al server tramite il suo dominio
    private static int serverPort = 8080; // numero di porta del server
    private static String server_address;  // indirizzo ip del server
    private static Socket client;
    private static ClientFrame frame;
    
    public static void setServerAddress(String address) {
        server_address = address;
    }
    
    // connettiti al server
    public static void connectToServer() {
        System.out.println("Hai inserito: " + server_address);
        client = new Socket();
        
        // tenta la connessione
        try {
            client.connect(new InetSocketAddress(server_address, serverPort));

            if (client.isConnected()) {
                // gestisce il flusso di input dal server
                frame.setStatusLabel("Connessione riuscita", Color.GREEN);
                
                // thread relativo alla ricezione dei messaggi
                MessageReader messageReader = new MessageReader(client.getInputStream(), frame);
                messageReader.start();
                
                // thread relativo all'invio dei messaggi
                MessageSender messageSender = new MessageSender(client);
                messageSender.start();
            }
        } catch (IOException e) {
            frame.setStatusLabel("Connessione non riuscita", Color.RED);
            System.err.println("Errore durante l'esecuzione del server: " + e.getMessage());
        }
    }
    
    // disconnettiti dal server
    public static void disconnectFromServer() {
        try {
            // Chiudi il socket del client
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dei messaggi dal server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        frame = new ClientFrame();
        frame.setTitle("Chat-Client");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}