/*
 * 
 * 
 * 
 */

package controlador;

/**
 *
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PALACIOS
 * @author ABUNASSAR PENARANDA
 * @author JESÚS RANGEL
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.VDiaFeriado;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.MDiaFeriado;
import dao.DaoDiaFeriado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.MConserje;
import modelo.MMemento;


/**
 *
 * @author Usuario
 */
public class CDiaFeriado implements ActionListener, KeyListener{

   private VDiaFeriado diaF;
   private MDiaFeriado dia;
   private DaoDiaFeriado daoDia;
   private SimpleDateFormat formato;
   private SimpleDateFormat formatoDia;
   private SimpleDateFormat formatoMes;
   private SimpleDateFormat formatoAnio;
   private ResultSet r;
   private int contDias;
   private MConserje c;
   private MMemento m;

    public CDiaFeriado() throws SQLException {
        m = new MMemento();
        diaF = new VDiaFeriado();
        dia = new MDiaFeriado();
        daoDia = new DaoDiaFeriado();
        formato = new SimpleDateFormat("yyyy-MM-dd");
        formatoDia = new SimpleDateFormat("dd");
        formatoMes = new SimpleDateFormat("MM");
        formatoAnio = new SimpleDateFormat("yyyy");
        diaF.setVisible(true); 
        diaF.agregarListener(this);
        diaF.getBtnRegistrar().setEnabled(false);
        diaF.getTxtCantidadFeriados().setVisible(false);
        diaF.getLblCantDiasFeriados().setVisible(false);
        diaF.getBtnModificar().setEnabled(false);
        diaF.getBtnRestablecer().setEnabled(false);
    }
    
    public void Limpiar(){
        diaF.getTxtDescripcion().setText("");
        diaF.getCalendario().setDate(null);
    }
    
    public ArrayList ObtenerDias(MDiaFeriado dia) 
    {
        ArrayList<MDiaFeriado> diasFeriados = new ArrayList<MDiaFeriado>();
        r = daoDia.ObtenerDiasParaTablaMensual(dia);
        contDias = 0;
        
       try {
           
           while(r.next()){
               dia = new MDiaFeriado(); 
               
               dia.setFecha(r.getString("DFFecha"));
               dia.setDescripcion(r.getString("DFDescripcion"));
               
               diasFeriados.add(dia);
               contDias++;
           }
           r.close();
       } catch (SQLException ex) {
           Logger.getLogger(CDiaFeriado.class.getName()).log(Level.SEVERE, null, ex);
       }
        
      
        return diasFeriados;
    }
    
    
    public void llenarTabla() 
    {

        ArrayList<MDiaFeriado> diasF = ObtenerDias(dia);
        
        DefaultTableModel model = (DefaultTableModel) diaF.getTablaMensual().getModel();
    
    
        model.setNumRows(0);
    
     
        Vector fila;
        
       for(MDiaFeriado diaFeriado : diasF){
        
            fila = new Vector();
            
            fila.add(diaFeriado.getFecha());
            
            fila.add(diaFeriado.getDescripcion());
            

            model.addRow(fila);
            
            
        }
       diaF.getTxtCantidadFeriados().setText(String.valueOf(contDias));
    }
    
