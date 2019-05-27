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

/**
 *
 * @author 
 */
public class Parqueo {
    private Conexion conexion = new Conexion();
    int ID_Factura;
    public boolean ConsultaTablaParqueo(int Posicion){
        boolean bVerificaUsuario = false;
        boolean bVerificaPosicion = false;
        int iEstado=0;
        try {
            Connection connecta = conexion.ConectarABD(); 
            if(connecta != null)
                {
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT COUNT(1),* FROM PARQUEO WHERE ID ='"+Posicion+"' group by ID,ESTADO,ID_FACTURA";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while(rsResultado.next()){
                     bVerificaUsuario = (rsResultado.getInt(1) > 0);
                    iEstado=rsResultado.getInt(3);
                    if (iEstado>0) {
                        bVerificaPosicion=false;
                        ID_Factura=rsResultado.getInt(4);
                    }else{
                        bVerificaPosicion=true;
                        
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
     return bVerificaPosicion;  
    }
    public boolean ActualizarTablaParqueo(int Posicion){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                    try{
                 PreparedStatement pstm = connecta.prepareStatement("update PARQUEO set ESTADO = ? where id ='"+Posicion+"'");            
            pstm.setInt(1, 0);
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
    public boolean ActualizarTablaParqueo(int Posicion, int iID_Factura){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD(); 
            if(connecta != null)
                {
                    try{
                 PreparedStatement pstm = connecta.prepareStatement("update PARQUEO set ESTADO=?, ID_FACTURA=? where id ='"+Posicion+"'");            
            pstm.setInt(1, 1);
            pstm.setInt(2, iID_Factura);
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
    public int[] EstadoTablaParqueo(int[] estado){
        try {
            int x=0;
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {          
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT * FROM PARQUEO";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL); 
                 while(rsResultado.next()){
                     estado[x]=rsResultado.getInt("ESTADO");
                     x++;
                 }
            }  
        } catch (SQLException ex) {
            ex.printStackTrace();
             
        }
        return estado;
    }
}
