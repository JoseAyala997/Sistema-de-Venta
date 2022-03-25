/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vegresos;
import Datos.vproductos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Torres
 */
public class fdeudas {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "DESCRIPCION", "MONTO", "FECHA", "HORA", "ESTADO","ID MOV."};
        String[] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT idegresos, descripcion, monto,fecha,hora, estado, idmovimiento from egresos \n"
                + "where (descripcion like '%" + buscar + "%' or fecha like '%" + buscar + "%') and estado='ACTIVO' order by idegresos desc";
        
        TotalRegistros = 0;
   
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idegresos");
                registro[1] = rs.getString("descripcion");
                registro[2] = rs.getString("monto");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("hora");
                registro[5] = rs.getString("estado");
                registro[6] = rs.getString("idmovimiento");

                TotalRegistros = TotalRegistros + 1;


                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
    public boolean insertar(vegresos dts) {
        SQL = "INSERT INTO egresos (descripcion, monto, fecha, hora, estado, idusuarios,idmovimiento)"
                + " values (upper(?),?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getDescripcion());
            pst.setLong(2, dts.getMonto());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getHora());
            pst.setString(5, "ACTIVO");
            pst.setInt(6, dts.getIdusuarios());
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

    public boolean eliminar(vegresos dts) {
        SQL = "UPDATE egresos set estado=? \n"
                + "where idegresos=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdegresos());

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

    public boolean editar(vegresos dts) {
        SQL = " update egresos set descripcion=upper(?), monto=?, fecha=?, hora=?, estado=?, idusuarios=? where idegresos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getDescripcion());
            pst.setLong(2, dts.getMonto());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getHora());
            pst.setString(5, "ACTIVO");
            pst.setInt(6, dts.getIdusuarios());
//            pst.setInt(7, dts.getIdmovimiento());
            pst.setInt(7, dts.getIdegresos());
            
            
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

}
