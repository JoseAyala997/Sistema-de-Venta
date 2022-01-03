/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vdetalle_venta;
import Datos.vventas;
import Logica.StyloTabla;
import Logica.freserva;
import Logica.fproductos;
import static Logica.fproductos.cantidadproducto;
import Logica.fventa;
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
public class frmventas extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static String x;

    public frmventas() {
        initComponents();
        x = "x";

        centrar_frm();

        cliente();

        NroFctura();

        Calendar mifecha = new GregorianCalendar();
        dcfecha.setCalendar(mifecha);

        lblidproducto.setVisible(false);
        txtcodcliente.setVisible(false);
        txtpulgadas.requestFocus();

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

        this.tablaventas.setModel(modelo);
        txtcantidad.requestFocus();
    }

    public static void cliente() {
        //asignamos un cliente general
        txtcodcliente.setText("3");
        txtcliente.setText("CLIENTE GENERAL");
        txtpulgadas.setText("0");
    }

    void centrar_frm() {
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    public static DecimalFormat formateador = new DecimalFormat("0000000");//damos formato al numero de factura

    public static void NroFctura() {

        fventa funcion = new fventa();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnrofactura.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }

    void insertarVenta() {
        vventas datos = new vventas();
        fventa funcion = new fventa();

        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
        //datos.setIdusuarios(Integer.parseInt(FRMPRINCIPAL.lblCod_Usuario.getText()));
        datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        datos.setFecha(new Date(a, m, d));
        datos.setNro_factura(txtnrofactura.getText());
        datos.setTipo(jComboBox1.getSelectedItem().toString());

        if (funcion.insertarVentas(datos)) {

        }
        imsertarDetalle();

    }

    public static void imsertarDetalle() {
        vdetalle_venta datos = new vdetalle_venta();
        fventa funcion = new fventa();
        fproductos cd = new fproductos();
        freserva rs = new freserva();
        if (true) {
            
        }
        for (int i = 0; i < tablaventas.getRowCount(); i++) {

// modelo.addColumn("ID");
//        modelo.addColumn("PRODUCTO");
//        modelo.addColumn("PRECIO");
//        modelo.addColumn("PULGADAS");
//        modelo.addColumn("CANTIDAD");
//        modelo.addColumn("SUB TOTAL");
            datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
            datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
            datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
            cd.restarpulgadas(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            cd.restarStock(Double.parseDouble(tablaventas.getValueAt(i, 4).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));

            funcion.insertarDetalle(datos);

        }
//        JOptionPane.showMessageDialog(null, "Venta Finalizada");
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
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtcodcliente = new javax.swing.JTextField();
        txtnrofactura = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        dcfecha = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(btnquitar))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRECIO");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txtproducto.setEnabled(false);

        txtprecio.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtpulgadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpulgadasKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("PULGADAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtpulgadas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpulgadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );

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

        txtcodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodclienteActionPerformed(evt);
            }
        });

        txtnrofactura.setEnabled(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        dcfecha.setEnabled(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
                .addGap(1, 1, 1)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtnrofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel6))
                            .addComponent(txtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(15, 15, 15)
                        .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(txtnrofactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("VENTAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(566, 566, 566)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

        if (txtcodcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
        }
        if (txtnrofactura.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NRO DE FACTURA");//validamos que el num de factura no este vacio

            return;
        }

        if (fila == 0) {//validamos si el jtable viene vacio 
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");

        } else {

            //mandamos los datos al frm factura
            FrmFactura frm = new FrmFactura();
            frm.txtFactura.setText(txtnrofactura.getText());
            frm.txtMonto.setText(txttotal.getText());
            frm.setVisible(true);
            insertarVenta();

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
        int cant;
        cant = Integer.parseInt(txtcantidad.getText());
        if (cant > cantidadproducto) {
//            if (fproductos.categoria) {
//                
//            }
            int respuesta
                    = JOptionPane.showConfirmDialog(rootPane, "La cantidad deseada supera la cantidad del producto desea agragarlo de todas formas? ", "Seleccionar Opcion", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {

                agregar[0] = lblidproducto.getText();
                agregar[1] = txtproducto.getText();
                agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText())));
                agregar[3] = txtpulgadas.getText();
                agregar[4] = txtcantidad.getText();
                int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText());
                agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
                modelo.addRow(agregar);
                sumarsubtotal();

                txtprecio.setText("");
                txtcantidad.setText("");
                lblidproducto.setText("");
                txtproducto.setText("");
                txtprecio.setText("");
                txtpulgadas.setText("0");
            }

        }


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
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtpulgadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpulgadasKeyTyped
        char key = evt.getKeyChar();
        if (txtpulgadas.getText().length() > 4) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtpulgadasKeyTyped

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
    public static com.toedter.calendar.JDateChooser dcfecha;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
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
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcodcliente;
    public static javax.swing.JTextField txtnrofactura;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtpulgadas;
    public static javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
