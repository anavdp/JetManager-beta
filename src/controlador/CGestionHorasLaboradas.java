/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controlador;

/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */

import dao.DaoGestionHorasLaboradas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VGestionHorasLaboradas;
import modelo.MEmpleado;
        
public class CGestionHorasLaboradas implements ActionListener, KeyListener{

    private VGestionHorasLaboradas horas;
    private MEmpleado empleado;
    private DaoGestionHorasLaboradas daoHoras;
    private ResultSet r;
    private int contFaltas;
    private int contDiasLabo;
    private SimpleDateFormat formato;
    private int horasLabMensual;
    private int cantidadFaltas; //para el select count
           
    
    public CGestionHorasLaboradas() throws SQLException {
        
        horas = new VGestionHorasLaboradas();
        empleado = new MEmpleado();
        daoHoras = new DaoGestionHorasLaboradas();
        horas.agregarListener(this);
        horas.setVisible(true);
        horas.getMesCalcular().setVisible(false);
        horas.getPanelConsulta().setVisible(false);
        JOptionPane.showMessageDialog(null, "Seleccione el mes antes de buscar el Rif", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void LimpiarRe()
    {
        horas.getTxtCedula().setText("");
        horas.getTxtHoras().setText("");
        
    }
    
    public void Salir()
    {
        
           if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Confirmación",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                JOptionPane.showMessageDialog(null, "Hasta Luego", "Saliendo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                horas.dispose();
            }
            else
            if(JOptionPane.NO_OPTION == 1){
                
                    horas.toFront();
                }
            else
            if(JOptionPane.CANCEL_OPTION == 2){
                    
                        horas.toFront();
                    }
        
    }
    
    public void Cancelar()
    {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la operación?", "Confirmación",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                LimpiarRe();
            }
            else
            if(JOptionPane.NO_OPTION == 1){
            
                horas.toFront();
            }
            else
                if(JOptionPane.CANCEL_OPTION == 2){
                
                    horas.toFront();
                }
            
    }
    
    public void ConsultaEmpleado()
    {
        if(horas.getCbbTipoConsulta().getSelectedItem() == "...")
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de consulta", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        else
            if(horas.getCbbTipoConsulta().getSelectedItem() == "Por empleado")
            {
                horas.getTxtCedulaConsulta().setEnabled(true);
                horas.getCbbTipoConsulta().setEnabled(false);
                horas.getBtnOk().setEnabled(false);
            }
        else
                if(horas.getCbbTipoConsulta().getSelectedItem() == "Por nómina")
                {
                    horas.getTxtCedulaConsulta().setEnabled(false);
                }
    }
    
    public void BuscarRif()
    {
        if(horas.getTxtCedula().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo del Rif", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
       else
        {
           
                empleado.setRif(horas.getTxtCedula().getText());
                
                r = daoHoras.BuscarRif(empleado);
                
            try {
                if(r.next())
                {
                    JOptionPane.showMessageDialog(null, "Calculando horas laboradas por el empleado", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    horas.getTxtHoras().setText(String.valueOf(calcularHorasLaborables()));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Rif no encontrado", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                r.close();
            } catch (SQLException ex) {
                Logger.getLogger(CGestionHorasLaboradas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
   public int ContarFaltas()
    { contFaltas = 0;
        r = daoHoras.ObtenerFaltas();
        try {
            while(r.next())
            {
                contFaltas++;
                
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(CGestionHorasLaboradas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contFaltas;
    }
    
    public int calcularHorasLaborables()
    {
        
        ContarFaltas();
         horasLabMensual = 0;
         contDiasLabo = 0;
         GregorianCalendar cal = new GregorianCalendar();
         formato = new SimpleDateFormat("dd");
         cal.set(Calendar.DAY_OF_MONTH, 1);
         cal.set(Calendar.MONTH, horas.getMesCalcular().getMonth());
         int mes = horas.getMesCalcular().getMonth();
         int diaContar1 = 7;
         int diaContar2 = 1;
         int cuenta = 0;
         int cuenta2 = 0;
         int diaH = 0;
         int contFer = 0;
         int horasMes = 0;
        
         while(cal.get(Calendar.MONTH) == mes)
         {
             if(cal.get(Calendar.DAY_OF_WEEK) == diaContar1 || cal.get(Calendar.DAY_OF_WEEK) == diaContar2)
             {
                 cuenta++;
             }
             cal.add(Calendar.DAY_OF_MONTH, 1);
             cuenta2++;
         }
         
         
        return horasLabMensual = (cuenta2 - ContarFaltas() - cuenta) * 8;
        
    }
    
    public void RegistrarHorasEmpleado()
    {
        if(horas.getTxtHoras().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe haber encontrado el rif de algún empleado", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);           
        }
        else
        {
            empleado.setID(Integer.valueOf(horas.getTxtHoras().getText()));
            
            daoHoras.InsertarHoras(empleado);
        }
    }
    
    public void ConsultarHorasLaboradas()
    {
        if(horas.getCbbTipoConsulta().getSelectedItem() == "Por empleado")
        {
            r = daoHoras.BuscarRif(empleado);
            
            try {
                if(r.next())
                {
                    empleado.setRif(r.getString("EmpRif"));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Rif no encontrado", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                r.close();
            } catch (SQLException ex) {
                Logger.getLogger(CGestionHorasLaboradas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Botón Cancelar
        if(e.getSource().equals(horas.getBtnCancelar()))
        {
            Cancelar(); 
        }
        
        //Botón Salir
        if(e.getSource().equals(horas.getBtnSalir()))
        {
            Salir();
        }
        
        //Botón Buscar
        if(e.getSource().equals(horas.getBtnBuscar()))
        {
                BuscarRif();
        }

        //Botón Registrar
        if(e.getSource().equals(horas.getBtnRegistrar()))
        {
            RegistrarHorasEmpleado();
            LimpiarRe();
        }
        
        //Botón Buscar Rif pero en Consulta
        if(e.getSource().equals(horas.getBtnBuscarRifconsulta()))
        {
            BuscarRif();
        }
        
        //Botón Ok del tipo de consulta
        if(e.getSource().equals(horas.getBtnOk()))
        {
            ConsultaEmpleado();
        }
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
