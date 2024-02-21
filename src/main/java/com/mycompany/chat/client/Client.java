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
    private static int server_port = 8080; // numero di porta del server
    private static String server_address;  // indirizzo ip del server
    private static Socket client;
    private static ClientFrame frame;
    private static ChatFrame chat_frame;
    
    public static void setServerAddress(String address) {
        server_address = address;
    }
    
    // connettiti al server
    public static void connectToServer() {
        System.out.println("Hai inserito: " + server_address);
        client = new Socket();
        
        // tenta la connessione
        try {
            client.connect(new InetSocketAddress(server_address, server_port));

            if (client.isConnected()) {
                // gestisce il flusso di input dal server
                frame.setStatusLabel("Connessione riuscita", Color.GREEN);
                
                // crea un chatFrame
                chat_frame = new ChatFrame();
                
                // thread relativo alla ricezione dei messaggi
                MessageReader messageReader = new MessageReader(client.getInputStream(), chat_frame);
                messageReader.start();
                
                // thread relativo all'invio dei messaggi
                MessageSender messageSender = new MessageSender(client);
                messageSender.start();
                
                chat_frame.setMessageReader(messageReader);                
                chat_frame.setMessageSender(messageSender);
                
                chat_frame.addServer("Server: " + server_address + ", " + server_port);
                
                // chiudi la finestra di avvio
                frame.dispose();
            }
        } catch (IOException e) {
            frame.setStatusLabel("Connessione non riuscita", Color.RED);
            System.err.println("Errore durante l'esecuzione del server: " + e.getMessage());
        }
    }
    
    // disconnettiti dal server e ritorna alla schermata iniziale
    public static void disconnectFromServer() {
        System.out.println("Chiamata a disconnect from server");
        try {
            // Chiudi il socket del client
            if (client != null) {
                client.close();
            }
            
            // chiudi il chat frame
            if(chat_frame != null) {
                chat_frame.dispose();
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dei messaggi dal server: " + e.getMessage());
        }
        
        openNewHomeFrame();
    }
    
    // crea una nuova istanza della pagina iniziale
    private static void openNewHomeFrame() {
        frame = new ClientFrame();
        frame.setTitle("Chat-Client");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        openNewHomeFrame();
    }
}