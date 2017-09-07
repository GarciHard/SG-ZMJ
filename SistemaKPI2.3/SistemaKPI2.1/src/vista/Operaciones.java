package vista;

import control.LoginControl;
import control.PrincipalControl;
import java.awt.Cursor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author GUR5TL
 */
public class Operaciones extends javax.swing.JDialog {

    String per;
    public static String linea = "";
    Principal winPrincipal;
    
    ConexionBD con = new ConexionBD();
    //Connection cn = con.getConnection();
    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;

    /**
     * Creates new form
     */
    public Operaciones(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/bs.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTema = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox();
        cmbArea = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtDescProblema = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescOpe = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPerdidas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox();

        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);
        jPopupMenu1.add(jSeparator1);

        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Oprecion"));

        jLabel2.setText("Operación:");

        cmbTema.setActionCommand("cmbTema");
        cmbTema.setNextFocusableComponent(cmbOperacion);
        cmbTema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTemaItemStateChanged(evt);
            }
        });

        jLabel3.setText("Tema:");

        cmbOperacion.setActionCommand("cmbOperacion");
        cmbOperacion.setNextFocusableComponent(cmbArea);
        cmbOperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOperacionItemStateChanged(evt);
            }
        });

        cmbArea.setActionCommand("cmbArea");
        cmbArea.setNextFocusableComponent(txtDescProblema);
        cmbArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAreaItemStateChanged(evt);
            }
        });

        jLabel4.setText("Problema:");

        txtDescProblema.setEnabled(false);
        txtDescProblema.setNextFocusableComponent(btnGuardar);

        jLabel1.setText("Area:");

        jLabel5.setText("Descripcion:");

        txtDescOpe.setEditable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.setActionCommand("btnGuardar");
        btnGuardar.setNextFocusableComponent(btnCancelar);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("btnCancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescOpe, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtDescOpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPerdidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tema", "Operacion", "Area", "Problema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPerdidas.setComponentPopupMenu(jPopupMenu1);
        tablaPerdidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPerdidas);

        jLabel6.setText("Buscar por:");

        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tema", "Operacion", "Area", "Problema" }));
        cmbBuscar.setActionCommand("cmbBuscar");
        cmbBuscar.setNextFocusableComponent(txtBuscar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            linea = PrincipalControl.linea;
            DefaultTableModel mod = (DefaultTableModel) tablaPerdidas.getModel();
            mod = ModeloValidacionesOperaciones.llenaTablaPerdidas(linea, mod);
            tablaPerdidas.setModel(mod);
            cmbTema.setModel(ModelosListasOperaciones.listaTema());
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    @SuppressWarnings("empty-statement")
    private void cmbTemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTemaItemStateChanged
        System.out.println(cmbTema.getSelectedIndex());
        if (cmbTema.getSelectedIndex() != 0) {
            cmbOperacion.setEnabled(true);
            try{
                if (cmbTema.getSelectedIndex() != 1 && cmbTema.getSelectedIndex() != 2 ){
                    try{
                        cmbOperacion.setModel(ModeloValidacionesOperaciones.listaOperacionesPorLineaDESC(linea));
                        cmbOperacion.setSelectedIndex(1);
                        cmbOperacion.setEnabled(false);
                        cmbArea.setEnabled(true);
                    } catch (Exception ex) {
                        Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else {
                    cmbOperacion.setModel(ModeloValidacionesOperaciones.listaOperacionesPorLineaASC(linea));
                    cmbOperacion.setEnabled(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (cmbTema.getSelectedIndex() == 0){
            System.out.println("entra"+cmbTema.getSelectedIndex());
            cmbOperacion.setSelectedIndex(-1);
            cmbOperacion.setEnabled(false);
            cmbArea.setSelectedIndex(-1);
            cmbArea.setEnabled(false);
            txtDescOpe.setText("");
            txtDescProblema.setText("");
            txtDescProblema.setEditable(false);
        }
    }//GEN-LAST:event_cmbTemaItemStateChanged

    private void cmbOperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOperacionItemStateChanged
        if (cmbOperacion.getSelectedIndex() != 0 && cmbTema.getSelectedIndex() != 0) {
            cmbArea.setEnabled(true);
            String operacion = cmbOperacion.getSelectedItem().toString();
            try {
                //txtDescOpe.setText(Principal.cls.DescOp(linea, operacion));
                txtDescOpe.setText(ModeloValidacionesOperaciones.descripcionOperacion(linea, operacion));
                switch (cmbTema.getSelectedIndex()){
                    case 1:
                       cmbArea.setModel(ModelosListasOperaciones.listaAreaCalidad());
                        break;
                    case 2:
                        cmbArea.setModel(ModelosListasOperaciones.listaAreTecnicas());
                        break;
                    case 3:
                        cmbArea.setModel(ModelosListasOperaciones.listaAreaOrganizacionales());
                        break;
                    case 4:
                        cmbArea.setModel(ModelosListasOperaciones.listaAreaCambio());
                        break;
                    case 5:
                        cmbArea.setModel(ModelosListasOperaciones.listaAreaPlaneados());
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            txtDescOpe.setText("");
            txtDescProblema.setText("");
            txtDescProblema.setEnabled(false);
            cmbArea.setSelectedIndex(-1);
            cmbArea.setEnabled(false);
        }
    }//GEN-LAST:event_cmbOperacionItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        cmbTema.setEnabled(false);
        cmbArea.setEnabled(false);
        cmbOperacion.setEnabled(false);
        cmbBuscar.setEnabled(false);
        txtBuscar.setEnabled(false);
        txtDescOpe.setEnabled(false);
        txtDescProblema.setEditable(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        try {
            Object[] regPerdida = new Object[5];
            if (btnGuardar.getText().equals("Guardar")) {
                if (cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0 && !txtDescProblema.getText().equals("")) {
                    try {
                        regPerdida[0] = linea;
                        regPerdida[1] = cmbTema.getSelectedItem().toString();
                        regPerdida[2] = cmbOperacion.getSelectedItem().toString();
                        regPerdida[3] = cmbArea.getSelectedItem().toString();
                        regPerdida[4] = txtDescProblema.getText();
                        ModeloValidacionesOperaciones.insertaPerdida(regPerdida);
                        limpiar();
                    } catch (Exception ex) {
                        Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Se deben llenar todos los campos", "Datos Faltantes", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    if (!txtDescProblema.getText().equals("")){
                        regPerdida[0] = linea;
                        regPerdida[1] = cmbTema.getSelectedItem().toString();
                        regPerdida[2] = cmbOperacion.getSelectedItem().toString();
                        regPerdida[3] = cmbArea.getSelectedItem().toString();
                        regPerdida[4] = txtDescProblema.getText();
                        //Principal.in.updatePerdida(this, regPerdida, per);
                        ModeloValidacionesOperaciones.updatePerdida(this, regPerdida, per);
                        btnGuardar.setText("Guardar");
                        limpiar();
                    }else {
                        JOptionPane.showMessageDialog(this, "No se puede crear la actualizacion por falta de problema");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            DefaultTableModel mod = (DefaultTableModel) tablaPerdidas.getModel();
            ModeloValidacionesOperaciones.llenaTablaPerdidas(linea, mod);
            tablaPerdidas.setModel(mod);
            
            cmbTema.setModel(ModelosListasOperaciones.listaTema());
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cmbTema.setEnabled(true);
        //btnGuardar.setEnabled(true);
        //btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        txtDescProblema.setEditable(true);
        if (tablaPerdidas.getSelectedRow() >= 0) {
            Object[] reg = new Object[tablaPerdidas.getColumnCount()];
            int row = tablaPerdidas.getSelectedRow();
            for (int i = 0; i < tablaPerdidas.getColumnCount(); i++) {
                reg[i] = tablaPerdidas.getValueAt(row, i);
            }
            for (int i = 0; i < cmbTema.getItemCount(); i++) {
                if (cmbTema.getItemAt(i).toString().toLowerCase().equals(reg[0].toString().toLowerCase())) {
                    cmbTema.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < cmbOperacion.getItemCount(); i++) {
                if (cmbOperacion.getItemAt(i).toString().toLowerCase().equals(reg[1].toString().toLowerCase())) {
                    cmbOperacion.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < cmbArea.getItemCount(); i++) {
                if (cmbArea.getItemAt(i).toString().toLowerCase().equals(reg[2].toString().toLowerCase())) {
                    cmbArea.setSelectedIndex(i);
                }
            }
            txtDescProblema.setText(reg[3].toString());
            per = reg[3].toString();
            btnGuardar.setText("Actualizar");
            cmbTema.setEnabled(false);
            cmbOperacion.setEnabled(false);
            cmbArea.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro");
        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        try {
            tablaPerdidas.setModel(ModeloValidacionesOperaciones.busqueda(linea, cmbBuscar.getSelectedItem().toString(), txtBuscar.getText(), (DefaultTableModel) tablaPerdidas.getModel()));
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        if (tablaPerdidas.getSelectedRow() >= 0) {
            
           PrincipalControl.auxiliarPrincipal = 4;
            new LoginControl(new Login(winPrincipal, true));
            if (LoginControl.auxiliarLogin == 1) {
                int op = JOptionPane.showConfirmDialog(this, "El registro se eliminará permanentemente\n ¿Desea Continar?", "Precaucion", JOptionPane.WARNING_MESSAGE);
                if (op == 0) {
                    try {
                        Object[] reg = new Object[tablaPerdidas.getColumnCount()];
                        int row = tablaPerdidas.getSelectedRow();
                        for (int i = 0; i < tablaPerdidas.getColumnCount(); i++) {
                            reg[i] = tablaPerdidas.getValueAt(row, i);
                        }
                        //Principal.in.deletePerdida(this, reg, linea);
                        ModeloValidacionesOperaciones.deletePerdida(this, reg, linea);
                        DefaultTableModel mod = (DefaultTableModel) tablaPerdidas.getModel();
                        //mod = Principal.ms.llenaTablaPerdidas(linea, mod);
                        ModeloValidacionesOperaciones.llenaTablaPerdidas(linea, mod);
                        tablaPerdidas.setModel(mod);
                        cmbTema.setModel(ModelosListasOperaciones.listaTema());
                    } catch (Exception ex) {
                        Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAreaItemStateChanged
        if (cmbArea.getSelectedIndex() != 0) {
            txtDescProblema.setEditable(true);
            txtDescProblema.setEnabled(true);
        }else{
            txtDescProblema.setText("");
            txtDescProblema.setEditable(false);
            txtDescProblema.setEnabled(false);
        }
    }//GEN-LAST:event_cmbAreaItemStateChanged
 
    public void limpiar() {
        btnGuardar.setText("Guardar");
        cmbTema.setSelectedIndex(0);
        cmbOperacion.setSelectedIndex(-1);
        cmbArea.setSelectedIndex(-1);
        txtDescOpe.setText("");
        txtDescProblema.setText("");
        txtDescProblema.setEnabled(false);
        cmbTema.setEnabled(false);
        cmbOperacion.setEnabled(false);
        cmbArea.setEnabled(false);
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public static JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JComboBox getCmbArea() {
        return cmbArea;
    }

    public JComboBox getCmbBuscar() {
        return cmbBuscar;
    }

    public JComboBox getCmbOperacion() {
        return cmbOperacion;
    }

    public JComboBox getCmbTema() {
        return cmbTema;
    }

    public JMenuItem getMenuEditar() {
        return menuEditar;
    }

    public JMenuItem getMenuEliminar() {
        return menuEliminar;
    }

    public JTable getTablaPerdidas() {
        return tablaPerdidas;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public JTextField getTxtDescOpe() {
        return txtDescOpe;
    }

    public JTextField getTxtDescProblema() {
        return txtDescProblema;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    protected static javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbBuscar;
    private javax.swing.JComboBox cmbOperacion;
    protected javax.swing.JComboBox cmbTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTable tablaPerdidas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescOpe;
    private javax.swing.JTextField txtDescProblema;
    // End of variables declaration//GEN-END:variables
}
