package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.services.ImpresorArchivosService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;

public class ImpresorArchivosServiceTest {
    @Test
    public void testExportarArchivoTxt() {
        String contenido = "0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n";
        String nombreArchivo = "salida";
        ImpresorArchivosService.exportarArchivoTxt(contenido, nombreArchivo);
        File archivo = new File(nombreArchivo + ".txt");
        Assertions.assertThat(archivo.exists()).isEqualTo(true);
        archivo.delete();
    }

    @Test
    public void testExportarArchivoTxtError() {
        String contenido = "0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n";
        String nombreArchivo = "salida";
        ImpresorArchivosService.exportarArchivoTxt(contenido, nombreArchivo);
        File archivo = new File(nombreArchivo + ".txt");
        Assertions.assertThat(archivo.exists()).isEqualTo(true);
        archivo.delete();
    }
}
