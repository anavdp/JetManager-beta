/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL

 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Mensajes;
import vista.VMenuPrincipal;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class CMenuPrincipal implements ActionListener {
    
    private final VMenuPrincipal vmenprin;
  
    
    public CMenuPrincipal() throws SQLException {
        vmenprin = new VMenuPrincipal();
        vmenprin.setVisible(true);
        vmenprin.agregarListener(this);
        
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(vmenprin.getJmenAsignarCandidato()) || e.getSource().equals(vmenprin.getBtnAsignarCandidatos())){
         new CAsignarCandidato();
     }
     if(e.getSource().equals(vmenprin.getjMenuConsultarCandidato() )|| e.getSource().equals(vmenprin.getBtnConsultarCandidato())){
         new CConsultaCandidatos();
     }
     
     if(e.getSource().equals(vmenprin.getJMenuConsultarCliente() )|| e.getSource().equals(vmenprin.getBtnConsultarCliente())){
         new CConsultaCliente();
     }
     if(e.getSource().equals(vmenprin.getJmenConsultarEntrevistas()) || e.getSource().equals(vmenprin.getBtnConsultarEntrevista())){
         new CConsultaEntrevista();
     }
      if(e.getSource().equals(vmenprin.getJmenRecordPagos()) || e.getSource().equals(vmenprin.getBtnConsultarRecordPagos())) {
         try {
             new CConsultaRecordPago();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         } catch (SQLException ex) {
             Logger.getLogger(CMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }}
      
      if(e.getSource().equals(vmenprin.getJmenRecordUtilidad()) || e.getSource().equals(vmenprin.getBtnConsultarRecordUtilidad())){
         try {
             new CConsultaRecordUtilidad();
         } catch (SQLException ex) {
             Logger.getLogger(CMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      
      if(e.getSource().equals(vmenprin.getJmenConsultarFaltas())    || e.getSource().equals(vmenprin.getBtnConsultarFaltas())){
          new CConsultarFaltas();      }
    
    if(e.getSource().equals(vmenprin.getjMenuConsultarProyecto()) || e.getSource().equals(vmenprin.getBtnConsultarProyectos())){
        new CConsultarProyecto();
    }
    
    if(e.getSource().equals(vmenprin.getJmenDiasFeriados())){
         try {
             new CDiaFeriado();
         } catch (SQLException ex) {
             Logger.getLogger(CMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    if(e.getSource().equals(vmenprin.getJmenConsultarHorasLaboradas()) || e.getSource().equals(vmenprin.getBtnGestionarHoras())){
         try {
             new CGestionHorasLaboradas();
         } catch (SQLException ex) {
             Logger.getLogger(CMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    if(e.getSource().equals(vmenprin.getJmenPagoNomina()) || e.getSource().equals(vmenprin.getBtnPagarNomina())){
         try {
             new CPagoDeNomina();
         } catch (SQLException ex) {
             Logger.getLogger(CMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    if(e.getSource().equals(vmenprin.getJmenRegistrarFaltas()) || e.getSource().equals(vmenprin.getBtnRegistrarFaltas())){
        new CRegistrarFaltas();
    }
    if(e.getSource().equals(vmenprin.getJmenRegistrarCandidato()) || e.getSource().equals(vmenprin.getBtnRegistrarCandidato())){
        new CRegistroCandidato();
        
    }
    if(e.getSource().equals(vmenprin.getJmenuRegistrarCliente()) || e.getSource().equals(vmenprin.getBtnRegistrarCliente())){
        new CRegistroCliente();
    }
    if(e.getSource().equals(vmenprin.getJmenRegistrarEntrevistas()) || e.getSource().equals(vmenprin.getBtnRegistrarEntrevista())){
        new CRegistroEntrevista();
    }
    if(e.getSource().equals(vmenprin.getBtnSalir())){
        JOptionPane.showMessageDialog(null, "Hasta Pronto...");
        vmenprin.dispose();
    }
    }
    
}
