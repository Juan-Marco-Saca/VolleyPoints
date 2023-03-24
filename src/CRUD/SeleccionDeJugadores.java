/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsaca
 */
public class SeleccionDeJugadores extends javax.swing.JInternalFrame {

    Metodos metodos = new Metodos();
    
    
    int [] cod_titulares = new int[6];
    int [] cod_cambios = new int[6];
    boolean bandera = false;
    
    String[] titulos = {"Codigo", "Nombre", "Apellido", "Numero", "Posicion", "Codigo Equipo"};
    DefaultTableModel modeloTitulares = new DefaultTableModel(null, titulos);
    DefaultTableModel modeloCambios = new DefaultTableModel(null, titulos);
    DefaultTableModel modeloJugadores = new DefaultTableModel(null, titulos);
    String equipo_a;
    String equipo_b;
    
    int titulares = 0;
    int cambios = 0;
    
    public SeleccionDeJugadores(int cod_equipo, String equipoB, String equipoA) {
        initComponents();
        Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        this.setSize(width, height);
        metodos.mostrarJugadores(cod_equipo, jtJugadores);
        equipo_a = equipoA;
        equipo_b = equipoB;
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtJugadores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTitulares = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCambios = new javax.swing.JTable();
        btnTitular = new javax.swing.JButton();
        btnCambio = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnSacarTitulares = new javax.swing.JButton();
        btnSacarCambio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jrbSaque = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 0, 0));
        jLabel1.setText("Seleccione los Jugadores");

        jtJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtJugadores);

        jtTitulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtTitulares);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 0, 0));
        jLabel2.setText("Titulares");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 0, 0));
        jLabel3.setText("Cambios");

        jtCambios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtCambios);

        btnTitular.setText("Titular");
        btnTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitularActionPerformed(evt);
            }
        });

        btnCambio.setText("Cambio");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnSacarTitulares.setText("Regresar Jugador");
        btnSacarTitulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarTitularesActionPerformed(evt);
            }
        });

        btnSacarCambio.setText("Regresar Jugador");
        btnSacarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarCambioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Seleccione los jugadores titulares en el orden que van a sacar en el primer set");

        jrbSaque.setForeground(new java.awt.Color(255, 0, 0));
        jrbSaque.setText("Empiezo el saque");
        jrbSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSaqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(268, 268, 268)
                                .addComponent(btnCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(215, 215, 215)))
                        .addGap(102, 102, 102))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrbSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(526, 526, 526)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(368, 368, 368))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(368, 368, 368))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSacarTitulares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(333, 333, 333))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSacarCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(333, 333, 333)))
                .addGap(163, 163, 163))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSacarTitulares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitular, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacarCambio)
                .addGap(392, 392, 392))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitularActionPerformed
        
        if (titulares < 6) {
           modeloJugadores = metodos.cambioDeTabla(jtJugadores, jtTitulares, modeloJugadores, modeloTitulares);
           jtJugadores.setModel(modeloJugadores); 
           titulares ++;
        } else{
            JOptionPane.showMessageDialog(null, "Tiene mas titulares de lo permitido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTitularActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        if (cambios < 6) {
            modeloJugadores = metodos.cambioDeTabla(jtJugadores, jtCambios, modeloJugadores, modeloCambios);
            jtJugadores.setModel(modeloJugadores);
            cambios ++;
        }else{
            JOptionPane.showMessageDialog(null, "Tiene mas cambios de lo permitido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if(jrbSaque.isSelected()){
            bandera = true;
        } else{
            bandera = false;
        }
        
        
        cod_titulares = metodos.codigoJugadores(jtTitulares);
        cod_cambios = metodos.codigoJugadores(jtCambios);
        NuevoPartido nuevoPartido = new NuevoPartido(modeloTitulares, modeloCambios, bandera, cod_titulares, cod_cambios, equipo_a, equipo_b);
        
        Main.Escritorio.add(nuevoPartido);
        nuevoPartido.setVisible(true);
        nuevoPartido.setSize(Main.Escritorio.getSize());
        
        this.dispose();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnSacarTitularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarTitularesActionPerformed
        if (titulares > 0) {
            modeloTitulares = metodos.cambioDeTabla(jtTitulares, jtJugadores, modeloTitulares, modeloJugadores);
            jtTitulares.setModel(modeloTitulares);
            titulares --;
        }else{
            JOptionPane.showMessageDialog(null, "Ya no hay titulares", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnSacarTitularesActionPerformed

    private void btnSacarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarCambioActionPerformed
        if (cambios > 0) {
            modeloCambios = metodos.cambioDeTabla(jtCambios, jtJugadores, modeloCambios, modeloJugadores);
            jtCambios.setModel(modeloCambios);
            cambios --; 
        }else{
            JOptionPane.showMessageDialog(null, "Ya no hay cambios", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacarCambioActionPerformed

    private void jrbSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSaqueActionPerformed

    }//GEN-LAST:event_jrbSaqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnSacarCambio;
    private javax.swing.JButton btnSacarTitulares;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnTitular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton jrbSaque;
    private javax.swing.JTable jtCambios;
    private javax.swing.JTable jtJugadores;
    private javax.swing.JTable jtTitulares;
    // End of variables declaration//GEN-END:variables

    



}
