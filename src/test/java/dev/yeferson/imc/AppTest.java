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
    @DisplayName("Calcula y muestra el IMC correctamente para entradas válidas")
    void dadoPesoYEstaturaValidos_CuandoEjecutaApp_EntoncesCalculaIMCCorrectamente() {
        // Given
        String simulatedInput = "70\n1.75\n";
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // When
        App.main(new String[]{});

        // Then
        String appOutput = output.toString();
        assertThat(appOutput, containsString("Su IMC es: 22.86"));
        assertThat(appOutput, containsString("Clasificación: Peso normal"));

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);
    }
}