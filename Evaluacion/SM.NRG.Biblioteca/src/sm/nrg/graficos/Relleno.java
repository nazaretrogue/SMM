/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

import java.awt.Color;
import java.awt.Point;

/**
 * Representa el relleno con todas sus propiedades.
 * @author nazaret
 */
public class Relleno {
    /**
     * Constructor con parámetros; establece el tipo y el color del relleno.
     * @param tr Tipo de relleno, prefierible SINRELLENO o LISO
     * @param c Color del relleno
     */
    public Relleno(TipoRelleno tr, Color c){
        tipo = tr;
        color1 = c;
    }
    
    /**
     * Constructor con parámetros; establece el tipo, los colores y los puntos a partir de los que rellenar si es gradiente.
     * @param tr Tipo dr relleno preferible GRADIENTEVER o GRADIENTEHOR
     * @param c1 Primer color del gradiente
     * @param c2 Segundo color del gradiente
     * @param p1 Primer punto a partir del cual generar el gradiente
     * @param p2 Segundo putno a partir del cual generar el gradiente
     */
    public Relleno(TipoRelleno tr, Color c1, Color c2, Point p1, Point p2){
        tipo = tr;
        color1 = c1;
        color2 = c2;
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Devuelve el tipo de relleno.
     * @return Tipo de relleno
     */
    public TipoRelleno getTipo() {
        return tipo;
    }

    /**
     * Devuelve el primer color del relleno si es gradiente o el único color si es liso.
     * @return Color del relleno
     */
    public Color getColor1() {
        return color1;
    }
    
    /**
     * Devuelve el segundo color del relleno si es gradiente o nulo si es liso.
     * @return Color del relleno
     */
    public Color getColor2() {
        return color2;
    }

    /**
     * Devuelve el primer punto si el relleno es gradiente, nulo en otro caso.
     * @return Primer punto del gradiente
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Devuelve el segundo punto si el relleno es gradiente, nulo en otro caso.
     * @return Segundo punto del gradiente
     */
    public Point getP2() {
        return p2;
    }
    
    /**
     * Establece un nuevo tipo de relleno.
     * @param tipo Tipo de relleno a establecer
     */
    public void setTipo(TipoRelleno tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece un nuevo color para el relleno liso o cambia uno de los dos colores del gradiente.
     * @param color Nuevo color a establecer
     */
    public void setColor1(Color color) {
        this.color1 = color;
    }
    
    /**
     * Establece el segundo color del gradiente.
     * @param color Nuevo color a establecer
     */
    public void setColor2(Color color) {
        this.color2 = color;
    }

    /**
     * Establece el primer punto a partir del cual generar el gradiente.
     * @param p1 Nuevo punto a establecer
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Establece el segundo punto a partir del cual generar el gradiente.
     * @param p2 Nuevo punto a establecer
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    /**
     * Tipo de relleno.
     */
    private TipoRelleno tipo;
    /**
     * Color uno del relleno con gradiente o color de relleno liso.
     */
    private Color color1;
    /**
     * Color dos del relleno con gradiente.
     */
    private Color color2;
    /**
     * Punto uno del relleno con gradiente.
     */
    private Point p1;
    /**
     * Punto dos del relleno con gradiente.
     */
    private Point p2;
}
