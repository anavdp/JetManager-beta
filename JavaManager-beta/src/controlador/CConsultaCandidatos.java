/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import dao.DaoEntrevista;
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
import vista.VConsultaCandidatos;

/**
 *
 * @author Julio César
 */
public class CConsultaCandidatos implements ActionListener, KeyListener {

    private VConsultaCandidatos vccan;
    private MCandidato can;
    private DaoCandidato daoc;
    private DefaultTableModel modelo;

    public CConsultaCandidatos() {
        vccan = new VConsultaCandidatos();
        can = new MCandidato();
        daoc = new DaoCandidato();
        vccan.Agregar_Listener(this);
        modelo = new DefaultTableModel();
        vccan.getTableReporteNombres().setModel(modelo);
        inicializar();
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("País");
        modelo.addColumn("E-mail");
        vccan.setVisible(true);
        
        vccan.getTxtNombres().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vccan.getTxtNombres().getText().length() >= 25) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
        
        vccan.getTxtApellidos().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vccan.getTxtApellidos().getText().length() >= 25) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
    }
    
    public void inicializar() {
        //modelo.setRowCount(0);
        vccan.getBtnConsultarNombres().setVisible(false);
        vccan.getBtnConsultarPalabrasClave().setVisible(false);
        vccan.getLblNombres().setVisible(false);
        vccan.getLblApellidos().setVisible(false);
        vccan.getLblPalabrasClave().setVisible(false);
        vccan.getTxtNombres().setVisible(false);
        vccan.getTxtApellidos().setVisible(false);
        vccan.getTxtPalabrasClave().setVisible(false);
    }
    
    public void mostrarPorNombres() {
        vccan.getBtnConsultarPalabrasClave().setVisible(false);
        vccan.getLblPalabrasClave().setVisible(false);
        vccan.getTxtPalabrasClave().setVisible(false);
        vccan.getBtnConsultarNombres().setVisible(true);
        vccan.getLblNombres().setVisible(true);
        vccan.getLblApellidos().setVisible(true);
        vccan.getTxtNombres().setVisible(true);
        vccan.getTxtApellidos().setVisible(true);
    }
    
    public void mostrarPorPalabrasClave() {
        vccan.getBtnConsultarNombres().setVisible(false);
        vccan.getLblNombres().setVisible(false);
        vccan.getLblApellidos().setVisible(false);
        vccan.getTxtNombres().setVisible(false);
        vccan.getTxtApellidos().setVisible(false);
        vccan.getBtnConsultarPalabrasClave().setVisible(true);
        vccan.getLblPalabrasClave().setVisible(true);
        vccan.getTxtPalabrasClave().setVisible(true);
    }
    
    public String[] traerPalabrasClave(String rif) {
        ResultSet res = daoc.consultarPalabrasClavePorCandidato(rif);
        String txt;
        String[] palabras;
        ArrayList<String> arr = new ArrayList<>();
        try {
            while(res.next()) {
                txt = res.getString("PalPalabra");
                arr.add(txt);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        palabras = new String[arr.size()];
        for(int i=0; i<palabras.length; i++) {
           palabras[i] = arr.get(i);
        }
        return palabras;
    }
    
    public boolean candidatoAsignado() {
        ResultSet res = new DaoEntrevista().consultarEntrevistasPorCandidato(can.getRif());
        try {
            while(res.next()) {
                if(res.getString("EntResultado").equals("A")) {
                    res.close();
                    return true;
                }
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet traerResultadosNombres() {
        ResultSet res;
        String nom = vccan.getTxtNombres().getText();
        String ape = vccan.getTxtApellidos().getText();
        if(!nom.isEmpty() && !ape.isEmpty()) {
            res = daoc.consultarCandidatosPorNombresApellidos(nom, ape);
        } else if(!nom.isEmpty()){
            res = daoc.consultarCandidatosPorNombres(nom);
        } else if(!ape.isEmpty()) {
            res = daoc.consultarCandidatosPorApellidos(ape);
        } else {
            JOptionPane.showMessageDialog(vccan,
                    "Debe ingresar al menos un carácter en un campo.",
                    "JET MANAGER", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return res;
    }
    
    public String[] obtenerPalabrasClave() {
        StringTokenizer st = new StringTokenizer(vccan.getTxtPalabrasClave().getText());
        String[] palabras = new String[st.countTokens()];
        for(int i=0; i<palabras.length; i++) {
            palabras[i] = st.nextToken();
            System.out.println("Palabra " + (i+1) + ": " + palabras[i]);
        }
        return palabras;
    }
    
    public ResultSet traerResultadosPalabras() {
        String[] palabras = obtenerPalabrasClave();
        return daoc.consultarCandidatosPorPalabrasClave(palabras);
    }
    
    public void llenarTabla(ResultSet res) {
        try {
            if(!res.next()) {
                JOptionPane.showMessageDialog(vccan,
                        "No se encontraron resultados.", 
                        "JET MANAGER", JOptionPane.WARNING_MESSAGE);
            }
            else {
                do {
                    //Object[] ob = new Object[5];
                    Object[] ob = new Object[5];
                    can.setRif(res.getString("CanRif"));
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
                vccan.getScrollpanReporteProyecto().setVisible(true);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vccan.getRadNombres())) {
            mostrarPorNombres();
            return;
        }
        
        if (e.getSource().equals(vccan.getRadPalabrasClave())) {
            mostrarPorPalabrasClave();
            return;
        }
        
        if (e.getSource().equals(vccan.getBtnConsultarNombres())) {
            modelo.setRowCount(0);
            llenarTabla(traerResultadosNombres());
            return;
        }
        
        if (e.getSource().equals(vccan.getBtnConsultarPalabrasClave())) {
            modelo.setRowCount(0);
            llenarTabla(traerResultadosPalabras());
            return;
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
