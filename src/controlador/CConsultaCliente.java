/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//**
/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package controlador;

import java.awt.event.ActionListener;
import modelo.MCliente;
import conexion.ConexionSqlite1;
import dao.DaoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VConsultaCliente;
/**
 *
 * @author Vicky
 */
public class CConsultaCliente implements ActionListener,KeyListener{
private static VConsultaCliente vcc;
private MCliente cli;
private DaoCliente daoC;

    public CConsultaCliente() {
        vcc= new VConsultaCliente();
        vcc.setVisible(true);
        vcc.agregarListener(this);
        cli=new MCliente();
        daoC= new DaoCliente();
        
        vcc.getTxtRifCliente().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloNumeros(e);
                if(vcc.getTxtRifCliente().getText().length() >= 9) {
                            e.consume();
                        }
            }
        
        });
        vcc.getTxtTelfCliente().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloNumeros(e);
                if(vcc.getTxtTelfCliente().getText().length() >= 10) {
                            e.consume();
                        }
            }
        
        });
                vcc.getTxtCodTelf().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloNumeros(e);
                if(vcc.getTxtCodTelf().getText().length() >= 4) {
                            e.consume();
                        }
            }
        
        });
        
        vcc.getTxtCiudad().addKeyListener(new KeyAdapter(){ 
            public void keyTyped(KeyEvent e){
                soloLetras(e);
            }
        
        });
        vcc.getTxtEmailCliente().addKeyListener(new KeyAdapter(){ 
            public void keyTyped(KeyEvent e){
                char tecla= e.getKeyChar();
                if(Character.isWhitespace(tecla)){
                    e.consume();
                }
            }
        
        });
    }

    public void soloLetras(KeyEvent e){
        char tecla= e.getKeyChar();
        if(!Character.isLetter(tecla)){
            e.consume();
        }
    }
    public void soloNumeros(KeyEvent e){
        char tecla= e.getKeyChar();
        if(Character.isLetter(tecla)){
            e.consume();
        }
    }
    public void buscarCliente(){
        String rifCliente=vcc.getCmbRif().getSelectedItem().toString()+vcc.getTxtRifCliente().getText();
        
        ResultSet rs;
        
        if(vcc.getTxtRifCliente().getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Por favor introduzca el rif.");
        vcc.getTxtRifCliente().requestFocus();
        return;
        }
        
    try {
        rs= daoC.buscarCliente(rifCliente);
        if(rs.next()){
            String estatus="E";
            
            if(rs.getString("CliEstatus").equals(estatus)){
                Limpiar();
                JOptionPane.showMessageDialog(null,"Error, cliente eliminado.");
                
            }else{
                
                
                cli.setCliId(rs.getString("CliRif"));
                cli.setCliNombre(rs.getString("CliRazonSocial"));
                cli.setCliEmail(rs.getString("CliEmail"));
                cli.setCliCodTelf(rs.getString("CliCodTelefono"));
                cli.setCliTelf(rs.getString("CliTelefono"));
                cli.setCliDirec(rs.getString("CliDireccion"));
                cli.setCliCiudad(rs.getString("CliCiudad"));
                cli.setCliPais(rs.getString("CliPais"));
                  rs.close();    
                  
                  vcc.getBtnBuscar().setEnabled(false);
                  vcc.getTxtRifCliente().setEnabled(false);
                  vcc.getTxtNomCliente().setText(cli.getCliNombre());
                  vcc.getTxtDirCliente().setText(cli.getCliDirec());
                  vcc.getTxtEmailCliente().setText(cli.getCliEmail());
                  vcc.getTxtCodTelf().setText(cli.getCliCodTelf());
                  vcc.getTxtTelfCliente().setText(cli.getCliTelf());
                  vcc.getCmbPais().setSelectedItem(cli.getCliPais());
                  vcc.getTxtCiudad().setText(cli.getCliCiudad());
                  vcc.getBtnModificar().setEnabled(true);
                  vcc.getBtnEliminar().setEnabled(true);
                  vcc.getBtnCancelar().setEnabled(true); 
                   vcc.getBtnCancelar().setVisible(true);
                  
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro el cliente.");
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(CConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    

    }
    public void modificarCliente(){
        vcc.getBtnModificar().setVisible(false);
        vcc.getBtnAceptar().setVisible(true);
       
        vcc.getBtnEliminar().setVisible(false);
        vcc.getTxtDirCliente().setEditable(true);
        vcc.getTxtDirCliente().setEnabled(true);
        vcc.getTxtTelfCliente().setEnabled(true);
        vcc.getTxtTelfCliente().setEditable(true);
        vcc.getTxtCodTelf().setEnabled(true);
        vcc.getTxtCodTelf().setEditable(true);
        vcc.getTxtEmailCliente().setEnabled(true);
        vcc.getTxtEmailCliente().setEnabled(true);
        vcc.getTxtCiudad().setEnabled(true);
        vcc.getTxtCiudad().setEditable(true);
        vcc.getCmbPais().setEnabled(true);
        vcc.getCmbPais().setEditable(true);    
        
    }
    public void Limpiar(){
        vcc.getBtnCancelar().setVisible(false);
        vcc.getBtnBuscar().setEnabled(true);
        vcc.getBtnEliminar().setVisible(true);
        vcc.getBtnEliminar().setEnabled(false);
        vcc.getBtnModificar().setEnabled(false);
        vcc.getBtnModificar().setVisible(true);
        vcc.getBtnAceptar().setVisible(false);
        vcc.getBtnCancelar().setVisible(false);
        vcc.getTxtDirCliente().setEditable(false);
        vcc.getTxtDirCliente().setEnabled(false);
        vcc.getTxtTelfCliente().setEnabled(false);
        vcc.getTxtTelfCliente().setEditable(false);
        vcc.getTxtEmailCliente().setEnabled(false);
        vcc.getTxtEmailCliente().setEnabled(false);
        vcc.getTxtCiudad().setEnabled(false);
        vcc.getTxtCiudad().setEditable(false);
        vcc.getCmbPais().setEnabled(false);
        vcc.getCmbPais().setEditable(false); 
        vcc.getTxtNomCliente().setText("");
        vcc.getTxtRifCliente().setText("");
        vcc.getTxtTelfCliente().setText("");
        vcc.getTxtEmailCliente().setText("");
        vcc.getTxtDirCliente().setText("");
        vcc.getTxtCiudad().setText("");
        vcc.getTxtCodTelf().setText("");
        vcc.getCmbPais().setSelectedIndex(0);
        vcc.getTxtRifCliente().setEnabled(true);
        vcc.getTxtRifCliente().setEditable(true);
        vcc.getTxtCodTelf().setEnabled(false);
        
        
    }
    public void aceptarCambios(){
        String ciu,pais,telf,email,direc, cod;
        ciu=vcc.getTxtCiudad().getText();
        pais= vcc.getCmbPais().getSelectedItem().toString();
        telf= vcc.getTxtTelfCliente().getText();
        email= vcc.getTxtEmailCliente().getText();
        direc= vcc.getTxtDirCliente().getText();
        cod= vcc.getTxtCodTelf().getText();
        if(ciu.equals(cli.getCliCiudad()) && pais.equals(cli.getCliPais()) 
                && telf.equals(cli.getCliTelf()) && email.equals(cli.getCliEmail()) 
                   && direc.equals(cli.getCliDirec()) && cod.equals(cli.getCliCodTelf())){
            JOptionPane.showMessageDialog(null, "No ha realizado nigun cambio.");
            
        }else{
            if(ciu.equals("") || pais.equals("...") || telf.equals("") || direc.equals("") || email.equals("") || cod.equals("")){
                JOptionPane.showMessageDialog(null, "Error: no se aceptan campos vacios.");
            }else{
            if(!ciu.equals(cli.getCliCiudad())){
                
               cli.setCliCiudad(ciu);
            }
            if(!pais.equals(cli.getCliPais()) ){
                cli.setCliPais(pais);
            }
            if(!telf.equals(cli.getCliTelf()) ){
                cli.setCliTelf(telf);
            }
            if(!direc.equals(cli.getCliDirec()) ){
                cli.setCliDirec(direc);
            }
            if(!email.equals(cli.getCliEmail())){
                cli.setCliEmail(email);
            }
            if(!cod.equals(cli.getCliCodTelf())){
                cli.setCliCodTelf(cod);
            }
            if(daoC.modificarCliente(cli)){
                JOptionPane.showMessageDialog(null, "Cliente Modificado Exitosamente");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar");
            }
            }
        }
        
   
            
    }
    
    public void eliminarCliente(){
        int r= JOptionPane.showConfirmDialog(null, "Seguro Eliminar");
        if(r==0){
            if(daoC.eliminarCliente(cli.getCliId())){
                JOptionPane.showMessageDialog(null,"Cliente eliminado satisfactoriamente");
                Limpiar();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if( e.getSource().equals(vcc.getBtnBuscar()) || e.getSource().equals(vcc.getTxtRifCliente())){
               buscarCliente();
           }
           if(e.getSource().equals(vcc.getBtnModificar())){
               modificarCliente();
           }
           if(e.getSource().equals(vcc.getBtnCancelar())){
               Limpiar();
           }
           if(e.getSource().equals(vcc.getBtnSalir())){
               vcc.dispose();
           }
           if(e.getSource().equals(vcc.getBtnAceptar())){
               aceptarCambios();
           }
           if(e.getSource().equals(vcc.getBtnEliminar())){
               eliminarCliente();
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
    
}
