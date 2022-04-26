/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vmovimiento_caja;
import Presentacion.frmprincipal;
import Presentacion.frmventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class fmovimiento_caja {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public static int ultimo_id;
    public static int ultimo_id_cj;
    public static String ultimo_idm;
    public static int ultimoMonto;
    public static int idm;
    DecimalFormat formatear = new DecimalFormat();
    public Integer totalregistros;

    public DefaultTableModel mostrarcaja(String buscar, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NRO CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC", "EGRESOS"};
        String[] registro = new String[11];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios,concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento , sum(e.monto)as egresos\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "join egresos e on cj.idmovimiento=e.idmovimiento where cj.estado='ACTIVO' and cj.idusuarios='" + buscar + "' order by cj.idmovimiento Desc";
        ;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
//                idm = rs.getInt("idmovimiento");
//                idm = rs.getInt("idmovimiento");
                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                registro[10] = rs.getString("egresos");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }
    }

    public DefaultTableModel mostrar(String buscar, String estado) {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NRO CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios,concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios \n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.estado='" + estado + "' and cj.idusuarios='" + buscar + "' order by cj.idmovimiento Desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }
    }

    public boolean cerraCaja(vmovimiento_caja dts) {
        sSQL = "update movimiento_caja set monto_cierre=?, fecha_cierre=?, estado=? "
                + " where idmovimiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, dts.getMonto_cierre());
            pst.setDate(2, dts.getFecha_cierre());
            pst.setString(3, dts.getEstado());
            pst.setInt(4, dts.getIdmovimiento());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error dddd: " + e);
            return false;
        }
    }

    public void mostrar_id() {

        sSQL = "select max(idmovimiento)as id from movimiento_caja ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id = rs.getInt("id");
//                System.out.println("hola" + jose);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }
       public void ultimo_cierre() {

        sSQL = "select max(idmovimiento)as id from movimiento_caja ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id = rs.getInt("id");
//                System.out.println("hola" + jose);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }

    public String[] obtenerdatos(String buscar) {

        String[] registro = new String[9];
        registro[0] = "";
        sSQL = "select cj.idmovimiento,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado,\n"
                + "cj.idusuarios, concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento \n"
                + "from movimiento_Caja cj \n"
                + "join usuarios em on em.idusuarios=cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.Estado='ACTIVO' and cj.idusuarios = '" + buscar + "'order by cj.idmovimiento Desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idmovimiento");
                registro[1] = formatear.format(rs.getLong("monto_apertura"));
                registro[2] = formatear.format(rs.getLong("monto_cierre"));
                registro[3] = rs.getString("fecha_apertura");
                registro[4] = rs.getString("fecha_cierre");
                registro[5] = rs.getString("idusuarios");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("funcionario");
                registro[8] = rs.getString("numDocumento");
            }

            return registro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 11111: " + e);
            return null;
        }
    }

    public DefaultTableModel mostraractivos() {
        DefaultTableModel modelo;

        String[] titulos = {"IDCAJA", "NUM CAJA", "MONTO APERTURA", "MONTO CIERRE", "FECHA APERT.", "FECHA CIERRE", "ESTADO", "IDPERSONA", "FUNCIONARIO", "DOC"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select cj.idmovimiento,cj.num_Caja,cj.monto_apertura,cj.monto_cierre,cj.fecha_apertura, cj.fecha_cierre, cj.estado, \n"
                + "cj.idusuarios, concat(p.nombre,' ',p.apellido) as funcionario,p.numDocumento\n"
                + "from movimiento_caja cj \n"
                + "join usuarios em on em.idusuarios = cj.idusuarios\n"
                + "join persona p on em.idusuarios=p.idpersona\n"
                + "where cj.estado='ACTIVO' order by cj.idmovimiento Desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idmovimiento");
                registro[1] = rs.getString("num_Caja");
                registro[2] = formatear.format(rs.getDouble("monto_apertura"));
                registro[3] = formatear.format(rs.getDouble("monto_cierre"));
                registro[4] = rs.getString("fecha_apertura");
                registro[5] = rs.getString("fecha_cierre");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("idusuarios");
                registro[8] = rs.getString("funcionario");
                registro[9] = rs.getString("numDocumento");
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: 1112" + e);
            return null;
        }
    }

    public boolean insertar(vmovimiento_caja dts) {
        sSQL = "insert into movimiento_caja (idusuarios,num_caja, fecha_apertura, fecha_cierre, monto_apertura, monto_cierre, estado)"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setString(2, dts.getNum_Caja());
            pst.setDate(3, dts.getFecha_apertura());
            pst.setDate(4, dts.getFecha_cierre());
            pst.setLong(5, dts.getMonto_apertura());
            pst.setLong(6, dts.getMonto_cierre());
            pst.setString(7, dts.getEstado());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error xxx: " + e);
            return false;
        }
    }

    public boolean Insertar_cierre(vmovimiento_caja dts) {
        mostrar_id();//se muestra el ultimo id registrado para actualizarlo
        sSQL = "UPDATE movimiento_caja set  fecha_cierre=?, cierre=?, estado=?\n"
                + "where idmovimiento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            /*Se crea un objeto "pst" del tipo preparadStatement(Prepara la consulta sql) para insertar los datos
         en la base de datos mediante insert into
             */

            pst.setDate(1, dts.getFecha_cierre());
            pst.setLong(2, dts.getMonto_cierre());
            pst.setString(3, "CERRADO");
            pst.setInt(4, ultimo_id);

            int n = pst.executeUpdate();
//              System.out.println(pst);
            if (n != 0) {

                return true;
            }

            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public boolean editar(vmovimiento_caja dts) {
        sSQL = "update movimiento_caja set idusuarios=?,fecha_apertura=?, fecha_cierre=?, monto_apertura=?, monto_cierre=?,  estado=?"
                + " where idmovimiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdusuarios());
            pst.setDate(2, dts.getFecha_apertura());
            pst.setDate(3, dts.getFecha_cierre());
            pst.setLong(4, dts.getMonto_apertura());
            pst.setLong(5, dts.getMonto_cierre());
            pst.setString(6, dts.getEstado());
            pst.setInt(7, dts.getIdmovimiento());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: xxx1" + e);
            return false;
        }
    }

    public Double mostraraprturacaja(String buscar) {
        Double t = 0.0;
        sSQL = "select monto_apertura "
                + "  from movimiento_caja "
                + " where idmovimiento='" + buscar + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("monto_apertura");
            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }
