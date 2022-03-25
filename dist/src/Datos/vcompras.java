/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Jose Ayala
 */
public class vcompras {
    private int idcompra;
    private int idusuarios;   
    private Long total;
    private Date fecha;
    private String nro_factura;
    private String tipo;
    private String estado;
    private int idmovimiento;

    public vcompras() {
    }

    public vcompras(int idcompra, int idusuarios, Long total, Date fecha, String nro_factura, String tipo, String estado, int idmovimiento) {
        this.idcompra = idcompra;
        this.idusuarios = idusuarios;
        this.total = total;
        this.fecha = fecha;
        this.nro_factura = nro_factura;
        this.tipo = tipo;
        this.estado = estado;
        this.idmovimiento = idmovimiento;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

   
   
}
