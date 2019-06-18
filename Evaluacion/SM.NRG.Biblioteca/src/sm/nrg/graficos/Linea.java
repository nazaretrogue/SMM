/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author nazaret
 */
public class Linea extends Figura {
    public Linea(Trazo t, boolean alisado, Line2D l){
        super(t, alisado);
        
        linea = new Line2D.Float(l.getP1(), l.getP2());
    }
    
    @Override
    public String toString(){
        return "Línea";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.draw(linea);
    }

    @Override
    public void setLocation(Point2D p) {
        double x = p.getX()-linea.getX1();
        double y = p.getY()-linea.getY1();
        
        Point2D nuevo = new Point2D.Double(linea.getX2()+x, linea.getY2()+y);
        linea.setLine(p, nuevo);
    }
    
    public boolean isNear(Point2D p){
        return linea.ptSegDist(p)<=5.0;
    }
    
    public boolean contains(Point2D p){
        return isNear(p);
    }

    public Line2D getLinea() {
        return linea;
    }

    public void setLinea(Line2D linea) {
        this.linea = linea;
    }
    
    Line2D linea;
}
