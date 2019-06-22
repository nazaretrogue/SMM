/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author nazaret
 */
public class Elipse extends FiguraConArea {
    public Elipse(Trazo t, boolean alisado, Relleno r, float transp, Ellipse2D el){
        super(t, alisado, r, transp);
        
        elipse = el;
    }
    
    @Override
    public String toString(){
        return "Elipse";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        if(super.getRelleno().getTipo() == TipoRelleno.SINRELLENO)
            g2d.draw(elipse);
        
        else if(super.getRelleno().getTipo() == TipoRelleno.LISO)
            g2d.fill(elipse);
        
        else{
            Point p1 = super.getRelleno().getP1(),
                  p2 = super.getRelleno().getP2();
            
            Color c1 = super.getRelleno().getColor1(),
                  c2 = super.getRelleno().getColor2();
            
            Paint fill = new GradientPaint(p1, c1, p2, c2);
            
            g2d.setPaint(fill);
            g2d.fill(elipse);
        }
    }

    @Override
    public void setLocation(Point p) {
        elipse.setFrameFromDiagonal(elipse.getX()+p.getX(), elipse.getY()+p.getY(), 
                                    elipse.getX()+p.getX()+elipse.getWidth(), elipse.getY()+p.getY()+elipse.getHeight());
    }
    
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)elipse.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    public Ellipse2D getElipse() {
        return elipse;
    }

    public void setElipse(Ellipse2D elipse) {
        this.elipse = elipse;
    }
    
    private Ellipse2D elipse;
}
