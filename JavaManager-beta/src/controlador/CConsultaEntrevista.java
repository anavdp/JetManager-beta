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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MEntrevista;
import modelo.MEntrevistaOnlineAdapter;
import modelo.MEntrevistaPresencial;

 /*/
 * @author Vicky
 */
public class CConsultaEntrevista implements ActionListener {
private VConsultaEntrevista vce;
private DaoProyecto dP;
private DaoCandidato dC;
private DaoEntrevista dE;
private MEntrevista ent;
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
    public void selectFecha() throws ParseException{
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
            model.addColumn("Resultado");// resultado de la entrevista
            
         

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[7];
                    if(rs.getInt("EntTipo")==1){
                        ent= new MEntrevistaPresencial(rs.getString("EntModo"), rs.getInt("EntTipo"), rs.getLong("EntDuracion"),new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")), rs.getString("EntResultado").charAt(0));
                    }else{
                        ent= new MEntrevistaOnlineAdapter();
                        ent.setEntTipo(rs.getInt("EntTipo"));
                        ent.setModo(rs.getString("EntModo"));
                        ent.setDuracion(rs.getLong("EntDuracion"));
                        ent.setEntFecha(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")));
                        ent.setResultado(rs.getString("EntResultado").charAt(0));

                    }
                    fila[0]= new SimpleDateFormat("yyyy-MM-dd").format(ent.getEntFecha());
                    fila[1]= rs.getString("CanNombres");
                    fila[2]= rs.getString("ProyTitulo");
                    fila[3]= ent.getEntTipo();
                    fila[4]= ent.getModo();
                    fila[5]= ent.getDuracion();
                    fila[6]= ent.getResultado();
                    
                // para llenar cada columna con lo datos almacenados
               /* for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }*/
                // es para cargar los datos en filas a la tabla modelo
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }
    public void selectProy() throws ParseException{
        ResultSet rs= dE.consultarEntrevistaPorProyectoTabla(vce.getCmbProyecto().getSelectedItem().toString());
    DefaultTableModel model;
        model = new DefaultTableModel();
        
        vce.getTabla().setModel(model);
        try {
            model.addColumn("Fecha"); //Fecha
            model.addColumn("Candidato"); //Candidato
            model.addColumn("Salario");
            model.addColumn("Cargo Asp"); //Cargo
            model.addColumn("Resultado");// Resultado de la entrevista
            model.addColumn("Duracion");
         

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[6];
                
                if(rs.getInt("EntTipo")==1){
                        ent= new MEntrevistaPresencial(rs.getString("EntCargoAsp"),  rs.getLong("EntDuracion"),new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")), rs.getLong("EntSalOfer"), rs.getString("EntResultado").charAt(0));
                    }else{
                        ent= new MEntrevistaOnlineAdapter();
                        ent.setEntTipo(rs.getInt("EntTipo"));
                        ent.setEntSalOfer(rs.getLong("EntSalOfer"));
                        ent.setEntCargoAsp(rs.getString("EntCargoAsp"));
                        ent.setDuracion(rs.getLong("EntDuracion"));
                        ent.setEntFecha(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")));
                        ent.setResultado(rs.getString("EntResultado").charAt(0));

                    }
                    fila[0]= new SimpleDateFormat("yyyy-MM-dd").format(ent.getEntFecha());
                    fila[1]= rs.getString("CanNombres");
                    fila[2]= ent.getEntSalOfer();
                    fila[3]= ent.getEntCargoAsp();
                    fila[4]= ent.getResultado();
                    fila[5]= ent.getDuracion();
                    
                
                
                // para llenar cada columna con lo datos almacenados
                /*for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }*/
                // es para cargar los datos en filas a la tabla modelo
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    
    
    }
    public void selectCand() throws ParseException{
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
                
                       if(rs.getInt("EntTipo")==1){
                        ent= new MEntrevistaPresencial(rs.getString("EntModo"), rs.getInt("EntTipo"),
                                rs.getLong("EntDuracion"),new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")),
                                rs.getString("EntResultado").charAt(0));
                    }else{
                        ent= new MEntrevistaOnlineAdapter();
                        ent.setEntTipo(rs.getInt("EntTipo"));
                        ent.setModo(rs.getString("EntModo"));
                        ent.setDuracion(rs.getLong("EntDuracion"));
                        ent.setEntFecha(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("EntFecha")));
                        ent.setResultado(rs.getString("EntResultado").charAt(0));

                    }
                    fila[0]= new SimpleDateFormat("yyyy-MM-dd").format(ent.getEntFecha());
                    fila[1]= rs.getString("ProyTitulo");
                    fila[2]= ent.getEntTipo();
                    fila[3]= ent.getDuracion();
                    fila[4]= ent.getResultado();
                    
                
                // para llenar cada columna con lo datos almacenados
               /* for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }*/
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
                try {
                    
                    selectFecha();
                } catch (ParseException ex) {
                    Logger.getLogger(CConsultaEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           if(cons==1){
                try {
                    selectProy();
                } catch (ParseException ex) {
                    Logger.getLogger(CConsultaEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           if(cons==3){
                try {
                    selectCand();
                } catch (ParseException ex) {
                    Logger.getLogger(CConsultaEntrevista.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
            
            
        }
        if(e.getSource().equals(vce.getBtnSalir())) {
            vce.dispose();
        }
    }
    
}
