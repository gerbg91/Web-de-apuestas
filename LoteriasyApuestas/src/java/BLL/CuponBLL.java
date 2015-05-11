/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Connection_DB;
import DAO.Cupon_DAO;
import DAO.Nino_DAO;
import Entidades.Cupon;
import Entidades.Nino;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class CuponBLL {

    /**
     * Metodo que verifica el premio que te ha tocado segun la terminacion
     *
     * @param numero
     * @param numeroSerie
     * @param fecha
     * @return
     */
    public float comprobarNumeroBLL(String numero, String numeroSerie, String fecha) {

        Connection _con;
        ArrayList<Cupon> _numerosPremiados = new ArrayList();
        float premioFinal = 0;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();

            /*Cambio de variable*/
            String numeroVarchar = numero;
            /*Cuatro cifras*/
            String cuatroCifras = numeroVarchar.substring(1);
            /*Tres cifras*/
            String tresCifras = numeroVarchar.substring(2);
            /*Dos cifras*/
            String dosCifras = numeroVarchar.substring(3);
            /*Ultima cifra*/
            String ultimaCifra = numeroVarchar.substring(4);
            /*Primera cifra*/
            String primeraCifra = numeroVarchar.substring(0, 1);

            _numerosPremiados = _compruebaDAO.comprobarNumero(_con, fecha);
            if (_numerosPremiados.get(0).getNumero().equals(numeroVarchar) & _numerosPremiados.get(8).getNumero().equals(numeroSerie)) {
               premioFinal = _numerosPremiados.get(8).getPremios()+123456789;
            } else {
                 if (_numerosPremiados.get(0).getNumero().equals(numeroVarchar)) {
                    premioFinal = _numerosPremiados.get(0).getPremios();
                } else if (_numerosPremiados.get(1).getNumero().equals(numeroVarchar)) {
                    premioFinal = _numerosPremiados.get(1).getPremios();
                } else if (_numerosPremiados.get(2).getNumero().equals(numeroVarchar)) {
                    premioFinal = _numerosPremiados.get(2).getPremios();
                } else if (_numerosPremiados.get(3).getNumero().equals(cuatroCifras)) {
                    premioFinal = _numerosPremiados.get(3).getPremios();
                } else if (_numerosPremiados.get(4).getNumero().equals(tresCifras)) {
                    premioFinal = _numerosPremiados.get(4).getPremios();
                } else if (_numerosPremiados.get(5).getNumero().equals(dosCifras)) {
                    premioFinal = _numerosPremiados.get(5).getPremios();
                } else if (_numerosPremiados.get(6).getNumero().equals(ultimaCifra)) {
                    premioFinal = _numerosPremiados.get(6).getPremios();
                } else if (_numerosPremiados.get(7).getNumero().equals(primeraCifra)) {
                    premioFinal = _numerosPremiados.get(7).getPremios();
                }
            }
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return premioFinal;
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
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _compruebaDAO.insertarNumero(_con, numero, cantidadPremio, fecha, TipoPremio);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }

/**
 * Metodo que elimina un registro de la base de datos
 * 
 * @param id
 */
    public void eliminarNumeroBLL(String id) {

      Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _compruebaDAO.eliminarNumero(_con, id);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }

  /**
 * Metodo que lista los numeros para el admin
 * 
 * @return 
 */
    public ArrayList<Cupon> listaNumeros_admin() {
 ArrayList<Cupon> _listaNumeros = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _listaNumeros= _compruebaDAO.listaNumeros_admin(_con);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _listaNumeros;
    
    }
      /**
 * Metodo que lista los numeros para el user
 * 
 * @return 
 */
    public ArrayList<Cupon> listaNumeros() {
 ArrayList<Cupon> _listaNumeros = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _listaNumeros= _compruebaDAO.listaNumeros(_con);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _listaNumeros;
    
    }

     /**
     * Metodo que recupera los datos a actualizar de un numero
     *
     * @param _id_Cupon
     * @return
     */
    public Cupon editarNumeroBLL(String _id_Cupon) {
        Cupon _datos = null;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _datosDAO = new Cupon_DAO();
            _datos = _datosDAO.datosNumero(_con, _id_Cupon);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _datos;
    }

        /**
     * Metodo que actualiza en la base de datos el numero
     *
     * @param _numero_cupon
     * @param _premio
     * @param _fecha
     * @param _tipo_loteria
     * @param id
     */
    public void actualizarNumeroBLL(String _numero_cupon, float _premio, String _fecha, String _tipo_loteria, String id) {
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _compruebaDAO.actualizarNumero(_con, _numero_cupon, _tipo_loteria, _fecha, _premio, id);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }
}
