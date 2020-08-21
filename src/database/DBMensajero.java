/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import logica.Mensajero;

/**
 *
 * @author kjan
 */
public class DBMensajero {
    DBConexion cn;
    
    public DBMensajero() {
        cn = new DBConexion();
    }
    public ResultSet getMensajeroById(int k_num_documento,String k_tipo_documento) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM mensajero "
                + "WHERE  k_num_documento = ? AND k_tipo_documento = ?");
       
        pstm.setInt(1, k_num_documento);
        pstm.setString(2, k_tipo_documento);
        

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    public ResultSet getMensajero() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM mensajero "
                + " ORDER BY k_tipo_documento, k_num_documento");
        ResultSet res = pstm.executeQuery();
        return res;
    }
  
    public void insertarMensajero(Mensajero m) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO mensajero ("
                    + " k_num_documento,"
                    + "k_tipo_documento,"
                    + " n_primer_nombre,"
                    + " n_segundo_nombre,"
                    + "n_primer_apellido,"
                    + "n_segundo_apellido,"
                    +"q_tefefono,"
                    + "o_genero,"
                    + "f_nacimiento,"
                    +"d_dir,"
                    +"q_num_seguridad_social,"
                    +"o_medio_transporte"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, m.getK_num_documento());
            pstm.setString(2, m.getK_tipo_documento());
            pstm.setString(3, m.getN_primer_nombre());
            pstm.setString(4, m.getN_segundo_nombre());
            pstm.setString(5, m.getN_primer_apellido());
            pstm.setString(6, m.getN_segundo_apellido());
            pstm.setString(7, m.getQ_tefefono());
            pstm.setString(8, m.getO_genero());
            pstm.setString(9, m.getF_nacimiento());
            pstm.setString(10, m.getD_dir());
            pstm.setInt(11, m.getQ_num_seguridad_social());
            pstm.setString(12, m.getO_medio_transporte());
            

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
     public void actualizarMensajero(Mensajero m) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE mensajero"
                    + " SET k_num_documento = ?,"
                    + " k_tipo_documento = ? "
                    + " n_primer_nombre= ? "
                    + " n_segundo_nombre= ? "
                    + "n_primer_apellido= ? "
                    + "n_segundo_apellido= ? "
                    +"q_tefefono = ?"
                    + "o_genero = ?"
                    + "f_nacimiento = ?"
                    +"d_dir = ?"
                    +"q_num_seguridad_social = ? "
                    +"o_medio_transporte = ?"
                    + " WHERE  k_num_documento = ? AND k_tipo_documento = ?");
            pstm.setInt(1, m.getK_num_documento());
            pstm.setString(2, m.getK_tipo_documento());
            pstm.setString(3, m.getN_primer_nombre());
            pstm.setString(4, m.getN_segundo_nombre());
            pstm.setString(5, m.getN_primer_apellido());
            pstm.setString(6, m.getN_segundo_apellido());
            pstm.setString(7, m.getQ_tefefono());
            pstm.setString(8, m.getO_genero());
            pstm.setString(9, m.getF_nacimiento());
            pstm.setString(10, m.getD_dir());
            pstm.setInt(11, m.getQ_num_seguridad_social());
            pstm.setString(12, m.getO_medio_transporte());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
     public void borrarMensajero(Mensajero m) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM mensajero "
                    + "WHERE  k_num_documento = ? AND k_tipo_documento = ?");

            pstm.setInt(1, m.getK_num_documento());
            pstm.setString(2, m.getK_tipo_documento());
            pstm.setString(3, m.getN_primer_nombre());
            pstm.setString(4, m.getN_segundo_nombre());
            pstm.setString(5, m.getN_primer_apellido());
            pstm.setString(6, m.getN_segundo_apellido());
            pstm.setString(7, m.getQ_tefefono());
            pstm.setString(8, m.getO_genero());
            pstm.setString(9, m.getF_nacimiento());
            pstm.setString(10, m.getD_dir());
            pstm.setInt(11, m.getQ_num_seguridad_social());
            pstm.setString(12, m.getO_medio_transporte());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }
     public String getMensaje() {
        return cn.getMensaje();
    }
}
    
