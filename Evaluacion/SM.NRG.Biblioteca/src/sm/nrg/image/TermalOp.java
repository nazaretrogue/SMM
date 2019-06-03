/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author nazaret
 */
public class TermalOp extends sm.image.BufferedImageOpAdapter{

    /**
     * Constructor con un parámetro
     * @param gris Contiene la imagen que se vería en el caso de que a ningún pixel se le pudiese aplicar el filtro.
     */
    public TermalOp(BufferedImage gris){
        this.gris = gris;
    }
    
    /**
     * Genera una imagen donde los pixeles que superan un valor de 128 en el rojo se mantienen y el resto pasa a escala de grises.
     * @param src Imagen fuente.
     * @param dest Imagen destino.
     * @return Imagen con el filtro termal aplicado.
     * @throws NullPointerException Genera una excepción cuando la imagen fuente es nula.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src == null)
            throw new NullPointerException("Imagen fuente nula");
        
        if(dest == null)
            dest = createCompatibleDestImage(src, null);
        
        WritableRaster src_raster = src.getRaster(),
                       dest_raster = dest.getRaster(),
                       src_gris_raster = gris.getRaster();
        
        int[] pixel_comp = null, pixel_comp_gris = null;
        
        for(int i=0; i<src.getWidth(); i++){
            for(int j=0; j<src.getHeight(); j++){
                pixel_comp = src_raster.getPixel(i, j, pixel_comp);
                pixel_comp_gris = src_gris_raster.getPixel(i, j, pixel_comp_gris);
                
                for(int k=0; k<src.getRaster().getNumBands(); k++){
                    if(pixel_comp[0] >= 128){
                        int aux = pixel_comp[k];
                        pixel_comp[k] = aux;
                    }
                    
                    else
                        pixel_comp[k] = pixel_comp_gris[0];
                }
                       
                dest_raster.setPixel(i, j, pixel_comp);
            }
        }
        
        return dest;
    }

    /**
     * Imagen que contiene los pixeles a los que no se les aplica el filtro termal.
     */
    private BufferedImage gris = null;
}
