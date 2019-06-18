/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;
import sm.nrg.graficos.*;
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
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import sm.image.BlendOp;
import sm.image.EqualizationOp;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.image.SubtractionOp;
import sm.image.TintOp;
import sm.nrg.image.RayosXOp;
import sm.nrg.iu.*;
import sm.nrg.image.SepiaOp;
import sm.nrg.image.TermalOp;
import sm.nrg.image.UmbralizacionOp;
import sm.sound.SMClipPlayer;
import sm.sound.SMPlayer;
import sm.sound.SMRecorder;
import sm.sound.SMSoundPlayerRecorder;
import sm.sound.SMSoundRecorder;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

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
        
        boton_stop.setVisible(false);
        boton_pausa.setVisible(false);
        boton_stop_record.setVisible(false);
        this.setSize(1200, 1000);   
    }
    
    private void Escalado(float escalado){
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
    
    private LookupTable FuncionPropia(double w){
        byte data[] = new byte[256];
        double K = 255.0;
        double f;
        
        for(int i=0; i<256; i++){ 
            f = (Math.abs(Math.pow(i, 3)+(Math.abs(Math.cos(Math.toRadians(i*w))))+1))%255;
            data[i] = (byte)f;
        }
        
        ByteLookupTable t = new ByteLookupTable(0, data);
        return t;
    }
    
    private void RepintarEscritorio(){
        for(JInternalFrame infr: escritorio.getAllFrames())
                ((VentanaInternaLienzo)infr).getLienzo().repaint();
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
     * Manejador de eventos de vídeo
     */
    
    private class VideoListener extends MediaPlayerEventAdapter{
        @Override
        public void playing(MediaPlayer media_player){
            boton_play.setVisible(false);
            boton_stop.setVisible(true);
        }
        
        @Override
        public void paused(MediaPlayer media_player){
            boton_play.setVisible(true);
            boton_stop.setVisible(false);
        }
        
        @Override
        public void finished(MediaPlayer media_player){
            this.paused(media_player);
        }
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
        panel_atr_lienzo = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        panel_deslizador_herramientas = new javax.swing.JScrollPane();
        barra_herramientas = new javax.swing.JToolBar();
        boton_nuevo = new javax.swing.JButton();
        boton_abrir = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        separador1 = new javax.swing.JToolBar.Separator();
        barra_herramientas_dibujo = new javax.swing.JToolBar();
        boton_linea = new javax.swing.JToggleButton();
        boton_rectangulo = new javax.swing.JToggleButton();
        boton_elipse = new javax.swing.JToggleButton();
        boton_rectangulo_red = new javax.swing.JToggleButton();
        boton_curva = new javax.swing.JToggleButton();
        separador2 = new javax.swing.JToolBar.Separator();
        Color c[]={Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN};
        desplegable_color = new javax.swing.JComboBox<>(c);
        separador3 = new javax.swing.JToolBar.Separator();
        spinner_grosor = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        boton_rellenar = new javax.swing.JToggleButton();
        boton_transp = new javax.swing.JToggleButton();
        boton_alisar = new javax.swing.JToggleButton();
        separador4 = new javax.swing.JToolBar.Separator();
        barra_herramientas_imagen = new javax.swing.JToolBar();
        boton_duplicar_img = new javax.swing.JButton();
        panel_slider = new javax.swing.JPanel();
        slider_brillo = new javax.swing.JSlider();
        panel_desp_filtros = new javax.swing.JPanel();
        desplegable_filtro = new javax.swing.JComboBox<>();
        boton_contraste = new javax.swing.JButton();
        boton_iluminar = new javax.swing.JButton();
        boton_oscurecer = new javax.swing.JButton();
        boton_funcion = new javax.swing.JButton();
        boton_sepia = new javax.swing.JButton();
        panel_tinte = new javax.swing.JPanel();
        boton_tintado = new javax.swing.JButton();
        slider_tinte = new javax.swing.JSlider();
        boton_ecual = new javax.swing.JButton();
        boton_negativo = new javax.swing.JButton();
        boton_rayos_x = new javax.swing.JButton();
        boton_termal = new javax.swing.JButton();
        boton_suma_img = new javax.swing.JButton();
        boton_resta_img = new javax.swing.JButton();
        panel_cs = new javax.swing.JPanel();
        boton_bandas = new javax.swing.JButton();
        desplegable_cs = new javax.swing.JComboBox<>();
        panel_rotacion = new javax.swing.JPanel();
        slider_rotacion = new javax.swing.JSlider();
        boton_es_aum = new javax.swing.JButton();
        boton_es_dis = new javax.swing.JButton();
        panel_umbral = new javax.swing.JPanel();
        slider_umbral = new javax.swing.JSlider();
        separador5 = new javax.swing.JToolBar.Separator();
        barra_herramientas_rep = new javax.swing.JToolBar();
        desplegable_reprod = new javax.swing.JComboBox<>();
        boton_play = new javax.swing.JButton();
        boton_pausa = new javax.swing.JButton();
        boton_stop = new javax.swing.JButton();
        boton_record = new javax.swing.JButton();
        boton_stop_record = new javax.swing.JButton();
        etiq_temp_record = new javax.swing.JLabel();
        boton_webcam = new javax.swing.JButton();
        boton_captura = new javax.swing.JButton();
        barra_menu = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_op_nuevo = new javax.swing.JMenuItem();
        menu_op_abrir_imagen = new javax.swing.JMenuItem();
        menu_op_guardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_op_abrir_audio = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menu_op_abrir_video = new javax.swing.JMenuItem();
        menu_edicion = new javax.swing.JMenu();
        menu_op_barra_est = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_form = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_dibujo = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_imagen = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_rep = new javax.swing.JCheckBoxMenuItem();
        menu_ayuda = new javax.swing.JMenu();
        menu_op_acerca = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panel_estado.setLayout(flowLayout1);

        etiq_estado.setText("Punto");
        panel_estado.add(etiq_estado);

        getContentPane().add(panel_estado, java.awt.BorderLayout.SOUTH);

        panel_atr_lienzo.setLayout(new java.awt.BorderLayout());
        panel_atr_lienzo.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_atr_lienzo, java.awt.BorderLayout.CENTER);

        panel_deslizador_herramientas.setPreferredSize(new java.awt.Dimension(100, 110));

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

        barra_herramientas_dibujo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barra_herramientas_dibujo.setRollover(true);

        grupo_herramientas.add(boton_linea);
        boton_linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        boton_linea.setToolTipText("Pincel líneas");
        boton_linea.setFocusable(false);
        boton_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_linea.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_linea);

        grupo_herramientas.add(boton_rectangulo);
        boton_rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        boton_rectangulo.setToolTipText("Pincel rectángulos");
        boton_rectangulo.setFocusable(false);
        boton_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rectangulo.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_rectangulo);

        grupo_herramientas.add(boton_elipse);
        boton_elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        boton_elipse.setToolTipText("Pincel elipses");
        boton_elipse.setFocusable(false);
        boton_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_elipse.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_elipse);

        grupo_herramientas.add(boton_rectangulo_red);
        boton_rectangulo_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo_red.png"))); // NOI18N
        boton_rectangulo_red.setToolTipText("Pincel rectángulo redondeado");
        boton_rectangulo_red.setFocusable(false);
        boton_rectangulo_red.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo_red.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas_dibujo.add(boton_rectangulo_red);

        grupo_herramientas.add(boton_curva);
        boton_curva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/curva1p.png"))); // NOI18N
        boton_curva.setToolTipText("Pincel curva con un punto de control");
        boton_curva.setFocusable(false);
        boton_curva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_curva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas_dibujo.add(boton_curva);
        barra_herramientas_dibujo.add(separador2);

        desplegable_color.setToolTipText("Colores");
        desplegable_color.setPreferredSize(new java.awt.Dimension(58, 45));
        desplegable_color.setRenderer(new ColorRender());
        desplegable_color.addActionListener(formListener);
        barra_herramientas_dibujo.add(desplegable_color);
        barra_herramientas_dibujo.add(separador3);

        spinner_grosor.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinner_grosor.setToolTipText("Grosor pincel");
        spinner_grosor.addChangeListener(formListener);
        barra_herramientas_dibujo.add(spinner_grosor);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Continuo", "Discontinuo", "Punteado" }));
        jComboBox1.addActionListener(formListener);
        barra_herramientas_dibujo.add(jComboBox1);

        boton_rellenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/relleno.png"))); // NOI18N
        boton_rellenar.setToolTipText("Relleno");
        boton_rellenar.setFocusable(false);
        boton_rellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rellenar.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_rellenar);

        boton_transp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/transparencia.png"))); // NOI18N
        boton_transp.setToolTipText("Transparencia");
        boton_transp.setFocusable(false);
        boton_transp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_transp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_transp.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_transp);

        boton_alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alisar.png"))); // NOI18N
        boton_alisar.setToolTipText("Alisado de bordes");
        boton_alisar.setFocusable(false);
        boton_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_alisar.addActionListener(formListener);
        barra_herramientas_dibujo.add(boton_alisar);

        barra_herramientas.add(barra_herramientas_dibujo);
        barra_herramientas.add(separador4);

        barra_herramientas_imagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barra_herramientas_imagen.setRollover(true);

        boton_duplicar_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/duplicar.png"))); // NOI18N
        boton_duplicar_img.setToolTipText("Duplicar imagen");
        boton_duplicar_img.setFocusable(false);
        boton_duplicar_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_duplicar_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_duplicar_img.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_duplicar_img);

        panel_slider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Brillo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        slider_brillo.setMaximum(255);
        slider_brillo.setMinimum(-255);
        slider_brillo.setToolTipText("Aumento/disminución de brillo");
        slider_brillo.setValue(0);
        slider_brillo.addChangeListener(formListener);
        slider_brillo.addFocusListener(formListener);
        panel_slider.add(slider_brillo);

        barra_herramientas_imagen.add(panel_slider);

        panel_desp_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        desplegable_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano", "Media 5x5", "Media 7x7" }));
        desplegable_filtro.setToolTipText("Filtros");
        desplegable_filtro.addActionListener(formListener);
        panel_desp_filtros.add(desplegable_filtro);

        barra_herramientas_imagen.add(panel_desp_filtros);

        boton_contraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste.png"))); // NOI18N
        boton_contraste.setToolTipText("Contraste");
        boton_contraste.setFocusable(false);
        boton_contraste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_contraste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_contraste.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_contraste);

        boton_iluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste_ilu.png"))); // NOI18N
        boton_iluminar.setToolTipText("Contraste con iluminación");
        boton_iluminar.setFocusable(false);
        boton_iluminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_iluminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_iluminar.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_iluminar);

        boton_oscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste_osc.png"))); // NOI18N
        boton_oscurecer.setToolTipText("Contraste con oscurecimiento");
        boton_oscurecer.setFocusable(false);
        boton_oscurecer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_oscurecer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_oscurecer.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_oscurecer);

        boton_funcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/funcion.png"))); // NOI18N
        boton_funcion.setToolTipText("Filtro función=(x^3+sin(xw)+1)%255)");
        boton_funcion.setFocusable(false);
        boton_funcion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_funcion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_funcion.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_funcion);

        boton_sepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sepia.png"))); // NOI18N
        boton_sepia.setToolTipText("Sepia");
        boton_sepia.setFocusable(false);
        boton_sepia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_sepia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_sepia.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_sepia);

        panel_tinte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tintado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        boton_tintado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tinte.png"))); // NOI18N
        boton_tintado.setToolTipText("Tintado");
        boton_tintado.addActionListener(formListener);
        panel_tinte.add(boton_tintado);

        slider_tinte.setToolTipText("Deslizador de tinte");
        slider_tinte.addChangeListener(formListener);
        slider_tinte.addFocusListener(formListener);
        panel_tinte.add(slider_tinte);

        barra_herramientas_imagen.add(panel_tinte);

        boton_ecual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ecualizacion.png"))); // NOI18N
        boton_ecual.setToolTipText("Ecualización");
        boton_ecual.setFocusable(false);
        boton_ecual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_ecual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_ecual.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_ecual);

        boton_negativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/negativo.png"))); // NOI18N
        boton_negativo.setToolTipText("Negativo");
        boton_negativo.setFocusable(false);
        boton_negativo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_negativo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_negativo.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_negativo);

        boton_rayos_x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rayos_x.png"))); // NOI18N
        boton_rayos_x.setToolTipText("Filtro rayos X");
        boton_rayos_x.setFocusable(false);
        boton_rayos_x.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rayos_x.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rayos_x.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_rayos_x);

        boton_termal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/termal.png"))); // NOI18N
        boton_termal.setToolTipText("Filtro termal");
        boton_termal.setFocusable(false);
        boton_termal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_termal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_termal.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_termal);

        boton_suma_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/suma_img.png"))); // NOI18N
        boton_suma_img.setToolTipText("Sumar imágenes");
        boton_suma_img.setFocusable(false);
        boton_suma_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_suma_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_suma_img.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_suma_img);

        boton_resta_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/resta_img.png"))); // NOI18N
        boton_resta_img.setToolTipText("Restar imágenes");
        boton_resta_img.setFocusable(false);
        boton_resta_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_resta_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_resta_img.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_resta_img);

        panel_cs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        boton_bandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bandas.png"))); // NOI18N
        boton_bandas.setToolTipText("Extracción de bandas");
        boton_bandas.addActionListener(formListener);
        panel_cs.add(boton_bandas);

        desplegable_cs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sRGB", "PYCC", "GRAY" }));
        desplegable_cs.setToolTipText("Espacios de color");
        desplegable_cs.addActionListener(formListener);
        panel_cs.add(desplegable_cs);

        barra_herramientas_imagen.add(panel_cs);

        panel_rotacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        slider_rotacion.setToolTipText("Rotación variable");
        slider_rotacion.setValue(0);
        slider_rotacion.addChangeListener(formListener);
        slider_rotacion.addFocusListener(formListener);
        panel_rotacion.add(slider_rotacion);

        barra_herramientas_imagen.add(panel_rotacion);

        boton_es_aum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/zoom_in.png"))); // NOI18N
        boton_es_aum.setToolTipText("Aumentar zoom");
        boton_es_aum.setFocusable(false);
        boton_es_aum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_es_aum.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_es_aum.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_es_aum);

        boton_es_dis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/zoom_out.png"))); // NOI18N
        boton_es_dis.setToolTipText("Disminuir zoom");
        boton_es_dis.setFocusable(false);
        boton_es_dis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_es_dis.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_es_dis.addActionListener(formListener);
        barra_herramientas_imagen.add(boton_es_dis);

        panel_umbral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Umbralización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_umbral.setToolTipText("Nivel de umbralización");

        slider_umbral.setMaximum(255);
        slider_umbral.setToolTipText("Nivel de umbralización");
        slider_umbral.setValue(0);
        slider_umbral.addChangeListener(formListener);
        slider_umbral.addFocusListener(formListener);
        panel_umbral.add(slider_umbral);

        barra_herramientas_imagen.add(panel_umbral);

        barra_herramientas.add(barra_herramientas_imagen);
        barra_herramientas.add(separador5);

        barra_herramientas_rep.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barra_herramientas_rep.setRollover(true);

        desplegable_reprod.setToolTipText("Lista de pistas de audio");
        barra_herramientas_rep.add(desplegable_reprod);

        boton_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play.png"))); // NOI18N
        boton_play.setToolTipText("Reproducir/pausar archivo actual");
        boton_play.setFocusable(false);
        boton_play.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_play.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_play.addActionListener(formListener);
        barra_herramientas_rep.add(boton_play);

        boton_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pausa.png"))); // NOI18N
        boton_pausa.setToolTipText("Pausar canción");
        boton_pausa.setFocusable(false);
        boton_pausa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_pausa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_pausa.addActionListener(formListener);
        barra_herramientas_rep.add(boton_pausa);

        boton_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stop.png"))); // NOI18N
        boton_stop.setToolTipText("Detener archivo actual");
        boton_stop.setFocusable(false);
        boton_stop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_stop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_stop.addActionListener(formListener);
        barra_herramientas_rep.add(boton_stop);

        boton_record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/grabar.png"))); // NOI18N
        boton_record.setToolTipText("Iniciar grabación");
        boton_record.setFocusable(false);
        boton_record.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_record.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_record.addActionListener(formListener);
        barra_herramientas_rep.add(boton_record);

        boton_stop_record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stop_grabar.png"))); // NOI18N
        boton_stop_record.setToolTipText("Detener grabación");
        boton_stop_record.setFocusable(false);
        boton_stop_record.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_stop_record.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_stop_record.addActionListener(formListener);
        barra_herramientas_rep.add(boton_stop_record);

        etiq_temp_record.setText("00:00");
        etiq_temp_record.setToolTipText("Temporizador de grabación");
        barra_herramientas_rep.add(etiq_temp_record);

        boton_webcam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/webcam.png"))); // NOI18N
        boton_webcam.setToolTipText("Iniciar webcam");
        boton_webcam.setFocusable(false);
        boton_webcam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_webcam.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_webcam.addActionListener(formListener);
        barra_herramientas_rep.add(boton_webcam);

        boton_captura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/captura.png"))); // NOI18N
        boton_captura.setToolTipText("Tomar captura del vídeo");
        boton_captura.setFocusable(false);
        boton_captura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_captura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_captura.addActionListener(formListener);
        barra_herramientas_rep.add(boton_captura);

        barra_herramientas.add(barra_herramientas_rep);

        panel_deslizador_herramientas.setViewportView(barra_herramientas);

        getContentPane().add(panel_deslizador_herramientas, java.awt.BorderLayout.NORTH);

        menu_archivo.setText("Archivo");

        menu_op_nuevo.setText("Nuevo");
        menu_op_nuevo.addActionListener(formListener);
        menu_archivo.add(menu_op_nuevo);

        menu_op_abrir_imagen.setText("Abrir imagen");
        menu_op_abrir_imagen.addActionListener(formListener);
        menu_archivo.add(menu_op_abrir_imagen);

        menu_op_guardar.setText("Guardar imagen");
        menu_op_guardar.addActionListener(formListener);
        menu_archivo.add(menu_op_guardar);
        menu_archivo.add(jSeparator1);

        menu_op_abrir_audio.setText("Abrir audio");
        menu_op_abrir_audio.addActionListener(formListener);
        menu_archivo.add(menu_op_abrir_audio);
        menu_archivo.add(jSeparator2);

        menu_op_abrir_video.setText("Abrir vídeo");
        menu_op_abrir_video.addActionListener(formListener);
        menu_archivo.add(menu_op_abrir_video);

        barra_menu.add(menu_archivo);

        menu_edicion.setText("Edición");

        menu_op_barra_est.setSelected(true);
        menu_op_barra_est.setText("Ver barra de estado");
        menu_op_barra_est.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_est);

        menu_op_barra_form.setSelected(true);
        menu_op_barra_form.setText("Ver barra de formas");
        menu_op_barra_form.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_form);

        menu_op_barra_dibujo.setSelected(true);
        menu_op_barra_dibujo.setText("Ver barra de dibujo");
        menu_op_barra_dibujo.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_dibujo);

        menu_op_barra_imagen.setSelected(true);
        menu_op_barra_imagen.setText("Ver barra de imagen");
        menu_op_barra_imagen.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_imagen);

        menu_op_barra_rep.setSelected(true);
        menu_op_barra_rep.setText("Ver barra de sonido/vídeo");
        menu_op_barra_rep.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_rep);

        barra_menu.add(menu_edicion);

        menu_ayuda.setText("Ayuda");

        menu_op_acerca.setText("Acerca de");
        menu_op_acerca.addActionListener(formListener);
        menu_ayuda.add(menu_op_acerca);

        barra_menu.add(menu_ayuda);

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
            else if (evt.getSource() == boton_linea) {
                VentanaPrincipal.this.boton_lineaActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rectangulo) {
                VentanaPrincipal.this.boton_rectanguloActionPerformed(evt);
            }
            else if (evt.getSource() == boton_elipse) {
                VentanaPrincipal.this.boton_elipseActionPerformed(evt);
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
            else if (evt.getSource() == boton_duplicar_img) {
                VentanaPrincipal.this.boton_duplicar_imgActionPerformed(evt);
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
            else if (evt.getSource() == boton_funcion) {
                VentanaPrincipal.this.boton_funcionActionPerformed(evt);
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
            else if (evt.getSource() == boton_negativo) {
                VentanaPrincipal.this.boton_negativoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rayos_x) {
                VentanaPrincipal.this.boton_rayos_xActionPerformed(evt);
            }
            else if (evt.getSource() == boton_termal) {
                VentanaPrincipal.this.boton_termalActionPerformed(evt);
            }
            else if (evt.getSource() == boton_suma_img) {
                VentanaPrincipal.this.boton_suma_imgActionPerformed(evt);
            }
            else if (evt.getSource() == boton_resta_img) {
                VentanaPrincipal.this.boton_resta_imgActionPerformed(evt);
            }
            else if (evt.getSource() == boton_bandas) {
                VentanaPrincipal.this.boton_bandasActionPerformed(evt);
            }
            else if (evt.getSource() == desplegable_cs) {
                VentanaPrincipal.this.desplegable_csActionPerformed(evt);
            }
            else if (evt.getSource() == boton_es_aum) {
                VentanaPrincipal.this.boton_es_aumActionPerformed(evt);
            }
            else if (evt.getSource() == boton_es_dis) {
                VentanaPrincipal.this.boton_es_disActionPerformed(evt);
            }
            else if (evt.getSource() == boton_play) {
                VentanaPrincipal.this.boton_playActionPerformed(evt);
            }
            else if (evt.getSource() == boton_pausa) {
                VentanaPrincipal.this.boton_pausaActionPerformed(evt);
            }
            else if (evt.getSource() == boton_stop) {
                VentanaPrincipal.this.boton_stopActionPerformed(evt);
            }
            else if (evt.getSource() == boton_record) {
                VentanaPrincipal.this.boton_recordActionPerformed(evt);
            }
            else if (evt.getSource() == boton_stop_record) {
                VentanaPrincipal.this.boton_stop_recordActionPerformed(evt);
            }
            else if (evt.getSource() == boton_webcam) {
                VentanaPrincipal.this.boton_webcamActionPerformed(evt);
            }
            else if (evt.getSource() == boton_captura) {
                VentanaPrincipal.this.boton_capturaActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_nuevo) {
                VentanaPrincipal.this.menu_op_nuevoActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_abrir_imagen) {
                VentanaPrincipal.this.menu_op_abrir_imagenActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_guardar) {
                VentanaPrincipal.this.menu_op_guardarActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_abrir_audio) {
                VentanaPrincipal.this.menu_op_abrir_audioActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_abrir_video) {
                VentanaPrincipal.this.menu_op_abrir_videoActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_est) {
                VentanaPrincipal.this.menu_op_barra_estActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_form) {
                VentanaPrincipal.this.menu_op_barra_formActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_dibujo) {
                VentanaPrincipal.this.menu_op_barra_dibujoActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_imagen) {
                VentanaPrincipal.this.menu_op_barra_imagenActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_barra_rep) {
                VentanaPrincipal.this.menu_op_barra_repActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_acerca) {
                VentanaPrincipal.this.menu_op_acercaActionPerformed(evt);
            }
            else if (evt.getSource() == jComboBox1) {
                VentanaPrincipal.this.jComboBox1ActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == slider_brillo) {
                VentanaPrincipal.this.slider_brilloFocusGained(evt);
            }
            else if (evt.getSource() == slider_tinte) {
                VentanaPrincipal.this.slider_tinteFocusGained(evt);
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
            else if (evt.getSource() == slider_tinte) {
                VentanaPrincipal.this.slider_tinteFocusLost(evt);
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
            else if (evt.getSource() == slider_tinte) {
                VentanaPrincipal.this.slider_tinteStateChanged(evt);
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

    private void boton_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_lineaActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.LINEAS);
        }
        
        this.etiq_estado.setText("Línea");
    }//GEN-LAST:event_boton_lineaActionPerformed

    private void boton_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rectanguloActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.RECTANGULOS);
        }
        
        this.etiq_estado.setText("Rectángulo");
    }//GEN-LAST:event_boton_rectanguloActionPerformed

    private void boton_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elipseActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null){
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.ELIPSES);
        }
        
        this.etiq_estado.setText("Elipse");
    }//GEN-LAST:event_boton_elipseActionPerformed

    private void spinner_grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_grosorStateChanged
        Stroke grosor = new BasicStroke((int)spinner_grosor.getValue());
        
