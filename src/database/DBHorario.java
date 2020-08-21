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
import logica.Horario;

/**
 *
 * @author kjan
 */
public class DBHorario {
    
     DBConexion cn;
    
    public DBHorario() {
        cn = new DBConexion();
    }

    public ResultSet getHorarioById(int k_id_horario, int k_num_documento, String k_tipo_documento) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM horario "
                + "WHERE k_id_horario = ? ");
        pstm.setInt(1, k_id_horario);
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
    public ResultSet getHorario() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM horario "
                + " ORDER BY k_tipo_documento, k_num_documento, k_id_horario");
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarHorario(Horario h) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO horario ("
                    + "k_id_horario,"
                    + "k_num_documento,"
                    + "k_tipo_documento,"
                    + "o_hora_inicio,"
                    + "o_hora_final,"
                    + " n_dia"
                    + " values(?,?,?,?,?,?)");
            pstm.setString(1, h.getK_id_horario());
            pstm.setInt(2, h.getK_num_documento());
            pstm.setString(4, h.getK_tipo_documento());
            pstm.setString(5, h.getO_hora_inicio());
            pstm.setString(6, h.getO_hora_final());
            pstm.setString(7, h.getN_dia());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarHorario(Horario h) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE horario"
                    + " SET k_id_horario = ?, "
                    + " k_num_documento = ?,"
                    + " k_tipo_documento = ? "
                    + "o_hora_inicio = ?"
                    + "o_hora_final = ? "
                    + " n_dia = ? "
                    + " WHERE k_id_horario = ? AND k_num_documento = ? AND k_tipo_documento = ?");
            pstm.setString(1, h.getK_id_horario());
            pstm.setInt(2, h.getK_num_documento());
            pstm.setString(4, h.getK_tipo_documento());
            pstm.setString(5, h.getO_hora_inicio());
            pstm.setString(6, h.getO_hora_final());
            pstm.setString(7, h.getN_dia());

            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarHorario(Horario h) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM horario "
                    + "WHERE k_telefono = ? AND k_num_documento = ? AND k_tipo_documento = ?");

            pstm.setString(1, h.getK_id_horario());
            pstm.setInt(2, h.getK_num_documento());
            pstm.setString(4, h.getK_tipo_documento());
            pstm.setString(5, h.getO_hora_inicio());
            pstm.setString(6, h.getO_hora_final());
            pstm.setString(7, h.getN_dia());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}
    

