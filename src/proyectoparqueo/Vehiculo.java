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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elyic
 */

public class Vehiculo {
    private Conexion conexion = new Conexion();
    //Declaracion de variables globales
    String sModeloGlobal ="";
    String sMatriculaGlobal="";
    String sMarcaGlobal ="";
    String sColorGlobal ="";
    public boolean InsertarTablaVehiculo(String sMatricula,String sModelo, String sColor, String sMarca){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 PreparedStatement st = connecta.prepareStatement("INSERT INTO VEHICULO (MATRICULA,MODELO,COLOR,MARCA) values (?,?,?,?)");
                  st.setString(1, sMatricula);                  
                  st.setString(2,sModelo);
                  st.setString(3,sColor);
                  st.setString(4, sMarca);
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
    
    
     public boolean ConsultaTablaVehiculo(String sMatricula){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD(); 
            if(connecta != null)
                {
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT COUNT(1),* FROM VEHICULO WHERE MATRICULA ='"+sMatricula+"' group by MATRICULA,COLOR,MODELO,MARCA";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while(rsResultado.next()){
                    bVerificaUsuario = (rsResultado.getInt(1) > 0);
                    if (bVerificaUsuario) 
                    {   
                   sMatriculaGlobal=rsResultado.getString("MATRICULA");
                  sModeloGlobal = rsResultado.getString("MODELO");
                  sColorGlobal =  rsResultado.getString("COLOR");
                  sMarcaGlobal =  rsResultado.getString("MARCA");                  
                     }
                 }
                  
                    if (bVerificaUsuario) 
                    {   
                    connecta.close();                    
                     }
                     else
                        {
                        bVerificaUsuario=false;
                        connecta.close();
                        }            
            
            }  
        } catch (SQLException ex) {
            
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario;  
    }
     public boolean ConsultarTablaVehiculo(DefaultTableModel tableModel, int ID_Cliente) throws SQLException
  {
     Connection connecta = conexion.ConectarABD();
     boolean bVerifica=false;
      // declaramos las variables para la carga de datos
        ResultSet resultado = null;
        //Declaramos un tablemodel para la carga de datos en una tabla en memoria
        tableModel.setRowCount(0);
        // valor count 0
        tableModel.setColumnCount(0);
        // valor count tanto a nivel de fila como de columna
        // preparamos la consulta a la base de datos y lo hacemos a traves de la variable
        // global con en el metodo prepareStatement ( y la consulta empieza con el comando select 
       // el dato * significa que son todos los datos y el siguiente comando el la tabla.
        
        PreparedStatement st = connecta.prepareStatement("SELECT \n" +
"VEHICULO.MATRICULA\n" +
",VEHICULO.COLOR\n" +
",VEHICULO.MODELO\n" +
",VEHICULO.MARCA\n"  +
"FROM \n" +
"CLIENTE\n" +
"JOIN ASOCIARCV\n" +
"ON ASOCIARCV.ID_CLIENTE = CLIENTE.ID\n" +
"JOIN VEHICULO\n" +
"ON ASOCIARCV.MATRICULA = VEHICULO.MATRICULA\n" +
"WHERE CLIENTE.ID = '"+ID_Cliente+"'");
        // siempre controlamos los errores
        try {
            // cargamos el resultado a la base de daots
            resultado = st.executeQuery();
            // si el resultao es nullo
            if(resultado != null)
            {
                // definirmos el numero de columnas que tiene tiene la data que se carga en resultado
                int numeroColumna = resultado.getMetaData().getColumnCount();
                // hacemos un ciclo for para cargar el nombre de las columnas en el jTable
                // utilizamos un ciclo for para agregar el nombre que aparece en la tabla de datos 
                for(int j = 1;j <= numeroColumna;j++)
                {
                    // cargamos el resultado de la consulta
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                // este while sirve para cargar los datos de las filas es decir los registros
                while(resultado.next())
                {
                    // cargamos los datos a un vector de tipo string
                    String []datos = new String[numeroColumna];
                    // rellenamos los datos a traves de un ciclo for
                    for(int i = 1;i <= numeroColumna;i++)
                    {
                           // asignamos la información al vector
                        datos[i-1] = (String) resultado.getString(i);
                        bVerifica=true;
                    }
                    tableModel.addRow(datos);
                }
            }
        }catch(SQLException e)
        {
              JOptionPane.showMessageDialog(null,"Error al realizar la actualización por"+e.getMessage());
        }

    finally  // para operaciones de finalización si se ejecutan o no.
     {
         try
         {
             /*
             st.Close cierra la conexión a la consulta
             con.Close cerramos la conexión a la base de datos
             Cerramos la conexión a la base de datos
             */
             st.close();
             connecta.close();
             
             if(resultado != null)
             {
                resultado.close();
             }
         }
         catch (Exception e)
         {
               JOptionPane.showMessageDialog(null,"Error al realizar la actualización por"+e.getMessage());
         }
     }
        return bVerifica;
  }
     public boolean ActualizarTablaVehiculo(String Matricula, String Modelo, String Color, String Marca){
        //Se crea una variable de tipo booleana para verificar que sea al menos de un registro
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            //Si es distinto de null significa que la conexion a la base de datos
            //fue exitosa 
            if(connecta != null)
                {
                    try{
                 PreparedStatement pstm = connecta.prepareStatement("update VEHICULO set MODELO = ?, COLOR = ?, MARCA = ? where MATRICULA ='"+Matricula+"'");            
            pstm.setString(1, Modelo);
            pstm.setString(2, Color);
            pstm.setString(3, Marca);
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
                        //Cerramos conexion
                        connecta.close();
                        }            
            
            }  
        } catch (SQLException ex) {
            
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario;  
    }
}
