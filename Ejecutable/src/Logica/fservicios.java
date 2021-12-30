/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.valimentos;
import Datos.vservicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Torres
 */
public class fservicios {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;
    
    public static Statement st;
    public static ResultSet rs;
    

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "SERVICIO", "PRECIO", "UNID-MEDIDA", "STOCK"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT idservicios,nombre_servicio,precio,unidad,stock \n" +
"                FROM servicios where (nombre_servicio like '%" + buscar + "%' ||  idservicios like '%" + buscar + "%' \n" +
"                  || precio  like '%" + buscar + "%') and estado = 'ACTIVO'  order by idservicios desc";
        TotalRegistros = 0;
        ValorTotal = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idservicios");
                registro[1] = rs.getString("nombre_servicio");
                registro[2] = rs.getString("precio");
                registro[3] = rs.getString("unidad");
                registro[4] = rs.getString("stock");
                

                TotalRegistros = TotalRegistros + 1;

                ValorTotal = ValorTotal + (Integer.parseInt(registro[2]) * Integer.parseInt(registro[4]));

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
     
        SQL = "SELECT stock FROM servicios where idservicios='"+codigo+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                cantidadproducto=rs.getInt("stock");
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


    public boolean insertar(vservicios dts) {
        SQL = "INSERT INTO servicios (nombre_servicio, precio, unidad, stock, estado)"
                + " values (upper(?),?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre_servicio());
            pst.setLong(2, dts.getPrecio());
            pst.setString(3, dts.getUnidad());
            pst.setDouble(4, dts.getStock());
            pst.setString(5, "ACTIVO");
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

    public boolean eliminar(vservicios dts) {
        SQL = "UPDATE servicios set estado=? \n"
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

    public boolean editar(vservicios dts) {
        SQL = " update servicios set nombre_servicio=?, precio=?, unidad=?, stock=?, estado=? "
                + " where idservicios=?";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getNombre_servicio());
            pst.setLong(2, dts.getPrecio());
            pst.setString(3,dts.getUnidad());
            pst.setDouble(4, dts.getStock());
            pst.setString(5, "ACTIVO");
            pst.setInt(6, dts.getIdservicios());
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
        SQL = " update servicios set stock=stock-'"+cantidad+"' "
                + " where idservicios='"+idservicios+"'";

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
