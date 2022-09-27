package br.com.igor.cm.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.igor.cm.Excecao.ExplosaoException;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void abrir(int linha, int coluna) {
        try {
            campos.parallelStream()
                    .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                    .findFirst()
                    .ifPresent(c -> c.abrir());
        } catch (ExplosaoException e) {
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }

    }

    public void alternarMarcacao(int linha, int coluna) {
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(c -> c.alternarMarcacao());

    }

    private void gerarCampos() {

        for (int Linha = 0; Linha < linhas; Linha++) {
            for (int Coluna = 0; Coluna < colunas; Coluna++) {
                campos.add(new Campo(Linha, Coluna));
            }
        }

    }

    private void associarVizinhos() {

        for (Campo c1 : campos) {
            for (Campo c2 : campos) {
                c1.adicionarVizinho(c2);
            }

        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = c -> c.isMinado();
        do {
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();
        } while (minasArmadas < minas);
    }

    public boolean objetivoAcalcado() {
        return campos.stream().allMatch(c -> c.objetivoAcalcado());
    }

    public void reiniciar() {
        campos.stream().forEach(c -> c.reiniciar());
        sortearMinas();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int c = 0; c < colunas; c++) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }
        sb.append("\n");
        int i = 0;
        for (int L = 0; L < linhas; L++) {
            sb.append(L);
            sb.append(" ");

            for (int C = 0; C < colunas; C++) {
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
