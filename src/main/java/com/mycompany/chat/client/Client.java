/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.chat.client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

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
    static private int serverPort = 49152; // numero di porta del server
    static private String server_address;  // indirizzo ip del server
    static private HomeFrame home;
    
    public static void setServerAddress(String address) {
        server_address = address;
    }
    
    public static void connectToServer() {
        System.out.println("Hai inserito: " + server_address);
        Socket client = new Socket();
        
        // tenta la connessione
        try {
            client.connect(new InetSocketAddress(server_address, serverPort));

            if (client.isConnected()) {
                // gestisce il flusso di input dal server
                home.setStatusLabel("Connessione riuscita", Color.GREEN);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Messaggio dal server: " + response);
                    }

                    // chiudi il socket
                    client.close();
                } catch (IOException e) {
                    System.err.println("Errore durante la lettura dei messaggi dal server: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            home.setStatusLabel("Connessione non riuscita", Color.RED);
            System.err.println("Errore durante l'esecuzione del server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        home = new HomeFrame();
        home.setTitle("Chat-Client");
        home.setSize(900, 600);
        home.setLocationRelativeTo(null); 
        home.setVisible(true);
    }
}