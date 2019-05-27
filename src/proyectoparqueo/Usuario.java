/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Elyic
 */
public class Usuario {
   
    Conexion conexion = new Conexion();
      
    public boolean ConsultaTablaUsuario(String sUsuario, String sCotrasena){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD(); 
            if(connecta != null)
                {
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT COUNT(1) FROM USUARIO WHERE usern ='"+sUsuario+"' AND contrasena = '"+sCotrasena+"'";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while (rsResultado.next()) {
                    bVerificaUsuario = (rsResultado.getInt(1) > 0);
                }
                    if (bVerificaUsuario) 
                    {                     
                    JOptionPane.showMessageDialog(null, "BIENVENIDO : "+sUsuario);
                    connecta.close();                    
                     }
                     else
                        {
                        JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrectos!");
                        connecta.close();
                        }            
            
            }  
        } catch (SQLException ex) {
            
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario;  
    }
}
