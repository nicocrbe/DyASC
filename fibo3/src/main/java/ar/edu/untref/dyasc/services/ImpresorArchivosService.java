package ar.edu.untref.dyasc.services;

import ar.edu.untref.dyasc.utils.ConstantsLogs;

import java.io.FileWriter;
import java.io.IOException;

public class ImpresorArchivosService {

    public static void exportarArchivoTxt(String contenido, String nombreArchivo) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo + ".txt");
            fw.write(contenido);
            fw.close();
        } catch (IOException e) {
            System.out.println(ConstantsLogs.LOG_ERROR_ARCHIVO);
            System.out.println(e.getMessage());
        }
    }
}
