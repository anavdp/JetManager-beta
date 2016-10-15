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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import vista.VRegistroCliente;
import modelo.MProyecto;
import dao.DaoCliente;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.MCliente;
import dao.DaoProyecto;
/*
 *
 * @author Vicky
 */
public class CRegistroCliente implements ActionListener, KeyListener, FocusListener{
    private static VRegistroCliente vrc;
    private static MProyecto proy;
    private DaoCliente daoC;
    private MCliente cli;
    private DaoProyecto daoP;
    private static boolean Existe;
    public CRegistroCliente() {
        vrc= new VRegistroCliente();
        
        vrc.setVisible(true);
        vrc.agregarListener(this);
      vrc.agregarFocusListener(this);
        daoC=new DaoCliente();
        daoP=new DaoProyecto();
        cli= new MCliente();
        proy= new MProyecto();
        vrc.getTxtProyId().setText(proy.getProyId());
        vrc.getTxtRifCliente().requestFocus();
        vrc.getTxtRifCliente().addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
           soloNumeros(e);       
           if(vrc.getTxtRifCliente().getText().length() >= 9) {
                            e.consume();
                        }
            }       
        });
        vrc.getTxtCodTelf().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloNumeros(e);
                if(vrc.getTxtCodTelf().getText().length() >= 4) {
                            e.consume();
                        }
            }
        
        });
        
        vrc.getTxtTelfCliente().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloNumeros(e);
                if(vrc.getTxtTelfCliente().getText().length() >= 10) {
                            e.consume();
                        }
            }
                });
        
        vrc.getTxtCiudad().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloLetras(e);
            }
              });
                
        vrc.getTxtNomCliente().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                soloLetras(e);
            }
        
        });
        vrc.getTxtCorreo().addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyTyped(KeyEvent e){
                char tecla= e.getKeyChar();
                if(Character.isWhitespace(tecla)){
                    e.consume();
                }
            }
        
        });
        
        
    }
 
public void soloLetras(KeyEvent e){
    char t= e.getKeyChar();
    if(Character.isDigit(t)){
        e.consume();
    }
          
}
public void soloNumeros(KeyEvent e){
     char t= e.getKeyChar();
            if(Character.isLetter(t)){
                e.consume();
            }
}


