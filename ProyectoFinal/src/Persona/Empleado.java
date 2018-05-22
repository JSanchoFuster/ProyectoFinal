/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import java.util.Date;

/**
 *
 * @author alumno
 */
public final class Empleado extends Persona{
    private int cod_empleado;
    private String sede;
    private String categoria;

    /**
     * Constructor de empleado
     * @param cod_empleado
     * @param sede
     * @param categoria
     * @param dni
     * @param nombre
     * @param fecha_alta
     * @param activo
     */
    public Empleado(int cod_empleado,String sede, String categoria, String dni, String nombre, Date fecha_alta, boolean activo) {
        super(dni, nombre, fecha_alta, activo);
        this.cod_empleado = cod_empleado;
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
        return super.toString() + "Empleado{" + "cod_empleado=" + getCod_empleado() + ", sede=" + getSede() + ", categoria=" + getCategoria() + '}';
    }

    /**
     * @return the cod_empleado
     */
    public int getCod_empleado() {
        return cod_empleado;
    }

    /**
     * @param cod_empleado the cod_empleado to set
     */
    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    

    
    
}
