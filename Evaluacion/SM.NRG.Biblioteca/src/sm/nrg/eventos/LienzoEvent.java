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
 * Clase que contiene las propiedades de los eventos generados por un lienzo.
 * @author nazaret
 */
public class LienzoEvent extends EventObject {
    /**
     * Constructor de los eventos.
     * @param source Objeto que ha generado el evento
     * @param fig Figura que se ha añadido para generar el evento
     */
    public LienzoEvent(Object source, Figura fig){
        super(source);
        
        figura = fig;
    }

    /**
     * Devuelve la figura que se ha añadido provocando un evento.
     * @return Figura añadida
     */
    public Figura getFigura() {
        return figura;
    }

    /**
     * Figura que al añadir ha generado el evento.
     */
    private Figura figura;
}
