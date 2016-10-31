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
public class MEntrevistaPresencial implements MEntrevista {
     private String entIDCandidato, entIdProy, entCargoAsp, entEntrevistador, entObservaciones, modo;
    private int entTipo;
    private long duracion;
    private Date entFecha;
    private float entSalOfer, entSalPret;
    private char resultado;

    public MEntrevistaPresencial(String entCargoAsp, long duracion, Date entFecha, float entSalOfer, char resultado) {
        this.entCargoAsp = entCargoAsp;
        this.duracion = duracion;
        this.entFecha = entFecha;
        this.entSalOfer = entSalOfer;
        this.resultado = resultado;
    }

    
    public MEntrevistaPresencial(String modo, int entTipo, long duracion, Date entFecha, char resultado) {
        this.modo = modo;
        this.entTipo = entTipo;
        this.duracion = duracion;
        this.entFecha = entFecha;
        this.resultado = resultado;
    }
    
    

    public MEntrevistaPresencial(String entIDCandidato, String entIdProy, String entCargoAsp, String entEntrevistador, String entObservaciones, String modo, int entTipo, int duracion, Date entFecha, float entSalOfer, float salPret, char resultado) {
        this.entIDCandidato = entIDCandidato;
        this.entIdProy = entIdProy;
        this.entCargoAsp = entCargoAsp;
        this.entEntrevistador = entEntrevistador;
        this.entObservaciones = entObservaciones;
        this.modo = modo;
        this.entTipo = entTipo;
        this.duracion = duracion;
        this.entFecha = entFecha;
        this.entSalOfer = entSalOfer;
        this.entSalPret = salPret;
        this.resultado = resultado;
    }

    public float getEntSalPret() {
        return entSalPret;
    }

    public void setEntSalPret(float entSalPret) {
        this.entSalPret = entSalPret;
    }

    @Override
    public char getResultado() {
        return resultado;
    }

    @Override
    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String getModo() {
        return modo;
    }

    @Override
    public void setModo(String modo) {
        this.modo = modo;
    }

    public MEntrevistaPresencial() {
    }

    @Override
    public String getEntIDCandidato() {
        return entIDCandidato;
    }

    @Override
    public void setEntIDCandidato(String entIDCandidato) {
        this.entIDCandidato = entIDCandidato;
    }

    @Override
    public String getEntIdProy() {
        return entIdProy;
    }

    /**
     *
     * @param entIdProy
     */
    @Override
    public void setEntIdProy(String entIdProy) {
        this.entIdProy = entIdProy;
    }

    /**
     *
     * @return
     */
    @Override
    public String getEntCargoAsp() {
        return entCargoAsp;
    }

    @Override
    public void setEntCargoAsp(String entCargoAsp) {
        this.entCargoAsp = entCargoAsp;
    }

    /**
     *
     * @return
     */
    @Override
    public String getEntEntrevistador() {
        return entEntrevistador;
    }

    @Override
    public void setEntEntrevistador(String entEntrevistador) {
        this.entEntrevistador = entEntrevistador;
    }

    /**
     *
     * @return
     */
    @Override
    public String getEntObservaciones() {
        return entObservaciones;
    }

    /**
     *
     * @param entObservaciones
     */
    @Override
    public void setEntObservaciones(String entObservaciones) {
        this.entObservaciones = entObservaciones;
    }

    @Override
    public int getEntTipo() {
        return entTipo;
    }

    @Override
    public void setEntTipo(int entTipo) {
        this.entTipo = entTipo;
    }

    @Override
    public Date getEntFecha() {
        return entFecha;
    }

    @Override
    public void setEntFecha(Date entFecha) {
        this.entFecha = entFecha;
    }

    @Override
    public double getEntSalOfer() {
        return entSalOfer;
    }

    @Override
    public void setEntSalOfer(float entSalOfer) {
        this.entSalOfer = entSalOfer;
    }

    @Override
    public double getSalPret() {
        return entSalPret;
    }

    @Override
    public void setSalPret(float salPret) {
        this.entSalPret = salPret;
    }

    @Override
    public long getDuracion() {
        return duracion;
    }

    @Override
    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    @Override
    public void setDuracion(int[] horaI, int[] horaF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
