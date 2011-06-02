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
public class MessageService {
    
    public static ImageIcon getMessage(By kindOfSearch) {
        return kindOfSearch.getMessage();
    }
 
    
}
