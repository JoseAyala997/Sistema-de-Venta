/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.valimentos;
import Datos.vcategoria;
import Datos.vproductos;
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
        String[] titulos = {"ID", "CATEGORIA","ESTADO"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "SELECT idcategorias,categoria,estado FROM categorias where categoria like '%" + buscar + "%'  and estado = 'ACTIVO'  order by idcategorias desc";
        TotalRegistros = 0;
//        ValorTotal = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idcategorias");
                registro[1] = rs.getString("categoria");
                registro[2] = rs.getString("estado");
              
                

                TotalRegistros = TotalRegistros + 1;

//                ValorTotal = ValorTotal + (Integer.parseInt(registro[2]) * Integer.parseInt(registro[4]));

                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    /*Funcion para controlar el stock por esta forma..tambien llamando en frmVista en la hora de seleccionar el producto*/

       
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


    public boolean insertar(vcategoria dts) {
        SQL = "INSERT INTO categorias (categoria, estado)"
                + " values (upper(?),?)";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getCategoria());
         
            pst.setString(2, "ACTIVO");
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

    public boolean eliminar(vcategoria dts) {
        SQL = "UPDATE categorias set estado=? \n"
                + "where idcategorias=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdcategorias());

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

    public boolean editar(vcategoria dts) {
        SQL = " update categorias set categoria=upper(?), estado=? "
                + " where idcategorias=?";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, dts.getCategoria());
          
            pst.setString(2, "ACTIVO");
            pst.setInt(3, dts.getIdcategorias());
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
