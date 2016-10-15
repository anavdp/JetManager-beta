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

import dao.DaoCandidato;
import dao.DaoEmpleado;
import dao.DaoProyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MCandidato;
import modelo.MEmpleado;
import modelo.MProyecto;
import vista.Mensajes;
import vista.VConsultaRecordPago;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class CConsultaRecordPago implements ActionListener {

    private final VConsultaRecordPago vrecpag;
    private final ArrayList<MCandidato> listadocan;
    private MEmpleado emp;
    private ArrayList<MEmpleado> listadoemp;
    private ArrayList<MProyecto> listadoproy;

    public CConsultaRecordPago() throws SQLException {
        vrecpag = new VConsultaRecordPago();
        vrecpag.setVisible(true);
        vrecpag.Agregar_Listener(this);
        listadocan = new ArrayList<>();
        listadoproy = new ArrayList<>();
        listadoemp = new ArrayList<>();

        CargarProyectos();
        CargarEmpleados();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vrecpag.getRadiobtnProyecto())) {

            vrecpag.getCmbboxProyectoConsultar().setVisible(true);
            vrecpag.getBtnConsultarProyecto().setVisible(true);
            vrecpag.getLblNombreProyectoConsultar().setVisible(true);

            vrecpag.getCmbboxEmpleadoConsultar().setSelectedIndex(0);
            vrecpag.getLblNombreEmpleadoConsultar().setVisible(false);
            vrecpag.getCmbboxEmpleadoConsultar().setVisible(false);
            vrecpag.getBtnConsultarEmpleado().setVisible(false);
            vrecpag.getScrollpanReporteEmpleado().setVisible(false);
            vrecpag.getTxtSalario().setVisible(false);
            vrecpag.getTxtTipoDePago().setVisible(false);
            vrecpag.getTxtTipoDeMoneda().setVisible(false);
            vrecpag.getLblSalario().setVisible(false);
            vrecpag.getLblTipoDePago().setVisible(false);
            vrecpag.getLblTipoDeMoneda().setVisible(false);

            vrecpag.getCmbboxMesConsultar().setSelectedIndex(0);
            vrecpag.getLblMesConsultar().setVisible(false);
            vrecpag.getCmbboxMesConsultar().setVisible(false);
            vrecpag.getBtnConsultarMes().setVisible(false);
            vrecpag.getLblHorasLaborables().setVisible(false);
            vrecpag.getTxtHorasLaborables().setVisible(false);
            vrecpag.getScrollpaneReporteMes().setVisible(false);

        }

        if (e.getSource().equals(vrecpag.getBtnConsultarProyecto())) {

            if (vrecpag.getCmbboxProyectoConsultar().getSelectedItem().equals("...")) {

                Mensajes.Aviso("Debe seleccionar un proyecto a consultar", "Aviso");
                vrecpag.getScrollpanReporteProyecto().setVisible(false);

            } else {

                try {
                    LlenarTablaProyecto();
                } catch (SQLException ex) {
                    Logger.getLogger(CConsultaRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                }

                vrecpag.getScrollpanReporteProyecto().setVisible(true);
            }

        }

        if (e.getSource().equals(vrecpag.getRadiobtnEmpleado())) {

            vrecpag.getCmbboxProyectoConsultar().setSelectedIndex(0);
            vrecpag.getCmbboxProyectoConsultar().setVisible(false);

            vrecpag.getBtnConsultarProyecto().setVisible(false);
            vrecpag.getLblNombreProyectoConsultar().setVisible(false);
            vrecpag.getScrollpanReporteProyecto().setVisible(false);

            vrecpag.getLblNombreEmpleadoConsultar().setVisible(true);
            vrecpag.getCmbboxEmpleadoConsultar().setVisible(true);
            vrecpag.getBtnConsultarEmpleado().setVisible(true);

            vrecpag.getCmbboxMesConsultar().setSelectedIndex(0);
            vrecpag.getLblMesConsultar().setVisible(false);
            vrecpag.getCmbboxMesConsultar().setVisible(false);
            vrecpag.getBtnConsultarMes().setVisible(false);
            vrecpag.getLblHorasLaborables().setVisible(false);
            vrecpag.getTxtHorasLaborables().setVisible(false);
            vrecpag.getScrollpaneReporteMes().setVisible(false);

        }

        if (e.getSource().equals(vrecpag.getBtnConsultarEmpleado())) {

            if (vrecpag.getCmbboxEmpleadoConsultar().getSelectedItem().equals("...")) {

                Mensajes.Aviso("Debe seleccionar un empleado a consultar", "Aviso");
                vrecpag.getScrollpanReporteEmpleado().setVisible(false);
                vrecpag.getScrollpanReporteEmpleado().setVisible(false);
                vrecpag.getTxtSalario().setVisible(false);
                vrecpag.getTxtTipoDePago().setVisible(false);
                vrecpag.getTxtTipoDeMoneda().setVisible(false);
                vrecpag.getLblSalario().setVisible(false);
                vrecpag.getLblTipoDePago().setVisible(false);
                vrecpag.getLblTipoDeMoneda().setVisible(false);

            } else {

                try {
                    CargarDetalleEmpleado();
                    LlenarTablaEmpleado();

                } catch (SQLException ex) {
                    Logger.getLogger(CConsultaRecordPago.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        if (e.getSource().equals(vrecpag.getRadiobtnMes())) {

            vrecpag.getCmbboxProyectoConsultar().setSelectedIndex(0);
            vrecpag.getCmbboxProyectoConsultar().setVisible(false);
            vrecpag.getBtnConsultarProyecto().setVisible(false);
            vrecpag.getLblNombreProyectoConsultar().setVisible(false);
            vrecpag.getScrollpanReporteProyecto().setVisible(false);

            vrecpag.getCmbboxEmpleadoConsultar().setSelectedIndex(0);
            vrecpag.getLblNombreEmpleadoConsultar().setVisible(false);
            vrecpag.getCmbboxEmpleadoConsultar().setVisible(false);
            vrecpag.getBtnConsultarEmpleado().setVisible(false);
            vrecpag.getScrollpanReporteEmpleado().setVisible(false);
            vrecpag.getTxtSalario().setVisible(false);
            vrecpag.getTxtTipoDePago().setVisible(false);
            vrecpag.getTxtTipoDeMoneda().setVisible(false);
            vrecpag.getLblSalario().setVisible(false);
            vrecpag.getLblTipoDePago().setVisible(false);
            vrecpag.getLblTipoDeMoneda().setVisible(false);

            vrecpag.getLblMesConsultar().setVisible(true);
            vrecpag.getCmbboxMesConsultar().setVisible(true);
            vrecpag.getBtnConsultarMes().setVisible(true);

        }

        if (e.getSource().equals(vrecpag.getBtnConsultarMes())) {

            if (vrecpag.getCmbboxMesConsultar().getSelectedItem().equals("...")) {

                Mensajes.Aviso("Debe seleccionar un mes a consultar", "Aviso");
                vrecpag.getScrollpaneReporteMes().setVisible(false);

                vrecpag.getLblHorasLaborables().setVisible(false);
                vrecpag.getTxtHorasLaborables().setVisible(false);

            } else {

                LlenarTablaMes();

                vrecpag.getLblHorasLaborables().setVisible(true);
                vrecpag.getTxtHorasLaborables().setVisible(true);

                vrecpag.getScrollpaneReporteMes().setVisible(true);

            }

        }

        throw new UnsupportedOperationException("Opcion no valida"); //To change body of generated methods, choose Tools | Templates.
    }

    private void CargarProyectos() throws SQLException {

        DaoProyecto daoTipo = new DaoProyecto();
        ResultSet RegistroProy;
        RegistroProy = daoTipo.consultarProyectos();
        MProyecto proy;

        while (RegistroProy.next()) {

            String nom, id;
            id = RegistroProy.getString("ProyId");
            nom = RegistroProy.getString("ProyTitulo");
            proy = new MProyecto(id, nom);
            listadoproy.add(proy);
            vrecpag.getCmbboxProyectoConsultar().addItem(nom);
        }
        RegistroProy.close();
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
                vrecpag.getCmbboxEmpleadoConsultar().addItem(can.toString());

            }
            empleados.close();
        } catch (SQLException ex) {
            Logger.getLogger(CConsultaRecordPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargarDetalleEmpleado() throws SQLException {
        int ind = vrecpag.getCmbboxEmpleadoConsultar().getSelectedIndex() - 1;
        DaoEmpleado daoTipo = new DaoEmpleado();
        MCandidato can = listadocan.get(ind);
        ResultSet rs = daoTipo.BuscarEmpleadoRif(can.getRif());
        if (rs.next()) {
            vrecpag.getTxtTipoDeMoneda().setText(rs.getString("EmpTipoMoneda"));
            vrecpag.getTxtSalario().setText(rs.getString("EmpSalario"));
            vrecpag.getTxtTipoDePago().setText(rs.getString("EmpTipoPago"));
            vrecpag.getScrollpanReporteEmpleado().setVisible(false);
            vrecpag.getTxtSalario().setVisible(true);
            vrecpag.getTxtTipoDePago().setVisible(true);
            vrecpag.getTxtTipoDeMoneda().setVisible(true);
            vrecpag.getLblSalario().setVisible(true);
            vrecpag.getLblTipoDePago().setVisible(true);
            vrecpag.getLblTipoDeMoneda().setVisible(true);
            vrecpag.getScrollpanReporteEmpleado().setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Candidato sin ser asignado a un proyecto ");
            vrecpag.getScrollpanReporteEmpleado().setVisible(false);
            vrecpag.getTxtSalario().setVisible(false);
            vrecpag.getTxtTipoDePago().setVisible(false);
            vrecpag.getTxtTipoDeMoneda().setVisible(false);
            vrecpag.getLblSalario().setVisible(false);
            vrecpag.getLblTipoDePago().setVisible(false);
            vrecpag.getLblTipoDeMoneda().setVisible(false);
        }
        rs.close();
    }

    private void LlenarTablaProyecto() throws SQLException {
        DefaultTableModel model;
        model = new DefaultTableModel();
        DaoProyecto daotipo = new DaoProyecto();
        vrecpag.getTableReporteProyecto().setModel(model);
        ResultSet rs = daotipo.BuscaProyectosParaTableModel(String.valueOf(vrecpag.getCmbboxProyectoConsultar().getSelectedItem()));
        try {
            model.addColumn("ID"); //Empleado
            model.addColumn("Nombres"); //Candidato
            model.addColumn("Apellidos");
            model.addColumn("Horas Trabajadas"); //PagoMensual
            model.addColumn("Salario");// Empleado
            model.addColumn("Tipo de pago");
            model.addColumn("Tipo de moneda");
            model.addColumn("Monto"); //PagoMensual

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[8];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 8; i++) {
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

    private void LlenarTablaEmpleado() throws SQLException {

        DefaultTableModel model1;
        model1 = new DefaultTableModel();
        DaoEmpleado daoTipo = new DaoEmpleado();
        vrecpag.getTableReporteEmpleado().setModel(model1);

        ResultSet rs = daoTipo.BuscaEmpleadosParaTableModel(String.valueOf(vrecpag.getCmbboxEmpleadoConsultar().getSelectedItem()));
        try {
            model1.addColumn("Fecha");
            model1.addColumn("Horas Trabajadas");
            model1.addColumn("Monto");

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[3];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // es para cargar los datos en filas a la tabla modelo
                model1.addRow(fila);

            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    private void LlenarTablaMes() {
        DefaultTableModel model;
        model = new DefaultTableModel();
        DaoEmpleado daotipo = new DaoEmpleado();
        vrecpag.getTableReporteMes().setModel(model);
        ResultSet rs = daotipo.BuscaEmpleadosMesParaTableModel(String.valueOf(vrecpag.getCmbboxMesConsultar().getSelectedItem()));
        try {
            model.addColumn("ID"); //Empleado
            model.addColumn("Nombres"); //Candidato
            model.addColumn("Apellidos");
            model.addColumn("Horas Trabajadas"); //PagoMensual
            model.addColumn("Tipo de pago");// Empleado
            model.addColumn("Salario");
            model.addColumn("Proyecto");
            model.addColumn("Monto");
            //PagoMensual

            while (rs.next()) {
                // es para obtener los datos y almacenar las filas
                Object[] fila = new Object[8];
                // para llenar cada columna con lo datos almacenados
                for (int i = 0; i < 8; i++) {
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

}
