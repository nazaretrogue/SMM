/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import sm.nrg.eventos.LienzoEvent;
import sm.nrg.eventos.LienzoListener;
import sm.nrg.graficos.*;


/**
 * Clase para crear un lienzo con las propiedades y figuras que se desee.
 * @author nazaret
 */
public class Lienzo2D extends javax.swing.JPanel {
    /**
     * Constructor por defecto; inicializa los atributos por defecto.
     */
    public Lienzo2D(){
        initComponents();
        
        v_shape = new ArrayList();
        herramienta = TipoHerramienta.LINEAS;
        traz = new Trazo(Color.BLACK, 1, TipoTrazo.CONTINUO);
        transp = 1.0f;
        relleno = new Relleno(TipoRelleno.SINRELLENO, Color.BLACK);
        alisado = false;
        lienzo_event_listeners = new ArrayList();
        recorte = new Rectangle2D.Float(0, 0, 0, 0);
    }
    
    /**
     * Dibuja las figuras que se han incluido en el lienzo.
     * @param g Objeto graphics para pintar
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setClip(recorte);
        
        for(Figura f: v_shape)
            f.paint(g2d);
    }
    
    /**
     * Crea la figura que se desee incluyéndola en el vector de figuras.
     * @param p_i Punto inicial de la figura
     */
    private void createShape(Point p_i){
        switch(herramienta){
            case LINEAS:
                Line2D laux = new Line2D.Float(p_i, p_i);
                v_shape.add(new Linea(traz, alisado, laux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case RECTANGULOS:
                p_aux = p_i;
                Rectangle2D raux = new Rectangle2D.Double(p_i.getX(), p_i.getY(), 1, 1);
                v_shape.add(new Rectangulo(traz, alisado, relleno, transp, raux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case ELIPSES:
                p_aux = p_i;
                Ellipse2D eaux = new Ellipse2D.Double(p_i.getX(), p_i.getY(), 1, 1);
                v_shape.add(new Elipse(traz, alisado, relleno, transp, eaux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case RECTANGULOSRED:
                p_aux = p_i;
                RoundRectangle2D rraux = new RoundRectangle2D.Double(p_i.getX(), p_i.getY(), 1, 1, 25, 25);
                v_shape.add(new RectanguloRedondeado(traz, alisado, relleno, transp, rraux));
                notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                break;
            case CURVAS:
                if(!curva_cuad){
                    QuadCurve2D caux = new QuadCurve2D.Double(p_i.getX(), p_i.getY(), p_i.getX(), p_i.getX(), p_i.getX(), p_i.getX());
                    v_shape.add(new CurvaCuadrada(traz, alisado, caux));
                    notifyFiguraAddedEvent(new LienzoEvent(this, v_shape.get(v_shape.size()-1)));
                }
                break;
        }
    }
    
    /**
     * Finaliza la creación de la figura.
     * @param p_f Punto final de la figura.
     */
    private void updateShape(Point p_f){
        switch(herramienta){
            case LINEAS:
                Linea laux = (Linea)v_shape.get(v_shape.size()-1);
                laux.getLinea().setLine(laux.getLinea().getP1(), p_f);
                break;
            case RECTANGULOS:
                Rectangulo raux = (Rectangulo)(v_shape.get(v_shape.size()-1));
                raux.getRectangulo().setFrameFromDiagonal(p_aux, p_f);

                v_shape.set(v_shape.size()-1, raux);
                break;
            case ELIPSES:
                Elipse eaux = (Elipse)(v_shape.get(v_shape.size()-1));
                eaux.getElipse().setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, eaux);
                break;
            case RECTANGULOSRED:
                RectanguloRedondeado rraux = (RectanguloRedondeado)(v_shape.get(v_shape.size()-1));
                rraux.getRecred().setFrameFromDiagonal(p_aux, p_f);
                
                v_shape.set(v_shape.size()-1, rraux);
                break;
            case CURVAS:
                CurvaCuadrada caux = (CurvaCuadrada)v_shape.get(v_shape.size()-1);
                if(!curva_cuad || !punto){
                    caux.getCurva().setCurve(caux.getCurva().getP1(), p_f, p_f);
                    curva_cuad = true;
                }
                else{
                    double ctrlx = Math.abs(caux.getCurva().getP2().getX() - caux.getCurva().getP1().getX());
                    double ctrly = Math.abs(caux.getCurva().getP2().getY() - caux.getCurva().getP1().getY());
                    
                    Point2D central = new Point2D.Double(ctrlx/2+p_f.getX(), ctrly/2+p_f.getY());
                    
                    caux.getCurva().setCurve(caux.getCurva().getP1(), central, caux.getCurva().getP2());
                }
                
                v_shape.set(v_shape.size()-1, caux);
                break;
        }
    }
    
    /**
     * Selecciona la figura que se desea y pinta un rectángulo rojo para remarcarla.
     * @param f 
     */
    public void seleccionarFigura(Figura f){
        v_shape.add(f.seleccionarFigura());
        repaint();
    }
    
    /**
     * Deselecciona la figura eliminando el marco.
     */
    public void deseleccionarFigura(){
        v_shape.remove(v_shape.size()-1);
        repaint();
    }

    /**
     * Devuelve el tipo de herramienta que está activa en el lienzo.
     * @return El tipo de herramienta
     */
    public TipoHerramienta getHerramienta() {
        return herramienta;
    }

    /**
     * Devuelve el trazo activo en el lienzo
     * @return El objeto trazo del lienzo
     */
    public Trazo getTraz() {
        return traz;
    }

    /**
     * Devuelve el grado de transparencia.
     * @return Grado de transparencia
     */
    public float getTransp() {
        return transp;
    }

    /**
     * Devuelve el relleno activo en el lienzo.
     * @return El objeto relleno del lienzo
     */
    public Relleno getRelleno() {
        return relleno;
    }

    /**
     * Devuelve el vector de figuras pintadas en el lienzo.
     * @return Vector de figuras.
     */
    public ArrayList<Figura> getV_shape() {
        return v_shape;
    }

    /**
     * Devuelve el área de recorte establecida.
     * @return Área de recorte
     */
    public Shape getRecorte() {
        return recorte;
    }
    
    /**
     * Devuelve la activación del alisado.
     * @return true si el alisado está activo; false en otro caso
     */
    public boolean isAlisado() {
        return alisado;
    }

    /**
     * Establece la herramienta.
     * @param herramienta Nueva herramienta para el lienzo
     */
    public void setHerramienta(TipoHerramienta herramienta) {
        this.herramienta = herramienta;
    }

    /**
     * Establece el trazo.
     * @param traz Nuevo trazo para el lienzo
     */
    public void setTraz(Trazo traz) {
        this.traz = traz;
    }

    /**
     * Establece la transparencia del lienzo.
     * @param transp Grado de transparencia
     */
    public void setTransp(float transp) {
        this.transp = transp;
    }

    /**
     * Establece el relleno: tipo y colores.
     * @param relleno Nuevo relleno para el lienzo
     */
    public void setRelleno(Relleno relleno) {
        this.relleno = relleno;
    }

    /**
     * Establece el alisado.
     * @param alisado valor de verdad para establecer el alisado en el lienzo
     */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }
    
    /**
     * Establece el área de recorte.
     * @param recorte Nueva área de recorte
     */
    public void setRecorte(Shape recorte){
        this.recorte = recorte;
    }

    /**
     * Agrega un listener nuevo al lienzo.
     * @param listener Listener de eventos para el lienzo
     */
    public void addLienzoListener(LienzoListener listener) {
        if(listener != null)
            lienzo_event_listeners.add(listener);
    }
    
    /**
     * Notifica cuando se añade una figura al lienzo.
     * @param evt Evento generado al añadir la figura
     */
    private void notifyFiguraAddedEvent(LienzoEvent evt){
        if(!lienzo_event_listeners.isEmpty()){
            for(LienzoListener listener: lienzo_event_listeners)
                listener.figuraAdded(evt);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseMotionListener(formListener);
        addMouseListener(formListener);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener {
        FormListener() {}
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMouseReleased(evt);
            }
        }

        public void mouseDragged(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Lienzo2D.this) {
                Lienzo2D.this.formMouseDragged(evt);
            }
        }

        public void mouseMoved(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Crea o actualiza la figura actual.
     * @param evt Evento que se ha generado al pulsar el botón del ratón
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(!curva_cuad){
            p_aux = evt.getPoint();
            createShape(p_aux);
        }
        
        else
            updateShape(evt.getPoint());
    }//GEN-LAST:event_formMousePressed
    
    /**
     * Finaliza la creación o actualización de la figura.
     * @param evt Evento generado por el ratón
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
        
        if(curva_cuad && !punto)
            punto = true;
        
        else{
            curva_cuad = false;
            punto = false;
        }
    }//GEN-LAST:event_formMouseReleased
    
    /**
     * Actualiza la figura a medida que se mueve el ratón.
     * @param evt Evento que ha generado el movimiento del ratón
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.updateShape(evt.getPoint());
        this.repaint();
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Array de figuras.
     */
    private ArrayList<Figura> v_shape;
    /**
     * Herramienta activa en el lienzo.
     */
    private TipoHerramienta herramienta;
    /**
     * Trazo activo en el lienzo.
     */
    private Trazo traz;
    /**
     * Grado de transparencia establecida en el lienzo: 1.0 opaco, 0.0 transparente.
     */
    private float transp;
    /**
     * Relleno activo en el lienzo.
     */
    private Relleno relleno;
    /**
     * Alisado activado o desactivado en el lienzo.
     */
    private boolean alisado;
    /**
     * Punto auxiliar para crear las figuras.
     */
    private Point p_aux;
    /**
     * Banderas para controlar la creación de curvas con su punto de control.
     */
    private boolean curva_cuad = false, punto = false;
    /**
     * Vector de listeners del lienzo.
     */
    private ArrayList<LienzoListener> lienzo_event_listeners;
    /**
     * Clip para limitar el área de dibujo.
     */
    private Shape recorte;
}
