package br.com.igor.cm.Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CampoTeste {
    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
    	  campo = new Campo(3,3);
    }
    
    @Test
    void testeVizinhoRealDistancia1Esquerda(){
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);   
   
    }

    @Test
    void testeVizinhoRealDistancia1Direita(){
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);   
   
    }

    @Test
    void testeVizinhoRealDistancia1EmCima(){
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);   
   
    }
    @Test
    void testeVizinhoRealDistancia1EmBaixo(){
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);   
   
    }


    @Test
    void testeVizinhoRealDistancia2(){
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);   
   
    }

    @Test
    void testeVizinhoNaoVizinho(){
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);   
   
    }




}
