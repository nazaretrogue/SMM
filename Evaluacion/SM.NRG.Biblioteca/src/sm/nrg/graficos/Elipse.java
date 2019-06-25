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
import java.awt.geom.Rectangle2D;

/**
 * Representa una elipse con sus propiedades.
 * @author nazaret
 */
public class Elipse extends FiguraConArea {
    /**
     * Constructor con parámetros; crea una elipse con las características deseadas.
     * @param t Trazo con el que se creará
     * @param alisado Indica si se creará con el alisado activado o no
     * @param r Relleno con el que se creará la elipse
     * @param transp Grado de transparencia
     * @param el Geometría de la elipse
     */
    public Elipse(Trazo t, boolean alisado, Relleno r, float transp, Ellipse2D el){
        super(t, alisado, r, transp);
        
        elipse = el;
    }
    
    /**
     * Transforma la figura en un objeto String.
     * @return String que representa la figura
     */
    @Override
    public String toString(){
        return "Elipse";
    }
    
    /**
     * Dibuja la figura con las características que tiene.
     * @param g2d Objeto graphics2D para pintar
     */
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

    /**
     * Reestablece la localización de la elipse.
     * @param p Punto que indica el desplazamiento, puede ser negativo
     */
    @Override
    public void setLocation(Point p) {
        elipse.setFrameFromDiagonal(elipse.getX()+p.getX(), elipse.getY()+p.getY(), 
                                    elipse.getX()+p.getX()+elipse.getWidth(), elipse.getY()+p.getY()+elipse.getHeight());
    }
    
    /**
     * Selecciona la figura creando un marco rojo alrededor.
     * @return Rectangulo rojo que enmarca la figura
     */
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde = (Rectangle2D)elipse.getBounds();
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    /**
     * Devuelve la geometría de la elipse.
     * @return Geometría de la elipse.
     */
    public Ellipse2D getElipse() {
        return elipse;
    }

    /**
     * Establece una nueva geometría.
     * @param elipse Nueva geometría para la elipse
     */
    public void setElipse(Ellipse2D elipse) {
        this.elipse = elipse;
    }
    
    /**
     * Geometría de la elipse.
     */
    private Ellipse2D elipse;
}
