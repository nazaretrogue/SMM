/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import sm.nrg.graficos.Linea2D;

/**
 *
 * @author nazaret
 */
public class Lienzo2D extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
        
        esta_relleno = false;
        color_figuras = Color.BLACK;
        es_transparente = false;
        v_shape = new ArrayList<>();
        trazo = new BasicStroke();
        herramienta = TipoHerramienta.PUNTOS;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        if(alisar)
            rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        else
            rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        
        if(es_transparente)
            comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, TRANSPARENCIA);
        
        else
            comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        
        g2d.setPaint(color_figuras);
        g2d.setStroke(trazo);
        g2d.setComposite(comp);
        
        for(Shape s:v_shape){
            if(esta_relleno)
                g2d.fill(s);
            
            else
                g2d.draw(s);
        }
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
    
    private Shape getSelectedShape(Point p){
        for(Shape s:v_shape){
            if(s.contains(p))
                return s;
        }
        
        return null;
    }
    
    private void moverFigura(Point p){
        if(fig_mover != null){
            
            switch (fig_mover.getClass().getSimpleName()) {
                case "Linea2D":
                    ((Linea2D)fig_mover).setLocation(p);
                    break;
                case "Rectangle":
                    ((Rectangle)fig_mover).setLocation(p);
                    break;
                case "Double":  // Lo detecta asi
                    RectangularShape elipse = (RectangularShape)fig_mover;
                    elipse.setFrameFromCenter(p.getX(), 
                                              p.getY(), 
                                              p.getX()+(elipse.getMaxX()-elipse.getCenterX()), 
                                              p.getY()+(elipse.getMaxY()-elipse.getCenterY()));
                    fig_mover = elipse;
                    break;
            }

        }
    }
    
    public void setTrazo(Stroke st){
        this.trazo = st;
        this.repaint();
    }
    
    public Stroke getTrazo(){
        return trazo;
    }
    
    public void setColor(Color c){
        this.color_figuras = c;
        this.repaint();
    }
    
    public Color getColor(){
        return color_figuras;
    }
    
    public void setTransparencia(boolean transp){
        this.es_transparente = transp;
        this.repaint();
    }
    
    public boolean getTransparencia(){
        return es_transparente;
    }
    
    public void setRelleno(boolean rell){
        this.esta_relleno = rell;
        this.repaint();
    }
    
    public boolean getRelleno(){
        return esta_relleno;
    }
    
    public void setHerramienta(TipoHerramienta herr){
        this.herramienta = herr;
        this.repaint();
    }
    
    public TipoHerramienta getHerramienta(){
        return herramienta;
    }
    
    public void setMover(boolean mov){
        this.mover = mov;
        this.repaint();
    }
    
    public boolean getMover(){
        return mover;
    }
    
    public void setAlisar(boolean alisar){
        this.alisar = alisar;
        this.repaint();
    }
    
    public boolean getAlisar(){
        return alisar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        
        if(mover)
            fig_mover = this.getSelectedShape(p_aux);
            
        else
            this.createShape(p_aux);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(mover)
            this.moverFigura(evt.getPoint());
        
        else
            this.updateShape(evt.getPoint());
            this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    Color color_figuras;
    static final float TRANSPARENCIA = 0.5f;
    boolean es_transparente;
    Composite comp;
    boolean esta_relleno;
    Stroke trazo;
    ArrayList<Shape> v_shape;
    TipoHerramienta herramienta;
    boolean mover;
    boolean alisar;
    RenderingHints rh;
    Point p_aux;
    Shape fig_mover;
}
