/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vmovimiento_caja;
import Logica.Conexion;
import Logica.fmovimiento_caja;
import static Logica.fproductos.cn;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author José Ayala
 */
public class FrmCerrarCaja extends javax.swing.JInternalFrame {

    public static String x;

    public FrmCerrarCaja() {
        initComponents();

        //codigo para centrar internalframe
//        x = "x";
//        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
//        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
//        setLocation(a / 2, b / 2);
//        setVisible(true);
        inhabilitar();
        txtID.setVisible(false);
        txtIDCaja.setVisible(false);
        cargarpasodefocus();
        centrar_Frm();
    }
    private Connection connection = new Conexion().conectar();

    void centrar_Frm() {
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    void cargarpasodefocus() {
        txtNroCaja.setNextFocusableComponent(jButton1);
        jButton1.setNextFocusableComponent(txtMontoApertura);
        txtMontoApertura.setNextFocusableComponent(txtmontocierre);
        txtmontocierre.setNextFocusableComponent(jFechaCierre);
        jFechaCierre.setNextFocusableComponent(txtDocumento);
        txtDocumento.setNextFocusableComponent(txtNroCaja);
    }
    static String opciones = "";

    public static void habilitar(boolean f) {
        txtMontoApertura.setEnabled(true);
        txtmontocierre.setEnabled(true);
        jFechaCierre.setEnabled(false);
        txtDocumento.setEnabled(true);
        txtmontoegreso.setEnabled(true);
        txtIDCaja.setText("");
        txtID.setText("");
        txtMontoApertura.setText("0");
        txtmontocierre.setText("0");
        txtDocumento.setText("");
        txtcapitalcaja.setText("0");
        txtnombreapellido.setText("");
        txtmontoacumulado.setText("0");
        btnguardar.setEnabled(true);
        if (f == true) {
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
            String anho = Integer.toString(c.get(Calendar.YEAR));
            String fechaactual = dia + "-" + mes + "-" + anho;
            try {
                java.util.Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaactual);
                jFechaCierre.setDate(fecha);
            } catch (Exception e) {

            }

            txtNroCaja.requestFocus();
        }

    }

    public static void inhabilitar() {
        txtMontoApertura.setEnabled(true);
        txtmontocierre.setEnabled(true);
        jFechaCierre.setEnabled(false);
        txtcapitalcaja.setEnabled(true);
        txtmontoegreso.setEnabled(true);
        txtDocumento.setEnabled(true);
        txtnombreapellido.setEnabled(true);
        txtmontoacumulado.setEnabled(true);
        txtMontoApertura.setText("0");
        txtmontocierre.setText("0");
        txtcompras.setText("0");
        txtDocumento.setText("");
        txtnombreapellido.setText("");
        txtmontoacumulado.setText("0");
        txtcapitalcaja.setText("0");
        txtcontado.setText("0");
        txtmontoegreso.setText("0");
        txtotros.setText("0");
        txtcredito.setText("0");
        txtIDCaja.setText("");
        txtID.setText("");
        txtNroCaja.setText("");
        btnguardar.setEnabled(false);  
        txtNroCaja.requestFocus();
    }

