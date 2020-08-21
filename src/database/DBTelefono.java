/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import logica.Telefono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DBTelefono {
    
    DBConexion cn;
    
    public DBTelefono() {
        cn = new DBConexion();
    }

    public ResultSet getTelefonoById(int k_telefono, int k_num_documento, String k_tipo_documento) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM telefono "
                + "WHERE k_telefono = ? AND k_num_documento = ? AND k_tipo_documento = ?");
        pstm.setInt(1, k_telefono);
        pstm.setInt(2, k_num_documento);
        pstm.setString(3, k_tipo_documento);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getTelefono() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM telefono "
                + " ORDER BY k_tipo_documento, k_num_documento, k_telefono");
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarTelefono(Telefono t) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO telefono ("
                    + " k_telefono,"
                    + " k_num_documento, "
                    + " k_tipo_documento) "
                    + " values(?,?,?)");
            pstm.setInt(1, t.getK_telefono());
            pstm.setInt(2, t.getK_num_documento());
            pstm.setString(3, t.getK_tipo_documento());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarTelefono(Telefono t) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE telefono"
                    + " SET k_telefono = ?, "
                    + " k_num_documento = ?,"
                    + " k_tipo_documento = ? "
                    + " WHERE k_telefono = ? AND k_num_documento = ? AND k_tipo_documento = ?");
            pstm.setInt(1, t.getK_telefono());
            pstm.setInt(2, t.getK_num_documento());
            pstm.setString(3, t.getK_tipo_documento());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarTelefono(Telefono t) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM telefono "
                    + "WHERE k_telefono = ? AND k_num_documento = ? AND k_tipo_documento = ?");

            pstm.setInt(1, t.getK_telefono());
            pstm.setInt(2, t.getK_num_documento());
            pstm.setString(3, t.getK_tipo_documento());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}
