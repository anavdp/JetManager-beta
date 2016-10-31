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
public interface MEntrevista {
    
    
    public String getEntIDCandidato();
    public void setEntIDCandidato(String entIDCandidato);
    public String getEntIdProy();
    public void setEntIdProy(String entIdProy);
    public String getEntCargoAsp();
    public void setEntCargoAsp(String entCargoAsp);
    public String getEntEntrevistador();
    public void setEntEntrevistador(String entEntrevistador);
    public String getEntObservaciones();
    public void setEntObservaciones(String entObservaciones);
    public int getEntTipo();
    public void setEntTipo(int entTipo);
    public Date getEntFecha();
    public void setEntFecha(Date entFecha);
    public double getEntSalOfer();
    public void setEntSalOfer(float entSalOfer);
    public double getSalPret();
    public void setSalPret(float salPret);
    public long getDuracion();
    public void setDuracion(long duracion);
    public void setDuracion(int[] horaI, int[] horaF);
    public String getModo();
    public void setModo(String modo);
    public char getResultado();
    public void setResultado(char resultado);
    
}
