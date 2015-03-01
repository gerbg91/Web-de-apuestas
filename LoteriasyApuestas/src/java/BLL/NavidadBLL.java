/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Connection_DB;
import DAO.Navidad_DAO;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author Ger
 */
public class NavidadBLL {

    /**
     * Metodo que verifica el premio que te ha tocado, en las papeletas no
     * son en numeros redondos(Ej: 4.5 euros), la cantidad apostada por el
     * usuario la transformo en centimos
     *
     * @param numero
     * @param cantidadDinero
     * @param fecha
     * @return 
     */
    public float comprobarNumeroBLL(int numero, float cantidadDinero, Date fecha) {

        Connection _con = null;
        float premioFinalEuros=0;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _compruebaDAO = new Navidad_DAO();
            float _resultado = _compruebaDAO.comprobarNumero(_con,fecha,numero);
            _conexion_DB.CerrarConexion(_con);
            if(_resultado!=0){
                float _premioCentimos = _resultado*100;
                float _cantidadDineroCentimos =  cantidadDinero*100;
                /*Algoritmo*/
                float premioFinal = (_premioCentimos*_cantidadDineroCentimos)/100;
                premioFinalEuros = premioFinal/100;
            }
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return premioFinalEuros;
    }
}
