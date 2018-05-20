/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Persona.*;
import Venta_Alquiler.Articulo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private PreparedStatement pt;
    private ResultSet rs;

    public Conexion() {
        //this.url = "jdbc:mysql://192.168.4.141:3310/pr_proyectofinal";
        this.url = "jdbc:mysql://192.168.1.38:3310/pr_proyectofinal";
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
    
    public Empleado consultarDatos(String dni, String pass){
    
        Empleado empleado = null;
        
       try{ 
           conectar();
           st = con.createStatement();
           rs = st.executeQuery("Select * from empleado where DNI='"+dni+"' and pass='"+pass+"';");
            if (rs.next()) {
                empleado= new Empleado(rs.getInt("cod_empleado"), rs.getString("sede"), rs.getString("categoria"), rs.getString("DNI"), rs.getString("nombre"), rs.getDate("fech_alta"), rs.getBoolean("activo"));
            }
           desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
       
      return empleado;  
    }
    
    public void anadirArticulo(String matricula,int stock, double precioUnidad,String observacion){
        
        try {
            conectar();
            pt = con.prepareStatement("insert into articulo values(0,?,?,?,?)");
            if (matricula!=null)
            pt.setString(1,matricula);
            else
            pt.setString(1,matricula);
            
            pt.setInt(2,stock);
            pt.setDouble(3,precioUnidad);
            pt.setString(4,observacion);
            pt.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
    }
    
    public boolean borrarArticulo(int codigo){
    int devuelve=0;
        try {
            conectar();
            st=con.createStatement();
            devuelve=st.executeUpdate("delete from articulo where codigo="+codigo+";");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        if(devuelve==0){
            return false;
        }else{
            return true;
        }
    }
    
    public void anadirCliente(String dni, String nombre, String direccion, String poblacion, String cp, String telefono, String formaPago, String ccc ){
    
    try {
            conectar();
            pt = con.prepareStatement("insert into cliente values(0,?,?,sysdate(),true,?,?,?,?,?,?);");
            
            pt.setString(1,dni);
            pt.setString(2,nombre);
            pt.setString(3,direccion);
            pt.setString(4,poblacion);
            pt.setString(5,cp);
            pt.setString(6,telefono);
            pt.setString(7,formaPago);
            pt.setString(8,ccc);
            
            pt.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
    }
    
    public ArrayList<String> conseguirDNI(){
        ArrayList<String> dnis = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select DNI from cliente");
                while(rs.next()){
                    dnis.add(rs.getString(1));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return dnis;
    }
    
    public ArrayList<String> conseguirDNIEmpleado(){
        ArrayList<String> dnis = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select DNI from empleado where categoria='comercial'");
                while(rs.next()){
                    dnis.add(rs.getString(1));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return dnis;
    }
    
    public ArrayList<String> conseguirCodArticulo(){
        ArrayList<String> codigo = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select codigo from articulo");
                while(rs.next()){
                    codigo.add(rs.getString(1));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return codigo;
    }
    
    public Articulo conseguirArticulo(int codigo){
        
        Articulo articulo = null;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from articulo where codigo="+codigo+"");
                while(rs.next()){
                    articulo = new Articulo(rs.getInt(1),rs.getString(2),rs.getDouble(4),rs.getInt(3),rs.getString(5));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
         
       return articulo;
    }
    
    public Cliente conseguirCliente(String dni){
        Cliente c1=null;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from cliente where DNI='"+dni+"';");
                if(rs.next()){
                    c1 = new Cliente(rs.getString("direccion"), rs.getString("poblacion"), rs.getString("cp"),0, rs.getString("forma_pago"), rs.getString("ccc"), rs.getString("DNI"), rs.getString("nombre"), rs.getDate("fech_alta"), rs.getBoolean("activo"));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return c1;
    }
    
    public void borrarCliente(String dni){
    
    try {
            conectar();
            st = con.createStatement();
            st.executeUpdate("Delete from cliente where DNI='"+dni+"'");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }   
    }
    
    public ArrayList<Articulo> articulos(){
        ArrayList<Articulo> articulos = new ArrayList<>();
        Articulo a1 = null;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from articulo");
                while(rs.next()){
                    a1 = new Articulo(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5));
                    articulos.add(a1);
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return articulos;
    }
    
    public void añadirVenta(String DNIcliente,String DNIempleado,boolean pagado,String formaPago,int lineaVenta,int articulo,int cantidad,double total){
    
    try {
            conectar();
            pt = con.prepareStatement("insert into venta values(0,sysdate(),select cod_cliente from cliente where DNI=?,select cod_empleado from empleado where DNI=?,?,?,?,?,?,?);");
            
            pt.setString(1,DNIcliente);
            pt.setString(2,DNIempleado);
            pt.setBoolean(3,pagado);
            pt.setString(4,formaPago);
            pt.setInt(5,lineaVenta);
            pt.setInt(6,articulo);
            pt.setInt(7,cantidad);
            pt.setDouble(8,total);
            
            pt.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    
    }
    
    public void añadirAlquiler(Date fechaFin,String dnicliente,int linea,int articulo,int cantidad,double total){
    
    try {
            conectar();
            pt = con.prepareStatement("insert into alquiler values(0,sysdate(),?,select cod_cliente from cliente where DNI=?,?,?,?,?);");
            
            pt.setDate(1,(java.sql.Date)fechaFin);
            pt.setString(2,dnicliente);
            pt.setInt(3,linea);
            pt.setInt(4,articulo);
            pt.setInt(5,cantidad);
            pt.setDouble(6,total);
            
            pt.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    
    }
    
}
