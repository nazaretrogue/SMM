/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * Representa un trazo con todas sus propiedades.
 * @author nazaret
 */
public class Trazo {
    /**
     * Constructor con parámetros; crea un trazo con las propiedades deseadas.
     * @param c Color del trazo
     * @param gros Grosor del trazo
     * @param tt Tipo de trazo
     */
    public Trazo(Color c, int gros, TipoTrazo tt){
        color = c;
        grosor = gros;
        tipo = tt;
        
        st = new BasicStroke();
    }

    /**
     * Devuelve el color que tiene el trazo.
     * @return Color del trazo
     */
    public Color getColor() {
        return color;
    }

    /**
     * Devuelve el grosor del trazo.
     * @return Grosor de trazo
     */
    public int getGrosor() {
        return grosor;
    }

    /**
     * Devuelve el tipo de trazo.
     * @return Tipo de trazo
     */
    public TipoTrazo getTipo() {
        return tipo;
    }

    /**
     * Establece un nuevo color para el trazo.
     * @param color Nuevo color a establecer
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Establece un nuevo grosor para el trazo.
     * @param grosor Nuevo grosor a establecer
     */
    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public void setTipo(TipoTrazo tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Establece el trazo para poder pintar las figuras.
     * @param g2d Objeto graphics2D para poder pintar
     */
    public void paint(Graphics2D g2d){
        if(tipo == TipoTrazo.CONTINUO)
            st = new BasicStroke(grosor);
        
        else{
            float patron_disc[] = new float[2];
                
            if(tipo == TipoTrazo.DISCONTINUO){
                patron_disc[0] = 15.0f;
                patron_disc[1] = 15.0f;
            }

            else{
                patron_disc[0] = 3.0f;
                patron_disc[1] = 15.0f;
            }
                
            st = new BasicStroke(grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, patron_disc, 0.0f);
        }
        
        g2d.setStroke(st);
        g2d.setPaint(color);
    }
    
    /**
     * Color del trazo.
     */
    private Color color;
    /**
     * Grosor del trazo.
     */
    private int grosor;
    /**
     * Tipo de trazo.
     */
    private TipoTrazo tipo;
    /**
     * Agrupa las anteriores propiedades para crear el trazo.
     */
    private Stroke st;
}
