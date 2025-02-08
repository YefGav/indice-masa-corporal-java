package dev.yeferson.imc.model;

public class CalculadoraIMC {
    private double peso;
    private double estatura;

    public CalculadoraIMC(double peso, double estatura) {
        if (peso <= 0 || estatura <= 0) {
            throw new IllegalArgumentException("Los valores de peso y estatura deben ser mayores a cero");
        }
        this.peso = peso;
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public double calcularIMC() {
        return peso / Math.pow(estatura, 2);
    }

    public String clasificarIMC(double imc) {
        
        if (imc < 16) return "Delgadez severa";
        if (imc < 17) return "Delgadez moderada";
        if (imc < 18.5) return "Delgadez leve";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidad leve";
        if (imc < 40) return "Obesidad moderada";
        return "Obesidad mórbida";
    }
}
