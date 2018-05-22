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
 * Clase conexion
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

    /**
     *Constructor que tiene como parametros la direccion del servidor
     */
    public Conexion() {
        this.url = "jdbc:mysql://192.168.4.141:3310/pr_proyectofinal";
        //this.url = "jdbc:mysql://192.168.1.38:3310/pr_proyectofinal";
        this.usuario = "jsancho";
        this.pass = "Admin1234";
    }

    /**
     * Constructor que recibe los parametros de la direccion del servidor en el que se va a trabajar
     * @param url Direccion ip servidor y tabla sobre la que se va a actuar
     * @param usuario Usuario con permisos para poder hacer peticiones a la bd
     * @param pass Contraseña del usuario
     */
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
    
    /**
     * Metodo que obtiene los datos para poder hacer login
     * @param dni DNI del usuario
     * @param pass Contraseña del usuario
     * @return Devuelve un objeto empleado
     */
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
    
    /**
     * Inserta un articulo a la bd
     * @param matricula Recibe o no la matricula del objeto
     * @param stock Recibe la cantidad inicial con la que se va a partir
     * @param precioUnidad Recibe un precio del articulo
     * @param observacion Descripción del articulo
     */
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
    
    /**
     * Borra un articulo
     * @param codigo Recibe la clave del articulo que se va a borrar
     * @return Devuelve un booleano dependiendo de si existe o no el articulo
     */
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
    
    /**
     * Añade un cliente a la bd
     * @param dni DNI del cliente
     * @param nombre Nombre del cliente
     * @param direccion Direccion del cliente
     * @param poblacion Poblacion del cliente
     * @param cp Codigo Postal del cliente
     * @param telefono Telefono del cliente
     * @param formaPago Forma de pago del cliente
     * @param ccc Recibira o no un Codigo de Cuenta Bancaria
     */
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
    
    /**
     * Metodo que devuelve todos los DNI de los clientes
     * @return Devuelve un array que contendrá todos los clientes actuales
     */
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
    
    /**
     * Metodo que devuelve todos los DNI de los empleados
     * @return Devuelve un array que contendrá todos los DNI de los empleados actuales
     */
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
    
    /**
     * Metodo que devuelve todos los codigos de los articulos
     * @return Devuelve un array que contendrá todos los codigos de los articulos actuales
     */
    public ArrayList<String> conseguirCodArticuloVenta(){
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
    
    /**
     * Metodo que devuelve el stock de los productos que no tienen matricula
     * @return Devuelve un array con todos los codigos
     */
    public ArrayList<String> conseguirCodArticuloStock(){
        ArrayList<String> codigo = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select codigo from articulo where matricula is NULL");
                while(rs.next()){
                    codigo.add(rs.getString(1));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return codigo;
    }
    
    /**
     * Metodo que devuelve el codigo de todos los productos que tienen matricula
     * @return Devuelve un array con todos los codigos
     */ 
    public ArrayList<String> conseguirCodArticuloAlquiler(){
        ArrayList<String> codigo = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select codigo from articulo where matricula<>\"\"");
                while(rs.next()){
                    codigo.add(rs.getString(1));
                }
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    return codigo;
    }
    
    /**
     * Metodo que devuelve un articulo dependiendo de un codigo
     * @param codigo Codigo del articulo
     * @return Devuelve un objeto articulo
     */
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
    
    /**
     * Metodo que devuelve un cliente dependiendo de un dni
     * @param dni DNI de un cliente
     * @return Devolvera un objeto cliente
     */
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
    
    /**
     * Metodo que borra un cliente dependiendo de un dni
     * @param dni DNI de un cliente
     */
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
    
    /**
     * Metodo que devuelve todos los Articulos
     * @return Devulve un array con objetos articulo
     */
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
    
    /**
     * Metodo que calcula el siguiente indice en la tabla alquiler
     * @return Numero del indice
     */
    public int indiceAlquiler(){
            int indice =0;
            try {
                conectar();
                st = con.createStatement();
                rs = st.executeQuery("Select max(cod_contrato) from alquiler");
                    if(rs.next()){
                        indice = rs.getInt(1);
                    }
                desconectar();
            } catch (SQLException ex) {
                System.out.println("Error");
            }
     return (indice+1);
    }
    
    /**
     * Metodo que calcula el siguiente indice en la tabla ventas
     * @return Numero del indice
     */
    public int indiceVentas(){
            int indice =0;
            try {
                conectar();
                st = con.createStatement();
                rs = st.executeQuery("Select max(nVenta) from venta");
                    if(rs.next()){
                        indice = rs.getInt(1);
                    }
                desconectar();
            } catch (SQLException ex) {
                System.out.println("Error");
            }
     return (indice+1);
    }
    
    /**
     * Metodo que añade una venta
     * @param nventa indice de venta generado por el metodo indiceVentas()
     * @param DNIcliente DNI del cliente 
     * @param DNIempleado DNI del empleado 
     * @param pagado Comprueba si esta pagado o no
     * @param formaPago Forma de pago
     * @param lineaVenta Linea de la venta
     * @param articulo codigo del articulo al que se hace referencia
     * @param cantidad cantidad del articulo a vender 
     * @param total total de la venta
     */
    public void añadirVenta(int nventa,String DNIcliente,String DNIempleado,boolean pagado,String formaPago,int lineaVenta,int articulo,int cantidad,double total){
    
    try {
            conectar();
            pt = con.prepareStatement("insert into venta values("+nventa+",sysdate(),(select cod_cliente from cliente where DNI=?),(select cod_empleado from empleado where DNI=?),?,?,?,?,?,?);");
            
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
    
    /**
     * Metodo que añade un alquiler
     * @param cod_contrato Codigo de contrato generado por el metodo indiceAlquiler()
     * @param fechaFin Fecha de fin del contrato
     * @param dnicliente DNI del cliente
     * @param linea Linea de el alquiler
     * @param articulo codigo del articulo al que se hace referencia
     * @param cantidad cantidad del articulo que se va a alquilar
     * @param total total del alquiler por dia
     */
    public void añadirAlquiler(int cod_contrato,Date fechaFin,String dnicliente,int linea,int articulo,int cantidad,double total){
    
    try {
            conectar();
            pt = con.prepareStatement("insert into alquiler values("+cod_contrato+",sysdate(),?,(select cod_cliente from cliente where DNI=?),?,?,?,?);");
            
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
    
    /**
     * Metodo que añade stock a un producto existente
     * @param codigoArticulo codigo del articulo a aumentar stock
     * @param cantidad cantidad a aumentar
     */
    public void actualizarStock(int codigoArticulo, int cantidad){
    
        try {
            conectar();
            pt = con.prepareStatement("UPDATE articulo set stock = stock+? where codigo=?;");
            
            pt.setInt(1, cantidad);
            pt.setInt(2,codigoArticulo);
            
            pt.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
    } 
}
