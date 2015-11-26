/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Statement;
import java.sql.*;


/**
 *
 * @author hernan
 */
public class conexion {
    
    public static String bd="automotora";
    public static String login="root";
    public static String pass = "root";
    
    public static String url="jdbc:mysql://localhost/"+bd;
    public static Connection conn;
    public static Statement setencia;
    
    public static boolean buscaRutCli;
    
    public String saludo="hola";
    
    public static void conectar()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,login,pass);
            if (conn != null)
            {
                System.out.println("conexion establecida con "+bd);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Hubo un problema al conectarse");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
        
    }
    
    public static void desconectar() throws SQLException 
    {
        conn.close();
               
    }
    
    
}
