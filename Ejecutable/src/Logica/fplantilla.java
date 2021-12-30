/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.valimentos;
import Datos.vcomidas;
import Datos.vplantilla;
import Datos.vreserva;
import static Logica.fmovimiento_caja.jose;
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
public class fplantilla {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String SQL = "";
    private String sSQL2 = "";
    public int totalRegistro;
    public static int ultimo;
    
    public void ultimo_id() {
    
        sSQL = "select max(idplantilla)as id from plantilla ";
      
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

    
    public boolean insertarplantilla(vplantilla dts) {
 
        sSQL = "INSERT INTO plantilla(tipo, observacion, idcomida)"
                + " values (?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, dts.getTipo());
            pst.setString(2, dts.getObservacion());
            pst.setInt(3, dts.getIdcomida());
            
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
    
    public boolean insertar_idcomida(vplantilla dts) {
        ultimo_id();
        sSQL = "update plantilla set tipo=?,observacion=? where idplantilla=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, dts.getTipo());
            pst.setString(2, dts.getObservacion());
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

}
