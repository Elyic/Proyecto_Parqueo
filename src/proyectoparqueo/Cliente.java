/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Elyic
 */
public class Cliente {
    
    private Conexion conexion = new Conexion();
    String sNombreGlobal="";
    String sDPIGlobal="";
    int IDGlobal=0;
    String sApellidoGlobal = "";
    public boolean ConsultaTablaCliente(String sDPI){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 Statement stConsulta =connecta.createStatement();
                 //SELECT PARA OBTENER LOS DATOS DEL CLIENTE
                 String sSQL ="SELECT COUNT(1),* FROM CLIENTE WHERE DPI  ='"+sDPI+"' group by ID,NOMBRE,DPI,APELLIDO";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while(rsResultado.next()){
                   bVerificaUsuario = (rsResultado.getInt(1) > 0);
                     if (bVerificaUsuario) {                        
                  IDGlobal=rsResultado.getInt(2);
                  sNombreGlobal = rsResultado.getString("NOMBRE");
                  sDPIGlobal =  rsResultado.getString("DPI");
                  sApellidoGlobal = rsResultado.getString("APELLIDO");
                     }  
                 }
                  
                    if (bVerificaUsuario) 
                    {                     
                    connecta.close();        
                     }
                     else
                        {
                        connecta.close();
                        }            
            
            }  
        } catch (SQLException ex) {
            
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario;  
    }
    
     public boolean InsertarTablaCliente(String sNombre,String sDPI,String sApellido){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                    //INSERT A LA TABLA CLIENTE
                 PreparedStatement st = connecta.prepareStatement("INSERT INTO CLIENTE (NOMBRE,DPI,APELLIDO) values (?,?,?)");
                  st.setString(1, sNombre);                  
                  st.setString(2,sDPI);
                  st.setString(3, sApellido);
                  st.execute();
                  bVerificaUsuario=true;
                  connecta.close();           
            
            }  
        } catch (SQLException ex) {
             bVerificaUsuario=false;
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario; 
     }
     public boolean ActualizarTablaCliente(String DPI, String Nombre, String Apellido){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                    try{
                        //UPDATE A TABLA CLIENTE (ACTIVA UN TRIGGER)
                 PreparedStatement pstm = connecta.prepareStatement("update CLIENTE set NOMBRE = ?, APELLIDO = ? where DPI ='"+DPI+"'");            
            pstm.setString(1, Nombre);
            pstm.setString(2, Apellido);
            pstm.execute();
            pstm.close();
            bVerificaUsuario=true;
         }catch(SQLException e){
         System.out.println(e);
      }
                    if (bVerificaUsuario) 
                    {                     
                    connecta.close();        
                     }
                     else
                        {
                        connecta.close();
                        }            
            
            }  
        } catch (SQLException ex) {
            
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario;  
    }
}
