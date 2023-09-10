package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.models.RequerimientoEntrada;
import ar.edu.untref.dyasc.services.AdministradorRequerimientosService;
import ar.edu.untref.dyasc.utils.EnumDirecciones;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdministradorRequerimientosServiceTest {
    private AdministradorRequerimientosService administradorRequerimientosService;

    @BeforeEach
    public void setUp() {
        this.administradorRequerimientosService = new AdministradorRequerimientosService();
    }

    @Test
    public void testRequerimientoEntrada() {
        String[] args = {"-o=hd", "-f=salida", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.HORIZONTAL_DERECHA);
        Assertions.assertThat(requerimientos.getNombreArchivo()).isEqualTo("salida");
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(true);
    }

    @Test
    public void testRequerimientoEntradaModo() {
        String[] args = {"-m=s", "-o=hd", "-f=salida", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.HORIZONTAL_DERECHA);
        Assertions.assertThat(requerimientos.getNombreArchivo()).isEqualTo("salida");
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(true);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(true);
    }

    @Test
    public void testRequerimientoEntradaOrientacion() {
        String[] args = {"-o=vi", "-f=salida", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.VERTICAL_INVERSA);
        Assertions.assertThat(requerimientos.getNombreArchivo()).isEqualTo("salida");
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(true);
    }

    @Test
    public void testRequerimientoEntradaArchivo() {
        String[] args = {"-f=salida", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.HORIZONTAL_DERECHA);
        Assertions.assertThat(requerimientos.getNombreArchivo()).isEqualTo("salida");
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(true);
    }

    @Test
    public void testRequerimientoEntradaArchivoDefault() {
        String[] args = {"10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.HORIZONTAL_DERECHA);
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(false);
    }

    @Test
    public void testRequerimientoEntradaModoDefault() {
        String[] args = {"-o=vi", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.VERTICAL_INVERSA);
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(false);
    }

    @Test
    public void testRequerimientoEntradaModoSumatoria() {
        String[] args = {"-m=s", "10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(true);
        Assertions.assertThat(requerimientos.isSalidaTextoEnabled()).isEqualTo(false);
    }

    @Test
    public void testRequerimientoEntradaModoSumatoriaDefault() {
        String[] args = {"10"};
        this.administradorRequerimientosService.getRequerimientos(args);
        RequerimientoEntrada requerimientos = this.administradorRequerimientosService.getRequerimientoEntrada();
        Assertions.assertThat(requerimientos.getDireccion()).isEqualTo(EnumDirecciones.HORIZONTAL_DERECHA);
        Assertions.assertThat(requerimientos.getNumero()).isEqualTo(10);
        Assertions.assertThat(requerimientos.isModoEnabled()).isEqualTo(false);
    }
}
