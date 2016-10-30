/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexion.ConexionSqlite1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import modelo.MDiaFeriado;
import modelo.MEmpleado;
import vista.VGestionHorasLaboradas;
/**
 *
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PALACIOS
 * @author ABUNASSAR PENARANDA
 * @author JESÚS RANGEL
 * 
 */
public class DaoGestionHorasLaboradas {
    private String sql;
    private ResultSet r;
    private SimpleDateFormat formatoMes;
    private SimpleDateFormat formatoAnio;
    private VGestionHorasLaboradas horas;
    
    public ResultSet BuscarRif(MEmpleado empleado)
    {
        sql = "SELECT FalIdEmpleado FROM TFalta WHERE FalIdEmpleado='";
        sql = sql + empleado.getID() + "'";
        
        r = ConexionSqlite1.consultar(sql);
        return r;
    }
    public ResultSet ObtenerFaltas(MEmpleado empleado)
    {
        sql = "SELECT FalJustidicada FROM TFalta WHERE FalJustidicada='No Justificada' AND FalIdEmpleado ='";
        sql = sql + empleado.getID() + "'";
        r = ConexionSqlite1.consultar(sql);
        return r;
    }
    
    //No me deja insertar, creo que es porque la fecha es un campo clave y no es único
   public boolean InsertarHoras(MEmpleado empleado, MDiaFeriado dia)
    {
        sql = "INSERT INTO TPagoMensual (PagIdEmpleado, PagFecha, PagHorasTrabajadas, PagMes) VALUES (";
        sql = sql + empleado.getID() + ",";
        sql = sql + "'2016-10-22',";
        sql = sql + empleado.getHorasLaboradas() + ",";
        sql = sql + "'" + String.valueOf(dia.getMes()) + "')";
        
        
        /*System.out.println("Mes: " + horas.getMesCho().getMonth());
        System.out.println("Año: " + horas.getAñoCho().getYear());
        System.out.println("Horas: " + empleado.getHorasLaboradas());*/
        
        return ConexionSqlite1.ejecutar(sql);
    }

   public ResultSet ObtenerFeriados(MDiaFeriado dia)
   {
       sql = "SELECT DFFecha FROM TDiaFeriado WHERE DFMes=";
       sql = sql + dia.getMes() + " AND DFAnio=" + dia.getAnio();
       r = ConexionSqlite1.consultar(sql);
       return r;
   }
   
   /*public ResultSet ConsultaHorasPorEmpleado()
   {
       //sql = 
       return r;
   }*/
   
}