public void buscarCliente(){
    String rif= vrc.getCmbRif().getSelectedItem().toString()+vrc.getTxtRifCliente().getText();
    ResultSet rs;
    if(vrc.getTxtRifCliente().getText().isEmpty()){
        vrc.getTxtRifCliente().requestFocus();
    }else{
        
        try {
            rs= daoC.buscarCliente(rif);
            if(rs.next()){//Cliente eliminado y encontrado
                char e= 'E';
                if(rs.getString("CliEstatus").equals(e)){
                    JOptionPane.showMessageDialog(null, "Error, cliente eliminado. Contacte al administrador.");
                    vrc.getTxtRifCliente().setText("");
                }else{//Cliente Activo y encontrado
                    Existe=true;
                cli.setCliId(rif);
                cli.setCliNombre(rs.getString("CliRazonSocial"));
                cli.setCliEmail(rs.getString("CliEmail"));
                cli.setCliTelf(rs.getString("CliTelefono"));
                cli.setCliDirec(rs.getString("CliDireccion"));
                cli.setCliCiudad(rs.getString("CliCiudad"));
                cli.setCliPais(rs.getString("CliPais"));
                cli.setCliCodTelf(rs.getString("CliCodTelefono"));
                  rs.close();    
                  //Llenamos el formulario
                  vrc.getTxtRifCliente().setEnabled(false);
                  vrc.getTxtNomCliente().setText(cli.getCliNombre());
                  vrc.getTxtDireccion().setText(cli.getCliDirec());
                  vrc.getTxtCorreo().setText(cli.getCliEmail());
                  vrc.getTxtTelfCliente().setText(cli.getCliTelf());
                  vrc.getCmbPais().setSelectedItem(cli.getCliPais());
                  vrc.getTxtCiudad().setText(cli.getCliCiudad());
                  vrc.getTxtCodTelf().setText(cli.getCliCodTelf());
                 
                  //Deshabilitamos los campos del cliente
                    vrc.getTxtNomCliente().setEnabled(false);
                  vrc.getTxtDireccion().setEnabled(false);
                  vrc.getTxtCorreo().setEnabled(false);
                  vrc.getTxtTelfCliente().setEnabled(false);
                  vrc.getCmbPais().setEnabled(false);
                  vrc.getTxtCiudad().setEnabled(false);
                  vrc.getTxtCodTelf().setEnabled(false);
                }
            }else{
                  //Cliente no encontrado
                
                  Existe=false;
                  vrc.getTxtNomCliente().requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
public void agregarClienteyProyecto(){
    Date fi,ff;
   if(vrc.getTxtRifCliente().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese el rif del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
       vrc.getTxtRifCliente().requestFocus();
       return;      
   }
   if(vrc.getTxtNomCliente().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese el Nombre del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
       vrc.getTxtNomCliente().requestFocus();
       return;
   }
    if(vrc.getTxtCiudad().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese la ciudad");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
       vrc.getTxtCiudad().requestFocus();
       return;
   } if(vrc.getTxtDireccion().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese la dirección del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
       vrc.getTxtDireccion().requestFocus();
       return;
   } 
   if(vrc.getTxtCodTelf().getText().isEmpty() || vrc.getTxtTelfCliente().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese un telefono valido del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
      
       return;
   } 
   if(vrc.getTxtCorreo().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese el correo del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getTabCliente());
       
       return;
   } 
    if(vrc.getCmbPais().getSelectedIndex()==0){
       JOptionPane.showMessageDialog(null, "Por favor ingrese el Nombre del cliente");
       vrc.getTabCliente().setSelectedComponent(vrc.getPanCliente());
       vrc.getCmbPais().requestFocus();
       return;
   }
   //Verificando los datos de proyecto 
   if(vrc.getTxtTitProy().getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Por favor ingrese el titulo del proyecto");
       vrc.getTxtTitProy().requestFocus();
       return;
   }
   
   String fechai= vrc.getDTPFechaIni().getDate().toString();
   String fechaf= vrc.getDTPFechaFinal().getDate().toString();
   
   if( fechai.isEmpty() || fechaf.isEmpty()){
       JOptionPane.showMessageDialog(null, "Seleccione la fechas de inicio/fin del proyecto.");
       return;
       
   }else{
       fi= vrc.getDTPFechaIni().getDate();
       ff= vrc.getDTPFechaFinal().getDate();
       if(fi.after(ff) || ff.equals(fi) ){
           JOptionPane.showMessageDialog(null, "Error: Verifique las fechas inicio/fin seleccionadas.");
           return;
       }
       
       if(vrc.getCmbIdioma().getSelectedIndex()==0){
           JOptionPane.showMessageDialog(null, "Seleccione un idioma para el proyecto.");
           return;
       }
       if(Existe){
           agregarProyecto();
       }else{
           String rif= vrc.getCmbRif().getSelectedItem().toString()+ vrc.getTxtRifCliente().getText();
       cli.setCliCiudad(vrc.getTxtCiudad().getText());
       cli.setCliDirec(vrc.getTxtDireccion().getText());
       cli.setCliEmail(vrc.getTxtCorreo().getText());
       cli.setCliId(rif);
       cli.setCliNombre(vrc.getTxtNomCliente().getText());
       cli.setCliPais(vrc.getCmbPais().getSelectedItem().toString());
       cli.setCliTelf(vrc.getTxtTelfCliente().getText());
       cli.setCliCodTelf(vrc.getTxtCodTelf().getText());
       if(daoC.agregarCliente(cli)){
           agregarProyecto();               
       }else{JOptionPane.showMessageDialog(null, "Registro NO Exitoso. Error de Cliente");}
       }
   
}}
public void agregarProyecto(){
    
    
            proy.setProyDesc(vrc.getTxtDescProy().getText());
           proy.setProyFechaFin(vrc.getDTPFechaIni().getDate());
           proy.setProyFechaInicio(vrc.getDTPFechaIni().getDate());
           proy.setProyIdCliente(cli.getCliId());
           proy.setProyIdioma(vrc.getCmbIdioma().getSelectedItem().toString());
           proy.setProyTitulo(vrc.getTxtTitProy().getText());
    if(daoP.agregarProyecto(proy)){
               JOptionPane.showMessageDialog(null, "Registro Exitoso");
               vrc.dispose();
              
           }else{
               JOptionPane.showMessageDialog(null, "Registro NO Exitoso. Error de proyecto.");
               
           }
}
           
public void Limpiar(){
                vrc.getTxtRifCliente().setEnabled(true);
                vrc.getTxtNomCliente().setEnabled(true);
                  vrc.getTxtDireccion().setEnabled(true);
                  vrc.getTxtCorreo().setEnabled(true);
                  vrc.getTxtTelfCliente().setEnabled(true);
                  vrc.getCmbPais().setEnabled(true);
                  vrc.getTxtCiudad().setEnabled(true);
                  vrc.getTxtCodTelf().setEnabled(true);
                  
                  vrc.getTxtCodTelf().setEditable(true);
                  vrc.getTxtRifCliente().setEditable(true);
                  vrc.getTxtNomCliente().setEditable(true);
                  vrc.getTxtDireccion().setEditable(true);
                  vrc.getTxtCorreo().setEditable(true);
                  vrc.getTxtTelfCliente().setEditable(true);
                  vrc.getCmbPais().setEditable(true);
                  vrc.getTxtCiudad().setEditable(true);
                  
                  vrc.getTxtNomCliente().setText("");
                  vrc.getTxtDireccion().setText("");
                  vrc.getTxtCorreo().setText("");
                  vrc.getTxtTelfCliente().setText("");
                  vrc.getCmbPais().setSelectedIndex(0);
                  vrc.getTxtCiudad().setText("");
                  vrc.getTxtRifCliente().setText("");
                  vrc.getTxtCodTelf().setText("");
                  vrc.getTxtRifCliente().requestFocus() ;
                  
                  
}

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(vrc.getBtnSiguiente())){
           vrc.getTabCliente().setSelectedComponent(vrc.getPanProy());
       }
       if(e.getSource().equals(vrc.getBtnAgregar())){
           agregarClienteyProyecto();
       }
       if(e.getSource().equals(vrc.getBtnCancelar())){
           Limpiar();
       }
       if(e.getSource().equals(vrc.getBtnSalir())){
           vrc.dispose();
           
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
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
       if( e.getSource().equals(vrc.getTxtRifCliente())){
           buscarCliente();
       }
       if(e.getSource().equals(vrc.getTxtCorreo())){
           vrc.getBtnSiguiente().requestFocus();
       }
    }


    
}
