package Presentacion;

import CONSULTAS.frmconsulta_paciente;
import CONSULTAS.frmhistorial_ventas;
import CONSULTAS.frmpaciente_consulta;
import CONSULTAS.frmusuarios_consulta;
import CONSULTAS.frmImprimir_factura;
import CONSULTAS.frm_ingreso_egreso;
import CONSULTAS.frm_ingreso_egreso_final;
import CONSULTAS.frmhistorial_compras;
import CONSULTAS.frmventa_general;
import CONSULTAS.frmventas_diarias;
import Logica.StyloTabla;
import Logica.fmovimiento_caja;
import Respaldos.Backup;
import Respaldos.HiloLector;
import Respaldos.copia_de_seguridad;
import Respaldos.frmrestaurar_copia;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ayala
 */
public class frmprincipal extends javax.swing.JFrame {

    Fondopanel fondo = new Fondopanel();//declaramos una variable de tipo panel llamada fondo
    public static String id_usuario;
    public static String usuario;
    public static String documento;

    public frmprincipal() {

        this.setContentPane(fondo);//establecemos la imagen solo al jframe
        initComponents();
        StyloTabla st = new StyloTabla();
        this.setExtendedState(frmprincipal.MAXIMIZED_BOTH);
        ocultar();

        fecha();

        mostrarhoy(lblcodusuario.getText());

    }

    void ocultar() {
        lblcodusuario.setVisible(false);
        lbldocumento.setVisible(false);
        lblidmovimiento2.setVisible(false);

        txtcontado.setText("0");
        txtcaja.setText("0");
        txthoy.setText("0");
        txtcredito.setText("0");
        txtpagado.setText("0");
        txtapertura.setText("0");
        txtegresos.setText("0");
        txtingresos.setText("0");

        txtcontado.setEnabled(false);
        txtcaja.setEnabled(false);
        txthoy.setEnabled(false);
        txtcredito.setEnabled(false);
        txtpagado.setEnabled(false);
        txtapertura.setEnabled(false);
        txtegresos.setEnabled(false);
        
        txtcontado1.setVisible(false);
       
        txthoy1.setVisible(false);
        txtcredito1.setVisible(false);
        txtpagado1.setVisible(false);
        txtapertura1.setVisible(false);
        txtegresos1.setVisible(false);
        txtingresos1.setVisible(false);
        TXTCOMPRAS1.setVisible(false);
    }

    void fecha() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        lblfechahoy.setText(dtf.format(LocalDateTime.now()));
    }
