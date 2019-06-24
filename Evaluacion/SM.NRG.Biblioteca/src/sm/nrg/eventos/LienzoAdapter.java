/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.eventos;

/**
 * Adapter para los eventos generados por el lienzo.
 * @author nazaret
 */
public class LienzoAdapter implements LienzoListener {
    /**
     * Implementación por defecto del método de la interfaz.
     * @param evt Evento que ha producido el lienzo
     */
    @Override
    public void figuraAdded(LienzoEvent evt) {}
}
