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

/**
 *
 * @author jesus
 */
import vista.VRegistrarFaltas;
import java.awt.event.*;
import dao.DaoRegFaltas;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import modelo.MFaltas;


public class CRegistrarFaltas implements ActionListener{
    VRegistrarFaltas vregistrar = new VRegistrarFaltas();
    DaoRegFaltas confalta= new DaoRegFaltas();
    MFaltas mregfalta = new MFaltas();
    SimpleDateFormat formato;

    public CRegistrarFaltas() {
        this.vregistrar = new VRegistrarFaltas();
        this.confalta = new DaoRegFaltas();
        this.mregfalta = new MFaltas();
        this.vregistrar.btnregistrar.addActionListener(this);
        this.vregistrar.btncancelar.addActionListener(this);
        this.vregistrar.btnsalir.addActionListener(this);
        formato = new SimpleDateFormat("yyyy-MM-dd");
        inicializar();
        vregistrar.setVisible(true);
        vregistrar.getJtcedula().addKeyListener (new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(vregistrar.getJtcedula().getText().length() >= 9) {
                            e.consume();
                        }

                        char c = e.getKeyChar();
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }    
        });

      }
    public void inicializar(){
         vregistrar.getJctipo().setSelectedIndex(0);
         ((JTextField)vregistrar.getJdatefecha().getDateEditor()).setText("");
         vregistrar.getJtcedula().setText("");
         vregistrar.getJtdescrip().setText("");
         
     }    

    public void Registrardatos(){
        mregfalta.setCedula(vregistrar.getJtcedula().getText());
        mregfalta.setFecha(formato.format(vregistrar.getJdatefecha().getDate()));
        mregfalta.setTipo((String) vregistrar.jctipo.getSelectedItem());
        mregfalta.setDescripcion(vregistrar.jtdescrip.getText());
        confalta.Registrarfal(mregfalta);
                
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vregistrar.getBtnregistrar())) {
            Registrardatos();
            //inicializar();
            }
        if(e.getSource().equals(vregistrar.getBtnsalir())) {
            vregistrar.dispose();
            return;
            
            }
         if (e.getSource().equals(vregistrar.getBtncancelar())) {
            inicializar();
            return;
            
        }

}
}