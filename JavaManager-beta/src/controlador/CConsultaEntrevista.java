/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
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
import java.sql.ResultSet;
import vista.VConsultaEntrevista;
import dao.DaoProyecto;
import dao.DaoCandidato;
import dao.DaoEntrevista;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 /*/
 * @author Vicky
 */
public class CConsultaEntrevista implements ActionListener {
private VConsultaEntrevista vce;
private DaoProyecto dP;
private DaoCandidato dC;
private DaoEntrevista dE;
private int cons=0;
    public CConsultaEntrevista() {
        vce= new VConsultaEntrevista();
        vce.setVisible(true);
        vce.agregarListener(this);
        dP= new DaoProyecto();
        dC= new DaoCandidato();
        dE= new DaoEntrevista();
        cargarCombos();
    }
    public void cargarCombos(){
        
        ResultSet proy,cand;
        try{
            cand= dC.ConsultarCandidatos();
            while(cand.next()){
                vce.getCmbCandidato().addItem(cand.getString("CanRif"));
            }
            cand.close();
            proy= dP.consultarProyectos();
            while(proy.next()){
                vce.getCmbProyecto().addItem(proy.getString("ProyId"));
            }
            proy.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void selectFecha(){
        Date f1,f2;
        f1= vce.getjDateChooser1().getDate();
        f2= vce.getjDateChooser2().getDate();
        if(f2.before(f1)){
            JOptionPane.showMessageDialog(null, "Rango de fechas invalido");
            return;
        }
        ResultSet rs= dE.consultarEntrevistaPorFecha(vce.getjDateChooser1().getDate(), vce.getjDateChooser2().getDate());
       DefaultTableModel model;
        model = new DefaultTableModel();
        
        vce.getTabla().setModel(model);
        try {
            model.addColumn("Fecha"); //Empleado
            model.addColumn("Candidato"); //Candidato
            model.addColumn("Proyecto");
            model.addColumn("Tipo"); // Tipo de la entrevista
            model.addColumn("Modo"); 
            model.addColumn("Duracion");
            model.addColumn("Resultado");// Empleado
            
         

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[7];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // es para cargar los datos en filas a la tabla modelo
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }
    public void selectProy(){
        ResultSet rs= dE.consultarEntrevistaPorProyectoTabla(vce.getCmbProyecto().getSelectedItem().toString());
    DefaultTableModel model;
        model = new DefaultTableModel();
        
        vce.getTabla().setModel(model);
        try {
            model.addColumn("Fecha"); //Fecha
            model.addColumn("Candidato"); //Candidato
            model.addColumn("Salario");
            model.addColumn("Cargo Asp"); //Cargo
            model.addColumn("Resultado");// Empleado
            model.addColumn("Duracion");
         

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[6];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // es para cargar los datos en filas a la tabla modelo
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    
    
    }
    public void selectCand(){
        ResultSet rs= dE.consultarTaplaPorCandidato(vce.getCmbCandidato().getSelectedItem().toString());
        DefaultTableModel model;
        model = new DefaultTableModel();
        
        vce.getTabla().setModel(model);
        try {
            model.addColumn("Fecha"); //Empleado
            model.addColumn("Proyecto");
            model.addColumn("Tipo"); //Tipo de Entrevista
            model.addColumn("Duracion");
            model.addColumn("Resultado");// Empleado
         

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[5];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // es para cargar los datos en filas a la tabla modelo
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource().equals(vce.getRadProy())){
            vce.getPanelProyecto().setVisible(true);
            vce.getPanelFecha().setVisible(false);
            vce.getPanelCand().setVisible(false);
            cons=1;
        }
        if(e.getSource().equals(vce.getRadFecha())){
           vce.getPanelProyecto().setVisible(false);
            vce.getPanelFecha().setVisible(true);
            vce.getPanelCand().setVisible(false);
            cons=2;
        }
        if(e.getSource().equals(vce.getRadCandidato())){
            vce.getPanelProyecto().setVisible(false);
            vce.getPanelFecha().setVisible(false);
            vce.getPanelCand().setVisible(true);
            cons=3;
        }
        if(e.getSource().equals(vce.getBtnConsultar())){
            if(cons==0){
                return;
            }
           if(cons==2){
                selectFecha();
           }
           if(cons==1){
               selectProy();
           }
           if(cons==3){
               selectCand();
           }
            
            
        }
        if(e.getSource().equals(vce.getBtnSalir())) {
            vce.dispose();
        }
    }
    
}
