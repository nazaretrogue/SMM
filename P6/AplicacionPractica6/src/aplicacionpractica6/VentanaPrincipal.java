/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica6;

import java.awt.GraphicsEnvironment;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author nazaret
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        this.setSize(600, 600);
        
        GraphicsEnvironment ge;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String []fuentes_sistema = ge.getAvailableFontFamilyNames();
        lista_fuentes.setModel(new DefaultComboBoxModel(fuentes_sistema));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo1 = new aplicacionpractica6.Lienzo();
        jPanel1 = new javax.swing.JPanel();
        check_mover = new javax.swing.JCheckBox();
        lista_fuentes = new javax.swing.JComboBox<>();
        check_ventana = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo1, java.awt.BorderLayout.CENTER);

        check_mover.setText("Mover figura");
        check_mover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_moverActionPerformed(evt);
            }
        });
        jPanel1.add(check_mover);

        lista_fuentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lista_fuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_fuentesActionPerformed(evt);
            }
        });
        jPanel1.add(lista_fuentes);

        check_ventana.setText("Efecto ventana");
        check_ventana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_ventanaActionPerformed(evt);
            }
        });
        jPanel1.add(check_ventana);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check_moverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_moverActionPerformed
        lienzo1.setMover(check_mover.isSelected());
    }//GEN-LAST:event_check_moverActionPerformed

    private void lista_fuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_fuentesActionPerformed
        tipo_fuente = (String)lista_fuentes.getSelectedItem();
        
        lienzo1.setFuente(tipo_fuente);
    }//GEN-LAST:event_lista_fuentesActionPerformed

    private void check_ventanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_ventanaActionPerformed
        lienzo1.setClipActivo(check_ventana.isSelected());
    }//GEN-LAST:event_check_ventanaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_mover;
    private javax.swing.JCheckBox check_ventana;
    private javax.swing.JPanel jPanel1;
    private aplicacionpractica6.Lienzo lienzo1;
    private javax.swing.JComboBox<String> lista_fuentes;
    // End of variables declaration//GEN-END:variables
    private String tipo_fuente;
}