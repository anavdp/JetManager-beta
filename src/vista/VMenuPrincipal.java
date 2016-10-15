/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class VMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VMenuPrincipal
     */
    public VMenuPrincipal() {
        initComponents();
    }

    public JMenuItem getJMenuConsultarCliente() {
        return JMenuConsultarCliente;
    }

    public JMenuItem getjMenuConsultarCandidato() {
        return jMenuConsultarCandidato;
    }

    public JMenuItem getjMenuConsultarProyecto() {
        return jMenuConsultarProyecto;
    }

    public JButton getBtnConsultarCliente() {
        return btnConsultarCliente;
    }

    public JButton getBtnConsultarEntrevista() {
        return btnConsultarEntrevista;
    }

    public JButton getBtnConsultarFaltas() {
        return btnConsultarFaltas;
    }

    public JButton getBtnPagarNomina() {
        return btnPagarNomina;
    }

    public JButton getBtnConsultarRecordPagos() {
        return btnConsultarRecordPagos;
    }

    public JButton getBtnConsultarRecordUtilidad() {
        return btnConsultarRecordUtilidad;
    }

    public JButton getBtnRegistrarCandidato() {
        return btnRegistrarCandidato;
    }

    public JButton getBtnRegistrarCliente() {
        return btnRegistrarCliente;
    }

    public JButton getBtnRegistrarEntrevista() {
        return btnRegistrarEntrevista;
    }

    public JButton getBtnRegistrarFaltas() {
        return btnRegistrarFaltas;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
// Empieza el menu
    public JMenuItem getJmenAsignarCandidato() {
        return jmenAsignarCandidato;
    }

    public JMenu getJmenBalances() {
        return jmenBalances;
    }

    public JMenuItem getJmenConsultarEntrevistas() {
        return jmenConsultarEntrevistas;
    }

    public JMenuItem getJmenConsultarFaltas() {
        return jmenConsultarFaltas;
    }

    public JMenuItem getJmenConsultarHorasLaboradas() {
        return jmenConsultarHorasLaboradas;
    }

    public JMenuItem getJmenDiasFeriados() {
        return jmenDiasFeriados;
    }

    public JMenu getJmenGeneral() {
        return jmenGeneral;
    }

    public JMenu getJmenGestionarCandidato() {
        return jmenGestionarCandidato;
    }

    public JMenu getJmenNomina() {
        return jmenNomina;
    }

    public JMenuItem getJmenPagoNomina() {
        return jmenPagoNomina;
    }

    public JMenuItem getJmenRecordPagos() {
        return jmenRecordPagos;
    }

    public JMenuItem getJmenRecordUtilidad() {
        return jmenRecordUtilidad;
    }

    public JMenuItem getJmenRegistrarCandidato() {
        return jmenRegistrarCandidato;
    }

    public JMenuItem getJmenRegistrarEntrevistas() {
        return jmenRegistrarEntrevistas;
    }

    public JMenuItem getJmenRegistrarFaltas() {
        return jmenRegistrarFaltas;
    }

    public JButton getBtnAsignarCandidatos() {
        return btnAsignarCandidatos;
    }

    public JButton getBtnConsultarCandidato() {
        return btnConsultarCandidato;
    }

    public JButton getBtnConsultarProyectos() {
        return btnConsultarProyectos;
    }

    public JButton getBtnGestionarHoras() {
        return btnGestionarHoras;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JMenuItem getjMenuRegistrarCobroMensual() {
        return jMenuRegistrarCobroMensual;
    }

    public JMenu getJmenRecursoHumano() {
        return jmenRecursoHumano;
    }

    public JMenuItem getJmenuRegistrarCliente() {
        return jmenuRegistrarCliente;
    }

    public JPanel getJpanEncabezado() {
        return jpanEncabezado;
    }

    public JPanel getPanMenu() {
        return panMenu;
    }

    
    
    
    
    public void agregarListener(ActionListener accion){
        this.btnAsignarCandidatos.addActionListener(accion);
        this.btnConsultarCandidato.addActionListener(accion);
        this.btnConsultarCliente.addActionListener(accion);
        this.btnConsultarEntrevista.addActionListener(accion);
        this.btnConsultarProyectos.addActionListener(accion);
        this.btnConsultarRecordPagos.addActionListener(accion);
        this.btnConsultarRecordUtilidad.addActionListener(accion);
        this.btnConsultarFaltas.addActionListener(accion);
        this.btnGestionarHoras.addActionListener(accion);
        this.btnPagarNomina.addActionListener(accion);
        this.btnRegistrarFaltas.addActionListener(accion);
        this.btnRegistrarCandidato.addActionListener(accion);
        this.btnRegistrarCliente.addActionListener(accion);
        this.btnRegistrarEntrevista.addActionListener(accion);
        
        //J MENU -----------------------------------------
        
    this.jmenAsignarCandidato.addActionListener(accion);
    this.jMenuConsultarCandidato.addActionListener(accion);
    this.JMenuConsultarCliente.addActionListener(accion);
    this.jmenConsultarEntrevistas.addActionListener(accion);
    this.jMenuConsultarProyecto.addActionListener(accion);
    this.jmenRecordPagos.addActionListener(accion);
    this.jmenRecordUtilidad.addActionListener(accion);
    this.jmenConsultarFaltas.addActionListener(accion);
    this.jmenDiasFeriados.addActionListener(accion);    
    this.jmenConsultarHorasLaboradas.addActionListener(accion);
    this.jmenPagoNomina.addActionListener(accion);
    this.jmenRegistrarFaltas.addActionListener(accion);
    this.jmenRegistrarCandidato.addActionListener(accion);
    this.jmenuRegistrarCliente.addActionListener(accion);
    this.jmenRegistrarEntrevistas.addActionListener(accion);
       this.btnSalir.addActionListener(accion);
    
    
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMenu = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btnRegistrarFaltas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegistrarCandidato = new javax.swing.JButton();
        btnRegistrarEntrevista = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnConsultarCliente = new javax.swing.JButton();
        btnConsultarEntrevista = new javax.swing.JButton();
        btnConsultarFaltas = new javax.swing.JButton();
        btnConsultarRecordPagos = new javax.swing.JButton();
        btnConsultarRecordUtilidad = new javax.swing.JButton();
        btnPagarNomina = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConsultarProyectos = new javax.swing.JButton();
        btnAsignarCandidatos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnConsultarCandidato = new javax.swing.JButton();
        btnGestionarHoras = new javax.swing.JButton();
        jpanEncabezado = new javax.swing.JPanel();
        lblRegistrarCandidato = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenGeneral = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jmenuRegistrarCliente = new javax.swing.JMenuItem();
        jMenuRegistrarCobroMensual = new javax.swing.JMenuItem();
        JMenuConsultarCliente = new javax.swing.JMenuItem();
        jMenuConsultarProyecto = new javax.swing.JMenuItem();
        jmenDiasFeriados = new javax.swing.JMenuItem();
        jmenRecursoHumano = new javax.swing.JMenu();
        jmenGestionarCandidato = new javax.swing.JMenu();
        jmenRegistrarCandidato = new javax.swing.JMenuItem();
        jmenAsignarCandidato = new javax.swing.JMenuItem();
        jMenuConsultarCandidato = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmenRegistrarEntrevistas = new javax.swing.JMenuItem();
        jmenConsultarEntrevistas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmenRegistrarFaltas = new javax.swing.JMenuItem();
        jmenConsultarFaltas = new javax.swing.JMenuItem();
        jmenConsultarHorasLaboradas = new javax.swing.JMenuItem();
        jmenNomina = new javax.swing.JMenu();
        jmenPagoNomina = new javax.swing.JMenuItem();
        jmenBalances = new javax.swing.JMenu();
        jmenRecordPagos = new javax.swing.JMenuItem();
        jmenRecordUtilidad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panMenu.setBackground(new java.awt.Color(51, 51, 51));
        panMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/JETLOGO.png"))); // NOI18N
        panMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 160));

        btnRegistrarFaltas.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarFaltas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarFaltas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarFaltas.setText("Registrar Faltas");
        btnRegistrarFaltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFaltasActionPerformed(evt);
            }
        });
        panMenu.add(btnRegistrarFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 220, 30));

        btnSalir.setBackground(new java.awt.Color(255, 153, 51));
        btnSalir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        btnRegistrarCandidato.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarCandidato.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarCandidato.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCandidato.setText("Gestionar Candidatos");
        btnRegistrarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCandidatoActionPerformed(evt);
            }
        });
        panMenu.add(btnRegistrarCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 200, -1));

        btnRegistrarEntrevista.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarEntrevista.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarEntrevista.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEntrevista.setText("Registrar Entrevista");
        btnRegistrarEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEntrevistaActionPerformed(evt);
            }
        });
        panMenu.add(btnRegistrarEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 200, -1));

        btnRegistrarCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setText("Registrar Cliente-Proyecto");
        panMenu.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 200, 30));

        btnConsultarCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCliente.setText("Consultar Cliente");
        panMenu.add(btnConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 200, 30));

        btnConsultarEntrevista.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarEntrevista.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarEntrevista.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarEntrevista.setText("Consultar Entrevista");
        panMenu.add(btnConsultarEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 200, -1));

        btnConsultarFaltas.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarFaltas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarFaltas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarFaltas.setText("Consultar Faltas");
        panMenu.add(btnConsultarFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 220, 30));

        btnConsultarRecordPagos.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarRecordPagos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarRecordPagos.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarRecordPagos.setText("Consultar Record de Pagos");
        btnConsultarRecordPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarRecordPagosActionPerformed(evt);
            }
        });
        panMenu.add(btnConsultarRecordPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 210, -1));

        btnConsultarRecordUtilidad.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarRecordUtilidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarRecordUtilidad.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarRecordUtilidad.setText("Consultar Record de Utilidad");
        btnConsultarRecordUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarRecordUtilidadActionPerformed(evt);
            }
        });
        panMenu.add(btnConsultarRecordUtilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, 30));

        btnPagarNomina.setBackground(new java.awt.Color(102, 102, 102));
        btnPagarNomina.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnPagarNomina.setForeground(new java.awt.Color(255, 255, 255));
        btnPagarNomina.setText("Pagar Nomina");
        panMenu.add(btnPagarNomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 220, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clientes");
        panMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Entrevistas");
        panMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Proyectos");
        panMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Empleados");
        panMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        btnConsultarProyectos.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarProyectos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarProyectos.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarProyectos.setText("Gestionar Proyecto");
        panMenu.add(btnConsultarProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 200, 30));

        btnAsignarCandidatos.setBackground(new java.awt.Color(102, 102, 102));
        btnAsignarCandidatos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAsignarCandidatos.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignarCandidatos.setText("Asignar Candidatos");
        panMenu.add(btnAsignarCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reportes");
        panMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        btnConsultarCandidato.setBackground(new java.awt.Color(102, 102, 102));
        btnConsultarCandidato.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultarCandidato.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCandidato.setText("Consultar Candidatos");
        btnConsultarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCandidatoActionPerformed(evt);
            }
        });
        panMenu.add(btnConsultarCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 200, 30));

        btnGestionarHoras.setBackground(new java.awt.Color(102, 102, 102));
        btnGestionarHoras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnGestionarHoras.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionarHoras.setText("Gestión de Horas Laboradas");
        panMenu.add(btnGestionarHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 220, 30));

        getContentPane().add(panMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 740, 480));

        jpanEncabezado.setBackground(new java.awt.Color(255, 153, 51));

        lblRegistrarCandidato.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        lblRegistrarCandidato.setText("Menú Principal");

        javax.swing.GroupLayout jpanEncabezadoLayout = new javax.swing.GroupLayout(jpanEncabezado);
        jpanEncabezado.setLayout(jpanEncabezadoLayout);
        jpanEncabezadoLayout.setHorizontalGroup(
            jpanEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrarCandidato)
                .addContainerGap(531, Short.MAX_VALUE))
        );
        jpanEncabezadoLayout.setVerticalGroup(
            jpanEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanEncabezadoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRegistrarCandidato)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jpanEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        jmenGeneral.setText("General");

        jMenu7.setText("Gestionar");

        jMenu8.setText("Cliente");

        jmenuRegistrarCliente.setText("Registrar cliente");
        jMenu8.add(jmenuRegistrarCliente);

        jMenuRegistrarCobroMensual.setText("Cobro mensual");
        jMenu8.add(jMenuRegistrarCobroMensual);

        JMenuConsultarCliente.setText("Consultar cliente");
        jMenu8.add(JMenuConsultarCliente);

        jMenu7.add(jMenu8);

        jMenuConsultarProyecto.setText("Proyecto");
        jMenu7.add(jMenuConsultarProyecto);

        jmenGeneral.add(jMenu7);

        jmenDiasFeriados.setText("Configurar dias feriados");
        jmenGeneral.add(jmenDiasFeriados);

        jMenuBar1.add(jmenGeneral);

        jmenRecursoHumano.setText("Recurso humano");

        jmenGestionarCandidato.setText("Gestionar candidato");

        jmenRegistrarCandidato.setText("Registrar/Modificar candidato");
        jmenGestionarCandidato.add(jmenRegistrarCandidato);

        jmenAsignarCandidato.setText("Asignar candidato");
        jmenGestionarCandidato.add(jmenAsignarCandidato);

        jMenuConsultarCandidato.setText("Consultar candidato");
        jMenuConsultarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultarCandidatoActionPerformed(evt);
            }
        });
        jmenGestionarCandidato.add(jMenuConsultarCandidato);

        jmenRecursoHumano.add(jmenGestionarCandidato);

        jMenu1.setText("Gestionar entrevistas");

        jmenRegistrarEntrevistas.setText("Registrar entrevistas");
        jMenu1.add(jmenRegistrarEntrevistas);

        jmenConsultarEntrevistas.setText("Consultar entrevistas");
        jMenu1.add(jmenConsultarEntrevistas);

        jmenRecursoHumano.add(jMenu1);

        jMenu3.setText("Gestionar faltas");

        jmenRegistrarFaltas.setText("Registrar faltas");
        jMenu3.add(jmenRegistrarFaltas);

        jmenConsultarFaltas.setText("Consultar faltas");
        jMenu3.add(jmenConsultarFaltas);

        jmenRecursoHumano.add(jMenu3);

        jmenConsultarHorasLaboradas.setText("Consultar horas laboradas");
        jmenRecursoHumano.add(jmenConsultarHorasLaboradas);

        jMenuBar1.add(jmenRecursoHumano);

        jmenNomina.setText("Nomina");

        jmenPagoNomina.setText("Pago de nomina");
        jmenNomina.add(jmenPagoNomina);

        jMenuBar1.add(jmenNomina);

        jmenBalances.setText("Balances");

        jmenRecordPagos.setText("Consultar record de pagos");
        jmenBalances.add(jmenRecordPagos);

        jmenRecordUtilidad.setText("Consultar record de utilidad");
        jmenBalances.add(jmenRecordUtilidad);

        jMenuBar1.add(jmenBalances);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarFaltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarFaltasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarFaltasActionPerformed

    private void btnRegistrarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarCandidatoActionPerformed

    private void btnRegistrarEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEntrevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarEntrevistaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarRecordPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarRecordPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarRecordPagosActionPerformed

    private void btnConsultarRecordUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarRecordUtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarRecordUtilidadActionPerformed

    private void btnConsultarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarCandidatoActionPerformed

    private void jMenuConsultarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultarCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuConsultarCandidatoActionPerformed

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
            java.util.logging.Logger.getLogger(VMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuConsultarCliente;
    private javax.swing.JButton btnAsignarCandidatos;
    private javax.swing.JButton btnConsultarCandidato;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnConsultarEntrevista;
    private javax.swing.JButton btnConsultarFaltas;
    private javax.swing.JButton btnConsultarProyectos;
    private javax.swing.JButton btnConsultarRecordPagos;
    private javax.swing.JButton btnConsultarRecordUtilidad;
    private javax.swing.JButton btnGestionarHoras;
    private javax.swing.JButton btnPagarNomina;
    private javax.swing.JButton btnRegistrarCandidato;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarEntrevista;
    private javax.swing.JButton btnRegistrarFaltas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConsultarCandidato;
    private javax.swing.JMenuItem jMenuConsultarProyecto;
    private javax.swing.JMenuItem jMenuRegistrarCobroMensual;
    private javax.swing.JMenuItem jmenAsignarCandidato;
    private javax.swing.JMenu jmenBalances;
    private javax.swing.JMenuItem jmenConsultarEntrevistas;
    private javax.swing.JMenuItem jmenConsultarFaltas;
    private javax.swing.JMenuItem jmenConsultarHorasLaboradas;
    private javax.swing.JMenuItem jmenDiasFeriados;
    private javax.swing.JMenu jmenGeneral;
    private javax.swing.JMenu jmenGestionarCandidato;
    private javax.swing.JMenu jmenNomina;
    private javax.swing.JMenuItem jmenPagoNomina;
    private javax.swing.JMenuItem jmenRecordPagos;
    private javax.swing.JMenuItem jmenRecordUtilidad;
    private javax.swing.JMenu jmenRecursoHumano;
    private javax.swing.JMenuItem jmenRegistrarCandidato;
    private javax.swing.JMenuItem jmenRegistrarEntrevistas;
    private javax.swing.JMenuItem jmenRegistrarFaltas;
    private javax.swing.JMenuItem jmenuRegistrarCliente;
    private javax.swing.JPanel jpanEncabezado;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRegistrarCandidato;
    private javax.swing.JPanel panMenu;
    // End of variables declaration//GEN-END:variables
}
