/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.geom.Point2D;

/**
 *
 * @author nazaret
 */
public class Linea2D extends java.awt.geom.Line2D.Double{
    public boolean isNear(Point2D p){
        return this.ptLineDist(p)<=2.0;
    }
    
    @Override
    public boolean contains(Point2D p){
        return isNear(p);
    }
    
    public void setLocation(Point2D p){
        double x = p.getX() - this.getX1();
        double y = p.getY() - this.getY1();
        
        Point2D nuevo = new Point2D.Double(x, y);
        this.setLine(p, nuevo);
    }
}
