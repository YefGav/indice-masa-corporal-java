package dev.yeferson.imc;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.closeTo;

public class CalculadoraIMCTest {

    @Test
    @DisplayName("Calcula corretamente el IMC segun los valores ingresados")

    void calcularIMC() {

        //Given
        double peso = 70;
        double altura = 1.75;
        CalculadoraIMC calculadora =new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, altura);

        //Then
        double imcEsperado = 22.86;
        assertThat(calculadora, instanceOf(CalculadoraIMC.class));
        assertThat(imcCalculado, closeTo(imcEsperado, 0.01));


      
        
    }
}
