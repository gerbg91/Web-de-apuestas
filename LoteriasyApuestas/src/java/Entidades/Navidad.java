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

    private int numero;
    private Date fecha;
    private float premios;

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
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
}
