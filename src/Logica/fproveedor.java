/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vproductos;
import Datos.vproveedor;
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
public class fproveedor {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "NOMBRE", "TELEFONO", "DIRECCION", "PRECIO MAYOR", "RUC", "STOCK", "RAZON SOCIAL"};
        String[] registro = new String[11];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT p.idservicios, p.nombre_producto,p.descripcion,p.precio_unitario,p.precio_mayor,p.precio_costo,p.stock,p.pulgadas, c.idcategorias,c.categoria, p.cod_barra\n"
                + " FROM productos p inner join categorias c on p.idcategorias=c.idcategorias\n"
                + "where (p.nombre_producto like '%" + buscar + "%' ||  p.cod_barra like '%" + buscar + "%') and p.estado = 'ACTIVO'  order by p.idservicios desc";

        TotalRegistros = 0;
        ValorTotal = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idservicios");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("precio_unitario");
                registro[4] = rs.getString("precio_mayor");
                registro[5] = rs.getString("precio_costo");
                registro[6] = rs.getString("stock");
                registro[7] = rs.getString("pulgadas");
                registro[8] = rs.getString("idcategorias");
                registro[9] = rs.getString("categoria");

                TotalRegistros = TotalRegistros + 1;

                ValorTotal = ValorTotal + (Integer.parseInt(registro[3]) * Integer.parseInt(registro[6]));

                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    
    public boolean insertar(vproveedor dts) {
        SQL = "INSERT INTO proveedor (nombre, telefono, direccion,ruc,razon,estado)"
                + " values (upper(?),?,upper(?),?,upper(?),?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getRuc());
            pst.setString(5, dts.getRazon());
            pst.setString(6, "ACTIVO");
  
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

    public boolean eliminar(vproveedor dts) {
        SQL = "UPDATE proveedor set estado=? \n"
                + "where idproveedor=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdproveedor());

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

    public boolean editar(vproveedor dts) {
        SQL = " update proveedor set  nombre=upper(?), telefono=?, direccion=upper(?),ruc=?,razon=upper(?),estado=? "
                + "where idservicios=?";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getRuc());
            pst.setString(5, dts.getRazon());
            pst.setString(6, "ACTIVO");

            
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
