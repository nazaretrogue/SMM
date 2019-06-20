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
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author nazaret
 */
public class RectanguloRedondeado extends FiguraConArea {
    public RectanguloRedondeado(Trazo t, boolean alisado, Relleno r, float transp, RoundRectangle2D rec){
        super(t, alisado, r, transp);
        
        recred = rec;
    }
    
    @Override
    public String toString(){
        return "Rectángulo redondeado";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        if(super.getRelleno().getTipo() == TipoRelleno.SINRELLENO)
            g2d.draw(recred);
        
        else if(super.getRelleno().getTipo() == TipoRelleno.LISO)
            g2d.fill(recred);
        
        else{
            Point p1 = super.getRelleno().getP1(),
                  p2 = super.getRelleno().getP2();
            
            Color c1 = super.getRelleno().getColor1(),
                  c2 = super.getRelleno().getColor2();
            
            Paint fill = new GradientPaint(p1, c1, p2, c2);
            
            g2d.setPaint(fill);
            g2d.fill(recred);
        }
    }

    @Override
    public void setLocation(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RoundRectangle2D getRecred() {
        return recred;
    }

    public void setRecred(RoundRectangle2D recred) {
        this.recred = recred;
    }
    
    private RoundRectangle2D recred;
}
