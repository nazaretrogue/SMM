/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nazaret
 */
public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        
        mover = false;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d=(Graphics2D)g;
        
        //pruebaShape(g2d);
        this.setAtributos(g2d);
        
        for(Shape s:v_shape)
            g2d.draw(s);
    }

    public void setMover(boolean mov) {
        mover = mov;
    }

    public boolean isMover() {
        return mover;
    }
    
    public void pruebaShape(Graphics2D g2d){
        Point2D pa=new Point2D.Float(70,70);
        Point2D pb=new Point2D.Float(200,200);
        
        // Línea
        Line2D linea = new Line2D.Double(pa.getX(), pa.getY(), 20, 40);
        g2d.draw(linea);
        
        // Rectángulo
        Rectangle2D rec = new Rectangle2D.Double(pa.getX(), pb.getY(), 20, 56);
        g2d.draw(rec);
        
        // Rectángulo redondeado
        RoundRectangle2D rr = new RoundRectangle2D.Double(pb.getX(), pa.getY(),77, 100, 30, 60);
        g2d.draw(rr);
        
        // Elipse
        Ellipse2D el = new Ellipse2D.Double(pa.getX(), pa.getX(), 20, 50);
        g2d.draw(el);
        
        // Arco
        Arc2D ar = new Arc2D.Double(pb.getY(), pb.getY(), 50, 32, 180, 270, Arc2D.PIE);
        g2d.draw(ar);
        
        // Curva cuadrada
        Point2D pc = new Point2D.Double(70, 70);
        QuadCurve2D qc = new QuadCurve2D.Double(100, pa.getY(), pc.getX(), pc.getY(), pb.getX(), pb.getX());
        g2d.draw(qc);
        
        // Curva cúbica
        Point2D pc2 = new Point2D.Double(200, 200);
        CubicCurve2D cc = new CubicCurve2D.Double(250, 300, 300, 35, 400, 400, 500, 46);
        g2d.draw(cc);
        
        // Trazo libre
        Path2D path = new Path2D.Double(Path2D.WIND_EVEN_ODD, 6);
        path.moveTo(1.0, 1.0);
        path.lineTo(15.0, 10.0);
        path.lineTo(2.0, 8.0);
        path.lineTo(16.5, 20.0);
        path.curveTo(4.5, 23.0, 23.5, 30.5, 16.5, 20.0);
        
        g2d.draw(path);
        
        // Área pera
        Ellipse2D little_one = new Ellipse2D.Double(200, 310, 100, 100);
        Ellipse2D big_one = new Ellipse2D.Double(175, 390, 150, 150);
        Area parte1 = new Area(little_one);
        Area parte2 = new Area(big_one);
        parte1.add(parte2);
        g2d.draw(parte1);
    }
    
    public void actualizar(){
        //l.setLine(p1, p2);
    }
    
    private Shape getSelected(Point2D p){
        for(Shape s:v_shape)
            if(s.contains(p))
                return s;
        
        return null;
    }
    
    private void setAtributos(Graphics2D g2d){
        // Trazo
        float disc[] = {10.0f, 10.0f, 2.0f};
        Stroke trazo = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1.5f, disc, 0.0f);
        g2d.setStroke(trazo);
        
        g2d.draw(new Rectangle2D.Double(10, 20, 40, 56));
        g2d.setStroke(new BasicStroke());
        
        // Relleno
        Paint color_borde = new Color(255, 0, 255);
        g2d.setPaint(color_borde);
        
        g2d.draw(new Rectangle2D.Double(70, 40, 40, 56));
        g2d.fill(new Rectangle2D.Double(70, 40, 40, 56));
        
        Paint relleno = new GradientPaint(70, 70, Color.WHITE, 70, 90, Color.RED);
        g2d.setPaint(relleno);
        
        g2d.fill(new Rectangle2D.Double(80, 50, 20, 36));
        
        // Composición
        Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(comp);
        
        g2d.fill(new Rectangle2D.Double(40, 20, 80, 90));
        
        // Transformación
        AffineTransform at = new AffineTransform();
        Rectangle2D rec = new Rectangle.Double(150, 150, 150, 150);
        g2d.draw(rec);
        
        at.setToIdentity();
        at.rotate(Math.toRadians(45.0), rec.getCenterX(), rec.getCenterY());
        at.translate(rec.getCenterX(), rec.getCenterY());
        at.scale(0.25, 0.25);
        at.translate(-rec.getCenterX(), -rec.getCenterY());
        g2d.setTransform(at);
        g2d.fill(rec);
        
        at.setToIdentity();
        g2d.setTransform(at);
        
        // Fuente
        Font f = new Font("Arial", Font.BOLD|Font.ITALIC, 45);
        g2d.setFont(f);
        
        g2d.drawString("agua", 20, 400);
        
        Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        f = f.deriveFont(map);
        g2d.setFont(f);
        
        g2d.drawString("mundo", 20, 450);
        
        // Renderización
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);
        
        g2d.drawString("mundo", 200, 450);
        
        // Recorte
        Ellipse2D izda = new Ellipse2D.Double(200, 200, 100, 100);
        Ellipse2D dcha = new Ellipse2D.Double(320, 200, 100, 100);
        Area p_izda = new Area(izda);
        Area p_dcha = new Area(dcha);
        p_izda.add(p_dcha);
        
        g2d.draw(p_izda);
        g2d.clip(p_izda);
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

        addMouseMotionListener(formListener);
        addMouseListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
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
            if (evt.getSource() == Lienzo.this) {
                Lienzo.this.formMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo.this) {
                Lienzo.this.formMouseReleased(evt);
            }
        }

        public void mouseDragged(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo.this) {
                Lienzo.this.formMouseDragged(evt);
            }
        }

        public void mouseMoved(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo.this) {
                Lienzo.this.formMouseMoved(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p_aux = evt.getPoint(); // aquí se crean los objs, en el dragged y released se modifican
        
        if(!mover){
            System.out.println(mover);
            r = new Rectangle(p_aux);
            v_shape.add(r);
        }else
            r = (Rectangle)getSelected(evt.getPoint());
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(mover){
            if(r != null)
                r.setLocation(evt.getPoint());
        }
        
        else
            r.setFrameFromDiagonal(p_aux, evt.getPoint());
        
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    Rectangle r;
    Point p_aux;
    List<Shape> v_shape = new ArrayList();
    boolean mover;
}