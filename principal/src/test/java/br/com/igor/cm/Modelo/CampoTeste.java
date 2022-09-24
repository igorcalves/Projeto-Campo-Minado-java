package br.com.igor.cm.Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.igor.cm.Excecao.ExplosaoException;

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
        Campo vizinho = new Campo(1, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);   
   
    }
    @Test
    void teteValorPdraoMarcado(){
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacaoDuasChamadsa(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }
    
    @Test
    void testesAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());
    }

    @Test
    void testesAbrirNaoMinadoMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testesAbrirMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testesAbrirMinadoNaoMarcado(){
        campo.minar();

        assertThrows(ExplosaoException.class, () ->{
            campo.abrir();
               });
    }

    @Test
    void testesAbrirVizinhos1(){
        Campo campo11 = new Campo(1,1);
        Campo campo22 = new Campo(2,2);

        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testesAbrirVizinhos2(){
        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,1);
        campo12.minar();
        
        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo11);
       
        campo.adicionarVizinho(campo22);


        
        campo.abrir();

        assertTrue(campo22.isAberto() && !campo11.isFechado());
    }




}
