/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PALACIOS
 * @author ABUNASSAR PENARANDA
 * @author JESÚS RANGEL
 */
public class MEmpleado extends MCandidato {
    
     private int ID;
     private int horasLaboradas; //Ésto lo agregué
     private String rif;
     private String tipoMoneda;
     private String TipoPago;
     private float salario;

    public MEmpleado() {
        super();
    }

    public MEmpleado(int ID, String rif, String tipoMoneda, String TipoPago, float salario, int horasLaboradas) {
        this.ID = ID;
        this.rif = rif;
        this.tipoMoneda = tipoMoneda;
        this.TipoPago = TipoPago;
        this.salario = salario;
        this.horasLaboradas = horasLaboradas;
    }

    public int getHorasLaboradas() {
        return horasLaboradas;
    }

    public void setHorasLaboradas(int horasLaboradas) {
        this.horasLaboradas = horasLaboradas;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
