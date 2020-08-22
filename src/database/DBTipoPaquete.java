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
import logica.TipoPaquete;

/**
 *
 * @author kjan
 */
public class DBTipoPaquete {
     DBConexion cn;
    
    public DBTipoPaquete() {
        cn = new DBConexion();
    }
    public ResultSet getTipoPaqueteById(int k_id_tipo_paquete,int k_id_servicio) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM TipoPaqquete "
                + "WHERE  k_id_tipo_paquete = ? AND k_id_servicio = ?");
       
        pstm.setInt(1, k_id_tipo_paquete);
        pstm.setInt(2, k_id_servicio);
        

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    public ResultSet getTipoPaquete() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM TipoPaquete "
                + " ORDER BY k_id_tipo_paquete, k_id_servicio");
        ResultSet res = pstm.executeQuery();
        return res;
    }
  
    public void insertarTipoPaquete(TipoPaquete y) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO TipoPaquete ("
                    + " k_id_tipo_paquete,"
                    + "k_id_servicio,"
                    + " o_descripcion,"
                    + " n_tipo,"
                    + " values(?,?,?,?)");
     
                
            pstm.setInt(1, y.getK_id_tipo_paquete());
            pstm.setInt(2, y.getK_id_servicio());
            pstm.setString(3, y.getO_descripcion());
            pstm.setString(4, y.getO_descripcion());
          
            

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
     public void actualizarTipoPaquete(TipoPaquete y) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE TipoPaquete"
                    + " SET k_id_tipo_paquete = ?, "
                    + " k_id_servicio = ?,"
                    + " o_descripcion = ? "
                    + " n_tipo= ? "
                   
                    + " WHERE  k_id_tipo_paquete = ? AND k_id_servicio = ?");
            pstm.setInt(1, y.getK_id_tipo_paquete());
            pstm.setInt(2, y.getK_id_servicio());
            pstm.setString(3, y.getO_descripcion());
            pstm.setString(4, y.getO_descripcion());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
     public void borrarTipoPaquete(TipoPaquete y) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM cliente "
                    + "WHERE  k_id_tipo_paquete = ? AND k_id_servicio = ?");

            pstm.setInt(1, y.getK_id_tipo_paquete());
            pstm.setInt(2, y.getK_id_servicio());
            pstm.setString(3, y.getO_descripcion());
            pstm.setString(4, y.getO_descripcion());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }
     public String getMensaje() {
        return cn.getMensaje();
    }
}   
