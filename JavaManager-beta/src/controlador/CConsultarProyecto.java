/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package controlador;
import modelo.MProyecto;
import dao.DaoProyecto;
import dao.DaoCliente;
import modelo.MCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VConsultaProyecto;

/**
 *
 * @author Vicky
 */
public class CConsultarProyecto implements ActionListener {
    private static VConsultaProyecto vcp;
    private DaoProyecto daoP;
    private DaoCliente daoC;
    private ArrayList<MCliente> listado;
    private MProyecto proy;
    private ArrayList<MProyecto> proyectos;
       

    public CConsultarProyecto() {
        vcp= new VConsultaProyecto();
        vcp.setVisible(true);
        vcp.agregarListener(this);
        daoP= new DaoProyecto();
        daoC= new DaoCliente();
        listado= new ArrayList<>();
        
        
        cargarClientes();
    }
public void cargarClientes(){
    ResultSet clientes= daoC.consultarClientes();
    MCliente cli;
        try {
            while(clientes.next()){
                String nombre,id;
                id= clientes.getString("CliRif");
                nombre= clientes.getString("CliRazonSocial");
                cli= new MCliente(id,nombre);
                listado.add(cli);
                vcp.getCmbCliente().addItem(cli.toString());
                
            } 
        clientes.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public void proyectosCliente() throws ParseException{
 if(vcp.getCmbCliente().getSelectedIndex()<=0){
     return;
 }
    vcp.getCmbCliente().setEnabled(false);
    String id,tit,desc,idio, cliID, fi,ff;
    Date fei,fef;
   
    int ind= vcp.getCmbCliente().getSelectedIndex()-1;
    
    ResultSet rs;
    
        MCliente cli= listado.get(ind);
        try {
            rs= daoP.consultarProyectoPorCliente(cli.getCliId());
            proyectos= new ArrayList<>();
            while(rs.next()){
                
                cliID= rs.getString("ProyIdCliente");
                id= rs.getString("ProyId");
                tit= rs.getString("ProyTitulo");
                desc= rs.getString("ProyDescripcion");
                idio= rs.getString("ProyIdiomas");
                fi= rs.getString("ProyFechaInicio");
                ff= rs.getString("ProyFechaFinEst");
                fei= new SimpleDateFormat("yyyy-MM-dd").parse(fi);
                fef=new SimpleDateFormat("yyyy-MM-dd").parse(ff);
                vcp.getCmbTitulo().addItem(tit);
                proy= new MProyecto(id,tit,cliID,idio,desc,fei,fef);
                proyectos.add(proy);
            }  
        rs.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(CConsultarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No tiene proyectos");
        }
    
}

    public void seleccionarProyecto(){
        if(vcp.getCmbTitulo().getSelectedIndex()<=0){
            return;
        }
        int index= vcp.getCmbTitulo().getSelectedIndex()-1;
        
        MProyecto select= proyectos.get(index);
        vcp.getTxtDescProy().setText(select.getProyDesc());
        vcp.getDTPFechaIni().setDate(select.getProyFechaInicio());
        vcp.getDTPFechaFinal().setDate(select.getProyFechaFin());
        vcp.getCmbIdioma().setSelectedItem(select.getProyIdioma());
        vcp.getTxtDescProy().setEnabled(false);
        vcp.getCmbIdioma().setEnabled(false);
        vcp.getDTPFechaIni().setEnabled(false);
        vcp.getDTPFechaFinal().setEnabled(false);
        
    }
    public void modificar(){
        vcp.getTxtDescProy().setEnabled(true);
        vcp.getTxtDescProy().setEditable(true);
        vcp.getDTPFechaIni().setEnabled(true);
        vcp.getDTPFechaFinal().setEnabled(true);
        vcp.getCmbIdioma().setEnabled(true);
        vcp.getCmbTitulo().setEnabled(false);
        vcp.getBtnModificar().setVisible(false);
        vcp.getBtnGuardar().setVisible(true);
    }
     public   void  limpiar(){
        
        
        vcp.setEnabled(true);
        vcp.getTxtDescProy().setText("");
        vcp.getTxtDescProy().setEnabled(true);
        vcp.getTxtDescProy().setEditable(true);
        vcp.getDTPFechaIni().setDate(null);
        vcp.getDTPFechaFinal().setDate(null);
        vcp.getDTPFechaIni().setEnabled(true);
        vcp.getDTPFechaFinal().setEnabled(true);
        vcp.getCmbIdioma().setEnabled(true);
        vcp.getCmbIdioma().setSelectedIndex(0);
        vcp.getBtnModificar().setVisible(true);
        vcp.getBtnGuardar().setVisible(false);
        vcp.getCmbCliente().setSelectedIndex(0);
        vcp.getCmbCliente().setEnabled(true);
        vcp.getCmbTitulo().removeAllItems();
        vcp.getCmbTitulo().addItem("...");
        vcp.getCmbTitulo().setSelectedIndex(0);
        
        
    }
     
     public void aceptarCambios(){
         String desc,idi;
         Date fi, ff;
         desc= vcp.getTxtDescProy().getText();
         idi= vcp.getCmbIdioma().getSelectedItem().toString();
         fi= vcp.getDTPFechaIni().getDate();
         ff= vcp.getDTPFechaFinal().getDate();
         if( desc.equals(proy.getProyDesc()) && idi.equals(proy.getProyIdioma()) && fi.equals(proy.getProyFechaInicio() )
                 && ff.equals(proy.getProyFechaFin())){
             JOptionPane.showMessageDialog(null, "No se realizo ningun cambio");
             
         }else{
             if(desc.isEmpty() || idi.equals("...") || ff.toString().isEmpty() || fi.toString().isEmpty()){
                 JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
             }else{
             if(!desc.equals(proy.getProyDesc())){
                 proy.setProyDesc(desc);
             }
             if(!idi.equals(proy.getProyIdioma())){
                 proy.setProyIdioma(idi);
             }
             if(! fi.equals(proy.getProyFechaInicio() )){
                 proy.setProyFechaInicio(fi);
             }
             if(!ff.equals(proy.getProyFechaFin())){
                 proy.setProyFechaFin(ff);
             }
             if(daoP.modificarProyecto(proy)){
                 JOptionPane.showMessageDialog(null, "Proyecto modificado");
                 vcp.dispose();
             }
             }
         }
         
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource().equals(vcp.getCmbCliente())){
            try {
                proyectosCliente();
            } catch (ParseException ex) {
                Logger.getLogger(CConsultarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource().equals(vcp.getCmbTitulo())){
            seleccionarProyecto();
        }
        if(e.getSource().equals(vcp.getBtnModificar())){
            modificar();
        }
        if(e.getSource().equals(vcp.getBtnCancelar())){
            limpiar();
        }
        if(e.getSource().equals(vcp.getBtnGuardar())){
            aceptarCambios();
        }
        if(e.getSource().equals(vcp.getBtnSalir())){
            vcp.dispose();
        }
    }
    
}