//    void mostrar() {
//        try {
//            fmovimiento_caja func = new fmovimiento_caja();
//
//            func.mostrar_ultimo_id();
////            func.mostrarTotalAcumuladoPagosVentas(lblidmovimiento2.getText());
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(rootPane, e);
//        }
//    }

    static DecimalFormat format = new DecimalFormat("###,###.##");

    public static void mostrarhoy(String buscar) {

        try {
            fmovimiento_caja func = new fmovimiento_caja();
            func.mostrar_ultimo_id(lblcodusuario.getText());
            func.ventashoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.ventasmod(lblidmovimiento2.getText());
            func.creditohoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.creditomod(lblidmovimiento2.getText());
            func.cobradohoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.cobradomod(lblidmovimiento2.getText());
            func.egresohoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.egresomov(lblidmovimiento2.getText());
            func.ingresohoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.ingresomov(lblidmovimiento2.getText());
            func.comprashoy(lblidmovimiento2.getText(), lblfechahoy.getText());
            func.comprasmov(lblidmovimiento2.getText());
            func.aperturahoy(lblidmovimiento2.getText());

            int egre = Integer.parseInt(txtegresos1.getText().replace(".", ""));
            int ingre = Integer.parseInt(txtingresos1.getText().replace(".", ""));
            int cont = Integer.parseInt(txtcontado.getText().replace(".", ""));
             int cont2 = Integer.parseInt(txtcontado1.getText().replace(".", ""));
            int cred = Integer.parseInt(txtcredito.getText().replace(".", ""));
            int aper = Integer.parseInt(txtapertura.getText().replace(".", ""));
            int compra = Integer.parseInt(TXTCOMPRAS1.getText().replace(".", ""));

            int total = cont + cred;
//            int egresos=(compra - cont - egre);
            int caja = (cont2 - egre) + (aper + ingre) - compra;

            txthoy.setText(String.valueOf(format.format((int) total)));
            txtcaja.setText(String.valueOf(format.format((int) caja)));

        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(rootPane, e);
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

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new Fondopanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcontado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txthoy = new javax.swing.JTextField();
        txtcredito = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpagado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcaja = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtegresos = new javax.swing.JTextField();
        txtapertura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtingresos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TXTCOMPRAS = new javax.swing.JTextField();
        lblfechahoy1 = new javax.swing.JLabel();
        lblfechahoy = new javax.swing.JLabel();
        lbldocumento = new javax.swing.JLabel();
        lblcodusuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblidmovimiento2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txthoy1 = new javax.swing.JTextField();
        txtcontado1 = new javax.swing.JTextField();
        txtcredito1 = new javax.swing.JTextField();
        txtpagado1 = new javax.swing.JTextField();
        txtegresos1 = new javax.swing.JTextField();
        txtingresos1 = new javax.swing.JTextField();
        TXTCOMPRAS1 = new javax.swing.JTextField();
        txtapertura1 = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        menumovimiento = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menucompras = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        registros = new javax.swing.JMenu();
        MENUUSUARIO = new javax.swing.JMenuItem();
        cutMenuItem6 = new javax.swing.JMenuItem();
        menupaciente = new javax.swing.JMenuItem();
        menucategoria = new javax.swing.JMenuItem();
        menupaciente1 = new javax.swing.JMenuItem();
        menupaciente2 = new javax.swing.JMenuItem();
        menupaciente3 = new javax.swing.JMenuItem();
        menureporte = new javax.swing.JMenu();
        husuarios = new javax.swing.JMenuItem();
        historialventas = new javax.swing.JMenuItem();
        rpaciente = new javax.swing.JMenuItem();
        cutMenuItem5 = new javax.swing.JMenuItem();
        historialventas1 = new javax.swing.JMenuItem();
        historialventas2 = new javax.swing.JMenuItem();
        historialventas3 = new javax.swing.JMenuItem();
        historialventas6 = new javax.swing.JMenuItem();
        historialventas4 = new javax.swing.JMenuItem();
        historialventas5 = new javax.swing.JMenuItem();
        menurespaldo = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte diario"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("VENDIDO HOY:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 34, -1, -1));

        txtcontado.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcontado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcontado.setEnabled(false);
        txtcontado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontadoActionPerformed(evt);
            }
        });
        jPanel3.add(txtcontado, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 75, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONTADO:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 82, 90, -1));

        txthoy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txthoy.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txthoy.setEnabled(false);
        txthoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoyActionPerformed(evt);
            }
        });
        jPanel3.add(txthoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 27, 130, 30));

        txtcredito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcredito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcredito.setEnabled(false);
        txtcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcreditoActionPerformed(evt);
            }
        });
        jPanel3.add(txtcredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 123, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CREDITO:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 130, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("PAGADO:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 178, 90, -1));

        txtpagado.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtpagado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtpagado.setEnabled(false);
        txtpagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagadoActionPerformed(evt);
            }
        });
        jPanel3.add(txtpagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 171, 130, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL CAJA:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 411, 96, -1));

        txtcaja.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcaja.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcaja.setEnabled(false);
        txtcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcajaActionPerformed(evt);
            }
        });
        jPanel3.add(txtcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 404, 130, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("EGRESOS:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 225, 90, -1));

        txtegresos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtegresos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtegresos.setEnabled(false);
        txtegresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtegresosActionPerformed(evt);
            }
        });
        jPanel3.add(txtegresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 218, 130, 30));

        txtapertura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtapertura.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtapertura.setEnabled(false);
        txtapertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaperturaActionPerformed(evt);
            }
        });
        jPanel3.add(txtapertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 360, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MONTO APERTURA:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 367, 148, -1));

        txtingresos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtingresos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtingresos.setEnabled(false);
        txtingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresosActionPerformed(evt);
            }
        });
        jPanel3.add(txtingresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 266, 130, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("INGRESOS:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 273, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("COMPRAS:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 321, 90, -1));

        TXTCOMPRAS.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TXTCOMPRAS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TXTCOMPRAS.setEnabled(false);
        TXTCOMPRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCOMPRASActionPerformed(evt);
            }
        });
        jPanel3.add(TXTCOMPRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 314, 130, 30));

        lblfechahoy1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfechahoy1.setForeground(new java.awt.Color(255, 255, 255));
        lblfechahoy1.setText("Fecha :");

        lblfechahoy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfechahoy.setForeground(new java.awt.Color(255, 255, 255));
        lblfechahoy.setText("FECHA");

        lbldocumento.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbldocumento.setText("Cod_USUARIO");

        lblcodusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblcodusuario.setText("Cod_USUARIO");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ACCESO:");

        lblacceso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(255, 255, 255));
        lblacceso.setText("LABEL2");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO:");

        lblusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("LABEL1");

        lblidmovimiento2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblidmovimiento2.setText("a");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CAMBIAR USUARIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txthoy1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txthoy1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txthoy1.setEnabled(false);
        txthoy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoy1ActionPerformed(evt);
            }
        });

        txtcontado1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcontado1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcontado1.setEnabled(false);
        txtcontado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontado1ActionPerformed(evt);
            }
        });

        txtcredito1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcredito1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcredito1.setEnabled(false);
        txtcredito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcredito1ActionPerformed(evt);
            }
        });

        txtpagado1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtpagado1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtpagado1.setEnabled(false);
        txtpagado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagado1ActionPerformed(evt);
            }
        });

        txtegresos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtegresos1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtegresos1.setEnabled(false);
        txtegresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtegresos1ActionPerformed(evt);
            }
        });

        txtingresos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtingresos1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtingresos1.setEnabled(false);
        txtingresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresos1ActionPerformed(evt);
            }
        });

        TXTCOMPRAS1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TXTCOMPRAS1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TXTCOMPRAS1.setEnabled(false);
        TXTCOMPRAS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCOMPRAS1ActionPerformed(evt);
            }
        });

        txtapertura1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtapertura1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtapertura1.setEnabled(false);
        txtapertura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapertura1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblfechahoy1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblfechahoy, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXTCOMPRAS1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtingresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtpagado1)
                                .addComponent(txtcredito1)
                                .addComponent(txtegresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcontado1)
                                .addComponent(txthoy1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(947, 947, 947))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtapertura1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbldocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblcodusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblacceso, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(lblidmovimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfechahoy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfechahoy1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(txthoy1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcontado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcredito1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtpagado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(txtegresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtingresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TXTCOMPRAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtapertura1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldocumento)
                    .addComponent(lblidmovimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodusuario)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(lblacceso)
                        .addComponent(jLabel4)
                        .addComponent(lblusuario))))
        );

        jDesktopPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menumovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/caja.png"))); // NOI18N
        menumovimiento.setText("Movimiento");
        menumovimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setText("Ventas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menumovimiento.add(jMenuItem1);

        menucompras.setText("Compras");
        menucompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucomprasActionPerformed(evt);
            }
        });
        menumovimiento.add(menucompras);

        jMenuItem4.setText("Apertura Caja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menumovimiento.add(jMenuItem4);

        jMenuItem15.setText("Cierre Caja");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        menumovimiento.add(jMenuItem15);

        menuBar.add(menumovimiento);

        registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save.png"))); // NOI18N
        registros.setMnemonic('f');
        registros.setText("Registros");
        registros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        MENUUSUARIO.setMnemonic('x');
        MENUUSUARIO.setText("Usuarios");
        MENUUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENUUSUARIOActionPerformed(evt);
            }
        });
        registros.add(MENUUSUARIO);

        cutMenuItem6.setMnemonic('t');
        cutMenuItem6.setText("Productos");
        cutMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem6ActionPerformed(evt);
            }
        });
        registros.add(cutMenuItem6);

        menupaciente.setMnemonic('t');
        menupaciente.setText("Clientes");
        menupaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupacienteActionPerformed(evt);
            }
        });
        registros.add(menupaciente);

        menucategoria.setMnemonic('t');
        menucategoria.setText("Categorias");
        menucategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucategoriaActionPerformed(evt);
            }
        });
        registros.add(menucategoria);

        menupaciente1.setMnemonic('t');
        menupaciente1.setText("Proveedores");
        menupaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupaciente1ActionPerformed(evt);
            }
        });
        registros.add(menupaciente1);

        menupaciente2.setMnemonic('t');
        menupaciente2.setText("Ingresos y Egresos");
        menupaciente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupaciente2ActionPerformed(evt);
            }
        });
        registros.add(menupaciente2);

        menupaciente3.setMnemonic('t');
        menupaciente3.setText("Deudores");
        menupaciente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupaciente3ActionPerformed(evt);
            }
        });
        registros.add(menupaciente3);

        menuBar.add(registros);

        menureporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadistica.png"))); // NOI18N
        menureporte.setMnemonic('e');
        menureporte.setText("Reportes");
        menureporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        husuarios.setMnemonic('t');
        husuarios.setText("Reporte Usuarios");
        husuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                husuariosActionPerformed(evt);
            }
        });
        menureporte.add(husuarios);

        historialventas.setMnemonic('t');
        historialventas.setText("Imprimir Factura");
        historialventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventasActionPerformed(evt);
            }
        });
        menureporte.add(historialventas);

        rpaciente.setMnemonic('t');
        rpaciente.setText("Reporte Clientes");
        rpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpacienteActionPerformed(evt);
            }
        });
        menureporte.add(rpaciente);

        cutMenuItem5.setMnemonic('t');
        cutMenuItem5.setText("Reporte Productos");
        cutMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem5ActionPerformed(evt);
            }
        });
        menureporte.add(cutMenuItem5);

        historialventas1.setMnemonic('t');
        historialventas1.setText("Historial Ventas");
        historialventas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas1ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas1);

        historialventas2.setMnemonic('t');
        historialventas2.setText("Ventas del dia");
        historialventas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas2ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas2);

        historialventas3.setMnemonic('t');
        historialventas3.setText("Venta general");
        historialventas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas3ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas3);

        historialventas6.setMnemonic('t');
        historialventas6.setText("Historial Compras");
        historialventas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas6ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas6);

        historialventas4.setMnemonic('t');
        historialventas4.setText("Ingresos y Egresos");
        historialventas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas4ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas4);

        historialventas5.setMnemonic('t');
        historialventas5.setText("Resumen Ingresos y Egresos");
        historialventas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas5ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas5);

        menuBar.add(menureporte);

        menurespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/copias.png"))); // NOI18N
        menurespaldo.setMnemonic('f');
        menurespaldo.setText("Respaldo");
        menurespaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menurespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menurespaldoActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Copia de Seguridad");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menurespaldo.add(jMenuItem5);

        jMenuItem6.setText("Restaurar copia");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menurespaldo.add(jMenuItem6);

        menuBar.add(menurespaldo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MENUUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENUUSUARIOActionPerformed
        String x = frmusuario.x;
        try {
            if (x == null) {
                frmusuario form = new frmusuario();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_MENUUSUARIOActionPerformed
    static String idcaja1;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA P??RA HACER LAS VENTAS");        // TODO add your handling code here:

        } else {
            String x = frmventas.x;
            try {
                if (x == null) {
                    frmventas form = new frmventas();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void historialventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventasActionPerformed
        // TODO add your handling code here:
        String x = frmImprimir_factura.x;
        try {
            if (x == null) {
                frmImprimir_factura form = new frmImprimir_factura();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventasActionPerformed

    private void husuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_husuariosActionPerformed
        String x = frmusuarios_consulta.x;
        try {
            if (x == null) {
                frmusuarios_consulta form = new frmusuarios_consulta();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_husuariosActionPerformed

    private void rpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpacienteActionPerformed
        String x = frmpaciente_consulta.x;
        try {
            if (x == null) {
                frmpaciente_consulta form = new frmpaciente_consulta();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rpacienteActionPerformed


    private void cutMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem5ActionPerformed
        String x = frmconsulta_paciente.x;
        try {
            if (x == null) {
                frmconsulta_paciente form = new frmconsulta_paciente();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cutMenuItem5ActionPerformed

    private void cutMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem6ActionPerformed
        String x = frmproducto2.x;
        try {
            if (x == null) {
                frmproducto2 form = new frmproducto2();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cutMenuItem6ActionPerformed

    private void menupacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupacienteActionPerformed
        String x = frmpaciente.x;
        try {
            if (x == null) {
                frmpaciente form = new frmpaciente();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menupacienteActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String x = FrmApertura_Caja.x;
        try {
            if (x == null) {
                FrmApertura_Caja form = new FrmApertura_Caja();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
                documento = lbldocumento.getText();
                id_usuario = lblcodusuario.getText();
                usuario = lblusuario.getText();
                FrmApertura_Caja.txtnombreapellido.setText(usuario);
                FrmApertura_Caja.txtID.setText(id_usuario);
                FrmApertura_Caja.txtDocumento.setText(documento);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmusuariologin frm = new frmusuariologin();
        frm.setVisible(true);
        frm.toFront();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -uroot -p12345 ventas");

            new HiloLector(p.getErrorStream()).start();

            InputStream is = p.getInputStream();//Pedimos la entrada

            FileOutputStream fos = new FileOutputStream("backup_ventas.sql"); //creamos el archivo para le respaldo

            byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

            int leido = is.read(buffer); //Devuelve el n??mero de bytes le??dos o -1 si se alcanz?? el final del stream.

            while (leido > 0) {
                fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, N??mero de caracteres para escribir
                leido = is.read(buffer);
            }

            fos.close();//Cierra respaldo

        } catch (IOException ex) {
            Logger.getLogger(copia_de_seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String x = Backup.x;
        try {
            if (x == null) {
                Backup form = new Backup();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String x = frmrestaurar_copia.x;
        try {
            if (x == null) {
                frmrestaurar_copia form = new frmrestaurar_copia();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menurespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menurespaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menurespaldoActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        String x = FrmCerrarCaja.x;
        try {
            if (x == null) {
                FrmCerrarCaja form = new FrmCerrarCaja();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void menucategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucategoriaActionPerformed
        String x = FrmCategorias.x;
        try {
            if (x == null) {
                FrmCategorias form = new FrmCategorias();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_menucategoriaActionPerformed

    private void menucomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucomprasActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA P??RA HACER LAS COMPRAS");        // TODO add your handling code here:

        } else {
            String x = frmcompras.x;
            try {
                if (x == null) {
                    frmcompras form = new frmcompras();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menucomprasActionPerformed

    private void menupaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupaciente1ActionPerformed
        String x = frmproveedor.x;
        try {
            if (x == null) {
                frmproveedor form = new frmproveedor();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menupaciente1ActionPerformed

    private void menupaciente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupaciente2ActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA P??RA CARGAR UN EGRESO");        // TODO add your handling code here:

        } else {
            String x = frmEgresos.x;
            try {
                if (x == null) {
                    frmEgresos form = new frmEgresos();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                    frmEgresos.txtidmovimiento.setText(idcaja1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_menupaciente2ActionPerformed

    private void menupaciente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupaciente3ActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PARA VER LOS DEUDORES");        // TODO add your handling code here:

        } else {
            String x = frmDeudas.x;
            try {
                if (x == null) {
                    frmDeudas form = new frmDeudas();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
//                    frmDeudas.txtidmovimiento.setText(idcaja1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menupaciente3ActionPerformed

    private void historialventas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas1ActionPerformed
        String x = frmhistorial_ventas.x;
        try {
            if (x == null) {
                frmhistorial_ventas form = new frmhistorial_ventas();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas1ActionPerformed

    private void historialventas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas2ActionPerformed
        String x = frmventas_diarias.x;
        try {
            if (x == null) {
                frmventas_diarias form = new frmventas_diarias();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas2ActionPerformed

    private void historialventas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas3ActionPerformed
        String x = frmventa_general.x;
        try {
            if (x == null) {
                frmventa_general form = new frmventa_general();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas3ActionPerformed

    private void historialventas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas4ActionPerformed
        String x = frm_ingreso_egreso.x;
        try {
            if (x == null) {
                frm_ingreso_egreso form = new frm_ingreso_egreso();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas4ActionPerformed

    private void historialventas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas5ActionPerformed
        String x = frm_ingreso_egreso_final.x;
        try {
            if (x == null) {
                frm_ingreso_egreso_final form = new frm_ingreso_egreso_final();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas5ActionPerformed

    private void historialventas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas6ActionPerformed
        String x = frmhistorial_compras.x;
        try {
            if (x == null) {
                frmhistorial_compras form = new frmhistorial_compras();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas6ActionPerformed

    private void txtapertura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapertura1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapertura1ActionPerformed

    private void TXTCOMPRAS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCOMPRAS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCOMPRAS1ActionPerformed

    private void txtingresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresos1ActionPerformed

    private void txtegresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtegresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtegresos1ActionPerformed

    private void txtpagado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagado1ActionPerformed

    private void txtcredito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcredito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredito1ActionPerformed

    private void txtcontado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontado1ActionPerformed

    private void txthoy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoy1ActionPerformed

    private void TXTCOMPRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCOMPRASActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCOMPRASActionPerformed

    private void txtingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresosActionPerformed

    private void txtaperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaperturaActionPerformed

    private void txtegresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtegresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtegresosActionPerformed

    private void txtcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcajaActionPerformed

    private void txtpagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagadoActionPerformed

    private void txtcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoActionPerformed

    private void txthoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoyActionPerformed

    private void txtcontadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoActionPerformed

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
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem MENUUSUARIO;
    public static javax.swing.JTextField TXTCOMPRAS;
    public static javax.swing.JTextField TXTCOMPRAS1;
    public static javax.swing.JMenuItem cutMenuItem5;
    public static javax.swing.JMenuItem cutMenuItem6;
    public static javax.swing.JMenuItem historialventas;
    public static javax.swing.JMenuItem historialventas1;
    public static javax.swing.JMenuItem historialventas2;
    public static javax.swing.JMenuItem historialventas3;
    public static javax.swing.JMenuItem historialventas4;
    public static javax.swing.JMenuItem historialventas5;
    public static javax.swing.JMenuItem historialventas6;
    public static javax.swing.JMenuItem husuarios;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane2;
    public static javax.swing.JLabel jLabel1;
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
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem15;
    public static javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblcodusuario;
    public static javax.swing.JLabel lbldocumento;
    public static javax.swing.JLabel lblfechahoy;
    public static javax.swing.JLabel lblfechahoy1;
    public static javax.swing.JLabel lblidmovimiento2;
    public static javax.swing.JLabel lblusuario;
    public static javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenuItem menucategoria;
    public static javax.swing.JMenuItem menucompras;
    public static javax.swing.JMenu menumovimiento;
    public static javax.swing.JMenuItem menupaciente;
    public static javax.swing.JMenuItem menupaciente1;
    public static javax.swing.JMenuItem menupaciente2;
    public static javax.swing.JMenuItem menupaciente3;
    public static javax.swing.JMenu menureporte;
    public static javax.swing.JMenu menurespaldo;
    public static javax.swing.JMenu registros;
    public static javax.swing.JMenuItem rpaciente;
    public static javax.swing.JTextField txtapertura;
    public static javax.swing.JTextField txtapertura1;
    public static javax.swing.JTextField txtcaja;
    public static javax.swing.JTextField txtcontado;
    public static javax.swing.JTextField txtcontado1;
    public static javax.swing.JTextField txtcredito;
    public static javax.swing.JTextField txtcredito1;
    public static javax.swing.JTextField txtegresos;
    public static javax.swing.JTextField txtegresos1;
    public static javax.swing.JTextField txthoy;
    public static javax.swing.JTextField txthoy1;
    public static javax.swing.JTextField txtingresos;
    public static javax.swing.JTextField txtingresos1;
    public static javax.swing.JTextField txtpagado;
    public static javax.swing.JTextField txtpagado1;
    // End of variables declaration//GEN-END:variables
//codigo para agregar imgaen
    class Fondopanel extends JPanel {

        private Image imagen;//se declara una variable

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Iconos/fondo.jpg")).getImage();//selecciona el paquete y la imagen que se quiere usar
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);//obtiene el tama??o del panel para ajustar la imagen
            setOpaque(false);//sirve para que se vea la imagen
            super.paint(g);//para mostrar todos los componentes del panel que estan estableci
        }
    }
}