    public void Cancelar()
    {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la operación?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                Limpiar();
            }
            else
            if(JOptionPane.NO_OPTION == 1){
            
                diaF.toFront();
            }
            else
                if(JOptionPane.CANCEL_OPTION == 2){
                
                    diaF.toFront();
                }
    }
    
    public void Buscar()
    {
        if(diaF.getCalendario().getDate() == null)
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                dia.setFecha(formato.format(diaF.getCalendario().getDate()));
               
                dia.setEstatus('A');
                r = daoDia.BuscarFecha(dia);
                
                try {
                    if(r.next())
                    {
                        c = new MConserje();
                        JOptionPane.showMessageDialog(null, "La fecha " + formato.format(diaF.getCalendario().getDate())+ " ya se encuentra registrada", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        dia.setDescripcion(r.getString("DFDescripcion"));
                        
                        c.AddMemento(dia.CrearMemento()); //Memento
                        
                        diaF.getTxtDescripcion().setText(dia.getDescripcion());
                        diaF.getBtnModificar().setEnabled(true);
                        diaF.getBtnRestablecer().setEnabled(true);
                    }
                    else
                    {
                        diaF.getBtnRegistrar().setEnabled(true);
                    }
                    r.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CDiaFeriado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void Consultar()
    {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea realizar la consulta?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
             {
                 dia.setMes(Integer.valueOf(diaF.getMesCho().getMonth() + 1));
                 dia.setAnio(Integer.valueOf(diaF.getjYearChooser1().getYear()));
                 
                
                     llenarTabla();
                     diaF.getLblCantDiasFeriados().setVisible(true);
                     diaF.getLblCantDiasFeriados().setText(String.valueOf(contDias));
                     
                 
             }
             else
            if(JOptionPane.NO_OPTION == 1){
                
                    diaF.toFront();
                }
            else
            if(JOptionPane.CANCEL_OPTION == 2){
                    
                        diaF.toFront();
                    }
    }
    
    public void Registrar()
    {
    if(diaF.getTxtDescripcion().getText().equals("") || diaF.getCalendario().getDate() == null)
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha y tipear su descripción", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            /*else
            if(Calendar.DAY_OF_WEEK == 1 || Calendar.DAY_OF_WEEK == 7)
            {
                JOptionPane.showMessageDialog(null, "El día es de fin de semana, imposible registrar", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
            }*/
            else
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar el día " + formato.format(diaF.getCalendario().getDate()) + " como feriado?", "Confirmación",1, javax.swing.JOptionPane.QUESTION_MESSAGE)==0)
            {
                dia.setFecha(formato.format(diaF.getCalendario().getDate()));
                dia.setDia(Integer.valueOf(formatoDia.format(diaF.getCalendario().getDate())));
                dia.setMes(Integer.valueOf(formatoMes.format(diaF.getCalendario().getDate())));
                dia.setAnio(Integer.valueOf(formatoAnio.format(diaF.getCalendario().getDate())));
                dia.setEstatus('A');
                dia.setDescripcion(diaF.getTxtDescripcion().getText());
                
                daoDia.InsetarDiaFeriado(dia);
                
                
                JOptionPane.showMessageDialog(null, "Registro exitoso", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
                Limpiar();
                
                diaF.getBtnRegistrar().setEnabled(false);
            }
            else
            if(JOptionPane.NO_OPTION == 1){
            
                diaF.toFront();
            }
            else
                if(JOptionPane.CANCEL_OPTION == 2){
                
                    diaF.toFront();
                }
    }
    
    public void Salir()
    {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                JOptionPane.showMessageDialog(null, "Hasta Luego", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                diaF.dispose();
            }
            else
            if(JOptionPane.NO_OPTION == 1){
                
                    diaF.toFront();
                }
            else
            if(JOptionPane.CANCEL_OPTION == 2){
                    
                        diaF.toFront();
                    }
    }
    
    public void Eliminar()
    {
        if(diaF.getTxtDescripcion().getText().equals("") || diaF.getCalendario().getDate() == null)
            {
                JOptionPane.showMessageDialog(null, "No deben existir campos vacíos", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            else
            if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar el día feriado " + formato.format(diaF.getCalendario().getDate()) + "?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                dia.setFecha(formato.format(diaF.getCalendario().getDate()));
                dia.setEstatus('E');
            
                daoDia.EliminarDiaFeriado(dia);
                
                JOptionPane.showMessageDialog(null, "Eliminación exitosa", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
                Limpiar();
               
            }
            else
            if(JOptionPane.NO_OPTION == 1){
                
                    diaF.toFront();
                }
            else
            if(JOptionPane.CANCEL_OPTION == 2){
                    
                        diaF.toFront();
                    }
    }
    
    
    public void Modificar()
    {
        if(diaF.getTxtDescripcion().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo 'Descripción'", "Jet-Manager", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        else
            if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea modificar la descripción del día feriado " + formato.format(diaF.getCalendario().getDate()) + "?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
        {          
            JOptionPane.showMessageDialog(null, "Modificación exitosa", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            dia.setDescripcion(diaF.getTxtDescripcion().getText());
            dia.setFecha(formato.format(diaF.getCalendario().getDate()));
            daoDia.ModificarDescipcion(dia);
            diaF.getTxtDescripcion().setText("");
            diaF.getCalendario().setDate(null);
            diaF.getBtnModificar().setEnabled(false);
        }
    }
    
    
    //Memento
    public void Restablecer()
    {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea reestablecer la modificación?", "Jet-Manager",1, javax.swing.JOptionPane.QUESTION_MESSAGE)== 0)
            {
                m = c.GetMemento(c.getEstados().size() - 1);

                diaF.getTxtDescripcion().setText(m.getEstado());
                
                dia.setDescripcion(m.getEstado());
                
                daoDia.ModificarDescipcion(dia);
                
                JOptionPane.showMessageDialog(null, "La modificación se restableció exitosamente", "Jet-Manager", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                //diaF.getTxtDescripcion().setText("");
                diaF.getCalendario().setDate(null);
                
                diaF.getBtnRestablecer().setEnabled(false);
            }
            else
            if(JOptionPane.NO_OPTION == 1){
                
                    diaF.toFront();
                }
            else
            if(JOptionPane.CANCEL_OPTION == 2){
                    
                        diaF.toFront();
                    }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Botón Reestablecer
        if(e.getSource().equals(diaF.getBtnRestablecer()))
        {
            Restablecer();
        }
        
        //Boton cancelar
        if(e.getSource().equals(diaF.getBtnCancelar()))
        {
            Cancelar();
            
        }
        
        //Boton registrar
        if(e.getSource().equals(diaF.getBtnRegistrar()))
        
        {
            Registrar();               
        }

        //Boton salir
        if(e.getSource().equals(diaF.getBtnSalir()))
        {
            Salir();           
        }
        
        //Boton Eliminar
        if(e.getSource().equals(diaF.getBtnEliminar()))
        {
            Eliminar();
        }
        
        //Boton Consultar
        if(e.getSource().equals(diaF.getBtnConsultar()))
        {
            Consultar();
        }
        
       
        //Boton Buscar
        if(e.getSource().equals(diaF.getBtnBuscar()))
        {
            Buscar();
        }
        
        //Botón Modificar
        if(e.getSource().equals(diaF.getBtnModificar()))
        {
            Modificar();
        }
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
