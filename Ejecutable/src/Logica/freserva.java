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

    private Conexion mysql = new Conexion();
    //Se crea una instancia "mysql" del tipo Coneccion.
    private Connection cn = mysql.conectar();
    /*Se crea un objeto "cn" del tipo Connection en el l 
    se almacena los valores devueltos por el método "myslq.conectar"*/
    private String sSql;
    public int totalRegistro;

    public DefaultTableModel mostrar(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id Usuario", "Id Paciente", "Paciente", "Nutricionista",
            "Fecha Consulta", "Hora Consulta", "Tipo consulta"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[9];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT r.idreserva, r.idusuarios,r.idpaciente,(select concat(nombre,' ',apellido)\n"
                + "from persona where idpersona=r.idpaciente) as Paciente,\n"
                + "(Select concat(nombre,' ',apellido) from persona where idpersona=r.idusuarios) as Usuarios,\n"
                + "r.fechaconsulta,r.horaconsulta,r.tipo_consulta, r.estado\n"
                + "from reserva r  where r.estado='ACTIVO'";

        
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

    public boolean insertar(vreserva dts) {

        sSql = "INSERT INTO reserva ( idusuarios,idpaciente,fechaconsulta, horaconsulta, tipo_consulta, estado) values(?,?,?,?,?,?)";
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
            pst.setString(6, "ACTIVO");
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
