package br.com.igor.cm.Modelo;

@FunctionalInterface
public interface CampoObservador {
    public void eventoOcorreu(Campo campo, CampoEvento evento);
}
