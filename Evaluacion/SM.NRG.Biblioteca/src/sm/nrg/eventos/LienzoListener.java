/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.eventos;

import java.util.EventListener;

/**
 * Interfaz que define los métodos que podrá ejecutar un evento producido por un lienzo.
 * @author nazaret
 */
public interface LienzoListener extends EventListener {
    /**
     * Se llama este método cuando se añae una nueva figura al lienzo.
     * @param evt Evento que ha generado el lienzo
     */
    public void figuraAdded(LienzoEvent evt);
}
