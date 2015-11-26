/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import datos.conexion;
import java.sql.*;

/**
 *
 * @author hernan
 */
public class Cliente {
   
    public String rutCliente;
    public String nombreCliente;
    public int edadCliente;

    public Cliente(String rutCliente, String nombreCliente, int edadCliente) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
    }
    
    public void imprimirCliente()
    {
        System.out.println("Rut Cliente: "+this.rutCliente);
        System.out.println("Nombre Cliente: "+this.nombreCliente);
        System.out.println("Edad Cliente: "+this.edadCliente);
    }
    
    
    public void cargarRutCliente()
    {
        try{
            conexion.buscaRutCli=false;
            String strSql="select * from cliente where rutCliente='"+rutCliente+"'";
            conexion.conectar();
            conexion.setencia=conexion.conn.prepareStatement(strSql);
            ResultSet objRes=conexion.setencia.executeQuery(strSql);
            if (objRes.next()){
                conexion.buscaRutCli=true;
                rutCliente=objRes.getString(1);
                nombreCliente=objRes.getString(2);
                edadCliente=Integer.parseInt(objRes.getString(3));
            }
            conexion.desconectar();
        }
        catch(Exception e){
            System.out.println("Error de metodo buscar cliente");
        }
    }
    
    public void guardar()
    {
        try{
            
            String srtSql = "insert into cliente values('"+rutCliente+"','"+nombreCliente+"',"+edadCliente+")";
            conexion.conectar();
            conexion.setencia=conexion.conn.prepareStatement(srtSql);
            conexion.setencia.execute(srtSql);
            System.out.println("Datos Almacenados");
            conexion.desconectar();
        }               
        catch(Exception e)
        {
            System.out.println("Error de metodo guardar");   
        }
    }
    
    public void actualizar()
    {
        try{
            
            String strSql="update cliente set nombreCliente='"+nombreCliente+"',"
                    + "edadCliente="+edadCliente+" where rutCliente='"+rutCliente+"'";
            conexion.conectar();
            conexion.setencia=conexion.conn.prepareStatement(strSql);
            conexion.setencia.execute(strSql);
            System.out.println("Cliente actualizado");
            conexion.desconectar();
            
        }catch(Exception e){
            System.out.println("Error de metodo actualizar");
        }
    }
    
    
    public void borrar()
    {
        try{
            
            String strSql="delete from cliente where rutCliente='"+rutCliente+"'";
            conexion.conectar();
            conexion.setencia=conexion.conn.prepareStatement(strSql);
            conexion.setencia.execute(strSql);
            System.out.println("Cliente eliminado");
            conexion.desconectar();
            
        }catch(Exception e){
            System.out.println("Error de metodo borrar");
        }
    }
    
}
