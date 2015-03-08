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
     * @param numero
     * @return
     * @throws Exception
     */
    public ArrayList<Cupon> comprobarNumero(Connection con, String fecha, int numero) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cupon");
            //stmt.setString(2, fecha);
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
     * Metodo que setea las propiedades de los numeros
     *
     * @param rs
     * @param numeros
     * @return
     * @throws SQLException
     */
    private Cupon obtenNumeros(ResultSet rs, Cupon numeros) throws SQLException {
        numeros.setNumero(rs.getString("numero"));
        numeros.setSerie(rs.getString("serie"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getInt("premios"));
        return numeros;
    }
}
