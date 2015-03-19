/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class Cupon_DAO {

    /**
     * Metdo que recupera el premio si ha resultado ganador
     *
     * @param con
     * @param fecha
     * @return
     * @throws Exception
     */
    public ArrayList<Cupon> comprobarNumero(Connection con, String fecha) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cupon where historico=? and (nombre=\"CincoCifras\" or nombre=\"CincoCifrasAnterior\" or nombre=\"CincoCifrasPosterior\" or nombre=\"CuatroCifras\" or nombre=\"TresCifras\" or nombre=\"DosCifras\" or nombre=\"UltimaCifra\" or nombre=\"PrimeraCifra\" or nombre=\"Serie\")");
            stmt.setString(1, fecha);
            rs = stmt.executeQuery();
            Cupon _numeros;
            while (rs.next()) {
                _numeros = new Cupon();
                _listaNumeros.add(obtenNumeros(rs, _numeros));
            }
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al buscar los numeros en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return _listaNumeros;
    }

    /**
     * Metodo que setea las propiedades de los numeros
     *
     * @param rs
     * @param numeros
     * @return
     * @throws SQLException
     */
    private Cupon obtenNumeros(ResultSet rs, Cupon numeros) throws SQLException {
        numeros.setNumero(rs.getString("numero"));
        numeros.setNombre(rs.getString("nombre"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getFloat("premios"));
        return numeros;
    }

    /**
     * Metodo que inserta en la base de datos
     *
     * @param _con
     * @param numero
     * @param cantidadPremio
     * @param fecha
     * @param TipoPremio
     * @throws Exception
     */
    public void insertarNumero(Connection _con, String numero, float cantidadPremio, String fecha, String TipoPremio) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("INSERT INTO cupon (numero, nombre, historico ,premios) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, numero);
            stmt.setString(2, TipoPremio);
            stmt.setString(3, fecha);
            stmt.setFloat(4, cantidadPremio);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al insertar los numeros en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * Metodo que busca en la base de datos el numero deseado
     *
     * @param _con
     * @param _numero_busqueda
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<Cupon> buscarNumero(Connection _con, int _numero_busqueda) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from cupon where numero=?");
            stmt.setString(1, Integer.toString(_numero_busqueda));
            rs = stmt.executeQuery();
            Cupon _numeros = null;
            while (rs.next()) {
                _numeros = new Cupon();
                _listaNumeros.add(obtenNumeros(rs, _numeros));
            }
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al buscar los numeros en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return _listaNumeros;
    }

    /**
     * Metodo que busca en la base de datos por fecha
     *
     * @param _con
     * @param _fecha
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<Cupon> buscarNumeroByFecha(Connection _con, String _fecha) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from cupon where historico=?");
            stmt.setString(1, _fecha);
            rs = stmt.executeQuery();
            Cupon _numeros = null;
            while (rs.next()) {
                _numeros = new Cupon();
                _listaNumeros.add(obtenNumeros(rs, _numeros));
            }
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al buscar los numeros en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return _listaNumeros;
    }

    /**
     * Metodo que elimina el registro de la base de datos
     *
     * @param _con
     * @param _numero_cupon
     * @param _fecha
     * @throws java.lang.Exception
     */
    public void eliminarNumero(Connection _con, String _numero_cupon, String _fecha) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("Delete from cupon where numero=? and historico=?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, _numero_cupon);
            stmt.setString(2, _fecha);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al borrar los numeros en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
