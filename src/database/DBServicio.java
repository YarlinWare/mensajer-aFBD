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
import logica.Servicio;

/**
 *
 * @author kjan
 */
public class DBServicio {
    
     DBConexion cn;
    
    public DBServicio() {
        cn = new DBConexion();
    }
    public ResultSet getServicioById(int k_id_servicio,int k_id_tipo_paquete,int k_num_documento_usuario,String k_tipo_documento_usuario,int k_num_documento_mensajero,String k_tipo_documento_mensajero) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM servicio "
                + "WHERE  k_id_servicio = ? AND k_id_tipo_paquete = ? k_num_documento_usuario = ? AND k_tipo_documento_usuario = ? k_num_documento_mensajero = ? AND k_tipo_documento_mensajero = ?");
       
        pstm.setInt(1,k_id_servicio);
        pstm.setInt(2,k_id_tipo_paquete);
        pstm.setInt(3,k_num_documento_usuario);
        pstm.setString(4, k_tipo_documento_usuario);
        pstm.setInt(5,k_num_documento_mensajero);
        pstm.setString(6, k_tipo_documento_mensajero);
        

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    public ResultSet getCliente() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM servicio "
                + " ORDER BY k_tipo_documento, k_num_documento");
        ResultSet res = pstm.executeQuery();
        return res;
    }
  
    public void insertarServicio(Servicio s) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO cliente ("
                    + " k_id_servicio,"
                    + "k_id_tipo_paquete,"
                    + " k_num_documento_usuario,"
                    + " k_tipo_documento_usuario,"
                    + "k_num_documento_mensajero,"
                    + "k_tipo_documento_mensajero,"
                    + "f_fecha,"
                    + "f_hora,"
                    +"v_valor_servicio"
                    + " values(?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, s.getK_id_servicio());
            pstm.setInt(2, s.getK_id_tipo_paquete());
            pstm.setInt(3, s.getK_num_documento_usuario());
            pstm.setString(4, s.getK_tipo_documento_usuario());
            pstm.setInt(5, s.getK_num_documento_mensajero());
            pstm.setString(6, s.getK_tipo_documento_mensajero());
            pstm.setString(7, s.getF_fecha());
            pstm.setString(8, s.getF_hora());
            pstm.setInt(9, s.getV_valor_servicio());
            

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
     public void actualizarServicio(Servicio s) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE servicio"
                    + " SET k_id_servicio = ?, "
                    + " k_id_tipo_paquete = ?,"
                    + " k_num_documento_usuario = ? "
                    + " k_tipo_documento_usuario= ? "
                    + " k_num_documento_mensajero= ? "
                    + "k_tipo_documento_mensajero= ? "
                    + "f_fecha= ? "
                    + "f_hora= ? "
                    + "v_valor_servicio= ? "
                    + " WHERE  k_id_servicio = ? AND k_id_tipo_paquete = ? k_num_documento_usuario = ? AND k_tipo_documento_usuario = ? k_num_documento_mensajero = ? AND k_tipo_documento_mensajero = ?");
            pstm.setInt(1, s.getK_id_servicio());
            pstm.setInt(2, s.getK_id_tipo_paquete());
            pstm.setInt(3, s.getK_num_documento_usuario());
            pstm.setString(4, s.getK_tipo_documento_usuario());
            pstm.setInt(5, s.getK_num_documento_mensajero());
            pstm.setString(6, s.getK_tipo_documento_mensajero());
            pstm.setString(7, s.getF_fecha());
            pstm.setString(8, s.getF_hora());
            pstm.setInt(9, s.getV_valor_servicio());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
     public void borrarServicio(Servicio s) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM cliente "
                    + "WHERE  k_id_servicio = ? AND k_id_tipo_paquete = ? k_num_documento_usuario = ? AND k_tipo_documento_usuario = ? k_num_documento_mensajero = ? AND k_tipo_documento_mensajero = ?");

             pstm.setInt(1, s.getK_id_servicio());
            pstm.setInt(2, s.getK_id_tipo_paquete());
            pstm.setInt(3, s.getK_num_documento_usuario());
            pstm.setString(4, s.getK_tipo_documento_usuario());
            pstm.setInt(5, s.getK_num_documento_mensajero());
            pstm.setString(6, s.getK_tipo_documento_mensajero());
            pstm.setString(7, s.getF_fecha());
            pstm.setString(8, s.getF_hora());
            pstm.setInt(9, s.getV_valor_servicio());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }
     public String getMensaje() {
        return cn.getMensaje();
    }
}
    

