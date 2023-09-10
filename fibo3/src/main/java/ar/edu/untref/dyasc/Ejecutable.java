package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.services.EjecutorFibonacciService;
import ar.edu.untref.dyasc.utils.ConstantsLogs;


public class Ejecutable {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(ConstantsLogs.LOG_ERROR_PARAMETROS);
            return;
        }

        EjecutorFibonacciService.parsearYEjecutarFibo(args);
    }
}
