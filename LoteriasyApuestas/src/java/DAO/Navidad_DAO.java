/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Navidad;
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
public class Navidad_DAO {

    /**
     * Metdo que recupera el premio si ha resultado ganador
     *
     * @param con
     * @param fecha
     * @param numero
     * @return
     * @throws Exception
     */
    @SuppressWarnings("null")
    public ArrayList<Navidad> comprobarNumero(Connection con, String fecha, String numero) throws Exception {
         ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM navidad where numero=? and historico=?");
            stmt.setString(1, numero);
            stmt.setString(2,fecha);
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            Navidad numeroPremiado = new Navidad();
            while (rs.next()) {
                 _numeros = new Navidad();
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
     * Metodo que recupera lista de premios secundarios importantes 
     *
     * @param con
     * @param fecha
     * @return
     * @throws Exception
     */
    public ArrayList<Navidad> listaPremiosSecundarios(Connection con, String fecha) throws Exception {
        ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from navidad where (nombre=\"PrimerPremioCentenas\" or nombre=\"SegundoPremioCentenas\" or nombre=\"TercerPremioCentenas\" or nombre=\"CuartoPremioCentenas\" or nombre=\"PrimerPremioDecenas\" or nombre=\"SegundoPremioDecenas\" or nombre=\"TercerPremioDecenas\" or nombre=\"Reintegro\") and historico=?");
            stmt.setString(1,fecha);
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            while (rs.next()) {
                _numeros = new Navidad();
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
    private Navidad obtenNumeros(ResultSet rs, Navidad numeros) throws SQLException {
        numeros.setId_Navidad(rs.getInt("id_Navidad"));
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
            stmt = _con.prepareStatement("INSERT INTO navidad (numero,nombre, historico ,premios) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,numero);
            stmt.setString(2,TipoPremio);
            stmt.setString(3,fecha);
            stmt.setFloat(4,cantidadPremio);
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
 * Metodo que elimina de la base de datos
 * 
 * 
 * @param _con
 * @param numero
 * @param fecha
 * @throws Exception 
 */
    public void eliminarNumero(Connection _con, String numero, String fecha) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("Delete from navidad where numero=?  and historico=? ");
            stmt.setString(1,numero);
            stmt.setString(2,fecha);
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
    
/**
 * Metodo que busca en la base de datos
 * 
 * @param _con
 * @param _numero_busqueda
 * @return
 * @throws Exception 
 */
    public ArrayList<Navidad> buscarNumero(Connection _con, int _numero_busqueda) throws Exception {
     ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from navidad where numero=?");
            stmt.setString(1,Integer.toString(_numero_busqueda));
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            while (rs.next()) {
                _numeros = new Navidad();
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
 * Metodo que busca en la BD por fecha
 * 
 * @param _con
 * @param _fecha
 * @return 
 * @throws java.lang.Exception 
 */
    public ArrayList<Navidad> buscarNumeroFecha(Connection _con, String _fecha) throws Exception {
     ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from navidad where historico=?");
            stmt.setString(1,_fecha);
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            while (rs.next()) {
                _numeros = new Navidad();
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
     * Metodo que recupera todos los numeros
     * 
     * @param _con
     * @return 
     */
    public ArrayList<Navidad> listaNumero(Connection _con) throws Exception {
        ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from navidad where nombre=\"PrimerPremio\" or nombre=\"SegundoPremio\" or nombre=\"TercerPremio\" or nombre=\"CuartoPremio\" or nombre=\"QuintoPremio\" or nombre=\"Pedrea\" or nombre=\"PrimerPremioAprox\" or nombre=\"SegundoPremioAprox\" or nombre=\"TercerPremioAprox\" order by premios desc, historico asc;");
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            while (rs.next()) {
                _numeros = new Navidad();
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
}
