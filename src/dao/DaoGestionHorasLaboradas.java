/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package dao;
import conexion.ConexionSqlite1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import modelo.MEmpleado;
import vista.VGestionHorasLaboradas;

public class DaoGestionHorasLaboradas {
    private String sql;
    private ResultSet r;
    private SimpleDateFormat formatoMes;
    private SimpleDateFormat formatoAnio;
    private VGestionHorasLaboradas horas;
    
    public ResultSet BuscarRif(MEmpleado empleado)
    {
        sql = "SELECT EmpRif FROM TEmpleado WHERE EmpRif='";
        sql = sql + empleado.getRif() + "'";
        
        r = ConexionSqlite1.consultar(sql);
        return r;
    }
    public ResultSet ObtenerFaltas()
    {
        sql = "SELECT FalJustificada FROM TFalta WHERE FalJustificada='No Justificada'";
        r = ConexionSqlite1.consultar(sql);
        return r;
    }
    
   public boolean InsertarHoras(MEmpleado empleado)
    {
        formatoMes = new SimpleDateFormat("MM");
        formatoAnio = new SimpleDateFormat("yyyy");
        horas = new VGestionHorasLaboradas();
        
        
        sql = "INSERT INTO THorasLaborables (HLMes, HLAnio, HLCantHoras) VALUES (";
        sql = sql + Integer.valueOf(horas.getMesCho().getMonth() + 1) +",";
        sql = sql + Integer.valueOf(horas.getAñoCho().getYear()) + ",";
        sql = sql + empleado.getID() + ")";
        
        return ConexionSqlite1.ejecutar(sql);
    }

   /*public ResultSet ConsultaHorasPorEmpleado()
   {
       //sql = 
       return r;
   }*/
}
