package Presentacion;

import Datos.vdetalle_venta;
import Datos.vdeudas;
import Datos.vventas;
import Logica.StyloTabla;
import Logica.freserva;
import Logica.fproductos;
import Logica.fventa;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
public class frmventas extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static String x;

    public frmventas() {
        initComponents();
        x = "x";

        deshabilitar();
        centrar_frm();

//        cliente();
        NroFctura();
        txtestado.setText("FINALIZADO");

        Calendar mifecha = new GregorianCalendar();
        dcfecha.setCalendar(mifecha);

        lblidproducto.setVisible(false);
        txtcodcliente.setVisible(false);
        txtpulgadas.requestFocus();
        txtpulgadas.setText("0");
        txtdescuento.setText("0");

        txtcategoria.setVisible(false);

        jPanel1.setBackground(new Color(0, 102, 100, 200));//le damos transparencia y color a los paneles 
        jPanel2.setBackground(new Color(0, 102, 100, 200));//le damos transparencia y color a los paneles 
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
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("DESC.");

        this.tablaventas.setModel(modelo);
        txtcantidad.requestFocus();
    }

    public static void cliente() {
        //asignamos un cliente general
        txtcodcliente.setText("3");
        txtcliente.setText("CLIENTE GENERAL");
        txtpulgadas.setText("0");
    }

    void habilitar(){
        txtdescuento.setEnabled(true);
    }
    
    void deshabilitar(){
        txtdescuento.setEnabled(false);
    }
    
    void centrar_frm() {
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    void estado() {

        if (cbotipo.getSelectedItem().equals("CONTADO")) {
            txtestado.setText("FINALIZADO");

        } else {
            txtestado.setText("PENDIENTE");
        }
    }

    public static DecimalFormat formateador = new DecimalFormat("0000000");//damos formato al numero de factura

    public static void NroFctura() {

        fventa funcion = new fventa();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnrofactura.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }

    public static void insertarVenta() {
        String tipo = cbotipo.getSelectedItem().toString();
//        System.out.println(tipo);
        if (tipo.equals("CONTADO")) {

            vventas datos = new vventas();
            fventa funcion = new fventa();

            datos.setEstado(txtestado.getText());
            datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
            datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
            datos.setSaldo(Long.parseLong("0"));
            datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
            datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
            datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

            Calendar cal = dcfecha.getCalendar();
            int a, m, d;
            a = cal.get(cal.YEAR) - 1900;
            m = cal.get(cal.MONTH);
            d = cal.get(cal.DAY_OF_MONTH);

            datos.setFecha(new Date(a, m, d));
            datos.setNro_factura(txtnrofactura.getText());
            datos.setTipo(cbotipo.getSelectedItem().toString());

            if (funcion.insertarVentas(datos)) {

            }
//            funcion.insertarVentas(datos);
            frmprincipal.mostrarhoy(frmprincipal.lblidmovimiento2.getText());
            imsertarDetalle();

        } else {
            vventas datos = new vventas();
            fventa funcion = new fventa();

            datos.setEstado(txtestado.getText());
            datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
            datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
            datos.setSaldo(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
            datos.setTotal(Long.parseLong("0"));
            datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
            datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

            Calendar cal = dcfecha.getCalendar();
            int a, m, d;
            a = cal.get(cal.YEAR) - 1900;
            m = cal.get(cal.MONTH);
            d = cal.get(cal.DAY_OF_MONTH);

            datos.setFecha(new Date(a, m, d));
            datos.setNro_factura(txtnrofactura.getText());
            datos.setTipo(cbotipo.getSelectedItem().toString());

            if (funcion.insertarVentas(datos)) {

            }
            frmprincipal.mostrarhoy(frmprincipal.lblidmovimiento2.getText());
            imsertarDetalle();
            insertar_deuda();
        }

    }

    void insertarpresupuesto() {

        vventas datos = new vventas();
        fventa funcion = new fventa();

        datos.setEstado("PRESUPUESTO");
        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
        datos.setSaldo(Long.parseLong("0"));
        datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
        datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        datos.setFecha(new Date(a, m, d));
        datos.setNro_factura(txtnrofactura.getText());
        datos.setTipo(cbotipo.getSelectedItem().toString());

        if (funcion.insertarVentas(datos)) {

        }
//            funcion.insertarVentas(datos);

        Detalle_presupuesto();

    }

    public static void imsertarDetalle() {
        vdetalle_venta datos = new vdetalle_venta();
        fventa funcion = new fventa();
        fproductos cd = new fproductos();
        freserva rs = new freserva();

        for (int i = 0; i < tablaventas.getRowCount(); i++) {
            String cat = (tablaventas.getValueAt(i, 6).toString());
            if (cat.equals("SERVICIOS")) {
                datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
                datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
                datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
                datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
//                System.out.println("servicio");
                funcion.insertarDetalle(datos);
            } else {
                datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
                datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
                datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
                datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
                cd.restarpulgadas(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                cd.restarStock(Double.parseDouble(tablaventas.getValueAt(i, 4).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));

                funcion.insertarDetalle(datos);
//                System.out.println("no es un servicio");
            }

        }

    }

    public static void insertar_deuda() {

        vdeudas dts = new vdeudas();
        fventa funcion = new fventa();

        dts.setIdcliente(Integer.parseInt(txtcodcliente.getText()));
        dts.setTotal_deuda(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
        dts.setEstado(txtestado.getText());

        if (funcion.insertarDeuda(dts)) {

        }
        System.out.println("deuda insertada");

    }

    public static void Detalle_presupuesto() {
        vdetalle_venta datos = new vdetalle_venta();
        fventa funcion = new fventa();
        fproductos cd = new fproductos();
        freserva rs = new freserva();

        for (int i = 0; i < tablaventas.getRowCount(); i++) {

            datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
            datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
            datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
            datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));

            funcion.insertarDetalle(datos);

        }

    }
    public static void venta(){
            int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

        if (txtcodcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
        } else {
            if (fila == 0) {//validamos si el jtable viene vacio 
                JOptionPane.showMessageDialog(null, "La tabla no puede estar vacia");

            } else {
                //mandamos los datos al frm factura
                FrmFactura frm = new FrmFactura();
                frm.txtFactura.setText(txtnrofactura.getText());
                frm.txtMonto.setText(txttotal.getText());
                frm.txtdescuento.setText(txttotal_descuento.getText());
                frm.setVisible(true);
//                insertarVenta();
            }
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

        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtproducto = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        lblidproducto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtpulgadas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtcodcliente = new javax.swing.JTextField();
        txtnrofactura = new javax.swing.JTextField();
        cbotipo = new javax.swing.JComboBox<>();
        dcfecha = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        txtestado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttotal_descuento = new javax.swing.JTextField();

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

        txttotal.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TOTAL:");

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
        jButton3.setText("FINALIZAR VENTA");
        jButton3.setPreferredSize(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("PRESUPUESTO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btnquitar)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 80, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRECIO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 60, 20));

        txtcantidad.setPreferredSize(null);
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
        });
        jPanel2.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 90, 30));

        txtproducto.setEnabled(false);
        txtproducto.setPreferredSize(null);
        jPanel2.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 30));

        txtprecio.setEnabled(false);
        txtprecio.setPreferredSize(null);
        jPanel2.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 140, 30));
        jPanel2.add(lblidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 38, 36));

        txtpulgadas.setPreferredSize(null);
        txtpulgadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpulgadasKeyTyped(evt);
            }
        });
        jPanel2.add(txtpulgadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("PULGADAS");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 20));

        txtcategoria.setEnabled(false);
        txtcategoria.setPreferredSize(null);
        jPanel2.add(txtcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 40, 30));
        jPanel2.add(txtdescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 140, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("REDONDEO PRECIO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 124, 20));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("CLIENTE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NRO. FACTURA");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TIPO");

        txtcliente.setEnabled(false);
        txtcliente.setPreferredSize(null);

        txtcodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodclienteActionPerformed(evt);
            }
        });

        txtnrofactura.setEnabled(false);
        txtnrofactura.setPreferredSize(null);

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));
        cbotipo.setPreferredSize(null);
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

        dcfecha.setEnabled(false);
        dcfecha.setPreferredSize(null);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtestado.setEnabled(false);
        txtestado.setPreferredSize(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ESTADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(65, 65, 65)
                        .addComponent(txtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtnrofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(11, 11, 11)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel6))
                                .addComponent(txtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(15, 15, 15)
                            .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(11, 11, 11)
                            .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(11, 11, 11)
                            .addComponent(txtnrofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("VENTAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("TOTAL DESCUENTO:");

        txttotal_descuento.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttotal_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttotal_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtcodclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodclienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        venta();


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

        String[] agregar = new String[8];
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
            JOptionPane.showMessageDialog(rootPane, "El descuento no puede estar vacio - Valor minimo 0");
            txtdescuento.setText("0");
            return;
        }
//        if (txtredondeo.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "El redondeo no puede estar vacio - Valor minimo 0");
//            txtredondeo.setText("0");
//            return;
//        }

        int redondeo;
        int cant;
        redondeo = Integer.parseInt(txtdescuento.getText());
        cant = Integer.parseInt(txtcantidad.getText());
        if (redondeo > 0 && cant >= 1) {

            agregar[0] = lblidproducto.getText();
            agregar[1] = txtproducto.getText();
            agregar[2] = String.valueOf(format.format(Integer.parseInt(txtdescuento.getText())));
            agregar[3] = txtpulgadas.getText();
            agregar[4] = txtcantidad.getText();
            agregar[6] = txtcategoria.getText();
            agregar[7] = "0";
//            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText()) - Integer.parseInt(txtdescuento.getText());
            int subttotal = Integer.parseInt(txtdescuento.getText());
            agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
            modelo.addRow(agregar);
            sumarsubtotal();

            txtprecio.setText("");
            txtcantidad.setText("");
            lblidproducto.setText("");
            txtproducto.setText("");
            txtprecio.setText("");
            txtcategoria.setText("");
            txtpulgadas.setText("0");
            txtdescuento.setText("0");

        } else {

            agregar[0] = lblidproducto.getText();
            agregar[1] = txtproducto.getText();
            agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText())));
            agregar[3] = txtpulgadas.getText();
            agregar[4] = txtcantidad.getText();
            agregar[6] = txtcategoria.getText();
            agregar[7] = "0";
            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText());
