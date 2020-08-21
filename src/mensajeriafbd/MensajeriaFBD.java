/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeriafbd;

import database.DBConexion;
import database.DBTelefono;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class MensajeriaFBD {

    /**
     * @param args the command line arguments
     */
    static String bd = "mensajeria_fbd_aws";
    static String login = "postgres";
    static String password = "mensajeria#2020";
    static String url = "jdbc:postgresql://mensajeriafbd.csvkszv7bls2.us-east-1.rds.amazonaws.com:5432/mensajeria_fbd_aws";
    static String mensaje = "";
    Connection conexion = null;
    public MensajeriaFBD() {
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,login,password);

            if (conexion!=null){
                    System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(SQLException e){
                mensaje = e.getMessage();
        }catch(ClassNotFoundException e){
                mensaje = e.getMessage();
        }
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        MensajeriaFBD cn = new MensajeriaFBD();
        Statement st;
        ResultSet rs;
        
        try {
            st = cn.conexion.createStatement();
            rs = st.executeQuery("select * from cliente");
            while(rs.next()){
                System.out.println(rs.getString("n_primer_nombre"));
            }
            cn.conexion.close();
        } catch (Exception e) {
        }
        
    }
    
}
