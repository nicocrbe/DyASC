package ar.edu.untref.dyasc.services;

import ar.edu.untref.dyasc.utils.Constants;

public class EjecutorFibonacci {
    public static void parsearYEjecutarFibo(String[] args) {
        int n;
        String serie = "";

        if(args[0].matches("[0-9]+")) {
            n = Integer.parseInt(args[0]);
            serie = SerieFibonacci.fibonacciHorizontal(n);
        }else if(args[0].contains("-o") && args.length == 2){
            n = Integer.parseInt(args[1]);
            String[] parametros = args[0].split("=");
            if(parametros.length != 2){
                System.out.println(Constants.LOG_OPCION_INVALIDA);
                return;
            }
            String direccion = parametros[1];
            serie = SerieFibonacci.getFibonacciPorDireccion(n, serie, direccion);
        }else{
            System.out.println(Constants.LOG_OPCION_INVALIDA);
        }
        System.out.println(serie);
    }
}
