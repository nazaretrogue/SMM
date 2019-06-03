/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

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
        
        if(super.getRelleno().tipo == TipoRelleno.SINRELLENO)
            g2d.draw(rectangulo);
        
        else if(super.getRelleno().tipo == TipoRelleno.LISO)
            g2d.fill(rectangulo);
        
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
    public Point2D setLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Rectangle2D rectangulo;
}
