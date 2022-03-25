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
public class vdetalle_compra {
//    iddetalle, idservicios, cantidad, precio, sub_total, pulgadas, idcompra
    private int iddetalle;
    private int idcompra;
    private int idservicios;
    private int cantidad;
    private Long precio;
    private Long sub_total;
private int pulgadas;
    public vdetalle_compra() {
    }

    public vdetalle_compra(int iddetalle, int idcompra, int idservicios, int cantidad, Long precio, Long sub_total, int pulgadas) {
        this.iddetalle = iddetalle;
        this.idcompra = idcompra;
        this.idservicios = idservicios;
        this.cantidad = cantidad;
        this.precio = precio;
        this.sub_total = sub_total;
        this.pulgadas = pulgadas;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getSub_total() {
        return sub_total;
    }

    public void setSub_total(Long sub_total) {
        this.sub_total = sub_total;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

  
    
}
