/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package modelo;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Vicky
 */
public final class MProyecto {
    private String proyId, proyTitulo, proyIdCliente, proyIdioma, proyDesc;
   
    private Date proyFechaInicio, proyFechaFin;

    public MProyecto(String proyId, String proyTitulo, String proyIdCliente, String proyIdioma, String proyDesc, Date proyFechaInicio, Date proyFechaFin) {
        this.proyId = proyId;
        this.proyTitulo = proyTitulo;
        this.proyIdCliente = proyIdCliente;
        this.proyIdioma = proyIdioma;
        this.proyDesc = proyDesc;
       
        this.proyFechaInicio = proyFechaInicio;
        this.proyFechaFin = proyFechaFin;
    }

    public MProyecto(String proyId, String proyTitulo) {
        this.proyId = proyId;
        this.proyTitulo = proyTitulo;
    }
    

    public MProyecto() {
        proyId= generarCodigo();
    }

    
  public  String generarCodigo (){
    String cadenaAleatoria = "";
    int longitud=8;
    long milis = new java.util.GregorianCalendar().getTimeInMillis();
    Random r = new Random(milis);
    int i = 0;
    while ( i < longitud){
        char c = (char)r.nextInt(255);
        if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
        cadenaAleatoria += c;
        i ++;
        }
    }
return cadenaAleatoria;
}
    public String getProyId() {
        return proyId;
    }

    public void setProyId(String proyId) {
        this.proyId = proyId;
    }

    public String getProyTitulo() {
        return proyTitulo;
    }

    public void setProyTitulo(String proyTitulo) {
        this.proyTitulo = proyTitulo;
    }

    public String getProyIdCliente() {
        return proyIdCliente;
    }

    public void setProyIdCliente(String proyIdCliente) {
        this.proyIdCliente = proyIdCliente;
    }

    public String getProyIdioma() {
        return proyIdioma;
    }

    public void setProyIdioma(String proyIdioma) {
        this.proyIdioma = proyIdioma;
    }

    public String getProyDesc() {
        return proyDesc;
    }

    public void setProyDesc(String proyDesc) {
        this.proyDesc = proyDesc;
    }

   

    public Date getProyFechaInicio() {
        return proyFechaInicio;
    }

    public void setProyFechaInicio(Date proyFechaInicio) {
        this.proyFechaInicio = proyFechaInicio;
    }

    public Date getProyFechaFin() {
        return proyFechaFin;
    }

    public void setProyFechaFin(Date proyFechaFin) {
        this.proyFechaFin = proyFechaFin;
    }
    
    
}
