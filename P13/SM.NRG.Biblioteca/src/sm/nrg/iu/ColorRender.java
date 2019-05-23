/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.nrg.iu;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author nazaret
 */
public class ColorRender implements ListCellRenderer<Color>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
        PanelColor p = new PanelColor(value);
        //p.setSize(80, 30);
        
        
        JButton b = new JButton();
        b.setBackground(value);
        
        return p;
    }
    
    
    
}
