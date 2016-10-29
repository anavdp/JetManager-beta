/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package dao;

/**
 *
 * @author jesus
 */
import modelo.MFaltas;
import conexion.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.*;


public class DaoRegFaltas {
    MFaltas mf;
    private ConexionSqlite1 con = ConexionSqlite1.getInstancia();
    
    public DaoRegFaltas(){
    mf = new MFaltas();
    }
    public void Registrarfal(MFaltas fal){
        String sql = "INSERT INTO TFalta (FalIdEmpleado, FalFecha, FalJustificada, FalObservaciones, FalEstatus) VALUES (";
        sql += Validaciones.Apost(fal.getCedula())+" , " ;
        sql += " ' "+ fal.getFecha() + " ' , " ;
        sql += Validaciones.Apost(fal.getTipo()) + " , " ;
        sql += Validaciones.Apost(String.valueOf(fal.getDescripcion())) + " , " ;
        sql += " 'A' ) " ;
        con.ejecutar(sql);      
    
    }
    public ResultSet Consultarfalce(String ce) {
        String sql= "select * from TFalta";
        ResultSet rs;
        rs = con.consultar(sql);
        return rs;
        
        
         /*String sql = "select FalIdEmpleado, FalFecha, FalJustificada, FalObservaciones (select EmpId from TEmpleado where EmpId = '" + ce + "') "
                + "as Id, "
                + "(select CanNombre from TCandidato where Id.EmpRif = TCandidato.CanRif), "
                + "TCandidato where FalIdEmpleado = ' " + ce + " ' " ;
        
         ResultSet rs;
        rs = ConexionSqlite1.consultar(sql);
        
        String sql1 = "select TFalta.FalIdEmpleado, TFalta.FalFecha, TFalta.FalJustificada, TFalta.FalObservaciones, TCandidato.CanNombres, "
                + "TEmpleado.EmpRif from"
                + "TFalta join TEmpleado on TFalta.FalIdEmpleado = TEmpleado.EmpRif join "
                + "TEmpleado on TEmpleado.EmpRif = TCandidato.CanRif where FalIdEmpleado = '" + ce + "'";
       
    }*/

    }
    
    }
