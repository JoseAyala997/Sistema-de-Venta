/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Jose Ayala
 */
public class vcomidas extends valimentos {

    private int idcomida;
    private String tipo;
    private String observacion;
    private String periodo;
    private String dias;
    private int caloriastotales;
    private String estado;
    private int idalimento;

    public vcomidas() {
    }

    public vcomidas(int idcomida, String tipo, String observacion, String periodo, String dias, int caloriastotales, String estado, int idalimento) {
        this.idcomida = idcomida;
        this.tipo = tipo;
        this.observacion = observacion;
        this.periodo = periodo;
        this.dias = dias;
        this.caloriastotales = caloriastotales;
        this.estado = estado;
        this.idalimento = idalimento;
    }

    public int getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getCaloriastotales() {
        return caloriastotales;
    }

    public void setCaloriastotales(int caloriastotales) {
        this.caloriastotales = caloriastotales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }
    


}
