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
public class Articulo {
    private int codigo;
    private String matricula;
    private double importeUnidad;
    private int cantidad;
    private String observacion;

    public Articulo(int codigo, String matricula, double importeUnidad, int cantidad, String observacion) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.importeUnidad = importeUnidad;
        this.cantidad = cantidad;
        this.observacion = observacion;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the importeUnidad
     */
    public double getImporteUnidad() {
        return importeUnidad;
    }

    /**
     * @param importeUnidad the importeUnidad to set
     */
    public void setImporteUnidad(double importeUnidad) {
        this.importeUnidad = importeUnidad;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", matricula=" + matricula + ", importeUnidad=" + importeUnidad + ", cantidad=" + cantidad + ", observacion=" + observacion + '}';
    }
    
    
}