    public static void imprimir_cierre() {

        try {
//            System.out.println("imprimiendo");
            Map p = new HashMap();
            p.put("id", txtID.getText());
            p.put("usuario", txtnombreapellido.getText());
            p.put("contado", txtcontado.getText());
            p.put("cobrado", txtcobrado.getText());
            p.put("credito", txtcredito.getText());
            p.put("egresos", txtmontoegreso.getText());

            JasperReport jr;
            JasperPrint jp;

            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rpt_cierre_caja.jrxml");//Jasper para tener vista en exel y demas editores de texto

            jp = JasperFillManager.fillReport(jr, p, cn);
//            JasperPrintManager.printReport(jp, true);

            JasperViewer view = new JasperViewer(jp, false);
            view.setTitle("Reporte de cierre");
            view.setVisible(true);
//            System.out.println("imprimiendo2");

        } catch (Exception e) {
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        txtMontoApertura = new javax.swing.JTextField();
        txtNroCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtmontocierre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFechaCierre = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtnombreapellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmontoacumulado = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtIDCaja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtmontoegreso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtcapitalcaja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcontado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcobrado = new javax.swing.JTextField();
        txtcredito = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtotros = new javax.swing.JTextField();
        txtcompras = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIDCaja1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtIDCaja2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtIDCaja3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIDCaja4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtIDCaja5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIDCaja6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtIDCaja7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtIDCaja8 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtIDCaja9 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtIDCaja10 = new javax.swing.JTextField();

        setClosable(true);
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setToolTipText("");

        txtMontoApertura.setEditable(false);
        txtMontoApertura.setForeground(new java.awt.Color(0, 153, 0));
        txtMontoApertura.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMontoApertura.setEnabled(false);
        txtMontoApertura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoAperturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoAperturaFocusLost(evt);
            }
        });
        txtMontoApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoAperturaActionPerformed(evt);
            }
        });
        txtMontoApertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoAperturaKeyReleased(evt);
            }
        });

        txtNroCaja.setEditable(false);
        txtNroCaja.setEnabled(false);
        txtNroCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroCajaFocusLost(evt);
            }
        });
        txtNroCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroCajaActionPerformed(evt);
            }
        });
        txtNroCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroCajaKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(222, 220, 220));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("NRO. CAJA");

        jLabel3.setBackground(new java.awt.Color(222, 220, 220));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("INGRESO VENTA");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtmontocierre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontocierreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontocierreFocusLost(evt);
            }
        });
        txtmontocierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontocierreActionPerformed(evt);
            }
        });
        txtmontocierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmontocierreKeyReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(222, 220, 220));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("MONTO CIERRE");

        jLabel8.setBackground(new java.awt.Color(222, 220, 220));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("FECHA CIERRE");

        jLabel9.setBackground(new java.awt.Color(222, 220, 220));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("C.I.");

        txtDocumento.setEditable(false);
        txtDocumento.setEnabled(false);
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        txtnombreapellido.setEditable(false);
        txtnombreapellido.setEnabled(false);
        txtnombreapellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombreapellidoFocusGained(evt);
            }
        });
        txtnombreapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreapellidoActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(222, 220, 220));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("USUARIO");

        jLabel5.setBackground(new java.awt.Color(222, 220, 220));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("MONTO APERTURA");

        txtmontoacumulado.setEditable(false);
        txtmontoacumulado.setBackground(new java.awt.Color(255, 255, 153));
        txtmontoacumulado.setForeground(new java.awt.Color(0, 153, 0));
        txtmontoacumulado.setDisabledTextColor(new java.awt.Color(255, 255, 153));
        txtmontoacumulado.setEnabled(false);
        txtmontoacumulado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontoacumuladoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontoacumuladoFocusLost(evt);
            }
        });
        txtmontoacumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoacumuladoActionPerformed(evt);
            }
        });

        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtIDCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCajaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CIERRE CAJA");
        jLabel1.setOpaque(true);

        txtmontoegreso.setEditable(false);
        txtmontoegreso.setBackground(new java.awt.Color(255, 255, 153));
        txtmontoegreso.setForeground(new java.awt.Color(255, 0, 0));
        txtmontoegreso.setEnabled(false);
        txtmontoegreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontoegresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontoegresoFocusLost(evt);
            }
        });
        txtmontoegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoegresoActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(222, 220, 220));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("EGRESO VENTA");

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setText("Cerrar Caja");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        txtcapitalcaja.setEditable(false);
        txtcapitalcaja.setForeground(new java.awt.Color(255, 153, 0));
        txtcapitalcaja.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtcapitalcaja.setEnabled(false);
        txtcapitalcaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcapitalcajaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcapitalcajaFocusLost(evt);
            }
        });
        txtcapitalcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcapitalcajaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(222, 220, 220));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("TOTAL CAJA");

        txtcontado.setEditable(false);
        txtcontado.setBackground(new java.awt.Color(255, 255, 153));
        txtcontado.setForeground(new java.awt.Color(255, 0, 0));
        txtcontado.setEnabled(false);
        txtcontado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcontadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontadoFocusLost(evt);
            }
        });
        txtcontado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontadoActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(222, 220, 220));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("VENTA CONTADO");

        jLabel12.setBackground(new java.awt.Color(222, 220, 220));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("VENTA CREDITO");

        jLabel13.setBackground(new java.awt.Color(222, 220, 220));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("TOTAL COBRADO");

        txtcobrado.setEditable(false);
        txtcobrado.setBackground(new java.awt.Color(255, 255, 153));
        txtcobrado.setForeground(new java.awt.Color(255, 0, 0));
        txtcobrado.setEnabled(false);
        txtcobrado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcobradoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcobradoFocusLost(evt);
            }
        });
        txtcobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcobradoActionPerformed(evt);
            }
        });

        txtcredito.setEditable(false);
        txtcredito.setBackground(new java.awt.Color(255, 255, 153));
        txtcredito.setForeground(new java.awt.Color(255, 0, 0));
        txtcredito.setEnabled(false);
        txtcredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcreditoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcreditoFocusLost(evt);
            }
        });
        txtcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcreditoActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(222, 220, 220));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("OTROS INGRESOS");

        txtotros.setEditable(false);
        txtotros.setBackground(new java.awt.Color(255, 255, 153));
        txtotros.setForeground(new java.awt.Color(0, 153, 0));
        txtotros.setDisabledTextColor(new java.awt.Color(102, 204, 0));
        txtotros.setEnabled(false);
        txtotros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtotrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtotrosFocusLost(evt);
            }
        });
        txtotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotrosActionPerformed(evt);
            }
        });

        txtcompras.setEditable(false);
        txtcompras.setBackground(new java.awt.Color(255, 255, 153));
        txtcompras.setForeground(new java.awt.Color(255, 0, 0));
        txtcompras.setEnabled(false);
        txtcompras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcomprasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcomprasFocusLost(evt);
            }
        });
        txtcompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomprasActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(222, 220, 220));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("TOTAL COMPRAS");

        txtIDCaja1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja1ActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(222, 220, 220));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("50 GS");

        jLabel17.setBackground(new java.awt.Color(222, 220, 220));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("100 GS");

        txtIDCaja2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja2ActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(222, 220, 220));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("500 GS");

        txtIDCaja3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja3ActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(222, 220, 220));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("1.000 GS");

        txtIDCaja4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja4ActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(222, 220, 220));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("2.000 GS");

        txtIDCaja5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja5ActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(222, 220, 220));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("5.000 GS");

        txtIDCaja6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja6ActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(222, 220, 220));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("10.000GS");

        txtIDCaja7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja7ActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(222, 220, 220));
        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("20.000 GS");

        txtIDCaja8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja8ActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(222, 220, 220));
        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("50.000 GS");

        txtIDCaja9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja9ActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(222, 220, 220));
        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("100.000 GS");

        txtIDCaja10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtIDCaja10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCaja10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtIDCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMontoApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmontocierre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtmontoegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtotros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtmontoacumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtcapitalcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcontado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtcompras, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombreapellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(txtcredito, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jFechaCierre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCaja10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtIDCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(txtNroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtMontoApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmontoegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmontoacumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcapitalcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcontado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtotros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombreapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtcobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtcompras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmontocierre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIDCaja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDCaja10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroCajaActionPerformed
        // TODO add your handling code here:
        jButton1.requestFocus();

    }//GEN-LAST:event_txtNroCajaActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmVista2 form = new FrmVista2();

        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 2;
        form.lbltitulovista.setText("CIERRE DE CAJA");
        DefaultComboBoxModel modelocbo;
        modelocbo = new DefaultComboBoxModel();
        modelocbo.addElement("ACTIVO");
        form.txtbuscar.setText(frmprincipal.lblcodusuario.getText());
        form.txtbuscar.setEnabled(false);
        form.jComboBox1.setModel(modelocbo);
        form.buscador();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMontoAperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoAperturaActionPerformed
        // TODO add your handling code here:
        txtmontocierre.requestFocus();
    }//GEN-LAST:event_txtMontoAperturaActionPerformed

    private void txtMontoAperturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoAperturaFocusGained
        // TODO add your handling code here:
