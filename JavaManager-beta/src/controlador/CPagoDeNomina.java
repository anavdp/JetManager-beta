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
import dao.DaoEmpleado;
import dao.DaoPagoMensual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MCandidato;
import modelo.MPagoMensual;
import vista.Mensajes;
import vista.VPagoDeNomina;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class CPagoDeNomina implements ActionListener {
    private final VPagoDeNomina vpagonom;
    private MPagoMensual pago;
    private final ArrayList<MCandidato> listadocan;
    
    public CPagoDeNomina() throws SQLException {
    vpagonom = new VPagoDeNomina();
        vpagonom.setVisible(true);
        vpagonom.Agregar_Listener(this);
        
         listadocan = new ArrayList<>();
         
         CargarEmpleados();
     }
     

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(vpagonom.getBtnCancelar())){
            vpagonom.getCmbEmpleadoPagar1().setSelectedIndex(0);
            vpagonom.getCmbMesPagar().setSelectedIndex(0);
            vpagonom.getTxtMontoPagar().setText("");
           
        }
        
        if (e.getSource().equals(vpagonom.getBtnSalir())){
            vpagonom.dispose();
        
    }
        if (e.getSource().equals(vpagonom.getBtnRealizar1())){
        if (vpagonom.getCmbEmpleadoPagar1().equals("...")){
        Mensajes.Aviso("Se debe seleccionar un empleado", "AVISO");
      
        }
        if (vpagonom.getCmbMesPagar().equals("...")){
        Mensajes.Aviso("Se debe seleccionar un mes", "AVISO");}
        
         if (vpagonom.getTxtMontoPagar().equals("")){
        Mensajes.Aviso("Se debe calcular el monto a pagar", "AVISO");
      
        }else {
        
            RegistrarPago();
        
        }}
        
        if (e.getSource().equals(vpagonom.getBtnCalcular())){
            if (vpagonom.getCmbEmpleadoPagar1().equals("...")){
        Mensajes.Aviso("Se debe seleccionar un empleado", "AVISO");
      
        }
        if (vpagonom.getCmbMesPagar().equals("...")){
        Mensajes.Aviso("Se debe seleccionar un mes", "AVISO");
            
        }else {
        
                try {
                    
                    CalcularPago();
                } catch (SQLException ex) {
                     
                }
        
        }
    }
    }
        
    private void RegistrarPago() {
         if (vpagonom.getCmbEmpleadoPagar1().getSelectedIndex()== 0 
                 || vpagonom.getCmbMesPagar().getSelectedIndex() == 0){
            
        Mensajes.Aviso("Se debe seleccionar un empleado y mes", "AVISO");
       
        }
        if (vpagonom.getTxtMontoPagar().getText().equals("")){
         Mensajes.Aviso("Calcular monto a pagar", "AVISO");
        }
            
        else{
        Mensajes.Informacion("Registro Exitoso", "JET MANAGER");
        vpagonom.getCmbEmpleadoPagar1().setSelectedIndex(0);
            vpagonom.getCmbMesPagar().setSelectedIndex(0);
            vpagonom.getTxtMontoPagar().setText("");
        
    }}

    private void CalcularPago() throws SQLException {
        if (vpagonom.getCmbEmpleadoPagar1().getSelectedIndex()== 0 || vpagonom.getCmbMesPagar().getSelectedIndex() == 0 ){
            
        Mensajes.Aviso("Se debe seleccionar un empleado y mes", "AVISO");
            
        }else{
        
        int ind = vpagonom.getCmbEmpleadoPagar1().getSelectedIndex() - 1;
        DaoEmpleado daoTipo = new DaoEmpleado();
        MCandidato can = listadocan.get(ind);
        ResultSet empleados = daoTipo.BuscarEmpleadoRif(can.getRif());
        float monto;
        
        try {
            if(empleados.next()){
                
                monto = empleados.getFloat("EmpSalario") * 140;
                vpagonom.getTxtMontoPagar().setText(String.valueOf(monto));
            
            }
        empleados.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPagoDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    }
    
     private void CargarEmpleados() throws SQLException {
        DaoCandidato daoTipo = new DaoCandidato();
        ResultSet empleados = daoTipo.ConsultarCandidatos();
        MCandidato can;
        try {
            while (empleados.next()) {
                String nom, apell, rif;
                rif = empleados.getString("CanRif");
                nom = empleados.getString("CanNombres");
                apell = empleados.getString("CanApellidos");
                can = new MCandidato(rif, nom, apell);
                listadocan.add(can);
                vpagonom.getCmbEmpleadoPagar1().addItem(can.toString());

            }
            empleados.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPagoDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}