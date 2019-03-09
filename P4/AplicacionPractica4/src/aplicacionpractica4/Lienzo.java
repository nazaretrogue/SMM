/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 *
 * @author nazaret
 */
public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        
        p_ini = new Point();
        p_fin = new Point();
        color = new Color(0,0,0);
        evento_raton = new java.awt.event.MouseEvent(this, WIDTH, WIDTH, SOMEBITS, WIDTH, WIDTH, HEIGHT, true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(color);
        
        int x1 = (int)p_ini.getX(), y1 = (int)p_ini.getY();
        int x2 = (int)p_fin.getX(), y2 = (int)p_fin.getY();
        
        switch(herramienta){
            case 0:
                g.fillOval((int)p_ini.getX()-5, (int)p_ini.getY()-5, 10, 10);
                break;
            case 1:
                g.drawLine((int)p_ini.getX(), (int)p_ini.getY(), (int)p_fin.getX(), (int)p_fin.getY());
                break;
            case 2:
                if(relleno == true){
                    if(x1 < x2){
                        if(y1 < y2)
                            g.fillRect(x1, y1, x2-x1, y2-y1);
                        else
                            g.fillRect(x1, y2, x2-x1, y1-y2);
                    }
                    
                    else{
                        if(y1 < y2)
                            g.fillRect(x2, y1, x1-x2, y2-y1);
                        else
                            g.fillRect(x2, y2, x1-x2, y1-y2);
                    }
                }
                    
                else{
                    if(x1 < x2){
                        if(y1 < y2)
                            g.drawRect(x1, y1, x2-x1, y2-y1);
                        else
                            g.drawRect(x1, y2, x2-x1, y1-y2);
                    }
                    
                    else{
                        if(y1 < y2)
                            g.drawRect(x2, y1, x1-x2, y2-y1);
                        else
                            g.drawRect(x2, y2, x1-x2, y1-y2);
                    }
                }
                
                break;
            case 3:
                if(relleno == true){
                    if(x1 < x2){
                        if(y1 < y2)
                            g.fillOval(x1, y1, x2-x1, y2-y1);
                        else
                            g.fillOval(x1, y2, x2-x1, y1-y2);
                    }
                    
                    else{
                        if(y1 < y2)
                            g.fillOval(x2, y1, x1-x2, y2-y1);
                        else
                            g.fillOval(x2, y2, x1-x2, y1-y2);
                    }
                }
                    
                else{
                    if(x1 < x2){
                        if(y1 < y2)
                            g.drawOval(x1, y1, x2-x1, y2-y1);
                        else
                            g.drawOval(x1, y2, x2-x1, y1-y2);
                    }
                    
                    else{
                        if(y1 < y2)
                            g.drawOval(x2, y1, x1-x2, y2-y1);
                        else
                            g.drawOval(x2, y2, x1-x2, y1-y2);
                    }
                }
                
                break;
        }
    }
    
    public void setColor(Color nuevo){
        color = nuevo;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setHerramienta(int num_tool){
        herramienta = num_tool;
    }
    
    public int getHerramienta(){
        return herramienta;
    }
    
    public void setRelleno(boolean estado){
        relleno = estado;
    }
    
    public boolean getRelleno(){
        return relleno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        p_ini = evt.getPoint();
        //this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        p_fin = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        p_fin = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p_ini = evt.getPoint();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    Point p_ini;    // Punto de inicio para líneas, rectángulos y elipses
    Point p_fin;    // Punto de fin para líneas, rectángulos y elipses
    java.awt.event.MouseEvent evento_raton;
    Color color;
    int herramienta;
    boolean relleno;
}
