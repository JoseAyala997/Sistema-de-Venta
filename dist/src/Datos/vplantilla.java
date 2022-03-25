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
public class vplantilla {
    
    private int idplantilla;
    private int idcomida;
    private String tipo;
    private String observacion;
    public vplantilla() {
    }

    public vplantilla(int idplantilla, int idcomida, String tipo, String observacion) {
        this.idplantilla = idplantilla;
        this.idcomida = idcomida;
        this.tipo = tipo;
        this.observacion = observacion;
    }

    public int getIdplantilla() {
        return idplantilla;
    }

    public void setIdplantilla(int idplantilla) {
        this.idplantilla = idplantilla;
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

   
    

    

}