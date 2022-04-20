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

    public String db = "ventas";
    public String url="jdbc:mysql://localhost:3306/" +db;
    public String user = "root";
    public String pass = "";

    public Conexion() {
    }
    public java.sql.Connection conectar(){
        java.sql.Connection link=null;
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return link;
    }
    
   
    
}
