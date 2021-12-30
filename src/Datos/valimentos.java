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
public class valimentos {
    private int idalimento;
    private String nombre_alimento;
    private int cantidad; 
    private int calorias;
    private int proteinas; 
    private int vitaminas;
    private int minerales; 
    private String estado;

    public valimentos() {
    }

    public valimentos(int idalimento, String nombre_alimento, int cantidad, int calorias, int proteinas, int vitaminas, int minerales, String estado) {
        this.idalimento = idalimento;
        this.nombre_alimento = nombre_alimento;
        this.cantidad = cantidad;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.vitaminas = vitaminas;
        this.minerales = minerales;
        this.estado = estado;
    }

    public int getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getVitaminas() {
        return vitaminas;
    }

    public void setVitaminas(int vitaminas) {
        this.vitaminas = vitaminas;
    }

    public int getMinerales() {
        return minerales;
    }

    public void setMinerales(int minerales) {
        this.minerales = minerales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
    
    
}
