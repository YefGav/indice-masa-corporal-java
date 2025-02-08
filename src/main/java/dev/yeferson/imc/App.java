package dev.yeferson.imc;

import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Ingrese su peso en kilogramos: ");
            double peso = scanner.nextDouble();

            System.out.print("Ingrese su estatura en metros: ");
            double estatura = scanner.nextDouble();

            CalculadoraIMC calculadora = new CalculadoraIMC();

            double imc = calculadora.calcularIMC(peso, estatura);
            String clasificacion = calculadora.clasificarIMC(imc);

            System.out.printf("Su IMC es: %.2f%n", imc);
            System.out.println("Su clasificación es: " + clasificacion);

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, por favor ingrese valores validos.");
        } finally {
            scanner.close();
        }

    }

}
