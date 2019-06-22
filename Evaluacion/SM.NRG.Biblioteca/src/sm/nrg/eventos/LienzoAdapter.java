/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.eventos;

/**
 *
 * @author nazaret
 */
public class LienzoAdapter implements LienzoListener {

    @Override
    public void figuraAdded(LienzoEvent evt) {}

    @Override
    public void colorTrazoCambiado(LienzoEvent evt) {}

    @Override
    public void colorRelleno1Cambiado(LienzoEvent evt) {}

    @Override
    public void colorRelleno2Cambiado(LienzoEvent evt) {}

    @Override
    public void grosorCambiado(LienzoEvent evt) {}

    @Override
    public void tipoTrazoCambiado(LienzoEvent evt) {}

    @Override
    public void transparenciaCambiada(LienzoEvent evt) {}

    @Override
    public void alisadoCambiado(LienzoEvent evt) {}
}
