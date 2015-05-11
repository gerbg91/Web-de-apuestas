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
        String a[]={"CincoCifras","CincoCifrasAnterior","CincoPosterior","CuatroCifras","TresCifras","DosCifras","UltimaCifra","PrimeraCifra","Serie"};
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            for (int e=0;e<=a.length-1;e++){
            stmt = con.prepareStatement("SELECT * FROM cupon where nombre=? and  historico=?");
            stmt.setString(1, a[e]);
            stmt.setString(2, fecha);
            rs = stmt.executeQuery();
            Cupon _numeros;
            while (rs.next()) {
                _numeros = new Cupon();
                _listaNumeros.add(obtenNumeros(rs, _numeros));
            }
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
        numeros.setId_Cupon(rs.getInt("id_Cupon"));
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
     * Metodo que elimina el registro de la base de datos
     *
     * @param _con
     * @param id
     * @throws java.lang.Exception
     */
    public void eliminarNumero(Connection _con, String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("Delete from cupon where id_Cupon=?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, Integer.parseInt(id));
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
     * Metodo que busca en la base de datos por fecha para el user
     *
     * @param _con
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<Cupon> listaNumeros(Connection _con) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from cupon where nombre=\"CincoCifras\" order by historico desc;");
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
     * Metodo que busca en la base de datos por fecha para el admin
     *
     * @param _con
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<Cupon> listaNumeros_admin(Connection _con) throws Exception {
        ArrayList<Cupon> _listaNumeros = new ArrayList();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from cupon where nombre=\"CincoCifras\" or nombre=\"CincoCifrasAnterior\" or nombre=\"CincoPosterior\" or nombre=\"CuatroCifras\" or nombre=\"TresCifras\" or nombre=\"DosCifras\" or nombre=\"UltimaCifra\" or nombre=\"PrimeraCifra\" or nombre=\"Serie\" order by historico desc, premios desc, numero;");
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
     * Metodo que recupera los datos de la base de datos
     * 
     * @param _con
     * @param id_Cupon
     * @return 
     * @throws java.lang.Exception 
     */
    public Cupon datosNumero(Connection _con, String id_Cupon) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("select * from cupon where id_Cupon=?;");
            stmt.setInt(1,Integer.parseInt(id_Cupon));
            rs = stmt.executeQuery();            
            Cupon _numero = new Cupon();
           while (rs.next()) {
                 _numero.setId_Cupon(rs.getInt("id_Cupon"));
                    _numero.setNumero(rs.getString("numero"));
                  _numero.setNombre(rs.getString("nombre"));
                   _numero.setFecha(rs.getDate("historico"));
                  _numero.setPremios(rs.getFloat("premios"));
           }
              return _numero;
           
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
     * Metodo que actualiza el numero
     *
     * @param _con
     * @param numero
     * @param TipoPremio
     * @param fecha
     * @param cantidadPremio
     * @param id_Cupon
     * @throws java.lang.Exception
     */
    public void actualizarNumero(Connection _con, String numero, String TipoPremio, String fecha, float cantidadPremio, String id_Cupon) throws Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("UPDATE cupon set numero=? , nombre=?, historico=?, premios=? where id_Cupon=?",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,numero);
            stmt.setString(2,TipoPremio);
            stmt.setString(3,fecha);
            stmt.setFloat(4,cantidadPremio);
            stmt.setInt(5,Integer.parseInt(id_Cupon));
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
}
