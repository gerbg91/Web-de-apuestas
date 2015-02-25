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
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class Navidad_DAO {

    /**
     * Metdo que recupera la lista de los numeros premiados
     *
     * @param con
     * @param fecha
     * @return 
     * @throws Exception
     */
    public ArrayList<Navidad> listadoNumeros(Connection con, Date fecha) throws Exception {
        ArrayList<Navidad> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM navidad where historico=?");
            stmt.setDate(1,fecha);
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
        numeros.setNumero(rs.getInt("numero"));
        numeros.setFecha(rs.getDate("historico"));
        numeros.setPremios(rs.getInt("premios"));
        return numeros;
    }
}
