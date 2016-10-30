/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PALACIOS
 * @author ABUNASSAR PENARANDA
 */

import modelo.MDiaFeriado;
import conexion.ConexionSqlite1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoDiaFeriado { 
    
    private String sql;
    private ResultSet r;

    
    public boolean InsetarDiaFeriado(MDiaFeriado dia) //Aquí va un throws
    {
        
        sql = "INSERT INTO TDiaFeriado (DFFecha, DFDia, DFMes, DFAnio, DFDescripcion, DFEstatus) VALUES (";
        
        sql = sql + "'" + dia.getFecha() + "',";
        sql = sql + dia.getDia() + ",";
        sql = sql + dia.getMes() + ",";
        sql = sql + dia.getAnio() + ",";
        sql = sql + "'" + dia.getDescripcion() + "',";
        sql = sql + "'" + dia.getEstatus() +"')";
        
        //Prueba
        System.out.println("Descripcion: " + dia.getDescripcion());
        System.out.println("Dia: " + dia.getDia());
        System.out.println("Mes: " + dia.getMes());
        System.out.println("Año: " + dia.getAnio());
        System.out.println("Fecha: " + dia.getFecha());
        System.out.println("Estatus: " + dia.getEstatus());
        
        return ConexionSqlite1.ejecutar(sql);
    }
         
  public boolean EliminarDiaFeriado(MDiaFeriado dia)
  {
      
      sql = "DELETE FROM TDiaFeriado ";
      
      sql = sql + " WHERE DFFecha='" + dia.getFecha() + "'";
      
      return ConexionSqlite1.ejecutar(sql);
  }
    
  public ResultSet ObtenerDiasParaTablaMensual(MDiaFeriado dia) //throws ClassNotFoundException
  {
      sql = "SELECT DFFecha, DFDescripcion FROM TDiaFeriado WHERE DFMes=" + dia.getMes();
      sql = sql + " AND DFAnio=" + dia.getAnio();
      
      r = ConexionSqlite1.consultar(sql);

      return r;
  }
  
  public ResultSet BuscarFecha(MDiaFeriado dia)
  {
      sql = "SELECT DFDescripcion FROM TDiaFeriado WHERE DFFecha='" + dia.getFecha() + "'";
      sql = sql + " AND DFEstatus='" + dia.getEstatus() + "'";
      
      r = ConexionSqlite1.consultar(sql);
      
      return r;
  }
  
  public boolean ModificarDescipcion(MDiaFeriado dia)
  {
      sql = "UPDATE TDiaFeriado SET DFDescripcion='";
      sql = sql + dia.getDescripcion() + "'";
      sql = sql + " WHERE DFFecha = '" + dia.getFecha() + "'";
      
      return ConexionSqlite1.ejecutar(sql);
  }
  
  
  //Ésto no pertenece a éste DAO, lo uso para llenar la tabla por aquí porque no me deja hacerlo directamente en la tabla
  public boolean InsertarEmpleado()
  {
     sql = "INSERT INTO TPagoMensual (PagIdEmpleado, PagFecha, PagHorasTrabajadas, PagMonto, PagMes) VALUES (10, '1992-04-10', 120, 200.2, 4)";
    return ConexionSqlite1.ejecutar(sql);
  }
}
