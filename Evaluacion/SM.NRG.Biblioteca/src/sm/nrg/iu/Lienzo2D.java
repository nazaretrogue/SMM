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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import sm.nrg.eventos.LienzoEvent;
import sm.nrg.eventos.LienzoListener;
import sm.nrg.graficos.*;


/**
 *
 * @author nazaret
 */
public class Lienzo2D extends javax.swing.JPanel {

    public Lienzo2D(){
        initComponents();
        
        v_shape = new ArrayList();
        herramienta = TipoHerramienta.LINEAS;
        traz = new Trazo(Color.BLACK, 1, TipoTrazo.CONTINUO);
        transp = 1.0f;
        relleno = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        alisado = false;
        lienzo_event_listeners = new ArrayList();
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
                v_shape.add(new Linea(traz, alisado, laux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case RECTANGULOS:
                p_aux = p_i;
                Rectangle2D raux = new Rectangle2D.Double(p_i.getX(), p_i.getY(), 1, 1);
                v_shape.add(new Rectangulo(traz, alisado, relleno, transp, raux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case ELIPSES:
                p_aux = p_i;
                Ellipse2D eaux = new Ellipse2D.Double(p_i.getX(), p_i.getY(), 1, 1);
                v_shape.add(new Elipse(traz, alisado, relleno, transp, eaux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case RECTANGULOSRED:
                p_aux = p_i;
                RoundRectangle2D rraux = new RoundRectangle2D.Double(p_i.getX(), p_i.getY(), 1, 1, 25, 25);
                v_shape.add(new RectanguloRedondeado(traz, alisado, relleno, transp, rraux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case CURVAS:
                if(!curva_cuad){
                    QuadCurve2D caux = new QuadCurve2D.Double(p_i.getX(), p_i.getY(), p_i.getX(), p_i.getX(), p_i.getX(), p_i.getX());
                    v_shape.add(new CurvaCuadrada(traz, alisado, caux));
                    notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                }
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
                Rectangulo raux = (Rectangulo)(v_shape.get(v_shape.size()-1));
                raux.getRectangulo().setFrameFromDiagonal(p_aux, p_f);

                v_shape.set(v_shape.size()-1, raux);
                break;
            case ELIPSES:
                Elipse eaux = (Elipse)(v_shape.get(v_shape.size()-1));
                eaux.getElipse().setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, eaux);
                break;
            case RECTANGULOSRED:
                RectanguloRedondeado rraux = (RectanguloRedondeado)(v_shape.get(v_shape.size()-1));
                rraux.getRecred().setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, rraux);
                break;
            case CURVAS:
                CurvaCuadrada caux = (CurvaCuadrada)v_shape.get(v_shape.size()-1);
                if(!curva_cuad || !punto){
                    caux.getCurva().setCurve(caux.getCurva().getP1(), p_f, p_f);
                    curva_cuad = true;
                }
                else{
                    double ctrlx = Math.abs(caux.getCurva().getP2().getX() - caux.getCurva().getP1().getX());
                    double ctrly = Math.abs(caux.getCurva().getP2().getY() - caux.getCurva().getP1().getY());
                    
                    Point2D central = new Point2D.Double(ctrlx/2+p_f.getX(), ctrly/2+p_f.getY());
                    
                    caux.getCurva().setCurve(caux.getCurva().getP1(), central, caux.getCurva().getP2());
                }
                
                v_shape.set(v_shape.size()-1, caux);
                break;
        }
    }
    
    public void seleccionarFigura(Figura f){
        v_shape.add(f.seleccionarFigura());
        repaint();
    }
    
    public void deseleccionarFigura(){
        v_shape.remove(v_shape.size()-1);
        repaint();
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
    
    public void addLienzoListener(LienzoListener listener){
        if(listener != null)
            lienzo_event_listeners.add(listener);
    }
    
    private void notifyFiguraAddedEvent(LienzoEvent evt){
        if(!lienzo_event_listeners.isEmpty()){
            for(LienzoListener listener: lienzo_event_listeners)
                listener.figuraAdded(evt);
        }
    }
    
    private void notifyPropiedadCambiadaEvent(LienzoEvent evt){
       /* if(!lienzo_event_listeners.isEmpty()){
            for(LienzoListener listener: lienzo_event_listeners)
                listener.propiedadCambiada(evt);
        }*/
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
        if(!curva_cuad){
            p_aux = evt.getPoint();
            createShape(p_aux);
        }
        
        else
            updateShape(evt.getPoint());
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
        
        if(curva_cuad && !punto)
            punto = true;
        
        else{
            curva_cuad = false;
            punto = false;
        }
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
    boolean curva_cuad = false, punto = false;
    ArrayList<LienzoListener> lienzo_event_listeners;
}
