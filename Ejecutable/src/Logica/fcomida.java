/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.valimentos;
import Datos.vcomidas;
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
public class fcomida {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSql="";
    public int totalRegistro;
    public int ultimo;
    private String SQL;
    
    public DefaultTableModel mostrar_plantilla(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;
modelo = new DefaultTableModel();
        String[] titulos = {"ID", "ID Alimento","TIPO","OBSERVACION","PERIODO","DIAS", "N ALIMENTO", "CANTIDAD", "CALORIAS", "PROTEINAS", "VITAMINAS", "MINERALES","ESTADO", "TOTAL CAL."};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[14];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "  select  co.idcomida,a.idalimento,co.periodo,co.dias, a.nombre_alimento, a.cantidad, a.calorias, "
                + "a.proteinas, a.vitaminas, a.minerales,a.estado,co.caloriastotales \n"
                + "from alimento a inner join comidas co on a.idalimento=co.idalimento\n"
                + "where  (co.periodo like '%" + buscar + "%' or co.dias like '%" + buscar + "%')\n"
                + "and co.estado='ACTIVO' order by idcomida desc ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                
                registro[0] = rs.getString("idcomida");
                registro[1] = rs.getString("idalimento");
                registro[2] = rs.getString("periodo");
                registro[3] = rs.getString("dias");
                registro[4] = rs.getString("nombre_alimento");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("calorias");
                registro[7] = rs.getString("proteinas");
                registro[8] = rs.getString("vitaminas");
                registro[9] = rs.getString("minerales");
                registro[10] = rs.getString("estado");
                registro[11] = rs.getString("caloriastotales");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void insertar_id() {

      sSQL = "select max(idcomida)as id from comidas ";
      
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

    public boolean insertarplantilla(vcomidas dts) {
        insertar_id();
        sSQL = "INSERT INTO comidas( tipo, observacion, periodo, dias, caloriastotales, estado, idalimento)"
                + " values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */
             pst.setString(1, dts.getTipo());
              pst.setString(2, dts.getObservacion());
            pst.setString(3, dts.getPeriodo());
            pst.setString(4, dts.getDias());
            pst.setInt(5, dts.getCaloriastotales());
            pst.setString(6, "ACTIVO");
            pst.setInt(7, dts.getIdalimento());

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
