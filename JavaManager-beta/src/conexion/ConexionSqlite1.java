/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package conexion;
import java.io.Serializable;
import java.sql.*;
import java.util.ResourceBundle;


public class ConexionSqlite1 implements Serializable 
{   private static String driver;
    private static String url;
    private static String nombreBd;
    private static String usuario;
    private static String password;
    private static String archivoProperties;
    private static Connection conexion;
    private static ConexionSqlite1 instancia = null;
    
     public static void establecerPropiedadesConexion(String driver, String url, String nombreBd, String usuario, String password) {
        ConexionSqlite1.driver = driver;
        ConexionSqlite1.url = url;
        ConexionSqlite1.nombreBd = nombreBd;
        ConexionSqlite1.usuario = usuario;
        ConexionSqlite1.password = password;
    }

    public static void establecerPropiedadesConexion(String archivoProperties, String driver, String url, String nombreBd, String usuario, String password) {
        ResourceBundle bundle = ResourceBundle.getBundle(archivoProperties);
        ConexionSqlite1.driver = bundle.getString(driver);
        ConexionSqlite1.url = bundle.getString(url);
        ConexionSqlite1.nombreBd = bundle.getString(nombreBd);
        ConexionSqlite1.usuario = bundle.getString(usuario);
        ConexionSqlite1.password = bundle.getString(password);
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConexionSqlite1.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConexionSqlite1.url = url;
    }

    public static String getNombreBd() {
        return nombreBd;
    }

    public static void setNombreBd(String nombreBd) {
        ConexionSqlite1.nombreBd = nombreBd;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConexionSqlite1.usuario = usuario;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConexionSqlite1.password = password;
    }
    
    
         public  Connection Enlace(){
       
       Connection connection=null;     
       try
        {
            Class.forName("org.sqlite.JDBC");
            //Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ABUNASSAR PENARANDA\\Desktop\\Semestre VI\\Laboratorio I\\Proyecto\\JetManager_backup.db" );
               // connection = DriverManager.getConnection(String.valueOf(url) + nombreBd, usuario, password);
        }
        catch (Exception e){
            System.err.println(e.getMessage());           
        }
        
         return connection;
}
         
           private synchronized static void createInstancia() {
        if (instancia == null) {
            instancia = new ConexionSqlite1();
        }
    }
           
         public static ConexionSqlite1 getInstancia(){
             if (instancia == null) createInstancia();
        return instancia;
         
         }
    //Para los insert, update, delete
         public static boolean ejecutar(String sql){
             //ConexionSqlite1 con= new ConexionSqlite1();
             Connection connection= getInstancia().Enlace(); //con.Enlace();
             Statement stm;
                       try{
           stm = connection.createStatement();
           stm.executeUpdate(sql);
           stm.close();
           connection.close();
           return true;
          }catch(Exception e){
            System.err.println(e.getMessage()); 
          return false;
          }
         }
 //Para los select
         public static ResultSet consultar(String sql){
      // ConexionSqlite1 con= new ConexionSqlite1();
       Connection c= getInstancia().Enlace(); //con.Enlace();
        Statement stmt = null;
        ResultSet rs= null;
    try {
        
      stmt = c.createStatement();
      rs = stmt.executeQuery( sql );
      //stmt.close();
      //c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
 return rs;
  }

    private ConexionSqlite1() {
    }
        
         
}
             
         