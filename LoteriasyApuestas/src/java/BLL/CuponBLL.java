/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Connection_DB;
import DAO.Cupon_DAO;
import Entidades.Cupon;
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
    public float comprobarNumeroBLL(int numero, int numeroSerie, String fecha) {

        Connection _con;
        ArrayList<Cupon> _numerosPremiados;
        float  premioFinal = 0;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();    
            
            /*Parseo String*/
            String numeroVarchar = Integer.toString(numero);
            String serie = Integer.toString(numeroSerie);
            /*Numero Posterios*/
            String numeroPosterior = Integer.toString(numero+1);
            /*Numero Anterior*/
            String numeroAnterior = Integer.toString(numero-1);
            /*Cuatro cifras*/
            String cuatroCifras = numeroVarchar.substring(1);
            /*Tres cifras*/
            String tresCifras = numeroVarchar.substring(2);
            /*Dos cifras*/
            String dosCifras = numeroVarchar.substring(3);
            /*Ultima cifra*/
            String ultimaCifra = numeroVarchar.substring(4);
            /*Primera cifra*/
            String primeraCifra = numeroVarchar.substring(0,1);
            
            
            _numerosPremiados = _compruebaDAO.comprobarNumero(_con, fecha, numero);
          if(!_numerosPremiados.get(0).getNumero().equals(numeroVarchar) | !_numerosPremiados.get(8).getNumero().equals(serie)){  
            if (_numerosPremiados.get(0).getNumero().equals(numeroVarchar)){
                premioFinal = _numerosPremiados.get(0).getPremios();
            }else if (_numerosPremiados.get(1).getNumero().equals(numeroAnterior)){
                premioFinal = _numerosPremiados.get(1).getPremios();
            }else if(_numerosPremiados.get(2).getNumero().equals(numeroPosterior)){
                premioFinal = _numerosPremiados.get(2).getPremios();
            }else if(_numerosPremiados.get(3).getNumero().equals(cuatroCifras)){
                premioFinal = _numerosPremiados.get(3).getPremios();
            }else if(_numerosPremiados.get(4).getNumero().equals(tresCifras)){
                premioFinal = _numerosPremiados.get(4).getPremios();
            }else if(_numerosPremiados.get(5).getNumero().equals(dosCifras)){
                premioFinal = _numerosPremiados.get(5).getPremios();
            }else if(_numerosPremiados.get(6).getNumero().equals(ultimaCifra)){
                premioFinal = (float) 1.5;
            }else if(_numerosPremiados.get(7).getNumero().equals(primeraCifra)){
                premioFinal = (float) 1.5;
            }
          }else {
              premioFinal = (float) 1000000000000.0;
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
    public void insertarNumeroBLL(int numero, float cantidadPremio, String fecha, String TipoPremio) {
        
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Cupon_DAO _compruebaDAO = new Cupon_DAO();
            _compruebaDAO.insertarNumero(_con, numero, cantidadPremio, fecha ,TipoPremio);
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
    }
}
