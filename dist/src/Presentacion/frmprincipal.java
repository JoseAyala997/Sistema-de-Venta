/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import CONSULTAS.frmconsulta_paciente;
import CONSULTAS.frmconsultar_dietas;

import CONSULTAS.frmhistorial_Reservas;
import CONSULTAS.frmhistorial_ventas;
import CONSULTAS.frmimprimir_dieta;
import CONSULTAS.frmpaciente_consulta;
import CONSULTAS.frmusuarios_consulta;
import Logica.StyloTabla;
import Logica.fmovimiento_caja;
import Logica.fusuarios;

import Respaldos.Backup;
import Respaldos.HiloLector;
import Respaldos.copia_de_seguridad;
import Respaldos.frmrestaurar_copia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
//        jPanel1.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();
        lblcodusuario.setVisible(false);
        lbldocumento.setVisible(false);
        this.setExtendedState(frmprincipal.MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new Fondopanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblcodusuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbldocumento = new javax.swing.JLabel();
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
        historialventas = new javax.swing.JMenuItem();
        husuarios = new javax.swing.JMenuItem();
        rpaciente = new javax.swing.JMenuItem();
        cutMenuItem5 = new javax.swing.JMenuItem();
        menurespaldo = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("USUARIO:");

        lblusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(102, 102, 102));
        lblusuario.setText("LABEL1");

        lblacceso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(102, 102, 102));
        lblacceso.setText("LABEL2");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("ACCESO:");

        lblcodusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblcodusuario.setText("Cod_USUARIO");

        jButton1.setText("CAMBIAR USUARIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbldocumento.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbldocumento.setText("Cod_USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblcodusuario)
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblacceso, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblacceso)
                    .addComponent(jLabel4)
                    .addComponent(lblcodusuario)
                    .addComponent(lblusuario)
                    .addComponent(lbldocumento)))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 462, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        menupaciente2.setText("Egresos");
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

        historialventas.setMnemonic('t');
        historialventas.setText("Historial Ventas");
        historialventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventasActionPerformed(evt);
            }
        });
        menureporte.add(historialventas);

        husuarios.setMnemonic('t');
        husuarios.setText("Reporte Usuarios");
        husuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                husuariosActionPerformed(evt);
            }
        });
        menureporte.add(husuarios);

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
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA HACER LAS VENTAS");        // TODO add your handling code here:

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

            int leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.

            while (leido > 0) {
                fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
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
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA HACER LAS COMPRAS");        // TODO add your handling code here:

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
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA CARGAR UN EGRESO");        // TODO add your handling code here:

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
    public static javax.swing.JMenuItem cutMenuItem5;
    public static javax.swing.JMenuItem cutMenuItem6;
    public static javax.swing.JMenuItem historialventas;
    public static javax.swing.JMenuItem husuarios;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JDesktopPane jDesktopPane2;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem15;
    public static javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblcodusuario;
    public static javax.swing.JLabel lbldocumento;
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
    // End of variables declaration//GEN-END:variables
//codigo para agregar imgaen
    class Fondopanel extends JPanel {

        private Image imagen;//se declara una variable

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Iconos/icononutricion.jpg")).getImage();//selecciona el paquete y la imagen que se quiere usar
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);//obtiene el tamaño del panel para ajustar la imagen
            setOpaque(false);//sirve para que se vea la imagen
            super.paint(g);//para mostrar todos los componentes del panel que estan estableci
        }
    }
}
