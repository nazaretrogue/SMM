/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

/**
 * Representa los tipos de trazos con los que se puede pintar una Figura.
 * @author nazaret
 */
public enum TipoTrazo {
    /**
     * Trazo continuo.
     */
    CONTINUO, 
    /**
     * Trazo discontinuo; crea un trazo discontinuo con líneas.
     */
    DISCONTINUO, 
    /**
     * Trazo punteado; crea un trazo discontinuo con puntos.
     */
    PUNTEADO
}
