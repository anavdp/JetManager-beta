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
 * @author Julio César
 */
public class MCandidato {
    private String rif;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private char edoCivil;
    private String direccion;
    private String ciudad;
    private String pais;
    private String email;
    private String codTelefono;
    private String telefono;
    private String[] palabrasClave;

    public MCandidato(String rif, String nom, String apell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public MCandidato() {
        super();
    }
    
    /**
     * @param rif
     * @param nombres
     * @param apellidos
     * @param fechaNacimiento
     * @param edoCivil
     * @param direccion
     * @param ciudad
     * @param pais
     * @param email
     * @param codTelefono
     * @param telefono
     * @param palabrasClave
     */
    public MCandidato(String rif, String nombres, String apellidos,
                Date fechaNacimiento, char edoCivil, String direccion,
                String ciudad, String pais, String email, String telefono,
                String codTelefono, String[] palabrasClave) {
    	super();
    	this.rif = rif;
    	this.nombres = nombres;
    	this.apellidos = apellidos;
    	this.fechaNacimiento = fechaNacimiento;
    	this.edoCivil = edoCivil;
    	this.direccion = direccion;
    	this.ciudad = ciudad;
    	this.pais = pais;
    	this.email = email;
        this.codTelefono = codTelefono;
    	this.telefono = telefono;
	this.palabrasClave = palabrasClave;
    }
    
    /**
     * @return the rif
     */
    public String getRif() {
    	return rif;
    }

    /**
    * @param rif the rif to set
     */
    public void setRif(String rif) {
    	this.rif = rif;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
    	return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
    	this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
    	return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
    	this.apellidos = apellidos;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
    	this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the edoCivil
     */
    public char getEdoCivil() {
    	return edoCivil;
    }

    /**
     * @param edoCivil the edoCivil to set
     */
    public void setEdoCivil(char edoCivil) {
    	this.edoCivil = edoCivil;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
    	return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
    	this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
    	return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
    	this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
    	return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
    	this.pais = pais;
    }

    /**
     * @return the email
     */
    public String getEmail() {
    	return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
    	return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
    	this.telefono = telefono;
    }

    /**
     * @return the palabrasClave
     */
    public String[] getPalabrasClave() {
    	return palabrasClave;
    }

    /**
     * @param palabrasClave the palabrasClave to set
     */
    public void setPalabrasClave(String[] palabrasClave) {
    	this.palabrasClave = palabrasClave;
    }
    
}