//            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtdescuento.getText());
            agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
            modelo.addRow(agregar);
            sumarsubtotal();

            txtprecio.setText("");
            txtcantidad.setText("");
            lblidproducto.setText("");
            txtproducto.setText("");
            txtprecio.setText("");
            txtcategoria.setText("");
            txtpulgadas.setText("0");
            txtdescuento.setText("0");

        }
deshabilitar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvistaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvistaproducto1ActionPerformed


    }//GEN-LAST:event_btnvistaproducto1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        frmvistapa_venta form = new frmvistapa_venta();
        form.setVisible(true);
        form.toFront();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVista_Servicios form = new FrmVista_Servicios();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 1;
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
//        int precio=0;
//        int cantidad=0;
//        int sub=0;
//        precio=Integer.parseInt(txtprecio.getText());
//        cantidad=Integer.parseInt(txtcantidad.getText());
//        sub = precio*cantidad;
//        txtredondeo.setText(String.valueOf(sub));
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipoActionPerformed

    private void txtpulgadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpulgadasKeyTyped
        char key = evt.getKeyChar();
        if (txtpulgadas.getText().length() > 4) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtpulgadasKeyTyped

    private void cbotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipoItemStateChanged
        estado();
    }//GEN-LAST:event_cbotipoItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

        if (txtcodcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
        } else {
            if (fila == 0) {//validamos si el jtable viene vacio 
                JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");

            } else {
                //mandamos los datos al frm factura
                FrmFactura frm = new FrmFactura();
                frm.txtFactura.setText(txtnrofactura.getText());
                frm.txtMonto.setText(txttotal.getText());
                frm.txtdescuento.setText(txttotal_descuento.getText());
                frm.setVisible(true);
                insertarpresupuesto();
            }
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed


    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int precio = 0;
            int cantidad = 0;
            int sub = 0;
            precio = Integer.parseInt(txtprecio.getText());
            cantidad = Integer.parseInt(txtcantidad.getText());
            sub = precio * cantidad;
            txtdescuento.setText(String.valueOf(sub));
            habilitar();
        }
        

    }//GEN-LAST:event_txtcantidadKeyReleased

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;
    public static float des1;
    public static float des2;

    public static void sumarsubtotal() {
        int totalrow = tablaventas.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        pulgadas = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
            des1 = Float.valueOf(tablaventas.getValueAt(i, 7).toString().replaceAll("\\.", ""));
            des2 += des1;

        }
        txttotal.setText(String.valueOf(format.format(sumatoria)));
        txttotal_descuento.setText(String.valueOf(format.format(des2)));
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
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmventas().setVisible(true);
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
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblidproducto;
    public static javax.swing.JTable tablaventas;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcategoria;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcodcliente;
    public static javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtestado;
    public static javax.swing.JTextField txtnrofactura;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtpulgadas;
    public static javax.swing.JTextField txttotal;
    public static javax.swing.JTextField txttotal_descuento;
    // End of variables declaration//GEN-END:variables
}
