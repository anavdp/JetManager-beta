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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MEntrevista;
import modelo.Validaciones;


/**
 *
 * @author Vicky
 */
public class DaoEntrevista {
   
   
    
    public boolean insertarEntrevista(MEntrevista ent){
      
        String sql="insert into TEntrevista (EntRifCandidato,EntTipo,EntIdProyecto,EntFecha, EntCargoAsp,EntSalOfer,"
                + "EntSalPret,EntObservaciones,EntEntrevistador) "
                + " values ('"+ent.getEntIDCandidato()+"',"+ent.getEntTipo()+
                ",'"+ent.getEntIdProy()+"','"+new SimpleDateFormat("yyyy-MM-dd").format(ent.getEntFecha())+"','"+ent.getEntCargoAsp()+"',"+
                ent.getEntSalOfer()+","+ent.getSalPret()+",'"+ent.getEntObservaciones()+"','"+
                ent.getEntEntrevistador()+"')";
               boolean agregado= ConexionSqlite1.ejecutar(sql);
                return agregado;
                }


public boolean buscarEntrevista(String rif, String codP){
    String sql= "select * from TEntrevista where EntRifCandidato='"+rif+"' and  EntIdProyecto='"+codP+"';";
    ResultSet rs= ConexionSqlite1.consultar(sql);
        try {
            if(rs.next()){
                rs.close();
                return true;
            } else{return false;
            
            }} catch (SQLException ex) {
            Logger.getLogger(DaoEntrevista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
}
public ResultSet consultarCandidatosNoAsignados() {
        ResultSet res;
        String sql = "SELECT * FROM TEntrevista WHERE EntResultado != 'A'";
        res = ConexionSqlite1.consultar(sql);
        return res;
    }

public ResultSet consultarEntrevistasPorCandidato(String rif) {
        ResultSet res;
        String sql = "SELECT * FROM TEntrevista WHERE EntRifCandidato = '" + rif + "'";
        res = ConexionSqlite1.consultar(sql);
        return res;
    }
public ResultSet consultarEntrevistaPorFecha(Date fi, Date f2)
{
String sql="  SELECT TEntrevista.EntFecha, TCandidato.CanNombres,TProyecto.ProyTitulo,TEntrevista.EntResultado"+
"FROM TEntrevista INNER JOIN TCandidato ON (TEntrevista.EntRifCandidato = TCandidato.CanRif)"+
 "INNER JOIN TProyecto ON (TEntrevista.EntIdProyecto = TProyecto.ProyId)"+
"WHERE"+
 " TEntrevista.EntRifCandidato = TCandidato.CanRif AND "+
  "TEntrevista.EntIdProyecto = TProyecto.ProyId AND "+
  "TEntrevista.EntFecha BETWEEN '" +
            new SimpleDateFormat("yyyy-MM-dd").format(fi) + "' "
            + "and '" + new SimpleDateFormat("yyyy-MM-dd").format(f2) + "';";
    ResultSet rs= ConexionSqlite1.consultar(sql);
    return rs;
}
public ResultSet consultarEntrevistaPorProyecto(String proy){
        ResultSet res;
        String sql = "SELECT * FROM TEntrevista WHERE EntIdProyecto = '" + proy + "'";
        res = ConexionSqlite1.consultar(sql);
        return res;
}

public ResultSet consultarEntrevistaPorProyectoTabla(String proy){
        ResultSet res;
        String sql = "SELECT \n" +
"  TEntrevista.EntFecha,\n" +
"  TEntrevista.EntResultado,\n" +
"  TCandidato.CanNombres,\n" +
"  TEntrevista.EntSalOfer,\n" +
"  TEntrevista.EntCargoAsp\n" +
"FROM\n" +
"  TEntrevista\n" +
"  INNER JOIN TCandidato ON (TEntrevista.EntRifCandidato = TCandidato.CanRif)\n" +
"  INNER JOIN TProyecto ON (TEntrevista.EntIdProyecto = TProyecto.ProyId)\n" +
"WHERE\n" +
"  TEntrevista.EntRifCandidato = TCandidato.CanRif AND \n" +
"  TEntrevista.EntIdProyecto = TProyecto.ProyId AND \n" +
"  TProyecto.ProyId ='" + proy + "' "+
"GROUP BY\n" +
"  TEntrevista.EntFecha,\n" +
"  TEntrevista.EntResultado\n" +
"ORDER BY\n" +
"  TEntrevista.EntFecha,\n" +
"  TCandidato.CanNombres,\n" +
"  TEntrevista.EntCargoAsp,\n" +
"  TEntrevista.EntSalOfer,\n" +
"  TEntrevista.EntResultado" ;
        res = ConexionSqlite1.consultar(sql);
        return res;
}

public ResultSet consultarTaplaPorCandidato(String rif){
    String sql= "SELECT \n" +
"  TEntrevista.EntFecha,\n" +
"  TProyecto.ProyTitulo,\n" +
"  TEntrevista.EntResultado,\n" +
"  TEntrevista.EntEntrevistador\n" +
"FROM\n" +
"  TEntrevista\n" +
"  INNER JOIN TCandidato ON (TEntrevista.EntRifCandidato = TCandidato.CanRif)\n" +
"  INNER JOIN TProyecto ON (TEntrevista.EntIdProyecto = TProyecto.ProyId)\n" +
"WHERE\n" +
"  TEntrevista.EntRifCandidato = TCandidato.CanRif AND \n" +
"  TEntrevista.EntIdProyecto = TProyecto.ProyId AND \n" +
"  TCandidato.CanRif='"+rif+"' " +
"GROUP BY\n" +
"  TEntrevista.EntFecha,\n" +
"  TProyecto.ProyTitulo,\n" +
"  TEntrevista.EntResultado\n" +
"ORDER BY\n" +
"  TEntrevista.EntFecha,\n" +
"  TProyecto.ProyTitulo,\n" +
"  TEntrevista.EntEntrevistador,\n" +
"  TEntrevista.EntResultado";
    ResultSet rs= ConexionSqlite1.consultar(sql);
    return rs;
}


    
    public void modificarEstatusEntrevista(String rif, char estatus) {
        String sql = "UPDATE TEntrevista SET EntResultado = '" + estatus + "' WHERE EntRifCandidato = '" + rif + "'";
        ConexionSqlite1.ejecutar(sql);
    }
    
}

