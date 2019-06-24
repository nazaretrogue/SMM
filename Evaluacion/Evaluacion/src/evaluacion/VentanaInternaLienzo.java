/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import sm.nrg.graficos.TipoHerramienta;
import sm.nrg.graficos.TipoTrazo;

/**
 *
 * @author nazaret
 */
public class VentanaInternaLienzo extends VentanaInterna {

    /**
     * Creates new form VentanaInterna
     */
    public VentanaInternaLienzo() {
        initComponents();
        
        this.setSize(300, 300);
    }
    
    public sm.nrg.iu.Lienzo2D getLienzo(){
        return lienzo2D;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_desplazamiento = new javax.swing.JScrollPane();
        lienzo2D = new sm.nrg.iu.LienzoImagen2D();

        FormListener formListener = new FormListener();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(formListener);

        javax.swing.GroupLayout lienzo2DLayout = new javax.swing.GroupLayout(lienzo2D);
        lienzo2D.setLayout(lienzo2DLayout);
        lienzo2DLayout.setHorizontalGroup(
            lienzo2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        lienzo2DLayout.setVerticalGroup(
            lienzo2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        panel_desplazamiento.setViewportView(lienzo2D);

        getContentPane().add(panel_desplazamiento, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements javax.swing.event.InternalFrameListener {
        FormListener() {}
        public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            if (evt.getSource() == VentanaInternaLienzo.this) {
                VentanaInternaLienzo.this.formInternalFrameActivated(evt);
            }
        }

        public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        ((VentanaPrincipal)this.getParent().getParent().getParent().getParent().getParent().getParent()).setBotonesLienzo();
    }//GEN-LAST:event_formInternalFrameActivated

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.nrg.iu.LienzoImagen2D lienzo2D;
    private javax.swing.JScrollPane panel_desplazamiento;
    // End of variables declaration//GEN-END:variables
}
