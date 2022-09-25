package br.com.igor.cm;

import br.com.igor.cm.Modelo.Tabuleiro;
import br.com.igor.cm.Visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {
       
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
        new TabuleiroConsole(tabuleiro);
    
    }
}
