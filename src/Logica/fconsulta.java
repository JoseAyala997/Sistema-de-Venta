/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vconsulta_seguimiento;
import Datos.vreserva;
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
public class fconsulta {

    private Conexion mysql = new Conexion();
    //Se crea una instancia "mysql" del tipo Coneccion.
    private Connection cn = mysql.conectar();
    /*Se crea un objeto "cn" del tipo Connection en el l 
    se almacena los valores devueltos por el método "myslq.conectar"*/
    private String sSql;
    public int totalRegistro;

    //mostrar turnos activos
    public DefaultTableModel mostrar_turno(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"ID Pac", "Paciente", "ID Usu", "Id Reserva", "Fecha Consulta", "Hora Consulta", "Tipo consulta", "Num. Turno", "Estado"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[9];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select r.idpaciente, concat (u.nombre,' ',u.apellido)as paciente, r.idusuarios,\n"
                + "              r.idreserva,r.fechaconsulta,\n"
                + "              r.horaconsulta,r.tipo_consulta,r.num_turno, r.estado from reserva r \n"
                + "               inner join persona u on u.idpersona=r.idpaciente\n"
                + "\n"
                + "               where r.num_turno like '%" + buscar + "%' and r.estado='ACTIVO' ORDER BY idreserva LIMIT 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                registro[0] = rs.getString("idpaciente");
                registro[1] = rs.getString("Paciente");
                registro[2] = rs.getString("idusuarios");
                registro[3] = rs.getString("idreserva");
                registro[4] = rs.getString("fechaconsulta");
                registro[5] = rs.getString("horaconsulta");
                registro[6] = rs.getString("tipo_consulta");
                registro[7] = rs.getString("num_turno");
                registro[8] = rs.getString("estado");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro); 
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    //mostrar turnos inactivos
    public DefaultTableModel mostrar_turno_inactivo(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"ID Pac", "Paciente", "ID Usu", "Id Reserva", "Fecha Consulta", "Hora Consulta", "Tipo consulta", "Num. Turno", "Estado"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[9];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select r.idpaciente, concat (u.nombre,' ',u.apellido)as paciente, r.idusuarios,\n"
                + "              r.idreserva,r.fechaconsulta,\n"
                + "              r.horaconsulta,r.tipo_consulta,r.num_turno, r.estado from reserva r \n"
                + "               inner join persona u on u.idpersona=r.idpaciente\n"
                + "\n"
                + "               where r.num_turno like '%" + buscar + "%' and r.estado='INACTIVO' ORDER BY idreserva LIMIT 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                registro[0] = rs.getString("idpaciente");
                registro[1] = rs.getString("Paciente");
                registro[2] = rs.getString("idusuarios");
                registro[3] = rs.getString("idreserva");
                registro[4] = rs.getString("fechaconsulta");
                registro[5] = rs.getString("horaconsulta");
                registro[6] = rs.getString("tipo_consulta");
                registro[7] = rs.getString("num_turno");
                registro[8] = rs.getString("estado");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    

    public boolean insertar_consulta(vconsulta_seguimiento dts) {

        sSql = "INSERT INTO consulta (observacion, fecha_prox,"
                + " idreserva, peso_inicial, recomendaciones, estado, idusuarios) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
            idreserva, idusuarios, idpaciente, fechaconsulta, horaconsulta, tipo_consulta, estado
             */
            pst.setString(1, dts.getObservacion());
            pst.setDate(2, dts.getFecha_prox());

            pst.setInt(3, dts.getIdreserva());
            pst.setInt(4, dts.getPeso_inicial());
            pst.setString(5, dts.getRecomendaciones());
            pst.setString(6, "ATENDIDO");
            pst.setInt(7, dts.getIdusuarios());

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
//        try {
//            PreparedStatement pst = cn.prepareStatement(sSql);
//            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
//         en la base de datos mediante insert into
//            idreserva, idusuarios, idpaciente, fechaconsulta, horaconsulta, tipo_consulta, estado
//             */
//            pst.setString(1, dts.getObservacion());
//            pst.setDate(2, dts.getFecha_prox());
//            pst.setInt(3, dts.getIdpaciente());
//        
//            pst.setInt(4, dts.getIdreserva());
//            pst.setInt(5, dts.getPeso_inicial());
//            pst.setString(6,dts.getRecomendaciones());
//            pst.setString(7,"ATENDIDO");
//            pst.setInt(8,dts.getIdusuarios());
//            
//
//            int n = pst.executeUpdate();
//
//            if (n != 0) {
//
//                return true;
//
//            }
//
//            return false;
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
//            return false;
//        }
//    }

    public boolean editar(vconsulta_seguimiento dts) {
        sSql = "UPDATE consulta set observacion=?, fecha_prox=?,"
                + " idreserva=?, peso_inicial=?, recomendaciones=?, estado=?, idusuarios=?\n"
                + "where idconsulta=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, dts.getObservacion());
            pst.setDate(2, dts.getFecha_prox());
            pst.setInt(3, dts.getIdreserva());
            pst.setInt(4, dts.getPeso_inicial());
            pst.setString(5, dts.getRecomendaciones());
            pst.setString(6, "ATENDIDO");
            pst.setInt(7, dts.getIdusuarios());

            pst.setInt(8, dts.getIdconsulta());

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

    public boolean eliminar(vreserva dts) {
        sSql = "UPDATE reserva set estado=? \n"
                + "where idreserva=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdreserva());

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

}
