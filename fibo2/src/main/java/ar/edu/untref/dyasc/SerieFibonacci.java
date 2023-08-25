package ar.edu.untref.dyasc;
 /*
 * Partiendo del ejercicio Fibonacci, copiarlo en otra carpeta llamada Fibo2 y a partir de eso realizar las modificaciones necesarias para soportar las siguientes opciones:

Orientación: horizontal (h) o vertical (v)
Dirección: directa (d) o inversa (i)
Si es especifica una opción no válida debe indicarse "Opción no válida".

El programa puede invocarse sin la opción "-o" en cuyo caso el comportamiento debe ser por default hd.
*
* Ejemplo de ejecución:
* java -jar fibo.jar -o=vd 5
*/
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
			 case "hd":
				 serie = SerieFibonacci.fibonacciHorizontal(n);
				 break;
			 case "vd":
				 serie = SerieFibonacci.fibonacciVertical(n);
				 break;
			 case "hi":
				 serie = SerieFibonacci.fibonacciHorizontalInverso(n);
				 break;
			 case "vi":
				 serie = SerieFibonacci.fibonacciVerticalInverso(n);
				 break;
			 default:
				 System.out.println("Opción no válida");
				 break;
		 }
		 return serie;
	 }
}
