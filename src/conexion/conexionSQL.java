/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author jsaca
 */
public class conexionSQL {
    
    Connection conectar = null;
    
    public Connection conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/volleypoints", "root", "");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXION" + e.getMessage());
        }
        return conectar;
    }
}
