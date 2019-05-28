/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import java.awt.BorderLayout;
import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author nazaret
 */
public class VentanaInternaVLCPlayer extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInterna
     */
    private VentanaInternaVLCPlayer(File f) {
        initComponents();
        
        archivo = f;
        EmbeddedMediaPlayerComponent area_visual = new EmbeddedMediaPlayerComponent();
        getContentPane().add(area_visual, BorderLayout.CENTER);
        
        video = area_visual.getMediaPlayer();
        
        this.setSize(720, 512);
    }
    
    public static VentanaInternaVLCPlayer getInstance(File f){
        VentanaInternaVLCPlayer vivcl = new VentanaInternaVLCPlayer(f);
        
        return (vivcl != null?vivcl:null);
    }
    
    public void play(){
        if(video != null){
            if(video.isPlayable())
                video.play();
            
            else
                video.playMedia(archivo.getAbsolutePath());
        }
    }
    
    public void stop(){
        if(video != null){
            if(video.isPlaying())
                video.pause();
            
            else
                video.stop();
        }
    }
    
    public void AddMediaPlayerEventListener(MediaPlayerEventListener m){
        if(video != null)
            video.addMediaPlayerEventListener(m);
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
        stop();
        video = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private EmbeddedMediaPlayer video = null;
    private File archivo;
}
