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

/**
 *
 * @author jesus
 */


public class MFaltas {
    private String cedula;
    private String fecha;
    private String tipo;
    private String descripcion;
       

    public MFaltas(String cedula, String fecha, String tipo, String descripcion) {
        super();
        this.cedula = cedula;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        
    }

    public MFaltas() {
        super();
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
       }
    
