/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.vistas;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AppManager {
    
    private boolean Splash()
    {
        boolean resultado=true;
        Splash f=new Splash(null,true);
        f.setAlwaysOnTop(true);
        
        f.setVisible(true);
        return resultado;
    }
    
    public AppManager(){
        if(Splash()){
            Principal f=new Principal();
            // Establece el JFrame en pantalla completa
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f.setVisible(true);
        }
    }
}
