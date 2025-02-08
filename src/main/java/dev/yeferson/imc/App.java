package dev.yeferson.imc;

import dev.yeferson.imc.model.CalculadoraIMC;
import dev.yeferson.imc.view.InterfazUsuario;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        InterfazUsuario interfazUsuario = new InterfazUsuario();

        try {
            double peso = interfazUsuario.leerPeso();
            double estatura = interfazUsuario.leerEstatura();

            CalculadoraIMC calculadora = new CalculadoraIMC(peso, estatura);
            double imc = calculadora.calcularIMC();
            String clasificacion = calculadora.clasificarIMC(imc);

            interfazUsuario.mostrarResultado(imc, clasificacion);

        } catch (IllegalArgumentException e) {
            interfazUsuario.mostrarError(e.getMessage());
        } catch (Exception e) {
            interfazUsuario.mostrarError("Ocurrió un error inesperado. Por favor, intente de nuevo.");
        } finally {
            interfazUsuario.cerrar();
        }
    }
}

