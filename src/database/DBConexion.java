/*
 * DBConexion.java
 * 
 * Created on 7/04/2008, 10:01:58 PM
 * 
 */

package database;


import java.sql.*;
/**
 * Clase que permite conectar con mysql
 * @author alejo
 */
public class DBConexion {
    static String bd = "mensajeria_fbd_aws";
    static String login = "postgres";
    static String password = "mensajeria#2020";
    static String url = "jdbc:postgresql://mensajeriafbd.csvkszv7bls2.us-east-1.rds.amazonaws.com:5432/mensajeria_fbd_aws";
    static String mensaje = "";
    
    public Connection conexion = null;
    /**
     * Constructor de la clase
     */
    public DBConexion() {
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
    
    /**
     * Metodo para retornar mensajes de control
     * @return 
     */
    public static String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo para setear mensajes de control
     * @param mensaje 
     */
    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }
     
    /**
     * metodo que retorna la conexion a la bd
     * @return 
     */
    public Connection getConexion(){
        return conexion;
    }

    /**
     * metodo que desconecta la base de datos
     */
    public void desconectar(){
        conexion = null;
    }

}
