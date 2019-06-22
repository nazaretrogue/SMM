/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author nazaret
 */
public abstract class FiguraConArea extends Figura{
    public FiguraConArea(Trazo t, boolean alisado, Relleno r, float transp){
        super(t, alisado);
        
        if(r.getTipo() == TipoRelleno.LISO || r.getTipo() == TipoRelleno.SINRELLENO)
            relleno = new Relleno(r.getTipo(), r.getColor1());
        
        else
            relleno = new Relleno(r.getTipo(), r.getColor1(), r.getColor2(), r.getP1(), r.getP2());
        
        transparencia = transp;
    }

    public Relleno getRelleno() {
        return relleno;
    }

    public float getTransparencia() {
        return transparencia;
    }

    public void setRelleno(Relleno relleno) {
        this.relleno = relleno;
    }

    public void setTransparencia(float transparencia) {
        this.transparencia = transparencia;
    }
    
    @Override
    public void paint(Graphics2D g2d){
        super.paint(g2d);
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencia));
    }

    @Override
    public abstract void setLocation(Point p);
    @Override
    public abstract Rectangulo seleccionarFigura();
    
    @Override
    public String toString(){
        return "Figura con área";
    }
    
    private Relleno relleno;
    private float transparencia;
}
