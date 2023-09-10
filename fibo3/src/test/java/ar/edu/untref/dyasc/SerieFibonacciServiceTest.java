package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.services.SerieFibonacciService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SerieFibonacciServiceTest {
    @Test
    public void testFibonacci10() {
        Assertions.assertThat(SerieFibonacciService.fibonacci(0)).isEqualTo(0);
        Assertions.assertThat(SerieFibonacciService.fibonacci(1)).isEqualTo(1);
        Assertions.assertThat(SerieFibonacciService.fibonacci(2)).isEqualTo(1);
        Assertions.assertThat(SerieFibonacciService.fibonacci(3)).isEqualTo(2);
        Assertions.assertThat(SerieFibonacciService.fibonacci(4)).isEqualTo(3);
        Assertions.assertThat(SerieFibonacciService.fibonacci(5)).isEqualTo(5);
        Assertions.assertThat(SerieFibonacciService.fibonacci(6)).isEqualTo(8);
        Assertions.assertThat(SerieFibonacciService.fibonacci(7)).isEqualTo(13);
        Assertions.assertThat(SerieFibonacciService.fibonacci(8)).isEqualTo(21);
        Assertions.assertThat(SerieFibonacciService.fibonacci(9)).isEqualTo(34);
        Assertions.assertThat(SerieFibonacciService.fibonacci(10)).isEqualTo(55);
    }

    @Test
    public void testFibonacciHorizontal() {
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(0)).isEqualTo("fibo<0>: 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(1)).isEqualTo("fibo<1>: 0 1");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(2)).isEqualTo("fibo<2>: 0 1 1");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(3)).isEqualTo("fibo<3>: 0 1 1 2");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(4)).isEqualTo("fibo<4>: 0 1 1 2 3");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(5)).isEqualTo("fibo<5>: 0 1 1 2 3 5");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontal(6)).isEqualTo("fibo<6>: 0 1 1 2 3 5 8");
    }

    @Test
    public void testFibonacciVertical() {
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(0)).isEqualTo("fibo<0>:\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(1)).isEqualTo("fibo<1>:\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(2)).isEqualTo("fibo<2>:\n0\n1\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(3)).isEqualTo("fibo<3>:\n0\n1\n1\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(4)).isEqualTo("fibo<4>:\n0\n1\n1\n2\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(5)).isEqualTo("fibo<5>:\n0\n1\n1\n2\n3\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVertical(6)).isEqualTo("fibo<6>:\n0\n1\n1\n2\n3\n5\n");
    }

   @Test
    public void testFibonacciHorizontalInverso() {
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(0)).isEqualTo("fibo<0>: 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(1)).isEqualTo("fibo<1>: 1 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(2)).isEqualTo("fibo<2>: 1 1 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(3)).isEqualTo("fibo<3>: 2 1 1 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(4)).isEqualTo("fibo<4>: 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(5)).isEqualTo("fibo<5>: 5 3 2 1 1 0");
        Assertions.assertThat(SerieFibonacciService.fibonacciHorizontalInverso(6)).isEqualTo("fibo<6>: 8 5 3 2 1 1 0");
    }

    @Test
    public void testFibonacciVerticalInverso() {
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(0)).isEqualTo("fibo<0>:\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(1)).isEqualTo("fibo<1>:\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(2)).isEqualTo("fibo<2>:\n1\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(3)).isEqualTo("fibo<3>:\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(4)).isEqualTo("fibo<4>:\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(5)).isEqualTo("fibo<5>:\n3\n2\n1\n1\n0\n");
        Assertions.assertThat(SerieFibonacciService.fibonacciVerticalInverso(6)).isEqualTo("fibo<6>:\n5\n3\n2\n1\n1\n0\n");
    }

    @Test
    public void testSumatoriaFibonacci() {
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(0)).isEqualTo("0");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(1)).isEqualTo("0");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(2)).isEqualTo("1");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(3)).isEqualTo("2");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(4)).isEqualTo("4");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(5)).isEqualTo("7");
        Assertions.assertThat(SerieFibonacciService.sumatoriaFibonacci(6)).isEqualTo("12");
    }
}
