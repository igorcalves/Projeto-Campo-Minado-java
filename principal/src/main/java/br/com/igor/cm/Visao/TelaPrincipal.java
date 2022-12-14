package br.com.igor.cm.Visao;

import javax.swing.JFrame;

import br.com.igor.cm.Modelo.Tabuleiro;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

        Tabuleiro tabuleiro = new Tabuleiro(50, 50, 2);

        add(new PainelTabuleiro(tabuleiro));
        setTitle("Campo Minado");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
