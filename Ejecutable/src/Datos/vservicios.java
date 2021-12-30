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
public class vservicios {
    private int idservicios;
    private String nombre_servicio;
    private Long precio;
    private String unidad;
    private Double stock;
    private String estado;

    public vservicios() {
    }

    public vservicios(int idservicios, String nombre_servicio, Long precio, String unidad, Double stock, String estado) {
        this.idservicios = idservicios;
        this.nombre_servicio = nombre_servicio;
        this.precio = precio;
        this.unidad = unidad;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
            
    
}
