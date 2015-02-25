/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Connection_DB;
import DAO.Navidad_DAO;
import Entidades.Navidad;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class NavidadBLL {

    /**
     * Metodo que verifica si te ha tocado el numero Dado que las papeletas no
     * son en numeros redondos(Ej: 4.5 euros), la cantidad apostada por el
     * usuario la transformo en centimos
     *
     * @param numero
     * @param cantidadDinero
     * @param fecha
     */
    public void comprobarNumeroBLL(int numero, float cantidadDinero, Date fecha) {

        Connection _con = null;
        ArrayList<Navidad> _listado = new ArrayList();
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO op = new Navidad_DAO();
            _listado = op.listadoNumeros(_con,fecha);
            _conexion_DB.CerrarConexion(_con);
            /*Ejecucion del algoritmo*/
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }
}
