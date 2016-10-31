/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Julio César
 */
public class MEntrevistaOnline {
    
    private String idCandidato, idProy, cargoAsp, entrevistador, observaciones, modo;
    private int tipo;
    private int[] horaInicio = new int[2];
    private int[] horaFin = new int[2];
    private Date fecha;
    private float salOfer, salPret;
    private char resultado;

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public MEntrevistaOnline(String idCandidato, String idProy, String cargoAsp, String entrevistador, String observaciones, String modo, int entTipo, int[] horaInicio, int[] horaFin, Date entFecha, float entSalOfer, float entSalPret, char resultado) {
        this.idCandidato = idCandidato;
        this.idProy = idProy;
        this.cargoAsp = cargoAsp;
        this.entrevistador = entrevistador;
        this.observaciones = observaciones;
        this.modo = modo;
        this.tipo = entTipo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = entFecha;
        this.salOfer = entSalOfer;
        this.salPret = entSalPret;
        this.resultado = resultado;
    }

    public MEntrevistaOnline() {
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getIdProy() {
        return idProy;
    }

    public void setIdProy(String idProy) {
        this.idProy = idProy;
    }

    public String getCargoAsp() {
        return cargoAsp;
    }

    public void setCargoAsp(String cargoAsp) {
        this.cargoAsp = cargoAsp;
    }

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int entTipo) {
        this.tipo = entTipo;
    }

    public int[] getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int[] horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int[] getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int[] horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date entFecha) {
        this.fecha = entFecha;
    }

    public float getSalOfer() {
        return salOfer;
    }

    public void setSalOfer(float entSalOfer) {
        this.salOfer = entSalOfer;
    }

    public float getSalPret() {
        return salPret;
    }

    public void setSalPret(float entSalPret) {
        this.salPret = entSalPret;
    }
    
}
