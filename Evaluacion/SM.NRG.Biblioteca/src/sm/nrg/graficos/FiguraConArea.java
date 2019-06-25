/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Representa una figura genérica que tiene área y por tanto puede ser rellena con algún color.
 * @author nazaret
 */
public abstract class FiguraConArea extends Figura{
    /**
     * Constructor con parámetros; establece el trazo, alisado, relleno y transparencia de una figura con relleno.
     * @param t Trazo con el que se creará la figura
     * @param alisado Indica si el alisado está activo o no
     * @param r Relleno con el que se creará la figura
     * @param transp Indica el grado de transparencia de la figura
     */
    public FiguraConArea(Trazo t, boolean alisado, Relleno r, float transp){
        super(t, alisado);
        
        if(r.getTipo() == TipoRelleno.LISO || r.getTipo() == TipoRelleno.SINRELLENO)
            relleno = new Relleno(r.getTipo(), r.getColor1());
        
        else
            relleno = new Relleno(r.getTipo(), r.getColor1(), r.getColor2(), r.getP1(), r.getP2());
        
        transparencia = transp;
    }

    /**
     * Devuelve el objeto Relleno de la figura.
     * @return Relleno de la figura
     */
    public Relleno getRelleno() {
        return relleno;
    }

    /**
     * Devuelve el grado de transparencia.
     * @return Grado de transparencia de la figura
     */
    public float getTransparencia() {
        return transparencia;
    }

    /**
     * Establece un nuevo relleno para la figura.
     * @param relleno Nuevo relleno a establecer
     */
    public void setRelleno(Relleno relleno) {
        this.relleno = relleno;
    }

    /**
     * Establece un nuevo grado de transparencia.
     * @param transparencia Nuevo grado de transparencia a establecer
     */
    public void setTransparencia(float transparencia) {
        this.transparencia = transparencia;
    }
    
    /**
     * Establece la transparencia y el relleno de la figura para poder pintarla.
     * @param g2d Objeto graphics2D para pintar la figura con relleno
     */
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencia));
    }

    /**
     * Establece una nueva localización para la figura; debe ser sobrecargado.
     * @param p Desplazamiento para la figura
     */
    @Override
    public abstract void setLocation(Point p);
    /**
     * Crea un marco rojo para seleccionar la figura; debe ser sobrecargado.
     * @return Rectángulo que enmarca la figura seleccionada
     */
    @Override
    public abstract Rectangulo seleccionarFigura();
    
    /**
     * Transforma la figura a un objeto String.
     * @return String de la figura
     */
    @Override
    public String toString(){
        return "Figura con área";
    }
    
    /**
     * Relleno de la figura; establece propiedades como el color y el tipo.
     */
    private Relleno relleno;
    /**
     * Grado de transparencia de la figura.
     */
    private float transparencia;
}
