/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vpacientes;
import Datos.vproductos;
import Datos.vusuarios;
import Logica.StyloTabla;
import Logica.fpacientes;
import Logica.fproductos;
import Logica.fusuarios;
//import static Presentacion.FrmProductos.btnbuscar;
//import static Presentacion.FrmProductos.txtcategoria;
//import static Presentacion.FrmProductos.txtidcategoria;
//import static Presentacion.FrmProductos.x;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class frmproducto2 extends javax.swing.JInternalFrame {

    public static String x;

    public frmproducto2() {
        initComponents();

        jtable();
        centrar();
        mostrar("");
        cancelar();

        txtid.setVisible(false);
//        txtpulgadas.setText("0");

        jPanel1.setBackground(new Color(0, 102, 100, 200));
        jPanel2.setBackground(new Color(0, 102, 100, 200));
        panelboton2.setBackground(new Color(0, 102, 100, 200));

//        StyloTabla st = new StyloTabla();
//        st.stylotabla(tablalistado);
        setSize(1331, 650);
        setTitle("PRODUCTOS");
    }

    void ocultar_columna() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(250);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(250);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(250);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(250);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(85);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(100);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(100);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(100);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(110);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(110);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(80);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(110);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(85);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(110);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);

    }

    void centrar() {
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    void jtable() {
        //metodo para no editar el jtable
        for (int c = 0; c < tablalistado.getColumnCount(); c++) {

            Class<?> col_class = tablalistado.getColumnClass(c);

            tablalistado.setDefaultEditor(col_class, null); // remove editor

        }
    }

    String acceso;

    void nuevo() {
        acceso = frmprincipal.lblacceso.getText();
        if (acceso.equals("ADMINISTRADOR")) {
            txtproducto.setEnabled(true);
            txtdescripcion.setEnabled(true);
            txtprecio_costo.setEnabled(true);
            txtprecio_mayor.setEnabled(true);
            txtprecio.setEnabled(true);
            txtcantidadstock.setEnabled(true);
            txtcategoria.setEnabled(true);
            txtpulgadas.setEnabled(true);
            txtid.setVisible(false);
            txtidcategoria.setVisible(false);
            txtcategoria.setEnabled(false);
            txtidproveedor.setVisible(false);
            txtproveedor.setEnabled(false);

            btnbuscar.setEnabled(true);
            btneliminar.setEnabled(true);
            btncancelar.setEnabled(true);
            btninsertar.setEnabled(true);
            btnbuscar1.setEnabled(true);
//        cbocategoria.setSelectedIndex(0);0

            txtproducto.setText("");
            txtprecio.setText("");
            txtcantidadstock.setText("0");
            txtid.setText("");
            txtdescripcion.setText("");
            txtprecio_mayor.setText("");
            txtprecio_costo.setText("");
            txtpulgadas.setText("0");
            txtcategoria.setText("");
            txtidcategoria.setText("");
            txtidproveedor.setText("");
            txtproveedor.setText("");
        } else {
            txtproducto.setEnabled(true);
            txtdescripcion.setEnabled(true);
            txtprecio_costo.setEnabled(true);
            txtprecio_mayor.setEnabled(true);
            txtprecio.setEnabled(true);
            txtcantidadstock.setEnabled(false);
            txtcategoria.setEnabled(true);
            txtpulgadas.setEnabled(false);
            txtid.setVisible(false);
            txtidcategoria.setVisible(false);
            txtcategoria.setEnabled(false);
            txtidproveedor.setVisible(false);
            txtproveedor.setEnabled(false);

            btnbuscar.setEnabled(true);
            btneliminar.setEnabled(true);
            btncancelar.setEnabled(true);
            btninsertar.setEnabled(true);
            btnbuscar1.setEnabled(true);
//        cbocategoria.setSelectedIndex(0);0

            txtproducto.setText("");
            txtprecio.setText("");
            txtcantidadstock.setText("0");
            txtid.setText("");
            txtdescripcion.setText("");
            txtprecio_mayor.setText("");
            txtprecio_costo.setText("");
            txtpulgadas.setText("0");
            txtcategoria.setText("");
            txtidcategoria.setText("");
            txtidproveedor.setText("");
            txtproveedor.setText("");
        }

    }

    void cancelar() {
        txtproducto.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtprecio_costo.setEnabled(false);
        txtprecio_mayor.setEnabled(false);
        txtprecio.setEnabled(false);
        txtcantidadstock.setEnabled(false);
        txtcategoria.setEnabled(false);
        txtpulgadas.setEnabled(false);
        txtcategoria.setEnabled(false);
        txtid.setVisible(false);
        txtidcategoria.setVisible(false);
        txtidproveedor.setVisible(false);
        txtproveedor.setEnabled(false);

        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
        btninsertar.setEnabled(false);
        btnbuscar1.setEnabled(false);
//        cbocategoria.setSelectedIndex(0);0

        txtproducto.setText("");
        txtprecio.setText("");
        txtcantidadstock.setText("0");
        txtid.setText("");
        txtdescripcion.setText("");
        txtprecio_mayor.setText("");
        txtprecio_costo.setText("");
        txtpulgadas.setText("0");
        txtcategoria.setText("");
        txtidcategoria.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            for (int c = 0; c < tablalistado.getColumnCount(); c++) {

                Class<?> col_class = tablalistado.getColumnClass(c);

                tablalistado.setDefaultEditor(col_class, null); // remove editor
            }
            fproductos func = new fproductos();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columna();
            lbltotalregistros.setText("Total Registros: " + Integer.toString(func.TotalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

//    void mostrar(String buscar) {
//        try {
//            DefaultTableModel modelo;
//
//            fproductos Funcion = new fproductos();
//
//            modelo = Funcion.mostrar(buscar);
//
//            int total = Funcion.TotalRegistros;
//
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
//
//            tablalistado.setModel(modelo);
//
//        } catch (Exception e) {
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelboton2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btninsertar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        txtcantidadstock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        txtprecio_mayor = new javax.swing.JTextField();
        txtprecio_costo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpulgadas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtidcategoria = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtidproveedor = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        txtproveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

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

        panelboton2.setBackground(new java.awt.Color(204, 204, 204));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevocopia.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btninsertar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btninsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar1.png"))); // NOI18N
        btninsertar.setText("Guardar");
        btninsertar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btninsertar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar1.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar1.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelboton2Layout = new javax.swing.GroupLayout(panelboton2);
        panelboton2.setLayout(panelboton2Layout);
        panelboton2Layout.setHorizontalGroup(
            panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboton2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btninsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btncancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelboton2Layout.setVerticalGroup(
            panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelboton2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(btnnuevo)
                .addGap(39, 39, 39)
                .addComponent(btninsertar)
                .addGap(49, 49, 49)
                .addComponent(btneliminar)
                .addGap(65, 65, 65)
                .addComponent(btncancelar)
                .addGap(50, 50, 50))
        );

        getContentPane().add(panelboton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 50, 130, 570));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel8.setText("PRODUCTO");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jLabel2.setText("BUSCAR POR  NOMBRE, DESCRIPCION O CATEGORIA");

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        lbltotalregistros.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbltotalregistros.setText("jLabel9");

        jLabel3.setText("CANTIDAD STOCK");

        jLabel4.setText("PRECIO UNT.");

        jLabel5.setText("CATEGORIA");

        jLabel9.setText("PRECIO MAYOR");

        jLabel10.setText("DESCRIPCION");

        jLabel11.setText("PRECIO COSTO");

        jLabel12.setText("PULGADAS");

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        jLabel7.setText("PROVEEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtpulgadas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio_mayor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidadstock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(224, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio_mayor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcantidadstock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpulgadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1160, 570));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("PRODUCTOS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 1370, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private String accion = "guardar";
    private void txtidpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpersonaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
        btninsertar.setText("Guardar");
        accion = "guardar";
        txtproducto.requestFocus();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        if (txtproducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NOMBRE PRODUCTO");
            txtproducto.requestFocus();
            return;
        }
        if (txtcantidadstock.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR LA CANTIDAD STOCK");
            txtcantidadstock.requestFocus();
            return;
        }
        if (txtprecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL PRECIO DEL PRODUCTO");
            txtprecio.requestFocus();
            return;
        }
        if (txtcategoria.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR LA CATEGORIA DEL PRODUCTO");
            txtcategoria.requestFocus();
            return;
        }
        if (txtproveedor.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL PROVEEDOR DEL PRODUCTO");
            txtproveedor.requestFocus();
            return;
        }
        vproductos dts = new vproductos();
        fproductos func = new fproductos();
//"INSERT INTO productos (nombre_producto, descripcion, precio_unitario, precio_mayor, precio_costo, stock, pulgadas, estado, idcategorias,idproveedor)"
        dts.setNombre_producto(txtproducto.getText());
        dts.setDescripcion(txtdescripcion.getText());
        dts.setPrecio_unitario(Long.parseLong(txtprecio.getText()));
        dts.setPrecio_costo(Long.parseLong(txtprecio_costo.getText()));
        dts.setPrecio_mayor(Long.parseLong(txtprecio_mayor.getText()));
        dts.setStock(Double.parseDouble(txtcantidadstock.getText()));
        dts.setPulgadas(Double.parseDouble(txtpulgadas.getText()));
        dts.setIdcategorias(Integer.parseInt(txtidcategoria.getText()));
        dts.setIdproveedor(Integer.parseInt(txtidproveedor.getText()));

        if (accion.equals("guardar")) {
            func.insertar(dts);
            JOptionPane.showMessageDialog(this, "PRODUCTO REGISTRADO CORRECTAMENTE");
            mostrar("");

        }
        if (accion.equals("Editar")) {

            dts.setIdservicios(Integer.parseInt(txtid.getText()));
            func.editar(dts);
            JOptionPane.showMessageDialog(this, "PRODUCTO EDITADO CORRECTAMENTE");
            mostrar("");

        }
        cancelar();
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtid.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar este producto?", "Confirmar", 2);

            if (confirmacion == 0) {
                fproductos func = new fproductos();
                vproductos dts = new vproductos();

                dts.setIdservicios(Integer.parseInt(txtid.getText()));
                func.eliminar(dts);
                mostrar("");
                cancelar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        accion = "Editar";
        btninsertar.setText("Editar");
        nuevo();
        try {

            int fila = tablalistado.rowAtPoint(evt.getPoint());
            txtid.setText(tablalistado.getValueAt(fila, 0).toString());
            txtproducto.setText(tablalistado.getValueAt(fila, 1).toString());
            txtdescripcion.setText(tablalistado.getValueAt(fila, 2).toString());
            txtprecio.setText(tablalistado.getValueAt(fila, 3).toString());
            txtprecio_mayor.setText(tablalistado.getValueAt(fila, 4).toString());
            txtprecio_costo.setText(tablalistado.getValueAt(fila, 5).toString());
            txtcantidadstock.setText(tablalistado.getValueAt(fila, 6).toString());
            txtidcategoria.setText(tablalistado.getValueAt(fila, 8).toString());
            txtcategoria.setText(tablalistado.getValueAt(fila, 9).toString());
            //            cbocategoria.setSelectedItem(tablalistado.getValueAt(fila, 8).toString());
            txtpulgadas.setText(tablalistado.getValueAt(fila, 7).toString());
            txtidproveedor.setText(tablalistado.getValueAt(fila, 11).toString());
            txtproveedor.setText(tablalistado.getValueAt(fila, 10).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        FrmVista2 form = new FrmVista2();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 3;
        form.lbltitulovista.setText("CATEGORIAS");
        form.buscador();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        FrmVista2 form = new FrmVista2();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 4;
        form.lbltitulovista.setText("PROVEEDORES");
        form.buscador();
    }//GEN-LAST:event_btnbuscar1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmproducto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JPanel panelboton2;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidadstock;
    public static javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtid;
    public static javax.swing.JTextField txtidcategoria;
    public static javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtprecio_costo;
    private javax.swing.JTextField txtprecio_mayor;
    private javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txtpulgadas;
    // End of variables declaration//GEN-END:variables
}
