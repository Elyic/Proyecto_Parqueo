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
import proyectoparqueo.Conexion;

/**
 *
 * @author Elyic
 */
public class AsociarCV {
   
    
    private Conexion conexion = new Conexion();
    int iIDGlobal;
    int iIDClienteGlobal;
    String sMatriculaGlobal;
    public boolean InsertarTablaAsociarCV(int ID_CLIENTE,String sMatricula){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                    //Asocia el id con la matricula en la tabla ASOCIARCV
                 PreparedStatement st = connecta.prepareStatement("INSERT INTO ASOCIARCV (ID_CLIENTE,MATRICULA) values (?,?)");
                  st.setInt(1, ID_CLIENTE);                  
                  st.setString(2,sMatricula);
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
    public boolean ConsultaTablaAsociarCV(String sMatricula, int ID_Cliente){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 Statement stConsulta =connecta.createStatement();
                 //Select para obtener los datos de la tabla ASOCIARCV
                 String sSQL ="SELECT COUNT(1),* from ASOCIARCV where ID_CLIENTE='"+ID_Cliente+"' and MATRICULA='"+sMatricula+"' group by ID,ID_CLIENTE,MATRICULA";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL); 
                 while(rsResultado.next()){                     
                  bVerificaUsuario = (rsResultado.getInt(1) > 0);
                  if (bVerificaUsuario) {
                     iIDGlobal=rsResultado.getInt(2); 
                     iIDClienteGlobal=rsResultado.getInt(3);
                     sMatriculaGlobal=rsResultado.getString("MATRICULA");
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
}
