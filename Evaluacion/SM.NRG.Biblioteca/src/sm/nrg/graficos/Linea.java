/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
    public void setLocation(Point p) {
        Point2D origen = new Point2D.Double(p.getX()+linea.getX1(), p.getY()+linea.getY1());
        Point2D nuevo = new Point2D.Double(p.getX()+linea.getX2(), p.getY()+linea.getY2());
        linea.setLine(origen, nuevo);
    }
    
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)linea.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
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
    
    private Line2D linea;
}
