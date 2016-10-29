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
import java.awt.event.ActionEvent;
import vista.VConsultarFaltas;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MFaltas;
import dao.DaoRegFaltas;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
/**
 *
 * @author jesus
 */
public class CConsultarFaltas implements ActionListener{
    VConsultarFaltas vfalta = new VConsultarFaltas();
    MFaltas mfalta = new MFaltas();
    DaoRegFaltas daofalta= new DaoRegFaltas();
    
    
    
    public CConsultarFaltas(){
        this.mfalta = new MFaltas();
        this.vfalta = new VConsultarFaltas();
        this.daofalta = new DaoRegFaltas();
        vfalta.setVisible(true);
        this.vfalta.btnconsultar.addActionListener(this);
        this.vfalta.btncancelar.addActionListener(this);
        this.vfalta.btnsalir.addActionListener(this);  
        vfalta.Agregarlistener(this);
        vfalta.jtcedula.setVisible(false);
        vfalta.jlce.setVisible(false);
        vfalta.jdfefi.setVisible(false);
        vfalta.jdfeini.setVisible(false);
        vfalta.jlfe.setVisible(false);
        vfalta.jld.setVisible(false);
        vfalta.jlh.setVisible(false);   
        
    }
    public void inicializar(){
         ((JTextField)vfalta.getJdfefi().getDateEditor()).setText("");
         ((JTextField)vfalta.getJdfeini().getDateEditor()).setText("");
         vfalta.getJtcedula().setText("");
         DefaultTableModel tablaini = (DefaultTableModel) vfalta.getjTable1().getModel();
         tablaini.setNumRows(0);
         
         
         
     }
    public void llenartabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        vfalta.getjTable1().setModel(modelo);
        
        
        DaoRegFaltas daofal = new DaoRegFaltas();
        ResultSet rs = daofal.Consultarfalce(vfalta.getJtcedula().getText());
        try{modelo.addColumn("ID Empleado"); 
            modelo.addColumn("Fecha");
            modelo.addColumn("Tipo de Falta"); 
            modelo.addColumn("Descripcion");
            
            while (rs.next()){
                Object[] columns = new Object[4];
                for (int i = 0; i < 4; i++) {
                    columns[i] = rs.getObject(i + 1);
                }
                modelo.addRow(columns);
            }
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource().equals(vfalta.getJrce())){
            vfalta.getJlce().setVisible(true);
            vfalta.getJtcedula().setVisible(true);
            vfalta.jdfefi.setVisible(false);
            vfalta.jdfeini.setVisible(false);
            vfalta.jlfe.setVisible(false);
            vfalta.jld.setVisible(false);
            vfalta.jlh.setVisible(false);
            
        }
        if(e.getSource().equals(vfalta.getJrfe())){
            vfalta.getJlfe().setVisible(true);
            vfalta.getJdfeini().setVisible(true);
            vfalta.getJdfefi().setVisible(true);
            vfalta.getJld().setVisible(true);
            vfalta.getJlh().setVisible(true);
            vfalta.jtcedula.setVisible(false);
            vfalta.jlce.setVisible(false);
        }
        if(e.getSource().equals(vfalta.getBtncancelar())){
            inicializar();
            return;
        }
        if(e.getSource().equals(vfalta.getBtnsalir())){
            vfalta.dispose();
            inicializar();
            return;
        }
        if(e.getSource().equals(vfalta.getBtnconsultar())){
            llenartabla();
        }
        
    }
    
}
