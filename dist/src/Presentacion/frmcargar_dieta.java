package Presentacion;

import Datos.valimentos;
import Datos.vcomidas;
import Datos.vdetalle_venta;
import Datos.vdieta;
import Datos.vpacientes;
import Datos.vplantilla;
import Datos.vventas;
import Logica.Conexion;
import Logica.StyloTabla;
import Logica.falimento;
import Logica.fcomida;
import Logica.fdieta;
import Logica.fpacientes;
import Logica.fplantilla;
import Logica.fproductos;
import static Logica.fproductos.cn;
import Logica.fventa;
import static Presentacion.frmventas.dcfecha;
import static Presentacion.frmventas.imsertarDetalle;
import static Presentacion.frmventas.tablaventas;
import static Presentacion.frmventas.txtcodcliente;
import static Presentacion.frmventas.txtnrofactura;
import static Presentacion.frmventas.txttotal;
import static Presentacion.frmventas.x;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static Presentacion.frmventas.cbotipo;

/**
 *
 * @author Jose Ayala
 */
public class frmcargar_dieta extends javax.swing.JInternalFrame {

    public static String x;
    public static DefaultTableModel modelo2;
    Fondopanel fondo = new Fondopanel();//declaramos una variable de tipo panel llamada fondo

    public frmcargar_dieta() {
        this.setContentPane(fondo);//establecemos la imagen solo al jframe
        initComponents();
        jtable();
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        Calendar FECHA = new GregorianCalendar();
        fecha_dieta.setCalendar(FECHA);

        setTitle("CARGAR DIETA");

        txtidpaciente11.setVisible(false);
        txtidnutricionista.setVisible(false);
        txtpaciente.setEnabled(false);
        txtnutricionista.setEnabled(false);
        fecha_dieta.setEnabled(false);
        

        paneldieta1.setBackground(new Color(0, 102, 100, 200));
        jPanel1.setBackground(new Color(0, 102, 100, 200));
        jPanel2.setBackground(new Color(0, 102, 100, 200));

        StyloTabla st = new StyloTabla();
        modelo2 = new DefaultTableModel();

        modelo2.addColumn("ID PLANTILLA");
        modelo2.addColumn("ID ALIMENTO");
        modelo2.addColumn("TIPO");
        modelo2.addColumn("OBSERVACION");
        modelo2.addColumn("PERIODO");
        modelo2.addColumn("DIAS");
        modelo2.addColumn("NOMBRE");
        modelo2.addColumn("CANTIDAD");
        modelo2.addColumn("CALORIAS");
        modelo2.addColumn("PROTEINAS");
        modelo2.addColumn("VITAMINAS");
        modelo2.addColumn("MINERALES");
        modelo2.addColumn("ESTADO");
        modelo2.addColumn("CAL_TOTAL");

        this.tabladieta.setModel(modelo2);

    }

    public void vaciartabla(JTable tabla) {
        try {
            int fila = tabla.getRowCount();
            for (int i = 0; fila > i; i++) {
                frmcargar_dieta.modelo2.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void INSERTAR_DIETA() {
        if (txtcomentario.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un comentario");
            txtcomentario.requestFocus();
            return;
        }
        vdieta datos = new vdieta();
        fdieta funcion = new fdieta();

        datos.setComentario(txtcomentario.getText());
        datos.setIdpaciente(Integer.parseInt(txtidpaciente11.getText()));
        datos.setIdpaciente(Integer.parseInt(txtidnutricionista.getText()));

        Calendar cal = fecha_dieta.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        datos.setFecha_registro(new Date(a, m, d));

        if (funcion.insertar_idcomida(datos)) {

            JOptionPane.showMessageDialog(null, "Dieta Guardada");
        }

        vaciartabla(tabladieta);
        txtcomentario.setText("");
        txtcomentario.requestFocus();

    }

    void jtable(){
         //metodo para no editar el jtable
                for (int c = 0; c < tabladieta.getColumnCount(); c++)

        {
 
            Class<?> col_class = tabladieta.getColumnClass(c);

            tabladieta.setDefaultEditor(col_class, null); // remove editor

        }
          
    }
    void DIETA() {
         if (txtpaciente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Nombre del paciente");
            txtpaciente.requestFocus();
            return;
        }
        vdieta datos = new vdieta();
        fdieta funcion = new fdieta();
        fproductos cd = new fproductos();

        for (int i = 0; i < tabladieta.getRowCount(); i++) {

            datos.setComentario(txtcomentario.getText());
            datos.setIdpaciente(Integer.parseInt(txtidpaciente11.getText()));
            datos.setIdusuarios(Integer.parseInt(txtidnutricionista.getText()));
            datos.setIdcomida(Integer.parseInt(tabladieta.getValueAt(i, 0).toString()));
            Calendar cal = fecha_dieta.getCalendar();
            int a, m, d;
            a = cal.get(cal.YEAR) - 1900;
            m = cal.get(cal.MONTH);
            d = cal.get(cal.DAY_OF_MONTH);

            datos.setFecha_registro(new Date(a, m, d));

            funcion.insertar_dieta(datos);
        }
//        JOptionPane.showMessageDialog(null,"Dieta generada y guardada");
        imprimir_dieta();

//        INSERTAR_DIETA();
    }

    private String accion = "guardar";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldieta1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladieta = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcomentario = new javax.swing.JTextArea();
        lblcaloriastotales1 = new javax.swing.JLabel();
        lblcaloriastotales2 = new javax.swing.JLabel();
        lblcaloriastotales3 = new javax.swing.JLabel();
        lblcaloriastotales4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtidpaciente11 = new javax.swing.JTextField();
        txtidnutricionista = new javax.swing.JTextField();
        txtnutricionista = new javax.swing.JTextField();
        txtpaciente = new javax.swing.JTextField();
        fecha_dieta = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        paneldieta1.setBackground(new java.awt.Color(0, 102, 102));

        tabladieta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabladieta);

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1.png"))); // NOI18N
        btnnuevo.setText("Buscar");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnnuevo)
                        .addGap(60, 60, 60)
                        .addComponent(btnguardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtcomentario.setColumns(20);
        txtcomentario.setRows(5);
        jScrollPane1.setViewportView(txtcomentario);

        lblcaloriastotales1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcaloriastotales1.setForeground(new java.awt.Color(255, 255, 255));
        lblcaloriastotales1.setText("Nutricionista:");

        lblcaloriastotales2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcaloriastotales2.setForeground(new java.awt.Color(255, 255, 255));
        lblcaloriastotales2.setText("Comentario:");

        lblcaloriastotales3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcaloriastotales3.setForeground(new java.awt.Color(255, 255, 255));
        lblcaloriastotales3.setText("Paciente:");

        lblcaloriastotales4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcaloriastotales4.setForeground(new java.awt.Color(255, 255, 255));
        lblcaloriastotales4.setText("Fecha:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtidpaciente11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpaciente11ActionPerformed(evt);
            }
        });

        txtidnutricionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnutricionistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneldieta1Layout = new javax.swing.GroupLayout(paneldieta1);
        paneldieta1.setLayout(paneldieta1Layout);
        paneldieta1Layout.setHorizontalGroup(
            paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldieta1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldieta1Layout.createSequentialGroup()
                        .addComponent(lblcaloriastotales1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidnutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneldieta1Layout.createSequentialGroup()
                        .addComponent(lblcaloriastotales3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidpaciente11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneldieta1Layout.createSequentialGroup()
                        .addComponent(lblcaloriastotales4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha_dieta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblcaloriastotales2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paneldieta1Layout.setVerticalGroup(
            paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldieta1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneldieta1Layout.createSequentialGroup()
                        .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcaloriastotales1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidnutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneldieta1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblcaloriastotales2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldieta1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(paneldieta1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(paneldieta1Layout.createSequentialGroup()
                                        .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblcaloriastotales3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtidpaciente11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)))))
                        .addGroup(paneldieta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblcaloriastotales4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha_dieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("DIETA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(536, 536, 536)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneldieta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneldieta1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtiddesayunolunes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiddesayunolunes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiddesayunolunes3ActionPerformed
    DecimalFormat format = new DecimalFormat("###,###.##");
    float sumatoria;
    float sumador;

    void sumarsubtotal() {
        int totalrow = tabladieta.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tabladieta.getValueAt(i, 5).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
        }

    }

    private Connection connection = new Conexion().conectar();

    void imprimir_dieta() {
        Map p = new HashMap();
        p.put("nombre", txtpaciente.getText());

        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rptdieta_final1.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("DIETA");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        vaciartabla(tabladieta);
        txtcomentario.setText("");
        txtpaciente.setText("");
        txtidpaciente11.setText("");
        txtcomentario.requestFocus();

    }

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtidcomida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcomida2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcomida2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmvistapaciente_dieta form = new frmvistapaciente_dieta();
        form.setVisible(true);
        form.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtidpaciente11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpaciente11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpaciente11ActionPerformed

    private void txtidnutricionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnutricionistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnutricionistaActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        frmvista_cargardieta form = new frmvista_cargardieta();
        form.setVisible(true);
        form.toFront();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        DIETA();
    }//GEN-LAST:event_btnguardarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmcargar_dieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcargar_dieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcargar_dieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcargar_dieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcargar_dieta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private com.toedter.calendar.JDateChooser fecha_dieta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcaloriastotales1;
    private javax.swing.JLabel lblcaloriastotales2;
    private javax.swing.JLabel lblcaloriastotales3;
    private javax.swing.JLabel lblcaloriastotales4;
    private javax.swing.JPanel paneldieta1;
    public static javax.swing.JTable tabladieta;
    private javax.swing.JTextArea txtcomentario;
    public static javax.swing.JTextField txtidnutricionista;
    public static javax.swing.JTextField txtidpaciente11;
    public static javax.swing.JTextField txtnutricionista;
    public static javax.swing.JTextField txtpaciente;
    // End of variables declaration//GEN-END:variables
class Fondopanel extends JPanel {

        private Image imagen;//se declara una variable

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Iconos/icononutricion.jpg")).getImage();//selecciona el paquete y la imagen que se quiere usar
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);//obtiene el tamaño del panel para ajustar la imagen
            setOpaque(false);//sirve para que se vea la imagen
            super.paint(g);//para mostrar todos los componentes del panel que estan establecidos
        }
    }
}
