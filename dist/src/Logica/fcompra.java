/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.vcompras;
import Datos.vdetalle_compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ALUMNO
 */
    public class fcompra {
    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();
    
    
  public boolean insertarVentas(vcompras dts) {
        SQL = "INSERT INTO compras (idusuarios, total, fecha, nro_factura, tipo, estado, idmovimiento)"
                + " values (?,?,?,?,?,?,?)";

        try {
            
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setLong(2, dts.getTotal());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getNro_factura());
            pst.setString(5, dts.getTipo());
            pst.setString(6, dts.getEstado());
            pst.setInt(7, dts.getIdmovimiento());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
  
   public boolean insertarDetalle(vdetalle_compra dts) {
        SQL = "INSERT INTO detalle_compra (idcompra, idservicios, cantidad, precio, sub_total, pulgadas)"
                + "values ((select idcompra from compras order by idcompra desc limit 1 ),?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
         
            pst.setInt(1, dts.getIdservicios());
            pst.setInt(2, dts.getCantidad());
            pst.setLong(3, dts.getPrecio());
            pst.setLong(4, dts.getSub_total());
            pst.setInt(5, dts.getPulgadas());
            
      
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
   
     public int NroFactura() {
         
         int NroFactura=0;
        SQL = "SELECT (count(*) + 1) contador FROM compras;";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                NroFactura = rs.getInt("contador");
             

            }
            return NroFactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }
}
