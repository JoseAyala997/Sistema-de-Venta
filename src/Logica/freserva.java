/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class freserva {

    public static int fecha_menor1;
    public static int fecha_mayor1;
    private Conexion mysql = new Conexion();
    //Se crea una instancia "mysql" del tipo Coneccion.
    private Connection cn = mysql.conectar();
    /*Se crea un objeto "cn" del tipo Connection en el l 
    se almacena los valores devueltos por el método "myslq.conectar"*/
    private String sSql;
    private String sSql2;
    public int totalRegistro;

    public DefaultTableModel mostrar(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id Usuario", "Id Paciente", "Paciente", "Nutricionista",
            "Fecha Consulta", "Hora Consulta", "Tipo consulta", "Turno", "estado"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[10];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT r.idreserva, r.idusuarios,r.idpaciente,(select concat(nombre,' ',apellido)\n"
                + "                from persona where idpersona=r.idpaciente) as Paciente,\n"
                + "                (Select concat(nombre,' ',apellido) from persona where idpersona=r.idusuarios) as Usuarios,\n"
                + "                r.fechaconsulta,r.horaconsulta,r.tipo_consulta, r.estado,r.num_turno\n"
                + "                from reserva r  where r.estado='ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                registro[0] = rs.getString("idreserva");
                registro[1] = rs.getString("idusuarios");
                registro[2] = rs.getString("idpaciente");
                registro[3] = rs.getString("Paciente");
                registro[4] = rs.getString("Usuarios");
                registro[5] = rs.getString("fechaconsulta");
                registro[6] = rs.getString("horaconsulta");
                registro[7] = rs.getString("tipo_consulta");
                registro[8] = rs.getString("num_turno");
                registro[9] = rs.getString("estado");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrar_turno(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"Paciente", "Nutricionista", "Id Reserva", "Observacion", "Peso Inicial", "Fecha Consulta", "Hora Consulta", "Tipo consulta", "P.Consulta", "Turno", "Recomendaciones"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[11];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select concat(p.nombre,' ',p.apellido) as paciente,concat(u.nombre,' ',u.apellido)as Nutricionista,\n"
                + "r.idreserva,c.observacion,c.peso_inicial,r.fechaconsulta,r.horaconsulta,r.tipo_consulta,c.fecha_prox ,r.num_turno,c.recomendaciones from consulta c\n"
                + "inner join reserva r on r.idreserva=c.idreserva \n"
                + "inner join persona p on p.idpersona=c.idpaciente\n"
                + "inner join persona u on u.idpersona=c.idusuarios\n"
                + "where r.estado='ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                registro[0] = rs.getString("paciente");
                registro[1] = rs.getString("Nutricionista");
                registro[2] = rs.getString("idreserva");
                registro[3] = rs.getString("Observacion");
                registro[4] = rs.getString("peso_inicial");
                registro[5] = rs.getString("fechaconsulta");
                registro[6] = rs.getString("horaconsulta");
                registro[7] = rs.getString("tipo_consulta");
                registro[8] = rs.getString("fecha_prox");
                registro[9] = rs.getString("num_turno");
                registro[10] = rs.getString("recomendaciones");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    //obtener fecha
    public int fecha_mayor() {

//        int fecha_men = 0;
        sSql = "SELECT *\n"
                + "FROM reserva\n"
                + "WHERE num_turno = (SELECT MAX(num_turno)\n"
                + "FROM reserva\n"
                + "WHERE num_turno < 2 and estado='INACTIVO')limit 1;";
//and fechaconsulta like '%" + buscar + "%'
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);
            while (rs.next()) {
                fecha_mayor1 = rs.getInt("num_turno");
                System.out.println("hola" + fecha_mayor1);

            }
            return fecha_mayor1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }
//obtener fecha

    public int fecha_menor() {

//        int fecha_men = 0;
        sSql = "SELECT * FROM reserva WHERE num_turno = (SELECT MIN(num_turno)FROM reserva\n"
                + "		WHERE num_turno > 2 and estado='ACTIVO') limit 1;";
//and fechaconsulta like '%" + buscar + "%'
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);
            while (rs.next()) {
                fecha_menor1 = rs.getInt("num_turno");
                System.out.println("hola" + fecha_menor1);

            }
            return fecha_menor1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }

    public boolean insertar(vreserva dts) {

        sSql = "INSERT INTO reserva ( idusuarios,idpaciente,fechaconsulta, horaconsulta, tipo_consulta, estado,num_turno) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
            idreserva, idusuarios, idpaciente, fechaconsulta, horaconsulta, tipo_consulta, estado
             */
            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdpaciente());
            pst.setDate(3, dts.getFechaconsulta());
            pst.setString(4, dts.getHoraconsulta());
            pst.setString(5, dts.getTipo_consulta());
            pst.setString(6, "ACTIVO");
            pst.setString(7, dts.getNum_turno());

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

    public boolean editar2(vreserva dts) {
        sSql = "UPDATE reserva set idusuarios=?, idpaciente=?,fechaconsulta=?, horaconsulta=?, tipo_consulta=?, estado=? \n"
                + "where idreserva=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdpaciente());
            pst.setDate(3, dts.getFechaconsulta());
            pst.setString(4, dts.getHoraconsulta());
            pst.setString(5, dts.getTipo_consulta());
            pst.setString(6, "INACTIVO");
            pst.setInt(7, dts.getIdreserva());

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

    public boolean editar(vreserva dts) {
        sSql = "UPDATE reserva set idusuarios=?, idpaciente=?, estado=? \n"
                + "where idreserva=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdpaciente());

            pst.setString(3, "INACTIVO");
            pst.setInt(4, dts.getIdreserva());

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

    public int turnos() {

        int turno = 0;
        sSql = "SELECT (count(*) + 1) contador FROM reserva;";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);
            while (rs.next()) {
                turno = rs.getInt("contador");

            }
            return turno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }

}
