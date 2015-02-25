/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * Clase con las propiedades del administrador
 *
 * @author Ger
 */
public class Administrador {

    private String id_usuario;
    private String pass_mysql;

    /**
     * @return the id_usuario
     */
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the pass_mysql
     */
    public String getPass_mysql() {
        return pass_mysql;
    }

    /**
     * @param pass_mysql the pass_mysql to set
     */
    public void setPass_mysql(String pass_mysql) {
        this.pass_mysql = pass_mysql;
    }
}
