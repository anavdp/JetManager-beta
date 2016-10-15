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
 * @author Vicky
 */
public class MEntrevista {
    private String entIDCandidato, entIdProy, entCargoAsp, entEntrevistador, entObservaciones;
    private int entTipo;
    private Date entFecha;
    private float entSalOfer, entSalPret;

    public MEntrevista(String entIDCandidato, String entIdProy, String entCargoAsp, String entEntrevistador, String entObservaciones, int entTipo, Date entFecha, float entSalOfer, float salPret) {
        this.entIDCandidato = entIDCandidato;
        this.entIdProy = entIdProy;
        this.entCargoAsp = entCargoAsp;
        this.entEntrevistador = entEntrevistador;
        this.entObservaciones = entObservaciones;
        this.entTipo = entTipo;
        this.entFecha = entFecha;
        this.entSalOfer = entSalOfer;
        this.entSalPret = salPret;
    }

    public MEntrevista() {
    }

    public String getEntIDCandidato() {
        return entIDCandidato;
    }

    public void setEntIDCandidato(String entIDCandidato) {
        this.entIDCandidato = entIDCandidato;
    }

    public String getEntIdProy() {
        return entIdProy;
    }

    public void setEntIdProy(String entIdProy) {
        this.entIdProy = entIdProy;
    }

    public String getEntCargoAsp() {
        return entCargoAsp;
    }

    public void setEntCargoAsp(String entCargoAsp) {
        this.entCargoAsp = entCargoAsp;
    }

    public String getEntEntrevistador() {
        return entEntrevistador;
    }

    public void setEntEntrevistador(String entEntrevistador) {
        this.entEntrevistador = entEntrevistador;
    }

    public String getEntObservaciones() {
        return entObservaciones;
    }

    public void setEntObservaciones(String entObservaciones) {
        this.entObservaciones = entObservaciones;
    }

    public int getEntTipo() {
        return entTipo;
    }

    public void setEntTipo(int entTipo) {
        this.entTipo = entTipo;
    }

    public Date getEntFecha() {
        return entFecha;
    }

    public void setEntFecha(Date entFecha) {
        this.entFecha = entFecha;
    }

    public double getEntSalOfer() {
        return entSalOfer;
    }

    public void setEntSalOfer(float entSalOfer) {
        this.entSalOfer = entSalOfer;
    }

    public double getSalPret() {
        return entSalPret;
    }

    public void setSalPret(float salPret) {
        this.entSalPret = salPret;
    }
    
}
