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
 * @author ABUNASSAR PENARANDA
 */
public class MEmpleado extends MCandidato {
     private int ID;
     private String rif;
     private String tipoMoneda;
     private String TipoPago;
     private float salario;

    public MEmpleado() {
        super();
    }

    public MEmpleado(int ID, String rif, String tipoMoneda, String TipoPago, float salario) {
        this.ID = ID;
        this.rif = rif;
        this.tipoMoneda = tipoMoneda;
        this.TipoPago = TipoPago;
        this.salario = salario;
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
     
     
    public MEmpleado(int id, String tipoMoneda, String tipoPago, float salario, String rif, String nombres, String apellidos, Date fechaNacimiento, char edoCivil, String direccion, String ciudad, String pais, String email, String telefono, String codTelefono, String[] palabrasClave) {
        super(rif, nombres, apellidos, fechaNacimiento, edoCivil, direccion, ciudad, pais, email, telefono, codTelefono, palabrasClave);
        this.ID = id;
        this.tipoMoneda = tipoMoneda;
        this.TipoPago = tipoPago;
        this.salario = salario;
    }

}
