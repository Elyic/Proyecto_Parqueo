/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Elyic
 */
public class Conexion {

    private Connection connecta;
    
    
     public Connection ConectarABD(){ 
         String bd = "Parqueo";
        String user= "sa";
        String pass = "123";
     try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String bdconect ="jdbc:sqlserver://localhost:1433;databaseName="+bd+";user="+user+";password="+pass+";";
        connecta = DriverManager.getConnection(bdconect);
         return connecta;
      }
      catch(Exception e)
            {
               System.out.println(e);         
            }
        return null; 
     }
    
}
