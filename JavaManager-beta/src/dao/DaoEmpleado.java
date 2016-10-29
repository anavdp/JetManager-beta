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
import modelo.MEmpleado;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class DaoEmpleado {
    
    private final ConexionSqlite1 con = ConexionSqlite1.getInstancia();
    
    
    public ResultSet ConsultarEmpleados(){
        ResultSet consulta;
        
        String sql;
        sql="SELECT * from TEmpleado";
        consulta= con.consultar(sql);
        
        
        return consulta;
    }
    
    public ResultSet BuscarEmpleadoRif(String rif) {
        ResultSet res;
        String sql = "SELECT * FROM TEmpleado WHERE EmpRif='" + rif + "'";
        res = con.consultar(sql);
        return res;
    }
    
    
    public ResultSet BuscarEmpleadoNombre(String nom) {
        ResultSet res;
        String sql = "SELECT * FROM TCandidato JOIN TEmpleado ON CanRif=EmpRif"
                + " WHERE (CanNombres || ' ' ||CanApellidos)= '" + nom + "'";
        res = con.consultar(sql);
        return res;
    }
    
    public ResultSet BuscaEmpleadosParaTableModel(String nomEmp) throws SQLException {

		
			
	       ResultSet res;
        String sql;

        sql = "SELECT PagFecha, PagHorasTrabajadas, PagMonto FROM "
                + "TCandidato JOIN TEmpleado ON CanRif=EmpRif JOIN TPagoMensual "
                + "ON EmpId = PagIdEmpleado "
                + "WHERE (CanNombres || ' ' ||CanApellidos)= '" + nomEmp + "'";
                  
                         res = con.consultar(sql);
                         return res;


		}
    
    public ResultSet BuscaEmpleadosMesParaTableModel(String mes){
        ResultSet rs;
        String sql;
        
     
        
        sql = "SELECT EmpId, CanNombres, CanApellidos, PagHorasTrabajadas, PagMonto,"
                + "EmpTipoPago , EmpSalario, EmpTipoMoneda, ProyTitulo FROM "
                + "TEmpleado JOIN TCandidato ON EmpRif = CanRif JOIN TPagoMensual"
                + " ON EmpId = PagIdEmpleado JOIN TEntrevista ON CanRif = EntRifCandidato "
                + "JOIN TProyecto ON EntIdProyecto = ProyId"
                + " WHERE PagMes ='"+ mes +"'";
              
   
        rs = con.consultar(sql);
        return rs;
    }
    
    public void insertarEmpleados(MEmpleado emp) {
        String sql = "INSERT INTO TEmpleado (EmpRif, EmpTipoMoneda, EmpTipoPago, EmpSalario, EmpEstatus) VALUES(";
        sql += "'" + emp.getRif() + "', ";
        sql += "'" + emp.getTipoMoneda() + "', ";
        sql += "'" + emp.getTipoPago() + "', ";
        sql += emp.getSalario() + ", ";
        sql += "'A')";
        System.out.println("sql = " + sql);
        con.ejecutar(sql);
    }

}
 