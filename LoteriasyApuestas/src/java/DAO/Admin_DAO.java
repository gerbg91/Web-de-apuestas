/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class Admin_DAO {
    
/**
 * Metodo que verifica el usuario
 * 
 * @param _con
 * @param _usuario
 * @return
 * @throws Exception 
 */
    public ArrayList<Administrador> verificarUsuario(Connection _con, String _usuario) throws Exception {
         ArrayList<Administrador> _administrador = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("SELECT CAST(AES_DECRYPT(texto_encriptado, 'llave') as char(50)) as pass FROM usuario where usu=?");
            stmt.setString(1, _usuario);
            rs = stmt.executeQuery();
            Administrador _admin = null;
             while (rs.next()) {
                _admin = new Administrador();
                _administrador.add(obtenNumeros(rs, _admin));
            }
        } catch (SQLException ex) {
            throw new Exception("Ha habido un problema al verificar el usuario en la BD " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return _administrador;
    }
    
      /**
     * Metodo que setea las propiedades del admin
     *
     * @param rs
     * @param numeros
     * @return
     * @throws SQLException
     */
    private Administrador obtenNumeros(ResultSet rs, Administrador admin) throws SQLException {
        admin.setPass_mysql(rs.getString("pass"));
        return admin;
    }
    }
   
