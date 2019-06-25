/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

/**
 * Representa una curva con un punto de control con todas sus propiedades.
 * @author nazaret
 */
public class CurvaCuadrada extends Figura {
    /**
     * Constructor con parámetros; crea una curva con un punto de control con las características deseadas.
     * @param t Trazo con el que crear la curva
     * @param alisado Indica si la curva se creará con o sin alisado
     * @param qc Curva a crear: contiene la geometría
     */
    public CurvaCuadrada(Trazo t, boolean alisado, QuadCurve2D qc){
        super(t, alisado);
        
        curva = new QuadCurve2D.Double(qc.getX1(), qc.getY1(), qc.getCtrlX(), qc.getCtrlY(), qc.getX2(), qc.getY2());
    }
    
    /**
     * Transforma la figura en un objeto String
     * @return String de la figura
     */
    @Override
    public String toString(){
        return "Curva cuadrática";
    }
    
    /**
     * Pinta la figura con sus propiedades.
     * @param g2d Objeto graphics2D para poder pintar
     */
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.draw(curva);
    }

    /**
     * Cambia la localización de la figura en el lienzo.
     * @param p Punto que indica el desplazamiento, puede ser negativo
     */
    @Override
    public void setLocation(Point p) {
        Point2D origen = new Point2D.Double(p.getX()+curva.getX1(), p.getY()+curva.getY1());
        Point2D fin = new Point2D.Double(p.getX()+curva.getX2(), p.getY()+curva.getY2());
        Point2D ctrl = new Point2D.Double(p.getX()+curva.getCtrlX(), p.getY()+curva.getCtrlY());
        curva.setCurve(origen, ctrl, fin);
    }
    
    /**
     * Crea un marco rojo alrededor de la figura para seleccionarla.
     * @return Rectángulo que enmarca la figura
     */
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)curva.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    /**
     * Devuelve la geometría (es decir, los puntos inicial, final y de control) de la curva.
     * @return Geometría de la curva
     */
    public QuadCurve2D getCurva() {
        return curva;
    }

    /**
     * Establece una nueva geometría para la curva.
     * @param curva Nueva curva que se va a establecer
     */
    public void setCurva(QuadCurve2D curva) {
        this.curva = curva;
    }
    
    /**
     * Geometría de la curva.
     */
    private QuadCurve2D curva;
}
