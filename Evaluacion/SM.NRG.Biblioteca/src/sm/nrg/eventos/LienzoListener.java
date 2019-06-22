/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.eventos;

import java.util.EventListener;

/**
 *
 * @author nazaret
 */
public interface LienzoListener extends EventListener {
    public void figuraAdded(LienzoEvent evt);
    public void colorTrazoCambiado(LienzoEvent evt);
    public void colorRelleno1Cambiado(LienzoEvent evt);
    public void colorRelleno2Cambiado(LienzoEvent evt);
    public void grosorCambiado(LienzoEvent evt);
    public void tipoTrazoCambiado(LienzoEvent evt);
    public void transparenciaCambiada(LienzoEvent evt);
    public void alisadoCambiado(LienzoEvent evt);
}