DecimalFormat format = new DecimalFormat("###,###.##");
    public Double mostrarTotalAcumuladoPagosVentas(String buscar) {
        Double t = 0.0;
        sSQL = "select total"
                + "  from venta "
                + " where idmovimiento='" + buscar + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("total");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }
 public Double ventashoy(String buscar) {
        int t = 0;
        sSQL = "select total"
                + "  from venta "
                + " where idmovimiento='" + buscar + "' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getInt("total");
                frmprincipal.txtcontado.setText(String.valueOf((format.format((int) t))));
//                frmprincipal.txthoy.setText(""+t);
                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        }
    }
  public Double cobradohoy(String buscar) {
        int t = 0;
        sSQL = "select sum(v.total)as cobrado from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
           Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getInt("cobrado");
                frmprincipal.txtpagado.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        }
    }
 public Double creditohoy(String buscar) {
        Double t = 0.0;

        sSQL = "select sum(v.saldo)as credito from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
       try {
           Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("credito");
                frmprincipal.txtcredito.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        }
    }
 
 
 public Double egresohoy(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT sum(monto)as egreso FROM egresos where estado='ACTIVO' AND idmovimiento='" + buscar + "' ";
       try {
           Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("egreso");
                frmprincipal.txtegresos.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        }
    }
 
 public Double aperturahoy(String buscar) {
        Double t = 0.0;

        sSQL = "SELECT monto_apertura FROM movimiento_caja where estado='ACTIVO'AND idmovimiento='" + buscar + "' ";
       try {
           Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("monto_apertura");
                frmprincipal.txtapertura.setText(format.format(t));
//                frmprincipal.txthoy.setText(""+t);
//                System.out.println(t);

            }
            return Double.parseDouble(String.valueOf(t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return Double.parseDouble(String.valueOf(t));
        }
    }
 
 
 
 
    public Double mostrarcredito(String buscar) {
        Double t = 0.0;

        sSQL = "select sum(v.saldo)as credito from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("credito");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }

    public Double mostrarcobrado(String buscar) {
        Double t = 0.0;
        sSQL = "select sum(v.total)as cobrado from venta v inner join movimiento_caja m where v.idmovimiento = m.idmovimiento "
                + "and v.tipo='CREDITO' and m.idmovimiento ='" + buscar + "' order by m.idmovimiento desc limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("cobrado");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }

    public int mostrarmovimiento(String buscar) {
        int t = 0;
        sSQL = "select max(m.idmovimiento)AS idmov from movimiento_caja m\n"
                + "inner join usuarios u on m.idusuarios=u.idusuarios where m.estado='ACTIVO' and m.idusuarios='" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = rs.getInt("idmov");
                System.out.println(t);
            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }

    public Double mostrarTotalegreso(String buscar) {
        Double t = 0.0;
        sSQL = "select sub_total "
                + "  from detalle_venta "
                + " where idventa='" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                t = t + rs.getDouble("sub_total");

            }
            return t;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:sss " + e);
            return t;
        }
    }

    public void mostrarMonto(String buscar) {

        sSQL = "SELECT (e.idmovimiento)as id, (m.idmovimiento)as idm from egresos e \n"
                + "inner join movimiento_caja m on e.idmovimiento=m.idmovimiento "
                + "where m.estado='ACTIVO' and m.idusuarios='" + buscar + "' order by m.idmovimiento Desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimoMonto = rs.getInt("id");
                idm = rs.getInt("idm");

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }

     public void mostrar_ultimo_id() {

        sSQL = "select max(idmovimiento)as id from movimiento_caja ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                ultimo_id_cj = rs.getInt("id");
                frmprincipal.lblidmovimiento2.setText(""+ultimo_id_cj);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }
}
