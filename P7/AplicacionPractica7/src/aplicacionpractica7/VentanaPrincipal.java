/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionpractica7;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.io.File;
import javax.swing.JFileChooser;
import sm.nrg.iu.TipoHerramienta;

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
        
        this.setSize(800, 800);
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
        spinner_grosor = new javax.swing.JSpinner();
        panel_atr = new javax.swing.JPanel();
        check_relleno = new javax.swing.JCheckBox();
        check_transp = new javax.swing.JCheckBox();
        check_alisar = new javax.swing.JCheckBox();
        check_editar = new javax.swing.JCheckBox();
        escritorio = new javax.swing.JDesktopPane();
        barra_menu = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_op_nuevo = new javax.swing.JMenuItem();
        menu_op_abrir = new javax.swing.JMenuItem();
        menu_op_guardar = new javax.swing.JMenuItem();
        menu_edicion = new javax.swing.JMenu();
        menu_op_barra_est = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_form = new javax.swing.JCheckBoxMenuItem();
        menu_op_barra_atr = new javax.swing.JCheckBoxMenuItem();

        FormListener formListener = new FormListener();

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
        boton_punto.setSelected(true);
        boton_punto.setFocusable(false);
        boton_punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_punto.addActionListener(formListener);
        barra_herramientas.add(boton_punto);

        grupo_herramientas.add(boton_linea);
        boton_linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        boton_linea.setFocusable(false);
        boton_linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_linea.addActionListener(formListener);
        barra_herramientas.add(boton_linea);

        grupo_herramientas.add(boton_rectangulo);
        boton_rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        boton_rectangulo.setFocusable(false);
        boton_rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rectangulo.addActionListener(formListener);
        barra_herramientas.add(boton_rectangulo);

        grupo_herramientas.add(boton_elipse);
        boton_elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        boton_elipse.setFocusable(false);
        boton_elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_elipse.addActionListener(formListener);
        barra_herramientas.add(boton_elipse);

        grupo_herramientas.add(boton_seleccion);
        boton_seleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seleccion.png"))); // NOI18N
        boton_seleccion.setFocusable(false);
        boton_seleccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_seleccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_seleccion.addActionListener(formListener);
        barra_herramientas.add(boton_seleccion);

        getContentPane().add(barra_herramientas, java.awt.BorderLayout.NORTH);

        panel_atr_lienzo.setLayout(new java.awt.BorderLayout());

        panel_atr_generico.setLayout(new java.awt.BorderLayout());

        barra_atr.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        barra_atr.setRollover(true);

        panel_colores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_colores.setLayout(new java.awt.GridLayout(2, 3));

        boton_negro.setBackground(new java.awt.Color(1, 1, 1));
        grupo_colores.add(boton_negro);
        boton_negro.setForeground(new java.awt.Color(1, 1, 1));
        boton_negro.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_negro.addActionListener(formListener);
        panel_colores.add(boton_negro);

        boton_rojo.setBackground(new java.awt.Color(255, 0, 0));
        grupo_colores.add(boton_rojo);
        boton_rojo.setForeground(new java.awt.Color(255, 0, 0));
        boton_rojo.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_rojo.addActionListener(formListener);
        panel_colores.add(boton_rojo);

        boton_azul.setBackground(new java.awt.Color(0, 0, 255));
        grupo_colores.add(boton_azul);
        boton_azul.setForeground(new java.awt.Color(0, 0, 255));
        boton_azul.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_azul.addActionListener(formListener);
        panel_colores.add(boton_azul);

        boton_blanco.setBackground(new java.awt.Color(255, 255, 255));
        grupo_colores.add(boton_blanco);
        boton_blanco.setForeground(new java.awt.Color(255, 255, 255));
        boton_blanco.setFocusable(false);
        boton_blanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_blanco.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_blanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_blanco.addActionListener(formListener);
        panel_colores.add(boton_blanco);

        boton_amarillo.setBackground(new java.awt.Color(255, 255, 0));
        grupo_colores.add(boton_amarillo);
        boton_amarillo.setForeground(new java.awt.Color(255, 255, 0));
        boton_amarillo.setFocusable(false);
        boton_amarillo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_amarillo.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_amarillo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_amarillo.addActionListener(formListener);
        panel_colores.add(boton_amarillo);

        boton_verde.setBackground(new java.awt.Color(0, 255, 0));
        grupo_colores.add(boton_verde);
        boton_verde.setForeground(new java.awt.Color(0, 255, 0));
        boton_verde.setToolTipText("");
        boton_verde.setPreferredSize(new java.awt.Dimension(20, 20));
        boton_verde.addActionListener(formListener);
        panel_colores.add(boton_verde);

        barra_atr.add(panel_colores);

        panel_grosor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grosor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        panel_grosor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        spinner_grosor.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinner_grosor.addChangeListener(formListener);
        panel_grosor.add(spinner_grosor);

        barra_atr.add(panel_grosor);

        panel_atr.setBorder(javax.swing.BorderFactory.createTitledBorder("   "));
        panel_atr.setLayout(new java.awt.GridLayout(2, 2));

        check_relleno.setText("Relleno");
        check_relleno.setFocusable(false);
        check_relleno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_relleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        check_relleno.addActionListener(formListener);
        panel_atr.add(check_relleno);

        check_transp.setText("Transparencia");
        check_transp.setFocusable(false);
        check_transp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_transp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        check_transp.addActionListener(formListener);
        panel_atr.add(check_transp);

        check_alisar.setText("Alisar");
        check_alisar.setFocusable(false);
        check_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        check_alisar.addActionListener(formListener);
        panel_atr.add(check_alisar);

        check_editar.setText("Editar");
        check_editar.setFocusable(false);
        check_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        check_editar.addActionListener(formListener);
        panel_atr.add(check_editar);

        barra_atr.add(panel_atr);

        panel_atr_generico.add(barra_atr, java.awt.BorderLayout.SOUTH);

        panel_atr_lienzo.add(panel_atr_generico, java.awt.BorderLayout.SOUTH);
        panel_atr_lienzo.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_atr_lienzo, java.awt.BorderLayout.CENTER);

        menu_archivo.setText("Archivo");

        menu_op_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        menu_op_nuevo.setText("Nuevo");
        menu_op_nuevo.addActionListener(formListener);
        menu_archivo.add(menu_op_nuevo);

        menu_op_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        menu_op_abrir.setText("Abrir");
        menu_op_abrir.addActionListener(formListener);
        menu_archivo.add(menu_op_abrir);

        menu_op_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        menu_op_guardar.setText("Guardar");
        menu_op_guardar.addActionListener(formListener);
        menu_archivo.add(menu_op_guardar);

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

        menu_op_barra_atr.setSelected(true);
        menu_op_barra_atr.setText("Ver barra de atributos");
        menu_op_barra_atr.addActionListener(formListener);
        menu_edicion.add(menu_op_barra_atr);

        barra_menu.add(menu_edicion);

        setJMenuBar(barra_menu);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == boton_punto) {
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
            else if (evt.getSource() == boton_negro) {
                VentanaPrincipal.this.boton_negroActionPerformed(evt);
            }
            else if (evt.getSource() == boton_rojo) {
                VentanaPrincipal.this.boton_rojoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_azul) {
                VentanaPrincipal.this.boton_azulActionPerformed(evt);
            }
            else if (evt.getSource() == boton_blanco) {
                VentanaPrincipal.this.boton_blancoActionPerformed(evt);
            }
            else if (evt.getSource() == boton_amarillo) {
                VentanaPrincipal.this.boton_amarilloActionPerformed(evt);
            }
            else if (evt.getSource() == boton_verde) {
                VentanaPrincipal.this.boton_verdeActionPerformed(evt);
            }
            else if (evt.getSource() == check_relleno) {
                VentanaPrincipal.this.check_rellenoActionPerformed(evt);
            }
            else if (evt.getSource() == check_transp) {
                VentanaPrincipal.this.check_transpActionPerformed(evt);
            }
            else if (evt.getSource() == check_alisar) {
                VentanaPrincipal.this.check_alisarActionPerformed(evt);
            }
            else if (evt.getSource() == check_editar) {
                VentanaPrincipal.this.check_editarActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_nuevo) {
                VentanaPrincipal.this.menu_op_nuevoActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_abrir) {
                VentanaPrincipal.this.menu_op_abrirActionPerformed(evt);
            }
            else if (evt.getSource() == menu_op_guardar) {
                VentanaPrincipal.this.menu_op_guardarActionPerformed(evt);
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
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == spinner_grosor) {
                VentanaPrincipal.this.spinner_grosorStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void menu_op_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_nuevoActionPerformed
        VentanaInterna vi = new VentanaInterna();
        escritorio.add(vi);
        vi.setVisible(true);
    }//GEN-LAST:event_menu_op_nuevoActionPerformed

    private void menu_op_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_abrirActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_menu_op_abrirActionPerformed

    private void menu_op_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_op_guardarActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_menu_op_guardarActionPerformed

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
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.PUNTOS);
        
        this.etiq_estado.setText("Punto");
    }//GEN-LAST:event_boton_puntoActionPerformed

    private void boton_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_lineaActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.LINEAS);
        
        this.etiq_estado.setText("Línea");
    }//GEN-LAST:event_boton_lineaActionPerformed

    private void boton_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rectanguloActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.RECTANGULOS);
        
        this.etiq_estado.setText("Rectángulo");
    }//GEN-LAST:event_boton_rectanguloActionPerformed

    private void boton_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elipseActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.ELIPSES);
        
        this.etiq_estado.setText("Elipse");
    }//GEN-LAST:event_boton_elipseActionPerformed

    private void boton_seleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_seleccionActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(boton_seleccion.isSelected());
        
        this.etiq_estado.setText("Moviendo figura");
    }//GEN-LAST:event_boton_seleccionActionPerformed

    private void boton_negroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_negroActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.BLACK);
    }//GEN-LAST:event_boton_negroActionPerformed

    private void boton_rojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rojoActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.RED);
    }//GEN-LAST:event_boton_rojoActionPerformed

    private void boton_azulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_azulActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.BLUE);
    }//GEN-LAST:event_boton_azulActionPerformed

    private void boton_blancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_blancoActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.WHITE);
    }//GEN-LAST:event_boton_blancoActionPerformed

    private void boton_amarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_amarilloActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.YELLOW);
    }//GEN-LAST:event_boton_amarilloActionPerformed

    private void boton_verdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_verdeActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setColor(Color.GREEN);
    }//GEN-LAST:event_boton_verdeActionPerformed

    private void check_rellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_rellenoActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setRelleno(check_relleno.isSelected());
    }//GEN-LAST:event_check_rellenoActionPerformed

    private void check_transpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_transpActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTransparencia(check_transp.isSelected());
    }//GEN-LAST:event_check_transpActionPerformed

    private void check_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_editarActionPerformed
        this.boton_seleccionActionPerformed(evt);
    }//GEN-LAST:event_check_editarActionPerformed

    private void check_alisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_alisarActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setAlisar(check_alisar.isSelected());
    }//GEN-LAST:event_check_alisarActionPerformed

    private void spinner_grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_grosorStateChanged
        Stroke grosor = new BasicStroke((int)spinner_grosor.getValue());
        
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTrazo(grosor);
    }//GEN-LAST:event_spinner_grosorStateChanged

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
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel etiq_estado;
    private javax.swing.ButtonGroup grupo_colores;
    private javax.swing.ButtonGroup grupo_herramientas;
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
    private javax.swing.JSpinner spinner_grosor;
    // End of variables declaration//GEN-END:variables
}
