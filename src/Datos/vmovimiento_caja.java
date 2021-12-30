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
public class vmovimiento_caja {
    private int idmovimiento;
    private String num_Caja;
   private int idusuarios;
   private Date fecha_apertura;
   private Date fecha_cierre;
   private long monto_apertura;
   private long monto_cierre;
   private String estado;
;

    public vmovimiento_caja() {
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getNum_Caja() {
        return num_Caja;
    }

    public void setNum_Caja(String num_Caja) {
        this.num_Caja = num_Caja;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public long getMonto_apertura() {
        return monto_apertura;
    }

    public void setMonto_apertura(long monto_apertura) {
        this.monto_apertura = monto_apertura;
    }

    public long getMonto_cierre() {
        return monto_cierre;
    }

    public void setMonto_cierre(long monto_cierre) {
        this.monto_cierre = monto_cierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

}