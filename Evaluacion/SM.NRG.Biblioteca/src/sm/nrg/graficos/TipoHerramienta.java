/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

/**
 * Representa las herramientas disponibles para pintar sobre un lienzo.
 * @author nazaret
 */
public enum TipoHerramienta {
    /**
     * Herramienta para dibujar líneas rectas.
     */
    LINEAS, 
    /**
     * Herramienta para dibujar rectángulos.
     */
    RECTANGULOS, 
    /**
     * Herramienta para dibujar elipses.
     */
    ELIPSES, 
    /**
     * Herramienta para dibujar rectángulos con las esquinas redondeadas.
     */
    RECTANGULOSRED, 
    /**
     * Herramienta para dibujar curvas con un punto de control.
     */
    CURVAS
}
