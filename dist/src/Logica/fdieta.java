/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.valimentos;
import Datos.vdieta;
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
public class fdieta {

    private Conexion mysql = new Conexion();
    //Se crea una instancia "mysql" del tipo Coneccion.
    private Connection cn = mysql.conectar();
    /*Se crea un objeto "cn" del tipo Connection en el l 
    se almacena los valores devueltos por el método "myslq.conectar"*/
    private String sSql;
    private String sSQL;
    public int totalRegistro;
    public  int ultimo;
    
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
          modelo.addColumn("DIA");
        modelo.addColumn("PERIODO");
        modelo.addColumn("IDALIMENTO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("CALORIAS");
        modelo.addColumn("PROTEINAS");
        modelo.addColumn("VITAMINAS");
        modelo.addColumn("MINERALES");

        sSql = "SELECT c.dia, c.periodo,a.idalimento,a.nombre,a.cantidad,a.calorias,a.proteinas,a.vitaminas,a.minerales"
                + "from alimento a inner join comidas c on a.idalimento=c.idalimento where nombre_alimento"
                + " like '%"+ buscar +"%' and a.estado= 'ACTIVO' order by idalimento desc";

                

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


   
    public boolean insertar_dieta(vdieta dts) {

        sSql = "INSERT INTO dieta(idusuarios, idcomida, idpaciente, comentario, fecha_registro, estado) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */
            pst.setInt(1, dts.getIdusuarios());
            pst.setInt(2, dts.getIdcomida());
              pst.setInt(3, dts.getIdpaciente());
            pst.setString(4, dts.getComentario());
            pst.setDate(5, dts.getFecha_registro());
         
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
     public boolean insertar_idcomida(vdieta dts) {
        ultimo_id();
        sSQL = "update dieta set fecha_registro=?,comentario=? where iddieta=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setDate(1, dts.getFecha_registro());
            pst.setString(2, dts.getComentario());
            pst.setInt(3, ultimo);
            
            
            System.out.println("hola"+ pst);
            
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
     
     public void ultimo_id() {
    
        sSQL = "select max(iddieta)as id from dieta ";
      
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
              ultimo = rs.getInt("id");
                System.out.println("hola" + ultimo);

            }
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
      
    }



}
