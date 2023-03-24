/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 *
 * @author jsaca
 */
public class Equipos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Equipos
     */
    public Equipos() {
        initComponents();
        Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        this.setSize(width, height);
        jSeparator.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNuevoEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEditarEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevoEquipo = new javax.swing.JButton();
        btnEditarEquipo = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        btnBack = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        btnNuevoEquipo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnNuevoEquipo.setText("Nuevo Equipo");
        btnNuevoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEquipoActionPerformed(evt);
            }
        });

        btnEditarEquipo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnEditarEquipo.setText("Editar Equipo");
        btnEditarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEquipoActionPerformed(evt);
            }
        });

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnEditarEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addGap(370, 370, 370)
                        .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnEditarEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(382, 382, 382))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu menu = new Menu();
        
        Main.Escritorio.add(menu);
        menu.setVisible(true);
        menu.setSize(Main.Escritorio.getSize());
        
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNuevoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEquipoActionPerformed
        NombreEquipo nombreEquipo = new NombreEquipo();
        
        Main.Escritorio.add(nombreEquipo);
        nombreEquipo.setVisible(true);
        nombreEquipo.setSize(Main.Escritorio.getSize());
        
        this.dispose();
    }//GEN-LAST:event_btnNuevoEquipoActionPerformed

    private void btnEditarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEquipoActionPerformed
        SeleccionarEditarEquipos seleccionEditarEquipos = new SeleccionarEditarEquipos();
        
        Main.Escritorio.add(seleccionEditarEquipos);
        seleccionEditarEquipos.setVisible(true);
        seleccionEditarEquipos.setSize(Main.Escritorio.getSize());
        
        this.dispose();
    }//GEN-LAST:event_btnEditarEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditarEquipo;
    private javax.swing.JButton btnNuevoEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator;
    // End of variables declaration//GEN-END:variables
}
