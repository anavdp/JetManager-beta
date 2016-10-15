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
import java.text.SimpleDateFormat;
import modelo.MPagoMensual;
import modelo.Validaciones;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class DaoPagoMensual {
    
    public boolean InsertarPagoMensual(MPagoMensual pago) {
        String sql;
        sql = "INSERT INTO TPagoMensual (PagIdEmpleado, PagMes, PagMonto, PagEstatus) VALUES(";
        sql += Validaciones.Apost(String.valueOf(pago.getID())) + ", ";
        //sql += Validaciones.Apost(String.valueOf(pago.getFecha())) + ", ";
        sql += Validaciones.Apost(pago.getMes()) + ", ";
        
        //sql += Validaciones.Apost(String.valueOf(pago.getHorasTrabajadas())) + ", ";
        sql += Validaciones.Apost(String.valueOf(pago.getMonto())) + ", ";
        sql += "'A')";
        return ConexionSqlite1.ejecutar(sql);
    
}
}