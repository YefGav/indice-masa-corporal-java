package dev.yeferson.imc.view;

import java.util.Scanner;

public class InterfazUsuario {
     private final Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double leerPeso() {
        System.out.print("Ingrese su peso en kilogramos: ");
        return scanner.nextDouble();
    }

    public double leerEstatura() {
        System.out.print("Ingrese su estatura en metros: ");
        return scanner.nextDouble();
    }

    public void mostrarResultado(double imc, String clasificacion) {
        System.out.printf("Su IMC es: %.2f%n", imc);
        System.out.println("Su clasificación es: " + clasificacion);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void cerrar() {
        scanner.close();
    }

}
