/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta_Alquiler;

import Persona.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Venta implements Implementar{
    private int nVenta;
    private Date fecha;
    private Cliente cliente;
    private boolean finalizado;
    private Empleado empleado;
    private boolean pagado;
    private String formaPago;
    private ArrayList<Articulo> articulos;
    private double total;

    /**
     * Constructor de venta
     * @param nVenta
     * @param fecha
     * @param cliente
     * @param finalizado
     * @param empleado
     * @param pagado
     * @param formaPago
     * @param articulos
     * @param total
     */
    public Venta(int nVenta, Date fecha, Cliente cliente, boolean finalizado, Empleado empleado, boolean pagado, String formaPago, ArrayList<Articulo> articulos, double total) {
        this.nVenta = nVenta;
        this.fecha = fecha;
        this.cliente = cliente;
        this.finalizado = finalizado;
        this.empleado = empleado;
        this.pagado = pagado;
        this.formaPago = formaPago;
        this.articulos = articulos;
        this.total = calcularTotal();
    }

    /**
     * @return the nVenta
     */
    public int getnVenta() {
        return nVenta;
    }

    /**
     * @param nVenta the nVenta to set
     */
    public void setnVenta(int nVenta) {
        this.nVenta = nVenta;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the pagado
     */
    public boolean isPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * @param formaPago the formaPago to set
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the articulos
     *

    /**
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Metodo que muestra una factura
     * @return Devuelve la factura
     */
    @Override
    public String imprimir() {
        return "Venta{" + "nVenta=" + getnVenta() + ", fecha=" + getFecha() + ", cliente=" + getCliente() + ", finalizado=" + isFinalizado() + ", empleado=" + getEmpleado() + ", pagado=" + isPagado() + ", formaPago=" + getFormaPago() + ", articulos=" + getArticulos() + ", total=" + getTotal() + '}';
    }

    /**
     * Metodo que calcula el total de la venta
     * @return Devuelve el total
     */
    @Override
    public Double calcularTotal() {
        double total=0;
        
        for (int i = 0; i < articulos.size(); i++) {
            total+=articulos.get(i).getCantidad()*articulos.get(i).getImporteUnidad();
        }
       return total;     
    }

    /**
     * Comprueba si existe el articulo al que se ha hecho referencia
     * @return Devuelve un boolean
     */
    @Override
    public Boolean existe() {
        //Cargar lista de articulos de BD y comprobar si existe ese articulo, en caso de que no exista no se podra realizar la venta o alquiler
        return false;   
    }

    /**
     * @return the articulos
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    
}
