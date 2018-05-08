/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Fecha.Fecha;

/**
 *
 * @author alumno
 */
public final class Empleado extends Persona{
    private String sede;
    private String categoria;

    public Empleado(String sede, String categoria, String dni, String nombre, Fecha fecha_alta, boolean activo) {
        super(dni, nombre, fecha_alta, activo);
        this.sede = sede;
        this.categoria = categoria;
    }

    /**
     * @return the sede
     */
    public String getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(String sede) {
        this.sede = sede;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "sede=" + sede + ", categoria=" + categoria + '}';
    }

    
    
}
