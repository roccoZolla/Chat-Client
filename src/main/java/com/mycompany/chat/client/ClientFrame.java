/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.chat.client;

import java.awt.Color;

/**
 *
 * @author rocco
 */
public class ClientFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    public ClientFrame() {
        initComponents();
        
        // imposta la label di errore
        no_valid_ip_label.setForeground(Color.RED);
        no_valid_ip_label.setText("Indirizzo IP non valido!");
        no_valid_ip_label.setVisible(false);
        
        connect_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            connect_buttonActionPerformed(evt);
        });
        
    }
    
    private void connect_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if(Utils.checkIPAddress(ip_address_field.getText())) {
            no_valid_ip_label.setVisible(false);
            Client.setServerAddress(ip_address_field.getText());
            Client.connectToServer();
        } else {
            no_valid_ip_label.setVisible(true);
            ip_address_field.setText("");
            ip_address_field.requestFocusInWindow(); // Rendi nuovamente selezionabile il campo di testo
        }
    }
    
    public void setStatusLabel(String text, Color color) {
        status_text.setForeground(color);
        status_text.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ip_address_field = new javax.swing.JTextField();
        connect_button = new javax.swing.JButton();
        ip_address_text = new javax.swing.JLabel();
        status_text = new javax.swing.JLabel();
        no_valid_ip_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        ip_address_field.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(ip_address_field, gridBagConstraints);

        connect_button.setText("Connetti");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        getContentPane().add(connect_button, gridBagConstraints);

        ip_address_text.setText("Inserisci indirizzo IP del Server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(ip_address_text, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(status_text, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        getContentPane().add(no_valid_ip_label, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect_button;
    private javax.swing.JTextField ip_address_field;
    private javax.swing.JLabel ip_address_text;
    private javax.swing.JLabel no_valid_ip_label;
    private javax.swing.JLabel status_text;
    // End of variables declaration//GEN-END:variables
}
