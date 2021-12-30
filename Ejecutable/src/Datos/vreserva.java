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
public class vreserva {

    private int idreserva;
    private int idusuarios;
    private int idpaciente;
    private Date fechaconsulta;
    private String horaconsulta;
    private String tipo_consulta;

    public vreserva() {
    }

    public vreserva(int idreserva, int idusuarios, int idpaciente, Date fechaconsulta, String horaconsulta, String tipo_consulta) {
        this.idreserva = idreserva;
        this.idusuarios = idusuarios;
        this.idpaciente = idpaciente;
        this.fechaconsulta = fechaconsulta;
        this.horaconsulta = horaconsulta;
        this.tipo_consulta = tipo_consulta;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
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

    public Date getFechaconsulta() {
        return fechaconsulta;
    }

    public void setFechaconsulta(Date fechaconsulta) {
        this.fechaconsulta = fechaconsulta;
    }

    public String getHoraconsulta() {
        return horaconsulta;
    }

    public void setHoraconsulta(String horaconsulta) {
        this.horaconsulta = horaconsulta;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }


}
