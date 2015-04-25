/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Ger
 */
public class Cupon {
    
    private int id_Cupon;
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
     * @return the id_Cupon
     */
    public int getId_Cupon() {
        return id_Cupon;
    }

    /**
     * @param id_Cupon the id_Cupon to set
     */
    public void setId_Cupon(int id_Cupon) {
        this.id_Cupon = id_Cupon;
    }
}