//       funControl.controlarestejtextfield(txtNroCaja,"ESTE CAMPO NO PUEDE QUEDAR VACÍO");

    }//GEN-LAST:event_txtMontoAperturaFocusGained

    private void txtMontoAperturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoAperturaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMontoAperturaFocusLost

    private void txtNroCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroCajaKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (txtNroCaja.getText().length() > 3) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtNroCajaKeyTyped

    private void txtNroCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroCajaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroCajaFocusLost

    private void txtmontocierreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontocierreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontocierreFocusGained

    private void txtmontocierreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontocierreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontocierreFocusLost

    private void txtmontocierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontocierreActionPerformed
        // TODO add your handling code here:
        txtDocumento.requestFocus();
    }//GEN-LAST:event_txtmontocierreActionPerformed

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDocumentoFocusLost

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtnombreapellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreapellidoFocusGained
        // TODO add your handling code here:
//        funControl.controlarestejtextfield(txtDocumento, "ESTE CAMPO NO PUEDE QUEDAR VACÍO");
    }//GEN-LAST:event_txtnombreapellidoFocusGained

    private void txtnombreapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreapellidoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardareditar();
        frmprincipal.mostrarhoy(frmprincipal.lblidmovimiento2.getText());
        frmprincipal.txtapertura.setText("0");
        frmprincipal.txtcaja.setText("0");


    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtmontoacumuladoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoacumuladoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoacumuladoFocusGained

    private void txtmontoacumuladoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoacumuladoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoacumuladoFocusLost

    private void txtmontoacumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoacumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoacumuladoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCajaActionPerformed
    DecimalFormat formatea = new DecimalFormat();
    private void txtMontoAperturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAperturaKeyReleased
        if (txtMontoApertura.getText().length() >= 0) {
            txtMontoApertura.setText(txtMontoApertura.getText().replace(".", ""));
            int c = Integer.parseInt(txtMontoApertura.getText());
            txtMontoApertura.setText(formatea.format(c) + "");
        }// TODO add your handling code here:

    }//GEN-LAST:event_txtMontoAperturaKeyReleased

    private void txtmontocierreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontocierreKeyReleased
        // TODO add your handling code here:
        if (txtmontocierre.getText().length() >= 0) {
            txtmontocierre.setText(txtmontocierre.getText().replace(".", ""));
            int c = Integer.parseInt(txtmontocierre.getText());
            txtmontocierre.setText(formatea.format(c) + "");
        }

    }//GEN-LAST:event_txtmontocierreKeyReleased

    private void txtmontoegresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoegresoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoFocusGained

    private void txtmontoegresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoegresoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoFocusLost

    private void txtmontoegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoegresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoActionPerformed

    private void txtcapitalcajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcapitalcajaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaFocusGained

    private void txtcapitalcajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcapitalcajaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaFocusLost

    private void txtcapitalcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcapitalcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtcontadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontadoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoFocusGained

    private void txtcontadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontadoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoFocusLost

    private void txtcontadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoActionPerformed

    private void txtcobradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcobradoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoFocusGained

    private void txtcobradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcobradoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoFocusLost

    private void txtcobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcobradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoActionPerformed

    private void txtcreditoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcreditoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoFocusGained

    private void txtcreditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcreditoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoFocusLost

    private void txtcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoActionPerformed

    private void txtotrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotrosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosFocusGained

    private void txtotrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotrosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosFocusLost

    private void txtotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosActionPerformed

    private void txtcomprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcomprasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasFocusGained

    private void txtcomprasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcomprasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasFocusLost

    private void txtcomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasActionPerformed

    private void txtIDCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja1ActionPerformed

    private void txtIDCaja2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja2ActionPerformed

    private void txtIDCaja3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja3ActionPerformed

    private void txtIDCaja4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja4ActionPerformed

    private void txtIDCaja5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja5ActionPerformed

    private void txtIDCaja6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja6ActionPerformed

    private void txtIDCaja7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja7ActionPerformed

    private void txtIDCaja8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja8ActionPerformed

    private void txtIDCaja9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja9ActionPerformed

    private void txtIDCaja10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCaja10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCaja10ActionPerformed
    static void guardareditar() {
        if (txtNroCaja.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "FALTO EL NRO DE CAJA");
            return;
        }
        if (txtmontocierre.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "FALTO INGRESAR EL MONTO DE CIERRE");
            return;
        }

        String montoApertura = txtMontoApertura.getText();
        String montoCierre = txtmontocierre.getText();
        String montototal = txtcapitalcaja.getText();

        try {

            montoApertura = montoApertura.replace(".", "");
            montoApertura = montoApertura.replace(",", ".");
            if (Double.parseDouble(montoApertura) <= 0) {
                JOptionPane.showMessageDialog(null, "LA CANTIDAD NO PUEDE SER MENOR A 0");
                return;
            }

            montoCierre = montoCierre.replace(".", "");
            montoCierre = montoCierre.replace(",", ".");
            montototal = montototal.replace(".", "");
            montoCierre = montoCierre.replace(",", ".");

            if (Double.parseDouble(montototal) != Double.parseDouble(montoCierre)) {
                JOptionPane.showMessageDialog(null, "EL MONTO NO PUEDE SER MENOR A 0 NI DIFERENTE AL TOTAL DE LA CAJA");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LA CANTIDAD INGRESADA DEL MONTO APERTURA O MONTO CIERRE ES INVALIDO");
            return;
        }

        fmovimiento_caja func = new fmovimiento_caja();

        vmovimiento_caja dts = new vmovimiento_caja();

//        dts.setNrocaja(txtNroCaja.getText());
        dts.setMonto_apertura(Long.parseLong(montoApertura));
        dts.setMonto_cierre(Long.parseLong(montoCierre));
        Calendar cal;
        int d, m, a;
        cal = jFechaCierre.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_cierre(new Date(a, m, d));

        dts.setEstado("CERRADO");

        dts.setIdmovimiento(Integer.parseInt(txtIDCaja.getText()));
        if (func.cerraCaja(dts)) {

            JOptionPane.showMessageDialog(null, "CAJA CERRADA CORRECTAMENTE");
//            ();
            imprimir_cierre();
            inhabilitar();
            frmprincipal.lblidmovimiento2.setText("0");

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCerrarCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    public static com.toedter.calendar.JDateChooser jFechaCierre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtDocumento;
    public static javax.swing.JTextField txtID;
    public static javax.swing.JTextField txtIDCaja;
    public static javax.swing.JTextField txtIDCaja1;
    public static javax.swing.JTextField txtIDCaja10;
    public static javax.swing.JTextField txtIDCaja2;
    public static javax.swing.JTextField txtIDCaja3;
    public static javax.swing.JTextField txtIDCaja4;
    public static javax.swing.JTextField txtIDCaja5;
    public static javax.swing.JTextField txtIDCaja6;
    public static javax.swing.JTextField txtIDCaja7;
    public static javax.swing.JTextField txtIDCaja8;
    public static javax.swing.JTextField txtIDCaja9;
    public static javax.swing.JTextField txtMontoApertura;
    public static javax.swing.JTextField txtNroCaja;
    public static javax.swing.JTextField txtcapitalcaja;
    public static javax.swing.JTextField txtcobrado;
    public static javax.swing.JTextField txtcompras;
    public static javax.swing.JTextField txtcontado;
    public static javax.swing.JTextField txtcredito;
    public static javax.swing.JTextField txtmontoacumulado;
    public static javax.swing.JTextField txtmontocierre;
    public static javax.swing.JTextField txtmontoegreso;
    public static javax.swing.JTextField txtnombreapellido;
    public static javax.swing.JTextField txtotros;
    // End of variables declaration//GEN-END:variables
}
