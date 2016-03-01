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

import com.clough.android.adbv.controller.RowController;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thedathoudarya
 */
public class AddUpdateRowDialog extends javax.swing.JDialog {

    private final DefaultTableModel defaultTableModel;
    private final DefaultTableModel mainTableModel;
    private final RowController rowController;
    private final Object[] columns;
    private final Object[] row;
    private final int rowIndex;

    /**
     * Creates new form AddUpdateRowDialog
     */
    public AddUpdateRowDialog(DefaultTableModel mainTableModel, RowController rowController, Object[] columns, Object[] row, int rowIndex) {
        super(new Frame(), true);
        initComponents();
        setLocationRelativeTo(null);
        defaultTableModel = (DefaultTableModel) addUpdateRowTable.getModel();
        this.mainTableModel = mainTableModel;
        this.rowController = rowController;
        this.columns = columns;
        this.row = row;
        this.rowIndex = rowIndex;
        if (row == null) {
            setTitle("Add new row");
            for (Object column : columns) {
                defaultTableModel.addRow(new Object[]{column, ""});
            }
        } else {
            setTitle("Update row");
            for (int i = 0; i < columns.length; i++) {
                defaultTableModel.addRow(new Object[]{columns[i], row[i]});
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        addUpdateRowTable = new javax.swing.JTable();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addUpdateRowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Field", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        addUpdateRowTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(addUpdateRowTable);
        if (addUpdateRowTable.getColumnModel().getColumnCount() > 0) {
            addUpdateRowTable.getColumnModel().getColumn(0).setResizable(false);
            addUpdateRowTable.getColumnModel().getColumn(1).setResizable(false);
        }

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(applyButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:        
        String status = (row == null ? "add" : "update");
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to " + status + " this row?", "Row adding/updating", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Object[] effectingRow = new Object[columns.length];
            for (int i = 0; i < effectingRow.length; i++) {
                effectingRow[i] = defaultTableModel.getValueAt(i, 1);
            }
            if (row == null) {
                rowController.insertRow(effectingRow);
                mainTableModel.addRow(effectingRow);
            } else {
                rowController.updateRow(rowIndex, effectingRow);
                for (int i = 0; i < effectingRow.length; i++) {
                    mainTableModel.setValueAt(effectingRow[i], rowIndex, i);
                }
            }
            dispose();
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable addUpdateRowTable;
    private javax.swing.JButton applyButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}