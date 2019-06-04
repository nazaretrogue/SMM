/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import sm.nrg.graficos.Figura;



/**
 *
 * @author nazaret
 */
public class Lienzo2D extends javax.swing.JPanel {

    public Lienzo2D(){
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        for(Figura f: vector_fig)
            f.paint(g2d);
    }
    
    private void createShape(Point p_i){
        switch(herramienta){
            case PUNTOS:
                v_shape.add(new Linea2D(p_i, p_i));
                break;
            case LINEAS:
                v_shape.add(new Linea2D(p_i, p_i));
                break;
            case RECTANGULOS:
                v_shape.add(new Rectangle(p_i));
                break;
            case ELIPSES:
                v_shape.add(new Ellipse2D.Double(p_i.getX(), p_i.getY(), 1, 1));
                break;
        }
    }
    
    private void updateShape(Point p_f){
        switch(herramienta){
            case LINEAS:
                Linea2D laux = (Linea2D)v_shape.get(v_shape.size()-1);
                laux.setLine(laux.getP1(), p_f);
                
                v_shape.set(v_shape.size()-1, laux);
                break;
            case RECTANGULOS:
                Rectangle raux = (Rectangle)(v_shape.get(v_shape.size()-1));
                raux.setFrameFromDiagonal(p_aux, p_f);

                v_shape.set(v_shape.size()-1, raux);
                break;
            case ELIPSES:
                Ellipse2D eaux = (Ellipse2D)(v_shape.get(v_shape.size()-1));
                eaux.setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, eaux);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseMotionListener(formListener);
        addMouseListener(formListener);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener {
        FormListener() {}
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMouseReleased(evt);
            }
        }

        public void mouseDragged(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMouseDragged(evt);
            }
        }

        public void mouseMoved(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    ArrayList<Figura> vector_fig;
}
