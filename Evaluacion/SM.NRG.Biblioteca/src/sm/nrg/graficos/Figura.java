/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

/**
 *
 * @author nazaret
 */
public abstract class Figura {
    
    public Figura(Trazo t, boolean alisado){
        trazo = new Trazo(t.getColor(), t.getGrosor(), t.getTipo());
        this.alisado = alisado;
    }

    public Trazo getTrazo() {
        return trazo;
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setTrazo(Trazo trazo) {
        this.trazo = trazo;
    }

    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }
    
    public void paint(Graphics2D g2d){
        if(alisado)
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        else
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
        
        trazo.paint(g2d);
            
    }
    
    public abstract void setLocation(Point2D p);
    
    @Override
    public String toString(){
        return "Figura";
    }
    
    private Trazo trazo;
    private boolean alisado;
}
