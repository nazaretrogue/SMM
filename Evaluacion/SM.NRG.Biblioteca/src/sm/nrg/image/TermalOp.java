/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.image;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;

/**
 *
 * @author nazaret
 */
public class TermalOp extends sm.image.BufferedImageOpAdapter{

    public TermalOp(BufferedImage gris){
        this.gris = gris;
    }
    
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
 
    BufferedImage gris = null;
}
