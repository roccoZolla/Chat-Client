/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author rocco
 */
// classe che si occupa della ricezione dei messaggi da parte del server
public class MessageReader extends Thread {
    private final BufferedReader reader;
    private final ChatFrame chat;

    public MessageReader(InputStream inputStream, ChatFrame chat) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.chat = chat;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                // Aggiorna l'interfaccia utente con il messaggio ricevuto
                updateUIWithMessage(message);
            }
        } catch (IOException e) {
            // Gestisci eventuali errori di lettura
            // e.printStackTrace();
            System.err.println("Errore durante la chiusura del messageReader: " + e.getMessage());
        } finally {
            closeResources();
        }
    }
    
    // rilascia le risorse una volta chiusa la connessione
    private void closeResources() {
        System.out.println("rilascio delle risorse in message Reader");
        try {
            // chiudi flusso di input
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            // Gestisci eventuali errori durante la chiusura delle risorse
            System.err.println("Errore durante la chiusura delle risorse: " + e.getMessage());
        }
        
        System.out.println("message reader chiuso correttamente");
    }

    private void updateUIWithMessage(String message) {
        // Aggiorna l'interfaccia utente con il messaggio ricevuto
        // Questo metodo deve essere implementato per adattarsi alla tua interfaccia utente
        // Ad esempio, potrebbe aggiornare una casella di testo o visualizzare una notifica
        System.out.println("cacato in testa");
        chat.appendMessage(message);
    }
}
