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
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class NavidadBLL {

    /**
     * Metodo que verifica el premio que te ha tocado, en las papeletas no son
     * en numeros redondos(Ej: 4.5 euros), la cantidad apostada por el usuario
     * la transformo en centimos
     *
     * @param numero
     * @param cantidadDinero
     * @param fecha
     * @return
     */
    public float comprobarNumeroBLL(int numero, float cantidadDinero, String fecha) {

        Connection _con = null;
        float premioFinalEuros = 0;
        ArrayList<Navidad> _listaNumeros = new ArrayList();
        ArrayList<Navidad> _numeroPremiado = new ArrayList();
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _compruebaDAO = new Navidad_DAO();
            _numeroPremiado = _compruebaDAO.comprobarNumero(_con, fecha, numero);

            if (!_numeroPremiado.isEmpty()) {
                float _premioCentimos = _numeroPremiado.get(0).getPremios() * 100;
                float _cantidadDineroCentimos = cantidadDinero * 100;
                float premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;
            } else {
                premioFinalEuros = obtenerPremiosSecundarios(numero, fecha, _con, cantidadDinero);
            }
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return premioFinalEuros;
    }

    /**
     * Metodo que obtiene el premio Final en euros segun su terminarcion en
     * centenas, decenas y unidad de reintegro
     *
     * @param numero
     * @param fecha
     * @param _con
     * @param cantidadDinero
     * @return
     */
    private float obtenerPremiosSecundarios(int numero, String fecha, Connection _con, float cantidadDinero) {

        float premioFinalEuros = 0;
        float _premioCentimos = 0;
        float _cantidadDineroCentimos = 0;
        float premioFinal = 0;
        ArrayList<Navidad> _listaNumeros = new ArrayList();

        try {
            Navidad_DAO _listaPremiosDAO = new Navidad_DAO();
            _listaNumeros = _listaPremiosDAO.listaPremiosSecundarios(_con, fecha);

            /*Parseo String*/
            String prueba = Integer.toString(numero);
            /*Centenas*/
            String prueba1 = prueba.substring(2);
            /*Dos ultimas cifras*/
            String prueba2 = prueba.substring(3);
            /*Ultima cifra*/
            String prueba3 = prueba.substring(4);

            if (_listaNumeros.get(0).getNumero().equals(prueba1)) {

                _premioCentimos = _listaNumeros.get(0).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(1).getNumero().equals(prueba1)) {

                _premioCentimos = _listaNumeros.get(1).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(2).getNumero().equals(prueba1)) {

                _premioCentimos = _listaNumeros.get(2).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;
            } else if (_listaNumeros.get(3).getNumero().equals(prueba1)) {

                _premioCentimos = _listaNumeros.get(3).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(4).getNumero().equals(prueba1)) {

                _premioCentimos = _listaNumeros.get(4).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(5).getNumero().equals(prueba2)) {

                _premioCentimos = _listaNumeros.get(5).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(6).getNumero().equals(prueba2)) {

                _premioCentimos = _listaNumeros.get(6).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(7).getNumero().equals(prueba2)) {

                _premioCentimos = _listaNumeros.get(7).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(8).getNumero().equals(prueba3)) {

                _premioCentimos = _listaNumeros.get(8).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;
            }
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return premioFinalEuros;
    }

}
