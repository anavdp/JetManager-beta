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
public class DaoCliente  {
    
    private ConexionSqlite1 con = ConexionSqlite1.getInstancia();
       
    public  ResultSet buscarCliente(String rif){
        String sql="Select * from TCliente where CliRif='"+rif+"';";
        ResultSet rs;
        rs= con.consultar(sql);

        return rs;    
    }
    public  boolean agregarCliente(MCliente cli){
        String sql="insert into TCliente (CliRif,CliRazonSocial,CliEmail,CliTelefono,CliDireccion,CliCiudad,CliPais,CliCodTelefono)"+
                "values('"+cli.getCliId()+"','"+cli.getCliNombre()+"','"+cli.getCliEmail()+"','"+cli.getCliTelf()+"','"+
                cli.getCliDirec()+"','"+cli.getCliCiudad()+"','"+cli.getCliPais()+"',')"+cli.getCliCodTelf()+"')";
        boolean agregado= con.ejecutar(sql);
        return agregado;
    }
    public  boolean eliminarCliente(String rif){
        String sql="update TCliente set CliEstatus='E' where CliRif='"+rif+"'";
        boolean eliminado= con.ejecutar(sql);
        return eliminado;      
        
    }
    public  ResultSet consultarClientes(){
        String sql= "Select * from TCliente where CliEstatus='A'";
        ResultSet rs= con.consultar(sql);
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
        boolean modificado= con.ejecutar(sql);
        return modificado;
    }
}
