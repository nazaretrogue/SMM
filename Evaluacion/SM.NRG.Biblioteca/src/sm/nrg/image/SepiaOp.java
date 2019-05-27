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
public class SepiaOp extends sm.image.BufferedImageOpAdapter{

    public SepiaOp(){}
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src == null)
            throw new NullPointerException("Imagen fuente nula");
        
        if(dest == null)
            dest = createCompatibleDestImage(src, null);
        
        WritableRaster src_raster = src.getRaster(),
                       dest_raster = dest.getRaster();
        
        for(int i=0; i<src_raster.getWidth(); i++){
            for(int j=0; j<src_raster.getHeight(); j++){
                int[] pixel_comp = null;
                pixel_comp = src_raster.getPixel(i, j, pixel_comp);
                
                if(pixel_comp.length >= 3){
                    pixel_comp[0] = (int)(pixel_comp[0]*0.393 + pixel_comp[1]*0.769 + pixel_comp[2]*0.189);
                    pixel_comp[1] = (int)(pixel_comp[0]*0.349 + pixel_comp[1]*0.686 + pixel_comp[2]*0.168);
                    pixel_comp[2] = (int)(pixel_comp[0]*0.272 + pixel_comp[1]*0.534 + pixel_comp[2]*0.131);
                
                    if(pixel_comp[0] > 255)
                        pixel_comp[0] = 255;

                    if(pixel_comp[1] > 255)
                        pixel_comp[1] = 255;

                    if(pixel_comp[2] > 255)
                        pixel_comp[2] = 255;
                }
                       
                dest_raster.setPixel(i, j, pixel_comp);
            }
        }
        
        return dest;
    }
    
}