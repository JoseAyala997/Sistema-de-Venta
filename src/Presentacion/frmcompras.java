/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcompras;
import Datos.vdetalle_compra;
import Logica.StyloTabla;
import Logica.fcompra;
import Logica.fproductos;
import java.awt.Color;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
//comentario
public class frmcompras extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static String x;

    public frmcompras() {
        initComponents();
        x = "x";
        NroFctura();
        setSize(1076, 652);
        centrar_frm();
         txtestado.setText("FINALIZADO");

        cliente();

        Calendar mifecha = new GregorianCalendar();
        dcfecha.setCalendar(mifecha);

        lblidproducto.setVisible(false);
//        txtcodcliente.setVisible(false);
        txtpulgadas.requestFocus();
        txtpulgadas.setText("0");
        txtdescuento.setText("0");

        jPanel1.setBackground(new Color(0, 102, 100, 200));//le damos transparencia y color a los paneles 
        jPanel3.setBackground(new Color(0, 102, 100, 200));//le damos transparencia y color a los paneles 
        jPanel4.setBackground(new Color(0, 102, 100, 200));//le damos transparencia y color a los paneles 

        StyloTabla st = new StyloTabla();
        st.stylotabla(tablaventas);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("PULGADAS");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SUB TOTAL");

        this.tablaventas.setModel(modelo);
        txtcantidad.requestFocus();
    }
    void estado(){
        
        if (cbotipo.getSelectedItem().equals("CONTADO")) {
            txtestado.setText("FINALIZADO");
            
        }else{
            txtestado.setText("PENDIENTE");
        }
    }

