package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraTests {

    @Test
    public void testGetMemoriaIgualZeroSemParametro() {
        // Método a ser testado: getMemoria
        // Cenário de Teste (Entradas): Nenhuma entrada, criação de uma nova calculadora sem parâmetros.
        // Resultado Esperado: A memória deve ser inicializada como 0.
        // Resultado Obtido: A memória foi inicializada como 0.
        Calculadora calculadora = new Calculadora();
        assertEquals(0, calculadora.getMemoria());
    }

    @Test
    public void testGetMemoriaIgualZeroComParametro() {
        // Método a ser testado: getMemoria
        // Cenário de Teste (Entradas): Valor de memória inicializado com 3.
        // Resultado Esperado: A memória deve ser inicializada com o valor passado como parâmetro (3).
        // Resultado Obtido: A memória foi inicializada com o valor passado como parâmetro (3).
        Calculadora calculadora = new Calculadora(3);
        assertEquals(3, calculadora.getMemoria());
    }

    @Test
    void testDividirPorZero() {
        // Método a ser testado: dividir
        // Cenário de Teste (Entradas): Divisão por zero.
        // Resultado Esperado: Deve lançar uma exceção do tipo Exception.
        // Resultado Obtido: Uma exceção do tipo Exception foi lançada.
        Calculadora calculadora = new Calculadora(3);
        assertThrows(Exception.class, () -> {
            calculadora.dividir(0);
        });
    }

    @Test
    void testDividirPorNumeroPositivo() throws Exception {
        // Método a ser testado: dividir
        // Cenário de Teste (Entradas): Divisão por 3.
        // Resultado Esperado: A memória deve ser dividida por 3.
        // Resultado Obtido: A memória foi dividida por 3.
        Calculadora calculadora = new Calculadora(3);
        calculadora.dividir(3);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void testMultiplicar() {
        // Método a ser testado: multiplicar
        // Cenário de Teste (Entradas): Multiplicação por 3.
        // Resultado Esperado: A memória deve ser multiplicada por 3.
        // Resultado Obtido: A memória foi multiplicada por 3.
        Calculadora calculadora = new Calculadora(3);
        calculadora.multiplicar(3);
        assertEquals(9, calculadora.getMemoria());
    }

    @Test
    void testSomar() {
        // Método a ser testado: somar
        // Cenário de Teste (Entradas): Adição de -3.
        // Resultado Esperado: A memória deve ser 0.
        // Resultado Obtido: A memória foi 0.
        Calculadora calculadora = new Calculadora(3);
        calculadora.somar(-3);
        assertEquals(0, calculadora.getMemoria());
    }

    @Test
    void testSubtrair() {
        // Método a ser testado: subtrair
        // Cenário de Teste (Entradas): Subtração de 3.
        // Resultado Esperado: A memória deve ser 0.
        // Resultado Obtido: A memória foi 0.
        Calculadora calculadora = new Calculadora(3);
        calculadora.subtrair(3);
        assertEquals(0, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPorUm() throws Exception {
        // Método a ser testado: exponenciar
        // Cenário de Teste (Entradas): Exponenciação por 1.
        // Resultado Esperado: A memória deve ser igual ao valor inicial (3).
        // Resultado Obtido: A memória é igual ao valor inicial (3).
        Calculadora calculadora = new Calculadora(3);
        calculadora.exponenciar(1);
        assertEquals(3, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPorDez() throws Exception {
        // Método a ser testado: exponenciar
        // Cenário de Teste (Entradas): Exponenciação por 10.
        // Resultado Esperado: A memória deve ser 59049 (3^10).
        // Resultado Obtido: A memória é 59049 (3^10).
        Calculadora calculadora = new Calculadora(3);
        calculadora.exponenciar(10);
        assertEquals(59049, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPorValorMaiorQueDez() {
        // Método a ser testado: exponenciar
        // Cenário de Teste (Entradas): Exponenciação por 11.
        // Resultado Esperado: Deve lançar uma exceção do tipo Exception com mensagem "Expoente incorreto, valor máximo é 10."
        // Resultado Obtido: Uma exceção do tipo Exception foi lançada com a mensagem correta.
        Calculadora calculadora = new Calculadora(3);
        Exception exception = assertThrows(Exception.class, () -> {
            calculadora.exponenciar(11);
        });
        assertEquals("Expoente incorreto, valor máximo é 10.", exception.getMessage());
    }

    @Test
    void testZerarMemoria() {
        // Método a ser testado: zerarMemoria
        // Cenário de Teste (Entradas): Nenhuma entrada, chamada do método zerarMemoria.
        // Resultado Esperado: A memória deve ser zerada, ou seja, 0.
        // Resultado Obtido: A memória foi zerada, ou seja, 0.
        Calculadora calculadora = new Calculadora(10);
        calculadora.zerarMemoria();
        assertEquals(0, calculadora.getMemoria());
    }
}
