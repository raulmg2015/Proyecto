/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tiendavirtual;

import javax.swing.JFrame;

/**
 *
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
     static PaginaPrincipal oVentana;
    public static void main(String[] args) {
        oVentana= new PaginaPrincipal();
        oVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        oVentana.setVisible(true);
        oVentana.setLocationRelativeTo(null);
        
        
    }
    public static void regresa(){
       oVentana.setVisible(true);
       oVentana.setLocationRelativeTo(null);
    }

}
