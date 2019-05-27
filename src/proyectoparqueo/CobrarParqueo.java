/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueo;

import java.awt.Image;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 
 */
public class CobrarParqueo extends javax.swing.JInternalFrame {

    /**
     * Creates new form CobrarParqueo
     */
    private String sFechaSalida;
    private int horas=0;
    private int minutos=0;
    float total=0;
    int iPosicion;
    Factura factura = new Factura();
    Parqueo parqueo = new Parqueo();
    public CobrarParqueo(int n) {
        initComponents();
        btncobrar.setEnabled(false);
        btnfactura.setEnabled(false);
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

        spPosicion = new javax.swing.JSpinner();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDpi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTarifaH = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTarifaM = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblParqueo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblIDFactura = new javax.swing.JLabel();
        btncobrar = new javax.swing.JButton();
        btnfactura = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        spPosicion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-find.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Datos del Cliente");

        jLabel2.setText("Nombre:");

        jLabel3.setText("DPI:");

        lblNombre.setText(" ");

        lblDpi.setText(" ");

        jLabel4.setText("Datos del Vehiculo");

        jLabel5.setText("Matricula:");

        lblMatricula.setText(" ");

        jLabel6.setText("Modelo:");

        lblModelo.setText(" ");

        jLabel7.setText("Color:");

        lblColor.setText(" ");

        jLabel8.setText("Marca:");

        lblMarca.setText(" ");

        jLabel9.setText("Fecha Ingreso:");

        lblFechaIngreso.setText(" ");

        jLabel11.setText("Fecha Salida:");

        lblFechaSalida.setText(" ");

        jLabel10.setText("Tarifa Hora: ");

        lblTarifaH.setText(" ");

        jLabel12.setText("Tarifa Minuto: ");

        lblTarifaM.setText(" ");

        jLabel13.setText("Total:");

        lblTotal.setText(" ");

        lblParqueo.setText(" ");

        jLabel14.setText("Parqueo:");

        jLabel15.setText("ID Factura:");

        lblIDFactura.setText(" ");

        btncobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cobrar.png"))); // NOI18N
        btncobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncobrarMouseEntered(evt);
            }
        });
        btncobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncobrarActionPerformed(evt);
            }
        });

        btnfactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reportess.png"))); // NOI18N
        btnfactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnfacturaMouseEntered(evt);
            }
        });
        btnfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDpi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTarifaH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTarifaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblParqueo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(lblMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIDFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btncobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblColor, lblFechaIngreso, lblFechaSalida, lblIDFactura, lblMarca, lblMatricula, lblModelo, lblParqueo, lblTarifaH, lblTarifaM, lblTotal});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spPosicion)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDpi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblParqueo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIDFactura)
                        .addGap(7, 7, 7)
                        .addComponent(lblFechaIngreso)
                        .addGap(11, 11, 11)
                        .addComponent(lblFechaSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTarifaH)
                        .addGap(13, 13, 13)
                        .addComponent(lblTarifaM)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblColor, lblFechaIngreso, lblFechaSalida, lblIDFactura, lblMarca, lblMatricula, lblModelo, lblParqueo, lblTarifaH, lblTarifaM, lblTotal});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vFecha(){
        Calendar cal = Calendar.getInstance();
        sFechaSalida=cal.get(cal.YEAR)+"-"+(cal.get(cal.MONTH)+1)+"-"+cal.get(cal.DATE)+" "+cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND);
        lblFechaSalida.setText(sFechaSalida);      
    }
    private void vCalcularTiempo(String fechainicio, String Fechafin){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
 
        Date fechaInicial = null;
        try {
            fechaInicial = dateFormat.parse(fechainicio);
        } catch (ParseException ex) {
            Logger.getLogger(CobrarParqueo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fechaFinal = null;
        try {
            fechaFinal = dateFormat.parse(Fechafin);
        } catch (ParseException ex) {
            Logger.getLogger(CobrarParqueo.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        int diferencia=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/1000);
 

        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        iPosicion=(int) spPosicion.getValue();
        if (parqueo.ConsultaTablaParqueo(iPosicion)) {
            JOptionPane.showMessageDialog(null,"Este parqueo esta libre!");
        }else{
            
            vFecha();
            factura.ConsultaTablaFactura(parqueo.ID_Factura);
            lblNombre.setText(factura.ClienteNombre+" "+factura.ClienteApellido);
            lblDpi.setText(factura.ClienteDPI);
            lblMatricula.setText(factura.VehiculoMatricula);
            lblModelo.setText(factura.VehiculoModelo);
            lblColor.setText(factura.VehiculoColor);
            lblMarca.setText(factura.VehiculoMarca);
            lblIDFactura.setText(""+parqueo.ID_Factura);
            lblFechaIngreso.setText(factura.FechaIngreso);
            lblTarifaH.setText("Q "+factura.TarifaH);
            lblTarifaM.setText("Q "+factura.TarifaM);
            lblParqueo.setText(""+factura.Parqueo);
            vCalcularTiempo(factura.FechaIngreso, sFechaSalida);
            total=(horas*factura.TarifaH)+(minutos*factura.TarifaM);
            lblTotal.setText("Q "+total);
            btncobrar.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnfacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfacturaMouseEntered
        // TODO add your handling code here:
        btnfactura.setToolTipText("Generar Factura");
    }//GEN-LAST:event_btnfacturaMouseEntered

    private void btncobrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseEntered
        // TODO add your handling code here:
        btncobrar.setToolTipText("Cobrar");
    }//GEN-LAST:event_btncobrarMouseEntered

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        // TODO add your handling code here:
        btnBuscar.setToolTipText("Buscar");
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobrarActionPerformed
        // TODO add your handling code here:
        if (factura.ActualizarTablaFactura(sFechaSalida, total, parqueo.ID_Factura)) {
            btnfactura.setEnabled(true);
            btncobrar.setEnabled(false);
            parqueo.ActualizarTablaParqueo(iPosicion);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar la transaccion!");
        }
        
    }//GEN-LAST:event_btncobrarActionPerformed

    private void btnfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturaActionPerformed
        // TODO add your handling code here:
      
        ImprimirFactura(parqueo.ID_Factura);
    }//GEN-LAST:event_btnfacturaActionPerformed
public void ImprimirFactura(int ID){
    JasperReport jr = null;
        Conexion conexion = new Conexion();
        Connection connecta = conexion.ConectarABD();
        String url = System.getProperty("user.dir");
        try {
            Map parametro = new HashMap();
            parametro.put("ID", ID);
            parametro.put("logo",this.getClass().getResourceAsStream("/Reportes/Parqueo.jpeg"));
            jr = (JasperReport) JRLoader.loadObjectFromFile(url+"\\src\\Reportes\\Factura.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, connecta);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.setTitle("Factura");
        } catch (JRException ex) {
            Logger.getLogger(ReporteFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btncobrar;
    private javax.swing.JButton btnfactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDpi;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblIDFactura;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblParqueo;
    private javax.swing.JLabel lblTarifaH;
    private javax.swing.JLabel lblTarifaM;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spPosicion;
    // End of variables declaration//GEN-END:variables
}