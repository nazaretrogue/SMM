/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

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
        return "Línea cuadrada";
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.draw(curva);
    }

    @Override
    public void setLocation(Point2D p) {
        double x = p.getX()-curva.getX1();
        double y = p.getY()-curva.getY1();
        
        Point2D nuevo = new Point2D.Double(curva.getX2()+x, curva.getY2()+y);
        Point2D nuevoctrl = new Point2D.Double(curva.getCtrlX()+x, curva.getCtrlY()+y);
        curva.setCurve(p, nuevoctrl, nuevo);
    }

    public QuadCurve2D getCurva() {
        return curva;
    }

    public void setCurva(QuadCurve2D curva) {
        this.curva = curva;
    }
    
    private QuadCurve2D curva;
}
