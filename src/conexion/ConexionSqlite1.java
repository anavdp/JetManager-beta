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
import java.sql.*;


public class ConexionSqlite1
{   
    
         public  Connection Enlace(){
       
       Connection connection=null;     
       try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\\\Users\\\\Vicky\\\\Documents\\\\NetBeansProjects\\\\JetManager\\\\JetManager_backup.db" );
        }
        catch (Exception e){
            System.err.println(e.getMessage());           
        }
        
         return connection;
}
    //Para los insert, update, delete
         public static boolean ejecutar(String sql){
             ConexionSqlite1 con= new ConexionSqlite1();
             Connection connection= con.Enlace();
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
       ConexionSqlite1 con= new ConexionSqlite1();
       Connection c= con.Enlace();
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
         
}
             
         