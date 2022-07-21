package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fventa;
import Presentacion.FrmVista2;
import Presentacion.frmprincipal;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose Ayala
 */
public class frmhistorial_ventas extends javax.swing.JInternalFrame {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    public static int comprobar;
    public static String x;

    public frmhistorial_ventas() {
        initComponents();

        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        Calendar mifecha = new GregorianCalendar();
        dcFecha_Inicio.setCalendar(mifecha);
        dcFecha_termino.setCalendar(mifecha);
        jPanel3.setBackground(new Color(0, 102, 100, 200));
//        StyloTabla st = new StyloTabla();
//        mostrar("","");
    }
    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;
    public static float des1;
    public static float des2;

    public static void sumarsubtotal() {
        int totalrow = jTable1.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
            des2 += des1;

        }
        lbltotalventa.setText(String.valueOf(format.format(sumatoria)));
//        txttotal_descuento.setText(String.valueOf(format.format(des2)));
    }

    void mostrarcontado(String inicio, String fin, String estado) {
        try {
            DefaultTableModel modelo;

            fventa Funcion = new fventa();

            modelo = Funcion.mostrarhventatotal(inicio, fin, estado);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            jTable1.setModel(modelo);

        } catch (Exception e) {
        }

    }

    void mostrarcredito(String inicio, String fin, String estado) {
        try {
            DefaultTableModel modelo;

            fventa Funcion = new fventa();

            modelo = Funcion.mostrarhventacredtotal(inicio, fin, estado);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            jTable1.setModel(modelo);

        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        dcFecha_Inicio = new com.toedter.calendar.JDateChooser();
        dcFecha_termino = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox<>();
        lbltotalventa = new javax.swing.JLabel();
        lbltotalventa1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dcFecha_Inicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 150, 30));

        dcFecha_termino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_termino, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 150, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("HISTORIAL DE VENTAS");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 292, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha fin");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de inicio");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, 30));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir1.png"))); // NOI18N
        btnnuevo.setText("Imprimir");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1184, 400));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 113, 30));

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO", " " }));
        jPanel3.add(cmbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 150, 30));

        lbltotalventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalventa.setText("0");
        lbltotalventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(lbltotalventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 110, 30));

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalventa1.setText("Total Venta:");
        lbltotalventa1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(lbltotalventa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        String estador = cmbestado.getSelectedItem().toString();
        int fila = jTable1.getRowCount();
        if (fila == 0) {
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");
        } else {
            if (estador.equals("CONTADO")) {
                estador = "FINALIZADO";
                Map p = new HashMap();
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("estado", estador);
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptventa_historial_total.jrxml");
                    print = JasperFillManager.fillReport(report, p, connection);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial ventas");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Map p = new HashMap();
                estador = "PENDIENTE";
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("estado", estador);
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptventa_historialcred_total.jrxml");
                    print = JasperFillManager.fillReport(report, p, connection);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial ventas");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = dcFecha_Inicio.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = dcFecha_termino.getDate();
        String p_fecha_Hasta = sdf_hasta.format(hasta);

        String estado = cmbestado.getSelectedItem().toString();
        if (estado.equals("CONTADO")) {
            estado = "FINALIZADO";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado);
            LOcultarColumna.ocultar_esta_columna2(jTable1, 0, 1, 2);
            sumarsubtotal();
        } else {
            estado = "PENDIENTE";
            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
            LOcultarColumna.ocultar_esta_columna2(jTable1, 0, 1, 2);
            sumarsubtotal();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private Connection connection = new Conexion().conectar();

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmhistorial_ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbestado;
    private com.toedter.calendar.JDateChooser dcFecha_Inicio;
    private com.toedter.calendar.JDateChooser dcFecha_termino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JLabel lbltotalventa;
    public static javax.swing.JLabel lbltotalventa1;
    // End of variables declaration//GEN-END:variables

}
