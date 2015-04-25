/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *Clase con las propiedades de la loteria de Navidad
 * 
 * @author Ger
 */
public class Navidad {
    
    private int id_Navidad;
    private String numero;
    private String nombre;
    private Date fecha;
    private float premios;

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @return the premios
     */
    public float getPremios() {
        return premios;
    }

    /**
     * @param premios the premios to set
     */
    public void setPremios(float premios) {
        this.premios = premios;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id_Navidad
     */
    public int getId_Navidad() {
        return id_Navidad;
    }

    /**
     * @param id_Navidad the id_Navidad to set
     */
    public void setId_Navidad(int id_Navidad) {
        this.id_Navidad = id_Navidad;
    }
}
