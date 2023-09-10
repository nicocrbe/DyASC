package ar.edu.untref.dyasc.services;

public class SerieFibonacciService {
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static String fibonacciHorizontal(int n) {
    	StringBuilder serie = new StringBuilder();
		serie.append("fibo<").append(n).append(">:");
		for (int i = 0; i <= n; i++) {
			serie.append(" ").append(SerieFibonacciService.fibonacci(i));
		}
		return serie.toString();
    }

    public static String fibonacciVertical(int n) {
    	StringBuilder serie = new StringBuilder();
		serie.append("fibo<").append(n).append(">:\n");
    	for (int i = 0; i < n; i++) {
    		serie.append(SerieFibonacciService.fibonacci(i)).append("\n");
    	}
    	return serie.toString();
    }

    public static String fibonacciHorizontalInverso(int n) {
		StringBuilder serie = new StringBuilder();
		serie.append("fibo<").append(n).append(">:");
		for (int i = n; i >= 0; i--) {
			serie.append(" ").append(SerieFibonacciService.fibonacci(i));
		}
		return serie.toString();
	}

    public static String fibonacciVerticalInverso(int n) {
    	StringBuilder serie = new StringBuilder();
		serie.append("fibo<").append(n).append(">:\n");
    	for (int i = n-1; i >= 0; i--) {
    		serie.append(SerieFibonacciService.fibonacci(i)).append("\n");
    	}
    	return serie.toString();
    }

	public static String sumatoriaFibonacci(int numero) {
		int sumatoria = 0;
		for (int i = 0; i < numero; i++) {
			sumatoria += SerieFibonacciService.fibonacci(i);
		}
		return String.valueOf(sumatoria);
	}
}
