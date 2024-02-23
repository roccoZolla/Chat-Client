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
    private boolean is_nickname_valid;
    private boolean is_IP_address_valid;

    /**
     * Creates new form HomeFrame
     */
    public ClientFrame() {
        initComponents();
        
        // imposta la label di errore relativa all'ip address
        no_valid_ip_label.setForeground(Color.RED);
        no_valid_ip_label.setText("Indirizzo IP non valido!");
        no_valid_ip_label.setVisible(false);     
        is_IP_address_valid = false;
        
        // imposta la label di errore relativa al nickname
        no_nickname_label.setForeground(Color.RED);
        no_nickname_label.setText("Nickname non valido!");
        no_nickname_label.setVisible(false); 
        is_nickname_valid = false;
    }
    
    public void setStatusLabel(String text, boolean color) {
        if(color) status_text.setForeground(Color.GREEN);
        if(!color) status_text.setForeground(Color.RED);
        
        status_text.setText(text);
    }
    
    private void tryToConnectToServer() {
        // controlla validita nickname, non deve essere vuoto
        if(nickname_field.getText().isEmpty()) {
            // stringa non valida
            no_nickname_label.setVisible(true);
            ip_address_field.requestFocusInWindow(); // Rendi nuovamente selezionabile il campo di testo
        } else {
            // stringa valida, non vuota
            is_nickname_valid = true;
            no_valid_ip_label.setVisible(false);
        }
        
        // controlla la validita dell'indirizzo IP
        if (Utils.checkIPAddress(ip_address_field.getText())) {
            // stringa valida
            is_IP_address_valid = true;
            no_valid_ip_label.setVisible(false);
        } else {
            // stringa non valida
            // mostra la label di errore
            no_valid_ip_label.setVisible(true);
            ip_address_field.setText("");
            ip_address_field.requestFocusInWindow(); // Rendi nuovamente selezionabile il campo di testo
        }
        
        if(is_nickname_valid && is_IP_address_valid) {
            Client.connectToServer(nickname_field.getText(), ip_address_field.getText());
        }
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
        ip_address_label = new javax.swing.JLabel();
        status_text = new javax.swing.JLabel();
        no_valid_ip_label = new javax.swing.JLabel();
        nickname_label = new javax.swing.JLabel();
        nickname_field = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        no_nickname_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        ip_address_field.setPreferredSize(new java.awt.Dimension(200, 29));
        ip_address_field.setRequestFocusEnabled(false);
        ip_address_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ip_address_fieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(ip_address_field, gridBagConstraints);

        connect_button.setText("Connetti");
        connect_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        getContentPane().add(connect_button, gridBagConstraints);

        ip_address_label.setText("IP Server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(ip_address_label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(status_text, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(no_valid_ip_label, gridBagConstraints);

        nickname_label.setText("Nickname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(nickname_label, gridBagConstraints);

        nickname_field.setPreferredSize(new java.awt.Dimension(200, 29));
        nickname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickname_fieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(nickname_field, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        getContentPane().add(filler1, gridBagConstraints);

        no_nickname_label.setText("test");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(no_nickname_label, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ip_address_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_address_fieldActionPerformed
        // TODO add your handling code here:
        tryToConnectToServer();
    }//GEN-LAST:event_ip_address_fieldActionPerformed

    private void nickname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickname_fieldActionPerformed
        // TODO add your handling code here:
        tryToConnectToServer();
        
    }//GEN-LAST:event_nickname_fieldActionPerformed

    private void connect_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_buttonActionPerformed
        // TODO add your handling code here:
        tryToConnectToServer();
    }//GEN-LAST:event_connect_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect_button;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField ip_address_field;
    private javax.swing.JLabel ip_address_label;
    private javax.swing.JTextField nickname_field;
    private javax.swing.JLabel nickname_label;
    private javax.swing.JLabel no_nickname_label;
    private javax.swing.JLabel no_valid_ip_label;
    private javax.swing.JLabel status_text;
    // End of variables declaration//GEN-END:variables
}
