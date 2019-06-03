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
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author nazaret
 */
public class UmbralizacionOp extends BufferedImageOpAdapter {
    
    /**
     * Constructor con un parámetro.
     * @param um Factor de umbralización
     */
    public UmbralizacionOp(int um){
        umbral = um;
    }

    /**
     * Da lugar a una imagen binaria tras examinar cada pixel y darle el valor correspondiente
     * @param src Imagen fuente
     * @param dest Imagen destino. Puede ser nula
     * @return Genera una imagen a la que le ha aplicado el filtro de umbralización
     * @throws NullPointerException Genera una excepción si la imagen fuente es nula
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src == null)
            throw new NullPointerException("Imagen fuente nula");
        
        if(dest == null)
            dest = createCompatibleDestImage(src, null);
        
        else if(!EsCompatible(dest))
            dest = createCompatibleDestImage(src, null);
        
        WritableRaster src_raster = src.getRaster(),
                       dest_raster = dest.getRaster();
        
        for(int i=0; i<src.getWidth(); i++){
            for(int j=0; j<src.getHeight(); j++){
                int[] pixel_comp = null;
                pixel_comp = src_raster.getPixel(i, j, pixel_comp);
                
                if(pixel_comp.length >= 3){
                    float media = (pixel_comp[0]+pixel_comp[1]+pixel_comp[2])/3;
                    
                    if(media < umbral)
                        pixel_comp[0] = pixel_comp[1] = pixel_comp[2] = 0;
                    
                    else
                        pixel_comp[0] = pixel_comp[1] = pixel_comp[2] = 255;
                }
                       
                dest_raster.setPixel(i, j, pixel_comp);
            }
        }
        
        return dest;
    }
    
    /**
     * Genera una imagen compatible que será devuelta por el método filter en el caso en que dest sea null
     * @param src Imagen fuente
     * @param destCM Imagen destino
     * @return Imagen en escala de grises
     */
    @Override
    public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM){
        if(destCM == null){
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            destCM = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        }
        
        WritableRaster wr = destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight());
        
        return new BufferedImage(destCM, wr, src.isAlphaPremultiplied(), null);
    }
    
    /**
     * Comprueba si el espacio de color de la imagen es GRAY.
     * @param img Imagen de la que comprobar el espacio de color
     * @return true en el caso de que el espacio sea GRAY; false en otro caso
     */
    private boolean EsCompatible(BufferedImage img){
        boolean comp = true;
        
        if(img.getColorModel().getColorSpace().toString() != "CS_GRAY"){
            comp = false;
            System.out.println("distinto");
        }
        
        return comp;
    }
    
    /**
     * Umbral que define qué pixeles serán blancos (si están por encima) y negros (si están por debajo).
     */
    private int umbral;
}
