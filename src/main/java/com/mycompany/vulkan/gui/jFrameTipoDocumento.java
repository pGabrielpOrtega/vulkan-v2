/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vulkan.gui;

import com.mycompany.vulkan.validacion.valNumero;
import com.mycompany.vulkan.validacion.valString;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import vulkan.declaracion.decTipoDeDocumento;
import com.mycompany.controlador.controlTipoDeDocumento;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author fer3dev
 */
public class jFrameTipoDocumento extends javax.swing.JFrame {

    decTipoDeDocumento doc = new decTipoDeDocumento();
    controlTipoDeDocumento docDao = new controlTipoDeDocumento();
    valString valS = new valString();
    valNumero valN = new valNumero();
    //
    private int estado;

    public jFrameTipoDocumento() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo1.png"));
        setIconImage(icon.getImage());
        setTitle("VK Restaurant");
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
        this.llenadoTabla();
    }

    private void llenadoTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        tbl_registros.setModel(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");

        List<decTipoDeDocumento> puesto = docDao.findclientesEntities();

        for (decTipoDeDocumento cliente : puesto) {
            if (cliente.getDesactivado() == 0) {
                modelo.addRow(
                        new Object[]{
                            cliente.getId(),
                            cliente.getNombre(),
                            cliente.getDescripcion(),}
                );
            }
        }

    }

    private void limpiar() {
        btn_modificar.setEnabled(false);
        btn_desactivar.setEnabled(false);
        btn_agregar.setEnabled(true);
        txt_id_area.setText("");
        txt_nombre.setText("");
        txt_descripcion.setText("");
    }

    private void desactivar() {
        int fila = tbl_registros.getSelectedRow();

        if (estado <= 0) {
            doc.setId(Integer.parseInt(txt_id_area.getText()));
            doc.setNombre(tbl_registros.getValueAt(fila, 1).toString());
            doc.setDescripcion(tbl_registros.getValueAt(fila, 2).toString());
            doc.setDesactivado(1);
            this.setEstado(1);

            try {
                docDao.edit(doc);
                limpiar();
                llenadoTabla();
                JOptionPane.showMessageDialog(this, "Se desactivó correctamente.");
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            doc.setId(Integer.parseInt(txt_id_area.getText()));
            doc.setNombre(tbl_registros.getValueAt(fila, 1).toString());
            doc.setDescripcion(tbl_registros.getValueAt(fila, 2).toString());
            doc.setDesactivado(0);
            this.setEstado(0);

            try {
                docDao.edit(doc);
                limpiar();
                llenadoTabla();
                JOptionPane.showMessageDialog(this, "Se desactivó correctamente.");
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_puestos_trabajo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_area = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_registros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_desactivar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(244, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 50));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_puestos_trabajo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_puestos_trabajo.setText("Tipo de Documento");
        jPanel4.add(lbl_puestos_trabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel5.setText("Nombre");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setText("Descripción");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txt_id_area.setEditable(false);
        txt_id_area.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.add(txt_id_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 90, -1));
        jPanel6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 220, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar50.png"))); // NOI18N
        btn_limpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, 50));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar50.png"))); // NOI18N
        btn_buscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 450, 220));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tbl_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_registros.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_registros.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tbl_registros.setSelectionForeground(new java.awt.Color(204, 204, 255));
        tbl_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_registrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_registros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1280, 310));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar1.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 204));
        btn_agregar.setForeground(new java.awt.Color(0, 0, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir1.png"))); // NOI18N
        btn_agregar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 204));
        btn_modificar.setForeground(new java.awt.Color(0, 0, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar1.png"))); // NOI18N
        btn_modificar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, -1));

        btn_desactivar.setBackground(new java.awt.Color(204, 204, 204));
        btn_desactivar.setForeground(new java.awt.Color(0, 0, 255));
        btn_desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desactivar1.png"))); // NOI18N
        btn_desactivar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, -1));

        btn_regresar.setBackground(new java.awt.Color(204, 204, 204));
        btn_regresar.setForeground(new java.awt.Color(255, 0, 51));
        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar1.png"))); // NOI18N
        btn_regresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        btn_regresar.setPreferredSize(new java.awt.Dimension(150, 50));
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BackgroundRes.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -250, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.llenadoTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre puesto tiene menos de 3 letras");

            JOptionPane.showMessageDialog(this, "Error numero menor a uno");
        } else if (valString.ochoKey(txt_descripcion.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en descripcion tiene menos de 8 caracteres");
        } else {
            JOptionPane.showMessageDialog(this, "Registrado");
            doc.setNombre(txt_nombre.getText());
            doc.setDescripcion(txt_descripcion.getText());
            doc.setId_documento("0");
            try {
                docDao.guardar(doc);
                limpiar();
                llenadoTabla();
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        if (valString.tresKey(txt_nombre.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error nombre puesto tiene menos de 3 letras");

            JOptionPane.showMessageDialog(this, "Error numero menor a uno");
        } else if (valString.ochoKey(txt_descripcion.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Error en descripcion tiene menos de 8 caracteres");
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de documento editado correctamente");
            doc.setId_tipo_documento(parseInt(txt_id_area.getText()));
            doc.setNombre(txt_nombre.getText());
            doc.setDescripcion(txt_descripcion.getText());
            try {
                docDao.edit(doc);
                limpiar();
                llenadoTabla();
            } catch (Exception ex) {
                Logger.getLogger(jFramePuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        mainMenu menu = new mainMenu();
        this.dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
        // TODO add your handling code here:
        this.desactivar();
    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked
        // TODO add your handling code here:
        int fila = tbl_registros.getSelectedRow();
        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");

        } else {
            btn_agregar.setEnabled(false);
            btn_modificar.setEnabled(true);
            btn_desactivar.setEnabled(true);
            String Id = tbl_registros.getValueAt(fila, 0).toString();
            String Nombre = tbl_registros.getValueAt(fila, 1).toString();
            String Descripcion = tbl_registros.getValueAt(fila, 2).toString();
            //String Activo = tbl_registros.getValueAt(fila, 3).toString();
            txt_id_area.setText(Id);
            txt_nombre.setText(Nombre);
            txt_descripcion.setText(Descripcion);
            //Txt_Activo.setText(Activo);
        }
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String input = JOptionPane.showInputDialog("Ingrese el ID de el Tipo de documento a buscar");
        System.out.println(input);
        try {
            parseInt(input);
            decTipoDeDocumento tipoDocumentoBuscar = docDao.findclientes(parseInt(input));
            if (tipoDocumentoBuscar == null) {
                JOptionPane.showMessageDialog(this, "Tipo de documento no encontrado");
            } else if (tipoDocumentoBuscar.getDesactivado() == 1) {
                JOptionPane.showMessageDialog(this, "Tipo de documento está actualmente desactivado");
            } else {
                String idn = String.valueOf(tipoDocumentoBuscar.getId_tipo_documento());
                txt_id_area.setText(idn);
                txt_nombre.setText(tipoDocumentoBuscar.getNombre());
                txt_descripcion.setText(tipoDocumentoBuscar.getDescripcion());
                btn_agregar.setEnabled(false);
                btn_modificar.setEnabled(true);
                btn_desactivar.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(jFramePuesto.class
                    .getName()).log(Level.SEVERE, null, ex);
            if (input != null) {
                JOptionPane.showMessageDialog(this, "El ID solo puede contener números");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameTipoDocumento().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_puestos_trabajo;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_id_area;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}