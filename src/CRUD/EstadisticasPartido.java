/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jsaca
 */
public class EstadisticasPartido extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Variables de analisis Jugador">
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
    
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    
     Metodos metodos = new Metodos();
     
     int codPartido;
     int codJugadorSeleccionado;
     String equipo;
     String equipoContra;
     int year;
     int mes;
     String torneo;
     
     int [] setsPartido;
     int cod_equipo;
    
    public EstadisticasPartido(int cod_partido, String equipo_1, String equipo_2, int mes, int year, String torneo){
        initComponents();
        Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        this.setSize(width, height);
        jPanel1.setSize(this.getSize());
        
        codPartido = cod_partido;
        equipo = equipo_1;
        equipoContra = equipo_2;
        this.year = year;
        this.mes = mes;
        this.torneo = torneo;
        jlYear.setText("Año: " + year);
        switch(mes){
            case 1:
                jlMes.setText("Mes: Enero");
                break;
            case 2:
                jlMes.setText("Mes: Febrero");
                break;
            case 3:
                jlMes.setText("Mes: Marzo");
                break;
            case 4:
                jlMes.setText("Mes: Abril");
                break;
            case 5:
                jlMes.setText("Mes: Mayo");
                break;
            case 6:
                jlMes.setText("Mes: Junio");
                break;
            case 7:
                jlMes.setText("Mes: Julio");
                break;
            case 8:
                jlMes.setText("Mes: Agosto");
                break;
            case 9:
                jlMes.setText("Mes: Septiembre");
                break;
            case 10:
                jlMes.setText("Mes: Octubre");
                break;
            case 11:
                jlMes.setText("Mes: Noviembre");
                break;
            case 12:
                jlMes.setText("Mes: Diciembre");
                break;
            default:
                break;
        }
        jEquipo.setText("Equipo: " + equipo);
        jlEquipoContra.setText("Equipo en Contra: " + equipoContra);
        jlTorneo.setText("Torneo: " + torneo);
        
        setsPartido = setsDelPartido();
        
        cod_equipo = CodEquipo();
        
        metodos.mostrarJugadores(cod_equipo, jtJugadoresEquipo);
        
        for (int i = 0; i < setsPartido.length; i++) {
            ExtraerDatosPartido(setsPartido[i]);
        }
        PorcentajesJugador();
        MostrarPorcentajes(jlSaquesEquipoB, jlSaquesEquipoM, jlBloqueosEquipoB, jlBloqueosEquipoM, jlColoquesEquipoB, jlColoquesEquipoM, jlAtaquesEquipoB, jlAtaquesEquipoM, jlRecibosEquipoB, jlRecibosEquipoM, jlDefensaEquipoB, jlDefensaEquipoM,
                    jlSaquesEquipoR, jlBloqueosEquipoR, jlColoquesEquipoR, jlAtaquesEquipoR, jlRecibosEquipoR, jlDefensaEquipoR);
        
        
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jtJugadoresEquipo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jlSaquesEquipoB = new javax.swing.JLabel();
        jlBloqueosEquipoB = new javax.swing.JLabel();
        jlRecibosEquipoB = new javax.swing.JLabel();
        jlColoquesEquipoB = new javax.swing.JLabel();
        jlAtaquesEquipoB = new javax.swing.JLabel();
        jlDefensaEquipoB = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlSaquesEquipoM = new javax.swing.JLabel();
        jlBloqueosEquipoM = new javax.swing.JLabel();
        jlRecibosEquipoM = new javax.swing.JLabel();
        jlColoquesEquipoM = new javax.swing.JLabel();
        jlAtaquesEquipoM = new javax.swing.JLabel();
        jlDefensaEquipoM = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlSaquesEquipoR = new javax.swing.JLabel();
        jlBloqueosEquipoR = new javax.swing.JLabel();
        jlRecibosEquipoR = new javax.swing.JLabel();
        jlColoquesEquipoR = new javax.swing.JLabel();
        jlAtaquesEquipoR = new javax.swing.JLabel();
        jlDefensaEquipoR = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnVerEstadisticas = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelGraficaEquipo = new javax.swing.JPanel();
        btnBuenosGrafica = new javax.swing.JToggleButton();
        btnContinuantesGrafico = new javax.swing.JToggleButton();
        btnMalosGrafico = new javax.swing.JToggleButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jlSaquesJugadorB = new javax.swing.JLabel();
        jlBloqueosJugadorB = new javax.swing.JLabel();
        jlRecibosJugdorB = new javax.swing.JLabel();
        jlColoquesJugadorB = new javax.swing.JLabel();
        jlAtaquesJugadorB = new javax.swing.JLabel();
        jlDefensaJugadorB = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlSaquesJugadorM = new javax.swing.JLabel();
        jlBloqueosJugadorM = new javax.swing.JLabel();
        jlRecibosJugadorM = new javax.swing.JLabel();
        jlColoquesJugadorM = new javax.swing.JLabel();
        jlAtaquesJugadorM = new javax.swing.JLabel();
        jlDefensaJugadorM = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlSaquesJugadorR = new javax.swing.JLabel();
        jlBloqueosJugadorR = new javax.swing.JLabel();
        jlRecibosJugadorR = new javax.swing.JLabel();
        jlColoquesJugadorR = new javax.swing.JLabel();
        jlAtaquesJugadorR = new javax.swing.JLabel();
        jlDefensaJugadorR = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jlYear = new javax.swing.JLabel();
        jlMes = new javax.swing.JLabel();
        jEquipo = new javax.swing.JLabel();
        jlEquipoContra = new javax.swing.JLabel();
        jlTorneo = new javax.swing.JLabel();
        panelGraficaJugador = new javax.swing.JPanel();
        btnGraficar = new javax.swing.JButton();
        btnContinuantesGraficoJugador = new javax.swing.JToggleButton();
        btnMalosGraficoJugador = new javax.swing.JToggleButton();
        btnBuenosGraficaJugador = new javax.swing.JToggleButton();
        btnGraficarJugador = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jtJugadoresEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jtJugadoresEquipo);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Estadisticas Del Partido");

        jLabel14.setText("Buenos");

        jlSaquesEquipoB.setText("Saques");

        jlBloqueosEquipoB.setText("Bloqueos");

        jlRecibosEquipoB.setText("Recibos");

        jlColoquesEquipoB.setText("Coloques");

        jlAtaquesEquipoB.setText("Ataques");

        jlDefensaEquipoB.setText("Defensa");

        jLabel15.setText("Malos");

        jlSaquesEquipoM.setText("Saques");

        jlBloqueosEquipoM.setText("Bloqueos");

        jlRecibosEquipoM.setText("Recibos");

        jlColoquesEquipoM.setText("Coloques");

        jlAtaquesEquipoM.setText("Ataques");

        jlDefensaEquipoM.setText("Defensa");

        jLabel16.setText("Realizados");

        jlSaquesEquipoR.setText("Saques");

        jlBloqueosEquipoR.setText("Bloqueos");

        jlRecibosEquipoR.setText("Recibos");

        jlColoquesEquipoR.setText("Coloques");

        jlAtaquesEquipoR.setText("Ataques");

        jlDefensaEquipoR.setText("Defensa");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Estdisticas Del Partido");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlDefensaEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlBloqueosEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlSaquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlColoquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlRecibosEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlAtaquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(107, 107, 107)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlDefensaEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBloqueosEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jlSaquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlColoquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jlRecibosEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jlAtaquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(3, 3, 3)))
                .addGap(83, 83, 83)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlAtaquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlRecibosEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jlColoquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jlSaquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jlBloqueosEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jlDefensaEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(64, 64, 64))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(155, 155, 155))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlSaquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlBloqueosEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecibosEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlColoquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAtaquesEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDefensaEquipoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSaquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSaquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlBloqueosEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlBloqueosEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlRecibosEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlRecibosEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlColoquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlColoquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAtaquesEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlAtaquesEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDefensaEquipoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDefensaEquipoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
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

        javax.swing.GroupLayout panelGraficaEquipoLayout = new javax.swing.GroupLayout(panelGraficaEquipo);
        panelGraficaEquipo.setLayout(panelGraficaEquipoLayout);
        panelGraficaEquipoLayout.setHorizontalGroup(
            panelGraficaEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraficaEquipoLayout.setVerticalGroup(
            panelGraficaEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        btnBuenosGrafica.setText("Buenos");

        btnContinuantesGrafico.setText("Continuantes");

        btnMalosGrafico.setText("Malos");

        jLabel17.setText("Buenos");

        jlSaquesJugadorB.setText("Saques");

        jlBloqueosJugadorB.setText("Bloqueos");

        jlRecibosJugdorB.setText("Recibos");

        jlColoquesJugadorB.setText("Coloques");

        jlAtaquesJugadorB.setText("Ataques");

        jlDefensaJugadorB.setText("Defensa");

        jLabel18.setText("Malos");

        jlSaquesJugadorM.setText("Saques");

        jlBloqueosJugadorM.setText("Bloqueos");

        jlRecibosJugadorM.setText("Recibos");

        jlColoquesJugadorM.setText("Coloques");

        jlAtaquesJugadorM.setText("Ataques");

        jlDefensaJugadorM.setText("Defensa");

        jLabel19.setText("Realizados");

        jlSaquesJugadorR.setText("Saques");

        jlBloqueosJugadorR.setText("Bloqueos");

        jlRecibosJugadorR.setText("Recibos");

        jlColoquesJugadorR.setText("Coloques");

        jlAtaquesJugadorR.setText("Ataques");

        jlDefensaJugadorR.setText("Defensa");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Estdisticas Jugador");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlDefensaJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlBloqueosJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlSaquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlColoquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlRecibosJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlAtaquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlDefensaJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBloqueosJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jlSaquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlColoquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jlRecibosJugdorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jlAtaquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(3, 3, 3)))
                .addGap(83, 83, 83)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlAtaquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jlRecibosJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(jlColoquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jlSaquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jlBloqueosJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jlDefensaJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(61, 61, 61))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(136, 136, 136))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlSaquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlBloqueosJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecibosJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlColoquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAtaquesJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDefensaJugadorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSaquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSaquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlBloqueosJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlBloqueosJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlRecibosJugdorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlRecibosJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlColoquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlColoquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAtaquesJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlAtaquesJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDefensaJugadorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDefensaJugadorM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setText("Informacion del Partido");

        jlYear.setText("Año: ");

        jlMes.setText("Mes: ");

        jEquipo.setText("Equipo: ");

        jlEquipoContra.setText("Equipo en Contra: ");

        jlTorneo.setText("Torneo: ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(131, 131, 131))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlEquipoContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129)))
                .addGap(74, 74, 74))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jlEquipoContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGraficaJugadorLayout = new javax.swing.GroupLayout(panelGraficaJugador);
        panelGraficaJugador.setLayout(panelGraficaJugadorLayout);
        panelGraficaJugadorLayout.setHorizontalGroup(
            panelGraficaJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        panelGraficaJugadorLayout.setVerticalGroup(
            panelGraficaJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        btnContinuantesGraficoJugador.setText("Continuantes");

        btnMalosGraficoJugador.setText("Malos");

        btnBuenosGraficaJugador.setText("Buenos");

        btnGraficarJugador.setText("Graficar");
        btnGraficarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(581, 581, 581)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1020, 1020, 1020))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGraficaEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuenosGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(230, 230, 230)
                        .addComponent(btnContinuantesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(255, 255, 255)
                        .addComponent(btnMalosGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(975, 975, 975))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(104, 104, 104)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnContinuantesGraficoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMalosGraficoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuenosGraficaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGraficaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(450, 450, 450))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(730, 730, 730)
                .addComponent(btnGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1191, 1191, 1191))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(974, 974, 974)
                .addComponent(btnGraficarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(605, 605, 605))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(210, 210, 210))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGraficaEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(150, 150, 150)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMalosGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnContinuantesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuenosGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addComponent(btnGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelGraficaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGraficarJugador)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuenosGraficaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86)
                        .addComponent(btnContinuantesGraficoJugador)
                        .addGap(93, 93, 93)
                        .addComponent(btnMalosGraficoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(113, 113, 113))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1807, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEstadisticasActionPerformed
        codJugadorSeleccionado = 0;
        codJugadorSeleccionado = Integer.parseInt(jtJugadoresEquipo.getValueAt(jtJugadoresEquipo.getSelectedRow(), 0).toString());
        System.out.println(codJugadorSeleccionado);
        panelGraficaJugador.removeAll();
        ResetAnalisis();
        int cod_jugador = metodos.codEquipoSeleccionado(jtJugadoresEquipo);

        metodos.mostrarJugadores(cod_equipo, jtJugadoresEquipo);
        
        for (int i = 0; i < setsPartido.length; i++) {
            ExtraerDatos(cod_jugador, setsPartido[i]);
        }
            
        PorcentajesJugador();
        MostrarPorcentajes(jlSaquesJugadorB, jlSaquesJugadorM, jlBloqueosJugadorB, jlBloqueosJugadorM, jlColoquesJugadorB, jlColoquesJugadorM, jlAtaquesJugadorB, jlAtaquesJugadorM, jlRecibosJugdorB, jlRecibosJugadorM, jlDefensaJugadorB, jlDefensaJugadorM,
            jlSaquesJugadorR, jlBloqueosJugadorR, jlColoquesJugadorR, jlAtaquesJugadorR, jlRecibosJugadorR, jlDefensaJugadorR);

        ChartPanel panel = GraficaJugador(CrearDatasetBuenos());
        panel.setSize(panelGraficaJugador.getSize());
        panelGraficaJugador.add(panel);

    }//GEN-LAST:event_btnVerEstadisticasActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Menu menu = new Menu();

        Main.Escritorio.add(menu);
        menu.setVisible(true);
        menu.setSize(Main.Escritorio.getSize());

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        ResetAnalisis();
        
        for (int i = 0; i < setsPartido.length; i++) {
            ExtraerDatosPartido(setsPartido[i]);
        }
        
        if (btnBuenosGrafica.isSelected() || btnMalosGrafico.isSelected() || btnContinuantesGrafico.isSelected()) {
            if (btnBuenosGrafica.isSelected()) {
                panelGraficaEquipo.removeAll();
                ChartPanel panel = GraficaEquipo(CrearDatasetBuenos());
                panel.setSize(panelGraficaEquipo.getSize());
                panelGraficaEquipo.add(panel);
            } else if (btnMalosGrafico.isSelected()) {
                panelGraficaEquipo.removeAll();
                ChartPanel panel = GraficaEquipo(CrearDatasetMalos());
                panel.setSize(panelGraficaEquipo.getSize());
                panelGraficaEquipo.add(panel);
            } else if (btnContinuantesGrafico.isSelected()) {
                panelGraficaEquipo.removeAll();
                ChartPanel panel = GraficaEquipo(CrearDatasetContinuantes());
                panel.setSize(panelGraficaEquipo.getSize());
                panelGraficaEquipo.add(panel);
            }else{
                panelGraficaEquipo.removeAll();
                ChartPanel panel = GraficaMixtos();
                panel.setSize(panelGraficaEquipo.getSize());
                panelGraficaEquipo.add(panel);
            }
        } else{
                panelGraficaEquipo.removeAll();
                ChartPanel panel = GraficaEquipo(CrearDatasetBuenos());
                panel.setSize(panelGraficaEquipo.getSize());
                panelGraficaEquipo.add(panel);
        }
            
        btnBuenosGrafica.setSelected(false);
        btnMalosGrafico.setSelected(false);
        btnContinuantesGrafico.setSelected(false);
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void btnGraficarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarJugadorActionPerformed
        if (codJugadorSeleccionado != 0) {
            if (btnBuenosGraficaJugador.isSelected() || btnMalosGraficoJugador.isSelected() || btnContinuantesGraficoJugador.isSelected()){
                if (btnBuenosGraficaJugador.isSelected()) {
                    panelGraficaJugador.removeAll();
                    ChartPanel panel = GraficaJugador(CrearDatasetBuenos());
                    panel.setSize(panelGraficaJugador.getSize());
                    panelGraficaJugador.add(panel);
                } else if (btnMalosGraficoJugador.isSelected()) {
                    panelGraficaJugador.removeAll();
                    ChartPanel panel = GraficaJugador(CrearDatasetMalos());
                    panel.setSize(panelGraficaJugador.getSize());
                    panelGraficaJugador.add(panel);
                } else if (btnContinuantesGraficoJugador.isSelected()) {
                    panelGraficaJugador.removeAll();
                    ChartPanel panel = GraficaJugador(CrearDatasetContinuantes());
                    panel.setSize(panelGraficaJugador.getSize());
                    panelGraficaJugador.add(panel);
                }else{
                    panelGraficaJugador.removeAll();
                    ChartPanel panel = GraficaMixtos();
                    panel.setSize(panelGraficaJugador.getSize());
                    panelGraficaJugador.add(panel);
                }
            }else{
                panelGraficaJugador.removeAll();
                ChartPanel panel = GraficaJugador(CrearDatasetBuenos());
                panel.setSize(panelGraficaJugador.getSize());
                panelGraficaJugador.add(panel);
            }
        
            btnBuenosGraficaJugador.setSelected(false);
            btnMalosGraficoJugador.setSelected(false);
            btnContinuantesGraficoJugador.setSelected(false);
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGraficarJugadorActionPerformed

// <editor-fold defaultstate="collapsed" desc="Variables declaration">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JToggleButton btnBuenosGrafica;
    private javax.swing.JToggleButton btnBuenosGraficaJugador;
    private javax.swing.JToggleButton btnContinuantesGrafico;
    private javax.swing.JToggleButton btnContinuantesGraficoJugador;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnGraficarJugador;
    private javax.swing.JToggleButton btnMalosGrafico;
    private javax.swing.JToggleButton btnMalosGraficoJugador;
    private javax.swing.JButton btnVerEstadisticas;
    private javax.swing.JLabel jEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlAtaquesEquipoB;
    private javax.swing.JLabel jlAtaquesEquipoM;
    private javax.swing.JLabel jlAtaquesEquipoR;
    private javax.swing.JLabel jlAtaquesJugadorB;
    private javax.swing.JLabel jlAtaquesJugadorM;
    private javax.swing.JLabel jlAtaquesJugadorR;
    private javax.swing.JLabel jlBloqueosEquipoB;
    private javax.swing.JLabel jlBloqueosEquipoM;
    private javax.swing.JLabel jlBloqueosEquipoR;
    private javax.swing.JLabel jlBloqueosJugadorB;
    private javax.swing.JLabel jlBloqueosJugadorM;
    private javax.swing.JLabel jlBloqueosJugadorR;
    private javax.swing.JLabel jlColoquesEquipoB;
    private javax.swing.JLabel jlColoquesEquipoM;
    private javax.swing.JLabel jlColoquesEquipoR;
    private javax.swing.JLabel jlColoquesJugadorB;
    private javax.swing.JLabel jlColoquesJugadorM;
    private javax.swing.JLabel jlColoquesJugadorR;
    private javax.swing.JLabel jlDefensaEquipoB;
    private javax.swing.JLabel jlDefensaEquipoM;
    private javax.swing.JLabel jlDefensaEquipoR;
    private javax.swing.JLabel jlDefensaJugadorB;
    private javax.swing.JLabel jlDefensaJugadorM;
    private javax.swing.JLabel jlDefensaJugadorR;
    private javax.swing.JLabel jlEquipoContra;
    private javax.swing.JLabel jlMes;
    private javax.swing.JLabel jlRecibosEquipoB;
    private javax.swing.JLabel jlRecibosEquipoM;
    private javax.swing.JLabel jlRecibosEquipoR;
    private javax.swing.JLabel jlRecibosJugadorM;
    private javax.swing.JLabel jlRecibosJugadorR;
    private javax.swing.JLabel jlRecibosJugdorB;
    private javax.swing.JLabel jlSaquesEquipoB;
    private javax.swing.JLabel jlSaquesEquipoM;
    private javax.swing.JLabel jlSaquesEquipoR;
    private javax.swing.JLabel jlSaquesJugadorB;
    private javax.swing.JLabel jlSaquesJugadorM;
    private javax.swing.JLabel jlSaquesJugadorR;
    private javax.swing.JLabel jlTorneo;
    private javax.swing.JLabel jlYear;
    private javax.swing.JTable jtJugadoresEquipo;
    private javax.swing.JPanel panelGraficaEquipo;
    private javax.swing.JPanel panelGraficaJugador;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    
    protected void ExtraerDatos(int cod_jugador, int cod_set){
        
        String SQL = "Select * from datos";
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                if (rs.getInt("cod_jugador") == cod_jugador && rs.getInt("cod_set") == cod_set) {
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

    protected void PorcentajesJugador(){

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
    
    protected void MostrarPorcentajes(javax.swing.JLabel jlSaquesB, javax.swing.JLabel jlSaquesM, javax.swing.JLabel jlBloqueosB, javax.swing.JLabel jlBloqueosM, javax.swing.JLabel jlColoquesB, javax.swing.JLabel jlColoquesM,
            javax.swing.JLabel jlAtaquesB, javax.swing.JLabel jlAtaquesM, javax.swing.JLabel jlRecibosB, javax.swing.JLabel jlRecibosM, javax.swing.JLabel jlDefensaB, javax.swing.JLabel jlDefensaM,
            javax.swing.JLabel jlSaquesR, javax.swing.JLabel jlBloqueosR, javax.swing.JLabel jlColoquesR, javax.swing.JLabel jlAtaquesR, javax.swing.JLabel jlRecibosR, javax.swing.JLabel jlDefensaR){
        
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
    
    protected ChartPanel GraficaEquipo(CategoryDataset result){
        
        CategoryDataset dataset = result;
        
        JFreeChart chart = ChartFactory.createBarChart("Estadisticas Equipo ",
                        "Movimiento", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
        
        return panel;      
    }
    
    protected ChartPanel GraficaJugador(CategoryDataset result){
        
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

    private int [] setsDelPartido(){
        int [] sets;
        int nsets = 0;
        
        String SQL = "Select * from sets";
        
        
        
        try{
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                if (rs.getInt("cod_partido") == codPartido) {
                    nsets ++;
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al contar sets " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        sets = new int[nsets];
        int i = 0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                if (rs.getInt("cod_partido") == codPartido) {
                    sets[i] = rs.getInt("cod_set");
                    i++;
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al extaer sets " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return sets;
    }

    private int CodEquipo(){
        int cod_equipo = 0;
        String SQL = "Select * from datos";
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while(rs.next()){
                if(rs.getInt("cod_set") == setsPartido[0]){
                    cod_equipo = rs.getInt("cod_equipo");
                    break;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al encontrar equipo " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cod_equipo;
    }
    protected void ExtraerDatosPartido(int cod_set){
        
        String SQL = "Select * from datos";
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                if (rs.getInt("cod_set") == cod_set) {
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
}