//      public void LocalDate() {        
//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
//         String dateStr = date.format(fmt);
//                 System.out.println ("LocalDate a String:" + dateStr);
//                 txtfecha.setText(dateStr);
//   }
    public static void cliente() {
        //asignamos un cliente general
//        txtcodcliente.setText("3");
//        txtcliente.setText("CLIENTE GENERAL");
        txtpulgadas.setText("0");
    }

    public static void vaciartabla() {
        try {
            int fila = tablaventas.getRowCount();
            for (int i = 0; fila > i; i++) {
                frmcompras.modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void centrar_frm() {
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    public static DecimalFormat formateador = new DecimalFormat("0000000");//damos formato al numero de factura

    void insertarVenta() {
        vcompras datos = new vcompras();
        fcompra funcion = new fcompra();

        datos.setEstado(txtestado.getText());
        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
//        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
        //datos.setIdusuarios(Integer.parseInt(FRMPRINCIPAL.lblCod_Usuario.getText()));
         datos.setNro_factura(txtnum_compra.getText());
        datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);
        datos.setFecha(new Date(a, m, d));

        datos.setTipo(cbotipo.getSelectedItem().toString());

        if (funcion.insertarVentas(datos)) {

        }
        imsertarDetalle();

    }

    public static void imsertarDetalle() {
        vdetalle_compra datos = new vdetalle_compra();
        fcompra funcion = new fcompra();
        fproductos cd = new fproductos();
//        freserva rs = new freserva();
        if (true) {

        }
        for (int i = 0; i < tablaventas.getRowCount(); i++) {

//        modelo.addColumn("ID");
//        modelo.addColumn("PRODUCTO");
//        modelo.addColumn("PRECIO");
//        modelo.addColumn("PULGADAS");
//        modelo.addColumn("CANTIDAD");
//        modelo.addColumn("SUB TOTAL");
            datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
            datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
            datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
            cd.sumarpulgadas(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            cd.sumarStock(Double.parseDouble(tablaventas.getValueAt(i, 4).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));

            funcion.insertarDetalle(datos);

        }
        vaciartabla();
        txttotal.setText("0");
        JOptionPane.showMessageDialog(null, "Compra Finalizada");
    }
 public static void NroFctura() {

        fcompra funcion = new fcompra();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnum_compra.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        dcfecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpulgadas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblidproducto = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnum_compra = new javax.swing.JTextField();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotal.setEnabled(false);
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TOTAL:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 60, 20));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("AÑADIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnquitar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnquitar.setText("QUITAR");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("FINALIZAR COMPRA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnquitar)
                            .addComponent(jButton1)))
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, -1, 320));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 840, 310));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("COMPRAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(446, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(425, 425, 425))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 102, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TIPO");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 102, 58, -1));

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));
        cbotipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipoItemStateChanged(evt);
            }
        });
        cbotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoActionPerformed(evt);
            }
        });
        jPanel3.add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 128, 124, 30));

        dcfecha.setEnabled(false);
        jPanel3.add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 128, 147, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRECIO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 24, 60, 20));

        txtprecio.setEnabled(false);
        txtprecio.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel3.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 54, 100, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 48, 38, 36));

        txtcantidad.setMinimumSize(new java.awt.Dimension(6, 30));
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        jPanel3.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 54, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 24, 80, 20));

        txtpulgadas.setMinimumSize(new java.awt.Dimension(6, 30));
        txtpulgadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpulgadasKeyTyped(evt);
            }
        });
        jPanel3.add(txtpulgadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 54, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("PULGADAS");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 24, 100, 20));

        txtproducto.setEnabled(false);
        txtproducto.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel3.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 54, 245, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 24, 80, 20));
        jPanel3.add(lblidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 111, 50, 24));

        txtestado.setEnabled(false);
        txtestado.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel3.add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 128, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ESTADO");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 102, 79, 20));
        jPanel3.add(txtdescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 128, 100, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("DESCUENTO EN GS.");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 98, 124, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("VENTA N°");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 24, 60, 20));

        txtnum_compra.setEnabled(false);
        txtnum_compra.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel3.add(txtnum_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 54, 100, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1060, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

//        if (txtcodcliente.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
//        }
//        if (txtnrofactura.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NRO DE FACTURA");//validamos que el num de factura no este vacio
//
//            return;
//        }
        if (fila == 0) {//validamos si el jtable viene vacio 
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");

        } else {

            //mandamos los datos al frm factura
//            FrmFactura frm = new FrmFactura();
//            frm.txtFactura.setText(txtnrofactura.getText());
//            frm.txtMonto.setText(txttotal.getText());
//            frm.setVisible(true);
            insertarVenta();
            NroFctura();

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        int fila = tablaventas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar el Producto");

        } else {
            int confirmacion = JOptionPane.showConfirmDialog(null, "?Deseas Eliminar el Producto de la lista?");
            if (JOptionPane.OK_OPTION == confirmacion) {
                modelo.removeRow(fila);
                sumarsubtotal();

            }
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String[] agregar = new String[6];
        if (txtproducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el Producto");
//            btn.requestFocus();
            return;
        }
        if (txtcantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes poner la cantidad");
            txtcantidad.requestFocus();
            return;
        }
         if (txtpulgadas.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "la pulgada no puede estar vacia");
            txtpulgadas.setText("0");
            return;
        }
          if (txtdescuento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El descuento no puede estar vacio");
            txtdescuento.setText("0");
            return;
        }
//        int cant;
//        cant = Integer.parseInt(txtcantidad.getText());
//        if (cant > cantidadproducto) {
//            if (fproductos.categoria) {
//                
//            }
//            int respuesta
//                    = JOptionPane.showConfirmDialog(rootPane, "La cantidad deseada supera la cantidad del producto desea agragarlo de todas formas? ", "Seleccionar Opcion", JOptionPane.YES_NO_OPTION);
//            if (respuesta == JOptionPane.YES_OPTION) {
//
//               
//            }
        agregar[0] = lblidproducto.getText();
        agregar[1] = txtproducto.getText();
        agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText())));
        agregar[3] = txtpulgadas.getText();
        agregar[4] = txtcantidad.getText();
        int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText()) - Integer.parseInt(txtdescuento.getText());
        agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
        modelo.addRow(agregar);
        sumarsubtotal();

        txtprecio.setText("");
        txtcantidad.setText("");
        lblidproducto.setText("");
        txtproducto.setText("");
        txtprecio.setText("");
        txtpulgadas.setText("0");
        txtdescuento.setText("0");
        

//        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvistaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvistaproducto1ActionPerformed


    }//GEN-LAST:event_btnvistaproducto1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVista_Servicios form = new FrmVista_Servicios();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 3;
        form.buscador();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
//        permitir solo hasta 4 numeros
        char key = evt.getKeyChar();
        if (txtcantidad.getText().length() > 3) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtpulgadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpulgadasKeyTyped
        char key = evt.getKeyChar();
        if (txtpulgadas.getText().length() > 4) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtpulgadasKeyTyped

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipoActionPerformed

    private void cbotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipoItemStateChanged
        estado();
    }//GEN-LAST:event_cbotipoItemStateChanged

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;

    public static void sumarsubtotal() {
        int totalrow = tablaventas.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        pulgadas = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", ""));
            sumatoria += sumador;

        }
        txttotal.setText(String.valueOf(format.format((sumatoria))));
    }

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
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnquitar;
    public static javax.swing.JComboBox<String> cbotipo;
    public static com.toedter.calendar.JDateChooser dcfecha;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblidproducto;
    public static javax.swing.JTable tablaventas;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtestado;
    public static javax.swing.JTextField txtnum_compra;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtpulgadas;
    public static javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
