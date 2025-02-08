package dev.yeferson.imc;

public class CalculadoraIMC {

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

}
