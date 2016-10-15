/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */

package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Validaciones {
  public static String getFechaActual() 
   {
      Date ahora = new Date();
      SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
      return formateador.format(ahora);
    }      
//-------------------------    
 public static boolean isDate(String fechax)
 {
  try {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
      formatoFecha.setLenient(false);
      formatoFecha.parse(fechax);
      return true;
  } catch (ParseException e) 
     {
      return false;
     }
  
}
//--------------------------    
 public static Date CnvStringFecha(String fecha)
{
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaDate = null;
    try {
        fechaDate = formato.parse(fecha);
    }
    catch (ParseException ex)
    {
        System.out.println(ex);
    }
    return fechaDate;
}
 //-------------------------------------------
 public static int PosicionarCombo(javax.swing.JComboBox Combo, String Valor)
{
   int i,Posi=-1;
   String PalCombo;   
   Valor=Valor.trim();
       
    for (i=0;i<Combo.getItemCount();i++)
    {
      PalCombo=(String)Combo.getItemAt(i);
      PalCombo=PalCombo.trim();
       
      if (Valor.equals(PalCombo) )
        Posi=i;
    }  
        
    return Posi;
}
 
 //-------------------------------------------
  public static int Generar_Aleatorio(int limite) 
      { 
         return (int) (Math.random()*limite+1)-1;
      }
  
 //-----------------------------------------------
   public static Date AgregarDias(Date fecha, int dias) 
    {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    } 
  
  //-------------------------------------    
 public static String FormatDate(Date fecha)
 {
     SimpleDateFormat formatoF = new SimpleDateFormat("dd/MM/yyyy");
     return formatoF.format(fecha);
 }
 
 //-------------------------------------------------
 public static void reiniciarJTable(javax.swing.JTable tabla)
 {
     DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
     while(modelo.getRowCount()>0)modelo.removeRow(0);
     modelo.setRowCount(99);
 }
  public static String Apost(String Texto) 
{
  return "'"+Texto+"'";
} 
  
 public static void limpiarJTable(javax.swing.JTable tabla)
 {
     DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
     while(modelo.getRowCount()>0)modelo.removeRow(0);
 }
  
 public static void agregarObjetoJTable(javax.swing.JTable tabla, Vector<String> datos)
 {
     DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
     //Mensajes.Aviso(datos.get(0), null);
     modelo.addRow(datos);
 }
 
  //--------------------------------------
   public static boolean Selecciona(String sino)
   {
     sino=sino.trim();
     if(sino.equals("Sí")){
         return true;
     } else{
         return false;
     }
 }
 
 
 
 
}
