/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Persona.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Conexion {
    private String url;
    private String usuario;
    private String pass;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Conexion() {
        this.url = "jdbc:mysql://192.168.4.141:3310/pr_proyectofinal";
        this.usuario = "jsancho";
        this.pass = "Admin1234";
    }

    public Conexion(String url, String usuario, String pass) {
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
    }
    
    private void conectar(){
    
        
        try {
            con = (Connection) DriverManager.getConnection(url,usuario,pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        

    }
    private void desconectar(){
        try {           
            con.close();                   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean consultarDatos(String dni, String pass){
    
        boolean empleado = false;
        
       try{ 
           conectar();
           st = con.createStatement();
           rs = st.executeQuery("Select * from empleado where DNI='"+dni+"' and pass='"+pass+"';");
            if (rs.next()) {
                empleado= true; 
            }
           desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
       
      return empleado;  
    }
    
}
