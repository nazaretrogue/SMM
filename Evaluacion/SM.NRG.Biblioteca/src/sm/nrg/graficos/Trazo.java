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
 *
 * @author nazaret
 */
public class Trazo {
    public Trazo(Color c, float gros, TipoTrazo tt){
        color = c;
        grosor = gros;
        tipo = tt;
        
        st = new BasicStroke();
    }

    public Color getColor() {
        return color;
    }

    public float getGrosor() {
        return grosor;
    }

    public TipoTrazo getTipo() {
        return tipo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setGrosor(float grosor) {
        this.grosor = grosor;
    }

    public void setTipo(TipoTrazo tipo) {
        this.tipo = tipo;
    }
    
    public void paint(Graphics2D g2d){
        if(tipo == TipoTrazo.CONTINUO)
            st = new BasicStroke();
        
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
    
    Color color;
    float grosor;
    TipoTrazo tipo;
    Stroke st;
}
