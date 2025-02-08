package dev.yeferson.imc;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.closeTo;

public class CalculadoraIMCTest {

    @Test
    @DisplayName("Calcula corretamente el IMC segun los valores ingresados")

    void calcularIMCTest() {

        //Given
        double peso = 70;        double estatura = 1.75;
        CalculadoraIMC calculadora =new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);

        //Then
        double imcEsperado = 22.86;
        assertThat(calculadora, instanceOf(CalculadoraIMC.class));
        assertThat(imcCalculado, closeTo(imcEsperado, 0.01));
    }

    @Test
    @DisplayName("Clasifica como 'Delgadez Severa' cuando el IMC es menor a 16")

    void imcDelgadezSeveraTest() {

        //Given     
        double peso = 40;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then
        assertThat(clasificacion, is("Delgadez severa"));
    }
}
