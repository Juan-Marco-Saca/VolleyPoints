
package CRUD;

import conexion.conexionSQL;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  

public class EstadisticasJugador extends javax.swing.JInternalFrame {

    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    
    Metodos metodos = new Metodos();
    
    // <editor-fold defaultstate="collapsed" desc="Variables de analisis">
    // B = bueno, M = malo, C = continuante # = area
    double SB1, SM1, SC1, SB2, SM2, SC2, SB3, SM3, SC3, SB4, SM4, SC4, SB5, SM5, SC5, SB6, SM6, SC6, saques; //saque  
    double RB1, RM1, RC1, RB2, RM2, RC2, RB3, RM3, RC3, RB4, RM4, RC4, RB5, RM5, RC5, RB6, RM6, RC6, recibos; //recibo
    double BB1, BM1, BC1, BB2, BM2, BC2, BB3, BM3, BC3, BB4, BM4, BC4, BB5, BM5, BC5, BB6, BM6, BC6, bloqueos; //bloqueo
    double AB1, AM1, AC1, AB2, AM2, AC2, AB3, AM3, AC3, AB4, AM4, AC4, AB5, AM5, AC5, AB6, AM6, AC6, ataques; //ataque
    double CB1, CM1, CC1, CB2, CM2, CC2, CB3, CM3, CC3, CB4, CM4, CC4, CB5, CM5, CC5, CB6, CM6, CC6, coloques; //coloque
    double DB1, DM1, DC1, DB2, DM2, DC2, DB3, DM3, DC3, DB4, DM4, DC4, DB5, DM5, DC5, DB6, DM6, DC6, defensas;//defensa
    double saquesB, saquesM;
    double bloqueosB, bloqueosM;
    double coloquesB, coloquesM;
    double ataquesB, ataquesM;
    double recibosB, recibosM;
    double defensasB, defensasM;
    // </editor-fold>
    
    int cod_equipo;
    
