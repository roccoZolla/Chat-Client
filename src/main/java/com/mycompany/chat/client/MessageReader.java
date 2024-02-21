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
    private final ClientFrame home;

    public MessageReader(InputStream inputStream, ClientFrame home) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.home = home;
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
            e.printStackTrace();
        } finally {
            // Chiudi il BufferedReader
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateUIWithMessage(String message) {
        // Aggiorna l'interfaccia utente con il messaggio ricevuto
        // Questo metodo deve essere implementato per adattarsi alla tua interfaccia utente
        // Ad esempio, potrebbe aggiornare una casella di testo o visualizzare una notifica
        System.out.println("cacato in testa");
    }
}
