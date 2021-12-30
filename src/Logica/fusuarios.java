/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpacientes;
import Datos.vpersona;
import Datos.vusuarios;
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
public class fusuarios {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public String ACCESO = "";
    public String NOMBRE = "";
    public String APELLIDO = "";
    private int cod_usuarios;
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Nombre", "Apellido", "N Documento", "Telefono", "Direccion", "Genero", "Acceso", "Login", "Contraseña"};
        String[] registro = new String[10];
        totalregistros = 0;
        try {
            Statement st = cn.createStatement();

            modelo = new DefaultTableModel(null, titulos);
            sSQL = "Select p.idpersona,p.nombre,p.apellido,p.numDocumento,p.telefono,p.direccion,p.genero,u.acceso,u.login,u.password "
                    + "from persona p inner join usuarios u on p.idpersona=u.idusuarios where numDocumento like '%" + buscar + "%' and p.estado='ACTIVO'"
                    + "order by idpersona desc";

            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("numDocumento");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("genero");
                //registro[7] = rs.getString("estado");
                registro[7] = rs.getString("acceso");
                registro[8] = rs.getString("login");
                registro[9] = rs.getString("password");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vusuarios dts) {
        sSQL = "insert into persona ( nombre, apellido, numDocumento, telefono,direccion, genero,estado) "
                + "values(?,?,?,?,?,?,?)";
        sSQL2 = "insert into usuarios (idusuarios,acceso,login,password,estado)"
                + "values((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getNumDocumento());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getGenero());
            pst.setString(7, "ACTIVO");

            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, "ACTIVO");

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vusuarios dts) {
        sSQL = "update persona set nombre=?, apellido=?, numDocumento=?, telefono=?, direccion=?, genero=?"
                + "where idpersona=?";
        //"update paciente set idpaciente=? where idpersona=? ";

        sSQL2 = "update usuarios set acceso=?,login=?,password=? "
                + "where idusuarios=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getNumDocumento());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getGenero());
            //pst.setString(7, "ACTIVO");
            pst.setInt(7, dts.getIdpersona());

            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            //pst2.setString(4, "ACTIVO");
            pst2.setInt(4, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(vusuarios dts) {
        sSQL = "update persona set estado=?"
                + "where idpersona=? ";
        // "delete from usuarios where idusuarios=?";
        sSQL2 = "update usuarios set estado=? "
                + "where idusuarios=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdusuarios());

            pst2.setString(1, "INACTIVO");
            pst2.setInt(2, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellido","Documento", "Acceso", "Login", "Clave", "Estado"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select u.idusuarios,p.nombre,p.apellido,p.numDocumento, u.acceso,u.login,u.password,u.estado from usuarios u \n"
                + "inner join persona p on u.idusuarios = p.idpersona  where login = '" + login + "' and password = '" + password + "' \n"
                + "and u.estado = 'ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idusuarios");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("numDocumento");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

// public int login1(String user,String pass) {
//
//        sSQL = "select u.idusuarios,u.acceso,concat(p.nombre, ' ',apellido) as nombres from usuarios u "
//                + "inner join persona p on u.idusuarios = p.idpersona"
//                + " where login = '"+user+"' and password = '"+pass+"' and u.estado = 'ACTIVO' ";
//        cod_usuarios=0;
//        ACCESO ="";
//        NOMBRE ="";
//        try {
//               Statement st = cn.createStatement();
//                  ResultSet rs = st.executeQuery(sSQL);
//                  
//                  while (rs.next()) {
//                      cod_usuarios = rs.getInt("idusuarios");
//                      ACCESO = rs.getString("acceso");
//                      NOMBRE = rs.getString("nombres");
//                      
//                  }
//                  return cod_usuarios;
//                  
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            return 0;
//        }
//    
//        
//        
//    }
}
