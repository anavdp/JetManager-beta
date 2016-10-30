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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class VGestionHorasLaboradas extends javax.swing.JFrame {

    /**
     * Creates new form VGestionHorasLaboradas
     */
    public VGestionHorasLaboradas() {
        initComponents();
    }

    public JButton getBtnBuscarRifconsulta() {
        return btnBuscarRifconsulta;
    }

    public void setBtnBuscarRifconsulta(JButton btnBuscarRifconsulta) {
        this.btnBuscarRifconsulta = btnBuscarRifconsulta;
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    public JButton getBtnOkFiltrar() {
        return btnOkFiltrar;
    }

    public void setBtnOkFiltrar(JButton btnOkFiltrar) {
        this.btnOkFiltrar = btnOkFiltrar;
    }

    public JMonthChooser getMesCalcular() {
        return MesCalcular;
    }

    public void setMesCalcular(JMonthChooser MesCalcular) {
        this.MesCalcular = MesCalcular;
    }

    public JLabel getLblRif() {
        return lblRif;
    }

    public void setLblRif(JLabel lblRif) {
        this.lblRif = lblRif;
    }

    public JYearChooser getAñoCho() {
        return AñoCho;
    }

    public void setAñoCho(JYearChooser AñoCho) {
        this.AñoCho = AñoCho;
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

    public JButton getBtnCalConsulta() {
        return btnCalConsulta;
    }

    public void setBtnCalConsulta(JButton btnCalConsulta) {
        this.btnCalConsulta = btnCalConsulta;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCancelarCon() {
        return btnCancelarCon;
    }

    public void setBtnCancelarCon(JButton btnCancelarCon) {
        this.btnCancelarCon = btnCancelarCon;
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

    public JComboBox<String> getCbbFiltro() {
        return cbbFiltro;
    }

    public void setCbbFiltro(JComboBox<String> cbbFiltro) {
        this.cbbFiltro = cbbFiltro;
    }

    public JComboBox<String> getCbbTipoConsulta() {
        return cbbTipoConsulta;
    }

    public void setCbbTipoConsulta(JComboBox<String> cbbTipoConsulta) {
        this.cbbTipoConsulta = cbbTipoConsulta;
    }

    public JDateChooser getFechaFinalCho() {
        return fechaFinalCho;
    }

    public void setFechaFinalCho(JDateChooser fechaFinalCho) {
        this.fechaFinalCho = fechaFinalCho;
    }

    public JDateChooser getFechaInicialCho() {
        return fechaInicialCho;
    }

    public void setFechaInicialCho(JDateChooser fechaInicialCho) {
        this.fechaInicialCho = fechaInicialCho;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JLabel getLblAnio() {
        return lblAnio;
    }

    public void setLblAnio(JLabel lblAnio) {
        this.lblAnio = lblAnio;
    }

    public JLabel getLblCedula() {
        return lblRif;
    }

    public void setLblCedula(JLabel lblCedula) {
        this.lblRif = lblCedula;
    }

    public JLabel getLblCedulaConsulta() {
        return lblCedulaConsulta;
    }

    public void setLblCedulaConsulta(JLabel lblCedulaConsulta) {
        this.lblCedulaConsulta = lblCedulaConsulta;
    }

    public JLabel getLblFechaFinal() {
        return lblFechaFinal;
    }

    public void setLblFechaFinal(JLabel lblFechaFinal) {
        this.lblFechaFinal = lblFechaFinal;
    }

    public JLabel getLblFechaInicial() {
        return lblFechaInicial;
    }

    public void setLblFechaInicial(JLabel lblFechaInicial) {
        this.lblFechaInicial = lblFechaInicial;
    }

    public JLabel getLblHoras() {
        return lblHoras;
    }

    public void setLblHoras(JLabel lblHoras) {
        this.lblHoras = lblHoras;
    }

    public JLabel getLblHorasConsulta() {
        return lblHorasConsulta;
    }

    public void setLblHorasConsulta(JLabel lblHorasConsulta) {
        this.lblHorasConsulta = lblHorasConsulta;
    }

    public JLabel getLblMes() {
        return lblMes;
    }

    public void setLblMes(JLabel lblMes) {
        this.lblMes = lblMes;
    }

    public JLabel getLblProyecto() {
        return lblProyecto;
    }

    public void setLblProyecto(JLabel lblProyecto) {
        this.lblProyecto = lblProyecto;
    }

    public JLabel getLblTipoBusqueda() {
        return lblTipoBusqueda;
    }

    public void setLblTipoBusqueda(JLabel lblTipoBusqueda) {
        this.lblTipoBusqueda = lblTipoBusqueda;
    }

    public JLabel getLblTipoFiltro() {
        return lblTipoFiltro;
    }

    public void setLblTipoFiltro(JLabel lblTipoFiltro) {
        this.lblTipoFiltro = lblTipoFiltro;
    }

    public JPanel getPanelConsulta() {
        return panelConsulta;
    }

    public void setPanelConsulta(JPanel panelConsulta) {
        this.panelConsulta = panelConsulta;
    }

    public JPanel getPanelRegistro() {
        return panelRegistro;
    }

    public void setPanelRegistro(JPanel panelRegistro) {
        this.panelRegistro = panelRegistro;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCedulaConsulta() {
        return txtCedulaConsulta;
    }

    public void setTxtCedulaConsulta(JTextField txtCedulaConsulta) {
        this.txtCedulaConsulta = txtCedulaConsulta;
    }

    public JTextField getTxtHoras() {
        return txtHoras;
    }

    public void setTxtHoras(JTextField txtHoras) {
        this.txtHoras = txtHoras;
    }


    public void agregarListener(ActionListener a)
    {
        this.btnBuscar.addActionListener(a);
        this.btnCalConsulta.addActionListener(a);
        this.btnCancelar.addActionListener(a);
        this.btnCancelarCon.addActionListener(a);
        this.btnRegistrar.addActionListener(a);
        this.btnSalir.addActionListener(a);
        
        this.cbbFiltro.addActionListener(a);
        this.cbbTipoConsulta.addActionListener(a);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelRegistro = new javax.swing.JPanel();
        lblRif = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        AñoCho = new com.toedter.calendar.JYearChooser();
        MesCho = new com.toedter.calendar.JMonthChooser();
        lblAnio = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        MesCalcular = new com.toedter.calendar.JMonthChooser();
        panelConsulta = new javax.swing.JPanel();
        lblTipoBusqueda = new javax.swing.JLabel();
        cbbTipoConsulta = new javax.swing.JComboBox<>();
        lblCedulaConsulta = new javax.swing.JLabel();
        txtCedulaConsulta = new javax.swing.JTextField();
        lblTipoFiltro = new javax.swing.JLabel();
        cbbFiltro = new javax.swing.JComboBox<>();
        fechaInicialCho = new com.toedter.calendar.JDateChooser();
        lblFechaInicial = new javax.swing.JLabel();
        lblFechaFinal = new javax.swing.JLabel();
        fechaFinalCho = new com.toedter.calendar.JDateChooser();
        lblProyecto = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnCalConsulta = new javax.swing.JButton();
        lblHorasConsulta = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnCancelarCon = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnOkFiltrar = new javax.swing.JButton();
        btnBuscarRifconsulta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Horas Laboradas");

        panelRegistro.setBackground(new java.awt.Color(102, 102, 102));

        lblRif.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblRif.setForeground(new java.awt.Color(255, 255, 255));
        lblRif.setText("ID Empleado");

        txtCedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCedula.setToolTipText("");

        btnBuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el empleado");

        AñoCho.setEnabled(false);

        MesCho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblAnio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblAnio.setForeground(new java.awt.Color(255, 255, 255));
        lblAnio.setText("Año");

        lblMes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMes.setForeground(new java.awt.Color(255, 255, 255));
        lblMes.setText("Mes");

        lblHoras.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHoras.setForeground(new java.awt.Color(255, 255, 255));
        lblHoras.setText("Horas");
        lblHoras.setToolTipText("Horas laboradas");

        txtHoras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtHoras.setToolTipText("Ej: 100");
        txtHoras.setEnabled(false);

        btnRegistrar.setBackground(new java.awt.Color(255, 153, 51));
        btnRegistrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Registra horas laboradas");

        btnCancelar.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la operación");

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(86, 86, 86)
                        .addComponent(btnCancelar)
                        .addContainerGap())
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRif)
                            .addComponent(lblHoras)
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblMes)
                                .addComponent(lblAnio)))
                        .addGap(54, 54, 54)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MesCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula)
                            .addComponent(AñoCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoras))
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(MesCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRif)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(63, 63, 63)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnio)
                    .addComponent(AñoCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMes)
                    .addComponent(MesCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoras)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("Registro", panelRegistro);

        panelConsulta.setBackground(new java.awt.Color(102, 102, 102));
        panelConsulta.setEnabled(false);

        lblTipoBusqueda.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTipoBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoBusqueda.setText("Tipo de búsqueda");

        cbbTipoConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbbTipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Por nómina", "Por empleado" }));

        lblCedulaConsulta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCedulaConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lblCedulaConsulta.setText("ID Empleado");

        txtCedulaConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCedulaConsulta.setEnabled(false);

        lblTipoFiltro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTipoFiltro.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoFiltro.setText("Filtrar");

        cbbFiltro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Por proyecto", "Por rango de fecha" }));

        fechaInicialCho.setEnabled(false);
        fechaInicialCho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblFechaInicial.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblFechaInicial.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicial.setText("Fecha Inicial");

        lblFechaFinal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblFechaFinal.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFinal.setText("Fecha Final");

        fechaFinalCho.setEnabled(false);
        fechaFinalCho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblProyecto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProyecto.setForeground(new java.awt.Color(255, 255, 255));
        lblProyecto.setText("Proyecto");

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        jComboBox1.setEnabled(false);

        btnCalConsulta.setBackground(new java.awt.Color(255, 153, 51));
        btnCalConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCalConsulta.setText("Calcular");
        btnCalConsulta.setToolTipText("Calcula horas laboradas");

        lblHorasConsulta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHorasConsulta.setForeground(new java.awt.Color(255, 255, 255));
        lblHorasConsulta.setText("Horas Laboradas");

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField1.setEnabled(false);

        btnCancelarCon.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelarCon.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCancelarCon.setText("Cancelar");
        btnCancelarCon.setToolTipText("Cancela operación");

        btnOk.setBackground(new java.awt.Color(255, 153, 51));
        btnOk.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnOk.setText("Ok");

        btnOkFiltrar.setBackground(new java.awt.Color(255, 153, 51));
        btnOkFiltrar.setText("Ok");

        btnBuscarRifconsulta.setBackground(new java.awt.Color(255, 153, 51));
        btnBuscarRifconsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnBuscarRifconsulta.setText("Buscar");

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedulaConsulta)
                    .addComponent(lblTipoBusqueda)
                    .addComponent(lblTipoFiltro)
                    .addComponent(lblFechaInicial)
                    .addComponent(lblFechaFinal)
                    .addComponent(lblProyecto)
                    .addComponent(lblHorasConsulta))
                .addGap(41, 41, 41)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaInicialCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedulaConsulta)
                            .addComponent(cbbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbTipoConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaFinalCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(btnOkFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBuscarRifconsulta))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalConsulta)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarCon)
                .addGap(191, 191, 191))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoBusqueda)
                    .addComponent(cbbTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addGap(40, 40, 40)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulaConsulta)
                    .addComponent(txtCedulaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRifconsulta))
                .addGap(44, 44, 44)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoFiltro)
                    .addComponent(cbbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkFiltrar))
                .addGap(48, 48, 48)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicial)
                    .addComponent(fechaInicialCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaFinal)
                    .addComponent(fechaFinalCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProyecto)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHorasConsulta)
                    .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalConsulta)))
                .addGap(49, 49, 49)
                .addComponent(btnCancelarCon)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Consulta", panelConsulta);

        btnSalir.setBackground(new java.awt.Color(255, 153, 51));
        btnSalir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir))
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
            java.util.logging.Logger.getLogger(VGestionHorasLaboradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VGestionHorasLaboradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VGestionHorasLaboradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VGestionHorasLaboradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VGestionHorasLaboradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser AñoCho;
    private com.toedter.calendar.JMonthChooser MesCalcular;
    private com.toedter.calendar.JMonthChooser MesCho;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarRifconsulta;
    private javax.swing.JButton btnCalConsulta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCon;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOkFiltrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbbFiltro;
    private javax.swing.JComboBox<String> cbbTipoConsulta;
    private com.toedter.calendar.JDateChooser fechaFinalCho;
    private com.toedter.calendar.JDateChooser fechaInicialCho;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedulaConsulta;
    private javax.swing.JLabel lblFechaFinal;
    private javax.swing.JLabel lblFechaInicial;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblHorasConsulta;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblRif;
    private javax.swing.JLabel lblTipoBusqueda;
    private javax.swing.JLabel lblTipoFiltro;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaConsulta;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables
}
