/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package modelo;

/**
 *
 * @author Vicky
 */
public class MCliente {
    private String cliId,cliNombre, cliDirec, cliTelf, cliEmail, cliPais, cliCiudad, cliCodTelf;

    @Override
    public String toString() {
        return cliId + " - " + cliNombre; //To change body of generated methods, choose Tools | Templates.
    }

    public MCliente(String cliId, String cliNombre) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
    }

    public MCliente(String cliId, String cliNombre, String cliDirec, String cliTelf, String cliEmail, String cliPais, String cliCiudad, String cliCodTelf) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliDirec = cliDirec;
        this.cliTelf = cliTelf;
        this.cliEmail = cliEmail;
        this.cliPais = cliPais;
        this.cliCiudad = cliCiudad;
        this.cliCodTelf= cliCodTelf;
    }

    public String getCliCodTelf() {
        return cliCodTelf;
    }

    public void setCliCodTelf(String cliCodTelf) {
        this.cliCodTelf = cliCodTelf;
    }

    public MCliente() {
        
    }

    public String getCliId() {
        return cliId;
    }

    public void setCliId(String cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliDirec() {
        return cliDirec;
    }

    public void setCliDirec(String cliDirec) {
        this.cliDirec = cliDirec;
    }

    public String getCliTelf() {
        return cliTelf;
    }

    public void setCliTelf(String cliTelf) {
        this.cliTelf = cliTelf;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliPais() {
        return cliPais;
    }

    public void setCliPais(String cliPais) {
        this.cliPais = cliPais;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }
    
}
