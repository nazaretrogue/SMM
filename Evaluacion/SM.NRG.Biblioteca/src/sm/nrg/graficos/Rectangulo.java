/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author nazaret
 */
public class Rectangulo extends FiguraConArea {
    public Rectangulo(Trazo t, boolean alisado, Relleno r, float transp, Rectangle2D rec){
        super(t, alisado, r, transp);
        
        rectangulo = rec;
    }
    
    @Override
    public String toString(){
        return "Rectángulo";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        if(super.getRelleno().getTipo() == TipoRelleno.SINRELLENO)
            g2d.draw(rectangulo);
        
        else if(super.getRelleno().getTipo() == TipoRelleno.LISO){
            Paint liso = super.getRelleno().getColor1();
            
            g2d.setPaint(liso);
            g2d.fill(rectangulo);
        }
        
        else{
            Point p1 = super.getRelleno().getP1(),
                  p2 = super.getRelleno().getP2();
            
            Color c1 = super.getRelleno().getColor1(),
                  c2 = super.getRelleno().getColor2();
            
            Paint fill = new GradientPaint(p1, c1, p2, c2);
            
            g2d.setPaint(fill);
            g2d.fill(rectangulo);
        }
    }

    @Override
    public void setLocation(Point p) {
        rectangulo.setFrameFromDiagonal(rectangulo.getX()+p.getX(), rectangulo.getY()+p.getY(), 
                                        rectangulo.getX()+p.getX()+rectangulo.getWidth(), rectangulo.getY()+p.getY()+rectangulo.getHeight());
    }
    
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde_aux = (Rectangle2D)rectangulo.getBounds();
        Rectangle2D borde = new Rectangle2D.Double(borde_aux.getX()-10.0, borde_aux.getY()-10.0, borde_aux.getWidth()+20.0, borde_aux.getHeight()+20.0);
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    public Rectangle2D getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangle2D rectangulo) {
        this.rectangulo = rectangulo;
    }
    
    private Rectangle2D rectangulo;
}
