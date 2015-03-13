/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Connection_DB;
import DAO.Navidad_DAO;
import DAO.Nino_DAO;
import Entidades.Nino;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class NinoBLL {

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

        Connection _con;
        float premioFinalEuros = 0;
        ArrayList<Nino> _listaNumeros = new ArrayList();
        ArrayList<Nino> _numeroPremiado;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Nino_DAO _compruebaDAO = new Nino_DAO();
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
        float _premioCentimos;
        float _cantidadDineroCentimos;
        float premioFinal;
        ArrayList<Nino> _listaNumeros;

        try {
            Nino_DAO _listaPremiosDAO = new Nino_DAO();
            _listaNumeros = _listaPremiosDAO.listaPremiosSecundarios(_con, fecha);

            /*Parseo String*/
            String numeroVarchar = Integer.toString(numero);
            /*Cuatro cifras*/
            String cuatroCifras = numeroVarchar.substring(1);
            /*Centenas*/
            String tresCifras = numeroVarchar.substring(2);
            /*Dos ultimas cifras*/
            String dosCifras = numeroVarchar.substring(3);
            /*Ultima cifra*/
            String unaCifra = numeroVarchar.substring(4);

            for (int e = 0; e <= _listaNumeros.size(); e++) {
                if (premioFinalEuros == 0) {
                    if (_listaNumeros.get(e).getNumero().length() == 4) {
                        if (_listaNumeros.get(e).getNumero().equals(cuatroCifras)) {

                            _premioCentimos = _listaNumeros.get(e).getPremios() * 100;
                            _cantidadDineroCentimos = cantidadDinero * 100;
                            premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                            premioFinalEuros = premioFinal / 100;
                        }
                    } else if (_listaNumeros.get(e).getNumero().length() == 3) {
                        if (_listaNumeros.get(e).getNumero().equals(tresCifras)) {

                            _premioCentimos = _listaNumeros.get(e).getPremios() * 100;
                            _cantidadDineroCentimos = cantidadDinero * 100;
                            premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                            premioFinalEuros = premioFinal / 100;

                        }
                    } else if (_listaNumeros.get(e).getNumero().length() == 2) {
                        if (_listaNumeros.get(e).getNumero().equals(dosCifras)) {

                            _premioCentimos = _listaNumeros.get(e).getPremios() * 100;
                            _cantidadDineroCentimos = cantidadDinero * 100;
                            premioFinal = (_premioCentimos * _cantidadDineroCentimos) / 100;
                            premioFinalEuros = premioFinal / 100;

                        }
                    } else if (_listaNumeros.get(e).getNumero().length() == 1) {
                        if (_listaNumeros.get(e).getNumero().equals(unaCifra)) {
                            
                            premioFinalEuros = cantidadDinero;

                        }
                    }
                }
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
     * @return
     */
    public boolean insertarNumeroBLL(int numero, float cantidadPremio, String fecha, String TipoPremio) {
        
        boolean _insercion = false;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Nino_DAO _compruebaDAO = new Nino_DAO();
            _insercion = _compruebaDAO.insertarNumero(_con, numero, cantidadPremio, fecha ,TipoPremio);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _insercion;
    }
}

