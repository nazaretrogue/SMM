/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 * Clase abstracta que representa una figura geométrica genérica.
 * @author nazaret
 */
public abstract class Figura {
    /**
     * Constructor con parámetros; establece el trazo y el alisado de cada figura.
     * @param t Trazo con el que se creará la figura
     * @param alisado Indica si el alisado está activo o no
     */
    public Figura(Trazo t, boolean alisado){
        trazo = new Trazo(t.getColor(), t.getGrosor(), t.getTipo());
        this.alisado = alisado;
    }

    /**
     * Devuelve el objeto Trazo.
     * @return Trazo de la figura
     */
    public Trazo getTrazo() {
        return trazo;
    }

    /**
     * Indica si el alisado está activo o no.
     * @return true si está activo; false en otro caso
     */
    public boolean isAlisado() {
        return alisado;
    }

    /**
     * Establece un nuevo Trazo para la figura.
     * @param trazo Nuevo trazo que tendrá la figura
     */
    public void setTrazo(Trazo trazo) {
        this.trazo = trazo;
    }

    /**
     * Establece el alisado.
     * @param alisado Indica si se activa el alisado (true) o no (false)
     */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }
    
    /**
     * Pinta el trazo y el alisado de la figura.
     * @param g2d Objeto graphics2D para pintar
     */
    public void paint(Graphics2D g2d){
        if(alisado)
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        else
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
        
        trazo.paint(g2d);
            
    }
    
    /**
     * Método abstracto para establecer una nueva localización para la figura; debe ser sobrecargado.
     * @param p Desplazamiento para la figura
     */
    public abstract void setLocation(Point p);
    /**
     * Métoco abstracto para seleccionar la figura; debe ser sobrecargado.
     * @return Rectángulo que enmarca la figura seleccionada
     */
    public abstract Rectangulo seleccionarFigura();
    
    /**
     * Transforma la figura en un objeto String.
     * @return String de la figura
     */
    @Override
    public String toString(){
        return "Figura";
    }
    
    /**
     * Trazo de la figura; establece todas las propiedades como el color, el grosor y tipo.
     */
    private Trazo trazo;
    /**
     * Alisado activo o desactivo para la figura.
     */
    private boolean alisado;
}
