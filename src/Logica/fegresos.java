/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdeudas;
import Datos.vegresos;
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
public class fegresos {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();
    public static String id_deuda;

    public int TotalRegistros;
    public int totalpagado;
    public int totaldeuda;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "DESCRIPCION", "MONTO", "FECHA", "HORA", "ESTADO", "ID MOV."};
        String[] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT idegresos, descripcion, monto,fecha,hora, estado, idmovimiento from egresos \n"
                + "where (descripcion like '%" + buscar + "%' or fecha like '%" + buscar + "%') and estado='INGRESO' OR estado='EGRESO' order by idegresos desc";

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

    public DefaultTableModel mostrarIE(String inicio, String fin, String estado) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "DESCRIPCION", "MONTO", "FECHA", "HORA", "ESTADO", "ID MOV."};
        String[] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT idegresos, descripcion, monto,fecha,hora, estado, idmovimiento from egresos \n"
                + "WHERE fecha BETWEEN '" + inicio + "' AND '" + fin + "' AND estado='" + estado + "' order by idegresos desc";

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

    public DefaultTableModel mostrarIE_Resumen(String inicio, String fin) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "DESCRIPCION", "MONTO", "FECHA", "HORA", "ESTADO"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "select idegresos,descripcion,sum(monto)as total,fecha,hora, estado FROM egresos where \n"
                + "fecha BETWEEN '" + inicio + "' AND '" + fin + "' and (estado ='INGRESO'|| estado='EGRESO') group by descripcion order by idegresos desc";

        TotalRegistros = 0;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idegresos");
                registro[1] = rs.getString("descripcion");
                registro[2] = rs.getString("total");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("hora");
                registro[5] = rs.getString("estado");

                TotalRegistros = TotalRegistros + 1;

                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrar_deudores(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID VENTA", "PRODUCTO", "CANT.", "PRECIO", "PULGADAS", "ESTADO", "TIPO", "DEUDA", "TOTAL PAGADO"};
        String[] registro = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT v.idventa,p.nombre_producto,d.cantidad,d.precio,d.pulgadas,v.estado,v.tipo,pe.numDocumento,v.saldo,v.total from detalle_venta d\n"
                + "inner join venta v on v.idventa=d.idventa\n"
                + "inner join persona pe on v.idpaciente=pe.idpersona\n"
                + "inner join productos p on p.idservicios=d.idservicios where pe.numDocumento='" + buscar + "' and v.estado='PENDIENTE' and v.tipo='CREDITO'";

        TotalRegistros = 0;
        totaldeuda = 0;
        totalpagado = 0;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("precio");
                registro[4] = rs.getString("pulgadas");
                registro[5] = rs.getString("estado");
                registro[6] = rs.getString("tipo");
                registro[7] = rs.getString("saldo");
                registro[8] = rs.getString("total");

                TotalRegistros = TotalRegistros + 1;
//                totaldeuda = totaldeuda + (Integer.parseInt(registro[7]));
//                totalpagado = totalpagado + (Integer.parseInt(registro[8]));
                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrar_deudas(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "CLIENTE", "NUM. DOC.", "ESTADO", "TIPO"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "select v.idventa, concat(p.nombre,' ',p.apellido)as nombre,p.numDocumento,v.estado,v.tipo from venta v\n"
                + "inner join persona p on p.idpersona=v.idpaciente where (p.numDocumento like '%" + buscar + "%' \n"
                + "or concat(p.nombre,' ',p.apellido) like '%" + buscar + "%') and v.estado='PENDIENTE' group by nombre";

        TotalRegistros = 0;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("numDocumento");
                registro[3] = rs.getString("estado");
                registro[4] = rs.getString("tipo");

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
            pst.setString(5, dts.getEstado());
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
            pst.setString(5, dts.getEstado());
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

    public void id_cliente(String buscar) {

        SQL = "select idcliente,iddeuda from deudas where idcliente='%" + buscar + "%' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                id_deuda = rs.getString("iddeuda");
                System.out.println("ID= " + id_deuda);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }

    public boolean insertarDeuda(vdeudas dts) {
        SQL = "INSERT INTO deudas (idcliente,total_deuda,estado)"
                + "values (?,'0','SIN DEUDA')";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, dts.getIdcliente());
//            pst.setLong(2, dts.getTotal_deuda());
//            pst.setString(3, dts.getEstado());

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

    public boolean editarDeuda(vdeudas dts) {
        SQL = " update deudas set total_deuda=?, estado=? where idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setLong(1, dts.getTotal_deuda());
            pst.setString(2, dts.getEstado());

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
