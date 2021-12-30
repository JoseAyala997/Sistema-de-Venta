/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.valimentos;
import Datos.vmovimiento_caja;
import Datos.vpacientes;
import static Logica.fservicios.SQL;
import static Logica.fservicios.cn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */

public class fmovimiento_caja {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public static int jose;
   
    public Integer totalregistros;

    public void mostrar() {
    
        sSQL = "select max(idmovimiento)as id from movimiento_caja ";
      
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
              jose = rs.getInt("id");
//                System.out.println("hola" + jose);

            }
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
      
    }
    
     
    public boolean insertar_apertura(vmovimiento_caja dts) {
        
        sSQL= "insert into movimiento_caja (idusuarios, fecha_apertura, apertura, fecha_cierre, cierre, estado)"
                + "values(?,?,?,?,?,?)";
        
         try {
           PreparedStatement pst = cn.prepareStatement(sSQL);

               pst.setInt(1, dts.getIdusuarios());
            pst.setDate(2, dts.getFecha_apertura());
            pst.setLong(3, dts.getApertura());
            pst.setDate(4, dts.getFecha_cierre());
            pst.setLong(5, dts.getCierre());
            pst.setString(6, "ABIERTO");
            
              int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            }

            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

        
         public boolean Insertar_cierre(vmovimiento_caja dts) {
           mostrar();
        sSQL = "UPDATE movimiento_caja set  fecha_cierre=?, cierre=?, estado=?\n"
                + "where idmovimiento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

   
            pst.setDate(1, dts.getFecha_cierre());
            pst.setLong(2, dts.getCierre());
            pst.setString(3, "CERRADO");
            pst.setInt(4, jose);
         

            int n = pst.executeUpdate();
//              System.out.println(pst);
            if (n != 0) {

                return true;
            }

            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
   }
   }
