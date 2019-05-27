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
public class RayosXOp extends sm.image.BufferedImageOpAdapter {

    public RayosXOp(){}
    
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
                    float media = (pixel_comp[0]+pixel_comp[1]+pixel_comp[2])/3;
                    
                    if(media < umbral_inf){
                        pixel_comp[0] = 205;
                        pixel_comp[1] = 224;
                        pixel_comp[2] = 248;
                    }
                    
                    else if(media >= umbral_inf && media < umbral_sup){
                        pixel_comp[0] = 105;
                        pixel_comp[1] = 132;
                        pixel_comp[2] = 179;
                    }
                    
                    else{
                        pixel_comp[0] = 40;
                        pixel_comp[1] = 40;
                        pixel_comp[2] = 47;
                    }
                }
                       
                dest_raster.setPixel(i, j, pixel_comp);
            }
        }
        
        return dest;
    }
    
    float umbral_inf = 85.0f;
    float umbral_sup = 170.0f;
}