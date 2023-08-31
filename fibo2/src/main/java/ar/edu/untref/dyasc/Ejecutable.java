package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.utils.Constants;

import static ar.edu.untref.dyasc.services.EjecutorFibonacci.parsearYEjecutarFibo;

public class Ejecutable {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(Constants.LOG_ERROR_PARAMETROS);
            return;
        }
        parsearYEjecutarFibo(args);
    }
}
