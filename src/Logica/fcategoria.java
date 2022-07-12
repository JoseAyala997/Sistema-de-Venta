/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcategoria;
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
public class fcategoria {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "CATEGORIA", "ESTADO"};
        String[] registro = new String[3];
        TotalRegistros = 0;
        try {
            cn = mysql.conectar();
            Statement st = cn.createStatement();

            modelo = new DefaultTableModel(null, titulos);
            SQL = "SELECT idcategorias,categoria,estado FROM categorias where categoria like '%" + buscar + "%'  and estado = 'ACTIVO'  order by idcategorias desc";

            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registro[0] = rs.getString("idcategorias");
                registro[1] = rs.getString("categoria");
                registro[2] = rs.getString("estado");

                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);

            }
            cn.close();
            st.close();
            rs.close();
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vcategoria dts) {
        SQL = "INSERT INTO categorias (categoria, estado)"
                + " values (upper(?),?)";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getCategoria());

            pst.setString(2, "ACTIVO");
            int n = pst.executeUpdate();
            if (n != 0) {
                cn.close();
                return true;
            } else {
                cn.close();
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vcategoria dts) {
        SQL = "UPDATE categorias set estado=? \n"
                + "where idcategorias=? ";
        try {
            cn = mysql.conectar();

            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdcategorias());

            int n = pst.executeUpdate();

            if (n != 0) {
                cn.close();
                return true;
            }
            cn.close();
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public boolean editar(vcategoria dts) {
        SQL = " update categorias set categoria=upper(?), estado=? "
                + " where idcategorias=?";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getCategoria());

            pst.setString(2, "ACTIVO");
            pst.setInt(3, dts.getIdcategorias());
            int n = pst.executeUpdate();
            if (n != 0) {
                cn.close();
                return true;
            } else {
                cn.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
