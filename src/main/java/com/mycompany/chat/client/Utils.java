/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat.client;

import java.util.regex.Pattern;

/**
 *
 * @author rocco
 */
public class Utils {
    private static String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    
    // verifica la validita degli indirizzi IP
    // sono accettati solo indirizzi IPv4 es. 127.0.0.1, 192.168.1.1
    public static boolean checkIPAddress(String ip_address) {
        System.out.println("verifico validita stringa");
        if (Pattern.matches(regex, ip_address)) {
            return true;
        }
        
        return false;
    }
    
    public static String retrieveClient(String clients_list) {
        String[] clients = clients_list.split(", ");
        String client_str = "";
        
        for(int i = 0; i < clients.length; i++) {
            if(!clients[i].equals("lista: ")) {
                client_str += "- " + clients[i] + "\n";
            }
        }
        
        return client_str;
    }
}
