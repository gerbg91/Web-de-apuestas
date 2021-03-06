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
    public float comprobarNumeroBLL(String numero, float cantidadDinero, String fecha) {

        Connection _con;
        float premioFinalEuros = 0;
        ArrayList<Navidad> _listaNumeros = new ArrayList();
        ArrayList<Navidad> _numeroPremiado;
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
     * Metodo que obtiene el premio Final en euros segun su terminacion en
     * centenas, decenas y unidad de reintegro
     *
     * @param numero
     * @param fecha
     * @param _con
     * @param cantidadDinero
     * @return
     */
    private float obtenerPremiosSecundarios(String numero, String fecha, Connection _con, float cantidadDinero) {

        float premioFinalEuros = 0;
        float _premioCentimos;
        float _cantidadDineroCentimos;
        float premioFinal;
        ArrayList<Navidad> _listaNumeros;

        try {
            Navidad_DAO _listaPremiosDAO = new Navidad_DAO();
            _listaNumeros = _listaPremiosDAO.listaPremiosSecundarios(_con, fecha);

            /*Cambio de variable String*/
            String numeroVarchar = numero;
            /*Centenas*/
            String centenas = numeroVarchar.substring(2);
            /*Dos ultimas cifras*/
            String decenas = numeroVarchar.substring(3);
            /*Ultima cifra*/
            String unidad = numeroVarchar.substring(4);

            if (_listaNumeros.get(0).getNumero().equals(centenas)) {

                _premioCentimos = _listaNumeros.get(0).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(1).getNumero().equals(centenas)) {

                _premioCentimos = _listaNumeros.get(1).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(2).getNumero().equals(centenas)) {

                _premioCentimos = _listaNumeros.get(2).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;
            } else if (_listaNumeros.get(3).getNumero().equals(centenas)) {

                _premioCentimos = _listaNumeros.get(3).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(4).getNumero().equals(centenas)) {

                _premioCentimos = _listaNumeros.get(4).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(5).getNumero().equals(decenas)) {

                _premioCentimos = _listaNumeros.get(5).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(6).getNumero().equals(decenas)) {

                _premioCentimos = _listaNumeros.get(6).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(7).getNumero().equals(decenas)) {

                _premioCentimos = _listaNumeros.get(7).getPremios() * 100;
                _cantidadDineroCentimos = cantidadDinero * 100;
                premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                premioFinalEuros = premioFinal / 100;

            } else if (_listaNumeros.get(8).getNumero().equals(unidad)) {
                premioFinalEuros = cantidadDinero;
            }
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return premioFinalEuros;
    }

    /**
     * Metodo que insertar en la base de datos el numero
     *
     * @param numero
     * @param cantidadPremio
     * @param TipoPremio
     * @param fecha
     */
    public void insertarNumeroBLL(String numero, float cantidadPremio, String fecha, String TipoPremio) {

        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _compruebaDAO = new Navidad_DAO();
            _compruebaDAO.insertarNumero(_con, numero, cantidadPremio, fecha, TipoPremio);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }

    /**
     * Metodo que elimina de la base de datos
     *
     * @param id_Navidad
     */
    public void eliminarNumeroBLL(String id_Navidad) {
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _compruebaDAO = new Navidad_DAO();
            _compruebaDAO.eliminarNumero(_con, id_Navidad);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }

    /**
     * Metodo que recupera la lista de numeros premiados para el usuario
     *
     * @return
     */
    public ArrayList<Navidad> listaNumeros_user() {

        ArrayList<Navidad> _listaNumeros = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _listaDAO = new Navidad_DAO();
            _listaNumeros = _listaDAO.listaNumero_user(_con);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _listaNumeros;
    }

    /**
     * Metodo que recupera la lista de numeros premiados para el admin
     *
     * @return
     */
    public ArrayList<Navidad> listaNumeros() {

        ArrayList<Navidad> _listaNumeros = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _listaDAO = new Navidad_DAO();
            _listaNumeros = _listaDAO.listaNumero(_con);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _listaNumeros;
    }

    /**
     * Metodo que recupera los datos a actualizar de un numero
     *
     * @param _id_Navidad
     * @return
     */
    public Navidad editarNumeroBLL(String _id_Navidad) {
        Navidad _datos = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _datosDAO = new Navidad_DAO();
            _datos = _datosDAO.datosNumero(_con, _id_Navidad);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _datos;
    }

    /**
     * Metodo que actualiza en la base de datos el numero
     *
     * @param _numero_navidad
     * @param _premio
     * @param _fecha
     * @param _tipo_loteria
     */
    public void actualizarNumeroBLL(String _numero_navidad, float _premio, String _fecha, String _tipo_loteria, String id) {
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Navidad_DAO _compruebaDAO = new Navidad_DAO();
            _compruebaDAO.actualizarNumero(_con, _numero_navidad, _tipo_loteria, _fecha, _premio, id);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }
}
