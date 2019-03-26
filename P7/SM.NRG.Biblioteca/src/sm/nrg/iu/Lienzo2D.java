/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

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
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setPaint(color_figuras);
        g2d.setStroke(trazo);
        
        for(Shape s:v_shape){
            if(esta_relleno)
                g2d.fill(s);
            
            else
                g2d.draw(s);
        }
    }
    
    private void createShape(Point2D p_i, Point2D p_f){
        switch(herramienta){
            case PUNTOS:
                v_shape.add(new Ellipse2D.Double(p_i.getX(), p_i.getY(), 10, 10));
                break;
            case LINEAS:
                break;
            case RECTANGULOS:
                break;
            case ELIPSES:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    Color color_figuras;
    static final float TRANSPARENCIA = 0.5f;
    boolean es_transparente;
    boolean esta_relleno;
    Stroke trazo;
    ArrayList<Shape> v_shape;
    TipoHerramienta herramienta;
}
