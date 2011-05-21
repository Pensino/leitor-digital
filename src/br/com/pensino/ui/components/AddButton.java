/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.ui.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author emiliowl
 */
public class AddButton extends JLabel {
    
    private static AddButton instance = null;
    
    private AddButton(String path) {
        super(new ImageIcon(path));
    }
    
    public static AddButton getInstance() {
        if (instance == null) {
            instance = new AddButton("btn_add.png");
            instance.setBounds(480, 10, -1, -1);
            instance.initialize();
        }
        return instance;
    }

    private void initialize() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                instance.setIcon(new ImageIcon("btn_add_press.png"));
                instance.setIcon(new ImageIcon("btn_add_over.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                instance.setIcon(new ImageIcon("btn_add_press.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                instance.setIcon(new ImageIcon("btn_add_over.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                instance.setIcon(new ImageIcon("btn_add_over.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                instance.setIcon(new ImageIcon("btn_add.png"));
            }
        });
    }
}
