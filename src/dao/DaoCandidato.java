/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package dao;

import modelo.Validaciones;
import conexion.ConexionSqlite1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MCandidato;
/**
 *
 * @author Julio César
 */

public class DaoCandidato {
    
    public boolean InsertarCandidato(MCandidato can) {
        String sql = "INSERT INTO TCandidato (CanRif, CanNombres, CanApellidos, CanFechaNac, CanEdoCivil, CanDireccion, CanPais, CanCiudad, CanEmail, CanCodTelefono, CanTelefono, CanEstatus) VALUES(";
        sql += Validaciones.Apost(can.getRif()) + ", ";
        sql += Validaciones.Apost(can.getNombres()) + ", ";
        sql += Validaciones.Apost(can.getApellidos()) + ", ";
        sql += Validaciones.Apost(new SimpleDateFormat("yyyy-MM-dd").format(can.getFechaNacimiento())) + ", ";
        sql += Validaciones.Apost(String.valueOf(can.getEdoCivil())) + ", ";
        sql += Validaciones.Apost(can.getDireccion()) + ", ";
        sql += Validaciones.Apost(can.getPais()) + ", ";
        sql += Validaciones.Apost(can.getCiudad()) + ", ";
        sql += Validaciones.Apost(can.getEmail()) + ", ";
        sql += Validaciones.Apost(can.getCodTelefono()) + ", ";
        sql += Validaciones.Apost(can.getTelefono()) + ", ";
        insertarPalabrasClave(can.getRif(), can.getPalabrasClave());
        sql += "'A')";
        System.out.println("sql = " + sql);
        //TODO Queda pendiente la inserción de las palabras clave
        return ConexionSqlite1.ejecutar(sql);
    }
    
    public ResultSet buscarPalabraClave(String p) {
        ResultSet res;
        String sql = "SELECT * FROM TPalabraClave WHERE PalPalabra='" + p + "'";
        res = ConexionSqlite1.consultar(sql);
        return res;
    }
    
