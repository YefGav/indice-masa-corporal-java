package dev.yeferson.imc;

public class CalculadoraIMC {

    public double calcularIMC(double peso, double estatura) {
        return  peso / Math.pow(estatura, 2);
    }

}
