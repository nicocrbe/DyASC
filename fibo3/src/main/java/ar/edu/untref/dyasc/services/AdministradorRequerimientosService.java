package ar.edu.untref.dyasc.services;

import ar.edu.untref.dyasc.models.RequerimientoEntrada;
import ar.edu.untref.dyasc.utils.ConstantsLogs;
import ar.edu.untref.dyasc.utils.EnumDirecciones;
import ar.edu.untref.dyasc.utils.EnumModos;

public class AdministradorRequerimientosService {

    private final RequerimientoEntrada requerimientoEntrada;

    public AdministradorRequerimientosService() {
        this.requerimientoEntrada = new RequerimientoEntrada();
    }

    public void getRequerimientos(String[] args) {
        for (String arg : args) {
            if (arg.matches("[0-9]+")) {
                int n = Integer.parseInt(arg);
                this.requerimientoEntrada.setNumero(n);
            } else if (arg.contains("-m")) {
                this.requerimientoEntrada.setModoEnabled(true);
                String paramModo = splitParametros(arg);
                this.requerimientoEntrada.setModo(EnumModos.getModo(paramModo));
            } else if (arg.contains("-o")) {
                this.requerimientoEntrada.setOrientacionEnabled(true);
                String paramDireccion = splitParametros(arg);
                this.requerimientoEntrada.setDireccion(EnumDirecciones.getDireccion(paramDireccion));
            } else if (arg.contains("-f")) {
                this.requerimientoEntrada.setSalidaTextoEnabled(true);
                String nombreArchivo = splitParametros(arg);
                this.requerimientoEntrada.setNombreArchivo(nombreArchivo);
            } else {
                System.out.println(ConstantsLogs.LOG_OPCION_INVALIDA);
            }
        }
        if(this.requerimientoEntrada.getNumero() == 0){
            System.out.println(ConstantsLogs.LOG_ERROR_PARAMETROS);
            return;
        }
        setOpcionesDefault();
    }

    private void setOpcionesDefault() {
        if(this.requerimientoEntrada.getModo() == null){
            System.out.println(ConstantsLogs.LOG_MODO_LISTA_DEFAULT);
            this.requerimientoEntrada.setModo(EnumModos.LISTA);
        }
        if(this.requerimientoEntrada.getDireccion() == null && !this.requerimientoEntrada.getModo().equals(EnumModos.SUMATORIA)){
            System.out.println(ConstantsLogs.LOG_DIRECCION_HD_DEFAULT);
            this.requerimientoEntrada.setDireccion(EnumDirecciones.HORIZONTAL_DERECHA);
        }
        if(this.requerimientoEntrada.getNombreArchivo() == null && this.requerimientoEntrada.isSalidaTextoEnabled()){
            System.out.println(ConstantsLogs.LOG_NOMBRE_ARCHIVO_DEFAULT);
            this.requerimientoEntrada.setNombreArchivo("fibo");
        }
    }

    private String splitParametros(String arg) {
        String[] parametros = arg.split("=");
        if(parametros.length != 2){
            System.out.println(ConstantsLogs.LOG_OPCION_INVALIDA);
            return null;
        }
        return parametros[1];
    }

    public RequerimientoEntrada getRequerimientoEntrada() {
        return requerimientoEntrada;
    }
}
