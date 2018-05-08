/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta_Alquiler;

import Fecha.*;
import Persona.*;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Venta implements Implementar{
    private int nVenta;
    private Fecha fecha;
    private Cliente cliente;
    private boolean finalizado;
    private Empleado empleado;
    private boolean pagado;
    private String formaPago;
    private ArrayList<Articulo> articulos;
    private double total;

    public Venta(int nVenta, Fecha fecha, Cliente cliente, boolean finalizado, Empleado empleado, boolean pagado, String formaPago, ArrayList<Articulo> articulos, double total) {
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
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Fecha fecha) {
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
     * @return the total
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

    @Override
    public String imprimir() {
        return "Venta{" + "nVenta=" + getnVenta() + ", fecha=" + getFecha() + ", cliente=" + getCliente() + ", finalizado=" + isFinalizado() + ", empleado=" + getEmpleado() + ", pagado=" + isPagado() + ", formaPago=" + getFormaPago() + ", articulos=" + getArticulos() + ", total=" + getTotal() + '}';
    }

    @Override
    public Double calcularTotal() {
        double total=0;
        
        for (int i = 0; i < articulos.size(); i++) {
            total+=articulos.get(i).getCantidad()*articulos.get(i).getImporteUnidad();
        }
       return total;     
    }

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
