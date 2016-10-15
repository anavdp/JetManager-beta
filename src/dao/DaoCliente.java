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
import javax.swing.JOptionPane;
import modelo.MCliente;

/**
 *
 * @author Vicky
 */
public class DaoCliente {
       
    public  ResultSet buscarCliente(String rif){
        String sql="Select * from TCliente where CliRif='"+rif+"';";
        ResultSet rs;
        rs= ConexionSqlite1.consultar(sql);

        return rs;    
    }
    public  boolean agregarCliente(MCliente cli){
        String sql="insert into TCliente (CliRif,CliRazonSocial,CliEmail,CliTelefono,CliDireccion,CliCiudad,CliPais,CliCodTelefono)"+
                "values('"+cli.getCliId()+"','"+cli.getCliNombre()+"','"+cli.getCliEmail()+"','"+cli.getCliTelf()+"','"+
                cli.getCliDirec()+"','"+cli.getCliCiudad()+"','"+cli.getCliPais()+"',')"+cli.getCliCodTelf()+"')";
        boolean agregado= ConexionSqlite1.ejecutar(sql);
        return agregado;
    }
    public  boolean eliminarCliente(String rif){
        String sql="update TCliente set CliEstatus='E' where CliRif='"+rif+"'";
        boolean eliminado= ConexionSqlite1.ejecutar(sql);
        return eliminado;      
        
    }
    public  ResultSet consultarClientes(){
        String sql= "Select * from TCliente where CliEstatus='A'";
        ResultSet rs= ConexionSqlite1.consultar(sql);
        return rs;
    }
    
    public  boolean modificarCliente(MCliente cli){
        String sql= "update TCliente set "+
                "CliEmail='"+cli.getCliEmail()+"',"+
                "CliTelefono='"+cli.getCliTelf()+"',"+
                "CliCodTelefono='"+cli.getCliCodTelf()+"',"+
                "CliPais='"+cli.getCliPais()+"',"+
                "CliCiudad='"+cli.getCliCiudad()+"',"+
                "CliDireccion='"+cli.getCliDirec()+"'"+
                " where CliRif='"+cli.getCliId()+"'";
        boolean modificado= ConexionSqlite1.ejecutar(sql);
        return modificado;
    }
}
