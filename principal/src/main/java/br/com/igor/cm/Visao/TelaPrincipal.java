package br.com.igor.cm.Visao;

import javax.swing.JFrame;
import java.awt.*;

public class TelaPrincipal extends JFrame{
    
    public TelaPrincipal(){
        setTitle("Campo Minado");
        setSize(690,438);
        setVisible(true);
    }
        


    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
