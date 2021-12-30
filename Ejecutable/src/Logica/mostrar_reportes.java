/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class mostrar_reportes {

    public static String SQL = "";
    public static Conexion mysql = new Conexion();
    public static Connection cn = mysql.conectar();

    public int TotalRegistros;
    public int ValorTotal;

    public static Statement st;
    public static ResultSet rs;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "N. Documento", "Nombre", "Telefono", "Acceso","Login","Contraseña","Direccion"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        SQL = "select c.idusuarios,p.numDocumento,p.nombre,p.telefono,c.acceso,c.login,c.password,p.direccion,c.estado\n"
                + "from usuarios c inner join persona p on c.idusuarios=p.idpersona where p.nombre LIKE '%"+buscar+"%'or p.numDocumento LIKE '%" + buscar + "%'\n"
                + " and c.estado='ACTIVO'  order by p.idpersona desc";
        TotalRegistros = 0;
        ValorTotal = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                registro[0] = rs.getString("idusuarios");
                registro[1] = rs.getString("numDocumento");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("direccion");

                TotalRegistros = TotalRegistros + 1;


                modelo.addRow(registro);

            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
