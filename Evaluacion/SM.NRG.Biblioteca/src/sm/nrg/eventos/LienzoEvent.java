/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.eventos;

import java.awt.Color;
import java.awt.Shape;
import java.util.EventObject;
import sm.nrg.graficos.Figura;
import sm.nrg.graficos.TipoTrazo;

/**
 *
 * @author nazaret
 */
public class LienzoEvent extends EventObject {
    public LienzoEvent(Object source, Figura fig){
        super(source);
        
        figura = fig;
    }
    
    public LienzoEvent(Object source, Figura fig, Color col_tr, Color col_r1, Color col_r2, int grosor, TipoTrazo tt, float transparencia, boolean alisar){
        super(source);
        
        figura = fig;
        color_trazo = col_tr;
        color_relleno1 = col_r1;
        color_relleno2 = col_r2;
        this.grosor = grosor;
        tipo_trazo = tt;
        transp = transparencia;
        alisado = alisar;
    }

    public Figura getFigura() {
        return figura;
    }

    public Color getColor_trazo() {
        return color_trazo;
    }

    public Color getColor_relleno1() {
        return color_relleno1;
    }

    public Color getColor_relleno2() {
        return color_relleno2;
    }

    public int getGrosor() {
        return grosor;
    }

    public TipoTrazo getTipo_trazo() {
        return tipo_trazo;
    }

    public float getTransp() {
        return transp;
    }

    public boolean isAlisado() {
        return alisado;
    }
    
    private Figura figura;
    private Color color_trazo;
    private Color color_relleno1;
    private Color color_relleno2;
    private int grosor;
    TipoTrazo tipo_trazo;
    float transp;
    boolean alisado;
}
