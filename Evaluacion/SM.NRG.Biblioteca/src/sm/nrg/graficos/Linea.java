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
 * Representa una línea con todas sus propiedades.
 * @author nazaret
 */
public class Linea extends Figura {
    /**
     * Constructor con parámetros; crea una línea con las características deseadas.
     * @param t Trazo con el que crear la línea
     * @param alisado Indica si el alisado está activo o no
     * @param l Geometría de la línea
     */
    public Linea(Trazo t, boolean alisado, Line2D l){
        super(t, alisado);
        
        linea = new Line2D.Float(l.getP1(), l.getP2());
    }
    
    /**
     * Transforma la figura en un objeto String.
     * @return String de la figura
     */
    @Override
    public String toString(){
        return "Línea";
    }
    
    /**
     * Pinta la figura con sus propiedades.
     * @param g2d Objeto graphics2D para pintar
     */
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.draw(linea);
    }

    /**
     * Establece una nueva localización para la figura.
     * @param p Desplazamiento de la figura, puede ser negativo
     */
    @Override
    public void setLocation(Point p) {
        Point2D origen = new Point2D.Double(p.getX()+linea.getX1(), p.getY()+linea.getY1());
        Point2D nuevo = new Point2D.Double(p.getX()+linea.getX2(), p.getY()+linea.getY2());
        linea.setLine(origen, nuevo);
    }
    
    /**
     * Crea un marco rojo alrededor de la figura seleccionada.
     * @return Rectángulo que enmarca la figura
     */
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)linea.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    /**
     * Devuelve la geometría de la línea (puntos inicial y final).
     * @return Geometría de la línea
     */
    public Line2D getLinea() {
        return linea;
    }

    /**
     * Establece una nueva geometría para la línea.
     * @param linea Nueva geometría a establecer
     */
    public void setLinea(Line2D linea) {
        this.linea = linea;
    }
    
    /**
     * Geometría de la línea.
     */
    private Line2D linea;
}
