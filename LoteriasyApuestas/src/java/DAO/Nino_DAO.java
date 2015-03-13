/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Nino;
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
public class Nino_DAO {

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
    public ArrayList<Nino> comprobarNumero(Connection con, String fecha, int numero) throws Exception {
         ArrayList<Nino> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM nino where numero=? and historico=?");
            stmt.setInt(1, numero);
            stmt.setString(2,fecha);
            rs = stmt.executeQuery();
            Nino _numeros = null;
            Nino numeroPremiado = new Nino();
            while (rs.next()) {
                 _numeros = new Nino();
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
     * Metodo que recupera lista de premios importantes 
     *
     * @param con
     * @param fecha
     * @return
     * @throws Exception
     */
    public ArrayList<Nino> listaPremiosSecundarios(Connection con, String fecha) throws Exception {
        ArrayList<Nino> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from nino where (nombre=\"TerminacionCuatroCifras\" or nombre=\"TerminacionTresCifras\" or nombre=\"TerminacionDosCifras\" or nombre=\"TerminacionUltimaCifra\" or nombre=\"PrimeraCifra\" or nombre=\"TerminacionUltimaCifra\") and historico=?");
            stmt.setString(1,fecha);
            rs = stmt.executeQuery();
            Nino _numeros = null;
            while (rs.next()) {
                _numeros = new Nino();
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
    private Nino obtenNumeros(ResultSet rs, Nino numeros) throws SQLException {
        numeros.setNumero(rs.getString("numero"));
        numeros.setNombre(rs.getString("nombre"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getInt("premios"));
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
     * @return
     * @throws Exception 
     */
    public boolean insertarNumero(Connection _con, int numero, float cantidadPremio, String fecha, String TipoPremio) throws Exception {  
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("INSERT INTO nino (numero,nombre, historico ,premios) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,Integer.toString(numero));
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
        return false;
    }
}

