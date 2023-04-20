import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void restaValorAbsoluto() {
        int esperado = 4;
        int resultado = Main.restaValorAbsoluto(136,132);
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    void restaValorAbsolutoNegativo() {
        int esperado =4;
        int resultado = Main.restaValorAbsoluto(136,140);
        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    void sumaDeMultiplicaciones() {

        String rutPrueba = "12.345.678-5";
        int esperado = 138;
        int resultado = Main.multiplicaciones(Main.reversarCadena(Main.quitarCaracteres(Main.tomarPrimeros(rutPrueba))));
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    void calcularDV() {
        String rutPrueba = "12.345.678-5";
        String esperado = "5";
        String resultado = Main.calcularDV(rutPrueba);
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    void calcularDVmiRut() {
        String rutPrueba = "20281663-0";
        String esperado = "0";
        String resultado = Main.calcularDV(rutPrueba);
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    void calcularDVSinDV() {
        String rutPrueba = "20611083";
        String esperado = "k";
        String resultado = Main.calcularDV(rutPrueba);
        Assertions.assertEquals(esperado, resultado);
    }
}