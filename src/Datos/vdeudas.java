/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author joseluis
 */
public class vdeudas {
  private int iddeuda;
  private int idcliente;
  private Long total_deuda;
  private String estado;

    public vdeudas() {
    }

    public vdeudas(int iddeuda, int idventa, int idcliente, Long total_deuda, String estado) {
        this.iddeuda = iddeuda;

        this.idcliente = idcliente;
        this.total_deuda = total_deuda;
        this.estado = estado;
    }

    public int getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(int iddeuda) {
        this.iddeuda = iddeuda;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Long getTotal_deuda() {
        return total_deuda;
    }

    public void setTotal_deuda(Long total_deuda) {
        this.total_deuda = total_deuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

    
  
}
