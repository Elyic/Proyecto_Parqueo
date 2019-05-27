/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Elyic
 */
public class jfiIngresoParqueo extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfiIngresoParqueo
     */
    private Cliente cliente = new Cliente();
    private Vehiculo vehiculo = new Vehiculo();
    private String sfecha="";
    private String Fecha="";
    private int iPosicion=1;
    private String sMatricula="";
            Factura factura = new Factura();
        AsociarCV asociarcv = new AsociarCV();
        Parqueo parqueo = new Parqueo();
    public jfiIngresoParqueo(int n) {
        initComponents();
        btnIngresoVehiculo.setEnabled(false);
        btnTicket.setEnabled(false);
        if (n>0) {
            spPosicion.setEnabled(false);
            spPosicion.setValue(n);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDPI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCodigoInterno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVehiculos = new javax.swing.JTable();
        btnIngresoVehiculo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        spPosicion = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        btnTicket = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ingreso Parqueo");

        jLabel1.setText("DPI Cliente");

        jLabel2.setText("Nombre de Cliente:");

        jLabel3.setText("Codigo Interno:");

        jTVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTVehiculos);

        btnIngresoVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AsigClientes-iloveimg-resized.png"))); // NOI18N
        btnIngresoVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresoVehiculoMouseEntered(evt);
            }
        });
        btnIngresoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoVehiculoActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha y Hora:");

        lblfecha.setText("fecha");

        spPosicion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save_37110 (2).png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-find.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });

        btnTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_ticket_49626_1.png"))); // NOI18N
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                            .addComponent(txtDPI)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblfecha)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBuscar)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIngresoVehiculo)
                                .addGap(69, 69, 69))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnGuardar)
                        .addGap(35, 35, 35)
                        .addComponent(btnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(lblBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodigoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIngresoVehiculo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblfecha)
                        .addComponent(spPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jLabel1.getAccessibleContext().setAccessibleName("DPI cliente");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void vFecha(){
        Calendar cal = Calendar.getInstance();
        sfecha=cal.get(cal.YEAR)+"-"+(cal.get(cal.MONTH)+1)+"-"+cal.get(cal.DATE)+" "+cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND);
        lblfecha.setText(sfecha);
        Fecha=cal.get(cal.YEAR)+"/"+(cal.get(cal.MONTH)+1)+"/"+cal.get(cal.DATE);
    }
    private void btnIngresoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoVehiculoActionPerformed
        // TODO add your handling code here:
        jfIngresoVehiculo jfingresovehiculo = new jfIngresoVehiculo(cliente.IDGlobal);
        jfingresovehiculo.setVisible(true);
    }//GEN-LAST:event_btnIngresoVehiculoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        iPosicion=(int) spPosicion.getValue();
        sMatricula=(String) jTVehiculos.getValueAt(jTVehiculos.getSelectedRow(), 0);
        if (sMatricula=="") {
            JOptionPane.showMessageDialog(null, "Debe ingresar un vehiculo");
        }else{
          if (!ComprobarVehiculo(sMatricula)) {
           asociarcv.ConsultaTablaAsociarCV(sMatricula,cliente.IDGlobal);
        if (parqueo.ConsultaTablaParqueo(iPosicion)) {
            factura.InsertarTablaFactura(asociarcv.iIDGlobal, sfecha,(float) 6, (float) 0.10, iPosicion, Fecha);
           factura.ConsultaTablaFactura(sfecha);
           parqueo.ActualizarTablaParqueo(iPosicion,factura.IDGlobal);
           btnTicket.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "La posicion "+iPosicion+" se encuentra ocupada!");
        } 
        }else{
            JOptionPane.showMessageDialog(null, "El vehiculo seleccionado ya se encuentra en el parqueo!");
        }  
        }
        
        

    }//GEN-LAST:event_btnGuardarActionPerformed
    public boolean ComprobarVehiculo(String Matricula){
        boolean bVerifica=false;
        int[] estado = new int[15];
        Parqueo parqueo = new Parqueo();
        Factura factura = new Factura();
        parqueo.EstadoTablaParqueo(estado);
        for (int i = 0; i < estado.length; i++) {
            switch((i+1)){
                case 1:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(1);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 2:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(2);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 3:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(3);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 4:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(4);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 5:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(5);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 6:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(6);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 7:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(7);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 8:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(8);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 9:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(9);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 10:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(10);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 11:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(11);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 12:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(12);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 13:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(13);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 14:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(14);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
                case 15:
                    if (estado[i]==1) {
                        parqueo.ConsultaTablaParqueo(15);
                        factura.ConsultaTablaFactura(parqueo.ID_Factura);
                        if (factura.VehiculoMatricula.equals(Matricula)) {
                          bVerifica=true;  
                        }
                    }
                break;
            }
        }
        return bVerifica;
    }
    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        // TODO add your handling code here:
        if (txtDPI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo DPI se encuentra vacio");
        }else{
           if(cliente.ConsultaTablaCliente(txtDPI.getText()))
        {
            lblNombre.setText(cliente.sNombreGlobal+" "+cliente.sApellidoGlobal);
            lblCodigoInterno.setText(""+cliente.IDGlobal);
             //JOptionPane.showMessageDialog(null, "Existe");
             btnIngresoVehiculo.setEnabled(true);
             vFecha();
            try {
            vehiculo.ConsultarTablaVehiculo((DefaultTableModel)jTVehiculos.getModel(), cliente.IDGlobal);     
            } catch (SQLException ex) {
                Logger.getLogger(jfiIngresoParqueo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            {
             jfIngresoCliente ingresocliente = new jfIngresoCliente( txtDPI.getText());              
            //se muestra en pantalla 
            ingresocliente.setVisible(true);
             //ingresocliente.setVisible(true);
            } 
        }
        
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void btnIngresoVehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresoVehiculoMouseEntered
        // TODO add your handling code here:
        btnIngresoVehiculo.setToolTipText("Ingresar nuevo vehiculo");
    }//GEN-LAST:event_btnIngresoVehiculoMouseEntered

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        // TODO add your handling code here:
       // System.out.println(factura.IDGlobal);
        ImprimirTicket(factura.IDGlobal);
    }//GEN-LAST:event_btnTicketActionPerformed
    public void ImprimirTicket(int ID){
        JasperReport jr = null;
        Conexion conexionsqlite = new Conexion();
        Connection connecta = conexionsqlite.ConectarABD();
        String url = System.getProperty("user.dir");
        try {
            Map parametro = new HashMap();
            parametro.put("ID", ID);
            parametro.put("logo",this.getClass().getResourceAsStream("/Reportes/Ticket.jpeg"));
            jr = (JasperReport) JRLoader.loadObjectFromFile(url+"\\src\\Reportes\\Ticket.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, connecta);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.setTitle("Ticket");
        } catch (JRException ex) {
            Logger.getLogger(jfiIngresoParqueo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresoVehiculo;
    private javax.swing.JButton btnTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVehiculos;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCodigoInterno;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JSpinner spPosicion;
    private javax.swing.JTextField txtDPI;
    // End of variables declaration//GEN-END:variables
}
