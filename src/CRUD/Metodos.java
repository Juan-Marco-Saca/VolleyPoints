
package CRUD;

import conexion.conexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    int sin_equipo = 81;
    
    protected String[] extraerEquipo(int cod_equipo){
        String [] equipo = new String[2];
        String SQL = "Select * from equipos";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            
            if (rs.getInt("cod_equipo") == cod_equipo) {
                equipo[0] = rs.getString("cod_equipo");
                equipo[1] = rs.getString("nombre");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al extraer el equipo" + e.getMessage());
        }        
        return equipo;
    }
    
    public Integer codEquipoSeleccionado(javax.swing.JTable tabla){
        
        int filaSeleccionada = tabla.getSelectedRow();
        
        int cod_equipo = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString());
        
        return cod_equipo;
    }
    
    protected void mostrarJugadores(int cod_equipo, javax.swing.JTable tabla){
   
      String[] titulos = {"Codigo", "Nombre", "Apellido", "Numero", "Posicion", "Codigo Equipo"};
      DefaultTableModel modelo = new DefaultTableModel(null, titulos);
      
      String[] registros = new String[6];
      
      String SQL = "Select * from jugadores";
      
      try{
          
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(SQL);
          
          while(rs.next()){
              if(rs.getInt("cod_equipo_de_jugador") == cod_equipo){
                registros[0] = rs.getString("cod_jugador");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Apellidos");
                registros[3] = rs.getString("Numero_Jugador");
                registros[4] = rs.getString("Posicion");
                if(registros[4].equals("1")){
                    registros[4] = "Pasador";
                } else if(registros[4].equals("2")){
                    registros[4] = "Lateral";
                }else if(registros[4].equals("3")){
                    registros[4] = "Quinto";
                } else if(registros[4].equals("4")){
                    registros[4] = "Centro";
                }else{
                    registros[4] = "Libero";
                }
                registros[5] = rs.getString("cod_equipo_de_jugador");  
                
                modelo.addRow(registros);
              }else{
                  
              }
          }
          
          tabla.setModel(modelo);
          
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR JUGADORES" + e.getMessage());
      }   
   }
    
    protected void cambiarEquipoDeJugador(int cod_equipo_de_jugador, javax.swing.JTable tabla){
       int filaSeleccionada = tabla.getSelectedRow();
       
       int cod_jugador = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString());
       String nombre = tabla.getValueAt(filaSeleccionada, 1).toString();
       String apellidos = tabla.getValueAt(filaSeleccionada, 2).toString();
       int numero_jugador = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 3).toString());
       String posicion = tabla.getValueAt(filaSeleccionada, 4).toString();
       int id_posicion = 0;
       if(posicion.equals("Pasador")){
                    id_posicion = 1;
                } else if(posicion.equals("Lateral")){
                    id_posicion = 2;
                }else if(posicion.equals("Quinto")){
                    id_posicion = 3;
                } else if(posicion.equals("Centro")){
                    id_posicion = 4;
                }else{
                    id_posicion = 5;
                }

       try{
           PreparedStatement pst = con.prepareStatement("UPDATE jugadores SET Nombre='"+nombre+"', Apellidos='"+apellidos+"', Numero_Jugador='"+numero_jugador+"', Posicion='"+id_posicion+"', cod_equipo_de_jugador='"+cod_equipo_de_jugador+"' WHERE cod_jugador='"+cod_jugador+"'");
           pst.executeUpdate();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al cambiar el equipo del jugador " + e.getMessage());
       }
   }

    protected DefaultTableModel cambioDeTabla(javax.swing.JTable tablaI, javax.swing.JTable tablaF, DefaultTableModel modeloI, DefaultTableModel modeloF){

        int filaSeleccionada = tablaI.getSelectedRow();
        
        String [] jugador = new String [6];
        
        if(filaSeleccionada >= 0){
            for (int i = 0; i < 6; i++) {
                jugador[i] = tablaI.getValueAt(filaSeleccionada, i).toString();
            } 
        }
        
        
       
        modeloF.addRow(jugador);
        tablaF.setModel(modeloF);
        modeloI = (DefaultTableModel)tablaI.getModel();
        modeloI.removeRow(filaSeleccionada);

        return modeloI;
    }

    protected void Rotacion(boolean saca, int cod_titulares[], javax.swing.JLabel jl1, javax.swing.JLabel jl2, javax.swing.JLabel jl3, javax.swing.JLabel jl4, javax.swing.JLabel jl5, javax.swing.JLabel jl6){
        
        if (saca == true) {
            int last = cod_titulares[6 - 1];
            for (int i = 6 - 2; i >= 0; i--) {
                cod_titulares[i + 1] = cod_titulares[i];
            }

            cod_titulares[0] = last;
            
            jl1.setText(Integer.toString(cod_titulares[0]));
            jl2.setText(Integer.toString(cod_titulares[5]));
            jl3.setText(Integer.toString(cod_titulares[4]));
            jl4.setText(Integer.toString(cod_titulares[3]));
            jl5.setText(Integer.toString(cod_titulares[2]));
            jl6.setText(Integer.toString(cod_titulares[1]));
        } else{
            
        }
    
    }
    
    protected Integer codPartido(){
        int cod_partido = 0;
        String SQL = "Select cod_partido from partido";
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            rs.last();
            
            cod_partido = rs.getInt("cod_partido");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al extraer codigo de partido " + e.getMessage());
        }
        
        return cod_partido;
    }
    
    protected Integer codSet(){
       int cod_set = 0;
       
       String SQL = "Select cod_set from sets";
       
       try{
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           
           rs.last();
           
           cod_set = rs.getInt("cod_set");
           
           
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL CONSEGUIR EL CODIGO DEL SET " + e.getMessage());
       }
       
       return cod_set;
   }
   
    protected void mostrarEquipos(javax.swing.JTable tabla){
        String [] titulos = {"Codigo", "Equipo"};
        String [] registros = new String[2];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "Select * from equipos";
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                if(rs.getInt("cod_equipo")!= 81){
                    registros[0] = rs.getString("cod_equipo");
                    registros[1] = rs.getString("Nombre");  
                    modelo.addRow(registros);
                }
            }
            
            tabla.setModel(modelo);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar los equipos " + e.getMessage());
        }
    }
    
    protected int[] codigoJugadores(javax.swing.JTable tabla){
        int [] cod = new int[6];
    
    
        for (int i = 0; i < tabla.getRowCount(); i++) {
            cod[i] = Integer.parseInt(tabla.getValueAt(i, 0).toString());
        }
    
        return cod;
    }
    
}
               
                        
        
        
    
