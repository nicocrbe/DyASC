package ar.edu.untref.dyasc.services;

import ar.edu.untref.dyasc.models.RequerimientoEntrada;
import ar.edu.untref.dyasc.utils.EnumModos;

import java.util.Objects;

public class EjecutorFibonacciService {

    public static void parsearYEjecutarFibo(String[] args) {

        String serie = "";
        AdministradorRequerimientosService administradorRequerimientosService = new AdministradorRequerimientosService();
        administradorRequerimientosService.getRequerimientos(args);

        RequerimientoEntrada requerimientos = administradorRequerimientosService.getRequerimientoEntrada();

        if((!requerimientos.isModoEnabled() || requerimientos.getModo().equals(EnumModos.LISTA)) && Objects.nonNull(requerimientos.getDireccion())){
            switch (requerimientos.getDireccion()){
                case HORIZONTAL_DERECHA:
                    serie = SerieFibonacciService.fibonacciHorizontal(requerimientos.getNumero());
                    break;
                case VERTICAL_DERECHA:
                    serie = SerieFibonacciService.fibonacciVertical(requerimientos.getNumero());
                    break;
                case HORIZONTAL_INVERSA:
                    serie = SerieFibonacciService.fibonacciHorizontalInverso(requerimientos.getNumero());
                    break;
                case VERTICAL_INVERSA:
                    serie = SerieFibonacciService.fibonacciVerticalInverso(requerimientos.getNumero());
                    break;
            }
        }

        if(requerimientos.isModoEnabled() && requerimientos.getModo().equals(EnumModos.SUMATORIA)){
            serie = SerieFibonacciService.sumatoriaFibonacci(requerimientos.getNumero());
            serie = "fibo<" + requerimientos.getNumero() + ">s: " + serie;
        }

        if(requerimientos.isSalidaTextoEnabled()){
            ImpresorArchivosService.exportarArchivoTxt(serie, requerimientos.getNombreArchivo());
            System.out.println("fibo<" + requerimientos.getNumero() + "> guardado en " + requerimientos.getNombreArchivo() + ".txt");
        } else {
            System.out.println(serie);
        }
    }


}
