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

    public TermalOp(){}
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src == null)
            throw new NullPointerException("Imagen fuente nula");
        
        if(dest == null)
            dest = createCompatibleDestImage(src, null);
        
        BufferedImage escala_grises = crearTonosGrises(src);
        
        WritableRaster src_raster = src.getRaster(),
                       dest_raster = dest.getRaster(),
                       src_gris_raster = escala_grises.getRaster();
        
        int[] pixel_comp = null, pixel_comp_gris = null;
        
        for(int i=0; i<src.getWidth(); i++){
            for(int j=0; j<src.getHeight(); j++){
                for(int k=0; k<src.getRaster().getNumBands(); k++){
                    pixel_comp = src_raster.getPixel(i, j, pixel_comp);
                    pixel_comp_gris = src_gris_raster.getPixel(i, j, pixel_comp_gris);
                    
                    if(k == 0 && pixel_comp[k] >= 128){
                        int aux = pixel_comp[k];
                        pixel_comp[k] = aux;
                    }
                    
                    else{
                        pixel_comp[k] = pixel_comp_gris[0];}
                }
                       
                dest_raster.setPixel(i, j, pixel_comp);
            }
        }
        
        return dest;
    }
    
    private BufferedImage crearTonosGrises(BufferedImage src){
        ColorModel destCM;
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        destCM = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        
        WritableRaster wr = destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight());
        
        return new BufferedImage(destCM, wr, src.isAlphaPremultiplied(), null);
    }
    
}
