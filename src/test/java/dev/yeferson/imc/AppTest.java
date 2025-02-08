package dev.yeferson.imc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class AppTest {


    @Test
    @DisplayName("Muestra mensaje de error para entrada inválida")
    void muestraMensajeDeErrorTest() {
        // Given
        String simulatedInput = "70\n0\n";
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // When
        App.main(new String[]{});

        // Then
        String appOutput = output.toString();
        assertThat(appOutput, containsString("Error: Los valores de peso y estatura deben ser mayores a cero"));

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Muestra mensaje de error para entrada inválida (peso cero)")
    void muestraMensajeDeErrorParaPesoCeroTest() {
        // Given
        String simulatedInput = "0\n1.75\n";
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // When
        App.main(new String[]{});

        // Then
        String appOutput = output.toString();
        assertThat(appOutput, containsString("Error: Ocurrió un error inesperado. Por favor, intente de nuevo."));

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
