/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Admin_DAO;
import DAO.Connection_DB;
import Entidades.Administrador;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Ger
 */
public class AdminBLL {

    public boolean comprobarUsuarioBLL(String _usuario, String _password) {
      boolean _entrada = false;
      ArrayList<Administrador> _admin;
        Connection _con;
        try {
            Connection_DB _conexion_DB = new Connection_DB();
            _con = _conexion_DB.AbrirConexion();
            Admin_DAO _adminDAO = new Admin_DAO();
            _admin = _adminDAO.verificarUsuario(_con,_usuario);
            
            if(!_admin.isEmpty()){
                if(_admin.get(0).getPass_mysql().equalsIgnoreCase(_password)){_entrada=true;}
            }
            
            _conexion_DB.CerrarConexion(_con);
        } catch (Exception ex) {
            System.out.println("Excepcion->" + ex.getMessage());
        }
        return _entrada;
    }
    }
    