    public EstadisticasJugador(int cod_equipo) {
        initComponents();
        
        metodos.mostrarJugadores(cod_equipo, jtJugadores);
        
        Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        this.setSize(width, height);
        
        
        this.cod_equipo = cod_equipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtJugadores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlSaquesB = new javax.swing.JLabel();
        jlBloqueosB = new javax.swing.JLabel();
        jlRecibosB = new javax.swing.JLabel();
        jlColoquesB = new javax.swing.JLabel();
        jlAtaquesB = new javax.swing.JLabel();
        jlDefensaB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlSaquesM = new javax.swing.JLabel();
        jlBloqueosM = new javax.swing.JLabel();
        jlRecibosM = new javax.swing.JLabel();
        jlColoquesM = new javax.swing.JLabel();
        jlAtaquesM = new javax.swing.JLabel();
        jlDefensaM = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlSaquesR = new javax.swing.JLabel();
        jlBloqueosR = new javax.swing.JLabel();
        jlRecibosR = new javax.swing.JLabel();
        jlColoquesR = new javax.swing.JLabel();
        jlAtaquesR = new javax.swing.JLabel();
        jlDefensaR = new javax.swing.JLabel();
        btnVerEstadisticas = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelGrafica = new javax.swing.JPanel();
        btnBuenosGrafica = new javax.swing.JToggleButton();
        btnContinuantesGrafico = new javax.swing.JToggleButton();
        btnMalosGrafico = new javax.swing.JToggleButton();
        btnGraficar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Estadisticas De Jugador");

        jLabel2.setText("Buenos");

        jlSaquesB.setText("Saques");

        jlBloqueosB.setText("Bloqueos");

        jlRecibosB.setText("Recibos");

        jlColoquesB.setText("Coloques");

        jlAtaquesB.setText("Ataques");

        jlDefensaB.setText("Defensa");

        jLabel9.setText("Malos");

        jlSaquesM.setText("Saques");

        jlBloqueosM.setText("Bloqueos");

        jlRecibosM.setText("Recibos");

        jlColoquesM.setText("Coloques");

        jlAtaquesM.setText("Ataques");

        jlDefensaM.setText("Defensa");

        jLabel3.setText("Realizados");

        jlSaquesR.setText("Saques");

        jlBloqueosR.setText("Bloqueos");

        jlRecibosR.setText("Recibos");

        jlColoquesR.setText("Coloques");

        jlAtaquesR.setText("Ataques");

        jlDefensaR.setText("Defensa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlDefensaR, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlBloqueosR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlSaquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlColoquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlRecibosR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlAtaquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlDefensaB, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBloqueosB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlSaquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlColoquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlRecibosB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlAtaquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(3, 3, 3)))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlAtaquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlRecibosM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jlColoquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlSaquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jlBloqueosM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jlDefensaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlSaquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlBloqueosR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecibosR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlColoquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAtaquesR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDefensaR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSaquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSaquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlBloqueosB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlBloqueosM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlRecibosB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlRecibosM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlColoquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlColoquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAtaquesB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlAtaquesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDefensaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDefensaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );

        btnVerEstadisticas.setText("Ver Estadisticas");
        btnVerEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEstadisticasActionPerformed(evt);
            }
        });

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnBuenosGrafica.setText("Buenos");

        btnContinuantesGrafico.setText("Continuantes");

        btnMalosGrafico.setText("Malos");

        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(409, 409, 409)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(563, 563, 563))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1)
                        .addGap(399, 399, 399)))
                .addGap(559, 559, 559))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuenosGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(btnContinuantesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(btnGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnMalosGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(339, 339, 339)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContinuantesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuenosGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMalosGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(34, 34, 34))
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

    private void btnVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEstadisticasActionPerformed
        panelGrafica.removeAll();
        ResetAnalisis();
        int cod_jugador = metodos.codEquipoSeleccionado(jtJugadores);
        this.setSize(Main.Escritorio.getSize());
        
        metodos.mostrarJugadores(cod_equipo, jtJugadores);
        ExtraerDatos(jtJugadores, cod_jugador);
        Porcentajes();
        MostrarPorcentajes();

        ChartPanel panel = Grafica(CrearDatasetBuenos());
        panel.setSize(panelGrafica.getSize());
        panelGrafica.add(panel);
        
        
    }//GEN-LAST:event_btnVerEstadisticasActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu menu = new Menu();

        Main.Escritorio.add(menu);
        menu.setVisible(true);
        menu.setSize(Main.Escritorio.getSize());

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
       
        
        if (btnBuenosGrafica.isSelected()) {
            panelGrafica.removeAll();
            ChartPanel panel = Grafica(CrearDatasetBuenos());
           panel.setSize(panelGrafica.getSize());
           panelGrafica.add(panel);
        } else if (btnMalosGrafico.isSelected()) {
            panelGrafica.removeAll();
            ChartPanel panel = Grafica(CrearDatasetMalos());
            panel.setSize(panelGrafica.getSize());
            panelGrafica.add(panel);
        } else if (btnContinuantesGrafico.isSelected()) {
            panelGrafica.removeAll();
            ChartPanel panel = Grafica(CrearDatasetContinuantes());
            panel.setSize(panelGrafica.getSize());
            panelGrafica.add(panel);
        }else{
            panelGrafica.removeAll(); 
            ChartPanel panel = GraficaMixtos();
            panel.setSize(panelGrafica.getSize());
            panelGrafica.add(panel);
        }
        btnBuenosGrafica.setSelected(false);
        btnMalosGrafico.setSelected(false);
        btnContinuantesGrafico.setSelected(false);
    }//GEN-LAST:event_btnGraficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JToggleButton btnBuenosGrafica;
    private javax.swing.JToggleButton btnContinuantesGrafico;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JToggleButton btnMalosGrafico;
    private javax.swing.JButton btnVerEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlAtaquesB;
    private javax.swing.JLabel jlAtaquesM;
    private javax.swing.JLabel jlAtaquesR;
    private javax.swing.JLabel jlBloqueosB;
    private javax.swing.JLabel jlBloqueosM;
    private javax.swing.JLabel jlBloqueosR;
    private javax.swing.JLabel jlColoquesB;
    private javax.swing.JLabel jlColoquesM;
    private javax.swing.JLabel jlColoquesR;
    private javax.swing.JLabel jlDefensaB;
    private javax.swing.JLabel jlDefensaM;
    private javax.swing.JLabel jlDefensaR;
    private javax.swing.JLabel jlRecibosB;
    private javax.swing.JLabel jlRecibosM;
    private javax.swing.JLabel jlRecibosR;
    private javax.swing.JLabel jlSaquesB;
    private javax.swing.JLabel jlSaquesM;
    private javax.swing.JLabel jlSaquesR;
    private javax.swing.JTable jtJugadores;
    private javax.swing.JPanel panelGrafica;
    // End of variables declaration//GEN-END:variables
       
    protected void ExtraerDatos(javax.swing.JTable tabla, int cod_jugador){
        
        String SQL = "Select * from datos";
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                if (rs.getInt("cod_jugador") == cod_jugador) {
                    switch(rs.getInt("cod_punto")){
                        case 1:
                            switch (rs.getInt("cod_movimiento")) {
                                case 1:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            SB1++;
                                            saques++;
                                            break;
                                        case 2:
                                            SB2++;
                                            saques++;
                                            break;
                                        case 3:
                                            SB3++;
                                            saques++;
                                            break;
                                        case 4:
                                            SB4++;
                                            saques++;
                                            break;
                                        case 5:
                                            SB5++;
                                            saques++;
                                            break;
                                        case 6:
                                            SB6++;
                                            saques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:                  
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            AB1++;
                                            ataques++;
                                            break;
                                        case 2:
                                            AB2++;
                                            ataques++;
                                            break;
                                        case 3:
                                            AB3++;
                                            ataques++;
                                            break;
                                        case 4:
                                            AB4++;
                                            ataques++;
                                            break;
                                        case 5:
                                            AB5++;
                                            ataques++;
                                            break;
                                        case 6:
                                            AB6++;
                                            ataques++;
                                            break;
                                        default:
                                            break;
                                    }

                                    break;
                                case 3:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            BB1++;
                                            bloqueos++;
                                            break;
                                        case 2:
                                            BB2++;
                                            bloqueos++;
                                            break;
                                        case 3:
                                            BB3++;
                                            bloqueos++;
                                            break;
                                        case 4:
                                            BB4++;
                                            bloqueos++;
                                            break;
                                        case 5:
                                            BB5++;
                                            bloqueos++;
                                            break;
                                        case 6:
                                            BB6++;
                                            bloqueos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                case 4:
                                        switch (rs.getInt("cod_area")) {
                                        case 1:
                                            RB1++;
                                            recibos++;
                                            break;
                                        case 2:
                                            RB2++;
                                            recibos++;
                                            break;
                                        case 3:
                                            RB3++;
                                            recibos++;
                                            break;
                                        case 4:
                                            RB4++;
                                            recibos++;
                                            break;
                                        case 5:
                                            RB5++;
                                            recibos++;
                                            break;
                                        case 6:
                                            RB6++;
                                            recibos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            CB1++;
                                            coloques++;
                                            break;
                                        case 2:
                                            CB2++;
                                            coloques++;
                                            break;
                                        case 3:
                                            CB3++;
                                            coloques++;
                                            break;
                                        case 4:
                                            CB4++;
                                            coloques++;
                                            break;
                                        case 5:
                                            CB5++;
                                            coloques++;
                                            break;
                                        case 6:
                                            CB6++;
                                            coloques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 7:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            DB1++;
                                            defensas++;
                                            break;
                                        case 2:
                                            DB2++;
                                            defensas++;
                                            break;
                                        case 3:
                                            DB3++;
                                            defensas++;
                                            break;
                                        case 4:
                                            DB4++;
                                            defensas++;
                                            break;
                                        case 5:
                                            DB5++;
                                            defensas++;
                                            break;
                                        case 6:
                                            DB6++;
                                            defensas++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                }
                            break;

                        case 2:
                            switch (rs.getInt("cod_movimiento")) {
                                case 1:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            SM1++;
                                            saques++;
                                            break;
                                        case 2:
                                            SM2++;
                                            saques++;
                                            break;
                                        case 3:
                                            SM3++;
                                            saques++;
                                            break;
                                        case 4:
                                            SM4++;
                                            saques++;
                                            break;
                                        case 5:
                                            SM5++;
                                            saques++;
                                            break;
                                        case 6:
                                            SM6++;
                                            saques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:                  
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            AM1++;
                                            ataques++;
                                            break;
                                        case 2:
                                            AM2++;
                                            ataques++;
                                            break;
                                        case 3:
                                            AM3++;
                                            ataques++;
                                            break;
                                        case 4:
                                            AM4++;
                                            ataques++;
                                            break;
                                        case 5:
                                            AM5++;
                                            ataques++;
                                            break;
                                        case 6:
                                            AM6++;
                                            ataques++;
                                            break;
                                        default:
                                            break;
                                    }

                                    break;
                                case 3:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            BM1++;
                                            bloqueos++;
                                            break;
                                        case 2:
                                            BM2++;
                                            bloqueos++;
                                            break;
                                        case 3:
                                            BM3++;
                                            bloqueos++;
                                            break;
                                        case 4:
                                            BM4++;
                                            bloqueos++;
                                            break;
                                        case 5:
                                            BM5++;
                                            bloqueos++;
                                            break;
                                        case 6:
                                            BM6++;
                                            bloqueos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                case 4:
                                        switch (rs.getInt("cod_area")) {
                                        case 1:
                                            RM1++;
                                            recibos++;
                                            break;
                                        case 2:
                                            RM2++;
                                            recibos++;
                                            break;
                                        case 3:
                                            RM3++;
                                            recibos++;
                                            break;
                                        case 4:
                                            RM4++;
                                            recibos++;
                                            break;
                                        case 5:
                                            RM5++;
                                            recibos++;
                                            break;
                                        case 6:
                                            RM6++;
                                            recibos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            CM1++;
                                            coloques++;
                                            break;
                                        case 2:
                                            CM2++;
                                            coloques++;
                                            break;
                                        case 3:
                                            CM3++;
                                            coloques++;
                                            break;
                                        case 4:
                                            CM4++;
                                            coloques++;
                                            break;
                                        case 5:
                                            CM5++;
                                            coloques++;
                                            break;
                                        case 6:
                                            CM6++;
                                            coloques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 7:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            DM1++;
                                            defensas++;
                                            break;
                                        case 2:
                                            DM2++;
                                            defensas++;
                                            break;
                                        case 3:
                                            DM3++;
                                            defensas++;
                                            break;
                                        case 4:
                                            DM4++;
                                            defensas++;
                                            break;
                                        case 5:
                                            DM5++;
                                            defensas++;
                                            break;
                                        case 6:
                                            DM6++;
                                            defensas++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                }
                            break;

                        case 3:

                            switch (rs.getInt("cod_movimiento")) {
                                case 1:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            SC1++;
                                            saques++;
                                            break;
                                        case 2:
                                            SC2++;
                                            saques++;
                                            break;
                                        case 3:
                                            SC3++;
                                            saques++;
                                            break;
                                        case 4:
                                            SC4++;
                                            saques++;
                                            break;
                                        case 5:
                                            SC5++;
                                            saques++;
                                            break;
                                        case 6:
                                            SC6++;
                                            saques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:                  
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            AC1++;
                                            ataques++;
                                            break;
                                        case 2:
                                            AC2++;
                                            ataques++;
                                            break;
                                        case 3:
                                            AC3++;
                                            ataques++;
                                            break;
                                        case 4:
                                            AC4++;
                                            ataques++;
                                            break;
                                        case 5:
                                            AC5++;
                                            ataques++;
                                            break;
                                        case 6:
                                            AC6++;
                                            ataques++;
                                            break;
                                        default:
                                            break;
                                    }

                                    break;
                                case 3:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            BC1++;
                                            bloqueos++;
                                            break;
                                        case 2:
                                            BC2++;
                                            bloqueos++;
                                            break;
                                        case 3:
                                            BC3++;
                                            bloqueos++;
                                            break;
                                        case 4:
                                            BC4++;
                                            bloqueos++;
                                            break;
                                        case 5:
                                            BC5++;
                                            bloqueos++;
                                            break;
                                        case 6:
                                            BC6++;
                                            bloqueos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                case 4:
                                        switch (rs.getInt("cod_area")) {
                                        case 1:
                                            RC1++;
                                            recibos++;
                                            break;
                                        case 2:
                                            RC2++;
                                            recibos++;
                                            break;
                                        case 3:
                                            RC3++;
                                            recibos++;
                                            break;
                                        case 4:
                                            RC4++;
                                            recibos++;
                                            break;
                                        case 5:
                                            RC5++;
                                            recibos++;
                                            break;
                                        case 6:
                                            RC6++;
                                            recibos++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            CC1++;
                                            coloques++;
                                            break;
                                        case 2:
                                            CC2++;
                                            coloques++;
                                            break;
                                        case 3:
                                            CC3++;
                                            coloques++;
                                            break;
                                        case 4:
                                            CC4++;
                                            coloques++;
                                            break;
                                        case 5:
                                            CC5++;
                                            coloques++;
                                            break;
                                        case 6:
                                            CC6++;
                                            coloques++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 7:
                                    switch (rs.getInt("cod_area")) {
                                        case 1:
                                            DC1++;
                                            defensas++;
                                            break;
                                        case 2:
                                            DC2++;
                                            defensas++;
                                            break;
                                        case 3:
                                            DC3++;
                                            defensas++;
                                            break;
                                        case 4:
                                            DC4++;
                                            defensas++;
                                            break;
                                        case 5:
                                            DC5++;
                                            defensas++;
                                            break;
                                        case 6:
                                            DC6++;
                                            defensas++;
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                                }
                            break;
                        default:
                            break;
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro al extraer datos " + e.getMessage());
        }
    }

    protected void Porcentajes(){

        if (saques >0) {
            saquesB = (SB1 + SB2 + SB3 + SB4 + SB5 + SB6 + SC1 + SC2 + SC3 + SC4 + SC5 + SC6);
            saquesM = (SM1 + SM2 + SM3 + SM4 + SM5 + SM6);
            saquesB = saquesB / saques;
            saquesM = saquesM / saques;
            saquesB = saquesB * 100;
            saquesM = saquesM * 100;
        } else{
            saquesB = 0;
            saquesM = 0;
        }

        if (bloqueos > 0) {
             bloqueosB = ((BB1 + BB2 + BB3 + BB4 + BB5 + BB6 + BC1 + BC2 + BC3 + BC4 + BC5 + BC6) / bloqueos)*100;
            bloqueosM = ((BM1 + BM2 + BM3 + BM4 + BM5 + BM6) / bloqueos)*100;
        } else{
            bloqueosB = 0;
            bloqueosM = 0;
        }

        if (coloques > 0) {
            coloquesB = ((CB1 + CB2 + CB3 + CB4 + CB5 + CB6 + CC1 + CC2 + CC3 + CC4 + CC5 + CC6) / coloques)*100;
            coloquesM = ((CM1 + CM2 + CM3 + CM4 + CM5 + CM6) / coloques)*100;
        } else{
            coloquesB = 0;
            coloquesM = 0;
        }

        if (ataques > 0) {
            ataquesB = ((AB1 + AB2 + AB3 + AB4 + AB5 + AB6 + AC1 + AC2 + AC3 + AC4 + AC5 + AC6) / ataques)*100;
            ataquesM = ((AM1 + AM2 + AM3 + AM4 + AM5 + AM6) / ataques)*100;
        } else{
            ataquesB = 0;
            ataquesM = 0;
        }

        if (recibos > 0) {
            recibosB = ((RB1 + RB2 + RB3 + RB4 + RB5 + RB6 + RC1 + RC2 + RC3 + RC4 + RC5 + RC6) / recibos)*100;
            recibosM = ((RM1 + RM2 + RM3 + RM4 + RM5 + RM6) / recibos)*100;
        } else{
            recibosB = 0;
            recibosM = 0;
        }
        
        if (defensas > 0) {
            defensasB = ((DB1 + DB2 + DB3 + DB4 + DB5 + DB6 + DC1 + DC2 + DC3 + DC4 + DC5 + DC6) / defensas)*100;
            defensasM = ((DM1 + DM2 + DM3 + DM4 + DM5 + DM6) / defensas)*100;
        } else{
            defensasB = 0;
            defensasM = 0;
        }
        
        
    }
    
    protected void MostrarPorcentajes(){
        
        jlSaquesB.setText("Saques: " + Double.toString(Math.round(saquesB)) + "%");
        jlSaquesM.setText("Saques: " + Double.toString(Math.round(saquesM)) + "%");
        
        jlBloqueosB.setText("Bloqueos: " + Double.toString(Math.round(bloqueosB)) + "%");
        jlBloqueosM.setText("Bloqueos: " + Double.toString(Math.round(bloqueosM)) + "%");
        
        jlColoquesB.setText("Pases: " + Double.toString(Math.round(coloquesB)) + "%");
        jlColoquesM.setText("Pases: " + Double.toString(Math.round(coloquesM)) + "%");
        
        jlAtaquesB.setText("Remates: " + Double.toString(Math.round(ataquesB)) + "%");
        jlAtaquesM.setText("Remates: " + Double.toString(Math.round(ataquesM)) + "%");
        
        jlRecibosB.setText("Recibos: " + Double.toString(Math.round(recibosB)) + "%");
        jlRecibosM.setText("Recibos: " + Double.toString(Math.round(recibosM)) + "%");
        
        jlDefensaB.setText("Defensas: " + Double.toString(Math.round(defensasB)) + "%");
        jlDefensaM.setText("Defensas: " + Double.toString(Math.round(defensasM)) + "%");
        
        
        jlSaquesR.setText("Saques: " + Double.toString(saques));
        jlBloqueosR.setText("Bloqueos: " + Double.toString(bloqueos));
        jlColoquesR.setText("Pases: " + Double.toString(coloques));
        jlAtaquesR.setText("Remates: " + Double.toString(ataques));
        jlRecibosR.setText("Recibos: " + Double.toString(recibos));
        jlDefensaR.setText("Defensas: " + Double.toString(defensas));
        
    } 

    private void ResetAnalisis(){
        SB1 = SM1 = SC1 = SB2 = SM2 = SC2 = SB3 = SM3 = SC3 = SB4 = SM4 = SC4 = SB5 = SM5 = SC5 = SB6 = SM6 = SC6 = saques = 0; //saque  
        RB1 = RM1 = RC1 = RB2 = RM2 = RC2 = RB3 = RM3 = RC3 = RB4 = RM4 = RC4 = RB5 = RM5 = RC5 = RB6 = RM6 = RC6 = recibos = 0; //recibo
        BB1 = BM1 = BC1 = BB2 = BM2 = BC2 = BB3 = BM3 = BC3 = BB4 = BM4 = BC4 = BB5 = BM5 = BC5 = BB6 = BM6 = BC6 = bloqueos = 0; //bloqueo
        AB1 = AM1 = AC1 = AB2 = AM2 = AC2 = AB3 = AM3 = AC3 = AB4 = AM4 = AC4 = AB5 = AM5 = AC5 = AB6 = AM6 = AC6 = ataques = 0; //ataque
        CB1 = CM1 = CC1 = CB2 = CM2 = CC2 = CB3 = CM3 = CC3 = CB4 = CM4 = CC4 = CB5 = CM5 = CC5 = CB6 = CM6 = CC6 = coloques = 0; //coloque
        DB1 =  DM1 = DC1 = DB2 = DM2 = DC2 = DB3 = DM3 = DC3 = DB4 = DM4 = DC4 = DB5 = DM5 = DC5 = DB6 = DM6 = DC6 = defensas = 0;//defensa
        saquesB = saquesM = 0;
        bloqueosB = bloqueosM = 0;
        coloquesB = coloquesM = 0;
        ataquesB = ataquesM = 0;
        recibosB = recibosM = 0;
        defensasB = defensasM = 0;
    }
    
    protected ChartPanel Grafica(CategoryDataset result){
        
        CategoryDataset dataset = result;
        
        JFreeChart chart = ChartFactory.createBarChart("Estadisticas Jugador ",
                        "Movimiento", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
        
        return panel;      
    }
    
    protected CategoryDataset CrearDatasetBuenos(){
        
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        
        result.addValue(SB1, "A1", "Saque");
        result.addValue(SB2, "A2", "Saque");
        result.addValue(SB3, "A3", "Saque");
        result.addValue(SB4, "A4", "Saque");
        result.addValue(SB5, "A5", "Saque");
        result.addValue(SB6, "A6", "Saque");
        
        result.addValue(RB1, "A1", "Recibo");
        result.addValue(RB2, "A2", "Recibo");
        result.addValue(RB3, "A3", "Recibo");
        result.addValue(RB4, "A4", "Recibo");
        result.addValue(RB5, "A5", "Recibo");
        result.addValue(RB6, "A6", "Recibo");
        
        result.addValue(BB1, "A1", "Bloqueo");
        result.addValue(BB2, "A2", "Bloqueo");
        result.addValue(BB3, "A3", "Bloqueo");
        result.addValue(BB4, "A4", "Bloqueo");
        result.addValue(BB5, "A5", "Bloqueo");
        result.addValue(BB6, "A6", "Bloqueo");
        
        result.addValue(AB1, "A1", "Remate");
        result.addValue(AB2, "A2", "Remate");
        result.addValue(AB3, "A3", "Remate");
        result.addValue(AB4, "A4", "Remate");
        result.addValue(AB5, "A5", "Remate");
        result.addValue(AB6, "A6", "Remate");
        
        result.addValue(CB1, "A1", "Pase");
        result.addValue(CB2, "A2", "Pase");
        result.addValue(CB3, "A3", "Pase");
        result.addValue(CB4, "A4", "Pase");
        result.addValue(CB5, "A5", "Pase");
        result.addValue(CB6, "A6", "Pase");
        
        result.addValue(DB1, "A1", "Defensa");
        result.addValue(DB2, "A2", "Defensa");
        result.addValue(DB3, "A3", "Defensa");
        result.addValue(DB4, "A4", "Defensa");
        result.addValue(DB5, "A5", "Defensa");
        result.addValue(DB6, "A6", "Defensa");
        
        return result;
    }
    
    protected CategoryDataset CrearDatasetContinuantes(){
        
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        
        result.addValue(SC1, "A1", "Saque");
        result.addValue(SC2, "A2", "Saque");
        result.addValue(SC3, "A3", "Saque");
        result.addValue(SC4, "A4", "Saque");
        result.addValue(SC5, "A5", "Saque");
        result.addValue(SC6, "A6", "Saque");
        
        result.addValue(RC1, "A1", "Recibo");
        result.addValue(RC2, "A2", "Recibo");
        result.addValue(RC3, "A3", "Recibo");
        result.addValue(RC4, "A4", "Recibo");
        result.addValue(RC5, "A5", "Recibo");
        result.addValue(RC6, "A6", "Recibo");
        
        result.addValue(BC1, "A1", "Bloqueo");
        result.addValue(BC2, "A2", "Bloqueo");
        result.addValue(BC3, "A3", "Bloqueo");
        result.addValue(BC4, "A4", "Bloqueo");
        result.addValue(BC5, "A5", "Bloqueo");
        result.addValue(BC6, "A6", "Bloqueo");
        
        result.addValue(AC1, "A1", "Remate");
        result.addValue(AC2, "A2", "Remate");
        result.addValue(AC3, "A3", "Remate");
        result.addValue(AC4, "A4", "Remate");
        result.addValue(AC5, "A5", "Remate");
        result.addValue(AC6, "A6", "Remate");
        
        result.addValue(CC1, "A1", "Pase");
        result.addValue(CC2, "A2", "Pase");
        result.addValue(CC3, "A3", "Pase");
        result.addValue(CC4, "A4", "Pase");
        result.addValue(CC5, "A5", "Pase");
        result.addValue(CC6, "A6", "Pase");
       
        result.addValue(DC1, "A1", "Defensa");
        result.addValue(DC2, "A2", "Defensa");
        result.addValue(DC3, "A3", "Defensa");
        result.addValue(DC4, "A4", "Defensa");
        result.addValue(DC5, "A5", "Defensa");
        result.addValue(DC6, "A6", "Defensa");
        
        return result;
    }
    
    protected CategoryDataset CrearDatasetMalos(){
        
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        
        result.addValue(SM1, "A1", "Saque");
        result.addValue(SM2, "A2", "Saque");
        result.addValue(SM3, "A3", "Saque");
        result.addValue(SM4, "A4", "Saque");
        result.addValue(SM5, "A5", "Saque");
        result.addValue(SM6, "A6", "Saque");
        
        result.addValue(RM1, "A1", "Recibo");
        result.addValue(RM2, "A2", "Recibo");
        result.addValue(RM3, "A3", "Recibo");
        result.addValue(RM4, "A4", "Recibo");
        result.addValue(RB5, "A5", "Recibo");
        result.addValue(RM6, "A6", "Recibo");
        
        result.addValue(BM1, "A1", "Bloqueo");
        result.addValue(BM2, "A2", "Bloqueo");
        result.addValue(BM3, "A3", "Bloqueo");
        result.addValue(BM4, "A4", "Bloqueo");
        result.addValue(BM5, "A5", "Bloqueo");
        result.addValue(BM6, "A6", "Bloqueo");
        
        result.addValue(AM1, "A1", "Remate");
        result.addValue(AM2, "A2", "Remate");
        result.addValue(AM3, "A3", "Remate");
        result.addValue(AM4, "A4", "Remate");
        result.addValue(AM5, "A5", "Remate");
        result.addValue(AM6, "A6", "Remate");
       
        result.addValue(CM1, "A1", "Pase");
        result.addValue(CM2, "A2", "Pase");
        result.addValue(CM3, "A3", "Pase");
        result.addValue(CM4, "A4", "Pase");
        result.addValue(CM5, "A5", "Pase");
        result.addValue(CM6, "A6", "Pase");
        
        result.addValue(DM1, "A1", "Defensa");
        result.addValue(DM2, "A2", "Defensa");
        result.addValue(DM3, "A3", "Defensa");
        result.addValue(DM4, "A4", "Defensa");
        result.addValue(DM5, "A5", "Defensa");
        result.addValue(DM6, "A6", "Defensa");
        
        return result;
    }
    
    protected ChartPanel GraficaMixtos(){
        
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        double S1 = 0, S2 = 0, S3 = 0, S4 = 0, S5 = 0, S6= 0;
        double R1 = 0, R2 = 0, R3 = 0, R4 = 0, R5 = 0, R6 = 0;
        double B1 = 0, B2 = 0, B3 = 0, B4 = 0, B5 = 0, B6 = 0;
        double A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0, A6 = 0;
        double C1 = 0, C2 = 0, C3 = 0, C4 = 0, C5 = 0, C6 = 0;
        double D1 = 0, D2 = 0, D3 = 0, D4 = 0, D5 = 0, D6 = 0;
        
        if (btnBuenosGrafica.isSelected() && btnContinuantesGrafico.isSelected()) {
           
            S1 = SB1 + SC1;
            S2 = SB2 + SC2;
            S3 = SB3 + SC3;
            S4 = SB4 + SC4;
            S5 = SB5 + SC5;
            S6 = SB6 + SC6;
            
            R1 = RB1 + RC1;
            R2 = RB2 + RC2;
            R3 = RB3 + RC3;
            R4 = RB4 + RC4;
            R5 = RB5 + RC5;
            R6 = RB6 + RC6;

            B1 = BB1 + BC1;
            B2 = BB2 + BC2;
            B3 = BB3 + BC3;
            B4 = BB4 + BC4;
            B5 = BB5 + BC5;
            B6 = BB6 + BC6;

            A1 = AB1 + AC1;
            A2 = AB2 + AC2;
            A3 = AB3 + AC3;
            A4 = AB4 + AC4;
            A5 = AB5 + AC5;
            A6 = AB6 + AC6;

            C1 = CB1 + CC1;
            C2 = CB2 + CC2;
            C3 = CB3 + CC3;
            C4 = CB4 + CC4;
            C5 = CB5 + CC5;
            C6 = CB6 + CC6;

            D1 = DB1 + DC1;
            D2 = DB2 + DC2;
            D3 = DB3 + DC3;
            D4 = DB4 + DC4;
            D5 = DB5 + DC5;
            D6 = DB6 + DC6;
        } else if (btnBuenosGrafica.isSelected()&& btnContinuantesGrafico.isSelected() && btnMalosGrafico.isSelected()) {
           
            S1 = SB1 + SC1 + SM1;
            S2 = SB2 + SC2 + SM2;
            S3 = SB3 + SC3 + SM3;
            S4 = SB4 + SC4 + SM4;
            S5 = SB5 + SC5 + SM5;
            S6 = SB6 + SC6 + SM6;
            
            R1 = RB1 + RC1 + RM1;
            R2 = RB2 + RC2 + RM2;
            R3 = RB3 + RC3 + RM3;
            R4 = RB4 + RC4 + RM4;
            R5 = RB5 + RC5 + RM5;
            R6 = RB6 + RC6 + RM6;

            B1 = BB1 + BC1 + BM1;
            B2 = BB2 + BC2 + BM2;
            B3 = BB3 + BC3 + BM3;
            B4 = BB4 + BC4 + BM4;
            B5 = BB5 + BC5 + BM5;
            B6 = BB6 + BC6 + BM6;

            A1 = AB1 + AC1 + AM1;
            A2 = AB2 + AC2 + AM2;
            A3 = AB3 + AC3 + AM3;
            A4 = AB4 + AC4 + AM4;
            A5 = AB5 + AC5 + AM5;
            A6 = AB6 + AC6 + AM6;

            C1 = CB1 + CC1 + CM1;
            C2 = CB2 + CC2 + CM2;
            C3 = CB3 + CC3 + CM3;
            C4 = CB4 + CC4 + CM4;
            C5 = CB5 + CC5 + CM5;
            C6 = CB6 + CC6 + CM6;

            D1 = DB1 + DC1 + DM1;
            D2 = DB2 + DC2 + CM2;
            D3 = DB3 + DC3 + DM3;
            D4 = DB4 + DC4 + DM4;
            D5 = DB5 + DC5 + DM5;
            D6 = DB6 + DC6 + DM6;
        } else if (btnMalosGrafico.isSelected() && btnContinuantesGrafico.isSelected()) {
            
            S1 = SM1 + SC1;
            S2 = SM2 + SC2;
            S3 = SM3 + SC3;
            S4 = SM4 + SC4;
            S5 = SM5 + SC5;
            S6 = SM6 + SC6;
            
            R1 = RM1 + RC1;
            R2 = RM2 + RC2;
            R3 = RM3 + RC3;
            R4 = RM4 + RC4;
            R5 = RM5 + RC5;
            R6 = RM6 + RC6;

            B1 = BM1 + BC1;
            B2 = BM2 + BC2;
            B3 = BM3 + BC3;
            B4 = BM4 + BC4;
            B5 = BM5 + BC5;
            B6 = BM6 + BC6;

            A1 = AM1 + AC1;
            A2 = AM2 + AC2;
            A3 = AM3 + AC3;
            A4 = AM4 + AC4;
            A5 = AM5 + AC5;
            A6 = AM6 + AC6;

            C1 = CM1 + CC1;
            C2 = CM2 + CC2;
            C3 = CM3 + CC3;
            C4 = CM4 + CC4;
            C5 = CM5 + CC5;
            C6 = CM6 + CC6;

            D1 = DM1 + DC1;
            D2 = DM2 + DC2;
            D3 = DM3 + DC3;
            D4 = DM4 + DC4;
            D5 = DM5 + DC5;
            D6 = DM6 + DC6;
        }else if (btnMalosGrafico.isSelected() && btnBuenosGrafica.isSelected()) {
            
            S1 = SM1 + SB1;
            S2 = SM2 + SB2;
            S3 = SM3 + SB3;
            S4 = SM4 + SB4;
            S5 = SM5 + SB5;
            S6 = SM6 + SB6;
            
            R1 = RM1 + RB1;
            R2 = RM2 + RB2;
            R3 = RM3 + RB3;
            R4 = RM4 + RB4;
            R5 = RM5 + RB5;
            R6 = RM6 + RB6;

            B1 = BM1 + BB1;
            B2 = BM2 + BB2;
            B3 = BM3 + BB3;
            B4 = BM4 + BB4;
            B5 = BM5 + BB5;
            B6 = BM6 + BB6;

            A1 = AM1 + AB1;
            A2 = AM2 + AB2;
            A3 = AM3 + AB3;
            A4 = AM4 + AB4;
            A5 = AM5 + AB5;
            A6 = AM6 + AB6;

            C1 = CM1 + CB1;
            C2 = CM2 + CB2;
            C3 = CM3 + CB3;
            C4 = CM4 + CB4;
            C5 = CM5 + CB5;
            C6 = CM6 + CB6;
            
            D1 = DM1 + DB1;
            D2 = DM2 + DB2;
            D3 = DM3 + DB3;
            D4 = DM4 + DB4;
            D5 = DM5 + DB5;
            D6 = DM6 + DB6;
        }else{
        
        }
        result.addValue(S1, "A1", "Saque");
        result.addValue(S2, "A2", "Saque");
        result.addValue(S3, "A3", "Saque");
        result.addValue(S4, "A4", "Saque");
        result.addValue(S5, "A5", "Saque");
        result.addValue(S6, "A6", "Saque");
        
        result.addValue(R1, "A1", "Recibo");
        result.addValue(R2, "A2", "Recibo");
        result.addValue(R3, "A3", "Recibo");
        result.addValue(R4, "A4", "Recibo");
        result.addValue(R5, "A5", "Recibo");
        result.addValue(R6, "A6", "Recibo");
        
        result.addValue(B1, "A1", "Bloqueo");
        result.addValue(B2, "A2", "Bloqueo");
        result.addValue(B3, "A3", "Bloqueo");
        result.addValue(B4, "A4", "Bloqueo");
        result.addValue(B5, "A5", "Bloqueo");
        result.addValue(B6, "A6", "Bloqueo");
        
        result.addValue(A1, "A1", "Remate");
        result.addValue(A2, "A2", "Remate");
        result.addValue(A3, "A3", "Remate");
        result.addValue(A4, "A4", "Remate");
        result.addValue(A5, "A5", "Remate");
        result.addValue(A6, "A6", "Remate");
        
        result.addValue(C1, "A1", "Pase");
        result.addValue(C2, "A2", "Pase");
        result.addValue(C3, "A3", "Pase");
        result.addValue(C4, "A4", "Pase");
        result.addValue(C5, "A5", "Pase");
        result.addValue(C6, "A6", "Pase");
        
        result.addValue(D1, "A1", "Defensa");
        result.addValue(D2, "A2", "Defensa");
        result.addValue(D3, "A3", "Defensa");
        result.addValue(D4, "A4", "Defensa");
        result.addValue(D5, "A5", "Defensa");
        result.addValue(D6, "A6", "Defensa");
        
        JFreeChart chart = ChartFactory.createBarChart("Estadisticas Jugador ",
                        "Movimiento", "Cantidad", result, PlotOrientation.VERTICAL, true, true, false);
        
        
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
        
        return panel;
    }
    
}
