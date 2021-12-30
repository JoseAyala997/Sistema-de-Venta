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
   private int idusuarios;
   private Date fecha_apertura;
   private long apertura;
   private Date fecha_cierre;
   private long cierre;
   private String estado;
;

    public vmovimiento_caja() {
    }

    public vmovimiento_caja(int idmovimiento, int idusuarios, Date fecha_apertura, long apertura, Date fecha_cierre, long cierre, String estado) {
        this.idmovimiento = idmovimiento;
        this.idusuarios = idusuarios;
        this.fecha_apertura = fecha_apertura;
        this.apertura = apertura;
        this.fecha_cierre = fecha_cierre;
        this.cierre = cierre;
        this.estado = estado;
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
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

    public long getApertura() {
        return apertura;
    }

    public void setApertura(long apertura) {
        this.apertura = apertura;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public long getCierre() {
        return cierre;
    }

    public void setCierre(long cierre) {
        this.cierre = cierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   
   
   
}