    public void insertarPalabrasClave(String rif, String[] palabras) {
        String sql;
        for (int i=0; i<palabras.length; i++) {
            ResultSet res = buscarPalabraClave(palabras[i]);
            try {
                if(!res.next()) {
                    res.close();
                    sql = "INSERT INTO TPalabraClave (PalPalabra, PalEstatus) VALUES(";
                    sql += Validaciones.Apost(palabras[i]) + ", ";
                    sql += "'A')";
                    ConexionSqlite1.ejecutar(sql);
                    res = buscarPalabraClave(palabras[i]);
                }
                sql = "INSERT INTO TPalabraPorCandidato (PCIdPalabra, PCRifCandidato, PCEstatus) VALUES(";
                sql += res.getInt("PalId") + ", ";
                sql += Validaciones.Apost(rif) + ", ";
                sql += "'A')";
                res.close();
                ConexionSqlite1.ejecutar(sql);
            } catch (SQLException ex) {
                Logger.getLogger(DaoCandidato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
     public boolean modificarCandidato(MCandidato can) {
         String sql = "UPDATE TCandidato SET ";
         sql += "CanNombres = " + Validaciones.Apost(can.getNombres()) + ", ";
         sql += "CanApellidos = " + Validaciones.Apost(can.getApellidos()) + ", ";
         sql += "CanFechaNac = " + Validaciones.Apost(new SimpleDateFormat("yyyy-MM-dd").format(can.getFechaNacimiento())) + ", ";
         sql += "CanEdoCivil = " + Validaciones.Apost(String.valueOf(can.getEdoCivil())) + ", ";
         sql += "CanDireccion = " + Validaciones.Apost(can.getDireccion()) + ", ";
         sql += "CanCiudad = " + Validaciones.Apost(can.getCiudad()) + ", ";
         sql += "CanPais = " + Validaciones.Apost(can.getPais()) + ", ";
         sql += "CanEmail = " + Validaciones.Apost(can.getEmail()) + ", ";
         sql += "CanCodTelefono = " + Validaciones.Apost(can.getCodTelefono()) + ", ";
         sql += "CanTelefono = " + Validaciones.Apost(can.getTelefono()) + " WHERE CanRif = " + Validaciones.Apost(can.getRif());
         eliminarFisicoPalabrasClavePorCandidato(can.getRif());
         insertarPalabrasClave(can.getRif(), can.getPalabrasClave());
         return ConexionSqlite1.ejecutar(sql);
     }
     
     public boolean eliminarCandidato(MCandidato can) {
         String sql = "UPDATE TCandidato SET CanEstatus = 'E' WHERE CanRif = '" + can.getRif() + "'";
         ConexionSqlite1.ejecutar(sql);
         return eliminarLogicoPalabrasClavePorCandidato(can.getRif());
     }
     
     public ResultSet BuscarCandidato(String id) {
        ResultSet res;
        String sql = "SELECT * FROM TCandidato WHERE CanRif='" + id + "'";
        res = ConexionSqlite1.consultar(sql);
        return res;
    }
    
     public ResultSet ConsultarCandidatos(){
        ResultSet consulta;
        
        String sql;
        sql="SELECT * from TCandidato";
        consulta= ConexionSqlite1.consultar(sql);
        
        return consulta;
    }
     
     public ResultSet consultarPalabrasClavePorCandidato(String rif) {
         ResultSet consulta;
         String sql = "SELECT PalPalabra FROM TPalabraClave, TPalabraPorCandidato WHERE PCIdPalabra = PalId AND PCRifCandidato = '" + rif + "'";
         consulta = ConexionSqlite1.consultar(sql);
         return consulta;
     }
     
     public boolean eliminarFisicoPalabrasClavePorCandidato(String rif) {
         //Eliminación física
         String sql = "DELETE FROM TPalabraPorCandidato WHERE PCRifCandidato = '" + rif + "'";
         return ConexionSqlite1.ejecutar(sql);
     }
     
     public boolean eliminarLogicoPalabrasClavePorCandidato(String rif) {
         //Eliminación lógica
         String sql = "UPDATE TPalabraPorCandidato SET PCEstatus = 'E' WHERE PCRifCandidato = '" + rif + "'";
         return ConexionSqlite1.ejecutar(sql);
     }
     
     public ResultSet consultarCandidatosPorNombres(String nom) {
         ResultSet consulta;
         String sql = "SELECT * FROM TCandidato WHERE CanNombres LIKE '%" + nom + "%' AND CanEstatus != 'E'";
         System.out.println("sql = " + sql);
         consulta = ConexionSqlite1.consultar(sql);
         return consulta;
     }
     
     public ResultSet consultarCandidatosPorApellidos(String ape) {
         ResultSet consulta;
         String sql = "SELECT * FROM TCandidato WHERE CanApellidos LIKE '%" + ape + "%' AND CanEstatus != 'E'";
         System.out.println("sql = " + sql);
         consulta = ConexionSqlite1.consultar(sql);
         return consulta;
     }
     
     public ResultSet consultarCandidatosPorNombresApellidos(String nom, String ape) {
         ResultSet consulta;
         String sql = "SELECT * FROM TCandidato WHERE (CanNombres LIKE '%" + nom + "%' AND CanApellidos LIKE '%" + ape + "%') AND CanEstatus != 'E'";
         System.out.println("sql = " + sql);
         consulta = ConexionSqlite1.consultar(sql);
         return consulta;
     }
     
     //Aún no sé si esta consulta funciona
     public ResultSet consultarCandidatosPorPalabrasClave(String[] palabras) {
         ResultSet consulta;
         String sql = "SELECT DISTINCT CanRif, CanNombres, CanApellidos, CanPais, CanEmail FROM TPalabraPorCandidato, TPalabraClave, TCandidato"
                 + " WHERE PCRifCandidato = CanRif AND PCIdPalabra = PalId AND (UPPER(PalPalabra) LIKE UPPER('%" + palabras[0] + "%')";
         for(int i=1; i<palabras.length; i++) {
             sql += " OR UPPER(PalPalabra) = UPPER('" + palabras[i] + "')";
         }
         sql += ") ORDER BY PCRifCandidato";
         System.out.println("sql = " + sql);
         consulta = ConexionSqlite1.consultar(sql);
         return consulta;
     }
     
}

