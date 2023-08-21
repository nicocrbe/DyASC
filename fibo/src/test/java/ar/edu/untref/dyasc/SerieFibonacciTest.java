package ar.edu.untref.dyasc;

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
}
