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
import logica.Trayecto;

/**
 *
 * @author kjan
 */
public class DBTrayecto {
    
    DBConexion cn;
    
    public DBTrayecto() {
        cn = new DBConexion();
    }

    public ResultSet getTrayectoById(int k_id_trayecto, int k_id_tipo_servicio,int K_id_servicio) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM trayecto "
                + "WHERE k_id_trayecto = ? AND k_id_tipo_servicio = ? AND k_id_servicio = ?");
        pstm.setInt(1, k_id_trayecto);
        pstm.setInt(2, k_id_tipo_servicio);
        pstm.setInt(3, K_id_servicio);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getTrayecto() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM trayecyo "
                + " ORDER BY k_id_trayecto, k_id_tipo_servicio,K_id_servicio");
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarTrayecto(Trayecto y) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO trayecto ("
                    + " k_id_trayecto,"
                    + " d_dir_origen, "
                    + " d_dir_destino) "
                    + " K_id_servicio, "
                    + "k_id_tipo_servicio"
                    + " values(?,?,?)");
            pstm.setInt(1, y.getK_id_trayecto());   
            pstm.setString(2, y.getD_dir_origen());
            pstm.setString(3, y.getD_dir_destino());
            pstm.setInt(4, y.getK_id_servicio());
            pstm.setInt(5, y.getK_id_tipo_servicio());
            

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarTrayecto(Trayecto y) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE trayecto"
                    + " SET k_id_trayecto = ?, "
                    + " d_dir_origen = ?,"
                    + " d_dir_destino = ? "
                    + " K_id_servicio = ? "
                    + " k_id_tipo_servicio = ? "
                    + " WHERE k_id_trayecto = ? AND k_id_tipo_servicio = ? AND k_id_servicio = ?");
            pstm.setInt(1, y.getK_id_trayecto());   
            pstm.setString(2, y.getD_dir_origen());
            pstm.setString(3, y.getD_dir_destino());
            pstm.setInt(4, y.getK_id_servicio());
            pstm.setInt(5, y.getK_id_tipo_servicio());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarTrayecto(Trayecto y) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM trayecto "
                    + "WHERE k_id_trayecto = ? AND k_id_tipo_servicio = ? AND k_id_servicio = ?");

            pstm.setInt(1, y.getK_id_trayecto());   
            pstm.setString(2, y.getD_dir_origen());
            pstm.setString(3, y.getD_dir_destino());
            pstm.setInt(4, y.getK_id_servicio());
            pstm.setInt(5, y.getK_id_tipo_servicio());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}
    
