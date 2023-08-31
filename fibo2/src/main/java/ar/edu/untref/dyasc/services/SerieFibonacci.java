package ar.edu.untref.dyasc.services;

import ar.edu.untref.dyasc.utils.Constants;

public class SerieFibonacci {
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
    	String serie = "";
    	for (int i = 0; i < n; i++) {
    		serie += " " + SerieFibonacci.fibonacci(i);
    	}
    	return serie;
    }

    public static String fibonacciVertical(int n) {
    	String serie = "";
    	for (int i = 0; i < n; i++) {
    		serie += SerieFibonacci.fibonacci(i) + "\n";
    	}
    	return serie;
    }

    public static String fibonacciHorizontalInverso(int n) {
    	String serie = "";
    	for (int i = n-1; i >= 0; i--) {
    		serie += " " + SerieFibonacci.fibonacci(i);
    	}
    	return serie;
    }

    public static String fibonacciVerticalInverso(int n) {
    	String serie = "";
    	for (int i = n-1; i >= 0; i--) {
    		serie += SerieFibonacci.fibonacci(i) + "\n";
    	}
    	return serie;
    }

	 public static String getFibonacciPorDireccion(int n, String serie, String direccion) {
		 switch (direccion) {
			 case Constants.HORIZONTAL_DERECHA:
				 serie = SerieFibonacci.fibonacciHorizontal(n);
				 break;
			 case Constants.VERTICAL_DERECHA:
				 serie = SerieFibonacci.fibonacciVertical(n);
				 break;
			 case Constants.HORIZONTAL_INVERSA:
				 serie = SerieFibonacci.fibonacciHorizontalInverso(n);
				 break;
			 case Constants.VERTICAL_INVERSA:
				 serie = SerieFibonacci.fibonacciVerticalInverso(n);
				 break;
			 default:
				 System.out.println(Constants.LOG_OPCION_INVALIDA);
				 break;
		 }
		 return serie;
	 }
}
