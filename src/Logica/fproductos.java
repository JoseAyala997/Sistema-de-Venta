/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class fproductos {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRODUCTO", "DESCRIPCION", "PRECIO UNT.", "PRECIO MAYOR", "PRECIO COSTO", "STOCK", "PULGADAS", "IDCAT", "CATEGORIA"};
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
    /*Funcion para controlar el stock por esta forma..tambien llamando en frmVista en la hora de seleccionar el producto*/
    public static int cantidadproducto;

    public static void controlarStock(String codigo) {

        SQL = "SELECT stock FROM productos where idservicios='" + codigo + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                cantidadproducto = rs.getInt("stock");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /*funcion para determinar si es servicio o producto*/
    public static String categoria;

    public static void vercategoria(String cat) {

        SQL = "SELECT c.categoria from categorias c inner join productos p \n"
                + "on c.idcategorias = p.idcategorias where c.categoria= '" + cat + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                categoria = rs.getString("categoria");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*este metodo agregado abajo es para los codigos de barra y la lectura para la posterior venta*/
//    public static String idProductos,Codigo_Barra,Nombre,Proveedor,Unidad,Stock,Precio,Estado;
//    public static void mostrarobtenerproucto(String Codigo) {
//   
//        SQL = "SELECT idProductos,Codigo_Barra,Nombre_Descripcion,Proveedor,Unidad,Stock,Precio,Estado \n"
//                + "FROM productos where Estado='Activo' and Codigo_Barra='"+Codigo+"' limit 1";
//      
//        try {
//             st = cn.createStatement();
//             rs = st.executeQuery(SQL);
//             
//            while (rs.next()) {
//
//                idProductos = rs.getString("idProductos");
//                Codigo_Barra = rs.getString("Codigo_Barra");
//                Nombre = rs.getString("Nombre_Descripcion");
//                Proveedor = rs.getString("Proveedor");
//                Unidad = rs.getString("Unidad");
//                Stock = rs.getString("Stock");
//                Precio= rs.getString("Precio");
//                Estado = rs.getString("Estado");
//                System.err.println(rs);
//                
//            }
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            
//        }
//        
//    
//    }
    public boolean insertar(vproductos dts) {
        SQL = "INSERT INTO productos (nombre_producto, descripcion, precio_unitario, precio_mayor, precio_costo, stock, pulgadas, estado, idcategorias)"
                + " values (upper(?),upper(?),?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre_producto());
            pst.setString(2, dts.getDescripcion());
            pst.setLong(3, dts.getPrecio_unitario());
            pst.setLong(4, dts.getPrecio_mayor());
            pst.setLong(5, dts.getPrecio_costo());
            pst.setDouble(6, dts.getStock());

            pst.setDouble(7, dts.getPulgadas());
            pst.setString(8, "ACTIVO");
            pst.setInt(9, dts.getIdcategorias());
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

    public boolean eliminar(vproductos dts) {
        SQL = "UPDATE productos set estado=? \n"
                + "where idservicios=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdservicios());

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

    public boolean editar(vproductos dts) {
        SQL = " update productos set  nombre_producto=upper(?), descripcion=upper(?), precio_unitario=?, precio_mayor=?, precio_costo=?, stock=?, pulgadas=?, estado=?, idcategorias=? "
                + "where idservicios=?";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre_producto());
            pst.setString(2, dts.getDescripcion());
            pst.setLong(3, dts.getPrecio_unitario());
            pst.setLong(4, dts.getPrecio_mayor());
            pst.setLong(5, dts.getPrecio_costo());
            pst.setDouble(6, dts.getStock());

            pst.setDouble(7, dts.getPulgadas());
            pst.setString(8, "ACTIVO");
            pst.setInt(9, dts.getIdcategorias());
            pst.setInt(10, dts.getIdservicios());
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

    public boolean restarStock(double cantidad, int idservicios) {
        SQL = " update productos set stock=stock-'" + cantidad + "' "
                + " where idservicios='" + idservicios + "'";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);

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

    public boolean restarpulgadas(double pulgada, int idservicios) {
        SQL = " update productos set pulgadas=pulgadas-'" + pulgada + "' "
                + " where idservicios='" + idservicios + "'";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);

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
