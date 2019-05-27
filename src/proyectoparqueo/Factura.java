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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 
 */
public class Factura {
    int IDGlobal;
    String ClienteNombre;
    String ClienteApellido;
    String ClienteDPI;
    String VehiculoMatricula;
    String VehiculoModelo;
    String VehiculoColor;
    String VehiculoMarca;
    String FechaIngreso;
    float TarifaH;
    float TarifaM;
    int Parqueo;
    private Conexion conexion = new Conexion();
    public boolean InsertarTablaFactura(int idAsociarcv,String sFechaIngreso,float TarifaH,float TarifaM,int Posicion,String Fecha){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 //INSERT A TABLA FACTURA
                 String SQL = "INSERT INTO FACTURA (ID_ASOCIARCV,FECHA_INGRESO,TARIFAH,TARIFAM,DESCPARQ,FECHA) values (?,?,?,?,?,?)";
                 PreparedStatement preparedStmt = connecta.prepareStatement(SQL);
                 preparedStmt.setInt(1, idAsociarcv);
                 preparedStmt.setString(2, sFechaIngreso);                  
                 preparedStmt.setFloat(3, TarifaH);
                 preparedStmt.setFloat(4, TarifaM);
                 preparedStmt.setInt(5, Posicion);
                 preparedStmt.setString(6, Fecha);
                 preparedStmt.execute();
                  bVerificaUsuario=true;
                  connecta.close();                      
            }  
        } catch (SQLException ex) {
             bVerificaUsuario=false;
            ex.printStackTrace();
             
        }        
     return bVerificaUsuario; 
     }
    public boolean ConsultaTablaFactura(String sFecha){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 //SELECT PARA OBTENER EL No.(ID) DE LA FACTURA
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT COUNT(1),* FROM FACTURA WHERE FECHA_INGRESO  ='"+sFecha+"' group by ID,ID_ASOCIARCV,FECHA_INGRESO,FECHA_SALIDA,TARIFAH,TARIFAM,MONTO,DESCPARQ,FECHA";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while(rsResultado.next()){
                  bVerificaUsuario = (rsResultado.getInt(1) > 0);
                  IDGlobal=rsResultado.getInt(2);
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
    public boolean ConsultaTablaFactura(int ID_Factura){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD(); 
            if(connecta != null)
                {
                 //SELECT PARA OBTENER DATOS DE LA FACTURA
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="SELECT Count(1),\n" +
" CLIENTE.ID,CLIENTE.NOMBRE \n" +
" ,CLIENTE.APELLIDO\n" +
" ,CLIENTE.DPI\n" +
",VEHICULO.MATRICULA\n" +
",VEHICULO.MARCA\n" +
",VEHICULO.COLOR\n" +
",VEHICULO.MODELO\n" +
",FACTURA.ID\n" +
",FACTURA.FECHA_INGRESO\n" +
",FACTURA.FECHA_SALIDA\n" +
",FACTURA.TARIFAH\n" +
",FACTURA.TARIFAM\n" +
",FACTURA.MONTO\n" +
",FACTURA.DESCPARQ \n" +
"FROM FACTURA\n" +
"JOIN ASOCIARCV  ON ASOCIARCV.ID=FACTURA.ID_ASOCIARCV \n" +
"JOIN CLIENTE ON CLIENTE.ID=ASOCIARCV.ID_CLIENTE\n" +
"JOIN VEHICULO ON VEHICULO.MATRICULA = ASOCIARCV.MATRICULA\n" +
"WHERE FACTURA.ID= '"+ID_Factura+"'"
                         + "group by CLIENTE.ID,CLIENTE.NOMBRE, \n" +
"CLIENTE.APELLIDO,\n" +
"CLIENTE.DPI,\n" +
"VEHICULO.MATRICULA,\n" +
"VEHICULO.MARCA,\n" +
"VEHICULO.COLOR,\n" +
"VEHICULO.MODELO,\n" +
"FACTURA.ID,\n" +
"FACTURA.FECHA_INGRESO,\n" +
"FACTURA.FECHA_SALIDA,\n" +
"FACTURA.TARIFAH,\n" +
"FACTURA.TARIFAM,\n" +
"FACTURA.MONTO,\n" +
"FACTURA.DESCPARQ";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                 while(rsResultado.next()){
                  bVerificaUsuario = (rsResultado.getInt(1) > 0); 
                  IDGlobal=rsResultado.getInt(2);
                    ClienteNombre= rsResultado.getString("NOMBRE");
                    ClienteApellido = rsResultado.getString("APELLIDO");
                    ClienteDPI = rsResultado.getString("DPI");
                    VehiculoMatricula = rsResultado.getString("MATRICULA");
                    VehiculoModelo = rsResultado.getString("MODELO");
                    VehiculoColor = rsResultado.getString("COLOR");
                    VehiculoMarca = rsResultado.getString("MARCA");
                    FechaIngreso = rsResultado.getString("FECHA_INGRESO");
                    TarifaH = rsResultado.getFloat("TARIFAH");
                    TarifaM = rsResultado.getFloat("TARIFAM");
                    Parqueo = rsResultado.getInt("DESCPARQ");
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
    public boolean ActualizarTablaFactura(String FechaSalida, float Total, int ID){
        boolean bVerificaUsuario = false;  
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
            //UPDATE PARA INSERTAR EL TOTAL DE LA FACTURA
            PreparedStatement pstm = connecta.prepareStatement("update FACTURA set FECHA_SALIDA = ?, MONTO =? where id ='"+ID+"'");
            pstm.setString(1, FechaSalida);
            pstm.setFloat(2, Total);
            pstm.execute();
            pstm.close();
                  bVerificaUsuario=true;
                  connecta.close();           
            
            }  
        } catch (SQLException ex) {
             bVerificaUsuario=false;
            ex.printStackTrace();           
        }
        
     return bVerificaUsuario; 
     }
    public boolean CargarFechas(DefaultComboBoxModel modeloCombo){
        boolean bVerifica=false;
        try {
            Connection connecta = conexion.ConectarABD();
            if(connecta != null)
                {
                 // SELECT PARA OBTENER LAS FECHAS DE LAS FACTURAS
                 Statement stConsulta =connecta.createStatement();
                 String sSQL ="select distinct FECHA from FACTURA where not(MONTO IS NULL)";
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL); 
                 while(rsResultado.next()){
                modeloCombo.addElement(rsResultado.getObject(1));
                 }
            }  
        } catch (SQLException ex) {
            ex.printStackTrace();
             
        }
        return bVerifica;
    }
}
