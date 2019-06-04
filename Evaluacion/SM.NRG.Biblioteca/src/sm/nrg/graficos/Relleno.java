/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author nazaret
 */
public class Relleno {
    public Relleno(TipoRelleno tr, Color c){
        tipo = tr;
        color1 = c;
    }
    
    public Relleno(TipoRelleno tr, Color c1, Color c2, Point p1, Point p2){
        tipo = tr;
        color1 = c1;
        color2 = c2;
        this.p1 = p1;
        this.p2 = p2;
    }

    public TipoRelleno getTipo() {
        return tipo;
    }

    public Color getColor1() {
        return color1;
    }
    
    public Color getColor2() {
        return color2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    
    public void setTipo(TipoRelleno tipo) {
        this.tipo = tipo;
    }

    public void setColor1(Color color) {
        this.color1 = color;
    }
    
    public void setColor2(Color color) {
        this.color2 = color;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    TipoRelleno tipo;
    Color color1, color2;
    Point p1, p2;
}
