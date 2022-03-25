package Logica;

import Datos.valimentos;
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
public class falimento {

    private Conexion mysql = new Conexion();
    //Se crea una instancia "mysql" del tipo Coneccion.
    private Connection cn = mysql.conectar();
    /*Se crea un objeto "cn" del tipo Connection en el l 
    se almacena los valores devueltos por el método "myslq.conectar"*/
    private String sSql;

    public int totalRegistro;

    public DefaultTableModel mostrar_plantilla(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        String[] titulos = {"ID", "ID Alimento", "TIPO", "OBSERVACION", "PERIODO", "DIAS", "N ALIMENTO", "CANTIDAD", "CALORIAS", "PROTEINAS", "VITAMINAS", "MINERALES", "ESTADO", "TOTAL CAL."};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[14];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "  select  co.idcomida,a.idalimento,co.tipo,co.observacion,co.periodo,co.dias, a.nombre_alimento, a.cantidad, a.calorias, "
                + "a.proteinas, a.vitaminas, a.minerales,a.estado,co.caloriastotales \n"
                + "from alimento a inner join comidas co on a.idalimento=co.idalimento\n"
                + "where  (co.tipo like '%" + buscar + "%' or co.dias like '%" + buscar + "%')\n"
                + "and co.estado='ACTIVO' order by idcomida desc limit 100";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos

                registro[0] = rs.getString("idcomida");
                registro[1] = rs.getString("idalimento");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("observacion");
                registro[4] = rs.getString("periodo");
                registro[5] = rs.getString("dias");
                registro[6] = rs.getString("nombre_alimento");
                registro[7] = rs.getString("cantidad");
                registro[8] = rs.getString("calorias");
                registro[9] = rs.getString("proteinas");
                registro[10] = rs.getString("vitaminas");
                registro[11] = rs.getString("minerales");
                registro[12] = rs.getString("estado");
                registro[13] = rs.getString("caloriastotales");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrar_dieta(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        String[] titulos = {"PACIENTE", "NUTRICIONISTA", "COMENTARIO", "DIAS", "COMIDA", "PERIODO", "CANTIDAD", "CALORIAS"};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[8];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select  CONCAT(p.nombre, ' ', p.apellido)as paciente,concat(u.nombre, ' ' ,u.apellido)as Nutricionista,\n"
                + "d.comentario,co.dias, a.nombre_alimento,co.periodo, a.cantidad, a.calorias\n"
                + "from alimento a inner join comidas co on a.idalimento=co.idalimento\n"
                + "inner join dieta d on co.idcomida=d.idcomida\n"
                + "inner join persona p on p.idpersona=d.idpaciente\n"
                + "inner join persona u on u.idpersona=d.idusuarios\n"
                + "where d.estado='ACTIVO' AND concat(p.nombre, ' ', p.apellido) like '%%'\n"
                + "order by co.idcomida desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
               
                registro[0] = rs.getString("paciente");
                registro[1] = rs.getString("Nutricionista");
                registro[2] = rs.getString("comentario");
                registro[3] = rs.getString("dias");
                registro[4] = rs.getString("nombre_alimento");
                registro[5] = rs.getString("periodo");
                registro[6] = rs.getString("cantidad");
                registro[7] = rs.getString("calorias");
         

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrar(String buscar) {
        //Se crea un método para establecer el modelo del jTable
        DefaultTableModel modelo;

        String[] titulos = {"ID", "N ALIMENTO", "CANTIDAD", "CALORIAS", "PROTEINAS", "VITAMINAS", "MINERALES",};
        /*Se declara un array del tipo String para los titulos de la 
    colomna de la tabla paises*/
        String[] registro = new String[8];
        /* Se declara un array de tipo String de 3 elementos donde se 
    insertara                              n los registros*/
        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "  select idalimento, nombre_alimento, cantidad, calorias, proteinas, vitaminas, minerales,estado "
                + "from alimento where (idalimento like '%" + buscar + "%' or nombre_alimento like '%" + buscar + "%')"
                + "and estado='ACTIVO' order by idalimento desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {//Mueve el cursor a la siguente fila hacia abajo para recorrer los campos
                registro[0] = rs.getString("idalimento");
                registro[1] = rs.getString("nombre_alimento");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("calorias");
                registro[4] = rs.getString("proteinas");
                registro[5] = rs.getString("vitaminas");
                registro[6] = rs.getString("minerales");
                registro[7] = rs.getString("estado");

                totalRegistro = totalRegistro + 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertar(valimentos dts) {

        sSql = "INSERT INTO alimento( nombre_alimento, cantidad, calorias, proteinas, vitaminas, minerales, estado) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */
            pst.setString(1, dts.getNombre_alimento());
            pst.setDouble(2, dts.getCantidad());
            pst.setInt(3, dts.getCalorias());
            pst.setDouble(4, dts.getProteinas());
            pst.setDouble(5, dts.getVitaminas());
            pst.setDouble(6, dts.getMinerales());
            pst.setString(7, "ACTIVO");

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

    public boolean editar(valimentos dts) {
        sSql = "UPDATE alimento set nombre_alimento=?, cantidad=?, calorias=?, proteinas=?, vitaminas=?, minerales=?, estado=? \n"
                + "where idalimento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, dts.getNombre_alimento());
            pst.setDouble(2, dts.getCantidad());
            pst.setInt(3, dts.getCalorias());
            pst.setDouble(4, dts.getProteinas());
            pst.setDouble(5, dts.getVitaminas());
            pst.setDouble(6, dts.getMinerales());
            pst.setString(7, "ACTIVO");
            pst.setInt(8, dts.getIdalimento());

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

    public boolean eliminar(valimentos dts) {
        sSql = "UPDATE alimento set estado=? \n"
                + "where idalimento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setString(1, "INACTIVO");
            pst.setInt(2, dts.getIdalimento());

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
