/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package controlador;

import dao.DaoCandidato;
import dao.DaoEmpleado;
import dao.DaoEntrevista;
import dao.DaoProyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MCandidato;
import modelo.MEmpleado;
import modelo.MProyecto;
import vista.VAsignarCandidato;

/**
 *
 * @author Julio César
 */
public class CAsignarCandidato implements ActionListener, KeyListener {

    private VAsignarCandidato vacan;
    private MCandidato can;
    private MEmpleado emp;
    private MProyecto proy;
    private DaoCandidato daoc;
    private DaoEmpleado daoe;
    private DaoProyecto daop;
    private DefaultTableModel modelo, modeloProy;

    public CAsignarCandidato() {
        vacan = new VAsignarCandidato();
        can = new MCandidato();
        emp = new MEmpleado();
        proy = new MProyecto();
        daoc = new DaoCandidato();
        daoe = new DaoEmpleado();
        daop = new DaoProyecto();
        vacan.Agregar_Listener(this);
        modelo = new DefaultTableModel();
        modeloProy = new DefaultTableModel();
        vacan.getTableReporteNoAsignados().setModel(modelo);
        vacan.getTableReporteProyectos().setModel(modeloProy);
        inicializar();
    }
    
    public void inicializar() {
        vacan.getBtnAsignar().setVisible(true);
        vacan.getLblRif().setVisible(true);
        vacan.getLblProyectos().setVisible(true);
        vacan.getLblProyecto().setVisible(true);
        vacan.getLblTipoMoneda().setVisible(true);
        vacan.getLblTipoPago().setVisible(true);
        vacan.getLblSalario().setVisible(true);
        
        modelo.setRowCount(0);
        modeloProy.setRowCount(0);
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("País");
        modelo.addColumn("E-mail");
        
        modeloProy.addColumn("Código");
        modeloProy.addColumn("Título");
        modeloProy.addColumn("Descripción");
        
        if(!llenarTablaCandidatos(traerCandidatos())) {
            vacan.dispose();
            return;
        }
        if(!llenarTablaProyectos(traerProyectos())) {
            vacan.dispose();
            return;
        }
        llenarComboRif(traerCandidatos());
        llenarComboProyecto(traerProyectos());
        vacan.setVisible(true);
    }
    
    public ResultSet traerCandidatos() {
        return new DaoEntrevista().consultarCandidatosNoAsignados();
    }
    
    public ResultSet traerProyectos() {
        return daop.consultarProyectos();
    }
    
    public void llenarComboRif(ResultSet res) {
        try {
            if(!res.next()) {
                JOptionPane.showMessageDialog(vacan,
                        "No se encontraron resultados.", 
                        "JET MANAGER", JOptionPane.WARNING_MESSAGE);
            }
            else {
                do {
                    can.setRif(res.getString("EntRifCandidato"));
                    vacan.getCmbRif().addItem(can.getRif());
                }while(res.next());
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarComboProyecto(ResultSet res) {
        try {
            if(!res.next()) {
                JOptionPane.showMessageDialog(vacan,
                        "No se encontraron resultados.", 
                        "JET MANAGER", JOptionPane.WARNING_MESSAGE);
            }
            else {
                do {
                    proy.setProyId(res.getString("ProyId"));
                    vacan.getCmbProyecto().addItem(proy.getProyId());
                }while(res.next());
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean llenarTablaProyectos(ResultSet res) {
        try {
            if(!res.next()) {
                JOptionPane.showMessageDialog(vacan,
                        "No hay proyectos disponibles.", 
                        "JET MANAGER", JOptionPane.WARNING_MESSAGE);
                res.close();
                return false;
            }
            else {
                do {
                    Object[] ob = new Object[3];
                    proy.setProyId(res.getString("ProyId"));
                    proy.setProyTitulo(res.getString("ProyTitulo"));
                    proy.setProyDesc(res.getString("ProyDescripcion"));
                    ob[0] = proy.getProyId();
                    ob[1] = proy.getProyTitulo();
                    ob[2] = proy.getProyDesc();
                    System.out.println(ob[0].toString() + " " + ob[1].toString() + " " + ob[2].toString());
                    modeloProy.addRow(ob);
                }while(res.next());
                vacan.getScrollpanReporteProyecto().setVisible(true);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean llenarTablaCandidatos(ResultSet res) {
        try {
            if(!res.next()) {
                JOptionPane.showMessageDialog(vacan,
                        "No hay candidatos por asignar a proyectos.", 
                        "JET MANAGER", JOptionPane.WARNING_MESSAGE);
                res.close();
                return false;
            }
            else {
                do {
                    //Object[] ob = new Object[5];
                    Object[] ob = new Object[5];
                    can.setRif(res.getString("EntRifCandidato"));
                    can.setNombres(res.getString("CanNombres"));
                    can.setApellidos(res.getString("CanApellidos"));
                    can.setPais(res.getString("CanPais"));
                    can.setEmail(res.getString("CanEmail"));
                    ob[0] = can.getRif();
                    ob[1] = can.getNombres();
                    ob[2] = can.getApellidos();
                    //res.close();
                    /*String[] palabras = traerPalabrasClave(ob[0].toString());
                    String txt = palabras[0];
                    for(int i=1; i<palabras.length; i++) {
                        txt += "; " + palabras[i];
                    }*/
                    ob[3] = can.getPais();
                    ob[4] = can.getEmail();
                    System.out.println(ob[0].toString() + " " + ob[1].toString() + " " + ob[2].toString() + " " + ob[3].toString());
                    /*if(candidatoAsignado()) {
                        ob[4] = "Asignado";
                    } else {
                        ob[4] = "En espera";
                    }*/
                    modelo.addRow(ob);
                }while(res.next());
                vacan.getScrollpanReporteProyecto().setVisible(true);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void asignarCandidato() {
        emp.setRif(vacan.getCmbRif().getSelectedItem().toString());
        emp.setTipoMoneda(vacan.getCmbTipoMoneda().getSelectedItem().toString());
        emp.setTipoPago(vacan.getCmbTipoPago().getSelectedItem().toString());
        emp.setSalario(Float.parseFloat(vacan.getTxtSalario().getText()));
        daoe.insertarEmpleados(emp);
        new DaoEntrevista().modificarEstatusEntrevista(emp.getRif(), 'A');
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vacan.getBtnAsignar())) {
            asignarCandidato();
            JOptionPane.showMessageDialog(vacan, 
                    "Candidato asignado exitosamente.", 
                    "JET MANAGER", 
                    JOptionPane.INFORMATION_MESSAGE);
            inicializar();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
