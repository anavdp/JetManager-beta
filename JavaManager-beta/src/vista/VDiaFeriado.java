/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PALACIOS
 * @author ABUNASSAR PENARANDA
 * @author JESÚS RANGEL
 */

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class VDiaFeriado extends javax.swing.JFrame {

    /**
     * Creates new form Feriados
     */
    public VDiaFeriado() {
        initComponents();
    }

    public JButton getBtnRestablecer() {
        return btnRestablecer;
    }

    public void setBtnRestablecer(JButton btnRestablecer) {
        this.btnRestablecer = btnRestablecer;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JLabel getLblCantDiasFeriados() {
        return lblCantDiasFeriados;
    }

    public void setLblCantDiasFeriados(JLabel lblCantDiasFeriados) {
        this.lblCantDiasFeriados = lblCantDiasFeriados;
    }

    public JTextField getTxtCantidadFeriados() {
        return txtCantidadFeriados;
    }

    public void setTxtCantidadFeriados(JTextField txtCantidadFeriados) {
        this.txtCantidadFeriados = txtCantidadFeriados;
    }
    
    public JDateChooser getCalendario() {
        return Calendario;
    }

    public void setCalendario(JDateChooser Calendario) {
        this.Calendario = Calendario;
    }

    public JMonthChooser getMesCho() {
        return MesCho;
    }

    public void setMesCho(JMonthChooser MesCho) {
        this.MesCho = MesCho;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JYearChooser getjYearChooser1() {
        return jYearChooser1;
    }

    public void setjYearChooser1(JYearChooser jYearChooser1) {
        this.jYearChooser1 = jYearChooser1;
    }

    public JLabel getLabelCantidadFeriados() {
        return labelCantidadFeriados;
    }

    public void setLabelCantidadFeriados(JLabel labelCantidadFeriados) {
        this.labelCantidadFeriados = labelCantidadFeriados;
    }

    public JLabel getLabelDescripcion() {
        return labelDescripcion;
    }

    public void setLabelDescripcion(JLabel labelDescripcion) {
        this.labelDescripcion = labelDescripcion;
    }

    public JLabel getLabelFecha() {
        return labelFecha;
    }

    public void setLabelFecha(JLabel labelFecha) {
        this.labelFecha = labelFecha;
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    public JPanel getPanelConsulta() {
        return panelConsulta;
    }

    public void setPanelConsulta(JPanel panelConsulta) {
        this.panelConsulta = panelConsulta;
    }

    public JPanel getPanelMensual() {
        return panelMensual;
    }

    public void setPanelMensual(JPanel panelMensual) {
        this.panelMensual = panelMensual;
    }

    public JPanel getPanelRegistro() {
        return panelRegistro;
    }

    public void setPanelRegistro(JPanel panelRegistro) {
        this.panelRegistro = panelRegistro;
    }

    public JPanel getPanelTipeo() {
        return panelTipeo;
    }

    public void setPanelTipeo(JPanel panelTipeo) {
        this.panelTipeo = panelTipeo;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JTable getTablaMensual() {
        return tablaMensual;
    }

    public void setTablaMensual(JTable tablaMensual) {
        this.tablaMensual = tablaMensual;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }


    public void agregarListener(ActionListener a){
        this.btnSalir.addActionListener(a);
        this.btnCancelar.addActionListener(a);
        this.btnBuscar.addActionListener(a);
        this.btnConsultar.addActionListener(a);
        this.btnRegistrar.addActionListener(a);
        this.btnEliminar.addActionListener(a);
        this.btnModificar.addActionListener(a);
        this.btnRestablecer.addActionListener(a);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelRegistro = new javax.swing.JPanel();
        panelTipeo = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        Calendario = new com.toedter.calendar.JDateChooser();
        labelDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelConsulta = new javax.swing.JPanel();
        panelMensual = new javax.swing.JPanel();
        MesCho = new com.toedter.calendar.JMonthChooser();
        btnConsultar = new javax.swing.JButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMensual = new javax.swing.JTable();
        labelCantidadFeriados = new javax.swing.JLabel();
        txtCantidadFeriados = new javax.swing.JTextField();
        lblCantDiasFeriados = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JetManager - Días Feriados");

        tabbedPane.setBackground(new java.awt.Color(102, 102, 102));

        panelRegistro.setBackground(new java.awt.Color(102, 102, 102));

        panelTipeo.setBackground(new java.awt.Color(102, 102, 102));

        labelFecha.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("Fecha");

        Calendario.setToolTipText("");
        Calendario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        labelDescripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        labelDescripcion.setText("Descripción");

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDescripcion.setToolTipText("Ej: Día de la independencia");

        btnBuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca la fecha seleccionada");

        btnModificar.setBackground(new java.awt.Color(255, 153, 51));
        btnModificar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");

        btnRestablecer.setBackground(new java.awt.Color(255, 153, 51));
        btnRestablecer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRestablecer.setText("Restablecer");

        javax.swing.GroupLayout panelTipeoLayout = new javax.swing.GroupLayout(panelTipeo);
        panelTipeo.setLayout(panelTipeoLayout);
        panelTipeoLayout.setHorizontalGroup(
            panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipeoLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion)
                    .addComponent(labelFecha))
                .addGap(32, 32, 32)
                .addGroup(panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTipeoLayout.createSequentialGroup()
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipeoLayout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRestablecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTipeoLayout.setVerticalGroup(
            panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipeoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha)
                    .addComponent(btnBuscar))
                .addGap(55, 55, 55)
                .addGroup(panelTipeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestablecer))
        );

        panelBotones.setBackground(new java.awt.Color(102, 102, 102));

        btnRegistrar.setBackground(new java.awt.Color(255, 153, 51));
        btnRegistrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Registra fecha como día feriado");

        btnCancelar.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Limpia las casillas");

        btnEliminar.setBackground(new java.awt.Color(255, 153, 51));
        btnEliminar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Elimina la fecha encontrada");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(81, 81, 81)
                .addComponent(btnCancelar)
                .addGap(73, 73, 73)
                .addComponent(btnEliminar)
                .addGap(99, 99, 99))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTipeo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelTipeo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        tabbedPane.addTab("Registro", panelRegistro);

        panelConsulta.setBackground(new java.awt.Color(102, 102, 102));

        panelMensual.setBackground(new java.awt.Color(102, 102, 102));

        MesCho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnConsultar.setBackground(new java.awt.Color(255, 153, 51));
        btnConsultar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("Consulta días feriados del mes seleccionado");

        javax.swing.GroupLayout panelMensualLayout = new javax.swing.GroupLayout(panelMensual);
        panelMensual.setLayout(panelMensualLayout);
        panelMensualLayout.setHorizontalGroup(
            panelMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMensualLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(MesCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnConsultar)
                .addGap(75, 75, 75))
        );
        panelMensualLayout.setVerticalGroup(
            panelMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMensualLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(MesCho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablaMensual.setBackground(new java.awt.Color(204, 204, 204));
        tablaMensual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablaMensual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(tablaMensual);

        labelCantidadFeriados.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelCantidadFeriados.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidadFeriados.setText("Cantidad de días feriados del mes seleccionado");

        txtCantidadFeriados.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCantidadFeriados.setForeground(new java.awt.Color(102, 255, 102));
        txtCantidadFeriados.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCantDiasFeriados.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCantDiasFeriados.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMensual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCantidadFeriados)
                .addGap(39, 39, 39)
                .addComponent(lblCantDiasFeriados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtCantidadFeriados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCantidadFeriados)
                    .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCantDiasFeriados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCantidadFeriados, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Consulta", panelConsulta);

        btnSalir.setBackground(new java.awt.Color(255, 153, 51));
        btnSalir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir de la ventana");
        btnSalir.setMaximumSize(new java.awt.Dimension(81, 25));
        btnSalir.setMinimumSize(new java.awt.Dimension(81, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VDiaFeriado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VDiaFeriado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VDiaFeriado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VDiaFeriado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VDiaFeriado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendario;
    private com.toedter.calendar.JMonthChooser MesCho;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel labelCantidadFeriados;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel lblCantDiasFeriados;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JPanel panelMensual;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel panelTipeo;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaMensual;
    private javax.swing.JTextField txtCantidadFeriados;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
