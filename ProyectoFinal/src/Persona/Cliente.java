/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Fecha.Fecha;
import java.util.Date;

/**
 *
 * @author alumno
 */
public final class Cliente extends Persona{
    private String direccion;
    private String poblacion;
    private String cp;
    private int tel_fijo;
    private String formaPago;
    private String ccc;

    public Cliente(String direccion, String poblacion, String cp, int tel_fijo, String formaPago, String ccc, String dni, String nombre, Date fecha_alta, boolean activo) {
        super(dni, nombre, fecha_alta, activo);
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cp = cp;
        this.tel_fijo = tel_fijo;
        this.formaPago = formaPago;
        this.ccc = ccc;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the poblacion
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the tel_fijo
     */
    public int getTel_fijo() {
        return tel_fijo;
    }

    /**
     * @param tel_fijo the tel_fijo to set
     */
    public void setTel_fijo(int tel_fijo) {
        this.tel_fijo = tel_fijo;
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
     * @return the ccc
     */
    public String getCcc() {
        return ccc;
    }

    /**
     * @param ccc the ccc to set
     */
    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "direccion=" + direccion + ", poblacion=" + poblacion + ", cp=" + cp + ", tel_fijo=" + tel_fijo + ", formaPago=" + formaPago + ", ccc=" + ccc + '}';
    }

}
