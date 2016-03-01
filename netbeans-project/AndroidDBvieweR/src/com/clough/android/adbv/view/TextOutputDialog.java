/*
 * Copyright (C) 2016 thedathoudarya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.clough.android.adbv.view;

import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author thedathoudarya
 */
public class TextOutputDialog extends javax.swing.JDialog {

    /**
     * Creates new form TextOutputDialog
     */
    public TextOutputDialog(java.awt.Frame parent, String outputText) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
//        textOutputTextPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));        
    textOutputTextPane.setContentType("text/html");
    textOutputTextPane.setText(""
            + "<html>"
            + "<body>"
            + "<p>"
            + "<tt>"+outputText.replaceAll(" ", "&nbsp;").replaceAll("\n", "<br>")+"</tt>"
            + "</p>"
            + "</body>"
            + "</html>"                
            + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        textOutputTextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Text Output");

        textOutputTextPane.setEditable(false);
        textOutputTextPane.setFont(new java.awt.Font("Ubuntu Mono", 0, 13)); // NOI18N
        jScrollPane2.setViewportView(textOutputTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane textOutputTextPane;
    // End of variables declaration//GEN-END:variables
}