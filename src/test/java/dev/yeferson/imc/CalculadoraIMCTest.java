package dev.yeferson.imc;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.Test;

import dev.yeferson.imc.model.CalculadoraIMC;
import static org.hamcrest.Matchers.closeTo;

public class CalculadoraIMCTest {

    @Test
    @DisplayName("Calcula correctamente el IMC según los valores ingresados")
    void calcularIMCTest() {
        // Given
        double peso = 70;        
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();

        // Then
        double imcEsperado = 22.86;
        assertThat(calculadora, instanceOf(CalculadoraIMC.class));
        assertThat(imcCalculado, closeTo(imcEsperado, 0.01));
    }

    @Test
    @DisplayName("Clasifica como 'Delgadez severa' cuando el IMC es menor a 16")
    void imcDelgadezSeveraTest() {
        // Given     
        double peso = 40;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Delgadez severa"));
    }

    @Test
    @DisplayName("Clasifica como 'Delgadez moderada' cuando el IMC es mayor o igual a 16 y menor a 17")
    void imcDelgadezModeradaTest() {
        // Given     
        double peso = 50;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Delgadez moderada"));
    }

    @Test
    @DisplayName("Clasifica como 'Delgadez leve' cuando el IMC es mayor o igual a 17 y menor a 18.5")
    void imcDelgadezLeveTest() {
        // Given     
        double peso = 55;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Delgadez leve"));
    }

    @Test
    @DisplayName("Clasifica como 'Peso normal' cuando el IMC es mayor o igual a 18.5 y menor a 25")
    void imcPesoNormalTest() {
        // Given     
        double peso = 60;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Peso normal"));
    }

    @Test
    @DisplayName("Clasifica como 'Sobrepeso' cuando el IMC es mayor o igual a 25 y menor a 30")
    void imcSobrepesoTest() {
        // Given     
        double peso = 80;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then        
        assertThat(clasificacion, is("Sobrepeso"));
    }

    @Test
    @DisplayName("Clasifica como 'Obesidad leve' cuando el IMC es mayor o igual a 30 y menor a 35")
    void imcObesidadLeveTest() {
        // Given     
        double peso = 90;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then        
        assertThat(clasificacion, is("Obesidad leve"));
    }

    @Test
    @DisplayName("Clasifica como 'Obesidad moderada' cuando el IMC es mayor o igual a 35 y menor a 40")
    void imcObesidadModeradaTest() {
        // Given
        double peso = 105;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Obesidad moderada"));
    }

    @Test
    @DisplayName("Clasifica como 'Obesidad mórbida' cuando el IMC es mayor o igual a 40")
    void imcObesidadMorbidaTest() {
        // Given
        double peso = 120;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);

        // When
        double imcCalculado = calculadora.calcularIMC();
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        // Then
        assertThat(clasificacion, is("Obesidad mórbida"));
    }
}