//        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null)
//            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setTrazo(grosor);
    }//GEN-LAST:event_spinner_grosorStateChanged

    private void boton_rellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rellenarActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null){
            Relleno r = new Relleno(TipoRelleno.LISO, Color.BLACK);
            
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setRelleno(r);
        }
    }//GEN-LAST:event_boton_rellenarActionPerformed

    private void boton_transpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_transpActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setTransp(0.5f);
    }//GEN-LAST:event_boton_transpActionPerformed

    private void boton_alisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alisarActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null)
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setAlisado(boton_alisar.isSelected());
    }//GEN-LAST:event_boton_alisarActionPerformed

    private void slider_brilloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_brilloFocusGained
       if(escritorio.getSelectedFrame() != null){
            if(escritorio.getSelectedFrame().getClass().getName().equals("evaluacion.VentanaInternaLienzo")){
                VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());

                if(vi != null){
                    ColorModel cm = ((LienzoImagen2D)(vi.getLienzo())).getImagen().getColorModel();
                    WritableRaster raster = ((LienzoImagen2D)(vi.getLienzo())).getImagen().copyData(null);
                    boolean alfa_pre = ((LienzoImagen2D)(vi.getLienzo())).getImagen().isAlphaPremultiplied();
                    img_aux = new BufferedImage(cm, raster, alfa_pre, null);
                }
            }
       }
    }//GEN-LAST:event_slider_brilloFocusGained

    private void slider_brilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_brilloFocusLost
        img_aux = null;
        slider_brillo.setValue(0);
    }//GEN-LAST:event_slider_brilloFocusLost

    private void slider_brilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_brilloStateChanged
        VentanaInternaLienzo vi = ((VentanaInternaLienzo)(escritorio.getSelectedFrame()));
        
        if(vi != null){
            if(img_aux != null){
                try{
                    float[] alpha;
                    float[] beta;
                    
                    if(img_aux.getColorModel().hasAlpha()){
                        alpha = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
                        beta = new float[]{(float)slider_brillo.getValue(), (float)slider_brillo.getValue(), (float)slider_brillo.getValue(), 0.0f};
                    }
                    
                    else{
                        alpha = new float[]{1.0f, 1.0f, 1.0f};
                        beta = new float[]{(float)slider_brillo.getValue(), (float)slider_brillo.getValue(), (float)slider_brillo.getValue()};
                    }
                    
                    RescaleOp rop = new RescaleOp(alpha, beta, null);

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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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

    private void boton_funcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_funcionActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    LookupTable lut = FuncionPropia(50.0);
                    LookupOp luop = new LookupOp(lut, null);
                    luop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_boton_funcionActionPerformed

    private void slider_rotacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_rotacionFocusGained
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null)
        {
            Color col = this.desplegable_color.getItemAt(this.desplegable_color.getSelectedIndex());
//            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setColor(col);
        }
    }//GEN-LAST:event_desplegable_colorActionPerformed

    private void boton_bandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_bandasActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
                
                int tope = 3;
                
                if(EsGray(img_source))
                    tope = 1;
                
                for(int i=0; i<tope; i++){
                    VentanaInternaLienzo ventana = new VentanaInternaLienzo();
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            
            if(img_source != null){
                String opcion = String.valueOf(desplegable_cs.getSelectedItem());
                
                switch(opcion){
                    case "sRGB":
                        if(EsYCC(img_source)){
                            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                            ColorConvertOp cop = new ColorConvertOp(cs, null);

                            BufferedImage dest = cop.filter(img_source, null);

                            VentanaInternaLienzo ventana = new VentanaInternaLienzo();
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

                            VentanaInternaLienzo ventana = new VentanaInternaLienzo();
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

                            VentanaInternaLienzo ventana = new VentanaInternaLienzo();
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
                    
                    EqualizationOp eqop = new EqualizationOp(0);
                    eqop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_boton_ecualActionPerformed

    private void slider_umbralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_umbralFocusGained
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
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
        VentanaInternaLienzo vi = ((VentanaInternaLienzo)(escritorio.getSelectedFrame()));
        
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

    private void menu_op_abrir_audioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_abrir_audioActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        
        if(resp == JFileChooser.APPROVE_OPTION) {
            try {
                File f = new File(dlg.getSelectedFile().getAbsolutePath()){
                    @Override
                    public String toString(){
                        return this.getName();
                    }
                };               
                
                desplegable_reprod.addItem(f);
                desplegable_reprod.setSelectedItem(f);
            }catch(Exception e){
                System.err.println("Error al abrir la pista de audio");
            }
        }
    }//GEN-LAST:event_menu_op_abrir_audioActionPerformed

    private void boton_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_playActionPerformed
        if(escritorio.getSelectedFrame() == null){
            if(pausa)
                player.resume();

            File f = ((File)(desplegable_reprod.getSelectedItem()));

            if(f != null){
                player = new SMClipPlayer(f);
                class ManejadorClip implements LineListener{
                    @Override
                    public void update(LineEvent event) {
                        if(event.getType() == LineEvent.Type.START){
                            boton_play.setVisible(false);
                            boton_pausa.setVisible(true);
                            boton_stop.setVisible(true);
                        }

                        else if(event.getType() == LineEvent.Type.STOP){
                            boton_play.setVisible(true);
                            boton_pausa.setVisible(false);
                            boton_stop.setVisible(false);
                            pausa = false;
                        }
                    }  
                }

                player.addLineListener(new ManejadorClip());

                if(player != null && !pausa)
                    player.play();
            }
        }
        
        else
            ((VentanaInternaVLCPlayer)(escritorio.getSelectedFrame())).play();
    }//GEN-LAST:event_boton_playActionPerformed

    private void boton_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_stopActionPerformed
        if(escritorio.getSelectedFrame() == null){
            if(player != null)
                player.stop();
        }
        
        else
            ((VentanaInternaVLCPlayer)(escritorio.getSelectedFrame())).stop();
    }//GEN-LAST:event_boton_stopActionPerformed

    private void boton_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_recordActionPerformed
        arch_aux = new File("grabacion");
        
        if(arch_aux != null){
            recorder = new SMSoundRecorder(arch_aux);
            class ManejadorGrabacion implements LineListener{
                @Override
                public void update(LineEvent event) {
                    if(event.getType() == LineEvent.Type.START){
                        boton_record.setVisible(false);
                        boton_stop_record.setVisible(true);
                    }
                    
                    else if(event.getType() == LineEvent.Type.STOP){
                        boton_record.setVisible(true);
                        boton_stop_record.setVisible(false);
                    }
                }  
            }
            
            recorder.addLineListener(new ManejadorGrabacion());
            if(recorder != null){
                recorder.record();
                grabando = true;
                
                t = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        int tiempo = 0;
                        int minutos = 0;
                        String grab;
                        
                        while(grabando){
                            try{
                                Thread.sleep(999);
                                tiempo++;
                                
                                if(tiempo == 60){
                                    tiempo = 0;
                                    minutos++;
                                }
                                
                                if(tiempo < 9)
                                    grab = "0"+Integer.toString(minutos)+":0"+Integer.toString(tiempo);
                                
                                else
                                    grab = "0"+Integer.toString(minutos)+":"+Integer.toString(tiempo);
                                
                                etiq_temp_record.setText(grab);
                            }catch(Exception e){
                                System.err.println(e);
                            }
                        }
                        
                        if(!grabando){
                            tiempo = 0;
                            minutos = 0;
                            etiq_temp_record.setText("00:00");
                        }
                    }
                    
                });
                
                t.start();
            }
        }
    }//GEN-LAST:event_boton_recordActionPerformed

    private void boton_stop_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_stop_recordActionPerformed
        if(recorder != null){
            recorder.stop();
            grabando = false;
        }
        
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        
        if(resp == JFileChooser.APPROVE_OPTION) {
            try {
                File f = new File(dlg.getSelectedFile().getAbsolutePath()){
                    @Override
                    public String toString(){
                        return this.getName();
                    }
                };               
                
                arch_aux.renameTo(f);
                desplegable_reprod.addItem(f);
                desplegable_reprod.setSelectedItem(f);
                
            }catch(Exception e){
                System.err.println("Error al abrir la pista de audio");
            }
        }
        
        arch_aux = null;
    }//GEN-LAST:event_boton_stop_recordActionPerformed

    private void boton_pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_pausaActionPerformed
        if(player != null){
            player.pause();
            pausa = true;
        }
    }//GEN-LAST:event_boton_pausaActionPerformed

    private void boton_webcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_webcamActionPerformed
        vic = VentanaInternaCamara.getInstance();
        
        if(vic != null){
            escritorio.add(vic);
            vic.setTitle("Webcam");
            vic.setVisible(true);
        }
    }//GEN-LAST:event_boton_webcamActionPerformed

    private void boton_capturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_capturaActionPerformed
        if(vic != null){
            VentanaInternaLienzo vi = new VentanaInternaLienzo();
            ((LienzoImagen2D)(vi.getLienzo())).setImagen(vic.getImagen());
            vi.setTitle("Captura");
            escritorio.add(vi);
            vi.setVisible(true);
        }
    }//GEN-LAST:event_boton_capturaActionPerformed

    private void boton_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_abrirActionPerformed
        FileFilter jpg = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        FileFilter png = new FileNameExtensionFilter("PNG file", "png");
        JFileChooser dlg = new JFileChooser();
        dlg.addChoosableFileFilter(jpg);
        dlg.addChoosableFileFilter(png);
        
        int resp = dlg.showOpenDialog(this);
        
        if(resp == JFileChooser.APPROVE_OPTION) {
            try {
                File f = new File(dlg.getSelectedFile().getAbsolutePath()){
                    @Override
                    public String toString(){
                        return this.getName();
                    }
                };               
                
                String[] nombre_archivo = f.toString().split("\\.");
                
                switch(nombre_archivo[1]){
                    case "jpeg":
                    case "jpg":
                    case "JPEG":
                    case "JPG":
                    case "PNG":
                    case "png":
                        BufferedImage img = ImageIO.read(f);
                        VentanaInternaLienzo vi = new VentanaInternaLienzo();
                        ((LienzoImagen2D)(vi.getLienzo())).setImagen(img);
                        escritorio.add(vi);
                        vi.setTitle(f.getName());
                        vi.setVisible(true);
                        break;
                    case "wav":
                    case "au":
                        desplegable_reprod.addItem(f);
                        desplegable_reprod.setSelectedItem(f);
                        break;
                    case "mp4":
                    case "mpeg":
                    case "mpg":
                    case "avi":
                    case "wmv":
                        VentanaInternaVLCPlayer vivlc = VentanaInternaVLCPlayer.getInstance(f);
                        vivlc.AddMediaPlayerEventListener(new VideoListener());
                        escritorio.add(vivlc);
                        vivlc.setTitle(f.getName());
                        vivlc.setVisible(true);
                        break;
                    default:
                        System.err.println("Formato no soportado");
                }
            }catch(Exception e){
                System.err.println("Error al leer el fichero");
            }
        }
    }//GEN-LAST:event_boton_abrirActionPerformed

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        String ancho, alto;
        ancho = JOptionPane.showInputDialog("Ancho");
        alto = JOptionPane.showInputDialog("Alto");
        
        if(ancho != null && alto != null){
            VentanaInternaLienzo vi = new VentanaInternaLienzo();
            vi.setTitle("Nueva");
            vi.setSize(Integer.valueOf(ancho), Integer.valueOf(alto));
            escritorio.add(vi);
            vi.setVisible(true);
            
            BufferedImage img;
            img = new BufferedImage(Integer.valueOf(ancho), Integer.valueOf(alto), BufferedImage.TYPE_INT_RGB);
            img.getGraphics().fillRect(0, 0, img.getWidth(), img.getHeight());
            ((LienzoImagen2D)(vi.getLienzo())).setImagen(img);
        }
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo) escritorio.getSelectedFrame();
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

    private void boton_duplicar_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_duplicar_imgActionPerformed
        VentanaInternaLienzo activa = ((VentanaInternaLienzo)(escritorio.getSelectedFrame()));
        
        VentanaInternaLienzo vi = new VentanaInternaLienzo();
        escritorio.add(vi);
        vi.setVisible(true);
        
        if(vi != null){
            ColorModel cm = ((LienzoImagen2D)(activa.getLienzo())).getImagen().getColorModel();
            WritableRaster raster = ((LienzoImagen2D)(activa.getLienzo())).getImagen().copyData(null);
            boolean alfa_pre = ((LienzoImagen2D)(activa.getLienzo())).getImagen().isAlphaPremultiplied();
            BufferedImage img = new BufferedImage(cm, raster, alfa_pre, null);
            
            ((LienzoImagen2D)(vi.getLienzo())).setImagen(img);
            vi.setTitle(activa.getTitle()+" (copia)");
        }
    }//GEN-LAST:event_boton_duplicar_imgActionPerformed

    private void boton_negativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_negativoActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    LookupTable lut = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
                    LookupOp luop = new LookupOp(lut, null);
                    luop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
                
                RepintarEscritorio();
            }
        }
    }//GEN-LAST:event_boton_negativoActionPerformed

    private void boton_rayos_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rayos_xActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    RayosXOp rxop = new RayosXOp();
                    rxop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_boton_rayos_xActionPerformed

    private void boton_termalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_termalActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            BufferedImage img_source = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
            if(img_source != null){
                try{
                    ColorSpace cs = new sm.image.color.GreyColorSpace();
                    ColorConvertOp cop = new ColorConvertOp(cs, null);

                    BufferedImage dest = cop.filter(img_source, null);
                    
                    TermalOp teop = new TermalOp(dest);
                    teop.filter(img_source, img_source);
                    vi.repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_boton_termalActionPerformed

    private void boton_suma_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_suma_imgActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            VentanaInternaLienzo vi_anterior = (VentanaInternaLienzo)(escritorio.selectFrame(false));
            if(vi_anterior != null){
                BufferedImage img_dcha = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
                BufferedImage img_izda = ((LienzoImagen2D)(vi_anterior.getLienzo())).getImagen();
                
                if(img_dcha != null && img_izda != null){
                    try{
                        BlendOp bop = new BlendOp(img_izda);
                        BufferedImage dest = bop.filter(img_dcha, null);
                        
                        VentanaInternaLienzo vi_suma = new VentanaInternaLienzo();
                        ((LienzoImagen2D)(vi_suma.getLienzo())).setImagen(dest);
                        vi_suma.setTitle(vi.getTitle() + "+" + vi_anterior.getTitle());
                        escritorio.add(vi_suma);
                        vi_suma.setVisible(true);
                        
                    }catch(Exception e){
                        System.err.println(e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_boton_suma_imgActionPerformed

    private void boton_resta_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_resta_imgActionPerformed
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            VentanaInternaLienzo vi_anterior = (VentanaInternaLienzo)(escritorio.selectFrame(false));
            if(vi_anterior != null){
                BufferedImage img_dcha = ((LienzoImagen2D)(vi.getLienzo())).getImagen();
                BufferedImage img_izda = ((LienzoImagen2D)(vi_anterior.getLienzo())).getImagen();
                
                if(img_dcha != null && img_izda != null){
                    try{
                        SubtractionOp sop = new SubtractionOp(img_izda);
                        BufferedImage dest = sop.filter(img_dcha, null);
                        
                        VentanaInternaLienzo vi_resta = new VentanaInternaLienzo();
                        ((LienzoImagen2D)(vi_resta.getLienzo())).setImagen(dest);
                        vi_resta.setTitle(vi.getTitle() + "-" + vi_anterior.getTitle());
                        escritorio.add(vi_resta);
                        vi_resta.setVisible(true);
                        
                    }catch(Exception e){
                        System.err.println(e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_boton_resta_imgActionPerformed

    private void slider_tinteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_tinteFocusGained
        VentanaInternaLienzo vi = (VentanaInternaLienzo)(escritorio.getSelectedFrame());
        
        if(vi != null){
            ColorModel cm = ((LienzoImagen2D)(vi.getLienzo())).getImagen().getColorModel();
            WritableRaster raster = ((LienzoImagen2D)(vi.getLienzo())).getImagen().copyData(null);
            boolean alfa_pre = ((LienzoImagen2D)(vi.getLienzo())).getImagen().isAlphaPremultiplied();
            img_aux = new BufferedImage(cm, raster, alfa_pre, null);
        }
    }//GEN-LAST:event_slider_tinteFocusGained

    private void slider_tinteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slider_tinteFocusLost
        img_aux = null;
        slider_tinte.setValue(50);
    }//GEN-LAST:event_slider_tinteFocusLost

    private void slider_tinteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_tinteStateChanged
        VentanaInternaLienzo vi = ((VentanaInternaLienzo)(escritorio.getSelectedFrame()));
        
        if(vi != null){
            if(img_aux != null){
                try{
                    TintOp top = new TintOp(this.desplegable_color.getItemAt(this.desplegable_color.getSelectedIndex()), slider_tinte.getValue()/100f);
                    top.filter(img_aux, ((LienzoImagen2D)(vi.getLienzo())).getImagen());
                    vi.getLienzo().repaint();
                }catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
            
            RepintarEscritorio();
        }
    }//GEN-LAST:event_slider_tinteStateChanged

    private void menu_op_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_nuevoActionPerformed
        this.boton_nuevoActionPerformed(evt);
    }//GEN-LAST:event_menu_op_nuevoActionPerformed

    private void menu_op_abrir_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_abrir_imagenActionPerformed
        this.boton_abrirActionPerformed(evt);
    }//GEN-LAST:event_menu_op_abrir_imagenActionPerformed

    private void menu_op_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_guardarActionPerformed
        this.boton_guardarActionPerformed(evt);
    }//GEN-LAST:event_menu_op_guardarActionPerformed

    private void menu_op_abrir_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_abrir_videoActionPerformed
        this.boton_abrirActionPerformed(evt);
    }//GEN-LAST:event_menu_op_abrir_videoActionPerformed

    private void menu_op_barra_dibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_dibujoActionPerformed
        this.barra_herramientas_dibujo.setVisible(!this.barra_herramientas_dibujo.isVisible());
    }//GEN-LAST:event_menu_op_barra_dibujoActionPerformed

    private void menu_op_barra_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_imagenActionPerformed
        this.barra_herramientas_imagen.setVisible(!this.barra_herramientas_imagen.isVisible());
    }//GEN-LAST:event_menu_op_barra_imagenActionPerformed

    private void menu_op_barra_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_barra_repActionPerformed
        this.barra_herramientas_rep.setVisible(!this.barra_herramientas_rep.isVisible());
    }//GEN-LAST:event_menu_op_barra_repActionPerformed

    private void menu_op_acercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_acercaActionPerformed
        String autor;
        
        autor = "SMM 2018/2019\n Nazaret Román Guerrero\n Versión beta 1.0";
        
        JOptionPane.showMessageDialog(null, autor);
    }//GEN-LAST:event_menu_op_acercaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if((VentanaInternaLienzo)(this.escritorio.getSelectedFrame()) != null){
            Trazo t = new Trazo(Color.BLACK, 5.0f, TipoTrazo.CONTINUO);
            
            ((VentanaInternaLienzo)(this.escritorio.getSelectedFrame())).getLienzo().setTraz(t);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JToolBar barra_herramientas_dibujo;
    private javax.swing.JToolBar barra_herramientas_imagen;
    private javax.swing.JToolBar barra_herramientas_rep;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JButton boton_abrir;
    private javax.swing.JToggleButton boton_alisar;
    private javax.swing.JButton boton_bandas;
    private javax.swing.JButton boton_captura;
    private javax.swing.JButton boton_contraste;
    private javax.swing.JToggleButton boton_curva;
    private javax.swing.JButton boton_duplicar_img;
    private javax.swing.JButton boton_ecual;
    private javax.swing.JToggleButton boton_elipse;
    private javax.swing.JButton boton_es_aum;
    private javax.swing.JButton boton_es_dis;
    private javax.swing.JButton boton_funcion;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JButton boton_iluminar;
    private javax.swing.JToggleButton boton_linea;
    private javax.swing.JButton boton_negativo;
    private javax.swing.JButton boton_nuevo;
    private javax.swing.JButton boton_oscurecer;
    private javax.swing.JButton boton_pausa;
    private javax.swing.JButton boton_play;
    private javax.swing.JButton boton_rayos_x;
    private javax.swing.JButton boton_record;
    private javax.swing.JToggleButton boton_rectangulo;
    private javax.swing.JToggleButton boton_rectangulo_red;
    private javax.swing.JToggleButton boton_rellenar;
    private javax.swing.JButton boton_resta_img;
    private javax.swing.JButton boton_sepia;
    private javax.swing.JButton boton_stop;
    private javax.swing.JButton boton_stop_record;
    private javax.swing.JButton boton_suma_img;
    private javax.swing.JButton boton_termal;
    private javax.swing.JButton boton_tintado;
    private javax.swing.JToggleButton boton_transp;
    private javax.swing.JButton boton_webcam;
    private javax.swing.JComboBox<Color> desplegable_color;
    private javax.swing.JComboBox<String> desplegable_cs;
    private javax.swing.JComboBox<String> desplegable_filtro;
    private javax.swing.JComboBox<File> desplegable_reprod;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel etiq_estado;
    private javax.swing.JLabel etiq_temp_record;
    private javax.swing.ButtonGroup grupo_colores;
    private javax.swing.ButtonGroup grupo_herramientas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JMenu menu_edicion;
    private javax.swing.JMenuItem menu_op_abrir_audio;
    private javax.swing.JMenuItem menu_op_abrir_imagen;
    private javax.swing.JMenuItem menu_op_abrir_video;
    private javax.swing.JMenuItem menu_op_acerca;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_dibujo;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_est;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_form;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_imagen;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_rep;
    private javax.swing.JMenuItem menu_op_guardar;
    private javax.swing.JMenuItem menu_op_nuevo;
    private javax.swing.JPanel panel_atr_lienzo;
    private javax.swing.JPanel panel_cs;
    private javax.swing.JScrollPane panel_deslizador_herramientas;
    private javax.swing.JPanel panel_desp_filtros;
    private javax.swing.JPanel panel_estado;
    private javax.swing.JPanel panel_rotacion;
    private javax.swing.JPanel panel_slider;
    private javax.swing.JPanel panel_tinte;
    private javax.swing.JPanel panel_umbral;
    private javax.swing.JToolBar.Separator separador1;
    private javax.swing.JToolBar.Separator separador2;
    private javax.swing.JToolBar.Separator separador3;
    private javax.swing.JToolBar.Separator separador4;
    private javax.swing.JToolBar.Separator separador5;
    private javax.swing.JSlider slider_brillo;
    private javax.swing.JSlider slider_rotacion;
    private javax.swing.JSlider slider_tinte;
    private javax.swing.JSlider slider_umbral;
    private javax.swing.JSpinner spinner_grosor;
    // End of variables declaration//GEN-END:variables
    private BufferedImage img_aux;
    private SMClipPlayer player = null;
    private SMSoundRecorder recorder = null;
    private File arch_aux;
    private Thread t;
    private boolean grabando = false;
    private boolean pausa = false;
    VentanaInternaCamara vic = null;
}
