/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdetalle_venta;
import Datos.vventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUMNO
 */
public class fventa {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();
    DecimalFormat formatear = new DecimalFormat();

    public boolean insertarVentas(vventas dts) {
        SQL = "INSERT INTO venta (idusuarios, idpaciente, total, fecha, nro_factura, tipo, estado,idmovimiento,descuento,saldo)"
                + " values (?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdpaciente());
            pst.setLong(3, dts.getTotal());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getNro_factura());
            pst.setString(6, dts.getTipo());
            pst.setString(7, dts.getEstado());
            pst.setInt(8, dts.getIdmovimiento());
            pst.setLong(9, dts.getDescuento());
            pst.setLong(10, dts.getSaldo());

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

    public boolean insertarDetalle(vdetalle_venta dts) {
        SQL = "INSERT INTO detalle_venta (idventa, idservicios, cantidad, precio, sub_total,pulgadas)"
                + "values ((select idventa from venta order by idventa desc limit 1 ),?,?,?,?,?)";

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

        int NroFactura = 0;
        SQL = "SELECT (count(*) + 1) contador FROM venta;";

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

    public boolean editar(vventas dts) {
        SQL = " update venta set total=?, estado=?, saldo=? where idventa=?";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setLong(1, dts.getTotal());
            pst.setString(2, dts.getEstado());
            pst.setLong(3, dts.getSaldo());
            pst.setInt(4, dts.getIdventa());

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

    public boolean editar_deudas(vventas dts) {
        SQL = " update venta set total=?, estado=?, saldo=?,idmovimiento=? where idventa=?";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setLong(1, dts.getTotal());
            pst.setString(2, dts.getEstado());
            pst.setLong(3, dts.getSaldo());
            pst.setInt(4, dts.getIdmovimiento());
            pst.setInt(5, dts.getIdventa());

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

    public DefaultTableModel mostrarcaja(String buscar, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDVENTA", "ID PRO.","ID MOV", "FECHA", "PRODUCTO", "PRECIO.", "CANTIDAD", "NUM. FACTURA", "TOTAL", "FUNCIONARIO", "CLIENTE", "EGRESOS"};
        String[] registro = new String[11];

        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,d.idservicios,v.idmovimiento,v.fecha, (SELECT nombre_producto FROM productos s WHERE s.idservicios = d.idservicios)as producto,\n"
                + " d.precio,d.cantidad,v.nro_factura,total, CONCAT(p.nombre, ' ', p.apellido)as cliente,concat(u.nombre, ' ', u.apellido)as usuario\n"
                + " FROM detalle_venta d INNER JOIN venta v ON d.idventa = v.idventa\n"
                + " inner join persona p on p.idpersona=v.idpaciente\n"
                + " inner join persona u on u.idpersona=v.idusuarios\n"
                + " WHERE v.nro_factura= '" + buscar + "' order by v.idventa desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("idservicios");
                
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                registro[10] = rs.getString("egresos");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }
    }

}
