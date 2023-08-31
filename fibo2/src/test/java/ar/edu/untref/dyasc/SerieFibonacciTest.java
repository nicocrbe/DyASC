package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.services.SerieFibonacci;
import ar.edu.untref.dyasc.utils.Constants;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SerieFibonacciTest {
    @Test
    public void testFibonacci10() {
        Assertions.assertThat(SerieFibonacci.fibonacci(0)).isEqualTo(0);
        Assertions.assertThat(SerieFibonacci.fibonacci(1)).isEqualTo(1);
        Assertions.assertThat(SerieFibonacci.fibonacci(2)).isEqualTo(1);
        Assertions.assertThat(SerieFibonacci.fibonacci(3)).isEqualTo(2);
        Assertions.assertThat(SerieFibonacci.fibonacci(4)).isEqualTo(3);
        Assertions.assertThat(SerieFibonacci.fibonacci(5)).isEqualTo(5);
        Assertions.assertThat(SerieFibonacci.fibonacci(6)).isEqualTo(8);
        Assertions.assertThat(SerieFibonacci.fibonacci(7)).isEqualTo(13);
        Assertions.assertThat(SerieFibonacci.fibonacci(8)).isEqualTo(21);
        Assertions.assertThat(SerieFibonacci.fibonacci(9)).isEqualTo(34);
        Assertions.assertThat(SerieFibonacci.fibonacci(10)).isEqualTo(55);
    }

    @Test
    public void testFibonacciHorizontal() {
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(0)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(1)).isEqualTo(" 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(2)).isEqualTo(" 0 1");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(3)).isEqualTo(" 0 1 1");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(4)).isEqualTo(" 0 1 1 2");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(5)).isEqualTo(" 0 1 1 2 3");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(6)).isEqualTo(" 0 1 1 2 3 5");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(7)).isEqualTo(" 0 1 1 2 3 5 8");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(8)).isEqualTo(" 0 1 1 2 3 5 8 13");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(9)).isEqualTo(" 0 1 1 2 3 5 8 13 21");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontal(10)).isEqualTo(" 0 1 1 2 3 5 8 13 21 34");
    }

    @Test
    public void testFibonacciVertical() {
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(0)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(1)).isEqualTo("0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(2)).isEqualTo("0\n1\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(3)).isEqualTo("0\n1\n1\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(4)).isEqualTo("0\n1\n1\n2\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(5)).isEqualTo("0\n1\n1\n2\n3\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(6)).isEqualTo("0\n1\n1\n2\n3\n5\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(7)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(8)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(9)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n21\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVertical(10)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n");
    }

    @Test
    public void testFibonacciHorizontalInverso() {
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(0)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(1)).isEqualTo(" 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(2)).isEqualTo(" 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(3)).isEqualTo(" 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(4)).isEqualTo(" 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(5)).isEqualTo(" 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(6)).isEqualTo(" 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(7)).isEqualTo(" 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(8)).isEqualTo(" 13 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(9)).isEqualTo(" 21 13 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.fibonacciHorizontalInverso(10)).isEqualTo(" 34 21 13 8 5 3 2 1 1 0");
    }

    @Test
    public void testFibonacciVerticalInverso() {
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(0)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(1)).isEqualTo("0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(2)).isEqualTo("1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(3)).isEqualTo("1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(4)).isEqualTo("2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(5)).isEqualTo("3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(6)).isEqualTo("5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(7)).isEqualTo("8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(8)).isEqualTo("13\n8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(9)).isEqualTo("21\n13\n8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.fibonacciVerticalInverso(10)).isEqualTo("34\n21\n13\n8\n5\n3\n2\n1\n1\n0\n");
    }

    @Test
    public void testGetFibonacciPorDireccion() {
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(0, "", Constants.HORIZONTAL_DERECHA)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(1, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(2, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(3, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(4, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(5, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(6, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3 5");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(7, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3 5 8");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(8, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3 5 8 13");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(9, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3 5 8 13 21");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(10, "", Constants.HORIZONTAL_DERECHA)).isEqualTo(" 0 1 1 2 3 5 8 13 21 34");

        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(0, "", Constants.VERTICAL_DERECHA)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(1, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(2, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(3, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(4, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(5, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(6, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n5\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(7, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(8, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(9, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n21\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(10, "", Constants.VERTICAL_DERECHA)).isEqualTo("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n");

        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(0, "", Constants.HORIZONTAL_INVERSA)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(1, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(2, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(3, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(4, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(5, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(6, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(7, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(8, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 13 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(9, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 21 13 8 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(10, "", Constants.HORIZONTAL_INVERSA)).isEqualTo(" 34 21 13 8 5 3 2 1 1 0");

        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(0, "", Constants.VERTICAL_INVERSA)).isEqualTo("");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(1, "", Constants.VERTICAL_INVERSA)).isEqualTo("0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(2, "", Constants.VERTICAL_INVERSA)).isEqualTo("1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(3, "", Constants.VERTICAL_INVERSA)).isEqualTo("1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(4, "", Constants.VERTICAL_INVERSA)).isEqualTo("2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(5, "", Constants.VERTICAL_INVERSA)).isEqualTo("3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(6, "", Constants.VERTICAL_INVERSA)).isEqualTo("5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(7, "", Constants.VERTICAL_INVERSA)).isEqualTo("8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(8, "", Constants.VERTICAL_INVERSA)).isEqualTo("13\n8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(9, "", Constants.VERTICAL_INVERSA)).isEqualTo("21\n13\n8\n5\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacci.getFibonacciPorDireccion(10, "", Constants.VERTICAL_INVERSA)).isEqualTo("34\n21\n13\n8\n5\n3\n2\n1\n1\n0\n");
    }
}
