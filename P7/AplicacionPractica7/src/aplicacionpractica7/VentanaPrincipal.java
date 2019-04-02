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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import sm.nrg.iu.TipoHerramienta;
import sm.nrg.iu.PanelColor;

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
        
        desplegable_color = new JComboBox<JPanel>();
        desplegable_color.setRenderer(new BasicComboBoxRenderer());
        
        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN};
        for(Color c: colores) {
            JPanel tmp = new PanelColor(c);
            tmp.setOpaque(true);
            desplegable_color.addItem(tmp);
        }
        
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
        try {
            desplegable_color =(javax.swing.JComboBox)java.beans.Beans.instantiate(getClass().getClassLoader(), "aplicacionpractica7.VentanaPrincipal_desplegable_color");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        separador3 = new javax.swing.JToolBar.Separator();
        spinner_grosor = new javax.swing.JSpinner();
        boton_rellenar = new javax.swing.JToggleButton();
        boton_transp = new javax.swing.JToggleButton();
        boton_alisar = new javax.swing.JToggleButton();
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
        escritorio = new javax.swing.JDesktopPane();
        barra_menu = new javax.swing.JMenuBar();
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

        boton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        boton_nuevo.setFocusable(false);
        boton_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_nuevo.addActionListener(formListener);
        barra_herramientas.add(boton_nuevo);

        boton_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        boton_abrir.setFocusable(false);
        boton_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_abrir.addActionListener(formListener);
        barra_herramientas.add(boton_abrir);

        boton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        boton_guardar.setFocusable(false);
        boton_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_guardar.addActionListener(formListener);
        barra_herramientas.add(boton_guardar);
        barra_herramientas.add(separador1);

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
        barra_herramientas.add(separador2);
        barra_herramientas.add(desplegable_color);
        barra_herramientas.add(separador3);

        spinner_grosor.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinner_grosor.addChangeListener(formListener);
        barra_herramientas.add(spinner_grosor);

        boton_rellenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png"))); // NOI18N
        boton_rellenar.setFocusable(false);
        boton_rellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_rellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_rellenar.addActionListener(formListener);
        barra_herramientas.add(boton_rellenar);

        boton_transp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/transparencia.png"))); // NOI18N
        boton_transp.setFocusable(false);
        boton_transp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_transp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_transp.addActionListener(formListener);
        barra_herramientas.add(boton_transp);

        boton_alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alisar.png"))); // NOI18N
        boton_alisar.setFocusable(false);
        boton_alisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_alisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_alisar.addActionListener(formListener);
        barra_herramientas.add(boton_alisar);

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

        setJMenuBar(barra_menu);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, javax.swing.event.ChangeListener {
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
            else if (evt.getSource() == boton_rellenar) {
                VentanaPrincipal.this.boton_rellenarActionPerformed(evt);
            }
            else if (evt.getSource() == boton_transp) {
                VentanaPrincipal.this.boton_transpActionPerformed(evt);
            }
            else if (evt.getSource() == boton_alisar) {
                VentanaPrincipal.this.boton_alisarActionPerformed(evt);
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
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        
        this.etiq_estado.setText("Punto");
    }//GEN-LAST:event_boton_puntoActionPerformed

    private void boton_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_lineaActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.LINEAS);
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        
        this.etiq_estado.setText("Línea");
    }//GEN-LAST:event_boton_lineaActionPerformed

    private void boton_rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rectanguloActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.RECTANGULOS);
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        
        this.etiq_estado.setText("Rectángulo");
    }//GEN-LAST:event_boton_rectanguloActionPerformed

    private void boton_elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elipseActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setHerramienta(TipoHerramienta.ELIPSES);
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setMover(false);
        
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

    private void spinner_grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_grosorStateChanged
        Stroke grosor = new BasicStroke((int)spinner_grosor.getValue());
        
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTrazo(grosor);
    }//GEN-LAST:event_spinner_grosorStateChanged

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        VentanaInterna vi = new VentanaInterna();
        escritorio.add(vi);
        vi.setVisible(true);
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_abrirActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_boton_abrirActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_rellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rellenarActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setRelleno(boton_rellenar.isSelected());
    }//GEN-LAST:event_boton_rellenarActionPerformed

    private void boton_transpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_transpActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setTransparencia(boton_transp.isSelected());
    }//GEN-LAST:event_boton_transpActionPerformed

    private void boton_alisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alisarActionPerformed
        ((VentanaInterna)(this.escritorio.getSelectedFrame())).getLienzo().setAlisar(boton_alisar.isSelected());
    }//GEN-LAST:event_boton_alisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barra_atr;
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JToggleButton boton_abrir;
    private javax.swing.JToggleButton boton_alisar;
    private javax.swing.JToggleButton boton_amarillo;
    private javax.swing.JToggleButton boton_azul;
    private javax.swing.JToggleButton boton_blanco;
    private javax.swing.JToggleButton boton_elipse;
    private javax.swing.JToggleButton boton_guardar;
    private javax.swing.JToggleButton boton_linea;
    private javax.swing.JToggleButton boton_negro;
    private javax.swing.JToggleButton boton_nuevo;
    private javax.swing.JToggleButton boton_punto;
    private javax.swing.JToggleButton boton_rectangulo;
    private javax.swing.JToggleButton boton_rellenar;
    private javax.swing.JToggleButton boton_rojo;
    private javax.swing.JToggleButton boton_seleccion;
    private javax.swing.JToggleButton boton_transp;
    private javax.swing.JToggleButton boton_verde;
    private javax.swing.JComboBox<JPanel> desplegable_color;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel etiq_estado;
    private javax.swing.ButtonGroup grupo_colores;
    private javax.swing.ButtonGroup grupo_herramientas;
    private javax.swing.JMenu menu_edicion;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_atr;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_est;
    private javax.swing.JCheckBoxMenuItem menu_op_barra_form;
    private javax.swing.JPanel panel_atr_generico;
    private javax.swing.JPanel panel_atr_lienzo;
    private javax.swing.JPanel panel_colores;
    private javax.swing.JPanel panel_estado;
    private javax.swing.JToolBar.Separator separador1;
    private javax.swing.JToolBar.Separator separador2;
    private javax.swing.JToolBar.Separator separador3;
    private javax.swing.JSpinner spinner_grosor;
    // End of variables declaration//GEN-END:variables
}
