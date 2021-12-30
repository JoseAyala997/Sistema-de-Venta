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
public class vdieta {


    private int iddieta;
    private int idusuarios;
    private int idpaciente;
    private int idcomida;
    private String comentario;
    private Date fecha_registro;
    private String estado;
  

    public vdieta() {
    }

    public vdieta(int iddieta, int idusuarios, int idcomida, int idpaciente, String comentario, Date fecha_registro, String estado) {
        this.iddieta = iddieta;
        this.idusuarios = idusuarios;
        this.idcomida = idcomida;
        this.idpaciente = idpaciente;
        this.comentario = comentario;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public int getIddieta() {
        return iddieta;
    }

    public void setIddieta(int iddieta) {
        this.iddieta = iddieta;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
