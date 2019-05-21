/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica12;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import sm.image.EqualizationOp;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.image.TintOp;
import sm.nrg.iu.*;
import sm.nrg.image.SepiaOp;
import sm.nrg.image.UmbralizacionOp;

/**
 *
 * @author nazaret
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        this.setSize(1200, 1000);   
    }
    
    private void Escalado(float escalado){
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    AffineTransform at = AffineTransform.getScaleInstance(escalado, escalado);
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage dest = atop.filter(img_source, null);
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }
    
    private void EjecutarContraste(int funcion){
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    LookupTable lut = LookupTableProducer.createLookupTable(funcion);
                    LookupOp luop = new LookupOp(lut, null);
                    luop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }
    
    private void Rotacion(int grados, BufferedImage dest){
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    double r = Math.toRadians(grados);
                    Point c = new Point(img_source.getWidth()/2, img_source.getHeight()/2);
                    AffineTransform at = AffineTransform.getRotateInstance(r, c.x, c.y);
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                    
                    if(dest == null)
                        dest = atop.filter(img_source, null);
                    
                    else
                        atop.filter(img_source, dest);
                    
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }
    
    private LookupTable seno(double w){
        byte data[] = new byte[256];
        double K = 255.0;
        double f;
        
        for(int i=0; i<256; i++){
            f = (Math.abs(Math.sin(Math.toRadians(i*w))));
            data[i] = (byte)(K*f);
        }
        
        ByteLookupTable t = new ByteLookupTable(0, data);
        return t;
    }
    
    private void RepintarEscritorio(){
        for(JInternalFrame infr: escritorio.getAllFrames())
                ((VentanaInterna)infr).getLienzo().repaint();
    }
    
    private boolean EsGray(BufferedImage img){
        boolean gray = false;
        
        if(img.getSampleModel().getNumBands() == 1)
            gray = true;
        
        return gray;
    }
    
    private boolean EsRGB(BufferedImage img){
        boolean rgb = false;
        
        if(img.getSampleModel().getNumBands() == 3 && img.getColorModel().getColorSpace().isCS_sRGB())
            rgb = true;
        
        return rgb;
    }
    
    private boolean EsYCC(BufferedImage img){
        return (!EsGray(img) && !EsRGB(img));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_colores = new javax.swing.ButtonGroup();
        grupo_herramientas = new javax.swing.ButtonGroup();
        panel_estado = new javax.swing.JPanel();
        etiq_estado = new javax.swing.JLabel();
        barra_herramientas = new javax.swing.JToolBar();
        boton_nuevo = new javax.swing.JToggleButton();
        boton_abrir = new javax.swing.JToggleButton();
        boton_guardar = new javax.swing.JToggleButton();
        separador1 = new javax.swing.JToolBar.Separator();
        boton_punto = new javax.swing.JToggleButton();
        boton_linea = new javax.swing.JToggleButton();
        boton_rectangulo = new javax.swing.JToggleButton();
        boton_elipse = new javax.swing.JToggleButton();
        boton_seleccion = new javax.swing.JToggleButton();
        separador2 = new javax.swing.JToolBar.Separator();
        Color c[]={Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN};
        desplegable_color = new javax.swing.JComboBox<>(c);
        separador3 = new javax.swing.JToolBar.Separator();
        spinner_grosor = new javax.swing.JSpinner();
        boton_rellenar = new javax.swing.JToggleButton();
        boton_transp = new javax.swing.JToggleButton();
        boton_alisar = new javax.swing.JToggleButton();
        separador4 = new javax.swing.JToolBar.Separator();
        panel_slider = new javax.swing.JPanel();
        slider_brillo = new javax.swing.JSlider();
        panel_desp_filtros = new javax.swing.JPanel();
        desplegable_filtro = new javax.swing.JComboBox<>();
        boton_contraste = new javax.swing.JButton();
        boton_iluminar = new javax.swing.JButton();
        boton_oscurecer = new javax.swing.JButton();
        boton_seno = new javax.swing.JButton();
        boton_sepia = new javax.swing.JButton();
        boton_tintado = new javax.swing.JButton();
        boton_ecual = new javax.swing.JButton();
        panel_cs = new javax.swing.JPanel();
        boton_bandas = new javax.swing.JButton();
        desplegable_cs = new javax.swing.JComboBox<>();
        panel_rotacion = new javax.swing.JPanel();
        slider_rotacion = new javax.swing.JSlider();
        boton_rot90 = new javax.swing.JButton();
        boton_rot180 = new javax.swing.JButton();
        boton_rot270 = new javax.swing.JButton();
        boton_es_dis = new javax.swing.JButton();
        boton_es_aum = new javax.swing.JButton();
        panel_umbral = new javax.swing.JPanel();
        slider_umbral = new javax.swing.JSlider();
        panel_atr_lienzo = new javax.swing.JPanel();
        panel_atr_generico = new javax.swing.JPanel();
        barra_atr = new javax.swing.JToolBar();
        escritorio = new javax.swing.JDesktopPane();
        barra_menu = new javax.swing.JMenuBar();
        menu_edicion = new javax.swing.JMenu();
        menu_op_barra_est = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_form = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_atr = new javax.swing.JCheckBoxMenuItem();
        menu_imagen = new javax.swing.JMenu();
        menu_op_rescaleop = new javax.swing.JMenuItem();
        menu_op_convolveop = new javax.swing.JMenuItem();
        menu_op_aftr = new javax.swing.JMenuItem();
        menu_op_lookup = new javax.swing.JMenuItem();
        menu_op_bandcomb = new javax.swing.JMenuItem();
        menu_op_colorconvert = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panel_estado.setLayout(flowLayout1);

        etiq_estado.setText("Punto");
        panel_estado.add(etiq_estado);

        getContentPane().add(panel_estado, java.awt.BorderLayout.SOUTH);

        barra_herramientas.setRollover(true);

        boton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        boton_nuevo.setToolTipText("Nuevo lienzo");
        boton_nuevo.setFocusable(false);
        boton_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_nuevo.addActionListener(formListener);
        barra_herramientas.add(boton_nuevo);

        boton_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        boton_abrir.setToolTipText("Abrir archivo");
        boton_abrir.setFocusable(false);
        boton_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_abrir.addActionListener(formListener);
        barra_herramientas.add(boton_abrir);

        boton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        boton_guardar.setToolTipText("Guardar archivo");
        boton_guardar.setFocusable(false);
        boton_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_guardar.addActionListener(formListener);
        barra_herramientas.add(boton_guardar);
        barra_herramientas.add(separador1);

        grupo_herramientas.add(boton_punto);
        boton_punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/punto.png"))); // NOI18N
        boton_punto.setSelected(true);
        boton_punto.setToolTipText("Pincel puntos");
        boton_punto.setFocusable(false);
        boton_punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_punto.addActionListener(formListener);
        barra_herramientas.add(boton_punto);

        grupo_herramientas.add(boton_linea);
        boton_linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        boton_linea.setToolTipText("Pincel líneas");
        boton_linea.setFocusable(false);
        boton_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_linea.addActionListener(formListener);
        barra_herramientas.add(boton_linea);

        grupo_herramientas.add(boton_rectangulo);
        boton_rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        boton_rectangulo.setToolTipText("Pincel rectángulos");
        boton_rectangulo.setFocusable(false);
        boton_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rectangulo.addActionListener(formListener);
        barra_herramientas.add(boton_rectangulo);

        grupo_herramientas.add(boton_elipse);
        boton_elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        boton_elipse.setToolTipText("Pincel elipses");
        boton_elipse.setFocusable(false);
        boton_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_elipse.addActionListener(formListener);
        barra_herramientas.add(boton_elipse);

        grupo_herramientas.add(boton_seleccion);
        boton_seleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seleccion.png"))); // NOI18N
        boton_seleccion.setToolTipText("Mover figura");
        boton_seleccion.setFocusable(false);
        boton_seleccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_seleccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_seleccion.addActionListener(formListener);
        barra_herramientas.add(boton_seleccion);
        barra_herramientas.add(separador2);

        desplegable_color.setToolTipText("Colores");
        desplegable_color.setPreferredSize(new java.awt.Dimension(50, 30));
        desplegable_color.setRenderer(new ColorRender());
        desplegable_color.addActionListener(formListener);
        barra_herramientas.add(desplegable_color);
        barra_herramientas.add(separador3);

        spinner_grosor.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinner_grosor.setToolTipText("Grosor pincel");
        spinner_grosor.addChangeListener(formListener);
        barra_herramientas.add(spinner_grosor);

        boton_rellenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png"))); // NOI18N
        boton_rellenar.setToolTipText("Relleno");
        boton_rellenar.setFocusable(false);
        boton_rellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rellenar.addActionListener(formListener);
        barra_herramientas.add(boton_rellenar);

        boton_transp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/transparencia.png"))); // NOI18N
        boton_transp.setToolTipText("Transparencia");
        boton_transp.setFocusable(false);
        boton_transp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_transp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_transp.addActionListener(formListener);
        barra_herramientas.add(boton_transp);

        boton_alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alisar.png"))); // NOI18N
        boton_alisar.setToolTipText("Alisado de bordes");
        boton_alisar.setFocusable(false);
        boton_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_alisar.addActionListener(formListener);
        barra_herramientas.add(boton_alisar);
        barra_herramientas.add(separador4);

        panel_slider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Brillo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        slider_brillo.setMaximum(255);
        slider_brillo.setMinimum(-255);
        slider_brillo.setToolTipText("Aumento/disminución de brillo");
        slider_brillo.setValue(0);
        slider_brillo.addChangeListener(formListener);
        slider_brillo.addFocusListener(formListener);
        panel_slider.add(slider_brillo);

        barra_herramientas.add(panel_slider);

        panel_desp_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        desplegable_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano", "Media 5x5", "Media 7x7" }));
        desplegable_filtro.setToolTipText("Filtros");
        desplegable_filtro.addActionListener(formListener);
        panel_desp_filtros.add(desplegable_filtro);

        barra_herramientas.add(panel_desp_filtros);

        boton_contraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste.png"))); // NOI18N
        boton_contraste.setToolTipText("Contraste");
        boton_contraste.setFocusable(false);
        boton_contraste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_contraste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_contraste.addActionListener(formListener);
        barra_herramientas.add(boton_contraste);

        boton_iluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iluminar.png"))); // NOI18N
        boton_iluminar.setToolTipText("Contraste con iluminación");
        boton_iluminar.addActionListener(formListener);
        barra_herramientas.add(boton_iluminar);

        boton_oscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/oscurecer.png"))); // NOI18N
        boton_oscurecer.setToolTipText("Contraste con oscurecimiento");
        boton_oscurecer.addActionListener(formListener);
        barra_herramientas.add(boton_oscurecer);

        boton_seno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sinusoidal.png"))); // NOI18N
        boton_seno.setToolTipText("Filtro sinusoidal");
        boton_seno.setFocusable(false);
        boton_seno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_seno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_seno.addActionListener(formListener);
        barra_herramientas.add(boton_seno);

        boton_sepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sepia.png"))); // NOI18N
        boton_sepia.setToolTipText("Sepia");
        boton_sepia.addActionListener(formListener);
        barra_herramientas.add(boton_sepia);

        boton_tintado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tintar.png"))); // NOI18N
        boton_tintado.setToolTipText("Tintado");
        boton_tintado.addActionListener(formListener);
        barra_herramientas.add(boton_tintado);

        boton_ecual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ecualizar.png"))); // NOI18N
        boton_ecual.setToolTipText("Ecualización");
        boton_ecual.addActionListener(formListener);
        barra_herramientas.add(boton_ecual);

        panel_cs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        boton_bandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bandas.png"))); // NOI18N
        boton_bandas.setToolTipText("Extracción de bandas");
        boton_bandas.addActionListener(formListener);
        panel_cs.add(boton_bandas);

        desplegable_cs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sRGB", "PYCC", "GRAY" }));
        desplegable_cs.setToolTipText("Espacios de color");
        desplegable_cs.addActionListener(formListener);
        panel_cs.add(desplegable_cs);

        barra_herramientas.add(panel_cs);

        panel_rotacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        slider_rotacion.setToolTipText("Rotación variable");
        slider_rotacion.setValue(0);
        slider_rotacion.addChangeListener(formListener);
        slider_rotacion.addFocusListener(formListener);
        panel_rotacion.add(slider_rotacion);

        boton_rot90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion90.png"))); // NOI18N
        boton_rot90.setToolTipText("Rotar 90º");
        boton_rot90.setFocusable(false);
        boton_rot90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rot90.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rot90.addActionListener(formListener);
        panel_rotacion.add(boton_rot90);

        boton_rot180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion180.png"))); // NOI18N
        boton_rot180.setToolTipText("Rotar 180º");
        boton_rot180.addActionListener(formListener);
        panel_rotacion.add(boton_rot180);

        boton_rot270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion270.png"))); // NOI18N
        boton_rot270.setToolTipText("Rotar 270º");
        boton_rot270.addActionListener(formListener);
        panel_rotacion.add(boton_rot270);

        barra_herramientas.add(panel_rotacion);

        boton_es_dis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disminuir.png"))); // NOI18N
        boton_es_dis.setToolTipText("Disminuir zoom");
        boton_es_dis.addActionListener(formListener);
        barra_herramientas.add(boton_es_dis);

        boton_es_aum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aumentar.png"))); // NOI18N
        boton_es_aum.setToolTipText("Aumentar zoom");
        boton_es_aum.addActionListener(formListener);
        barra_herramientas.add(boton_es_aum);

        panel_umbral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Umbralización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_umbral.setToolTipText("Nivel de umbralización");

        slider_umbral.setMaximum(255);
        slider_umbral.setValue(0);
        slider_umbral.addChangeListener(formListener);
        slider_umbral.addFocusListener(formListener);
        panel_umbral.add(slider_umbral);

        barra_herramientas.add(panel_umbral);

        getContentPane().add(barra_herramientas, java.awt.BorderLayout.NORTH);

        panel_atr_lienzo.setLayout(new java.awt.BorderLayout());

        panel_atr_generico.setLayout(new java.awt.BorderLayout());

        barra_atr.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        barra_atr.setRollover(true);
        panel_atr_generico.add(barra_atr, java.awt.BorderLayout.SOUTH);

        panel_atr_lienzo.add(panel_atr_generico, java.awt.BorderLayout.SOUTH);
        panel_atr_lienzo.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_atr_lienzo, java.awt.BorderLayout.CENTER);

        menu_edicion.setText("Edición");

        menu_op_barra_est.setSelected(true);
        menu_op_barra_est.setText("Ver barra de estado");
        menu_op_barra_est.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_est);

        menu_op_barra_form.setSelected(true);
        menu_op_barra_form.setText("Ver barra de formas");
        menu_op_barra_form.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_form);

        menu_op_barra_atr.setSelected(true);
        menu_op_barra_atr.setText("Ver barra de atributos");
        menu_op_barra_atr.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_atr);

        barra_menu.add(menu_edicion);

        menu_imagen.setText("Imagen");

        menu_op_rescaleop.setText("RescaleOp");
        menu_op_rescaleop.addActionListener(formListener);
        menu_imagen.add(menu_op_rescaleop);

        menu_op_convolveop.setText("ConvolveOp");
        menu_op_convolveop.addActionListener(formListener);
        menu_imagen.add(menu_op_convolveop);

        menu_op_aftr.setText("AffineTransformOp");
        menu_op_aftr.addActionListener(formListener);
        menu_imagen.add(menu_op_aftr);

        menu_op_lookup.setText("LookUpOp");
        menu_op_lookup.addActionListener(formListener);
        menu_imagen.add(menu_op_lookup);

        menu_op_bandcomb.setText("BandCombineOp");
        menu_op_bandcomb.addActionListener(formListener);
        menu_imagen.add(menu_op_bandcomb);

        menu_op_colorconvert.setText("ColorConvertOp");
        menu_op_colorconvert.addActionListener(formListener);
        menu_imagen.add(menu_op_colorconvert);

        barra_menu.add(menu_imagen);

        setJMenuBar(barra_menu);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == boton_nuevo) {
                VentanaPrincipal.this.boton_nuevoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_abrir) {
                VentanaPrincipal.this.boton_abrirActionPerformed(evt);
            }
            else if (evt.getSource() == boton_guardar) {
                VentanaPrincipal.this.boton_guardarActionPerformed(evt);
            }
            else if (evt.getSource() == boton_punto) {
                VentanaPrincipal.this.boton_puntoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_linea) {
                VentanaPrincipal.this.boton_lineaActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rectangulo) {
                VentanaPrincipal.this.boton_rectanguloActionPerformed(evt);
            }
            else if (evt.getSource() == boton_elipse) {
                VentanaPrincipal.this.boton_elipseActionPerformed(evt);
            }
            else if (evt.getSource() == boton_seleccion) {
                VentanaPrincipal.this.boton_seleccionActionPerformed(evt);
            }
            else if (evt.getSource() == desplegable_color) {
                VentanaPrincipal.this.desplegable_colorActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rellenar) {
                VentanaPrincipal.this.boton_rellenarActionPerformed(evt);
            }
            else if (evt.getSource() == boton_transp) {
                VentanaPrincipal.this.boton_transpActionPerformed(evt);
            }
            else if (evt.getSource() == boton_alisar) {
                VentanaPrincipal.this.boton_alisarActionPerformed(evt);
            }
            else if (evt.getSource() == desplegable_filtro) {
                VentanaPrincipal.this.desplegable_filtroActionPerformed(evt);
            }
            else if (evt.getSource() == boton_contraste) {
                VentanaPrincipal.this.boton_contrasteActionPerformed(evt);
            }
            else if (evt.getSource() == boton_iluminar) {
                VentanaPrincipal.this.boton_iluminarActionPerformed(evt);
            }
            else if (evt.getSource() == boton_oscurecer) {
                VentanaPrincipal.this.boton_oscurecerActionPerformed(evt);
            }
            else if (evt.getSource() == boton_seno) {
                VentanaPrincipal.this.boton_senoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_sepia) {
                VentanaPrincipal.this.boton_sepiaActionPerformed(evt);
            }
            else if (evt.getSource() == boton_tintado) {
                VentanaPrincipal.this.boton_tintadoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_ecual) {
                VentanaPrincipal.this.boton_ecualActionPerformed(evt);
            }
            else if (evt.getSource() == boton_bandas) {
                VentanaPrincipal.this.boton_bandasActionPerformed(evt);
            }
            else if (evt.getSource() == desplegable_cs) {
                VentanaPrincipal.this.desplegable_csActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rot90) {
                VentanaPrincipal.this.boton_rot90ActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rot180) {
                VentanaPrincipal.this.boton_rot180ActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rot270) {
                VentanaPrincipal.this.boton_rot270ActionPerformed(evt);
            }
            else if (evt.getSource() == boton_es_aum) {
                VentanaPrincipal.this.boton_es_aumActionPerformed(evt);
            }
            else if (evt.getSource() == boton_es_dis) {
                VentanaPrincipal.this.boton_es_disActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_est) {
                VentanaPrincipal.this.menu_op_barra_estActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_form) {
                VentanaPrincipal.this.menu_op_barra_formActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_atr) {
                VentanaPrincipal.this.menu_op_barra_atrActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_rescaleop) {
                VentanaPrincipal.this.menu_op_rescaleopActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_convolveop) {
                VentanaPrincipal.this.menu_op_convolveopActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_aftr) {
                VentanaPrincipal.this.menu_op_aftrActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_lookup) {
                VentanaPrincipal.this.menu_op_lookupActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_bandcomb) {
                VentanaPrincipal.this.menu_op_bandcombActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_colorconvert) {
                VentanaPrincipal.this.menu_op_colorconvertActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == slider_brillo) {
                VentanaPrincipal.this.slider_brilloFocusGained(evt);
            }
            else if (evt.getSource() == slider_rotacion) {
                VentanaPrincipal.this.slider_rotacionFocusGained(evt);
            }
            else if (evt.getSource() == slider_umbral) {
                VentanaPrincipal.this.slider_umbralFocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == slider_brillo) {
                VentanaPrincipal.this.slider_brilloFocusLost(evt);
            }
            else if (evt.getSource() == slider_rotacion) {
                VentanaPrincipal.this.slider_rotacionFocusLost(evt);
            }
            else if (evt.getSource() == slider_umbral) {
                VentanaPrincipal.this.slider_umbralFocusLost(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == spinner_grosor) {
                VentanaPrincipal.this.spinner_grosorStateChanged(evt);
            }
            else if (evt.getSource() == slider_brillo) {
                VentanaPrincipal.this.slider_brilloStateChanged(evt);
            }
            else if (evt.getSource() == slider_rotacion) {
                VentanaPrincipal.this.slider_rotacionStateChanged(evt);
            }
            else if (evt.getSource() == slider_umbral) {
                VentanaPrincipal.this.slider_umbralStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void menu_op_barra_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_estActionPerformed
        this.panel_estado.setVisible(!this.panel_estado.isVisible());
    }//GEN-LAST:event_menu_op_barra_estActionPerformed

    private void menu_op_barra_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_formActionPerformed
        this.barra_herramientas.setVisible(!this.barra_herramientas.isVisible());
    }//GEN-LAST:event_menu_op_barra_formActionPerformed

    private void menu_op_barra_atrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_atrActionPerformed
        this.barra_atr.setVisible(!this.barra_atr.isVisible());
    }//GEN-LAST:event_menu_op_barra_atrActionPerformed

    private void boton_puntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_puntoActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.PUNTOS);
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        }
        
        this.etiq_estado.setText("Punto");
    }//GEN-LAST:event_boton_puntoActionPerformed

    private void boton_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_lineaActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.LINEAS);
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        }
        
        this.etiq_estado.setText("Línea");
    }//GEN-LAST:event_boton_lineaActionPerformed

    private void boton_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rectanguloActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.RECTANGULOS);
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        }
        
        this.etiq_estado.setText("Rectángulo");
    }//GEN-LAST:event_boton_rectanguloActionPerformed

    private void boton_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elipseActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.ELIPSES);
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        }
        
        this.etiq_estado.setText("Elipse");
    }//GEN-LAST:event_boton_elipseActionPerformed

    private void boton_seleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_seleccionActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(boton_seleccion.isSelected());
        
        this.etiq_estado.setText("Moviendo figura");
    }//GEN-LAST:event_boton_seleccionActionPerformed

    private void spinner_grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_grosorStateChanged
        Stroke grosor = new BasicStroke((int)spinner_grosor.getValue());
        
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTrazo(grosor);
    }//GEN-LAST:event_spinner_grosorStateChanged

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        VentanaInterna vi = new VentanaInterna();
        escritorio.add(vi);
        vi.setVisible(true);
        
        BufferedImage img;
        img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        img.getGraphics().fillRect(0, 0, img.getWidth(), img.getHeight());
        ((LienzoImagen2D)(vi.getLienzo())).setImagen(img);
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_abrirActionPerformed
        FileFilter jpg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        FileFilter png = new FileNameExtensionFilter("PNG file", "png");
        JFileChooser dlg = new JFileChooser();
        dlg.addChoosableFileFilter(jpg);
        dlg.addChoosableFileFilter(png);
        int resp = dlg.showOpenDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION) {
            try {
                File f = dlg.getSelectedFile();
                
                String[] formatos = ImageIO.getReaderFormatNames();
                boolean encontrado = false;
                int i = 0;
                
                while(i<formatos.length && !encontrado){
                    if(formatos[i].equals("jpg") || formatos[i].equals("png"))
                        encontrado = true;
                    
                    i++;
                }
                
                if(encontrado){
                    BufferedImage img = ImageIO.read(f);
                    VentanaInterna vi = new VentanaInterna();
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(img);
                    this.escritorio.add(vi);
                    vi.setTitle(f.getName());
                    vi.setVisible(true);
                }
                
                else
                    System.err.println("Formato no soportado");
            }catch(Exception e){
                System.err.println("Error al leer la imagen");
            }
        }
    }//GEN-LAST:event_boton_abrirActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        VentanaInterna vi = (VentanaInterna) escritorio.getSelectedFrame();
        if(vi != null){
            FileFilter jpg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
            FileFilter png = new FileNameExtensionFilter("PNG file", "png");
            JFileChooser dlg = new JFileChooser();
            dlg.addChoosableFileFilter(jpg);
            dlg.addChoosableFileFilter(png);
            int resp = dlg.showSaveDialog(this);
            if(resp == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage img = ((LienzoImagen2D)(vi.getLienzo())).getImagen(true);
                    if(img != null){
                        File f = dlg.getSelectedFile();
                        String[] formatos = ImageIO.getWriterFormatNames();
                        boolean encontrado = false;
                        int i = 0;
                        String extension = f.getPath().substring(f.getPath().lastIndexOf("."));

                        while(i<formatos.length && !encontrado){
                            if(formatos[i].equals("jpg") || formatos[i].equals("png"))
                                encontrado = true;
                            
                            i++;
                        }

                        if(encontrado){
                            if(extension.equals(".jpg"))
                                ImageIO.write(img, "jpg", f);

                            else if(extension.equals(".png"))
                                ImageIO.write(img, "png", f);

                            vi.setTitle(f.getName());
                        }
                        
                        else
                            System.out.println("Formato no soportado");
                    }
                }catch(Exception e){
                    System.err.print(e);
                    System.err.println("Error al guardar la imagen");
                }
            }
        }
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_rellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rellenarActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setRelleno(boton_rellenar.isSelected());
    }//GEN-LAST:event_boton_rellenarActionPerformed

    private void boton_transpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_transpActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTransparencia(boton_transp.isSelected());
    }//GEN-LAST:event_boton_transpActionPerformed

    private void boton_alisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alisarActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setAlisar(boton_alisar.isSelected());
    }//GEN-LAST:event_boton_alisarActionPerformed

    private void menu_op_rescaleopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_rescaleopActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    RescaleOp rop = new RescaleOp(1.0f, 100.0f, null);
                    
                    rop.filter(img_source, img_source);
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_menu_op_rescaleopActionPerformed

    private void menu_op_convolveopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_convolveopActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    float data[] = {0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
                    Kernel k = new Kernel(3, 3, data);
                    ConvolveOp cop = new ConvolveOp(k);
                    BufferedImage dest = cop.filter(img_source, null);
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_menu_op_convolveopActionPerformed

    private void slider_brilloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_brilloFocusGained
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            ColorModel cm = ((LienzoImagen2D)(vi.getLienzo())).getImagen().getColorModel();
            WritableRaster raster = ((LienzoImagen2D)(vi.getLienzo())).getImagen().copyData(null);
            boolean alfa_pre = ((LienzoImagen2D)(vi.getLienzo())).getImagen().isAlphaPremultiplied();
            img_aux = new BufferedImage(cm, raster, alfa_pre, null);
        }
    }//GEN-LAST:event_slider_brilloFocusGained

    private void slider_brilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_brilloFocusLost
        img_aux = null;
        slider_brillo.setValue(0);
    }//GEN-LAST:event_slider_brilloFocusLost

    private void slider_brilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_brilloStateChanged
        VentanaInterna vi = ((VentanaInterna)(escritorio.getSelectedFrame()));
        
        if(vi != null){
            if(img_aux != null){
                try{
                    float[] color = {1.0f, 1.0f, 1.0f, 0.0f};
                    float[] offset = {(float)slider_brillo.getValue(), (float)slider_brillo.getValue(), (float)slider_brillo.getValue(), (float)slider_brillo.getValue()};
                    
                    RescaleOp rop = new RescaleOp(color, offset, null);

                    rop.filter(img_aux, ((LienzoImagen2D)(vi.getLienzo())).getImagen());
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_slider_brilloStateChanged

    private void desplegable_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_filtroActionPerformed
        String opcion = String.valueOf(desplegable_filtro.getSelectedItem());
        float data[] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float data5[] = new float[25];
        float data7[] = new float[49];
        Kernel k = new Kernel(3, 3, data);
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            switch(opcion){
                case "Media":
                    k = KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
                    break;
                case "Binomial":
                    k = KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
                    break;
                case "Enfoque":
                    k = KernelProducer.createKernel(KernelProducer.TYPE_ENFOQUE_3x3);
                    break;
                case "Relieve":
                    k = KernelProducer.createKernel(KernelProducer.TYPE_RELIEVE_3x3);
                    break;
                case "Laplaciano":
                    k = KernelProducer.createKernel(KernelProducer.TYPE_LAPLACIANA_3x3);
                    break;
                case "Media 5x5":
                    for(int i=0; i<25; i++)
                        data5[i] = 0.04f;
                    k = new Kernel(5, 5, data5);
                    break;
                case "Media 7x7":
                    for(int i=0; i<49; i++)
                        data7[i] = 0.02f;
                    k = new Kernel(7, 7, data7);
                    break;
            }

            ConvolveOp cop = new ConvolveOp(k, ConvolveOp.EDGE_NO_OP, null);
            BufferedImage dest = cop.filter(img_source, null);
            ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
            vi.repaint();
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_desplegable_filtroActionPerformed

    private void menu_op_aftrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_aftrActionPerformed
        this.Escalado(1.25f);
    }//GEN-LAST:event_menu_op_aftrActionPerformed

    private void menu_op_lookupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_lookupActionPerformed
        EjecutarContraste(LookupTableProducer.TYPE_SFUNCION);
    }//GEN-LAST:event_menu_op_lookupActionPerformed

    private void boton_rot90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rot90ActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                BufferedImage dest = new BufferedImage(img_source.getHeight(), img_source.getWidth(), img_source.getType());
                Rotacion(90, dest);
            }
        }
    }//GEN-LAST:event_boton_rot90ActionPerformed

    private void boton_rot180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rot180ActionPerformed
        Rotacion(180, null);
    }//GEN-LAST:event_boton_rot180ActionPerformed

    private void boton_es_aumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_es_aumActionPerformed
        this.Escalado(1.25f);
    }//GEN-LAST:event_boton_es_aumActionPerformed

    private void boton_es_disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_es_disActionPerformed
        this.Escalado(0.75f);
    }//GEN-LAST:event_boton_es_disActionPerformed

    private void boton_contrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_contrasteActionPerformed
        EjecutarContraste(LookupTableProducer.TYPE_SFUNCION);
    }//GEN-LAST:event_boton_contrasteActionPerformed

    private void boton_iluminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_iluminarActionPerformed
        EjecutarContraste(LookupTableProducer.TYPE_LOGARITHM);
    }//GEN-LAST:event_boton_iluminarActionPerformed

    private void boton_oscurecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_oscurecerActionPerformed
        EjecutarContraste(LookupTableProducer.TYPE_POWER);
    }//GEN-LAST:event_boton_oscurecerActionPerformed

    private void boton_senoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_senoActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    LookupTable lut = seno(180.0/255.0);
                    LookupOp luop = new LookupOp(lut, null);
                    luop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_boton_senoActionPerformed

    private void boton_rot270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rot270ActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                BufferedImage dest = new BufferedImage(img_source.getHeight(), img_source.getWidth(), img_source.getType());
                Rotacion(270, dest);
            }
        }
    }//GEN-LAST:event_boton_rot270ActionPerformed

    private void slider_rotacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_rotacionFocusGained
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            ColorModel cm = ((LienzoImagen2D)(vi.getLienzo())).getImagen().getColorModel();
            WritableRaster raster = ((LienzoImagen2D)(vi.getLienzo())).getImagen().copyData(null);
            boolean alfa_pre = ((LienzoImagen2D)(vi.getLienzo())).getImagen().isAlphaPremultiplied();
            img_aux = new BufferedImage(cm, raster, alfa_pre, null);
        }
    }//GEN-LAST:event_slider_rotacionFocusGained

    private void slider_rotacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_rotacionFocusLost
        img_aux = null;
        slider_rotacion.setValue(0);
    }//GEN-LAST:event_slider_rotacionFocusLost

    private void slider_rotacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_rotacionStateChanged
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = img_aux;
            if(img_source != null){
                try{
                    double r = Math.toRadians(slider_rotacion.getValue());
                    Point c = new Point(img_aux.getWidth()/2, img_aux.getHeight()/2);
                    AffineTransform at = AffineTransform.getRotateInstance(r, c.x, c.y);
                    AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage dest = atop.filter(img_source, null);
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_slider_rotacionStateChanged

    private void desplegable_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_colorActionPerformed
        if((VentanaInterna)(this.escritorio.getSelectedFrame()) != null)
        {
            Color col = this.desplegable_color.getItemAt(this.desplegable_color.getSelectedIndex());
            ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(col);
        }
    }//GEN-LAST:event_desplegable_colorActionPerformed

    private void menu_op_bandcombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_bandcombActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
                
                for(int i=0; i<3; i++){
                    VentanaInterna ventana = new VentanaInterna();
                    int band_list[] = {i};
                    WritableRaster band_raster = (WritableRaster)img_source.getRaster().createWritableChild(0, 0, img_source.getWidth(), img_source.getHeight(), 0, 0, band_list);
                    
                    BufferedImage img_banda = new BufferedImage(cm, band_raster, false, null);
                    ((LienzoImagen2D)(ventana.getLienzo())).setImagen(img_banda);
                    
                    escritorio.add(ventana);
                    ventana.setVisible(true);
                    ventana.setTitle("Banda " + i);
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_menu_op_bandcombActionPerformed

    private void menu_op_colorconvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_colorconvertActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                if(img_source.getColorModel().getColorSpace().isCS_sRGB()){
                    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                    ColorConvertOp cop = new ColorConvertOp(cs, null);
                    
                    BufferedImage dest = cop.filter(img_source, null);
                    
                    VentanaInterna ventana = new VentanaInterna();
                    ((LienzoImagen2D)(ventana.getLienzo())).setImagen(dest);
                    escritorio.add(ventana);
                    ventana.setVisible(true);
                    ventana.setTitle("[YCC]");
                    
                    RepintarEscritorio();
                }
            }
        }
    }//GEN-LAST:event_menu_op_colorconvertActionPerformed

    private void boton_bandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_bandasActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
                
                int tope = 3;
                
                if(EsGray(img_source))
                    tope = 1;
                
                for(int i=0; i<tope; i++){
                    VentanaInterna ventana = new VentanaInterna();
                    int band_list[] = {i};
                    WritableRaster band_raster = (WritableRaster)img_source.getRaster().createWritableChild(0, 0, img_source.getWidth(), img_source.getHeight(), 0, 0, band_list);
                    
                    BufferedImage img_banda = new BufferedImage(cm, band_raster, false, null);
                    ((LienzoImagen2D)(ventana.getLienzo())).setImagen(img_banda);
                    
                    escritorio.add(ventana);
                    ventana.setVisible(true);
                    ventana.setTitle("Banda " + i);
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_boton_bandasActionPerformed

    private void desplegable_csActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_csActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                String opcion = String.valueOf(desplegable_cs.getSelectedItem());
                System.out.print(opcion);
                
                switch(opcion){
                    case "sRGB":
                        if(EsYCC(img_source)){
                            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                            ColorConvertOp cop = new ColorConvertOp(cs, null);

                            BufferedImage dest = cop.filter(img_source, null);

                            VentanaInterna ventana = new VentanaInterna();
                            ((LienzoImagen2D)(ventana.getLienzo())).setImagen(dest);
                            escritorio.add(ventana);
                            ventana.setVisible(true);
                            ventana.setTitle("[sRGB]");
                        }
                        break;
                    case "PYCC":
                        if(EsRGB(img_source)){
                            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                            ColorConvertOp cop = new ColorConvertOp(cs, null);

                            BufferedImage dest = cop.filter(img_source, null);

                            VentanaInterna ventana = new VentanaInterna();
                            ((LienzoImagen2D)(ventana.getLienzo())).setImagen(dest);
                            escritorio.add(ventana);
                            ventana.setVisible(true);
                            ventana.setTitle("[YCC]");
                        }
                        break;
                    case "GRAY":
                        if(EsRGB(img_source) || EsYCC(img_source)){
                            ColorSpace cs = new sm.image.color.GreyColorSpace();
                            ColorConvertOp cop = new ColorConvertOp(cs, null);

                            BufferedImage dest = cop.filter(img_source, null);

                            VentanaInterna ventana = new VentanaInterna();
                            ((LienzoImagen2D)(ventana.getLienzo())).setImagen(dest);
                            escritorio.add(ventana);
                            ventana.setVisible(true);
                            ventana.setTitle("[GRAY]");
                        }
                        break;
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_desplegable_csActionPerformed

    private void boton_sepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_sepiaActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    SepiaOp sop = new SepiaOp();
                    sop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_boton_sepiaActionPerformed

    private void boton_tintadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_tintadoActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    TintOp top = new TintOp(this.desplegable_color.getItemAt(this.desplegable_color.getSelectedIndex()), 0.5f);
                    top.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_boton_tintadoActionPerformed

    private void boton_ecualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ecualActionPerformed
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    if(!EsYCC(img_source)){
                        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                        ColorConvertOp cop = new ColorConvertOp(cs, null);

                        img_source = cop.filter(img_source, null);
                        ((LienzoImagen2D)(vi.getLienzo())).setImagen(img_source);
                    }
                    
                    EqualizationOp eqop = new EqualizationOp();
                    eqop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_boton_ecualActionPerformed

    private void slider_umbralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_umbralFocusGained
        VentanaInterna vi = (VentanaInterna)(escritorio.getSelectedFrame());
        
        if(vi != null){
            ColorModel cm = ((LienzoImagen2D)(vi.getLienzo())).getImagen().getColorModel();
            WritableRaster raster = ((LienzoImagen2D)(vi.getLienzo())).getImagen().copyData(null);
            boolean alfa_pre = ((LienzoImagen2D)(vi.getLienzo())).getImagen().isAlphaPremultiplied();
            img_aux = new BufferedImage(cm, raster, alfa_pre, null);
        }
    }//GEN-LAST:event_slider_umbralFocusGained

    private void slider_umbralFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_umbralFocusLost
        img_aux = null;
        slider_umbral.setValue(0);
    }//GEN-LAST:event_slider_umbralFocusLost

    private void slider_umbralStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_umbralStateChanged
        VentanaInterna vi = ((VentanaInterna)(escritorio.getSelectedFrame()));
        
        if(vi != null){
            if(img_aux != null){
                try{
                    UmbralizacionOp uop = new UmbralizacionOp(slider_umbral.getValue());

                    BufferedImage dest = uop.filter(img_aux, null);
                    ((LienzoImagen2D)(vi.getLienzo())).setImagen(dest);
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_slider_umbralStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barra_atr;
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JToggleButton boton_abrir;
    private javax.swing.JToggleButton boton_alisar;
    private javax.swing.JButton boton_bandas;
    private javax.swing.JButton boton_contraste;
    private javax.swing.JButton boton_ecual;
    private javax.swing.JToggleButton boton_elipse;
    private javax.swing.JButton boton_es_aum;
    private javax.swing.JButton boton_es_dis;
    private javax.swing.JToggleButton boton_guardar;
    private javax.swing.JButton boton_iluminar;
    private javax.swing.JToggleButton boton_linea;
    private javax.swing.JToggleButton boton_nuevo;
    private javax.swing.JButton boton_oscurecer;
    private javax.swing.JToggleButton boton_punto;
    private javax.swing.JToggleButton boton_rectangulo;
    private javax.swing.JToggleButton boton_rellenar;
    private javax.swing.JButton boton_rot180;
    private javax.swing.JButton boton_rot270;
    private javax.swing.JButton boton_rot90;
    private javax.swing.JToggleButton boton_seleccion;
    private javax.swing.JButton boton_seno;
    private javax.swing.JButton boton_sepia;
    private javax.swing.JButton boton_tintado;
    private javax.swing.JToggleButton boton_transp;
    private javax.swing.JComboBox<Color> desplegable_color;
    private javax.swing.JComboBox<String> desplegable_cs;
    private javax.swing.JComboBox<String> desplegable_filtro;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel etiq_estado;
    private javax.swing.ButtonGroup grupo_colores;
    private javax.swing.ButtonGroup grupo_herramientas;
    private javax.swing.JMenu menu_edicion;
    private javax.swing.JMenu menu_imagen;
    private javax.swing.JMenuItem menu_op_aftr;
    private javax.swing.JMenuItem menu_op_bandcomb;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_atr;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_est;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_form;
    private javax.swing.JMenuItem menu_op_colorconvert;
    private javax.swing.JMenuItem menu_op_convolveop;
    private javax.swing.JMenuItem menu_op_lookup;
    private javax.swing.JMenuItem menu_op_rescaleop;
    private javax.swing.JPanel panel_atr_generico;
    private javax.swing.JPanel panel_atr_lienzo;
    private javax.swing.JPanel panel_cs;
    private javax.swing.JPanel panel_desp_filtros;
    private javax.swing.JPanel panel_estado;
    private javax.swing.JPanel panel_rotacion;
    private javax.swing.JPanel panel_slider;
    private javax.swing.JPanel panel_umbral;
    private javax.swing.JToolBar.Separator separador1;
    private javax.swing.JToolBar.Separator separador2;
    private javax.swing.JToolBar.Separator separador3;
    private javax.swing.JToolBar.Separator separador4;
    private javax.swing.JSlider slider_brillo;
    private javax.swing.JSlider slider_rotacion;
    private javax.swing.JSlider slider_umbral;
    private javax.swing.JSpinner spinner_grosor;
    // End of variables declaration//GEN-END:variables
    private BufferedImage img_aux;
}
