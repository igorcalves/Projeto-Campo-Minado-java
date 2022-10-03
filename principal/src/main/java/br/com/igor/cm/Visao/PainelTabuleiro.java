package br.com.igor.cm.Visao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

import br.com.igor.cm.Modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(
                tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {
            if (e.isGanho()) {
                JOptionPane.showMessageDialog(this, e);
            }

        });

    }

}
