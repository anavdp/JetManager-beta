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

import conexion.ConexionSqlite1;
import dao.DaoCandidato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.MCandidato;
import vista.VRegistroCandidato;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class CRegistroCandidato implements ActionListener, KeyListener, ItemListener {

   private VRegistroCandidato vregcan;
   private MCandidato can;
   private boolean modificar;

   public void inicializar() {
       modificar = false;
       //Se borran todos los campos de texto y se seleccionan las opciones por defecto
       vregcan.getCmbPais().setSelectedIndex(0);
       vregcan.getTxtRif().setText("");
       vregcan.getTxtNombres().setText("");
       vregcan.getTxtApellidos().setText("");
       ((JTextField)vregcan.getCalFechaNacimiento().getDateEditor()).setText("");
       vregcan.getCmbEdoCivil().setSelectedIndex(0);
       vregcan.getTxaDireccion().setText("");
       vregcan.getCmbPais().setSelectedIndex(0);
       vregcan.getTxtCiudad().setText("");
       vregcan.getTxtCorreo().setText("");
       vregcan.getLblCodTelefono().setText("+1");
       vregcan.getTxtTelefono().setText("");
       vregcan.getTxaPalabrasClave().setText("");
       
       //Se habilitan y deshabilitan los componentes
       vregcan.getCmbRif().setEnabled(true);
       vregcan.getTxtRif().setEnabled(true);
       vregcan.getTxtNombres().setEnabled(false);
       vregcan.getTxtApellidos().setEnabled(false);
       vregcan.getCalFechaNacimiento().setEnabled(false);
       vregcan.getCmbEdoCivil().setEnabled(false);
       vregcan.getTxaDireccion().setEnabled(false);
       vregcan.getCmbPais().setEnabled(false);
       vregcan.getTxtCiudad().setEnabled(false);
       vregcan.getTxtCorreo().setEnabled(false);
       vregcan.getTxtTelefono().setEnabled(false);
       vregcan.getTxaPalabrasClave().setEnabled(false);
       vregcan.getBtnModificar().setEnabled(false);
       vregcan.getBtnCancelar().setEnabled(false);
       vregcan.getBtnGuardar().setEnabled(false);
       vregcan.getBtnBuscar().setEnabled(false);
       vregcan.getBtnEliminar().setEnabled(false);
       vregcan.getBtnSalir().setEnabled(true);
   }
   
   public void habilitarRegistro() {
       vregcan.getCmbRif().setEnabled(false);
       vregcan.getTxtRif().setEnabled(false);
       vregcan.getTxtNombres().setEnabled(true);
       vregcan.getTxtApellidos().setEnabled(true);
       vregcan.getCalFechaNacimiento().setEnabled(true);
       vregcan.getCmbEdoCivil().setEnabled(true);
       vregcan.getTxaDireccion().setEnabled(true);
       vregcan.getCmbPais().setEnabled(true);
       vregcan.getTxtCiudad().setEnabled(true);
       vregcan.getTxtCorreo().setEnabled(true);
       vregcan.getTxtTelefono().setEnabled(true);
       vregcan.getTxaPalabrasClave().setEnabled(true);
       vregcan.getBtnCancelar().setEnabled(true);
       vregcan.getBtnModificar().setEnabled(false);
       vregcan.getBtnGuardar().setEnabled(true);
       vregcan.getBtnEliminar().setEnabled(false);
   }
   
    public CRegistroCandidato() {
        this.can = new MCandidato();
        this.vregcan = new VRegistroCandidato();
        vregcan.agregarListener((ActionListener) this);
        vregcan.agregarItemListener((ItemListener) this);
        inicializar();
        vregcan.setVisible(true);
        
        vregcan.getTxtRif().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtRif().getText().length() >= 9) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                    
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            traerResultados();
                        }
                    }
                    
                    @Override
                    public void keyReleased(KeyEvent e) {
                        if(vregcan.getTxtRif().getText().isEmpty()) {
                            vregcan.getBtnBuscar().setEnabled(false);
                            return;
                        }
                        vregcan.getBtnBuscar().setEnabled(true);
                    }
                });
        
        vregcan.getTxtNombres().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtNombres().getText().length() >= 25) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
        
        vregcan.getTxtApellidos().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtApellidos().getText().length() >= 25) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
        
        vregcan.getTxaDireccion().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxaDireccion().getText().length() >= 80) {
                            e.consume();
                        }
                    }
                });
        
        vregcan.getTxtCiudad().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtCiudad().getText().length() >= 30) {
                            e.consume();
                        }
                        
                        char c = e.getKeyChar();
                        if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
        
        vregcan.getTxtCorreo().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtCorreo().getText().length() >= 30) {
                            e.consume();
                        }
                        
                        char c = e.getKeyChar();
                        if(Character.isWhitespace(c)) {
                            e.consume();
                        }
                    }
                });
     
        vregcan.getTxtTelefono().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregcan.getTxtTelefono().getText().length() >= 10) {
                            e.consume();
                        }
                        
                        char c = e.getKeyChar();
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                });
        
        vregcan.getTxaPalabrasClave().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if(!Character.isLetterOrDigit(c)
                                && !Character.isWhitespace(c)
                                && c != '+' && c != '-' && c != '.') {
                            e.consume();
                        }
                    }
                    
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            e.consume();
                        }
                    }
                });
        
    }
   
    public int indiceEdoCivil(char e) {
        switch(e) {
            case 'S':
                return 0;
            case 'C':
                return 1;
            case 'D':
                return 2;
            default:
                return 3;
        }
    }
    
    public void llenarPalabrasClave(String[] palabras) {
        String text = "";
        for(int i=0; i<palabras.length; i++) {
            text += palabras[i] + " ";
        }
        vregcan.getTxaPalabrasClave().setText(text);
    }
    
    public void llenarCampos() {
        vregcan.getTxtNombres().setText(can.getNombres());
        vregcan.getTxtApellidos().setText(can.getApellidos());
        vregcan.getCalFechaNacimiento().setDate(can.getFechaNacimiento());
        vregcan.getCmbEdoCivil().setSelectedIndex(indiceEdoCivil(can.getEdoCivil()));
        vregcan.getTxaDireccion().setText(can.getDireccion());
        vregcan.getCmbPais().setSelectedItem(can.getPais());
        vregcan.getTxtCiudad().setText(can.getCiudad());
        vregcan.getTxtCorreo().setText(can.getEmail());
        vregcan.getLblCodTelefono().setText(can.getCodTelefono());
        vregcan.getTxtTelefono().setText(can.getTelefono());
        llenarPalabrasClave(can.getPalabrasClave());
    }
    
    public void traerResultados() {
        DaoCandidato daoc = new DaoCandidato();
        ResultSet res;
        String rif = vregcan.getCmbRif().getSelectedItem().toString() +
                vregcan.getTxtRif().getText();
        res = daoc.BuscarCandidato(rif);
       try {
           if(!res.next()) {
               int showConfirmDialog = JOptionPane.showConfirmDialog(vregcan,
                       "Candidato no existe. ¿Desea registrarlo?",
                       "Gestionar candidato",
                       JOptionPane.YES_NO_OPTION,
                       JOptionPane.QUESTION_MESSAGE);
               if(showConfirmDialog == JOptionPane.YES_OPTION) {
                   habilitarRegistro();
               }
           }
           else {
               vregcan.getBtnBuscar().setEnabled(false);
               vregcan.getCmbRif().setEnabled(false);
               vregcan.getTxtRif().setEnabled(false);
               vregcan.getBtnCancelar().setEnabled(true);
               try {
                   can.setRif(res.getString("CanRif"));
                   can.setNombres(res.getString("CanNombres"));
                   can.setApellidos(res.getString("CanApellidos"));
                   Date d;
                   try {
                       d = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString("CanFechaNac"));
                        can.setFechaNacimiento(d);
                   } catch (ParseException ex) {
                       Logger.getLogger(CRegistroCandidato.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   can.setEdoCivil(res.getString("CanEdoCivil").charAt(0));
                   System.out.println("EdoCivil = " + can.getEdoCivil());
                   can.setDireccion(res.getString("CanDireccion"));
                   can.setPais(res.getString("CanPais"));
                   can.setCiudad(res.getString("CanCiudad"));
                   can.setEmail(res.getString("CanEmail"));
                   can.setCodTelefono(res.getString("CanCodTelefono"));
                   can.setTelefono(res.getString("CanTelefono"));
                   if(res.getString("CanEstatus").equals("A")) {
                       vregcan.getBtnModificar().setEnabled(true);
                       vregcan.getBtnEliminar().setEnabled(true);
                   }
                   else {
                       JOptionPane.showMessageDialog(vregcan,
                               "El candidato " + can.getNombres() + " " + can.getApellidos() + " ha sido eliminado. Consulte con el administrador.",
                               "Gestionar candidato",
                               JOptionPane.WARNING_MESSAGE);
                   }
                   res.close();
                   res = daoc.consultarPalabrasClavePorCandidato(can.getRif());
                   String txt;
                   String[] palabras;
                   ArrayList<String> arr = new ArrayList<>();
                   while(res.next()) {
                       txt = res.getString("PalPalabra");
                       arr.add(txt);
                   }
                   res.close();
                   palabras = new String[arr.size()];
                   for(int i=0; i<palabras.length; i++) {
                       palabras[i] = arr.get(i);
                   }
                   can.setPalabrasClave(palabras);
                   llenarCampos();
               }
               catch(SQLException ex) {
                   Logger.getLogger(CRegistroCandidato.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       } catch (SQLException ex) {
           Logger.getLogger(CRegistroCandidato.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public String[] obtenerPalabrasClave() {
        StringTokenizer st = new StringTokenizer(vregcan.getTxaPalabrasClave().getText());
        String[] palabras = new String[st.countTokens()];
        for(int i=0; i<palabras.length; i++) {
            palabras[i] = st.nextToken();
            System.out.println("Palabra " + (i+1) + ": " + palabras[i]);
        }
        return palabras;
    }
    
    public void setearCandidato() {
        can.setRif(vregcan.getCmbRif().getSelectedItem().toString() + vregcan.getTxtRif().getText());
        can.setNombres(vregcan.getTxtNombres().getText());
        can.setApellidos(vregcan.getTxtApellidos().getText());
        can.setFechaNacimiento(vregcan.getCalFechaNacimiento().getDate());
        can.setEdoCivil(vregcan.getCmbEdoCivil().getSelectedItem().toString().charAt(0));
        can.setDireccion(vregcan.getTxaDireccion().getText());
        can.setPais(vregcan.getCmbPais().getSelectedItem().toString());
        can.setCiudad(vregcan.getTxtCiudad().getText());
        can.setEmail(vregcan.getTxtCorreo().getText());        
        can.setCodTelefono(vregcan.getLblCodTelefono().getText());
        can.setTelefono(vregcan.getTxtTelefono().getText());
        can.setPalabrasClave(obtenerPalabrasClave());
    }
    
    public void registrarCandidato() {
        setearCandidato();
        new DaoCandidato().InsertarCandidato(can);
    }
    
    public void modificarCandidato() {
        setearCandidato();
        new DaoCandidato().modificarCandidato(can);
    }
    
    public void eliminarCandidato() {
        int respuesta = JOptionPane.showConfirmDialog(vregcan,
                "¿Está seguro de que desea eliminar al candidato " + can.getNombres() + " " + can.getApellidos() + "?",
                "Gestionar candidato",
                JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION) {
            if(new DaoCandidato().eliminarCandidato(can)) {
                JOptionPane.showMessageDialog(vregcan,
                    "Candidato eliminado satisfactoriamente.",
                    "Gestionar candidato",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(vregcan,
                    "Error al conectar con la base de datos. No se pudo eliminar el registro.",
                    "Gestionar candidato",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vregcan.getBtnCancelar())) {
            inicializar();
            return;
        }
        
        if(e.getSource().equals(vregcan.getBtnModificar())) {
            modificar = true;
            habilitarRegistro();
            return;
        }
        
        if(e.getSource().equals(vregcan.getBtnGuardar())) {
            if (!modificar) {
                registrarCandidato();
            } else {
                modificarCandidato();
            }
            JOptionPane.showMessageDialog(vregcan,
                    "Cambios guardados satisfactoriamente.",
                    "Gestionar candidato",
                    JOptionPane.INFORMATION_MESSAGE);
            inicializar();
            return;
        }
        
        if(e.getSource().equals(vregcan.getBtnBuscar())) {
            traerResultados();
            return;
        }
        
        if(e.getSource().equals(vregcan.getBtnEliminar())) {
            eliminarCandidato();
            inicializar();
            return;
        }
        
        if(e.getSource().equals(vregcan.getBtnSalir())) {
            vregcan.dispose();
            return;
        }
        
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(vregcan.getCmbPais())) {
            if(vregcan.getCmbPais().getItemAt(186).equals(vregcan.getCmbPais().getSelectedItem())) {
                vregcan.getLblCodTelefono().setText("+58");
            }
        }
        //NO descomentar la siguiente línea:
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
