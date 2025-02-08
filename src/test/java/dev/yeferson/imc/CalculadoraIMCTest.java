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

    @Test
    @DisplayName("Clasifica como 'Delgadez Moderada' cuando el IMC es mayor o igual a 16 y menor a 17")

    void imcDelgadezModeradaTest() {

        //Given     
        double peso = 50;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then
        assertThat(clasificacion, is("Delgadez moderada"));
    }

    @Test
    @DisplayName("Clasifica como 'Delgadez Leve' cuando el IMC es mayor o igual a 17 y menor a 18.5")

    void imcDelgadezLeveTest() {

        //Given     
        double peso = 60;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then
        assertThat(clasificacion, is("Delgadez leve"));
    }

    @Test
    @DisplayName("Clasifica como 'Peso Normal' cuando el IMC es mayor o igual a 18.5 y menor a 25")

    void imcPesoNormalTest() {

        //Given     
        double peso = 60;
        double estatura = 1.75;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then
        assertThat(clasificacion, is("Peso normal"));
    }

    @Test
    @DisplayName("Clasifica como 'Sobrepeso' cuando el IMC es mayor o igual a 25 y menor a 30")

    void imcSobrepesoTest() {

        //Given     
        double peso = 80;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);        
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then        
        assertThat(clasificacion, is("Sobrepeso"));
    }

    @Test
    @DisplayName("Clasifica como 'Obesidad Leve' cuando el IMC es mayor o igual a 30 y menor a 35")

    void imcObesidadLeveTest() {

        //Given     
        double peso = 90;
        double estatura = 1.70;
        CalculadoraIMC calculadora = new CalculadoraIMC();

        //When
        double imcCalculado = calculadora.calcularIMC(peso, estatura);        
        String clasificacion = calculadora.clasificarIMC(imcCalculado);

        //Then        
        assertThat(clasificacion, is("Obesidad leve"));
    }

    @Test
    @DisplayName("Clasifica como 'Obesidad Moderada' cuando el IMC es mayor o igual a 35 y menor a 40")

    void imcObesidadModeradaTest() {
        
    }
}
