/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//**
 /*Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
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
    private ConexionSqlite1 con = ConexionSqlite1.getInstancia();

    
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
        
        return con.ejecutar(sql);
    }
         
  public boolean EliminarDiaFeriado(MDiaFeriado dia)
  {
      
      sql = "DELETE FROM TDiaFeriado ";
      
      sql = sql + " WHERE DFFecha='" + dia.getFecha() + "'";
      
      return con.ejecutar(sql);
  }
    
  public ResultSet ObtenerDiasParaTablaMensual(MDiaFeriado dia) //throws ClassNotFoundException
  {
      sql = "SELECT DFFecha, DFDescripcion FROM TDiaFeriado WHERE DFMes=" + dia.getMes();
      sql = sql + " AND DFAnio=" + dia.getAnio();
      
      r = con.consultar(sql);

      return r;
  }
  
  public ResultSet BuscarFecha(MDiaFeriado dia)
  {
      sql = "SELECT DFDescripcion FROM TDiaFeriado WHERE DFFecha='" + dia.getFecha() + "'";
      sql = sql + " AND DFEstatus='" + dia.getEstatus() + "'";
      
      r = con.consultar(sql);
      
      return r;
  }
}
