/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.graficos;

/**
 * Representa los tipos de relleno que puede tener una FiguraConArea.
 * @author nazaret
 */
public enum TipoRelleno {
    /**
     * Relleno desactivado.
     */
    SINRELLENO, 
    /**
     * Relleno con un color liso.
     */
    LISO, 
    /**
     * Relleno con degradado horizontal, usa dos colores.
     */
    GRADIENTEHOR, 
    /**
     * Relleno con degrado vertical, usa dos colores.
     */
    GRADIENTEVER
}
