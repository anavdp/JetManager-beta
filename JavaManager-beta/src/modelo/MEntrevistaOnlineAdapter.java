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
public class MEntrevistaOnlineAdapter implements MEntrevista {

     private MEntrevistaOnline entrevistaOnline;

    public MEntrevistaOnlineAdapter() {
        entrevistaOnline = new MEntrevistaOnline();
    }
    
    @Override
    public String getEntIDCandidato() {
        return entrevistaOnline.getIdCandidato();
    }

    @Override
    public void setEntIDCandidato(String entIDCandidato) {
        entrevistaOnline.setIdCandidato(entIDCandidato);
    }

    @Override
    public String getEntIdProy() {
        return entrevistaOnline.getIdProy();
    }

    @Override
    public void setEntIdProy(String entIdProy) {
        entrevistaOnline.setIdProy(entIdProy);
    }

    @Override
    public String getEntCargoAsp() {
        return entrevistaOnline.getCargoAsp();
    }

    @Override
    public void setEntCargoAsp(String entCargoAsp) {
        entrevistaOnline.setCargoAsp(entCargoAsp);
    }

    @Override
    public String getEntEntrevistador() {
        return entrevistaOnline.getEntrevistador();
    }

    @Override
    public void setEntEntrevistador(String entEntrevistador) {
        entrevistaOnline.setEntrevistador(entEntrevistador);
    }

    @Override
    public String getEntObservaciones() {
        return entrevistaOnline.getObservaciones();
    }

    @Override
    public void setEntObservaciones(String entObservaciones) {
        entrevistaOnline.setObservaciones(entObservaciones);
    }

    @Override
    public int getEntTipo() {
        return entrevistaOnline.getTipo();
    }

    @Override
    public void setEntTipo(int entTipo) {
        entrevistaOnline.setTipo(entTipo);
    }

    @Override
    public Date getEntFecha() {
        return entrevistaOnline.getFecha();
    }

    @Override
    public void setEntFecha(Date entFecha) {
        entrevistaOnline.setFecha(entFecha);
    }

    @Override
    public double getEntSalOfer() {
        return entrevistaOnline.getSalOfer();
    }

    @Override
    public void setEntSalOfer(float entSalOfer) {
        entrevistaOnline.setSalOfer(entSalOfer);
    }

    @Override
    public double getSalPret() {
        return entrevistaOnline.getSalPret();
    }

    @Override
    public void setSalPret(float salPret) {
        entrevistaOnline.setSalPret(salPret);
    }

    @Override
    public long getDuracion() {
        int[] horaI = entrevistaOnline.getHoraInicio();
        int[] horaF = entrevistaOnline.getHoraFin();
        int minutosI = horaI[0]*60 + horaI[1];
        int minutosF = horaF[0]*60 + horaF[1];
        return minutosF - minutosI;
    }

    @Override
    public void setDuracion(long duracion) {
        int[] horaI = new int[2];
        int[] horaF = new int[2];
        horaI[0] = 0;
        horaI[1] = 0;
        horaF[1] = (int) (duracion % 60);
        horaF[0] = (int) (duracion / 60);
        entrevistaOnline.setHoraInicio(horaI);
        entrevistaOnline.setHoraFin(horaF);
    }

    @Override
    public void setDuracion(int[] horaI, int[] horaF) {
        entrevistaOnline.setHoraInicio(horaI);
        entrevistaOnline.setHoraFin(horaF);
    }

    @Override
    public String getModo() {
        return entrevistaOnline.getModo();
    }

    @Override
    public void setModo(String modo) {
        entrevistaOnline.setModo(modo);
    }

    @Override
    public char getResultado() {
        return entrevistaOnline.getResultado();
    }

    @Override
    public void setResultado(char resultado) {
        entrevistaOnline.setResultado(resultado);
    }
    
}
