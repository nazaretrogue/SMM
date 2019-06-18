/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import sm.nrg.graficos.*;


/**
 *
 * @author nazaret
 */
public class Lienzo2D extends javax.swing.JPanel {

    public Lienzo2D(){
        initComponents();
        
        v_shape = new ArrayList<Figura>();
        herramienta = TipoHerramienta.RECTANGULOS;
        traz = new Trazo(Color.BLACK, 5.0f, TipoTrazo.CONTINUO);
        transp = 0.5f;
        relleno = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        alisado = false;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        for(Figura f: v_shape)
            f.paint(g2d);
    }
    
    private void createShape(Point p_i){
        switch(herramienta){
            case LINEAS:
                Line2D laux = new Line2D.Float(p_i, p_i);
                v_shape.add(new Linea(traz, alisado, laux)); //aux = new Line2D.Float(p_i, p_i);
                break;
            case RECTANGULOS:
                aux = new Rectangle(p_i);
                break;
            case ELIPSES:
                //v_shape.add(new Ellipse2D.Double(p_i.getX(), p_i.getY(), 1, 1));
                break;
            case RECTANGULOSRED:
                break;
            case CURVAS:
                break;
        }
    }
    
    private void updateShape(Point p_f){
        switch(herramienta){
            case LINEAS:
                Linea laux = (Linea)v_shape.get(v_shape.size()-1);
                laux.getLinea().setLine(laux.getLinea().getP1(), p_f);
                break;
            case RECTANGULOS:
                Rectangle2D raux = (Rectangle2D)(aux);
                raux.setFrameFromDiagonal(p_aux, p_f);

                v_shape.add(new Rectangulo(traz, alisado, relleno, transp, raux));
                this.repaint();
                break;
            /*case ELIPSES:
                Ellipse2D eaux = (Ellipse2D)(v_shape.get(v_shape.size()-1));
                eaux.setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, eaux);
                break;*/
        }
    }

    public TipoHerramienta getHerramienta() {
        return herramienta;
    }

    public Trazo getTraz() {
        return traz;
    }

    public float getTransp() {
        return transp;
    }

    public Relleno getRelleno() {
        return relleno;
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setHerramienta(TipoHerramienta herramienta) {
        this.herramienta = herramienta;
    }

    public void setTraz(Trazo traz) {
        this.traz = traz;
    }

    public void setTransp(float transp) {
        this.transp = transp;
    }

    public void setRelleno(Relleno relleno) {
        this.relleno = relleno;
    }

    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
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
        p_aux = evt.getPoint();
        
        createShape(p_aux);
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.updateShape(evt.getPoint());
        this.repaint();
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    ArrayList<Figura> v_shape;
    TipoHerramienta herramienta;
    Trazo traz;
    float transp;
    Relleno relleno;
    boolean alisado;
    Shape aux;
    Point p_aux;
}
