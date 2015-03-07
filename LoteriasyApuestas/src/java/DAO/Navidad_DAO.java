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
    public ArrayList<Navidad> comprobarNumero(Connection con, String fecha, int numero) throws Exception {
         ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM navidad where numero=? and historico=?");
            stmt.setInt(1, numero);
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
     * Metodo que recupera lista de premios importantes 
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
        numeros.setNumero(rs.getString("numero"));
        numeros.setNombre(rs.getString("nombre"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getInt("premios"));
        return numeros;
    }
}
