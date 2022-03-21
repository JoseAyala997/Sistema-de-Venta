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
public class vventas {
    private int idventa;
    private int idusuarios;
    private int idpaciente;    
    private Long total;
    private Date fecha;
    private String nro_factura;
    private String tipo;
    private String estado;
    private int idmovimiento;
    private Long descuento;

    public vventas() {
    }

    public vventas(int idventa, int idusuarios, int idpaciente, Long total, Date fecha, String nro_factura, String tipo, String estado, int idmovimiento, Long descuento) {
        this.idventa = idventa;
        this.idusuarios = idusuarios;
        this.idpaciente = idpaciente;
        this.total = total;
        this.fecha = fecha;
        this.nro_factura = nro_factura;
        this.tipo = tipo;
        this.estado = estado;
        this.idmovimiento = idmovimiento;
        this.descuento = descuento;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
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

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

   
    
   
}
