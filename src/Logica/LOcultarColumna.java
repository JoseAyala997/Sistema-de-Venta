/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Jose Ayala
 */
public class LOcultarColumna {

    public static void ocultar_esta_columna(javax.swing.JTable nombretabla, int nrocolumna) {
        nombretabla.getColumnModel().getColumn(nrocolumna).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna).setPreferredWidth(0);
    }
}
