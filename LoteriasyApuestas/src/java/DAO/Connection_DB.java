/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ger
 */
public class Connection_DB {

    /**
     * Metodo que abre la conexion con la base de datos
     * 
     * @return
     * @throws Exception 
     */
    public Connection AbrirConexion() throws Exception {
        Connection con;  
        try {
            Class.forName("com.mysql.jdbc.Driver");  // Cargar el driver
            String urlOdbc = "jdbc:mysql://localhost:3306/loteriasDB";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "root"));  
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        }
    }

    /**
     * Metodo para cerrar conexion
     *
     * @param con
     * @throws Exception
     */
    public void CerrarConexion(Connection con) throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new Exception("Ha sido imposible cerrar la conexion" + e.getMessage());
        }
    }
}
