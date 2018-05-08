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
public class Alquiler implements Implementar{
    private int cod_contrato;
    private Cliente cliente;
    private Fecha fecha_ini;
    private Fecha fecha_fin;
    private String observacion;
    private ArrayList<Articulo> articulos;
    private double total;

    public Alquiler(int cod_contrato, Cliente cliente, Fecha fecha_ini, Fecha fecha_fin, String observacion, ArrayList<Articulo> articulos, double total) {
        this.cod_contrato = cod_contrato;
        this.cliente = cliente;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.observacion = observacion;
        this.articulos = articulos;
        this.total = calcularTotal();
    }

    /**
     * @return the cod_contrato
     */
    public int getCod_contrato() {
        return cod_contrato;
    }

    /**
     * @param cod_contrato the cod_contrato to set
     */
    public void setCod_contrato(int cod_contrato) {
        this.cod_contrato = cod_contrato;
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
     * @return the fecha_ini
     */
    public Fecha getFecha_ini() {
        return fecha_ini;
    }

    /**
     * @param fecha_ini the fecha_ini to set
     */
    public void setFecha_ini(Fecha fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    /**
     * @return the fecha_fin
     */
    public Fecha getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Fecha fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        return "Alquiler{" + "cod_contrato=" + cod_contrato + ", cliente=" + cliente + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", observacion=" + observacion + ", articulos=" + articulos + ", total=" + total + '}';
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
    
    
}
