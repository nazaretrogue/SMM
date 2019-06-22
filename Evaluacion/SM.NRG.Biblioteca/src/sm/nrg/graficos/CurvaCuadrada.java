/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author nazaret
 */
public class CurvaCuadrada extends Figura {
    public CurvaCuadrada(Trazo t, boolean alisado, QuadCurve2D qc){
        super(t, alisado);
        
        curva = new QuadCurve2D.Double(qc.getX1(), qc.getY1(), qc.getCtrlX(), qc.getCtrlY(), qc.getX2(), qc.getY2());
    }
    
    @Override
    public String toString(){
        return "Curva cuadrática";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.draw(curva);
    }

    @Override
    public void setLocation(Point p) {
        Point2D origen = new Point2D.Double(p.getX()+curva.getX1(), p.getY()+curva.getY1());
        Point2D fin = new Point2D.Double(p.getX()+curva.getX2(), p.getY()+curva.getY2());
        Point2D ctrl = new Point2D.Double(p.getX()+curva.getCtrlX(), p.getY()+curva.getCtrlY());
        curva.setCurve(origen, ctrl, fin);
    }
    
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)curva.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    public QuadCurve2D getCurva() {
        return curva;
    }

    public void setCurva(QuadCurve2D curva) {
        this.curva = curva;
    }
    
    private QuadCurve2D curva;
}
