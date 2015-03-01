/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Navidad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public float comprobarNumero(Connection con, Date fecha, int numero) throws Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT premios FROM navidad where numero=?");
            //stmt.setDate(1,fecha);
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            Navidad _numeros = null;
            while (rs.next()) {
                _numeros = new Navidad();
                _numeros.setPremios(rs.getFloat("premios"));
            }
            return _numeros.getPremios();
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
        numeros.setNumero(rs.getInt("numero"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getInt("premios"));
        return numeros;
    }
}
