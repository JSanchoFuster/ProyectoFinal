/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta_Alquiler;

/**
 *
 * @author alumno
 */
public interface Implementar {

    /**
     * Mostrara una factura
     * @return Devuelve la factura
     */
    public String imprimir();

    /**
     * Calcula el total de una venta o alquiler
     * @return Total
     */ 
    public Double calcularTotal();

    /** 
     * Comprueba si existe un producto
     * @return Devulve si o no
     */
    public Boolean existe();
}
