/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexion.ConexionSqlite1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import modelo.MProyecto;

/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
/**
 *
 * @author Vicky
 */
public class DaoProyecto  {
   
  private ConexionSqlite1 con = ConexionSqlite1.getInstancia();
  
    public ResultSet consultarProyectos(){
        ResultSet consulta;
        String sql;
        
        sql="Select * from TProyecto where ProyEstatus='A';";
        consulta= con.consultar(sql);       
        return consulta;
    }
    public boolean agregarProyecto(MProyecto proy){
        String sql= "insert into TProyecto (ProyId,ProyTitulo,ProyFechaInicio, ProyFechaFinEst,ProyIdCliente,ProyDescripcion,"
                +"ProyIdiomas) values('"+proy.getProyId()+"','"+proy.getProyTitulo()+"','"+new SimpleDateFormat("yyyy-MM-dd").format(proy.getProyFechaInicio())+"','"+
                new SimpleDateFormat("yyyy-MM-dd").format(proy.getProyFechaFin())+"','"+proy.getProyIdCliente()+"','"+proy.getProyDesc()+"','"+proy.getProyIdioma()+"')";
        boolean agregado= con.ejecutar(sql);
        return agregado;
    }
    public boolean modificarProyecto(MProyecto proy){
        String sql= "update TProyecto set "+
                "ProyFechaInicio='"+ proy.getProyFechaInicio() +"',"+
                "ProyFechaFinEst='"+ proy.getProyFechaFin() +"',"+
                "ProyDescripcion='"+ proy.getProyDesc() +"',"+
                "ProyIdiomas='"+ proy.getProyIdioma() +"'"+
                " where ProyId='"+ proy.getProyId()+"'";
        boolean modificado= con.ejecutar(sql);
        return modificado;
    }
    public boolean eliminarProyecto(String cod){
        String sql= "update TProyecto set ProyEstatus='E' where ProyId='"+cod+"'";
        boolean eliminado= con.ejecutar(sql);
        return eliminado;
    }
    
   public ResultSet buscarProyecto(String cod){
       ResultSet proyecto;
       String sql= "select * from TProyecto where ProyId='"+cod+"';";
       proyecto= con.consultar(sql);
       return proyecto;
   }
       public ResultSet consultarProyectoPorCliente(String rif){
       ResultSet proyecto;
       String sql= "select * from TProyecto where ProyIdCliente='"+rif+"';";
       proyecto= con.consultar(sql);
       return proyecto;
   }
       
       
    public ResultSet BuscaProyectosParaTableModel(String nomProy) throws SQLException {

		
			
			ResultSet rs;
                        String sql;
                         sql = "SELECT EmpId, CanNombres, CanApellidos,"
                                 + " PagHorasTrabajadas, EmpSalario,"
                                 + " EmpTipoPago, EmpTipoMoneda,"
                                 + " PagMonto FROM TProyecto JOIN TEntrevista ON"
                                 + " ProyId=EntIdProyecto JOIN TCandidato ON"
                                 + " EntRifCandidato=CanRif JOIN TEmpleado ON"
                                 + " CanRif=EmpRif JOIN TPagoMensual ON"
                                 + " EmpId=PagIdEmpleado"
                                 + " WHERE ProyTitulo= '"+ nomProy+"'" ;
                         rs = con.consultar(sql);
                         return rs;


		}
    

    public ResultSet BuscaProyectosParaTableModelUtil(String nomProy) throws SQLException {

		
			
			ResultSet rs;
                        String sql;
                         sql = "SELECT EmpId, CanNombres, CanApellidos,"
                                 + " PagHorasTrabajadas, EmpSalario,"
                                 + " EmpTipoPago, EmpTipoMoneda,"
                                 + " PagMonto FROM TProyecto JOIN TEntrevista ON"
                                 + " ProyId=EntIdProyecto JOIN TCandidato ON"
                                 + " EntRifCandidato=CanRif JOIN TEmpleado ON"
                                 + " CanRif=EmpRif JOIN TPagoMensual ON"
                                 + " EmpId=PagIdEmpleado"
                                 + " WHERE ProyTitulo= '"+ nomProy+"'" ;
                         rs = con.consultar(sql);
                         return rs;
}

}
