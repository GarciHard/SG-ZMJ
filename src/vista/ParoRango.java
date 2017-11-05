package vista;

import dao.BitacoraDAOImpl;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.OrdenaTablaTiempo;
import utils.PrincipalMetodos;

/**
 *
 * @author PRR1TL
 */
public class ParoRango extends javax.swing.JDialog {

    public static int hInicio = 0;
    public static int hFin = 0;
    ///registro
    private static DefaultTableModel modeloTabla;
    private static Object[] registroBitacora = new Object[17];
    private static int contadorFila = 0;  
    private static ArrayList tiempoHora;
    private static Object[] tiempos;
    private static Object[] registroBitacoraAux;
    private static Object[] registroBitacoraTmp;
    private static Object[] registroBitacoraTmpAux;
    private static List tablaObj = new ArrayList();    
    
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    public static int auxParoRango = 0;
    
    Principal winPrincipal;
    
    public ParoRango(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        winPrincipal = (Principal) parent;
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/bs.png")).getImage());
        cmbHInicio.setModel(new DefaultComboBoxModel(TiempoTurno.cmbTiempoModel.toArray()));
        cmbHFin.setModel(new DefaultComboBoxModel(TiempoTurno.cmbTiempoModel.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbHInicio = new javax.swing.JComboBox();
        cmbHFin = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAceptar.setText("Aceptar");
        btnAceptar.setNextFocusableComponent(btnAceptar);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setNextFocusableComponent(btnCancelar);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbHInicio.setNextFocusableComponent(cmbHFin);

        cmbHFin.setNextFocusableComponent(btnAceptar);

        jLabel1.setText("Hora Fin");

        jLabel2.setText("Hora Inicio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHFin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        cmbHInicio.setEnabled(false);
        cmbHFin.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        hInicio = Integer.parseInt(cmbHInicio.getSelectedItem().toString());
        hFin = Integer.parseInt(cmbHFin.getSelectedItem().toString());
        int cont = hFin - hInicio;
        int aux = 0;        
        if(hFin <= hInicio){
            JOptionPane.showMessageDialog(this, "Revisa tu ahora de Inicio y Fin");
        }else {
            while ( aux <= cont){ //Inicio <= hFin 
                agregarRegistroBitacora(winPrincipal);
                hInicio = hInicio+1;
                aux = aux+1;
            }
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "Paro de tiempo guardado");
            winPrincipal.getCmbHora().setEnabled(false);
            winPrincipal.getCmbTema().setSelectedIndex(0);
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cmbHInicio.setSelectedIndex(0);
        cmbHFin.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void agregarRegistroBitacora(Principal winPrincipal) {
        int valorTema = winPrincipal.getCmbTema().getSelectedIndex();
        modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        registroBitacora = modeloRegistroBitacora(winPrincipal, registroBitacora);

        if (winPrincipal.getTblBitacora().getRowCount() == 0) {
            modeloTabla.addRow(registroBitacora);
            insertarRegistroFilaAccess(winPrincipal);           
        } else {
            tiempoHora = new ArrayList();
            for (int c = 0; c < modeloTabla.getRowCount(); c++) {
                if (modeloTabla.getValueAt(c, 2).toString().equals(registroBitacora[2].toString())) {
                    tiempos = new Object[4];
                    tiempos[0] = modeloTabla.getValueAt(c, 2);
                    tiempos[1] = modeloTabla.getValueAt(c, 3);
                    tiempos[2] = modeloTabla.getValueAt(c, 4);
                    tiempos[3] = modeloTabla.getValueAt(c, 5);
                    tiempoHora.add(tiempos);
                }
            }
            if (!tiempoHora.isEmpty()) {
                for (int i = 0; i < tiempoHora.size(); i++) {
                    registroBitacoraTmp = (Object[]) tiempoHora.get(i);
                    registroBitacoraTmpAux = null;
                    if (tiempoHora.size() > 1 && i < tiempoHora.size() - 1) {
                        registroBitacoraTmpAux = (Object[]) tiempoHora.get(i + 1);
                    }
                    if (Integer.parseInt(registroBitacora[3].toString()) > Integer.parseInt(registroBitacoraTmp[1].toString())) {
                        if (Integer.parseInt(registroBitacora[3].toString()) < Integer.parseInt(registroBitacoraTmp[2].toString())) {
                            JOptionPane.showMessageDialog(winPrincipal, "Registro dentro de intervalo no válido","Advertencia", JOptionPane.WARNING_MESSAGE );
                            
                            break;
                        } else if (Integer.parseInt(registroBitacora[3].toString()) > Integer.parseInt(registroBitacoraTmp[2].toString())) {
                            if (registroBitacoraTmpAux != null) {
                                if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmpAux[1].toString())) {
                                    modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                    ordenarTabla(modeloTabla);
                                    insertarRegistroFilaAccess(winPrincipal);   
                                    
                                    break;
                                }
                            } else {
                                modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                ordenarTabla(modeloTabla);
                                insertarRegistroFilaAccess(winPrincipal);
                                
                                break;
                            }
                        }
                    } else if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmp[1].toString())) {
                        modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                        ordenarTabla(modeloTabla);
                        insertarRegistroFilaAccess(winPrincipal);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(winPrincipal, "Tiempo de registro duplicado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                ordenarTabla(modeloTabla);
                insertarRegistroFilaAccess(winPrincipal);
            }
        }
    }
    
    private Object[] modeloRegistroBitacora(Principal winPrincipal, Object[] reg) {
        switch (winPrincipal.getCmbTema().getSelectedItem().toString()) {
            case "Tiempo Faltante":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaPlaneados().getSelectedItem();
                reg[9] = "";
                reg[10] = winPrincipal.getCmbClientePlaneados().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePlaneados().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "0";
                reg[15] = "";
                reg[16] = "";
                break;
            case "Calidad":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();
                reg[7] = winPrincipal.getCmbOperacionCalidad().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaCalidad().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaCalidad().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteCalidad().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCalidad().getSelectedItem();
                reg[12] = "0";//winPrincipal.getTxtCantidadProducidaCalidad().getText();
                reg[13] = "";
                reg[14] = winPrincipal.getTxtScrapCalidad().getText();
                reg[15] = "";
                reg[16] = "0";
                break;
            case "Tecnicas":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbOperacionTecnicas().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaTecnicas().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaTecnicas().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteTecnicas().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteTecnicas().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = winPrincipal.getTxtScrapTecnicas().getText();
                reg[15] = "";
                reg[16] = "0";
                break;
            case "Organizacionales":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaOrganizacional().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaOrganizacional().getSelectedItem();
                if (winPrincipal.getCmbClienteOrganizacional()
                        .getSelectedItem().equals(winPrincipal.getCmbClienteOrganizacional().getItemAt(0))) {
                    reg[10] = "";
                } else {
                    reg[10] = winPrincipal.getCmbClienteOrganizacional().getSelectedItem();
                }
                if (winPrincipal.getCmbNoParteOrganizacional()
                        .getSelectedItem().equals(winPrincipal.getCmbNoParteOrganizacional().getItemAt(0))) {
                    reg[11] = "";
                } else {
                    reg[11] = winPrincipal.getCmbNoParteOrganizacional().getSelectedItem();
                }
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "0";
                reg[15] = winPrincipal.getTxtMatFaltante().getText();
                reg[16] = "0";
                break;
            case "Cambio de Modelo":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaCambios().getSelectedItem();
                reg[9] = winPrincipal.getCmbClienteCambios().getSelectedItem()+"-"+winPrincipal.getCmbNoParteCambios().getSelectedItem()+" a "+winPrincipal.getCmbClienteNuevoCambios().getSelectedItem()+"-"+winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();//winPrincipal.getCmbProblemaCambios().getSelectedItem(); //problema
                reg[10] = winPrincipal.getCmbClienteCambios().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCambios().getSelectedItem();
                reg[12] = 0;
                reg[13] = winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();
                reg[14] = winPrincipal.getTxtScrapCambios().getText();
                reg[15] = "";
                reg[16] = "0";
                break;
            case "Paros Planeados":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = String.valueOf(ParoRango.hInicio);//winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = "0";//winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = "59";//winPrincipal.getTxtTiempoFin().getText();
                reg[5] = "60";//winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//tema
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();//operacion
                reg[8] = winPrincipal.getCmbAreaPlaneados().getSelectedItem();//area
                reg[9] = "";//problema
                reg[10] = winPrincipal.getCmbClientePlaneados().getSelectedItem();// cliente
                reg[11] = winPrincipal.getCmbNoPartePlaneados().getSelectedItem();//parte
                reg[12] = 0;//cantidad
                reg[13] = "";//parte nuevo
                reg[14] = "0";//scrap
                reg[15] = "";//detalle material
                reg[16] = "0"; //tc
                break;
        }
        return reg;
    }
    
    private void insertarRegistroFilaAccess(Principal winPrincipal) {
            try {
              int columnas = winPrincipal.getTblBitacora().getColumnCount();
              ArrayList reg = new ArrayList();
              for (int j = 0; j < columnas; j++) {
                  Object ob = winPrincipal.getTblBitacora().getValueAt(contadorFila, j);
                  if ((j== 12 || j == 16) && (ob == null || ob.toString().isEmpty())) {
                      winPrincipal.getTblBitacora().setValueAt("0", contadorFila, j);
                      reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                  } else if (ob == null || ob.toString().isEmpty()) {
                      winPrincipal.getTblBitacora().setValueAt("", contadorFila, j);
                      reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                  } else {
                      reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                  }
                  //reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                  System.out.println(j + " . " + reg);
              }
              new BitacoraDAOImpl().insertarFilaRegistro(reg);
              contadorFila++;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(winPrincipal, "ParoRango.insertarRegistroFilaAccess()\n" + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    private void ordenarTabla(DefaultTableModel modeloTabla) {
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            registroBitacoraAux = new Object[16];
            for (int j = 0; j < registroBitacoraAux.length; j++) {
                registroBitacoraAux[j] = modeloTabla.getValueAt(i, j);
            }
            tablaObj.add(registroBitacoraAux);
            modeloTabla.removeRow(i);
        }
        Collections.sort(tablaObj, new OrdenaTablaTiempo());

        for (int i = 0; i < tablaObj.size(); i++) {
            modeloTabla.addRow((Object[]) tablaObj.get(i));
        }
        tablaObj.clear();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private static javax.swing.JComboBox cmbHFin;
    private static javax.swing.JComboBox cmbHInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
