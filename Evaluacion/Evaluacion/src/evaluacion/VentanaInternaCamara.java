/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 *
 * @author nazaret
 */
public class VentanaInternaCamara extends VentanaInterna {

    /**
     * Creates new form VentanaInternaCamara
     */
    private VentanaInternaCamara() {
        initComponents();
        
        webcam = Webcam.getDefault();
        
        if(webcam != null){
            Dimension resoluciones[] = webcam.getViewSizes();
            Dimension max_resolucion = resoluciones[resoluciones.length-1];
            webcam.setViewSize(max_resolucion);
            
            WebcamPanel area_visual = new WebcamPanel(webcam);
            area_visual.setFitArea(false);
            getContentPane().add(area_visual, BorderLayout.CENTER);
            pack();
        }
    }
    
    public static VentanaInternaCamara getInstance(){
        VentanaInternaCamara vic = new VentanaInternaCamara();
        
        return (vic.webcam != null?vic:null);
    }
    
    public void close(){
        webcam.close();
    }
    
    public BufferedImage getImagen(){
        BufferedImage captura = webcam.getImage();
        
        return captura;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        close();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Webcam webcam = null;
}
