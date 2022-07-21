/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {

    public String db = "ventas";// creamos una variable para almacenar el nombre de la bd
    public String url="jdbc:mysql://localhost:3306/" +db;//cargamos la url dentro de una variable
    public String user = "db_ventas_user";// db_ventas_user creamos una variable donde almacenar el usuario
    public String pass = "12345";//creamos una variable para almacenar la contraseña de la bd

    public Conexion() {//constructor de la clase
    }
    public java.sql.Connection conectar(){//creamos un metodo llamado conectar para la conexion de la bd
        java.sql.Connection link=null;
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);//hacemos una conexion con la base de datos
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);//enviamos un sqlException en caso de que no se conecte a la bd
            
        }
        
        return link;
    }
    
   
    
}
