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
import logica.Cliente;

/**
 *
 * @author kjan
 */
public class DBCliente {
    DBConexion cn;
    
    public DBCliente() {
        cn = new DBConexion();
    }
    public ResultSet getClienteById(int k_num_documento,String k_tipo_documento) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + "SELECT * FROM cliente "
                + "WHERE  k_num_documento = ? AND k_tipo_documento = ?");
       
        pstm.setInt(1, k_num_documento);
        pstm.setString(2, k_tipo_documento);
        

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    public ResultSet getCliente() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement(" "
                + " SELECT * FROM cliente "
                + " ORDER BY k_tipo_documento, k_num_documento");
        ResultSet res = pstm.executeQuery();
        return res;
    }
  
    public void insertarCliente(Cliente c) {
        
        Date date = new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("INSERT INTO cliente ("
                    + " k_num_documento,"
                    + "k_tipo_documento,"
                    + " n_primer_nombre,"
                    + " n_segundo_nombre,"
                    + "n_primer_apellido,"
                    + "n_segundo_apellido,"
                    + "o_genero,"
                    + "f_nacimiento,"
                    +"n_correo"
                    + " values(?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, c.getK_num_documento());
            pstm.setString(2, c.getK_tipo_documento());
            pstm.setString(3, c.getN_primer_nombre());
            pstm.setString(4, c.getN_segundo_nombre());
            pstm.setString(5, c.getN_primer_apellido());
            pstm.setString(6, c.getN_segundo_apellido());
            pstm.setString(7, c.getO_genero());
            pstm.setString(8, c.getF_nacimiento());
            pstm.setString(9, c.getN_correo());
            

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
     public void actualizarCliente(Cliente c) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE cliente"
                    + " SET k_cliente = ?, "
                    + " k_num_documento = ?,"
                    + " k_tipo_documento = ? "
                    + " n_primer_nombre= ? "
                    + " n_segundo_nombre= ? "
                    + "n_primer_apellido= ? "
                    + "n_segundo_apellido= ? "
                    + "o_genero= ? "
                    + "f_nacimiento= ? "
                    + "n_correo= ? "
                    + " WHERE  k_num_documento = ? AND k_tipo_documento = ?");
            pstm.setInt(1, c.getK_num_documento());
            pstm.setString(2, c.getK_tipo_documento());
            pstm.setString(3, c.getN_primer_nombre());
            pstm.setString(4, c.getN_segundo_nombre());
            pstm.setString(5, c.getN_primer_apellido());
            pstm.setString(6, c.getN_segundo_apellido());
            pstm.setString(7, c.getO_genero());
            pstm.setString(8, c.getF_nacimiento());
            pstm.setString(9, c.getN_correo());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
     public void borrarCliente(Cliente c) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM cliente "
                    + "WHERE  k_num_documento = ? AND k_tipo_documento = ?");

            pstm.setInt(1, c.getK_num_documento());
            pstm.setString(2, c.getK_tipo_documento());
            pstm.setString(3, c.getN_primer_nombre());
            pstm.setString(4, c.getN_segundo_nombre());
            pstm.setString(5, c.getN_primer_apellido());
            pstm.setString(6, c.getN_segundo_apellido());
            pstm.setString(7, c.getO_genero());
            pstm.setString(8, c.getF_nacimiento());
            pstm.setString(9, c.getN_correo());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }
     public String getMensaje() {
        return cn.getMensaje();
    }
}
