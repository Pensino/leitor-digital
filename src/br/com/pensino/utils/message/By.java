/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.message;

import javax.swing.ImageIcon;

/**
 *
 * @author emiliowl
 */
public class By {

    private ImageIcon message;
    
    public By(ImageIcon message) {
        super();
        this.message = message;
    }
    
    public ImageIcon getMessage() {
        if (message != null) {
            return this.message;
        }
        throw new IllegalStateException("Argumento de busca inicializado incorretamente");
    }

    public static By name(String fileName) {
        return new By(new ImageIcon(fileName + ".png"));
    }
}
