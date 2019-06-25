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
import java.awt.geom.Rectangle2D;

/**
 * Representa un rectángulo con todas sus propiedades.
 * @author nazaret
 */
public class Rectangulo extends FiguraConArea {
    /**
     * Constructor con parámetros; crea un rectángulo con las propiedades deseadas.
     * @param t Trazo con el que crear el rectángulo
     * @param alisado Indica si el alisado está activo o no
     * @param r Relleno del rectángulo
     * @param transp Grado de transparencia del rectángulo
     * @param rec Geometría del rectángulo
     */
    public Rectangulo(Trazo t, boolean alisado, Relleno r, float transp, Rectangle2D rec){
        super(t, alisado, r, transp);
        
        rectangulo = rec;
    }
    
    /**
     * Transforma la figura en un objeto String.
     * @return String de la figura
     */
    @Override
    public String toString(){
        return "Rectángulo";
    }
    
    /**
     * Pinta la figura con las propiedades establecidas.
     * @param g2d Objeto graphics2D para pintar
     */
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        if(super.getRelleno().getTipo() == TipoRelleno.SINRELLENO)
            g2d.draw(rectangulo);
        
        else if(super.getRelleno().getTipo() == TipoRelleno.LISO){
            Paint liso = super.getRelleno().getColor1();
            
            g2d.setPaint(liso);
            g2d.fill(rectangulo);
        }
        
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

    /**
     * Establece la nueva localización para la figura.
     * @param p Punto que indica el desplazamiento, puede ser negativo 
     */
    @Override
    public void setLocation(Point p) {
        rectangulo.setFrameFromDiagonal(rectangulo.getX()+p.getX(), rectangulo.getY()+p.getY(), 
                                        rectangulo.getX()+p.getX()+rectangulo.getWidth(), rectangulo.getY()+p.getY()+rectangulo.getHeight());
    }
    
    /**
     * Enmarca la figura de rojo para seleccionarla.
     * @return Rectángulo que enmarca la figura
     */
    @Override
    public Rectangulo seleccionarFigura(){
        Rectangle2D borde_aux = (Rectangle2D)rectangulo.getBounds();
        Rectangle2D borde = new Rectangle2D.Double(borde_aux.getX()-10.0, borde_aux.getY()-10.0, borde_aux.getWidth()+20.0, borde_aux.getHeight()+20.0);
        Trazo t = new Trazo(Color.RED, 2, TipoTrazo.DISCONTINUO);
        Relleno r = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        
        return new Rectangulo(t, true, r, 1.0f, borde);
    }

    /**
     * Devuelve la geometría del rectángulo (punto de inicio, alto y ancho).
     * @return Geomtría del rectángulo 
     */
    public Rectangle2D getRectangulo() {
        return rectangulo;
    }

    /**
     * Establece una nueva geometría para el rectángulo.
     * @param rectangulo Nueva geometría a establecer
     */
    public void setRectangulo(Rectangle2D rectangulo) {
        this.rectangulo = rectangulo;
    }
    
    /**
     * Geometría del rectángulo.
     */
    private Rectangle2D rectangulo;
}
