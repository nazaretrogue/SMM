/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica7;

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
        
        this.setSize(600, 600);
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
        boton_punto = new javax.swing.JToggleButton();
        boton_linea = new javax.swing.JToggleButton();
        boton_rectangulo = new javax.swing.JToggleButton();
        boton_elipse = new javax.swing.JToggleButton();
        boton_seleccion = new javax.swing.JToggleButton();
        panel_atr_lienzo = new javax.swing.JPanel();
        panel_atr_generico = new javax.swing.JPanel();
        barra_atr = new javax.swing.JToolBar();
        panel_colores = new javax.swing.JPanel();
        boton_negro = new javax.swing.JToggleButton();
        boton_rojo = new javax.swing.JToggleButton();
        boton_azul = new javax.swing.JToggleButton();
        boton_blanco = new javax.swing.JToggleButton();
        boton_amarillo = new javax.swing.JToggleButton();
        boton_verde = new javax.swing.JToggleButton();
        panel_grosor = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        panel_atr = new javax.swing.JPanel();
        check_relleno = new javax.swing.JCheckBox();
        check_transp = new javax.swing.JCheckBox();
        check_alisar = new javax.swing.JCheckBox();
        check_editar = new javax.swing.JCheckBox();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        barra_menu = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_op_nuevo = new javax.swing.JMenuItem();
        menu_op_abrir = new javax.swing.JMenuItem();
        menu_op_guardar = new javax.swing.JMenuItem();
        menu_edicion = new javax.swing.JMenu();
        menu_op_barra_est = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_form = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_atr = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panel_estado.setLayout(flowLayout1);

        etiq_estado.setText("Punto");
        panel_estado.add(etiq_estado);

        getContentPane().add(panel_estado, java.awt.BorderLayout.SOUTH);

        barra_herramientas.setRollover(true);

        grupo_herramientas.add(boton_punto);
        boton_punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/punto.png"))); // NOI18N
        boton_punto.setFocusable(false);
        boton_punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(boton_punto);

        grupo_herramientas.add(boton_linea);
        boton_linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        boton_linea.setFocusable(false);
        boton_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(boton_linea);

        grupo_herramientas.add(boton_rectangulo);
        boton_rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        boton_rectangulo.setFocusable(false);
        boton_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(boton_rectangulo);

        grupo_herramientas.add(boton_elipse);
        boton_elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        boton_elipse.setFocusable(false);
        boton_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(boton_elipse);

        grupo_herramientas.add(boton_seleccion);
        boton_seleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seleccion.png"))); // NOI18N
        boton_seleccion.setFocusable(false);
        boton_seleccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_seleccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(boton_seleccion);

        getContentPane().add(barra_herramientas, java.awt.BorderLayout.NORTH);

        panel_atr_lienzo.setLayout(new java.awt.BorderLayout());

        panel_atr_generico.setLayout(new java.awt.BorderLayout());

        barra_atr.setRollover(true);

        panel_colores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_colores.setLayout(new java.awt.GridLayout(2, 3));

        boton_negro.setBackground(new java.awt.Color(1, 1, 1));
        grupo_colores.add(boton_negro);
        boton_negro.setForeground(new java.awt.Color(1, 1, 1));
        boton_negro.setPreferredSize(new java.awt.Dimension(20, 20));
        panel_colores.add(boton_negro);

        boton_rojo.setBackground(new java.awt.Color(255, 0, 0));
        grupo_colores.add(boton_rojo);
        boton_rojo.setForeground(new java.awt.Color(255, 0, 0));
        boton_rojo.setPreferredSize(new java.awt.Dimension(20, 20));
        panel_colores.add(boton_rojo);

        boton_azul.setBackground(new java.awt.Color(0, 0, 255));
        grupo_colores.add(boton_azul);
        boton_azul.setForeground(new java.awt.Color(0, 0, 255));
        boton_azul.setPreferredSize(new java.awt.Dimension(20, 20));
        panel_colores.add(boton_azul);

        boton_blanco.setBackground(new java.awt.Color(255, 255, 255));
        grupo_colores.add(boton_blanco);
        boton_blanco.setForeground(new java.awt.Color(255, 255, 255));
        boton_blanco.setFocusable(false);
        boton_blanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_blanco.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_blanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_colores.add(boton_blanco);

        boton_amarillo.setBackground(new java.awt.Color(255, 255, 0));
        grupo_colores.add(boton_amarillo);
        boton_amarillo.setForeground(new java.awt.Color(255, 255, 0));
        boton_amarillo.setFocusable(false);
        boton_amarillo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_amarillo.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_amarillo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_colores.add(boton_amarillo);

        boton_verde.setBackground(new java.awt.Color(0, 255, 0));
        grupo_colores.add(boton_verde);
        boton_verde.setForeground(new java.awt.Color(0, 255, 0));
        boton_verde.setToolTipText("");
        boton_verde.setPreferredSize(new java.awt.Dimension(20, 20));
        panel_colores.add(boton_verde);

        barra_atr.add(panel_colores);

        panel_grosor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grosor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_grosor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        panel_grosor.add(jSpinner1);

        barra_atr.add(panel_grosor);

        panel_atr.setBorder(javax.swing.BorderFactory.createTitledBorder("   "));
        panel_atr.setLayout(new java.awt.GridLayout(2, 2));

        check_relleno.setText("Relleno");
        check_relleno.setFocusable(false);
        check_relleno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_relleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_atr.add(check_relleno);

        check_transp.setText("Transparencia");
        check_transp.setFocusable(false);
        check_transp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_transp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_atr.add(check_transp);

        check_alisar.setText("Alisar");
        check_alisar.setFocusable(false);
        check_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_atr.add(check_alisar);

        check_editar.setText("Editar");
        check_editar.setFocusable(false);
        check_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel_atr.add(check_editar);

        barra_atr.add(panel_atr);

        panel_atr_generico.add(barra_atr, java.awt.BorderLayout.SOUTH);

        panel_atr_lienzo.add(panel_atr_generico, java.awt.BorderLayout.SOUTH);
        panel_atr_lienzo.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_atr_lienzo, java.awt.BorderLayout.CENTER);

        menu_archivo.setText("Archivo");

        menu_op_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        menu_op_nuevo.setText("Nuevo");
        menu_archivo.add(menu_op_nuevo);

        menu_op_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        menu_op_abrir.setText("Abrir");
        menu_archivo.add(menu_op_abrir);

        menu_op_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        menu_op_guardar.setText("Guardar");
        menu_archivo.add(menu_op_guardar);

        barra_menu.add(menu_archivo);

        menu_edicion.setText("Edición");

        menu_op_barra_est.setSelected(true);
        menu_op_barra_est.setText("Ver barra de estado");
        menu_edicion.add(menu_op_barra_est);

        menu_op_barra_form.setSelected(true);
        menu_op_barra_form.setText("Ver barra de formas");
        menu_edicion.add(menu_op_barra_form);

        menu_op_barra_atr.setSelected(true);
        menu_op_barra_atr.setText("Ver barra de atributos");
        menu_edicion.add(menu_op_barra_atr);

        barra_menu.add(menu_edicion);

        setJMenuBar(barra_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barra_atr;
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JToggleButton boton_amarillo;
    private javax.swing.JToggleButton boton_azul;
    private javax.swing.JToggleButton boton_blanco;
    private javax.swing.JToggleButton boton_elipse;
    private javax.swing.JToggleButton boton_linea;
    private javax.swing.JToggleButton boton_negro;
    private javax.swing.JToggleButton boton_punto;
    private javax.swing.JToggleButton boton_rectangulo;
    private javax.swing.JToggleButton boton_rojo;
    private javax.swing.JToggleButton boton_seleccion;
    private javax.swing.JToggleButton boton_verde;
    private javax.swing.JCheckBox check_alisar;
    private javax.swing.JCheckBox check_editar;
    private javax.swing.JCheckBox check_relleno;
    private javax.swing.JCheckBox check_transp;
    private javax.swing.JLabel etiq_estado;
    private javax.swing.ButtonGroup grupo_colores;
    private javax.swing.ButtonGroup grupo_herramientas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_edicion;
    private javax.swing.JMenuItem menu_op_abrir;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_atr;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_est;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_form;
    private javax.swing.JMenuItem menu_op_guardar;
    private javax.swing.JMenuItem menu_op_nuevo;
    private javax.swing.JPanel panel_atr;
    private javax.swing.JPanel panel_atr_generico;
    private javax.swing.JPanel panel_atr_lienzo;
    private javax.swing.JPanel panel_colores;
    private javax.swing.JPanel panel_estado;
    private javax.swing.JPanel panel_grosor;
    // End of variables declaration//GEN-END:variables
}
